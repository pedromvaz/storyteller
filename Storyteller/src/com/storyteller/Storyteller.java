/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller;

import com.storyteller.controller.Coordinates;
import com.storyteller.controller.Passage;
import com.storyteller.controller.Room;
import com.storyteller.controller.Structure;
import com.storyteller.controller.World;

/**
 * Storyteller is the main class of this project. It is responsible for
 * <ul>
 * <li>managing the world where the story will take place (creating, storing and loading)
 * <li>managing everything inside this world (structures, plants, creatures, etc)
 * <li>advancing the story in a linear fashion
 * </ul>
 * @author pedromvaz
 * @version 0.01
 * @see World
 * @see Structure
 * @see Plant
 * @see Creature
 */
public class Storyteller {
	
	private static World sandbox;
	
	public static void main(String[] args) {
		sandbox = World.getWorld();
		
		Coordinates location = new Coordinates(5.0, 5.0);
		Structure cave = new Structure(location);
		Room caveInterior = new Room(cave);
		Passage caveEntrance = caveInterior.addPassageToWorld();
		// TODO Create a dedicated method to add structures to the world
		sandbox.getStructures().add(cave);
	}
}
