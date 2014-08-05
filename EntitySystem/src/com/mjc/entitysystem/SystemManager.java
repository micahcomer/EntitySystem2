package com.mjc.entitysystem;
import java.util.ArrayList;

public class SystemManager {

	private static ArrayList<SubSystem> AllSystems;
	
	public static void addSystem(SubSystem s){
		AllSystems.add(s);
	}
	
	public static void removeSystem(SubSystem s){
		AllSystems.remove(s);
	}
	
	public static SubSystem getSystem(Class<? extends SubSystem> type){
		for(SubSystem s:AllSystems){
			if (s.getClass().equals(type)){
				return s;
			}
		}
		return null;
	}
	
}
