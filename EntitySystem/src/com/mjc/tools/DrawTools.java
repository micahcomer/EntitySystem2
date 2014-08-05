package com.mjc.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;

public class DrawTools {

	public static Rect screen;
	private static Paint paint;
	public static Canvas canvas;
	public static Context context;
	public static Resources resources;
	
	public static Rect getScreen(){
		if (screen.equals(null)){
			WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
			Display display = wm.getDefaultDisplay();
			Point p = new Point();
			display.getSize(p);		
			screen = new Rect(0,0,p.x, p.y);	
		}
		return screen;
	}
	
	public static Paint getPaint(){
		if (paint==null){
			paint = new Paint();
		}
		return paint;
	}
	
}
