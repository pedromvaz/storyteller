/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

import com.storyteller.controller.exceptions.InvalidGenderException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains every Unit Test applicable to the Creature class.
 * @author pedromvaz
 * @version 0.02
 * @see Creature
 */
public class CreatureTest {
	
	static final int SECONDS_FOR_HUNGER = 4 * 60 * 60;
	static final int SECONDS_FOR_THIRST = 6 * 60 * 60;
	
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
	public void testSetFather() throws InvalidGenderException {
		System.out.println("Testing setFather method with the father...");
		
		assertNull(son.getFather());
		assertNull(daughter.getFather());
		son.setFather(father);
		daughter.setFather(father);
		assertEquals(son.getFather(), father);
		assertEquals(daughter.getFather(), father);
	}
	
	@Test
	public void testSetSecondFather() throws InvalidGenderException {
		System.out.println("Testing setFather method twice...");
		
		son.setFather(father);
		daughter.setFather(father);
		
		Creature father2 = new Creature(new Coordinates(1.5, 1.5), Creature.GENDER.MALE);
		son.setFather(father2);
		daughter.setFather(father2);
		
		assertEquals(son.getFather(), father);
		assertEquals(daughter.getFather(), father);
		assertNotEquals(son.getFather(), father2);
		assertNotEquals(daughter.getFather(), father2);
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
	public void testSetMother() throws InvalidGenderException {
		System.out.println("Testing setMother method with the mother...");
		
		assertNull(son.getMother());
		assertNull(daughter.getMother());
		son.setMother(mother);
		daughter.setMother(mother);
		assertEquals(son.getMother(), mother);
		assertEquals(daughter.getMother(), mother);
	}
	
	@Test
	public void testSetSecondMother() throws InvalidGenderException {
		System.out.println("Testing setMother method twice...");
		
		son.setMother(mother);
		daughter.setMother(mother);
		
		Creature mother2 = new Creature(new Coordinates(2.5, 2.5), Creature.GENDER.FEMALE);
		son.setMother(mother2);
		daughter.setMother(mother2);
		
		assertEquals(son.getMother(), mother);
		assertEquals(daughter.getMother(), mother);
		assertNotEquals(son.getFather(), mother2);
		assertNotEquals(daughter.getFather(), mother2);
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
		System.out.println("Testing getChildren method...");
		
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

	@Test
	public void testAct() {
		System.out.println("Testing act method...");
		
		// TODO What do we test here?
		// should do nothing
		father.act(1);
	}

	@Test
	public void testGetNeeds() {
		System.out.println("Testing getNeeds method...");
		
		assertFalse(father.getNeeds().contains("Eat"));
		assertFalse(father.getNeeds().contains("Drink"));
		father.act(SECONDS_FOR_HUNGER);
		assertTrue(father.getNeeds().contains("Eat"));
		assertFalse(father.getNeeds().contains("Drink"));
		father.act(SECONDS_FOR_THIRST - SECONDS_FOR_HUNGER);
		assertTrue(father.getNeeds().contains("Eat"));
		assertTrue(father.getNeeds().contains("Drink"));
	}
	
	@Test
	public void testGetInventorySize() {
		System.out.println("Testing getInventorySize method...");
		
		assertEquals(father.getInventorySize(), 0);
	}

	@Test
	public void testAddToInventory() {
		System.out.println("Testing addToInventory method...");
		
		Coordinates location = new Coordinates(5.0, 5.0);
		Item item1 = new Item(location);
		Item item2 = new Item(location);
		Item item3 = new Item(location);
		
		assertEquals(father.getInventorySize(), 0);
		father.addToInventory(item1);
		assertEquals(father.getInventorySize(), 1);
		father.addToInventory(item2);
		assertEquals(father.getInventorySize(), 2);
		father.addToInventory(item3);
		assertEquals(father.getInventorySize(), 2);
		
		assertEquals(father.getLocation(), item1.getLocation());
		assertEquals(father.getLocation(), item2.getLocation());
		assertNotEquals(father.getLocation(), item3.getLocation());
	}

	@Test
	public void testEatFromInventory() {
		System.out.println("Testing eatFromInventory method...");
		
		Food food = new Food(father);
		Item item = new Item(father);
		
		assertFalse(father.getNeeds().contains("Eat"));
		father.act(SECONDS_FOR_HUNGER);
		assertTrue(father.getNeeds().contains("Eat"));
		
		assertFalse(father.eatFromInventory());
		father.addToInventory(item);
		assertFalse(father.eatFromInventory());
		father.addToInventory(food);
		assertTrue(father.eatFromInventory());
		assertFalse(father.eatFromInventory());
		
		father.act(0);
		assertFalse(father.getNeeds().contains("Eat"));
	}

	@Test
	public void testDrinkFrom() {
		System.out.println("Testing drinkFrom method...");
		
		Coordinates location = new Coordinates(5.0, 5.0);
		WaterBody spring = new WaterBody(location, 0.0, 1000.0, WaterBody.SIZE.SMALL);
		
		assertFalse(father.getNeeds().contains("Drink"));
		father.act(SECONDS_FOR_THIRST);
		assertTrue(father.getNeeds().contains("Drink"));
		
		while (father.getNeeds().contains("Drink")) {
			father.drinkFrom(spring);
			father.act(0);
		}
		
		assertFalse(father.getNeeds().contains("Drink"));
	}

	@Test
	public void testGatherFoodFrom() {
		System.out.println("Testing gatherFoodFrom method...");
		
		Coordinates location = new Coordinates(5.0, 5.0);
		Plant tree = new Plant(location, 3.0, 10.0, Plant.SIZE.LARGE);
		
		assertTrue(father.gatherFoodFrom(tree));
		assertEquals(father.getInventorySize(), 1);
		assertTrue(father.gatherFoodFrom(tree));
		assertEquals(father.getInventorySize(), 2);
		// inventory is full at this point
		assertFalse(father.gatherFoodFrom(tree));
		assertEquals(father.getInventorySize(), 2);
		assertTrue(father.eatFromInventory());
		assertEquals(father.getInventorySize(), 1);
		// tree has no more food to give, although inventory has space for more
		assertFalse(father.gatherFoodFrom(tree));
		assertTrue(father.eatFromInventory());
		assertEquals(father.getInventorySize(), 0);
	}
}
