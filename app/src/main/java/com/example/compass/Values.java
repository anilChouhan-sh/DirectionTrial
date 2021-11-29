package com.example.compass;

public class Values {
    static float DEGREE ;
    static double Latitude;  //y
    static double Longitude;  //x
    static double X ;
    static  double Y;
    Values(double latitude, double longitude, float d){
        Latitude = latitude;
        Longitude = longitude;
        DEGREE =d ;
    }
//    public static float getDEGREE() {
//        return DEGREE;
//    }
//
//    public static float getX() {
//        return X;
//    }
//
//    public static float getY() {
//        return Y;
//    }

    public static void setDEGREE(float DEGREE) {
        Values.DEGREE = DEGREE;
    }

    public static void setLatitude(double latitude) {
        Latitude = latitude;
    }
    public static void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public static void setX(double x) {
        X = x;
    }

    public static void setY(double y) {
        Y = y;
    }
}
