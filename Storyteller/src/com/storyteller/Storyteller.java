/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller;

import com.storyteller.controller.Coordinates;
import com.storyteller.controller.Plant;
import com.storyteller.controller.Room;
import com.storyteller.controller.Structure;
import com.storyteller.controller.WaterBody;
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
		
		Coordinates caveLocation = new Coordinates(5.0, 5.0);
		Structure cave = new Structure(caveLocation);
		Room caveInterior = new Room(cave);
		caveInterior.addPassageToWorld();
		// TODO Create a dedicated method to add structures to the world
		sandbox.getStructures().add(cave);
		
		Coordinates treeLocation = new Coordinates(10.0, 7.0);
		Plant tree = new Plant(treeLocation, 1000.0, 152, Plant.SIZE.HUGE);
		// TODO Create a dedicated method to add plants to the world
		sandbox.getPlants().add(tree);
		
		Coordinates springLocation = new Coordinates(3.0, 9.0);
		WaterBody spring = new WaterBody(springLocation, 0.0, 1000.0, WaterBody.SIZE.SMALL);
		// TODO Create a dedicated method to add water bodies to the world
		sandbox.getStructures().add(spring);
	}
}
