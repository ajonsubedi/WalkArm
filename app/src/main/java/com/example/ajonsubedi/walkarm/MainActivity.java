package com.example.ajonsubedi.walkarm;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

//    Button btnNewAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stepcount_test_page);

//        btnNewAlarm = (Button)findViewById(R.id.btnNewAlarm);
//
//        btnNewAlarm.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//
//            }
//
//        });

        TextView isStepDetectorBeschikbaar = (TextView) findViewById(R.id.isStepDetectorBeschikbaar);
        TextView isStepCounterBeschikbaar = (TextView) findViewById(R.id.isStepCounterBeschikbaar);

        TextView huidigStap = (TextView) findViewById(R.id.huidigStap);
        TextView huidigTimeStap = (TextView) findViewById(R.id.huidigStapTime);
        TextView totaalStap = (TextView) findViewById(R.id.totaalStap);

        StepCountFunction test = new StepCountFunction(this.getApplicationContext());

        isStepCounterBeschikbaar.setText(test.isSupportStepCounter);
        isStepDetectorBeschikbaar.setText(test.isSupportStepDetector);

        test.initListener(totaalStap,huidigStap,huidigTimeStap);
        test.registerSensor();


    }
}
