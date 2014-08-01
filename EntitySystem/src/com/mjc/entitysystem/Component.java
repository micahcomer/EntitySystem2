package com.mjc.entitysystem;

public abstract class Component {

	int ID;

	public final int getID() {
		return ID;
	}

	public final void setID(int iD) {
		ID = iD;
	}

	public abstract Component newInstance();
	
}
