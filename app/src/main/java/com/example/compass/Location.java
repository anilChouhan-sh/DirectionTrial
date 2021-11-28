package com.example.compass;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class Location  {

    FusedLocationProviderClient fusedLocationProviderClient;
    LocationRequest locationRequest;

    LocationCallback locationCallback ;
    MainActivity mContext ;

    Location (MainActivity context){
        mContext = context ;
    }

    void initialize(){
        locationRequest = new LocationRequest();

        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        Onupdate();
    }

    public void Onupdate(){
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(mContext) ;

        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

//            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(mContext, new OnSuccessListener<android.location.Location>() {
//                @Override
//                public void onSuccess(android.location.Location location) {
//                    //textView.setText(String.valueOf(location.getLatitude()));
//                    textView1.setText(String.valueOf( location.getLongitude()));
//                }
//            });
            locationCallback = new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    if (locationResult == null) {
                        return;
                    }
                    for (android.location.Location location : locationResult.getLocations()) {
                        // Update UI with location data
                        // ...
                        Log.d("------location-----" , location.getLatitude() + " , " + location.getLongitude()) ;
                    }
                }
            };



            fusedLocationProviderClient.requestLocationUpdates(locationRequest,
                    locationCallback,
                    Looper.getMainLooper());

        }




        else {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                mContext.requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION , Manifest.permission.ACCESS_COARSE_LOCATION} ,99);
            }
        }

    }


    public void unregister(){
        Log.d("------desssss-----" , "================") ;
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }

}