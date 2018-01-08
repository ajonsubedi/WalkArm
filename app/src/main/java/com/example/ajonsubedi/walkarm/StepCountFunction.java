package com.example.ajonsubedi.walkarm;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Messenger;

/**
 * Created by fenglin on 8/01/18.
 */

public class StepCountFunction {

    int aantalStappen;

    StepCountFunction(int aantalStappen)
    {
        this.aantalStappen = aantalStappen;

    }

    public static boolean isSupportStepCountSensor(Context context)
    {
        SensorManager sensorManager = (SensorManager) context.getSystemService(context.SENSOR_SERVICE);

        Sensor counterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        Sensor detectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        if (counterSensor != null || detectorSensor != null)
        {
            return true;
        }
        return false;
    }

    private boolean isBind = false;
    private Messenger mGetReplyMessenger = new Messenger(new Handler(this));
    private Messenger messenger;

    //start count service
    private void setupService(){
        Intent intent = new Intent(this,StepService.class);


    }

}
