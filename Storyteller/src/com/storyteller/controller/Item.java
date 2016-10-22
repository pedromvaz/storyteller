/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

/**
 * This class is the parent class of all items in Storyteller world.
 * Examples of items are food, drinks, weapons, clothing, armor pieces, rocks, tree branches.
 * @author pedromvaz
 * @version 0.02
 */
public class Item extends Entity {
	
	public static final String TYPE = "Item";
	
	private Entity owner = null;
	
	public Item(Creature creature) {
		super(null);
		
		owner = creature;
	}
	
	public Item(Coordinates location) {
		super(location);
	}
	
	/**
	 * Returns the type of this item.
	 * @return A string describing the item type.
	 */
	public String getType() {
		return TYPE;
	}
	
	/**
	 * If the item has an owner, returns the location of the owner, otherwise returns the location
	 * of the item.
	 * @return The location of the item.
	 */
	@Override
	public Coordinates getLocation() {
		return owner != null ? owner.getLocation() : super.getLocation();
	}
}
