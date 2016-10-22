/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

/**
 * This class is the parent class of all food sources in Storyteller world.
 * Examples of food sources are fruits, meats, leaves, fish.
 * @author pedromvaz
 * @version 0.02
 */
public class Food extends Item {
	
	public static final String TYPE = "Food";
	
	public Food(Creature creature) {
		super(creature.getLocation());
	}
	
	public Food(Coordinates location) {
		super(location);
	}
	
	/**
	 * Returns the type of this item.
	 * @return A string describing the item type.
	 */
	@Override
	public String getType() {
		return TYPE;
	}
}
