/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

import java.util.HashSet;

/**
 * A Room is a space belonging to a structure. It has a determined size and shape,
 * and can be connected to other rooms -- or the world -- via passages.
 * @author pedromvaz
 * @version 0.01
 * @see Structure
 * @see Passage
 * @see World
 */
public class Room {
	
	public enum SIZE { TINY, SMALL, MEDIUM, LARGE, HUGE };
	
	private Structure structure;
	private final HashSet<Passage> passages;
	
	public Room(Structure structure) {
		setStructure(structure);
		structure.addRoom(this);
		passages = new HashSet<>();
	}
	
	/**
	 * Returns the structure to which this Room belongs to.
	 * @return The structure that contains this room.
	 */
	public Structure getStructure() {
		return structure;
	}

	/**
	 * Sets the structure to which this Room belongs to.
	 * @param structure The structure that contains this room.
	 */
	private void setStructure(Structure structure) {
		this.structure = structure;
	}

	/**
	 * Returns the passages connected to this room.
	 * @return A list of passages.
	 */
	public HashSet<Passage> getPassages() {
		return passages;
	}

	/**
	 * Adds a passage between this room and another one, if it doesn't exist yet.
	 * The passage will not be created if the two rooms do not belong to the same structure.
	 * @param room The room to connect to via a passage.
	 * @return The passage between the two rooms, or NULL if it was not created.
	 */
	public Passage addPassageToRoom(Room room) {
		for (Passage p : getPassages()) {
			if (p.getRooms().contains(room))
				return null;
		}
		
		if (this.getStructure() != room.getStructure())
			return null;
		
		Passage p = new Passage(Passage.SIZE.MEDIUM, this, room);
		this.getPassages().add(p);
		room.getPassages().add(p);
		
		return p;
	}
	
	/**
	 * Adds a passage between this room and the world, if it doesn't exist yet.
	 * @return The passage between the room and the world, or NULL if it was not created.
	 */
	public Passage addPassageToWorld() {
		for (Passage p : getPassages()) {
			if (p.isExterior())
				return null;
		}
		
		Passage p = new Passage(Passage.SIZE.MEDIUM, this, null);
		this.getPassages().add(p);
		
		return p;
	}
}
