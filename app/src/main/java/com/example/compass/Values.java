package com.example.compass;

public class Values {
    static float DEGREE ;
    static double X;
    static double Y;
    Values(double x, double y, float d){
        X =x ;
        Y =y ;
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

    public static void setX(double x) {
        X = x;
    }
    public static void setY(double y) {
        Y = y;
    }
}
