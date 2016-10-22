/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

import com.storyteller.controller.exceptions.InvalidGenderException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class is the parent class of all creatures in Storyteller world.
 * Examples of creatures are bears, wolves, humans, orcs, and many others.
 * @author pedromvaz
 * @version 0.02
 * @see World
 */
public class Creature extends Entity {
	
	/**
	 * The choices for a creature's gender.
	 */
	public enum GENDER { MALE, FEMALE };
	
	private GENDER gender;
	private Creature father, mother;
	// TODO Consider updating children to a Set, because a List doesn't make sense
	private final List<Creature> children;
	
	// grouping a Creature's needs
	// TODO Consider using a SortedSet, once we create the class Need
	private final Set<String> needs;
	private double hunger;
	private double thirst;
	
	private final Set<Item> inventory;
	
	/**
	 * Creates a new creature with a specific gender.
	 * @param location The location of this creature.
	 * @param gender The gender of this creature.
	 */
	public Creature(Coordinates location, GENDER gender) {
		super(location);
		setGender(gender);
		
		children = new ArrayList<>();
		
		needs = new HashSet<>();
		setHunger(0.0);
		setThirst(0.0);
		
		inventory = new HashSet<>();
	}
	
	/**
	 * Gets the gender of the creature.
	 * @return Either MALE or FEMALE.
	 * @see Creature.GENDER
	 */
	public GENDER getGender() {
		return gender;
	}

	/**
	 * Sets the gender of the creature.
	 * @param gender Either MALE or FEMALE.
	 */
	private void setGender(GENDER gender) {
		this.gender = gender;
	}
	
	/**
	 * Gets the biological father of the creature.
	 * @return A creature of the male gender.
	 */
	public Creature getFather() {
		return father;
	}

	/**
	 * Sets the biological father of the creature.
	 * @param father A creature of the male gender.
	 * @throws com.storyteller.controller.exceptions.InvalidGenderException
	 */
	public void setFather(Creature father) throws InvalidGenderException {
		if (this.father != null)
			return;
		
		if (father.gender != GENDER.MALE)
			throw new InvalidGenderException("Only a male creature can be a father.");
		
		this.father = father;
		father.addChild(this);
	}

	/**
	 * Gets the biological mother of the creature.
	 * @return A creature of the female gender.
	 */
	public Creature getMother() {
		return mother;
	}

	/**
	 * Sets the biological mother of the creature.
	 * @param mother A creature of the female gender.
	 * @throws com.storyteller.controller.exceptions.InvalidGenderException
	 */
	public void setMother(Creature mother) throws InvalidGenderException {
		if (this.mother != null)
			return;
		
		if (mother.gender != GENDER.FEMALE)
			throw new InvalidGenderException("Only a female creature can be a mother.");
		
		this.mother = mother;
		mother.addChild(this);
	}
	
	/**
	 * Gets a list of all this creature's children.
	 * @return A list of creatures.
	 */
	public List<Creature> getChildren() {
		return children;
	}
	
	/**
	 * Adds a new child to the creature.
	 * @param child A creature.
	 */
	private void addChild(Creature child) {
		this.children.add(child);
	}
	
	/**
	 * This is the method that will make each Creature act, or decide on an action, for each
	 * interval of time. Every type of Creature will have a different implementation.
	 * @param interval_of_time The number of seconds each interval of time takes.
	 */
	@Override
	public void act(int interval_of_time) {
		updateConditions(interval_of_time);
		
		// basic needs
		checkNeedToEat();
		checkNeedToDrink();
	}
	
	private void updateConditions(int interval_of_time) {
		// TODO When the Creature is sleeping, hunger and thirst grow about half as much
		setHunger(getHunger() + 0.00694 * interval_of_time); // gets hungry (100.0) every 4 hours
		setThirst(getThirst() + 0.00463 * interval_of_time); // gets thirsty (100.0) every 6 hours
	}
	
	private void checkNeedToEat() {
		if (getHunger() > 80.0)
			addNeed("Eat");
		else
			removeNeed("Eat");
	}
	
	private void checkNeedToDrink() {
		if (getThirst() >= 80.0) addNeed("Drink");
		if (getThirst() <= 20.0) removeNeed("Drink");
	}
	
	/**
	 * Returns the list of needs for a Creature.
	 * @return A list of needs.
	 */
	public Set<String> getNeeds() {
		return needs;
	}
	
	/**
	 * Adds a need to the Creature's list.
	 * @param need The need to add to the list.
	 */
	private void addNeed(String need) {
		needs.add(need);
	}
	
	/**
	 * Removes a need from the Creature's list.
	 * @param need The need to remove from the list.
	 */
	private void removeNeed(String need) {
		needs.remove(need);
	}

	/**
	 * Returns the Creature's hunger level.
	 * A value close to 0.0 means the Creature is not hungry.
	 * A value close to 100.0 means the Creature is starving.
	 * @return The Creature's hunger level.
	 */
	private double getHunger() {
		return hunger;
	}

	/**
	 * Updates the Creature's hunger level, either up or down.
	 * A value close to 0.0 means the Creature is not hungry.
	 * A value close to 100.0 means the Creature is starving.
	 * @param hunger 
	 */
	private void setHunger(double hunger) {
		this.hunger = Math.max(0.0, Math.min(100.0, hunger));
	}

	/**
	 * Returns the Creature's thirst level.
	 * A value close to 0.0 means the Creature is not thirsty.
	 * A value close to 100.0 means the Creature is very thirsty.
	 * @return The Creature's thirst level.
	 */
	private double getThirst() {
		return thirst;
	}

	/**
	 * Updates the Creature's hunger level, either up or down.
	 * A value close to 0.0 means the Creature is not hungry.
	 * A value close to 100.0 means the Creature is starving.
	 * @param hunger 
	 */
	private void setThirst(double thirst) {
		this.thirst = Math.max(0.0, Math.min(100.0, thirst));
	}
	
	/**
	 * Adds a specific item to the inventory, as long as:
	 * <ul>
	 * <li>The inventory is not full
	 * <li>The item is not already in the inventory
	 * </ul>
	 * @param item The item to be added to the inventory
	 * @return TRUE if the item was added to the inventory, FALSE otherwise
	 */
	public boolean addToInventory(Item item) {
		if (inventory.size() < 2) {
			item.setLocation(this.getLocation());
			
			return inventory.add(item);
		}
		
		return false;
	}
	
	/**
	 * Returns the number of items currently in the Creature's inventory.
	 * @return The number of items in the inventory.
	 */
	public int getInventorySize() {
		return inventory.size();
	}
	
	/**
	 * Eats the first piece of food found in the inventory.
	 * If food is found, the Creature's hunger is reduced.
	 * The decision to eat from the inventory was to avoid eating the same piece of food
	 * over and over. This way the food is removed, and only consumed once.
	 * @return TRUE if the Creature ate some food, FALSE otherwise.
	 */
	public boolean eatFromInventory() {
		for (Item item : inventory)
			if (item.getType().equals(Food.TYPE)) {
				inventory.remove(item);
				
				// TODO Improve on this solution
				// each food type will lower hunger differently
				// Creatures will have different appetites
				setHunger(getHunger() - 20);
				
				return true;
			}
		
		return false;
	}
	
	/**
	 * The Creature drinks from a WaterBody, lowering its thirst.
	 * @param waterBody The WaterBody from which the Creature drinks water.
	 */
	public void drinkFrom(WaterBody waterBody) {
		// TODO Improve on this solution
		// each Creature will drink different quantities
		// the thirst decreases depending on the salinity; it might even increase
		double water = waterBody.retrieveWater(1.0);
		
		if (water > 0.0)
			setThirst(getThirst() - 3);
	}
}
