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
 * This class contains every Unit Test applicable to the FlatWorld class.
 * @author pedromvaz
 * @version 0.02
 * @see World
 */
public class FlatWorldTest {
	
	public FlatWorldTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Starting tests on " + FlatWorld.class.getName() + " class");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Finished tests on " + FlatWorld.class.getName() + " class");
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testGetArea() {
		System.out.println("Testing getArea method...");
		
		FlatWorld world;
		
		for (double x = 0.0; x < 10.0; x++) {
			for (double y = 0.0; y < 10.0; y++) {
				world = new FlatWorld(new Coordinates(x, y));
				
				assertEquals(x, world.getArea().getX(), 0.0);
				assertEquals(y, world.getArea().getY(), 0.0);
			}
		}
	}

	/**
	 * This test checks that an Entity is added to the FlatWorld instance, as well as confirms
	 * that no Entity is placed outside the borders of the world.
	 */
	@Test
	public void testAddEntity() {
		System.out.println("Testing addEntity method...");
		
		double wX = 9.0, wY = 12.0;
		FlatWorld world = new FlatWorld(new Coordinates(wX, wY));
		Coordinates location;
		Entity e;
		
		for (double eX = -5.0; eX < wX + 5.0; eX += 5.0) {
			for (double eY = -5.0; eY < wY + 5.0; eY += 5.0) {
				location = new Coordinates(eX, eY);
				e = new Entity(location);
				world.addEntity(e);
				
				assertTrue(world.hasEntity(e));
				
				if (eX <= 0.0)		assertEquals(e.getLocation().getX(), 0.0, 0.0);
				else if (eX >= wX)	assertEquals(e.getLocation().getX(), wX, 0.0);
				else				assertEquals(e.getLocation().getX(), eX, 0.0);
				
				if (eY <= 0.0)		assertEquals(e.getLocation().getY(), 0.0, 0.0);
				else if (eY >= wY)	assertEquals(e.getLocation().getY(), wY, 0.0);
				else				assertEquals(e.getLocation().getY(), eY, 0.0);
			}
		}
	}
}
