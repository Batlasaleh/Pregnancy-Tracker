package com.example.android.map_project;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String MONTHLY_NOTIFICATION = "MonthlyNotification";
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }
    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(MONTHLY_NOTIFICATION,
                    "Monthly Notifications",NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("Showing notifications on a monthly basis");

            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }
}
