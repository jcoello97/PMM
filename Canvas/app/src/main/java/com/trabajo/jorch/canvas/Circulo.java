package com.trabajo.jorch.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jorch on 20/11/2016.
 */

public class Circulo extends View
{
    public Circulo(Context context) {
        super(context);
    }

    public Circulo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(25);
        canvas.drawText("ancho:"+getWidth()+" alto:"+getHeight(),20,20,paint);

    }
}
