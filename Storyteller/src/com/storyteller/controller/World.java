/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the World where the story will take place. It is governed by the
 * Singleton pattern, meaning we will only be dealing with one World instance at a time.
 * This world will have a link to all the structures, plants, creatures, etc that exist in it.
 * @author pedromvaz
 * @version 0.02
 * @see Structure
 * @see Plant
 * @see Creature
 */
public class World {
	
	private static World instance;
	public static final double DEFAULT_WIDTH = 10.00;
	public static final double DEFAULT_HEIGHT = 10.00;
	
	private final List<Structure> structures;
	private final List<Plant> plants;
	private final List<Creature> creatures;
	private final List<WaterBody> waterBodies;
	
	private double width;
	private double height;
	
	private World(double width, double height) {
		setWidth(width);
		setHeight(height);
		
		structures = new ArrayList<>();
		plants = new ArrayList<>();
		creatures = new ArrayList<>();
		waterBodies = new ArrayList<>();
	}
	
	/**
	 * Returns a World instance.
	 * @return The sole instance of the World where the story will take place. If none exists,
	 * it creates a new one with default dimensions; otherwise, it returns the existing instance
	 */
	public static World getWorld() {
		if (instance == null) {
			// default dimensions for world, if no dimensions are provided
			instance = new World(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		}
		
		return instance;
	}
	
	/**
	 * Creates a new World instance with the specified dimensions, unless the existing World
	 * instance already has those dimensions.
	 * @param width The width of the new World instance.
	 * @param height The height of the new World instance.
	 * @return Returns a new World instance with the specified dimensions, unless there was an
	 * existing World instance with the same dimensions, in which case this existing instance will
	 * be returned.
	 */
	public static World createNewWorld(double width, double height) {
		if (instance == null || !instance.hasDimensions(width, height)) {
			instance = new World(width, height);
		}
		
		return instance;
	}
	
	/**
	 * Verifies if the existing World instance has the specified dimensions.
	 * @param width The width we want to check against the current World instance.
	 * @param height The height we want to check against the current World instance.
	 * @return Returns true if the existing World instance has the same dimensions as the
	 * ones specified, or false otherwise.
	 */
	private boolean hasDimensions(double width, double height) {
		return instance.getWidth() == width && instance.getHeight() == height;
	}
	
	public double getWidth() {
		return width;
	}

	private void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	private void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Retrieves the list of all structures in this World instance.
	 * @return A list of Structure objects.
	 */
	public List<Structure> getStructures() {
		return structures;
	}

	/**
	 * Retrieves the list of all plants in this World instance.
	 * @return A list of Plant objects.
	 */
	public List<Plant> getPlants() {
		return plants;
	}

	/**
	 * Retrieves the list of all creatures in this World instance.
	 * @return A list of Creature objects.
	 */
	public List<Creature> getCreatures() {
		return creatures;
	}
	
	/**
	 * Retrieves the list of all water bodies in this World instance.
	 * @return A list of WaterBody objects.
	 */
	public List<WaterBody> getWaterBodies() {
		return waterBodies;
	}
}
