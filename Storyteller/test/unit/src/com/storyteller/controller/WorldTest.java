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
 * @version 0.02
 * @see World
 */
public class WorldTest {
	
	WorldImpl world;
	
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
		world = new WorldImpl();
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testHasEntity() {
		System.out.println("Testing hasEntity method...");
		
		Coordinates location = new Coordinates(10.0, 20.0);
		Entity e = new Entity(location);
		assertFalse(world.hasEntity(e));
	}

	@Test
	public void testAddEntity() {
		System.out.println("Testing addEntity method...");
		
		Coordinates location = new Coordinates(10.0, 20.0);
		Entity e = new Entity(location);
		world.addEntity(e);
		assertTrue(world.hasEntity(e));
	}

	@Test
	public void testRemoveEntity() {
		System.out.println("Testing removeEntity method...");
		
		Coordinates location = new Coordinates(10.0, 20.0);
		Entity e = new Entity(location);
		world.addEntity(e);
		assertTrue(world.hasEntity(e));
		world.removeEntity(e);
		assertFalse(world.hasEntity(e));
	}
	
	@Test
	public void testProgressTimeflow() {
		System.out.println("Testing progressTimeflow method...");
		
		// initializing 100 entities with test class below
		// test class contains counter, in the end it should be set to 100
		assertEquals(TimelineEntity.COUNT, 0);
		
		for (double x = 0.0; x < 10.0; x++) {
			for (double y = 0.0; y < 10.0; y++) {
				Entity e = new TimelineEntity(new Coordinates(x, y));
				world.addEntity(e);
			}
		}
		
		world.progressTimeflow();
		assertEquals(TimelineEntity.COUNT, 100);
	}

	@Test
	public void testGetCurrentTime() {
		System.out.println("Testing getCurrentTime method...");
		
		// testing the starting time of a newly created world
		// assuming it's 0 minutes and 0 seconds
		int i = 0, seconds = 0;
		
		do {
			assertEquals(world.getCurrentTime() % 100, seconds);
			world.progressTimeflow();
			seconds = (seconds + World.INTERVAL_OF_TIME) % 60;
		} while (i++ < 30);
	}
}

class WorldImpl extends World {
	
}

class TimelineEntity extends Entity {
	
	public static int COUNT = 0;
	
	public TimelineEntity(Coordinates location) {
		super(location);
	}
	
	@Override
	public void act(int interval_of_time) {
		COUNT++;
	}
}
