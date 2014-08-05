package com.mjc.systems;

import java.util.LinkedList;

import com.mjc.components.Animation;
import com.mjc.components.Physics;
import com.mjc.components.Position;
import com.mjc.entitysystem.EntityManager;
import com.mjc.entitysystem.SubSystem;

public class PhysicsSystem extends SubSystem{

	public static void updatePositions(){
		
		Position pos;
		@SuppressWarnings("unchecked")
		LinkedList<Physics> physics = (LinkedList<Physics>) EntityManager.getAllComponentsOfType(Physics.class);
		for (Physics p:physics){
			pos = (Position) EntityManager.getComponent(Position.class, p.getID());
			pos.x+=p.speed.x;
			pos.y+=p.speed.y;
			
			Animation a = (Animation) EntityManager.getComponent(Animation.class, p.getID());
			if (!a.equals(null)){
				a.sourceRect.set(pos.x, pos.y, pos.x+a.cellSize.x, pos.y+a.cellSize.y);				
			}
		}
	}
	
}
