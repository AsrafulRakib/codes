package com.dynamicdriller.notificationalarmtest.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.work.*
import com.dynamicdriller.notificationalarmtest.R
import java.security.SecureRandom
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit
import kotlin.random.Random

private const val SNOOZE_REQUEST_CODE = 0
private const val CANCEL_REQUEST_CODE = 1

class NotificationWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    @RequiresApi(Build.VERSION_CODES.S)
    override fun doWork(): Result {
        val packageName = "com.dynamicdriller.notificationalarmtest.workmanager"
        val customRingtoneResId = R.raw.alarm

        val message = inputData.getString("message")
        // Create a notification channel if it doesn't exist
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("alarm_channel", "MedicineReminderApp", NotificationManager.IMPORTANCE_HIGH)
            val notificationManager = applicationContext.getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
        // Set the custom ringtone for the notification
        val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
        val customRingtoneUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + packageName + "/" + customRingtoneResId)
        // Create a notification
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        // Define notification ID counter
//        val notificationId = SecureRandom().nextInt(500)
        val notificationId = (System.currentTimeMillis()%100000).toInt()
        val channelId = "alarm_channel"
        val channelName = "MedicineReminderApp"
        val snoozeAction = createSnoozeAction(applicationContext, inputData, notificationId)
        val cancelAction = createCancelAction(applicationContext, notificationId)
        val importance = NotificationManager.IMPORTANCE_HIGH
        val notificationChannel = NotificationChannel(channelId, channelName, importance)
        notificationManager.createNotificationChannel(notificationChannel)
        if (Build.VERSION. SDK_INT >= Build.VERSION_CODES. O ){
            val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
            notificationChannel.setSound(customRingtoneUri,audioAttributes)
        }
        val notificationBuilder = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.medcine_icon)
            .setContentTitle("Notification Test")
            .setContentText(message)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setSound(customRingtoneUri)
            .addAction(snoozeAction)
            .addAction(cancelAction)
            .setAutoCancel(true)
        notificationManager.notify(notificationId, notificationBuilder.build())
        return Result.success()
    }
    // Create snooze action
    @RequiresApi(Build.VERSION_CODES.S)
    private fun createSnoozeAction(context: Context, inputData: Data, notificationId: Int): NotificationCompat.Action {
        val snoozeIntent = Intent(context, NotificationBroadcastReceiver::class.java).apply {
            action = "SNOOZE_NOTIFICATION"
            putExtra("message", inputData.getString("message"))
            putExtra("notificationId", notificationId)
        }
        val snoozePendingIntent = PendingIntent.getBroadcast(context, notificationId, snoozeIntent, PendingIntent.FLAG_MUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)
        return NotificationCompat.Action.Builder(R.drawable.snooze, "Snooze", snoozePendingIntent).build()
    }

    // Create cancel action
    @RequiresApi(Build.VERSION_CODES.S)
    private fun createCancelAction(context: Context, notificationId: Int): NotificationCompat.Action {
        val cancelIntent = Intent(context, NotificationBroadcastReceiver::class.java).apply {
            action = "CANCEL_NOTIFICATION"
            putExtra("notificationId", notificationId)
        }
        Log.d("notification1234", " createCancelActionCreate : $notificationId")
        val cancelPendingIntent = PendingIntent.getBroadcast(context, notificationId, cancelIntent,  PendingIntent.FLAG_MUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)
        return NotificationCompat.Action.Builder(R.drawable.cancel, "Cancel", cancelPendingIntent).build()
    }
}
@RequiresApi(Build.VERSION_CODES.O)
fun setNotifications(medicineName: String, time: LocalDateTime, current: Context) {
    Log.d("nitificationcheck", "addDosage:notifytime $time ")
    val currentTime = LocalDateTime.now()
    val duration = Duration.between(currentTime, time)
    val delay = duration.toMillis()

    val data = Data.Builder()
        .putString("message", medicineName)
        .build()

    val notificationWorkRequest = OneTimeWorkRequest.Builder(NotificationWorker::class.java)
        .setInitialDelay(delay, TimeUnit.MILLISECONDS)
        .setInputData(data)
        .build()

    WorkManager.getInstance(current).enqueue(notificationWorkRequest)
}
