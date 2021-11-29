package com.example.compass;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
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
        Paint paint =new Paint() ;
        paint.setColor(Color.RED);

        Rect rect = new Rect();
        rect.top = getHeight()/2-250 ;
        rect.left = getWidth()/2;
        rect.bottom = getHeight()/2 +100-250;
        rect.right = getWidth()/2 + 50;
      //  canvas.drawColor(Color.BLUE );

        matrix.reset();
        matrix.postScale(0.1f, 0.1f) ;
        // matrix.postRotate( Values.DEGREE) ;
        Bitmap bit = Bitmap.createBitmap(bitmapOrg , 0 ,0 ,   width , height , matrix ,true) ;
        canvas.drawBitmap(bit,  getWidth()/2 - newWidth/2 ,getHeight()/2 -newHeight/2 ,null);
        canvas.translate(0,(float) Values.Y);
        canvas.rotate(Values.DEGREE ,getWidth()/2 ,getHeight()/2);
        canvas.drawRect(rect,paint);
    }
}
