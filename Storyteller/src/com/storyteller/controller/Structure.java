/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

import java.util.HashSet;

/**
 * This class is the parent class of all structures in the Storyteller world.
 * These structures can be natural (caves, water springs, lakes, mountains)
 * or made by any of the races living in the world (homes, bridges, walls).
 * @author pedromvaz
 * @version 0.01
 * @see World
 * @see Room
 */
public class Structure {
	
	private Coordinates location;
	private final HashSet<Room> rooms;
	
	/**
	 * Creates a new structure on a specific location in the Storyteller world.
	 * @param location The location where the structure is set on.
	 */
	public Structure(Coordinates location) {
		setLocation(location);
		rooms = new HashSet<>();
	}
	
	/**
	 * Returns the location of this structure.
	 * @return The location of the structure.
	 */
	public Coordinates getLocation() {
		return location;
	}

	/**
	 * Sets the location of the structure.
	 * @param location The new location for the structure
	 */
	private void setLocation(Coordinates location) {
		this.location = location;
	}
	
	/**
	 * Returns the list of all rooms that belong to this structure.
	 * @return A list of rooms.
	 */
	public HashSet<Room> getRooms() {
		return rooms;
	}

	/**
	 * Adds a new room to the structure.
	 * @param room A new room.
	 * @return TRUE if the room was added to the structure, FALSE otherwise.
	 */
	public boolean addRoom(Room room) {
		return rooms.add(room);
	}
}
