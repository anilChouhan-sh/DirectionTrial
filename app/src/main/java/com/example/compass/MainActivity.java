package com.example.compass;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity  {



    private View myview ;
    TextView tvHeading ,tvLatitude , tvLongitude;
Location location ;
Direction direction ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Values.setDEGREE(0);
        setContentView(R.layout.activity_main);


        tvHeading =  findViewById(R.id.tvHeading);
        tvLatitude = findViewById(R.id.tvLatitude) ;
        tvLongitude = findViewById(R.id.tvLongitude) ;
        myview = findViewById(R.id.myview) ;

        location = new Location(this) ;
        direction = new Direction(this) ;

        direction.initialize();
        location.initialize();


    }

    void updateValues(){
        tvHeading.setText(String.valueOf(Values.DEGREE));
        tvLongitude.setText(String.valueOf(Values.Y));
        tvLatitude.setText(String.valueOf(Values.X));

        myview.postInvalidate();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // for the system's orientation sensor registered listeners
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                location.Onupdate();
                direction.registerListeners();
            }
        });
        thread.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        direction.unregisterListners();
      //  location.unregister();
        // to stop the listener and save battery

    }

}