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
 * This class contains every Unit Test applicable to the Entity class.
 * @author pedromvaz
 * @version 0.02
 * @see Entity
 */
public class EntityTest {
	
	Coordinates location;
	Entity entity;
	
	public EntityTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Starting tests on " + Entity.class.getName() + " class");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Finished tests on " + Entity.class.getName() + " class");
	}
	
	@Before
	public void setUp() {
		location = new Coordinates(3.0, 2.0);
		entity = new Entity(location);
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testGetLocation() {
		System.out.println("Testing getLocation method...");
		
		Coordinates sameLocation = new Coordinates(location.getX(), location.getY());
		Coordinates newLocation = new Coordinates(location.getX() + 5.7, location.getY() + 9.2);
		
		assertSame(entity.getLocation(), location);
		assertNotSame(entity.getLocation(), sameLocation);
		assertNotSame(entity.getLocation(), newLocation);
		
		assertEquals(entity.getLocation().getX(), sameLocation.getX(), 0.0);
		assertEquals(entity.getLocation().getY(), sameLocation.getY(), 0.0);
		assertNotEquals(entity.getLocation().getX(), newLocation.getX(), 0.0);
		assertNotEquals(entity.getLocation().getY(), newLocation.getY(), 0.0);
	}

	@Test
	public void testSetLocation() {
		System.out.println("Testing setLocation method...");
		
		Coordinates newLocation = new Coordinates(location.getX() + 5.7, location.getY() + 9.2);
		
		assertSame(entity.getLocation(), location);
		assertNotSame(entity.getLocation(), newLocation);
		assertNotEquals(entity.getLocation().getX(), newLocation.getX(), 0.0);
		assertNotEquals(entity.getLocation().getY(), newLocation.getY(), 0.0);
		
		entity.setLocation(newLocation);
		
		assertNotSame(entity.getLocation(), location);
		assertSame(entity.getLocation(), newLocation);
		assertEquals(entity.getLocation().getX(), newLocation.getX(), 0.0);
		assertEquals(entity.getLocation().getY(), newLocation.getY(), 0.0);
	}
}
