package com.example.ajonsubedi.walkarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;



import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences data = getSharedPreferences("Alarm",MODE_PRIVATE);

        int aantalAlarm = data.getAll().size();
        List<Alarm> alarms = new ArrayList<Alarm>();

        for (int x = 0; x < aantalAlarm+1;x++)
        {
            //String alarmName, String mHour, String mMinute,List<String> mDay, int steps, boolean isOn
            String a = data.getString(Integer.toString(x),null);
            String[] strData = a.split(":");

            String alarmName = strData[0];
            String hour = strData[1];
            String min = strData[2];
            String resRepeat = strData[3];
            int steps = Integer.parseInt(strData[4]);
            boolean isOn = true;
            String[] repeatArray = resRepeat.split(";");

            alarms.add(new Alarm(alarmName,hour,min,repeatArray,steps,isOn));

        }

            ListView listAlarm = (ListView) findViewById(R.id.listOfAlarms);
        LayoutInflater inflater = getLayoutInflater();

        Alarm[] alarmsVoorAdapter = new Alarm[alarms.size()];
        int index1 = 0;
        for (Alarm alarmx : alarms)
        {
            alarmsVoorAdapter[index1] = alarmx;
            index1++;
        }

        listAlarm.setAdapter(new AlarmAdapter(this,alarmsVoorAdapter));

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
        PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0, intent,0);
       // alarmManager.setAlarmClock();

    }


        Button btnNewAlarm = (Button) findViewById(R.id.btnNewAlarm);
        public void addNewAlarm(){
            btnNewAlarm = (Button)findViewById(R.id.btnNewAlarm);
            btnNewAlarm.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SetAlarmActivity.class);
                    startActivity(intent);
                }
            });

        }







}
