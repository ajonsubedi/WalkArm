package com.example.ajonsubedi.walkarm;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.Preference;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajon Subedi on 1/8/2018.
 */

public class SetAlarmActivity extends AppCompatActivity implements View.OnClickListener{

    private int intHour, intMinute;
    private Button btnSetTime,btnSaveAlarm;
    private TextView txtSteps;
    private EditText txtAlarmName;
    private Button btnMon,btnTue,btnWed,btnThu,btnFri,btnSat,btnSun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);

        btnSetTime = (Button)findViewById(R.id.btnSetTime);
        btnSaveAlarm = (Button)findViewById(R.id.btnSaveAlarm);
        btnSetTime.setOnClickListener(this);
        final NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        txtSteps = (TextView)findViewById(R.id.txtSteps);

        btnMon = (Button) findViewById(R.id.btnMon);
        btnTue = (Button) findViewById(R.id.btnThu);
        btnWed = (Button) findViewById(R.id.btnWed);
        btnThu = (Button) findViewById(R.id.btnThu);
        btnFri = (Button) findViewById(R.id.btnFri);
        btnSat = (Button) findViewById(R.id.btnSat);
        btnSun = (Button) findViewById(R.id.btnSun);

        final List<String> repeatDays = new ArrayList<String>();
        btnMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  repeatDays.add("Mon");
            }
        });
        btnTue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                repeatDays.add("Tue");
            }
        });
        btnWed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                repeatDays.add("Wed");
            }
        });
        btnThu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                repeatDays.add("Thu");
            }
        });
        btnFri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                repeatDays.add("Fri");
            }
        });
        btnSat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                repeatDays.add("Sat");
            }
        });
        btnSun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                repeatDays.add("Sun");
            }
        });


        final String alarmName = txtAlarmName.getText().toString();

        final int steps = Integer.parseInt(txtSteps.getText().toString());

        numberPicker.setMinValue(20);
        numberPicker.setMaxValue(1000);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                txtSteps.setText("Steps : " + newVal);
            }
        });

        btnSaveAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences data = getSharedPreferences("Alarm",MODE_PRIVATE);
                SharedPreferences.Editor editor = data.edit();

                int aantal = data.getAll().size();
                String resRepeatDay = new String();
                for (String repeatDay:repeatDays)
                {
                    resRepeatDay += repeatDay+";";
                }

                String result = alarmName+":"+Integer.toString(intHour)+":"+Integer.toString(intMinute)+":"+resRepeatDay+":"+Integer.toString(steps)+":"+"true";
                editor.putString(Integer.toString(aantal),result);
                editor.commit();
                Intent intent = new Intent(SetAlarmActivity.this,MainActivity.class);
                startActivity(intent);

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



}

