package com.example.ajonsubedi.walkarm;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    Button btnNewAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewAlarm = (Button)findViewById(R.id.btnNewAlarm);

        btnNewAlarm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }

        });


    }
}
