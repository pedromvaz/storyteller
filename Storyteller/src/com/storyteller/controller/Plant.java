/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

/**
 * This class is the parent class of all plants in the Storyteller world.
 * Examples of plants are trees, bushes, grass, flowers, algae.
 * Some plants are sources of food (trees, bushes, grass), others are merely decorative (flowers).
 * @author pedromvaz
 * @version 0.02
 * @see World
 */
public class Plant extends Entity {
	
	public enum SIZE { TINY, SMALL, MEDIUM, LARGE, HUGE };
	
	private double availableFood;
	private double age;
	private SIZE size;
	
	/**
	 * Creates a default plant with a huge amount of food, of medium size and very young age.
	 * @param location The location of this plant.
	 */
	public Plant(Coordinates location) {
		this(location, 1000.0, 1.0, SIZE.MEDIUM);
	}
	
	/**
	 * Creates a new plant with a specific food quantity, age and size.
	 * @param location The location of this plant.
	 * @param food The amount of food the plant will provide (values >= 0.0).
	 * @param age The age the plant will have.
	 * @param size The size of the plant.
	 */
	public Plant(Coordinates location, double food, double age, SIZE size) {
		super(location);
		setAvailableFood(food);
		setAge(age);
		setSize(size);
	}

	/**
	 * Sets the amount of food the plant will provide.
	 * @param availableFood Any double value, but values below 0.0 are set to 0.0
	 */
	private void setAvailableFood(double availableFood) {
		this.availableFood = Math.max(availableFood, 0.0);
	}
	
	/**
	 * Determines if the plant has any food left to provide.
	 * @return TRUE if the plant has food left, FALSE otherwise.
	 */
	public boolean hasAvailableFood() {
		return availableFood > 0;
	}
	
	/**
	 * Used by Creatures to retrieve Food from the Plant.
	 * @return Returns a piece of food, if the plant has any left, otherwise returns nothing.
	 */
	public Food provideFood() {
		if (hasAvailableFood()) {
			availableFood--;
			return new Food(this.getLocation());
		}
		
		return null;
	}
	
	/**
	 * This is the method that will make each Plant grow over time. The amount of sunlight,
	 * the season of the year, the temperature, the quality of the soil, all will determine
	 * how the plant grows.
	 * @param interval_of_time The number of seconds each interval of time takes.
	 */
	@Override
	public void act(int interval_of_time) {
		// TODO Plants don't act for the moment
	}

	/**
	 * Sets the age of the plant.
	 * @param age The age of the plant.
	 */
	private void setAge(double age) {
		this.age = age;
	}
	
	/**
	 * Returns the age of this Plant.
	 * @return The age of the plant.
	 */
	public double getAge() {
		return age;
	}

	/**
	 * Returns the size of the plant.
	 * @return The size of the plant.
	 */
	public SIZE getSize() {
		return size;
	}

	/**
	 * Sets the size of the plant.
	 * @param size The size of the plant.
	 */
	private void setSize(SIZE size) {
		this.size = size;
	}
}
