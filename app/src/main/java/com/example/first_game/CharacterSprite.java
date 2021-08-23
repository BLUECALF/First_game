package com.example.first_game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class CharacterSprite {

    public Bitmap image;
    int x,y;

    //constructor
    public CharacterSprite(Bitmap bmp)
    {
       image = bmp;
       x= 100;
       y= 100;

    }

    public void update()
    {

        y++;
    }
    public void draw(Canvas canvas)
    {
        //canvas.drawBitmap(image,100,100,null);

        Rect rect = new Rect(00,800,600,850);

        Rect rect1 = new Rect(100,50,1000,600);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);

        //canvas.drawPaint(paint);
        //paint.setColor(Color.BLACK);
        canvas.drawBitmap(image,x,y,null);

        canvas.drawCircle(x,y,70,paint);
        y++;

       canvas.drawRect(rect,paint);

    }

}
