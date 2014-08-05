package com.mjc.components;

import android.graphics.Point;

import com.mjc.entitysystem.Component;

public class Physics extends Component{

	public Point speed;
	
	@Override
	public Component newInstance() {
		Physics p = new Physics();
		p.speed = new Point(0,0);
		return p;		
	}

}
