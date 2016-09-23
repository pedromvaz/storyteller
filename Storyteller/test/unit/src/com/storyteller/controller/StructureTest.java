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
 * This class contains every Unit Test applicable to the Structure class.
 * @author pedromvaz
 * @version 0.02
 * @see Structure
 */
public class StructureTest {
	
	Structure structure;
	Coordinates location;
	Room roomOne, roomTwo;
	
	public StructureTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Starting tests on " + Structure.class.getName() + " class");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Finished tests on " + Structure.class.getName() + " class");
	}
	
	@Before
	public void setUp() {
		location = new Coordinates(10.0, 10.0);
		structure = new Structure(location);
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testGetRooms() {
		System.out.println("Testing getRooms method...");
		
		assertTrue(structure.getRooms().isEmpty());
		roomOne = new Room(structure);
		assertEquals(structure.getRooms().size(), 1);
		roomTwo = new Room(structure);
		assertEquals(structure.getRooms().size(), 2);
	}

	@Test
	public void testAddRoom() {
		System.out.println("Testing addRoom method...");
		
		assertTrue(structure.getRooms().isEmpty());
		roomOne = new Room(structure);
		roomTwo = new Room(structure);
		assertEquals(structure.getRooms().size(), 2);
		structure.addRoom(roomOne);
		assertEquals(structure.getRooms().size(), 2);
		structure.addRoom(roomTwo);
		assertEquals(structure.getRooms().size(), 2);
	}
}
