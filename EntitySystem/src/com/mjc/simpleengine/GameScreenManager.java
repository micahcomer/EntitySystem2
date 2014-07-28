package com.mjc.simpleengine;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;


public class GameScreenManager extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener{

	//Application context
	Context context;
	
	//objects which house info about the screen
	SurfaceHolder surfaceHolder;	    

	//our Thread class which houses the game loop
	private PaintThread thread;

	//class constructor
	public GameScreenManager(Activity context) {
		super(context);
		this.context = context;
		setOnTouchListener(this);
		InitView();		
	}
	
	//initialization code
	public void InitView(){
		//initialize our screen holder
		SurfaceHolder holder = getHolder();
		holder.addCallback( this);	

		//initialize our Thread class. A call will be made to start it later
		thread = new PaintThread(holder, context, new Handler());
		setFocusable(true);      
	}

	//@Override 
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {}

	public void surfaceCreated(SurfaceHolder arg0) {
		if(thread.state==PaintThread.PAUSED){
			//When game is opened again in the Android OS
			thread = new PaintThread(getHolder(), context, new Handler());
			thread.start();
		}else{
			//creating the game Thread for the first time
			thread.start();
		}
	}

	public void surfaceDestroyed(SurfaceHolder arg0) {
		boolean retry = true;
		//code to end gameloop
		thread.state=PaintThread.PAUSED;
		while (retry) {
			try {
				//code to kill Thread
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
			}
		}

	}

	//OnTouch Interface Methods
	public boolean onTouch(View v, MotionEvent event) {
		//TODO: OnTouch Code begins here.
		return true;
	}

}





