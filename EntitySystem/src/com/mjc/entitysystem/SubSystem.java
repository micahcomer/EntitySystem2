package com.mjc.entitysystem;

public abstract class SubSystem {

	public SubSystem(){
		SystemManager.addSystem(this);
	}
	
}
