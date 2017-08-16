package com.example.hp.w3d2systembroadcast;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MyDynamicReceiver myDymamicReceiver = new MyDynamicReceiver();
    IntentFilter intentFilter;
    EditText editText;
    Button sendSMS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.btnSendText);
        sendSMS = (Button) findViewById(R.id.btnSendSMS);

    }

    public void  sendBroadcasts(View view){
        switch(view.getId()) {
            case R.id.btnStaticBroadcast:
                Intent intent = new Intent();
                intent.setAction("myAction");
                sendBroadcast(intent);
                break;
            case R.id.btnStaticBroadcast2:
                Intent intent1 = new Intent();
                intent1.setAction("myAction2");
                sendBroadcast(intent1);
                break;
            case R.id.btnDymnamicBroadCast:
                Intent intent2 = new Intent();
                intent2.setAction("dosomething");
                sendBroadcast(intent2);
                break;
            case R.id.btnMediaRemoved:
                Intent intent3 = new Intent();
                intent3.setAction("Removed Media");
                sendBroadcast(intent3);
                break;
            case R.id.btnpowerConnected:
                Intent intent4 = new Intent();
                intent4.setAction("Power Connected");
                sendBroadcast(intent4);
                break;
            case R.id.btnUserUnclocked:
                Intent intent5 = new Intent();
                intent5.setAction("User Unclocked");
                sendBroadcast(intent5);
                break;

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        intentFilter = new IntentFilter();
        intentFilter.addAction("dosomething");

        registerReceiver(myDymamicReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myDymamicReceiver);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionNotification:
                scheduleNotification(getNotification("5 second delay"), 5000);
                return true;

        }
    }
*/
    private void scheduleNotification(Notification notification, int delay) {

        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }
/*
    private Notification getNotification(String content) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Scheduled Notification");
        builder.setContentText(content);
        builder.setSmallIcon(R.drawable.stop);
        return builder.build();
    }
*/
}

