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
 * This class contains every Unit Test applicable to the Item class.
 * @author pedromvaz
 * @version 0.02
 * @see Item
 */
public class ItemTest {
	
	public ItemTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Starting tests on " + Item.class.getName() + " class");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Finished tests on " + Item.class.getName() + " class");
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	
	
	@Test
	public void testGetLocation() {
		System.out.println("Testing getLocation method...");
		
		Coordinates itemLocation = new Coordinates(7.0, 5.0);
		Coordinates creatureLocation = new Coordinates(9.0, 12.0);
		Coordinates creatureNewLocation = new Coordinates(10.0, 12.0);
		
		Item item1 = new Item(itemLocation);
		assertEquals(item1.getLocation(), itemLocation);
		
		Creature creature = new Creature(creatureLocation, Creature.GENDER.MALE);
		Item item2 = new Item(creature);
		assertEquals(item2.getLocation(), creatureLocation);
		creature.setLocation(creatureNewLocation);
		assertEquals(item2.getLocation(), creatureNewLocation);
	}

	@Test
	public void testGetType() {
		System.out.println("Testing getType method...");
		
		Item item = new Item(new Coordinates(10.0, 10.0));
		assertEquals(item.getType(), Item.TYPE);
	}
}
