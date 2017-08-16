package com.example.hp.w3d2systembroadcast;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by HP on 8/16/2017.
 */

public class ObjectListAdaptor extends RecyclerView.Adapter<ObjectListAdaptor.ViewHolder>{
    Context context;
    List<Obj> ObjectList = new ArrayList<>();

    public ObjectListAdaptor(List<Obj> ramdomList) {
        this.ObjectList = ObjectList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView ObjA;

        public ViewHolder(View itemView) {
            super(itemView);

            ObjA = (TextView) itemView.findViewById(R.id.textView2);

        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_list_item, parent, false);
        return new ViewHolder(view);
    }


    private int lastPosition = -1;
    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {


        Log.d(TAG, "onBindViewHolder: ");
        if(position > lastPosition){
            //Animation animation = AnimationUtils
        }

        Log.d(TAG, "onBindViewHolder: ");
        final Obj objectB = ObjectList.get(position);
        holder.ObjA.setText(""+objectB.getObjectA());

    }

    public int getItemCount() {
        return ObjectList.size();
    }


}
