package com.example.notification;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button notifyBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notifyBtn = findViewById(R.id.notify_btn);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        notifyBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                //notification code here
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification");
                        builder.setSmallIcon(R.drawable.notification_message);
                        builder.setContentTitle("My title");
                        builder .setContentText("Welcome to Hacker Zone my friend");
                        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                        builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);

// notificationId is a unique int for each notification that you must define

                managerCompat.notify(1,builder.build());

            }
        });



    }
}