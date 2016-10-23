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
	public void testHasAvailableFood() {
		System.out.println("Testing hasAvailableFood method...");
		
		tree = new Plant(location, 3.0, 10.0, Plant.SIZE.LARGE);
		
		assertTrue(tree.hasAvailableFood());
		tree.provideFood();
		assertTrue(tree.hasAvailableFood());
		tree.provideFood();
		assertTrue(tree.hasAvailableFood());
		tree.provideFood();
		assertFalse(tree.hasAvailableFood());
	}

	@Test
	public void testProvideFood() {
		System.out.println("Testing retrieveFood method...");
		
		tree = new Plant(location, 2.0, 10.0, Plant.SIZE.LARGE);
		
		Food food1 = tree.provideFood();
		Food food2 = tree.provideFood();
		Food food3 = tree.provideFood();
		
		assertNotNull(food1);
		assertNotNull(food2);
		assertNotEquals(food1, food2);
		assertNull(food3);
	}
	
	@Test
	public void testSetNegativeFoodAmount() {
		System.out.println("Testing setAvailableFood method with negative value...");
		
		tree = new Plant(location, -10.0, 10, Plant.SIZE.LARGE);
		
		assertFalse(tree.hasAvailableFood());
		assertNull(tree.provideFood());
	}

	@Test
	public void testGetSize() {
		System.out.println("Testing getSize method...");
		
		for (Plant.SIZE size : Plant.SIZE.values()) {
			tree = new Plant(location, 1000.0, 10, size);
			assertEquals(tree.getSize(), size);
		}
	}

	@Test
	public void testAct() {
		System.out.println("Testing act method...");
		
		// This method does nothing for the moment
	}

	@Test
	public void testGetAge() {
		System.out.println("Testing getAge method...");
		
		for (double age = 1.0; age < 10.0; age += 0.1) {
			tree = new Plant(location, 3.0, age, Plant.SIZE.LARGE);
			assertEquals(tree.getAge(), age, 0.0);
		}
	}
}
