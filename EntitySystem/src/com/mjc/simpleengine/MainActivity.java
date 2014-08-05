package com.mjc.simpleengine;

import android.app.Activity;
import android.os.Bundle;
public class MainActivity extends Activity {

	
	//The GameScreenManager is a SurfaceView.
	//When it is created, it creates its own paint thread.
	//The paint thread is then started when the GameScreenManager
	//surface is created.  The update and draw methods for the game
	//are inside the paint thread.
	
	GameManager gsm;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		gsm = new GameManager(this);		
		setContentView(gsm);	
		}	
}
