/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the World where the story will take place. This world is linked
 * to all the entities (structures, plants, creatures, water bodies, ...) that exist in it.
 * @author pedromvaz
 * @version 0.02
 * @see Entity
 */
public abstract class World {
	public static final int INTERVAL_OF_TIME = 1;		// 1 second
	
	private final List<Entity> entities;
	private int days, hours, minutes, seconds;
	
	public World() {
		// for now, the world starts at 9 in the morning, on day 0
		days = 0;
		hours = 9;
		minutes = 0;
		seconds = 0;
		
		entities = new ArrayList<>();
	}
	
	/**
	 * Returns the current time in the world. The value will be in the format
	 * DDDDDDDDDDhhmmss, of which:
	 * <ul>
	 * <li>DDDDDDDDDD is the number of the day the world is at, since it began
	 * <li>hh is the hour of the current day (max 24)
	 * <li>mm is the number of minutes passed since the last hour (max 60)
	 * <li>ss is the number of seconds passed since the last minute (max 60)
	 * </ul>
	 * @return A long value representing the days, hours, minutes and seconds that have passed.
	 */
	public long getCurrentTime() {
		return (long)days * 1000000 +
				hours * 10000 +
				minutes * 100 +
				seconds;
	}
	
	private void incrementTime() {
		seconds += INTERVAL_OF_TIME;
		
		if (seconds == 60) {
			minutes++;
			seconds = 0;
		}
		
		if (minutes == 60) {
			hours++;
			minutes = 0;
		}
		
		if (hours == 24) {
			days++;
			hours = 0;
		}
	}
	
	/**
	 * Checks if an Entity object exists in the World instance.
	 * @param entity The Entity object being checked to exist.
	 * @return TRUE if the Entity object exists in the World instance, FALSE otherwise.
	 */
	public boolean hasEntity(Entity entity) {
		return entities.contains(entity);
	}
	
	/**
	 * Adds a new Entity object to this world.
	 * @param entity The Entity object to be added to the world.
	 */
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	/**
	 * Removes an Entity object from this world.
	 * @param entity The Entity object to be removed from the world.
	 */
	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}
	
	/**
	 * Progresses the world by an interval of time, allowing each entity in the world to act.
	 */
	public void progressTimeflow() {
		for (Entity e : entities) {
			e.act(INTERVAL_OF_TIME);
		}
		
		incrementTime();
	}
}
