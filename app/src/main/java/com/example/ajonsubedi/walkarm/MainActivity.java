package com.example.ajonsubedi.walkarm;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String alarmName = getIntent().getStringExtra("name");
        String alarmTime = getIntent().getStringExtra("time");
        String alarmrepeat = getIntent().getStringExtra("repeat");
        String alarmSteps = getIntent().getStringExtra("steps");
        boolean alarmSwicth = getIntent().getBooleanExtra("switch", true);


        //ADD NEW ALARM
        addNewAlarm();

        //GET INFO FROM NEW ALARM
        //SET ALARM TIME FROM SETUP
        Intent i = getIntent();
        String strAlarmTime = i.getStringExtra("alarmTime");
        TextView setAlarmTime = (TextView)findViewById(R.id.textView);
        setAlarmTime.setText(strAlarmTime);

    }


        Button btnNewAlarm;
        public void addNewAlarm(){
            btnNewAlarm = (Button)findViewById(R.id.btnNewAlarm);
            btnNewAlarm.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, setAlarm.class);
                    startActivity(intent);
                }
            });
        }







}
