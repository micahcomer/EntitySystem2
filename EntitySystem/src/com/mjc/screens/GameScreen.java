package com.mjc.screens;

import com.mjc.events.ScreenEventListener;

import android.graphics.Canvas;

//This is the main screen that will be used.  This is where the actual game play will occur.  This screen will handle entities.  Things
//above the level of this screen will be coded with OOP.

public class GameScreen extends Screen{

	//TODO: Determine fields needed.
	
	public GameScreen(ScreenEventListener manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {		
		// TODO Initialize if needed.
		
	}

	@Override
	public void hide() {
		//Called by GameManager when a game event necessitates switching away from this screen.
		//TODO Any code for hiding this screen (such as saving state).
		
	}

	@Override
	public void update(long delta) {
		//Called by GameManager.
		//TODO All SubSystems that need to update should do so here.
		
	}

	@Override
	public void draw(Canvas c) {
		// Called by GameManager
		//TODO All Subsystems that need to draw should do so here.
		
	}
	
}