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
 * This class contains every Unit Test applicable to the Food class.
 * @author pedromvaz
 * @version 0.02
 * @see Food
 */
public class FoodTest {
	
	public FoodTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Starting tests on " + Food.class.getName() + " class");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Finished tests on " + Food.class.getName() + " class");
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testGetType() {
		System.out.println("Testing getType method...");
		
		Food food = new Food(new Coordinates(10.0, 10.0));
		assertEquals(food.getType(), Food.TYPE);
		assertNotEquals(food.getType(), Item.TYPE);
	}
	
}
