package com.example.vharshinee.ex7;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends Activity {
    Handler hand = new Handler();
    Button clickme;
    TextView timer,heading;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = (TextView) findViewById(R.id.timer);
        clickme = (Button) findViewById(R.id.clickme);
        heading = (TextView) findViewById(R.id.heading);
        clickme.setVisibility(View.INVISIBLE);
        hand.postDelayed(run, 1000);
        clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heading.setText("hello!!!");
            }
        });
    }

    Runnable run = new Runnable()
    {
        @Override
        public void run()
        {
            updateTime();
        }
    };
    public void updateTime()
    {
        timer.setText("" + (Integer.parseInt(timer.getText().toString()) - 1));
        if (Integer.parseInt(timer.getText().toString()) == 0)
        {


                clickme.setVisibility(View.VISIBLE);
        }
        else
        {
            hand.postDelayed(run, 1000);
        }
    }
}