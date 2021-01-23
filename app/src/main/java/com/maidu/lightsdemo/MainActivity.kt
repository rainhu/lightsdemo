package com.maidu.lightsdemo

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mNotificationManager =  getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "led notification"
        val channelName = "led notification name"
        val importance =  NotificationManager.IMPORTANCE_HIGH

        val channel =  NotificationChannel(channelId, channelName, importance)
        channel.enableLights(true);
        channel.lightColor = Color.RED;
        channel.enableVibration(true)

        val isShowLights =  channel.shouldShowLights()
        Log.d("debuglight", "isShowLights = $isShowLights ")

        mNotificationManager.createNotificationChannel(channel)

        val notification =  Notification.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentText("test")
            .build()

        mNotificationManager.notify(123, notification)
    }
}



