package com.mjc.entitysystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class EntityManager {

	static LinkedList<Component> AllComponents;
	static int lastID=0;
	
	public EntityManager(){
		AllComponents = new LinkedList<Component>();
	}
	
	public static int createEntity(ArrayList<Class<? extends Component>> list){
		int ID = getNewID();
		for (int i=0; i<list.size(); i++){			
			AllComponents.add(getNewComponent(ID, list.get(i)));
		}
		return ID;
	}
	
	public static Component getComponent(Class<? extends Component> type, int ID){
		for (Component c:AllComponents){
			if (c.getClass().equals(type) && c.ID==ID){
				return c;
			}
		}
		return null;
	}
	
	public static <T extends Component> LinkedList<? extends Component> getAllComponentsOfType(Class<T> type){
		
		LinkedList<Component> list = new LinkedList<Component>();
		for (Component c: AllComponents){
			if (c.getClass().equals(type)){
				list.add(c);
			}
		}		
		return list;
	}

	private static <T extends Component> Component getNewComponent(int newID, Class<T> c){
		
		Component returnComp = null;
		try {
			Component newComp = c.newInstance();			
			returnComp = newComp.getClass().asSubclass(c).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		returnComp = returnComp.newInstance();
		returnComp.ID = newID;
		return returnComp;
	}
	
	private static int getNewID(){
		if (lastID<Integer.MAX_VALUE){
			lastID++;
			return lastID;
		}else{
			if (AllComponents.size()<=Integer.MAX_VALUE){
				return AllComponents.size();
			}else{
				return -1;
			}
		}
	}
	
}
