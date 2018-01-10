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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by Ajon Subedi on 1/8/2018.
 */

public class setAlarm extends AppCompatActivity implements View.OnClickListener{

    private int intHour, intMinute;
    Button btnSetTime, btnCancelAlarm, btnSaveAlarm;
    TextView txtSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_new_alarm_layout);

        btnSetTime = (Button)findViewById(R.id.btnSetTime);
        btnCancelAlarm = (Button)findViewById(R.id.btnCancelAlarm);
        btnSaveAlarm = (Button)findViewById(R.id.btnSaveAlarm);
        btnSetTime.setOnClickListener(this);
        final NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        txtSteps = (TextView)findViewById(R.id.txtSteps);

        cancelAlarm();


        //SAVE
        btnSaveAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(setAlarm.this, MainActivity.class);
                //TextView alarmName = (TextView)findViewById(R.id.my_alarm_name_item);
                TextView alarmTime = (TextView)findViewById(R.id.txtSetTime);
                /*TextView alarmRepeat = (TextView)findViewById(R.id.my_alarm_repeat_item);
                TextView alarmSteps = (TextView)findViewById(R.id.my_alarm_steps_item);
                Switch switchOnOffAlarm = (Switch)findViewById(R.id.my_alarm_switchButton_item);*/
                i.putExtra("alarmTime", alarmTime.getText().toString());


                startActivity(i);
            }


        });






        numberPicker.setMinValue(20);
        numberPicker.setMaxValue(1000);


        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                txtSteps.setText("Steps : " + newVal);
            }
        });


    }

    //SET TIME
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        final TextView txtTime = (TextView)findViewById(R.id.txtSetTime);

        btnSetTime = (Button)findViewById(R.id.btnSetTime);

        if (v == btnSetTime) {

            //GET CURRENT TIME
            final Calendar c = Calendar.getInstance();
            intHour = c.get(Calendar.HOUR_OF_DAY);
            intMinute = c.get(Calendar.MINUTE);

            //OPEN TIMEPICKER
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            if(minute < 10 || hourOfDay < 10){
                                txtTime.setText("0" + hourOfDay + ":" + "0" + minute);
                            }
                            if(minute > 10 || hourOfDay > 10){txtTime.setText(hourOfDay + ":" + minute);}
                        }
                    }, intHour, intMinute, false);
            timePickerDialog.show();
        }
    }

    public void cancelAlarm(){
        btnCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(setAlarm.this, MainActivity.class);
                startActivity(i);
            }
        });
    }



    public void saveAlarm(){

    }


}

