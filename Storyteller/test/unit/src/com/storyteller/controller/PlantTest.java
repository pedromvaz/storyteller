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
 * This class contains every Unit Test applicable to the Plant class.
 * @author pedromvaz
 * @version 0.01
 * @see Plant
 */
public class PlantTest {
	
	Coordinates location;
	Plant tree;
	
	public PlantTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Starting tests on " + Plant.class.getName() + " class");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Finished tests on " + Plant.class.getName() + " class");
	}
	
	@Before
	public void setUp() {
		location = new Coordinates(5.0, 5.0);
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testGetLocation() {
		System.out.println("Testing getLocation method...");
		
		tree = new Plant(location, 1000.0, 10, Plant.SIZE.LARGE);
		assertEquals(tree.getLocation().getX(), location.getX(), 0.0);
		assertEquals(tree.getLocation().getY(), location.getY(), 0.0);
	}

	@Test
	public void testHasAvailableFood() {
		System.out.println("Testing hasAvailableFood method...");
		
		tree = new Plant(location, 1000.0, 10, Plant.SIZE.LARGE);
		
		assertTrue(tree.hasAvailableFood());
		tree.retrieveFood(50);
		assertTrue(tree.hasAvailableFood());
		tree.retrieveFood(500);
		assertTrue(tree.hasAvailableFood());
		tree.retrieveFood(5000);
		// plants will have infinite amount of food for the time being
		assertTrue(tree.hasAvailableFood());
	}

	@Test
	public void testRetrieveFood() {
		System.out.println("Testing retrieveFood method...");
		
		tree = new Plant(location, 1000.0, 10, Plant.SIZE.LARGE);
		
		assertEquals(tree.retrieveFood(50.0), 50.0, 0.0);
		assertEquals(tree.retrieveFood(500.0), 500.0, 0.0);
		assertEquals(tree.retrieveFood(5000.0), 1000.0, 0.0);
	}
	
	@Test
	public void testSetNegativeFoodAmount() {
		System.out.println("Testing setAvailableFood method with negative value...");
		
		tree = new Plant(location, -10.0, 10, Plant.SIZE.LARGE);
		
		assertFalse(tree.hasAvailableFood());
		assertEquals(tree.retrieveFood(10.0), 0.0, 0.0);
	}

	@Test
	public void testGetSize() {
		System.out.println("Testing getSize method...");
		
		for (Plant.SIZE size : Plant.SIZE.values()) {
			tree = new Plant(location, 1000.0, 10, size);
			assertEquals(tree.getSize(), size);
		}
	}
}
