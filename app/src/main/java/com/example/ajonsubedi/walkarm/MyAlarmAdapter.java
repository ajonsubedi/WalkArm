package com.example.ajonsubedi.walkarm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;


/**
 * Created by Ajon Subedi on 1/8/2018.
 */

public class MyAlarmAdapter extends ArrayAdapter<String> {

    public MyAlarmAdapter(Context context, String[] arr){super(context, -1, arr);}
    /*public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.my_alarm_item, null);

        TextView alarmName = (TextView) view.findViewById(R.id.my_alarm_name_item);
        TextView time = (TextView) view.findViewById(R.id.my_alarm_time_item);
        TextView steps = (TextView) view.findViewById(R.id.my_alarm_steps_item);
        ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.my_alarm_toggleButton_item);

        alarmName.setText(Integer.toString(Integer.parseInt(getItem(position))));
        time.setText(Integer.toString(Integer.parseInt(getItem(position))));
        steps.setText(Integer.toString(Integer.parseInt(getItem(position))));

    }*/
}


