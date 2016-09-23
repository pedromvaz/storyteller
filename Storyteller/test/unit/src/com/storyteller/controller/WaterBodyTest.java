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
 * This class contains every Unit Test applicable to the WaterBody class.
 * @author pedromvaz
 * @version 0.02
 * @see WaterBody
 */
public class WaterBodyTest {
	
	Coordinates location;
	WaterBody spring;
	
	public WaterBodyTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Starting tests on " + WaterBody.class.getName() + " class");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Finished tests on " + WaterBody.class.getName() + " class");
	}
	
	@Before
	public void setUp() {
		location = new Coordinates(5.0, 5.0);
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testGetSalinity() {
		System.out.println("Testing getSalinity method...");
		
		for (double salinity = 0.0; salinity <= 1.0; salinity += 0.01) {
			spring = new WaterBody(location, salinity, 1000.0, WaterBody.SIZE.SMALL);
			assertEquals(spring.getSalinity(), salinity, 0.0);
		}
	}
	
	@Test
	public void testSetAbsurdSalinity() {
		System.out.println("Testing setSalinity method with absurd values...");
		
		// values below 0.0 are converted to 0.0
		spring = new WaterBody(location, -1.0, 1000.0, WaterBody.SIZE.SMALL);
		assertEquals(spring.getSalinity(), 0.0, 0.0);
		
		// values above 1.0 are converted to 1.0
		spring = new WaterBody(location, 2.0, 1000.0, WaterBody.SIZE.SMALL);
		assertEquals(spring.getSalinity(), 1.0, 0.0);
	}

	@Test
	public void testHasAvailableWater() {
		System.out.println("Testing hasAvailableWater method...");
		
		spring = new WaterBody(location, 0.0, 1000.0, WaterBody.SIZE.SMALL);
		
		assertTrue(spring.hasAvailableWater());
		spring.retrieveWater(50);
		assertTrue(spring.hasAvailableWater());
		spring.retrieveWater(500);
		assertTrue(spring.hasAvailableWater());
		spring.retrieveWater(5000);
		// water bodies will have infinite amount of water for the time being
		assertTrue(spring.hasAvailableWater());
	}

	@Test
	public void testRetrieveWater() {
		System.out.println("Testing retrieveWater method...");
		
		spring = new WaterBody(location, 0.0, 1000.0, WaterBody.SIZE.SMALL);
		
		assertEquals(spring.retrieveWater(50.0), 50.0, 0.0);
		assertEquals(spring.retrieveWater(500.0), 500.0, 0.0);
		assertEquals(spring.retrieveWater(5000.0), 1000.0, 0.0);
	}
	
	@Test
	public void testSetNegativeWaterAmount() {
		System.out.println("Testing setAvailableWater method with negative value...");
		
		spring = new WaterBody(location, 0.0, -1000.0, WaterBody.SIZE.SMALL);
		assertFalse(spring.hasAvailableWater());
		assertEquals(spring.retrieveWater(10.0), 0.0, 0.0);
	}

	@Test
	public void testGetSize() {
		System.out.println("Testing getSize method...");
		
		for (WaterBody.SIZE size : WaterBody.SIZE.values()) {
			spring = new WaterBody(location, 0.0, 1000.0, size);
			assertEquals(spring.getSize(), size);
		}
	}
}
