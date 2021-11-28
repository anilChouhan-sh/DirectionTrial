package com.example.compass;

public class Values {
    static float DEGREE ;
    static float X;
    static float Y;
    Values(float x, float y, float d){
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

    public static void setX(float x) {
        X = x;
    }
    public static void setY(float y) {
        Y = y;
    }
}
