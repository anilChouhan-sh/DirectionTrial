package com.example.compass;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MainActivity extends Activity  {



    private View myview ;
    TextView tvHeading ,tvLatitude , tvLongitude;
    Button moveup ,moveDown ;
Location location ;
Direction direction ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Values.setDEGREE(0);
        Values.setY(0);
        setContentView(R.layout.activity_main);

        moveup = findViewById(R.id.moveup);
        moveDown =findViewById(R.id.moveDown) ;

        tvHeading =  findViewById(R.id.tvHeading);
        tvLatitude = findViewById(R.id.tvLatitude) ;
        tvLongitude = findViewById(R.id.tvLongitude) ;
        myview = findViewById(R.id.myview) ;

        location = new Location(this) ;
        direction = new Direction(this) ;

        direction.initialize();
        location.initialize();

            moveup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Values.setY(Values.Y + 40);
                    updateValues();
                }
            });
        moveDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Values.setY(Values.Y - 40);
                updateValues();
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 99 : if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                location.Onupdate();
            }
            else {Toast.makeText(this ,"Location Pemission Required" ,Toast.LENGTH_LONG).show();
                    finish();
            }
            break;
        }
    }
    void updateValues(){

        tvHeading.setText(String.valueOf(Values.DEGREE));
        tvLongitude.setText(String.valueOf(Values.Longitude));
        tvLatitude.setText(String.valueOf(Values.Latitude));
        myview.postInvalidate();

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("-------Resume" ,"Called");
        // for the system's orientation sensor registered listeners
//        location.Onupdate();
//        direction.registerListeners();
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
        Log.d("-------Pause" ,"Called");
        direction.unregisterListners();
        location.unregister();
        // to stop the listener and save battery

    }

}