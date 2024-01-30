package com.prateek.exoplayerdemo

import android.net.Uri
import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.BehindLiveWindowException
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.trackselection.TrackSelectionOverrides
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), Player.Listener {
    private var qualityPopUp: PopupMenu?=null
    private var player: ExoPlayer? = null
    private var playbackPosition = 0L
    private var playWhenReady = true
    private var trackSelector:DefaultTrackSelector?=null
    var qualityList = ArrayList<Pair<String, TrackSelectionOverrides.Builder>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
        /*initPlayer()
        player?.addListener(object : Player.EventListener {
            fun onTimelineChanged(timeline: Timeline?, manifest: Any?) {}
            override fun onTracksChanged(
                trackGroups: TrackGroupArray,
                trackSelections: TrackSelectionArray
            ) {
            }

            override fun onLoadingChanged(isLoading: Boolean) {}
            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {}
            fun onPlayerError(error: ExoPlaybackException?) {
//                Log.e(PLAYER_ACTIVITY_TAG, "SOME ERROR IN PLAYER")
                if (isBehindLiveWindow(error!!)) {
                    initPlayer()
                }
            }

            fun onPositionDiscontinuity() {}
            override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters) {}
        })*/
    }
    /*private fun isBehindLiveWindow(e: ExoPlaybackException): Boolean {
        if (e.type != ExoPlaybackException.TYPE_SOURCE) {
            return false
        }
        var cause: Throwable? = e.sourceException
        while (cause != null) {
            if (cause is BehindLiveWindowException) {
                return true
            }
            cause = cause.cause
        }
        return false
    }*/
    private fun initListener() {
        exo_quality.setOnClickListener {
            qualityPopUp?.show()
        }
    }


    private fun initPlayer() {
        trackSelector = DefaultTrackSelector(/* context= */this, AdaptiveTrackSelection.Factory())
        player = ExoPlayer.Builder(this)
            .setTrackSelector(trackSelector!!)
            .build()
        player?.playWhenReady = true
        player_exo.controllerHideOnTouch = true
        player_exo.controllerShowTimeoutMs = 1500
        player_exo.player = player
        val shomoyNewsUrl = "https://cdn.appv.jagobd.com:444/cZMLmVyX3RpbEU9Mi8xNy8yMDE0GIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PTOmdFsaWRtaW51aiPhnPTI/somoyt000011226615544544.stream/playlist.m3u8"
        val channeliUrl = "https://cdn.appv.jagobd.com:444/cZMLmVyX3RpbEU9Mi8xNy8yMDE0GIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PTOmdFsaWRtaW51aiPhnPTI/channeli-8-org.stream/playlist.m3u8"
        val url4 = "https://cph-p2p-msl.akamaized.net/hls/live/2000341/test/master.m3u8"
        val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
        val mediaItem = MediaItem.fromUri(Uri.parse(shomoyNewsUrl))
        val mediaSource = HlsMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(mediaItem)
        player?.setMediaSource(mediaSource)
        player?.seekTo(playbackPosition)
        player?.playWhenReady = playWhenReady
        player?.addListener(this)
        player?.prepare()
    }

    private fun setUpQualityList() {
        qualityPopUp = PopupMenu(this, exo_quality)
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
        if (playbackState==Player.STATE_READY){
             trackSelector?.generateQualityList()?.let {
                 qualityList = it
                 setUpQualityList()
             }
        }
    }

    private fun releasePlayer() {
        player?.let {
            playbackPosition = it.currentPosition
            playWhenReady = it.playWhenReady
            it.release()
            player = null
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

    override fun onPlayerError(error: PlaybackException) {
        /*if (error.message?.contains("BehindLiveWindowException") == true){
            initPlayer()
        }*/
        if (error.errorCode == PlaybackException.ERROR_CODE_BEHIND_LIVE_WINDOW){
            initPlayer()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        releasePlayer()
    }
}