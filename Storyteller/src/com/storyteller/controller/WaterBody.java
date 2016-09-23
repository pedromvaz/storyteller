/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

/**
 * This class is the parent class of all water bodies in the Storyteller world.
 * These water bodies can be:
 * <ul>
 * <li>a small water spring, a pond, wetlands
 * <li>a river, a stream, a canal
 * <li>a lake, a sea, an ocean
 * </ul>
 * @author pedromvaz
 * @version 0.02
 */
public class WaterBody extends Entity {
	
	public enum SIZE { TINY, SMALL, MEDIUM, LARGE, HUGE };
	
	private double salinity;
	private double availableWater;
	private SIZE size;
	
	/**
	 * Creates a default water body with a huge amount of fresh water, of small size.
	 * @param location The location of this water body.
	 */
	public WaterBody(Coordinates location) {
		this(location, 0.0, 1000.0, SIZE.SMALL);
	}
	
	/**
	 * Creates a new water body with a specific saltness, amount of water and size.
	 * @param location The location of the water body.
	 * @param salinity The measure of all the salts dissolved in the water (values range from 0.0 to 1.0).
	 * @param availableWater The amount of water available in this body (values >= 0.0).
	 * @param size The size of this water body.
	 */
	public WaterBody(Coordinates location, double salinity, double availableWater, SIZE size) {
		super(location);
		setSalinity(salinity);
		setAvailableWater(availableWater);
		setSize(size);
	}
	
	/**
	 * Returns the salinity of the water in the body.
	 * @return A value between 0.0 (very fresh water) and 1.0 (very salty water).
	 */
	public double getSalinity() {
		return salinity;
	}
	
	/**
	 * Sets the salinity of the water in the body.
	 * @param salinity Any double value, but
	 * (1) values below 0.0 are set to 0.0, and
	 * (2) values above 1.0 are set to 1.0
	 */
	private void setSalinity(double salinity) {
		salinity = Math.min(salinity, 1.0);
		salinity = Math.max(salinity, 0.0);
		
		this.salinity = salinity;
	}
	
	/**
	 * Sets the amount of available water.
	 * @param availableWater Any double value, but
	 * (1) values below 0.0 are set to 0.0
	 */
	private void setAvailableWater(double availableWater) {
		availableWater = Math.max(availableWater, 0.0);
		
		this.availableWater = availableWater;
	}
	
	/**
	 * Determines if the water body has any water left to provide.
	 * @return TRUE if the body has water left, FALSE otherwise.
	 */
	public boolean hasAvailableWater() {
		return availableWater > 0;
	}
	
	/**
	 * Used by creatures to retrieve water from the body.
	 * @param requestedAmount The amount the creature wants to retrieve.
	 * @return The amount actually available in the water body. If the body has more water
	 * available than what the creature requires, the creature will receive what it asked for;
	 * otherwise it will only receive what the body has left to provide.
	 * @see Creature
	 */
	public double retrieveWater(double requestedAmount) {
		return Math.min(availableWater, requestedAmount);
	}
	
	/**
	 * Returns the size of the water body.
	 * @return The size of the water body.
	 */
	public SIZE getSize() {
		return size;
	}

	/**
	 * Sets the size of the water body.
	 * @param size The size of the water body.
	 */
	private void setSize(SIZE size) {
		this.size = size;
	}
}
