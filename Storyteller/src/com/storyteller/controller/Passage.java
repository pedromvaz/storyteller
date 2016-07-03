/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

import java.util.HashSet;

/**
 * A Passage is a way for a creature to enter or leave a structure,
 * or move from room to room inside that structure.
 * These passages can be natural (cave entrances) or made by any of the races
 * living in the world (doors, gates, trapdoors, portals, wall breach).
 * @author pedromvaz
 * @version 0.01
 * @see World
 * @see Room
 */
public class Passage {
	
	public enum SIZE { TINY, SMALL, MEDIUM, LARGE, HUGE };
	
	private SIZE size;
	private HashSet<Room> rooms;
	
	/**
	 * Creates a passage of a specific size between either
	 * - the world and a structure
	 * - two rooms of the same structure.
	 * @param size The size of the passage.
	 * @param one The first room connected to this passage.
	 * @param two The second room connected to this passage, or NULL if it's an exterior passage.
	 */
	public Passage(SIZE size, Room one, Room two) {
		setSize(size);
		setRooms(one, two);
	}
	
	/**
	 * Gets the size of this passage.
	 * @return The size of the passage.
	 */
	public SIZE getSize() {
		return size;
	}

	/**
	 * Sets the new size for this passage.
	 * @param size The size of the passage.
	 */
	public final void setSize(SIZE size) {
		this.size = size;
	}
	
	/**
	 * Returns the list of rooms that this passage connects.
	 * - If it returns two rooms, it means this is an interior passage.
	 * - If it returns only one room, it means this room is connected
	 * to the world by this passage.
	 * @return A list of rooms.
	 */
	public HashSet<Room> getRooms() {
		return rooms;
	}

	/**
	 * Sets the list of rooms connected to this passage.
	 * - If the two rooms are set, it means this is an interior passage.
	 * - If only one room is set, it means this room is connected to the world
	 * by this passage.
	 * @param one The first room.
	 * @param two The second room.
	 */
	private void setRooms(Room one, Room two) {
		rooms = new HashSet<>();
		
		if (one != null) rooms.add(one);
		if (two != null) rooms.add(two);
	}
	
	/**
	 * Indicates if this is an exterior passage or an interior passage.
	 * @return TRUE if it's an exterior passage, FALSE if it's interior.
	 */
	public boolean isExterior() {
		return getRooms().size() == 1;
	}
}
