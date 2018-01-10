package com.example.ajonsubedi.walkarm;

import android.app.AlarmManager;
import android.text.method.DateTimeKeyListener;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Ajon Subedi on 1/10/2018.
 */

public class Alarm {

    private String alarmname;
    private String mHour;
    private String mMinute;
    private String[] mDay;
    private int steps;
    private boolean isOn;
    private String time;
    private String repeatDays;
    public Alarm(String alarmName, String mHour, String mMinute,String[] mDay, int steps, boolean isOn){
        this.alarmname = alarmName;
        this.mHour = mHour;
        this.mMinute = mMinute;
        this.mDay = mDay;
        this.steps = steps;
        this.isOn = isOn;

        this.time = mHour+':'+mMinute;

        for(String day:mDay)
        {
            repeatDays+= day+" ";
        }
    }

    public String getTime(){return this.time;}

    public String getAlarmname() {
        return alarmname;
    }

    public void setAlarmname(String alarmname) {
        this.alarmname = alarmname;
    }

    public String getHour() {
        return mHour;
    }

    public void setHour(String mHour) {
        this.mHour = mHour;
    }

    public String getMinute() {
        return mMinute;
    }

    public void setMinute(String mMinute) {
        this.mMinute = mMinute;
    }

    public String[] getDay() {
        return mDay;
    }

    public void setDay(String[] mDay) {
        this.mDay = mDay;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setOn( boolean isOn){this.isOn = isOn;}
    public boolean getIsOn(){return  isOn;}

}
