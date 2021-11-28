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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Values.setDEGREE(0);
        setContentView(R.layout.activity_main);


        tvHeading =  findViewById(R.id.tvHeading);
        tvLatitude = findViewById(R.id.tvLatitude) ;
        tvLongitude = findViewById(R.id.tvLongitude) ;
        myview = findViewById(R.id.myview) ;

        Location location = new Location(this) ;
        Direction direction = new Direction(this) ;


    }

    void updateValues(){
        tvHeading.setText(String.valueOf(Values.DEGREE));
        tvLongitude.setText(String.valueOf(Values.X));
        tvLatitude.setText(String.valueOf(Values.Y));

        myview.postInvalidate();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // for the system's orientation sensor registered listeners

    }

    @Override
    protected void onPause() {
        super.onPause();

        // to stop the listener and save battery

    }

}