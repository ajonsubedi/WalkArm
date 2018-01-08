package com.example.ajonsubedi.walkarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNewAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_new_alarm_layout);

        btnNewAlarm = (Button)findViewById(R.id.btnNewAlarm);

       /* btnNewAlarm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });*/
    }
}
