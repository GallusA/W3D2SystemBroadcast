package com.example.hp.w3d2systembroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by HP on 8/15/2017.
 */

public class MyDynamicReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "I am Dynamic", Toast.LENGTH_SHORT).show();
    }
}
