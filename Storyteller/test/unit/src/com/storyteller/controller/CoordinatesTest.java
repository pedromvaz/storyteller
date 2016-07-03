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
 * This class contains every Unit Test applicable to the Coordinates class.
 * @author pedromvaz
 * @version 0.01
 * @see Coordinates
 */
public class CoordinatesTest {
	
	public CoordinatesTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Starting tests on " + Coordinates.class.getName() + " class");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Finished tests on " + Coordinates.class.getName() + " class");
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testInstances() {
		System.out.println("Testing different instances...");
		
		Coordinates c1 = new Coordinates(1.0, 1.0);
		Coordinates c2 = new Coordinates(1.0, 1.0);
		
		assertNotSame(c1, c2);
	}

	@Test
	public void testGetX() {
		System.out.println("Testing getX method...");
		
		for (double x = 1.0; x < 1000000; x *= 5) {
			Coordinates c = new Coordinates(x, 1.0);
			assertEquals(c.getX(), x, 0.0);
		}
	}

	@Test
	public void testSetX() {
		System.out.println("Testing setX method...");
		
		Coordinates c = new Coordinates(1.0, 1.0);
		
		for (double x = 3.0; x < 1000000; x *= 5) {
			c.setX(x);
			assertEquals(c.getX(), x, 0.0);
		}
	}

	@Test
	public void testGetY() {
		System.out.println("Testing getY method...");
		
		for (double y = 2.5; y < 1000000; y *= 5) {
			Coordinates c = new Coordinates(1.0, y);
			assertEquals(c.getY(), y, 0.0);
		}
	}

	@Test
	public void testSetY() {
		System.out.println("Testing setY method...");
		
		Coordinates c = new Coordinates(1.0, 1.0);
		
		for (double y = 4.25; y < 1000000; y *= 5) {
			c.setY(y);
			assertEquals(c.getY(), y, 0.0);
		}
	}
}
