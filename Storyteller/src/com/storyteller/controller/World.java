/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the World where the story will take place. It is governed by an adaptation
 * of the Singleton pattern, meaning we will only be dealing with one World instance at a time.
 * This world is linked to all the entities (structures, plants, creatures, water bodies, ...)
 * that exist in it.
 * @author pedromvaz
 * @version 0.02
 * @see Entity
 */
public class World {
	public static final double DEFAULT_WIDTH = 10.00;
	public static final double DEFAULT_HEIGHT = 10.00;
	public static final int INTERVAL_OF_TIME = 1;		// 1 second
	
	private static World instance;
	private final List<Entity> entities;
	
	private double width;
	private double height;
	private int days, hours, minutes, seconds;
	
	private World(double width, double height) {
		setWidth(width);
		setHeight(height);
		
		// for now, the world starts at 9 in the morning, on day 0
		days = 0;
		hours = 9;
		minutes = 0;
		seconds = 0;
		
		entities = new ArrayList<>();
	}
	
	/**
	 * Creates a new World instance with the specified dimensions.
	 * @param width The width of the new World instance.
	 * @param height The height of the new World instance.
	 */
	public static void createNewWorld(double width, double height) {
		instance = new World(width, height);
	}
	
	/**
	 * Returns the width of this world.
	 * @return The width of the world.
	 */
	public static double getWidth() {
		return instance.width;
	}

	private void setWidth(double width) {
		this.width = width;
	}

	/**
	 * Returns the height of this world.
	 * @return The height of this world.
	 */
	public static double getHeight() {
		return instance.height;
	}

	private void setHeight(double height) {
		this.height = height;
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
	public static long getCurrentTime() {
		return (long)instance.days * 1000000 +
				instance.hours * 10000 +
				instance.minutes * 100 +
				instance.seconds;
	}
	
	private static void incrementTime() {
		instance.seconds += INTERVAL_OF_TIME;
		
		if (instance.seconds == 60) {
			instance.minutes++;
			instance.seconds = 0;
		}
		
		if (instance.minutes == 60) {
			instance.hours++;
			instance.minutes = 0;
		}
		
		if (instance.hours == 24) {
			instance.days++;
			instance.hours = 0;
		}
	}
	
	/**
	 * Checks if an Entity object exists in the World instance.
	 * @param entity The Entity object being checked to exist.
	 * @return TRUE if the Entity object exists in the World instance, FALSE otherwise.
	 */
	public static boolean hasEntity(Entity entity) {
		return instance.entities.contains(entity);
	}
	
	/**
	 * Adds a new Entity object to this world.
	 * @param entity The Entity object to be added to the world.
	 */
	public static void addEntity(Entity entity) {
		instance.entities.add(entity);
	}
	
	/**
	 * Removes an Entity object from this world.
	 * @param entity The Entity object to be removed from the world.
	 */
	public static void removeEntity(Entity entity) {
		instance.entities.remove(entity);
	}
	
	/**
	 * Progresses the world by an interval of time, allowing each entity in the world to act.
	 */
	public static void progressTimeflow() {
		for (Entity e : instance.entities) {
			e.act(INTERVAL_OF_TIME);
		}
		
		incrementTime();
	}
}
