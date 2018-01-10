package com.example.ajonsubedi.walkarm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by fenglin on 10/01/18.
 */

public class AlarmAdapter extends ArrayAdapter<Alarm> {

    private  Alarm[] mAlarms;
    public AlarmAdapter(Context context, Alarm[] alarms)
    {
        super(context,-1,alarms);
        mAlarms = alarms;

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.my_alarm_item,null);

        TextView alarmName = (TextView)view.findViewById(R.id.my_alarm_name_item);
        TextView alarmTime = (TextView)view.findViewById(R.id.my_alarm_time_item);
        TextView alarmRepeat = (TextView)view.findViewById(R.id.my_alarm_repeat_item);
        Switch switchOnOffAlarm = (Switch)view.findViewById(R.id.my_alarm_switchButton_item);

        Alarm alarm = mAlarms[position];

        alarmName.setText(alarm.getAlarmname());
        alarmTime.setText(alarm.getTime());
        alarmRepeat.setText(alarm.getTime());
        switchOnOffAlarm.setChecked(alarm.getIsOn());

        return view;
    }

    }
