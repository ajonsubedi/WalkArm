package com.example.ajonsubedi.walkarm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Messenger;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 * Created by fenglin on 8/01/18.
 */

public class StepCountFunction {

    public String stepDetectorText;

    public String stepCounterText;
    public String stepDetectorTimeText;

    private String isSupportStepDetector;
    private String isSupportStepCounter;

    private SensorManager sensorManager; // = een systeem service, gebruik voor om bepaalde sensor te krijgen

    private Sensor stepCounter; //totaal steps sensoren
    private Sensor stepDetector; //1 step sensoren

    private SensorEventListener stepCounterListener;
    private SensorEventListener stepDetectorListener;

    private SimpleDateFormat simpleDateFormat; // gebruik om tijdstamp te bewaren

    StepCountFunction(Context context)
    {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        stepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER); // stepCounter sensoor aan stepCount toekennen;
        stepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR); //stepDetector sensoor

        // packageManager is een manager van user's gsm,
        // die bevat alle beschikbaar sensoren

        isSupportStepCounter = String.valueOf(context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_COUNTER));
        isSupportStepDetector = String.valueOf(context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_DETECTOR));

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");


    }

    private void initListener()
    {
        stepCounterListener = new SensorEventListener() {
            @Override   //Deze methode wordt geactiveerd wanneer de nauwkeurigheid van de geregistreerde sensor verandert.
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.e("Counter-SensorChanged",sensorEvent.values[0]+"---"+sensorEvent.accuracy+"---"+sensorEvent.timestamp);
                stepCounterText = ("Totaal steps" + sensorEvent.values[0]);
            }

            @Override //Deze methode wordt geactiveerd wanneer zich een nieuwe gebeurtenis voordoet op de geregistreerde sensor
            public void onAccuracyChanged(Sensor sensor,int i) {
                Log.e("Counter-Accuracy", sensor.getName()+"---"+i);
            }
        };

        stepDetectorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.e("Detector-SensorChanged",sensorEvent.values[0]+"---"+sensorEvent.accuracy+"---"+sensorEvent.timestamp);
                stepDetectorText = "huidige stap count" + sensorEvent.values[0];
                stepDetectorTimeText = "huidig staptijd" + simpleDateFormat.format(sensorEvent.timestamp/1000000);

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
                Log.e("Detector-Accuracy", sensor.getName()+"---"+i);
            }
        };

    }

    //Sensoor registeren betekent begint de sensor te gebruiken
    //unregister = stop met het gebruiken van sensoren
    private void  unregisterSensor(Context context){
        if(context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_SENSOR_STEP_COUNTER)
                &&
                context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_DETECTOR))
        {
            sensorManager.unregisterListener(stepCounterListener);
            sensorManager.unregisterListener(stepDetectorListener);
        }
    }




}
