package com.example.ajonsubedi.walkarm;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    Button btnNewAlarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewAlarm = (Button)findViewById(R.id.btnNewAlarm);
        Intent getIntent = getIntent();

        LayoutInflater inflater = getLayoutInflater();


        btnNewAlarm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, setAlarm.class);

                startActivity(intent);
            }
        });


    }


}
