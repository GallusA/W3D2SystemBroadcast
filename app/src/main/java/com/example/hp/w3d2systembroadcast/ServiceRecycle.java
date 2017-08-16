package com.example.hp.w3d2systembroadcast;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Created by HP on 8/16/2017.
 */

public class ServiceRecycle extends Service {
    private static final String TAG = "MyBoundService";

    IBinder iBinder = new ServiceRecycle.MyBinder();

    ArrayList<Obj> ObjectList = new ArrayList<>();

    public ServiceRecycle() {
    }

    @Override
    public void onCreate() {
        super.onCreate();


        Log.d(TAG, "onCreate: ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        SecureRandom randomS = new SecureRandom();
        for(int i=0;i<Integer.parseInt(intent.getStringExtra("value3"));i++){
            ObjectList.add(new Obj(new BigInteger(140, randomS).toString(30)));
        }
        return iBinder;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public class MyBinder extends Binder {

        public ServiceRecycle getService(){
            return ServiceRecycle.this;
        }

    }

    public ArrayList<Obj> getRecyclerViewList(){
        return ObjectList;
    }
}