package com.example.first_game;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread{
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean running;
    public  Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder,GameView gameView)

    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }
    public void setRunning(boolean isRunning){
        running = isRunning;
    }
    @Override
    public void run()
    {
        while(running)
        {
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized(surfaceHolder)
                {
                    this.gameView.update();
                    this.gameView.draw(canvas);
                }
            } catch (Exception e){ e.printStackTrace();}


        }
        }
    }


