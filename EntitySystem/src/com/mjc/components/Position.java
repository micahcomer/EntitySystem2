package com.mjc.components;

import com.mjc.entitysystem.Component;

public class Position extends Component{

	public int x;
	public int y;
	
	public Component newInstance() {
		// TODO Auto-generated method stub		
		Position p = new Position();
		p.x=0;
		p.y=0;
		return p;
	}

}
