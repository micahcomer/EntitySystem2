package com.mjc.tools;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class GameLoader {
	
	public static Bitmap loadBitmap(Context c, String filename){
		AssetManager am = c.getAssets();
		Bitmap b = null;
		try {
			InputStream is = am.open(filename);
			b = BitmapFactory.decodeStream(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;		
	}
}
