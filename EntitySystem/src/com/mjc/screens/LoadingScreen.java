package com.mjc.screens;

import com.mjc.events.ScreenEventListener;

import android.graphics.Canvas;



public class LoadingScreen extends Screen{

	public LoadingScreen(ScreenEventListener manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Code to load game world goes here.
		//This should be started on another thread.  When the thread completes, this should generate a game event to have
		//game manager switch screens.
		
	}

	@Override
	public void hide() {
		// TODO Any code to run when hiding this screen.
		
	}

	@Override
	public void update(long delta) {
		// TODO Code for an update (such as updating a progress bar, based on progress reported from thread started in show().
		
	}

	@Override
	public void draw(Canvas c) {
		// TODO Draw code goes here.
		
	}
	
}