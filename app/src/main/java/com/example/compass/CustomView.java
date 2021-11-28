package com.example.compass;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public  class CustomView extends View {
    Matrix matrix;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        matrix = new Matrix() ;
        bitmapOrg = BitmapFactory.decodeResource(getResources(),
                R.drawable.direction);
    }
    Bitmap bitmapOrg ;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = bitmapOrg.getWidth();
        int newWidth = (int) Math.round(bitmapOrg.getWidth()*0.1) ;
        int newHeight = (int) Math.round(bitmapOrg.getHeight()*0.1) ;
        int height = bitmapOrg.getHeight();

        canvas.save();
        matrix.reset();
        matrix.postScale(0.1f, 0.1f) ;
        matrix.postRotate( Degree.DEGREE) ;
        Bitmap bit = Bitmap.createBitmap(bitmapOrg , 0 ,0 ,   width , height , matrix ,true) ;
        Paint paint =new Paint() ;
        canvas.drawBitmap(bit ,  getWidth()/2 - newWidth/2 ,getHeight()/2 -newHeight/2,paint);
        canvas.restore();
    }
}
