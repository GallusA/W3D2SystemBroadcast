package com.example.hp.w3d2systembroadcast;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by HP on 8/16/2017.
 */

public class Obj implements Parcelable{

    String ObjectA;

    public Obj(String objectA) {
        ObjectA = objectA;
    }

    public String getObjectA() {
        return ObjectA;
    }

    public void setObjectA(String objectA) {
        ObjectA = objectA;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
