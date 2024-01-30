package com.dynamicdriller.exoplayer2

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.TrackGroup
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.StyledPlayerControlView
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.BandwidthMeter

class MainActivity : AppCompatActivity() {
    val url3 = "https://cph-p2p-msl.akamaized.net/hls/live/2000341/test/master.m3u8"
    val shomoyNewsUrl = "https://cdn.appv.jagobd.com:444/cZMLmVyX3RpbEU9Mi8xNy8yMDE0GIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PTOmdFsaWRtaW51aiPhnPTI/somoyt000011226615544544.stream/playlist.m3u8"

    val channeliUrl = "https://cdn.appv.jagobd.com:444/cZMLmVyX3RpbEU9Mi8xNy8yMDE0GIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PTOmdFsaWRtaW51aiPhnPTI/channeli-8-org.stream/playlist.m3u8"
    val url2 = "https://cdn.appv.jagobd.com:444/cZMLmVyX3RpbEU9Mi8xNy8yMDE0GIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PTOmdFsaWRtaW51aiPhnPTI/boishakhitv-org.stream/playlist.m3u8"
    val url4 = "https://edge4.bioscopelive.com/hls/anonymous/jXIJHxTwxjH84pYlEATOmQ/1684903233/live-independent-tv.m3u8"
    lateinit var playerView :StyledPlayerView
//    val progressDialog = ProgressDialog(applicationContext)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerView = findViewById(R.id.exoplayerView)
/*        progressDialog.setMessage("Loading...")
        progressDialog.setCancelable(true)*/
        playVideo(shomoyNewsUrl)
    }

    private fun playVideo(videoUrl: String) {
        try {
            val trackSelector = DefaultTrackSelector(applicationContext)
            val simpleExoPlayer = SimpleExoPlayer.Builder(applicationContext)
                .setTrackSelector(trackSelector)
                .build()

            playerView.player = simpleExoPlayer

            val mediaItem = MediaItem.fromUri(videoUrl)
            simpleExoPlayer.setMediaItem(mediaItem)

            // Set the track selection parameters for video renderer
            val trackSelectorParameters = trackSelector.buildUponParameters()
                .setMaxVideoSize(1920, 1080) // Set the maximum video size to 1080p
                .setPreferredTextLanguage("en")
                .build()

            trackSelector.parameters = trackSelectorParameters

            simpleExoPlayer.prepare()
            simpleExoPlayer.play()
            simpleExoPlayer.playWhenReady = true

            playerView.showController()
            playerView.controllerHideOnTouch = true

            // Get the available track groups
            val mappedTrackInfo = trackSelector.currentMappedTrackInfo
            val trackGroups = mappedTrackInfo?.getTrackGroups(C.TRACK_TYPE_VIDEO)
            if (trackGroups != null && trackGroups.length > 0) {
                // Get the default track selection
                val defaultTrackSelection = DefaultTrackSelector.SelectionOverride(
                    0,
                    0
                )

                // Set the default track selection override
                trackSelector.setParameters(
                    trackSelector.buildUponParameters().setSelectionOverride(
                        C.TRACK_TYPE_VIDEO,
                        trackGroups,
                        defaultTrackSelection
                    )
                )
            }
        } catch (e: Exception) {
            // Handle any exceptions that may occur during video playback
        }
    }




    /* private fun playVideo() {
         try {
             // Create a track selector with parameters
             val parameters = DefaultTrackSelector.ParametersBuilder(applicationContext)
                 .setMaxVideoSize(1920, 1080) // Set the maximum video size to 1080p
                 .build()
             val trackSelector = DefaultTrackSelector(applicationContext)
             trackSelector.parameters = parameters
 // Create a simple exoplayer with the track selector
             val simpleExoplayer = SimpleExoPlayer.Builder(applicationContext)
                 .setTrackSelector(trackSelector)
                 .build()
             playerView.player = simpleExoplayer
             val mediaItem = MediaItem.fromUri(channeliUrl)
             simpleExoplayer.addMediaItem(mediaItem)
             playerView.showController()
 //            playerView.controllerShowTimeoutMs = 500
             playerView.controllerHideOnTouch = true
             simpleExoplayer.prepare()
             simpleExoplayer.play()
             simpleExoplayer.playWhenReady = true
         }catch (e:java.lang.Exception){

         }
     }*/

}