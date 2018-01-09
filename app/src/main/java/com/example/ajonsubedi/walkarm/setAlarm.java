package com.example.ajonsubedi.walkarm;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by Ajon Subedi on 1/8/2018.
 */

public class setAlarm extends Activity implements View.OnClickListener{
    Button btnSetTime, btnCancelAlarm;
    TextView txtTime;
    TextView txtSteps;
    private int intHour, intMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_new_alarm_layout);

        Intent getIntent = getIntent();


        btnSetTime = (Button)findViewById(R.id.btnSetTime);
        btnCancelAlarm = (Button)findViewById(R.id.btnCancelAlarm);
        txtTime = (TextView)findViewById(R.id.txtSetTime);
        btnSetTime.setOnClickListener(this);
        final NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker);
        txtSteps = (TextView)findViewById(R.id.txtSteps);


        btnCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(setAlarm.this, MainActivity.class);
                startActivity(i);
            }
        });
        //Populate NumberPicker values from minimum and maximum value range
        //Set the minimum value of NumberPicker
        np.setMinValue(20);
        //Specify the maximum value/number of NumberPicker
        np.setMaxValue(1000);

        //Gets whether the selector wheel wraps when reaching the min/max value.

        //Set a value change listener for NumberPicker
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                txtSteps.setText("Steps : " + newVal);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {

        if (v == btnSetTime) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            intHour = c.get(Calendar.HOUR_OF_DAY);
            intMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            if(minute < 10 || hourOfDay < 10){
                                txtTime.setText("0" + hourOfDay + ":" + "0" + minute);
                            }
                            else{txtTime.setText(hourOfDay + ":" + minute);}
                        }
                    }, intHour, intMinute, false);
            timePickerDialog.show();
        }
    }


}

