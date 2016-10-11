/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller;

import com.storyteller.controller.*;
import com.storyteller.controller.exceptions.InvalidGenderException;

/**
 * Storyteller is the main class of this project. It is responsible for
 * <ul>
 * <li>managing the world where the story will take place (creating, storing and loading)
 * <li>advancing the story in a linear fashion
 * </ul>
 * @author pedromvaz
 * @version 0.02
 * @see World
 * @see Entity
 * @see Structure
 * @see Plant
 * @see Creature
 * @see WaterBody
 */
public class Storyteller {
	
	private static World world;
	
	/**
	 * The main method that will manage the world, its entities, and make the story evolve
	 * in a linear fashion.
	 * @param args No arguments are expected as of v0.02
	 * @throws Exception Any exception that is unexpected will not be caught, and will
	 * intentionally cause the program to stop.
	 */
	public static void main(String[] args) throws Exception {
		world = new FlatWorld(new Coordinates(1000.0, 1000.0));
		
		initStructures();
		initPlants();
		initWaterBodies();
		initCreatures();
		
		while(true) {
			world.progressTimeflow();
			Thread.sleep(100);
		}
	}
	
	private static void initStructures() {
		Coordinates caveLocation = new Coordinates(5.0, 5.0);
		Structure cave = new Structure(caveLocation);
		Room caveInterior = new Room(cave);
		caveInterior.addPassageToWorld();
		world.addEntity(cave);
	}
	
	private static void initPlants() {
		Coordinates treeLocation = new Coordinates(10.0, 7.0);
		Plant tree = new Plant(treeLocation, 1000.0, 152, Plant.SIZE.HUGE);
		world.addEntity(tree);
	}
	
	private static void initWaterBodies() {
		Coordinates springLocation = new Coordinates(3.0, 9.0);
		WaterBody spring = new WaterBody(springLocation, 0.0, 1000.0, WaterBody.SIZE.SMALL);
		world.addEntity(spring);
	}
	
	private static void initCreatures() throws InvalidGenderException {
		Coordinates fatherLocation = new Coordinates(7.0, 5.0);
		Creature father = new Creature(fatherLocation, Creature.GENDER.MALE);
		world.addEntity(father);
		
		Coordinates motherLocation = new Coordinates(9.0, 7.0);
		Creature mother = new Creature(motherLocation, Creature.GENDER.FEMALE);
		world.addEntity(mother);
		
		Coordinates sonLocation = new Coordinates(10.0, 8.0);
		Creature son = new Creature(sonLocation, Creature.GENDER.MALE);
		son.setFather(father);
		son.setMother(mother);
		world.addEntity(son);
		
		Coordinates daughterLocation = new Coordinates(9.0, 8.0);
		Creature daughter = new Creature(daughterLocation, Creature.GENDER.FEMALE);
		daughter.setFather(father);
		daughter.setMother(mother);
		world.addEntity(daughter);
	}
}
