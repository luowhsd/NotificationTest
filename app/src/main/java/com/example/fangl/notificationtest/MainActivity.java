package com.example.fangl.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private Button sendNotice;
    private NotificationManager manager;
    private Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,NotificationActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
        manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notification = new NotificationCompat.Builder(this)
                        .setContentTitle("Notification Title")
//                        .setContentText("Content Text")
                        .setStyle(new android.support.v4.app.NotificationCompat.BigTextStyle().bigText("史诗大时代史诗大时代史诗大时代史诗大时代史诗大时代史诗大时代史诗大时代史诗大时代史诗大时代史诗大时代"))
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentIntent(pi)
//                        .setSound(Uri.fromFile(new File("/system/medio/audio/ringtones/Luna.ogg")))
                        .setVibrate(new long[]{0,1000,500,1000})
                        .setAutoCancel(true)
                        .setLights(Color.YELLOW,1000,1000)
//                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.bigpicture)))
                        .setPriority(NotificationCompat.PRIORITY_MAX)  // MIN 最低 LOW 较低 HIGH 较高 MAX最高 DEFAULT 默认
                        .build();
        sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                manager.notify(1,notification);

            }
        });
    }
}
