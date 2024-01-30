package com.dynamicdriller.exoplayertest

import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileOpen
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.common.TrackSelectionParameters
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.dynamicdriller.exoplayertest.ui.theme.ExoPlayerTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val url4 = "https://edge4.bioscopelive.com/hls/anonymous/jXIJHxTwxjH84pYlEATOmQ/1684903233/live-independent-tv.m3u8"
            ExoPlayerTestTheme {
                val url3 = "http://qthttp.apple.com.edgesuite.net/1010qwoeiuryfg/sl.m3u8"
                val url4 = "https://cph-p2p-msl.akamaized.net/hls/live/2000341/test/master.m3u8"
                val url2 = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"
                val viewModel = hiltViewModel<MainViewModel>()
                viewModel.addVideoUri(Uri.parse(url4))
                val videoItems by viewModel.videoItems.collectAsState()
                val selectVideoLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.GetContent(),
                    onResult = { uri ->
                        uri?.let(viewModel::addVideoUri)
                    }
                )
                var lifecycle by remember {
                    mutableStateOf(Lifecycle.Event.ON_CREATE)
                }
                val lifecycleOwner = LocalLifecycleOwner.current
                DisposableEffect(lifecycleOwner) {
                    val observer = LifecycleEventObserver { _, event ->
                        lifecycle = event
                    }
                    lifecycleOwner.lifecycle.addObserver(observer)
                    onDispose {
                        lifecycleOwner.lifecycle.removeObserver(observer)
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    viewModel.playVideo(Uri.parse(url4))
                    AndroidView(
                        factory = { context ->
                            PlayerView(context).also {
                                it.controllerHideOnTouch = true
                                it.player?.playWhenReady = true
                                it.player = viewModel.player
                                it.useController = true
                                it.controllerShowTimeoutMs = 1000
                            }
                        },
                        update = {
                            it.player?.playWhenReady = true
                            it.setFullscreenButtonClickListener {booleanValue->
                                if (booleanValue){
                                   this@MainActivity.requestedOrientation = SCREEN_ORIENTATION_USER_LANDSCAPE
                                }else{
                                    this@MainActivity.requestedOrientation = SCREEN_ORIENTATION_PORTRAIT
                                }
                            }
                            when (lifecycle) {
                                Lifecycle.Event.ON_PAUSE -> {
                                    it.onPause()
                                    it.player?.pause()
                                }
                                Lifecycle.Event.ON_RESUME -> {
                                    it.onResume()
                                }
                                else -> Unit
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16 / 9f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    IconButton(onClick = {
                        selectVideoLauncher.launch("video/mp4")
                    }) {
                        Icon(
                            imageVector = Icons.Default.FileOpen,
                            contentDescription = "Select video"
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(videoItems) { item ->
                            Text(
                                text = item.name,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        viewModel.playVideo(Uri.parse(url4))
                                    }
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }

//            MainScreen()
        }
    }
}
@Composable
fun MainScreen(){
    val context = LocalContext.current
    val url4 = "https://cph-p2p-msl.akamaized.net/hls/live/2000341/test/master.m3u8"
    val url3 = "http://qthttp.apple.com.edgesuite.net/1010qwoeiuryfg/sl.m3u8"

    val liveurl = "https://www.cbsnews.com/live/"
    val url2 = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"
    val url = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    val exoPlayer = ExoPlayer.Builder(context).build()
    exoPlayer.setMediaItem(MediaItem.fromUri(url3))
    val playerView = PlayerView(context)
    playerView.player = exoPlayer
    playerView.showController()
    DisposableEffect(AndroidView(factory = {playerView}, update = {
        it.setFullscreenButtonClickListener { booleanValue->
            if (booleanValue){
                MainActivity().requestedOrientation = SCREEN_ORIENTATION_USER_LANDSCAPE
            }else{
                MainActivity().requestedOrientation = SCREEN_ORIENTATION_PORTRAIT
            }
        }
    })){
        exoPlayer.prepare()
        exoPlayer.trackSelector
        playerView.showController()
        playerView.controllerHideOnTouch = true
        exoPlayer.trackSelectionParameters = TrackSelectionParameters.getDefaults(context)
        exoPlayer.trackSelectionParameters.maxVideoBitrate
        exoPlayer.playWhenReady = true
        onDispose {
            exoPlayer.release()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExoPlayerTestTheme {
        Greeting("Android")
    }
}