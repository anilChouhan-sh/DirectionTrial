package com.example.compass;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import static android.content.Context.SENSOR_SERVICE;

public class Direction implements SensorEventListener {
    private SensorManager mSensorManager;
    private float accelerometerReading[] =new float[3];
    private float magnetometerReading[] =new float[3];


    private MainActivity mContext ;

    Direction(MainActivity activity){
        mContext =activity ;
    }

    public void initialize(){
        mSensorManager = (SensorManager) mContext.getSystemService(SENSOR_SERVICE);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

// Rotation matrix based on current readings from accelerometer and magnetometer.



        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            accelerometerReading =event.values ;
        }
        if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            magnetometerReading =event.values ;
        }


// Express the updated rotation matrix as three orientation angles.
        final float[] rotationMatrix = new float[9];
        SensorManager.getRotationMatrix(rotationMatrix, null,
                accelerometerReading, magnetometerReading);
        final float[] orientationAngles = new float[3];
        SensorManager.getOrientation(rotationMatrix, orientationAngles);


        // get the angle around the z-axis rotated
        float degree = (float) ((Math.toDegrees(orientationAngles[0]) + 360)% 360);
        degree = Math.round(degree);

        Values.setDEGREE(degree);




    }

    public void registerListeners(){
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME);
    }

    public void unregisterListners(){
        mSensorManager.unregisterListener(this);
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
