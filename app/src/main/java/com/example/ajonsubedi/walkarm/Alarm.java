package com.example.ajonsubedi.walkarm;

import android.text.method.DateTimeKeyListener;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ajon Subedi on 1/10/2018.
 */

public class Alarm {
    private String alarmname;
    private int mHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    private int mMinute = Calendar.getInstance().get(Calendar.MINUTE);
    private int mDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    private String steps;
    private boolean isOn;

    public Alarm(String alarmName, int mHour, int mMinute,int mDay, String steps, boolean isOn){
        this.alarmname = alarmName;
        this.mHour = mHour;
        this.mMinute = mMinute;
        this.mDay = mDay;
        this.steps = steps;
        this.isOn = isOn;
    }

    public String getAlarmname() {
        return alarmname;
    }

    public void setAlarmname(String alarmname) {
        this.alarmname = alarmname;
    }

    public int getHour() {
        return mHour;
    }

    public void setHour(int mHour) {
        this.mHour = mHour;
    }

    public int getMinute() {
        return mMinute;
    }

    public void setMinute(int mMinute) {
        this.mMinute = mMinute;
    }

    public int getDay() {
        return mDay;
    }

    public void setDay(int mDay) {
        this.mDay = mDay;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    //FUNCTIES
    public void ringAlarm(){

    }

    public void getNotification(){

    }

    public void turnOffAlarm(){

    }

    public void snoozeAlarm(){

    }
}
