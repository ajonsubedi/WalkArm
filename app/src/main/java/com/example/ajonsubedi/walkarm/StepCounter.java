package com.example.ajonsubedi.walkarm;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by fenglin on 10/01/18.
 */

/*
!!! Stap 1:Moet eerst functie InitLinstener gebruiken
    Stap 2: RegisterListener()
    Stap 3: Reset(_
 */

public class StepCounter {

    private int doelStappen;
    private int huidigStappen;

    private boolean heeftBereikt;
    private SensorManager sensorManager; // = een systeem service, gebruik voor om bepaalde sensor te krijgen
    private Sensor stepDetector; //deze sensor geeft 1 of 0 terug
    private SensorEventListener stepDetectorListener;

    // In mainActivity context = this.getApplicationContext()
    StepCounter(int doelStappen, Context context) {

        this.huidigStappen = 0;
        this.doelStappen = doelStappen;
        heeftBereikt = false;

        this.sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        stepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

    }

        public void InitListener(final TextView txtViewHuidigStappen)
        {
            stepDetectorListener = new SensorEventListener() {

                @Override   //Deze methode wordt geactiveerd als de gebruiker stapt
                public void onSensorChanged(SensorEvent sensorEvent) {

                    huidigStappen++;    // Bij elke stap +1
                    txtViewHuidigStappen.setText(Integer.toString(huidigStappen));
                    HeeftDoelbreikt();

                }
                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            };
        }

    //Controleer of de doel heeft bereikt
    private void HeeftDoelbreikt ()
    {

        if (huidigStappen == doelStappen)
        {
            heeftBereikt = true;
            sensorManager.unregisterListener(stepDetectorListener);
        }
    }

    //na voltooid van een wekker reset;
    public void Reset()
    {
        huidigStappen = 0;
        heeftBereikt = false;
    }

    public void RegisterListener()
    {
        sensorManager.registerListener(stepDetectorListener,stepDetector,sensorManager.SENSOR_DELAY_NORMAL);
    }

    public int GetHuidigStappen() {
        return this.huidigStappen;
    }

    public boolean GetHeeftBereikt()
    {
        return heeftBereikt;
    }



}
