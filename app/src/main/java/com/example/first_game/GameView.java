package com.example.first_game;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private CharacterSprite charactersprite;




    // constructor 4 gameview
    public GameView(Context context)
    {
        super(context);
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(),this);
        setFocusable(true);

    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        charactersprite = new CharacterSprite(BitmapFactory.decodeResource(getResources(), R.drawable.player));

        thread.setRunning(true);
        thread.start();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

        boolean retry = true ;
        while(retry)
        {
            try{thread.setRunning(false);
            thread.join();

            } catch(InterruptedException e){
                e.printStackTrace();
            }
            retry = false;
        }

    }
    public void update()
    { charactersprite.update();}
    public void draw(Canvas canvas){
        super.draw(canvas);
        if(canvas != null)
        { charactersprite.draw(canvas);
        getHolder().unlockCanvasAndPost(canvas);
        }

    }
}
