package com.dynamicdriller.bdtv

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import com.dynamicdriller.bdtv.databinding.FragmentTvViewBinding
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.LoadControl
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.TracksInfo
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelectionOverrides
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Util


class TvViewFragment : Fragment(), Player.Listener  {
    private lateinit var binding: FragmentTvViewBinding
    private var qualityPopUp: PopupMenu?=null
    private var player: ExoPlayer? = null
    private var playbackPosition = 0L
    private var playWhenReady = true
    private var trackSelector: DefaultTrackSelector?=null
    private var qualityList = ArrayList<Pair<String, TrackSelectionOverrides.Builder>>()
    private val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory().setConnectTimeoutMs(10000)
    private lateinit var urlOfTV :String
    private lateinit var mediaItem:MediaItem
    private lateinit var mediaSource:MediaSource
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvViewBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        urlOfTV = arguments?.getString("url").toString()
        mediaItem = MediaItem.fromUri(Uri.parse(urlOfTV))
        mediaSource = HlsMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(mediaItem)
        initListener()
    }

    private fun initListener() {
        binding.exoQuality.setOnClickListener {
            qualityPopUp?.show()
        }
    }
    private fun initPlayer() {
        trackSelector = DefaultTrackSelector(requireContext(), AdaptiveTrackSelection.Factory())
        val loadControl: LoadControl = DefaultLoadControl.Builder()
            .setBufferDurationsMs(
                60000,
                120000,
                5000,
                2500
            )
            .setTargetBufferBytes(C.LENGTH_UNSET)
            .setPrioritizeTimeOverSizeThresholds(true)
            .setBackBuffer(
                30000,
                true
            )
            .build()

        player = ExoPlayer.Builder(requireContext())
            .setLoadControl(loadControl)
            .setTrackSelector(trackSelector!!)
            .build()

        player?.playWhenReady = true
        binding.playerExo.controllerHideOnTouch = true
        binding.playerExo.controllerShowTimeoutMs = 1500
        binding.playerExo.player = player
        player?.setMediaSource(mediaSource)
        player?.seekTo(playbackPosition)
        player?.playWhenReady = playWhenReady
        player?.addListener(this)
        player?.prepare()
    }
    private fun releasePlayer() {
        player?.let {
            playbackPosition = it.currentPosition
            playWhenReady = it.playWhenReady
            it.release()
            player = null
        }
    }
    private fun setUpQualityList() {
        qualityPopUp = PopupMenu(requireContext(), binding.exoQuality)
        qualityList.let {
            for ((i, videoQuality) in it.withIndex()) {
                qualityPopUp?.menu?.add(0, i, 0, videoQuality.first)
            }
        }
        qualityPopUp?.setOnMenuItemClickListener { menuItem ->
            qualityList[menuItem.itemId].let {
                trackSelector!!.parameters = trackSelector!!.parameters
                    .buildUpon()
                    .setTrackSelectionOverrides(it.second.build())
                    .setTunnelingEnabled(true)
                    .build()
            }
            true
        }
    }

    override fun onTracksInfoChanged(tracksInfo: TracksInfo) {
        println("TRACK CHANGED")
        println(tracksInfo.trackGroupInfos)
    }

    override fun onPlaybackStateChanged(playbackState: Int) {
        if (playbackState== Player.STATE_READY){
            trackSelector?.generateQualityList()?.let {
                qualityList = it
                setUpQualityList()
            }
        }
    }
    override fun onPlayerError(error: PlaybackException) {
        if (error.errorCode == PlaybackException.ERROR_CODE_BEHIND_LIVE_WINDOW){
            initPlayer()
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initPlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT < 24) {
            initPlayer()
        }
    }
    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }
}