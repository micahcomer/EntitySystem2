package com.mjc.systems;

import java.util.LinkedList;

import android.graphics.Canvas;

import com.mjc.components.Animation;
import com.mjc.components.Position;
import com.mjc.entitysystem.Component;
import com.mjc.entitysystem.EntityManager;
import com.mjc.entitysystem.SubSystem;
import com.mjc.tools.DrawTools;


public class RenderSystem extends SubSystem{

	public RenderSystem(){
		super();
	}
	
	public static void DrawAllEntities(Canvas c){
		
		LinkedList<? extends Component> anims = EntityManager.getAllComponentsOfType(Animation.class);
		for (Component a:anims){
			int ID = a.getID();			
			Animation animation = (Animation)a;
			Position pos = (Position)EntityManager.getComponent(Position.class, ID);
			animation.onScreenSize.offsetTo(pos.x, pos.y);
			c.drawBitmap(animation.spriteStrip, animation.sourceRect, animation.onScreenSize, DrawTools.getPaint());
		}
	}
	
}

