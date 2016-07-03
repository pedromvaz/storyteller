/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains every Unit Test applicable to the World class.
 * @author pedromvaz
 * @version 0.01
 * @see World
 */
public class WorldTest {
	
	public WorldTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Starting tests on " + World.class.getName() + " class");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Finished tests on " + World.class.getName() + " class");
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testGetWorld() {
		System.out.println("Testing getWorld method...");
		
		assertNotNull(World.getWorld());
	}
	
	@Test
	public void testSingleton() {
		System.out.println("Testing Singleton pattern...");
		
		World instance1 = World.getWorld();
		World instance2 = World.getWorld();
		assertSame(instance1, instance2);
	}
	
	@Test
	public void testCreateNewWorld() {
		System.out.println("Testing createNewWorld method...");
		
		World instance1 = World.getWorld();
		World instance2 = World.createNewWorld(World.DEFAULT_WIDTH, World.DEFAULT_HEIGHT);
		assertSame(instance1, instance2);
		
		instance1 = World.getWorld();
		instance2 = World.createNewWorld(World.DEFAULT_WIDTH + 10, World.DEFAULT_HEIGHT + 10);
		assertNotSame(instance1, instance2);
		
		instance1 = World.createNewWorld(1000, 500);
		instance2 = World.createNewWorld(1000, 500);
		assertSame(instance1, instance2);
		
		instance1 = World.createNewWorld(1000, 500);
		instance2 = World.createNewWorld(1234, 500);
		assertNotSame(instance1, instance2);
		
		instance1 = World.createNewWorld(1000, 500);
		instance2 = World.createNewWorld(1000, 567);
		assertNotSame(instance1, instance2);
		
		instance1 = World.createNewWorld(1000, 500);
		instance2 = World.createNewWorld(1234, 567);
		assertNotSame(instance1, instance2);
	}
	
	@Test
	public void testGetStructures() {
		System.out.println("Testing getStructures method...");
		
		World instance = World.getWorld();
		assertTrue(instance.getStructures().isEmpty());
		
		instance = World.createNewWorld(20, 20);
		assertTrue(instance.getStructures().isEmpty());
		
		Coordinates location = new Coordinates(5.0, 5.0);
		Structure cave = new Structure(location);
		// TODO Create a dedicated method to add structures to the world
		instance.getStructures().add(cave);
		assertEquals(instance.getStructures().size(), 1);
	}
	
	@Test
	public void testGetPlants() {
		System.out.println("Testing getPlants method...");
		
		World instance = World.getWorld();
		assertTrue(instance.getPlants().isEmpty());
		
		instance = World.createNewWorld(20, 20);
		assertTrue(instance.getPlants().isEmpty());
	}
	
	@Test
	public void testGetCreatures() {
		System.out.println("Testing getCreatures method...");
		
		World instance = World.getWorld();
		assertTrue(instance.getCreatures().isEmpty());
		
		instance = World.createNewWorld(20, 20);
		assertTrue(instance.getCreatures().isEmpty());
	}
}
