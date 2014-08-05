package com.mjc.components;

import com.mjc.entitysystem.Component;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;

public class Animation extends Component{

	public Bitmap spriteStrip;
	public Point totalCells;
	public Point cellSize;
	public Point currentCell;
	public Rect sourceRect;
	public Rect onScreenSize;
	public int frameRate;
	public long lastFrameTime;
	public boolean running;
	public boolean repeats;
	
	public Animation newInstance(){
		Animation a = new Animation();
		a.totalCells = new Point(0,0);
		a.cellSize = new Point(0,0);
		a.currentCell = new Point(0,0);
		a.sourceRect = new Rect(0,0,0,0);
		a.onScreenSize = new Rect(0,0,0,0);
		a.frameRate = 30; //default of 30 fps
		a.running = true;
		a.repeats = true;
		
		return a;
	}
	
}
