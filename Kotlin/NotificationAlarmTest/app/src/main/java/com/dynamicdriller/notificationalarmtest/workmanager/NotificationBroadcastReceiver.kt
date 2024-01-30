package com.dynamicdriller.notificationalarmtest.workmanager

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.material.*
import androidx.compose.runtime.*
import java.time.LocalDateTime

class NotificationBroadcastReceiver : BroadcastReceiver() {
    private val notificationList = mutableListOf<Int>()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationId = intent.getIntExtra("notificationId", 0)
        notificationList.add(notificationId)
        if (notificationList.contains(notificationId)){
            when (intent.action) {
                "CANCEL_NOTIFICATION" -> {
                    notificationManager.cancel(notificationId)
                    notificationList.remove(notificationId)
                    Log.d("notification1234", "CancelReceive: $notificationId")
                }
                "SNOOZE_NOTIFICATION" -> {
                    notificationManager.cancel(notificationId)
                    setNotifications(intent.getStringExtra("message").toString(), LocalDateTime.now().plusSeconds(10), context)
                }
            }
        }
    }
}

/*// A helper function to play a sound effect from a raw resource id
fun playSound(@RawRes soundId: Int) {
    val context = LocalContext.current
    val mediaPlayer = MediaPlayer.create(context, soundId)
    mediaPlayer.start()
}*/
