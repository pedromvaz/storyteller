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
 * This class contains every Unit Test applicable to the Passage class.
 * @author pedromvaz
 * @version 0.01
 * @see Passage
 */
public class PassageTest {
	
	Coordinates location;
	Structure structure;
	Room roomOne, roomTwo;
	Passage passageOne, passageTwo;
	
	public PassageTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Starting tests on " + Passage.class.getName() + " class");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Finished tests on " + Passage.class.getName() + " class");
	}
	
	@Before
	public void setUp() {
		location = new Coordinates(5.0, 5.0);
		structure = new Structure(location);
		roomOne = new Room(structure);
		roomTwo = new Room(structure);
		passageOne = roomOne.addPassageToRoom(roomTwo);
		passageTwo = roomOne.addPassageToWorld();
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testGetSize() {
		System.out.println("Testing getSize method...");
		
		// default size for a passage should be MEDIUM
		assertEquals(passageOne.getSize(), Passage.SIZE.MEDIUM);
	}
	
	@Test
	public void testSetSize() {
		System.out.println("Testing setSize method...");
		
		passageOne.setSize(Passage.SIZE.LARGE);
		assertEquals(passageOne.getSize(), Passage.SIZE.LARGE);
	}
	
	@Test
	public void testGetRooms() {
		System.out.println("Testing getRooms method...");
		
		// passageOne should connect two rooms
		assertEquals(passageOne.getRooms().size(), 2);
		assertTrue(passageOne.getRooms().contains(roomOne));
		assertTrue(passageOne.getRooms().contains(roomTwo));
		
		// passageTwo should connect one room and the world
		assertEquals(passageTwo.getRooms().size(), 1);
		assertTrue(passageTwo.getRooms().contains(roomOne));
		assertFalse(passageTwo.getRooms().contains(roomTwo));
	}

	@Test
	public void testIsExterior() {
		System.out.println("Testing isExterior method...");
		
		assertFalse(passageOne.isExterior());
		assertTrue(passageTwo.isExterior());
	}
}
