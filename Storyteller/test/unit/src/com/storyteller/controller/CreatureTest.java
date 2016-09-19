/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

import com.storyteller.controller.exceptions.InvalidGenderException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains every Unit Test applicable to the Creature class.
 * @author pedromvaz
 * @version 0.0.1
 * @see Creature
 */
public class CreatureTest {
	
	Creature father, mother, son, daughter;
	
	public CreatureTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Starting tests on " + Creature.class.getName() + " class");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Finished tests on " + Creature.class.getName() + " class");
	}
	
	@Before
	public void setUp() {
		father = new Creature(new Coordinates(1.0, 1.0), Creature.GENDER.MALE);
		mother = new Creature(new Coordinates(2.0, 2.0), Creature.GENDER.FEMALE);
		son = new Creature(new Coordinates(3.0, 3.0), Creature.GENDER.MALE);
		daughter = new Creature(new Coordinates(4.0, 4.0), Creature.GENDER.FEMALE);
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testGetLocation() {
		System.out.println("Testing getLocation method...");
		
		Coordinates location = new Coordinates(5.0, 6.5);
		
		father = new Creature(location, Creature.GENDER.MALE);
		assertEquals(father.getLocation().getX(), location.getX(), 0.0);
		assertEquals(father.getLocation().getY(), location.getY(), 0.0);
	}
	
	@Test
	public void testGetGender() {
		System.out.println("Testing getGender method...");
		
		assertEquals(father.getGender(), Creature.GENDER.MALE);
		assertEquals(mother.getGender(), Creature.GENDER.FEMALE);
		assertEquals(father.getGender(), Creature.GENDER.MALE);
		assertEquals(daughter.getGender(), Creature.GENDER.FEMALE);
	}

	@Test
	public void testGetFather() throws InvalidGenderException {
		System.out.println("Testing getFather method...");
		
		assertNull(father.getFather());
		assertNull(mother.getFather());
		assertNull(son.getFather());
		assertNull(daughter.getFather());
		son.setFather(father);
		daughter.setFather(father);
		assertEquals(son.getFather(), father);
		assertEquals(daughter.getFather(), father);
	}

	@Test
	public void testSetFatherAsFather() throws InvalidGenderException {
		System.out.println("Testing setFather method with the father...");
		
		assertNull(son.getFather());
		assertNull(daughter.getFather());
		son.setFather(father);
		daughter.setFather(father);
		assertEquals(son.getFather(), father);
		assertEquals(daughter.getFather(), father);
	}
	
	@Test
	public void testSetMotherAsFather() {
		System.out.println("Testing setFather method with the mother...");
		
		try {
			assertNull(son.getFather());
			son.setFather(mother);
		} catch (InvalidGenderException ex) {
			System.out.println(ex.getMessage());
		} finally {
			assertNull(son.getFather());
		}
	}

	@Test
	public void testGetMother() throws InvalidGenderException {
		System.out.println("Testing getMother method...");
		
		assertNull(father.getMother());
		assertNull(mother.getMother());
		assertNull(son.getMother());
		assertNull(daughter.getMother());
		son.setMother(mother);
		daughter.setMother(mother);
		assertEquals(son.getMother(), mother);
		assertEquals(daughter.getMother(), mother);
	}

	@Test
	public void testSetMotherAsMother() throws InvalidGenderException {
		System.out.println("Testing setMother method with the mother...");
		
		assertNull(son.getMother());
		assertNull(daughter.getMother());
		son.setMother(mother);
		daughter.setMother(mother);
		assertEquals(son.getMother(), mother);
		assertEquals(daughter.getMother(), mother);
	}
	
	@Test
	public void testSetFatherAsMother() {
		System.out.println("Testing setMother method with the father...");
		
		try {
			assertNull(son.getMother());
			son.setMother(father);
		} catch (InvalidGenderException ex) {
			System.out.println(ex.getMessage());
		} finally {
			assertNull(son.getMother());
		}
	}
	
	@Test
	public void testGetChildren() throws InvalidGenderException {
		assertTrue(father.getChildren().isEmpty());
		assertTrue(mother.getChildren().isEmpty());
		son.setFather(father);
		son.setMother(mother);
		assertEquals(father.getChildren().size(), 1);
		assertEquals(mother.getChildren().size(), 1);
		assertTrue(father.getChildren().contains(son));
		assertTrue(mother.getChildren().contains(son));
		daughter.setFather(father);
		daughter.setMother(mother);
		assertEquals(father.getChildren().size(), 2);
		assertEquals(mother.getChildren().size(), 2);
		assertTrue(father.getChildren().contains(daughter));
		assertTrue(mother.getChildren().contains(daughter));
	}
}
