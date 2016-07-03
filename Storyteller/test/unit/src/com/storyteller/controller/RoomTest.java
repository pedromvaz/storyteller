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
 * This class contains every Unit Test applicable to the Room class.
 * @author pedromvaz
 * @version 0.01
 * @see Room
 */
public class RoomTest {
	
	Coordinates location;
	Structure structureOne, structureTwo;
	Room roomOne, roomTwo, roomThree;
	
	public RoomTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Starting tests on " + Room.class.getName() + " class");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Finished tests on " + Room.class.getName() + " class");
	}
	
	@Before
	public void setUp() {
		location = new Coordinates(5.0, 5.0);
		structureOne = new Structure(location);
		structureTwo = new Structure(location);
		roomOne = new Room(structureOne);
		roomTwo = new Room(structureOne);
		roomThree = new Room(structureTwo);
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testGetStructure() {
		System.out.println("Testing getStructure method...");
		
		assertNotNull(roomOne.getStructure());
		assertNotNull(roomTwo.getStructure());
		assertNotNull(roomThree.getStructure());
		
		assertEquals(roomOne.getStructure(), structureOne);
		assertEquals(roomTwo.getStructure(), structureOne);
		assertEquals(roomThree.getStructure(), structureTwo);
		
		assertEquals(roomOne.getStructure(), roomTwo.getStructure());
		assertNotEquals(roomOne.getStructure(), roomThree.getStructure());
		assertNotEquals(roomTwo.getStructure(), roomThree.getStructure());
	}
	
	@Test
	public void testGetPassages() {
		System.out.println("Testing getPassages method...");
		
		assertEquals(roomOne.getPassages().size(), 0);
		roomOne.addPassageToRoom(roomTwo);
		assertEquals(roomOne.getPassages().size(), 1);
		roomOne.addPassageToWorld();
		assertEquals(roomOne.getPassages().size(), 2);
		
		assertEquals(roomTwo.getPassages().size(), 1);
		roomTwo.addPassageToRoom(roomOne);
		assertEquals(roomTwo.getPassages().size(), 1);
		
		assertEquals(roomThree.getPassages().size(), 0);
		roomThree.addPassageToWorld();
		assertEquals(roomThree.getPassages().size(), 1);
		roomThree.addPassageToRoom(roomOne);
		assertEquals(roomThree.getPassages().size(), 1);
		roomThree.addPassageToRoom(roomTwo);
		assertEquals(roomThree.getPassages().size(), 1);
	}
	
	@Test
	public void testAddPassageToRoom() {
		System.out.println("Testing addPassageToRoom method...");
		
		Passage p = roomOne.addPassageToRoom(roomTwo);
		assertEquals(p.getRooms().size(), 2);
		assertTrue(p.getRooms().contains(roomOne));
		assertTrue(p.getRooms().contains(roomTwo));
		assertFalse(p.isExterior());
		
		// p2 will be NULL because p already connects roomOne to roomTwo
		Passage p2 = roomTwo.addPassageToRoom(roomOne);
		assertNull(p2);
		
		// p3 will be NULL because we can't connect rooms from different structures
		Passage p3 = roomTwo.addPassageToRoom(roomThree);
		assertNull(p3);
	}

	@Test
	public void testAddPassageToWorld() {
		System.out.println("Testing addPassageToWorld method...");
		
		Passage p = roomOne.addPassageToWorld();
		assertEquals(p.getRooms().size(), 1);
		assertTrue(p.getRooms().contains(roomOne));
		assertTrue(p.isExterior());
	}
}
