/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

/**
 * This class is the parent class of all entities.
 * All things in Storyteller that exist in the world are entities: creatures, plants,
 * structures, and so on.
 * This allows us to have a single point where we deal with:
 * <ul>
 * <li>coordinates, i.e. where every entity is in the world
 * <li>dimensions, the volume every entity takes in the world
 * <li>collisions, by using dimensions to see if two entities are trying to exist in the same space
 * </ul>
 * @author pedromvaz
 * @version 0.02
 * @see World
 */
public class Entity {
	
	private Coordinates location;
	
	public Entity(Coordinates location) {
		setLocation(location);
	}
	
	/**
	 * Retrieves the location of the entity.
	 * @return The location of the entity.
	 */
	public Coordinates getLocation() {
		return location;
	}

	/**
	 * Sets the location for the entity.
	 * @param location The location for the entity.
	 */
	public void setLocation(Coordinates location) {
		this.location = location;
	}
}
