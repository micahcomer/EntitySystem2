package com.mjc.screens;

import com.mjc.events.ScreenEventListener;

import android.graphics.Canvas;

public abstract class Screen {
	
	ScreenEventListener manager;
	
	public Screen(ScreenEventListener manager){
		this.manager = manager;
	}
	
	//this is called by the manager, in order to initiate the screen after construction
	public abstract void show();
	
	//this is called by the screen itself, just prior to firing a screen event to have the manager switch away from it.
	public abstract void hide();
	
	public abstract void update(long delta);
	
	public abstract void draw(Canvas c);
	
}
