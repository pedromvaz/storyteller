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
		World.createNewWorld(World.DEFAULT_WIDTH, World.DEFAULT_HEIGHT);
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testGetWidth() {
		for (double width = 0.0; width < 400.0; width += 29.3) {
			World.createNewWorld(width, 20.0);
			assertEquals(World.getWidth(), width, 0.0);
		}
	}

	@Test
	public void testGetHeight() {
		for (double height = 0.0; height < 200.0; height += 12.7) {
			World.createNewWorld(20.0, height);
			assertEquals(World.getHeight(), height, 0.0);
		}
	}

	@Test
	public void testHasEntity() {
		System.out.println("Testing hasEntity method...");
		
		Coordinates location = new Coordinates(10.0, 20.0);
		Entity e = new Entity(location);
		assertFalse(World.hasEntity(e));
	}

	@Test
	public void testAddEntity() {
		System.out.println("Testing addEntity method...");
		
		Coordinates location = new Coordinates(10.0, 20.0);
		Entity e = new Entity(location);
		World.addEntity(e);
		assertTrue(World.hasEntity(e));
	}

	@Test
	public void testRemoveEntity() {
		System.out.println("Testing removeEntity method...");
		
		Coordinates location = new Coordinates(10.0, 20.0);
		Entity e = new Entity(location);
		World.addEntity(e);
		assertTrue(World.hasEntity(e));
		World.removeEntity(e);
		assertFalse(World.hasEntity(e));
	}
	
	@Test
	public void testCreateNewWorld() {
		System.out.println("Testing createNewWorld method...");
		
		// Testing that, once we create a new World, the Entities do not cross over
		Coordinates location = new Coordinates(10.0, 20.0);
		Entity e = new Entity(location);
		World.addEntity(e);
		assertTrue(World.hasEntity(e));
		World.createNewWorld(20.0, 25.0);
		assertFalse(World.hasEntity(e));
	}

	@Test
	public void testProgressTimeline() {
		System.out.println("Testing progressTimeline method...");
		
		// initializing 100 entities with test class below
		// test class contains counter, in the end it should be set to 100
		assertEquals(TimelineEntity.COUNT, 0);
		
		for (double x = 0.0; x < 10.0; x++) {
			for (double y = 0.0; y < 10.0; y++) {
				Entity e = new TimelineEntity(new Coordinates(x, y));
				World.addEntity(e);
			}
		}
		
		World.progressTimeflow();
		assertEquals(TimelineEntity.COUNT, 100);
	}

	@Test
	public void testGetCurrentTime() {
		System.out.println("Testing getCurrentTime method...");
		
		// testing the starting time of a newly created world
		// assuming it's 0 minutes and 0 seconds
		int i = 0, seconds = 0;
		
		do {
			assertEquals(World.getCurrentTime() % 100, seconds);
			World.progressTimeflow();
			seconds = (seconds + World.INTERVAL_OF_TIME) % 60;
		} while (i++ < 30);
	}
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
