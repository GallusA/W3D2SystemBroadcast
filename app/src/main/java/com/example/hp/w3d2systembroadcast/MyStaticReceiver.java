package com.example.hp.w3d2systembroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by HP on 8/15/2017.
 */

public class MyStaticReceiver extends BroadcastReceiver {
    private  static final String TAG ="MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()){
            case "myAction":
                Log.d(TAG, "onReceive: " + "myAction");
                break;
            case "myAction2":
                Log.d(TAG, "onReceive: " + "myAction2");
                break;
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Log.d(TAG, "onReceive: " + "AIR PLANE MODE" );
                break;
            case Intent.ACTION_MEDIA_REMOVED:
                Log.d(TAG, "onReceive: " + "MEDIA REMOVE");
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Log.d(TAG, "onReceive: " + "POWER CONNECTED");
                break;
            case Intent.ACTION_USER_UNLOCKED:
                Log.d(TAG, "onReceive: " + "USER UNCLOCKED");
                break;
        }

        Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
    }
}
