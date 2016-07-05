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
 * @version 0.01
 * @see World
 */
public class Plant {
	
	public enum SIZE { TINY, SMALL, MEDIUM, LARGE, HUGE };
	
	private Coordinates location;
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
	 * @param food The amount of food the plant will provide
	 * @param age The age the plant will have
	 * @param size The size of the plant
	 */
	public Plant(Coordinates location, double food, double age, SIZE size) {
		setLocation(location);
		setAvailableFood(food);
		setAge(age);
		setSize(size);
	}

	/**
	 * Retrieves the location of the plant.
	 * @return The location of the plant.
	 */
	public Coordinates getLocation() {
		return location;
	}

	/**
	 * Sets the location for the plant.
	 * @param location The location for the plant.
	 */
	private void setLocation(Coordinates location) {
		this.location = location;
	}
	
	/**
	 * Sets the amount of food the plant will provide.
	 * @param availableFood The new amount of food in the plant.
	 */
	private void setAvailableFood(double availableFood) {
		this.availableFood = availableFood;
	}
	
	/**
	 * Determines if the plant has any food left or not to provide.
	 * @return TRUE if the plant has food left, FALSE otherwise.
	 */
	public boolean hasAvailableFood() {
		return availableFood > 0;
	}
	
	/**
	 * Used by creatures to retrieve food from the plant.
	 * @param requestedAmount The amount the creature wants to retrieve.
	 * @return The amount actually available in the plant. If the plant has more food available
	 * than what the creature requires, the creature will receive what it asked for; otherwise
	 * it will only receive what the plant has left to provide.
	 * @see Creature
	 */
	public double retrieveFood(double requestedAmount) {
		return Math.min(availableFood, requestedAmount);
	}

	/**
	 * Sets the age of the plant.
	 * @param age The age of the plant.
	 */
	private void setAge(double age) {
		this.age = age;
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
