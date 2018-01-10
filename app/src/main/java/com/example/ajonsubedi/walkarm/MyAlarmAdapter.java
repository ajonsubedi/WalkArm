package com.example.ajonsubedi.walkarm;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Ajon Subedi on 1/10/2018.
 */

public class MyAlarmAdapter extends ArrayAdapter<String> {
    public MyAlarmAdapter(Context context, String[] alarmInfos) {super(context,R.layout.my_alarm_item, alarmInfos);}
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.my_alarm_item, null);

        //Get all content from my_alarm_item.xml
        String listItem = getItem(position);
        TextView alarmName = (TextView)view.findViewById(R.id.my_alarm_name_item);
        TextView alarmTime = (TextView)view.findViewById(R.id.my_alarm_time_item);
        TextView alarmRepeat = (TextView)view.findViewById(R.id.my_alarm_repeat_item);
        TextView alarmSteps = (TextView)view.findViewById(R.id.my_alarm_steps_item);
        Switch switchOnOffAlarm = (Switch)view.findViewById(R.id.my_alarm_switchButton_item);

        alarmName.setText(listItem);
        alarmTime.setText(listItem);
        alarmRepeat.setText(listItem);
        alarmSteps.setText(listItem);
        switchOnOffAlarm.setChecked(isEnabled(position));

        return view;
    }
}


