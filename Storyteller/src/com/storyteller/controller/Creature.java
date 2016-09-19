/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

import com.storyteller.controller.exceptions.InvalidGenderException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the parent class of all creatures in Storyteller world.
 * Examples of creatures are bears, wolves, humans, orcs, and many others.
 * @author pedromvaz
 * @version 0.01
 * @see World
 */
public class Creature {
	
	/**
	 * The choices for a creature's gender.
	 */
	public enum GENDER { MALE, FEMALE };
	
	private Coordinates location;
	private GENDER gender;
	private Creature father, mother;
	private final List<Creature> children;
	
	/**
	 * Creates a new creature with a specific gender.
	 * @param location The location of this creature.
	 * @param gender The gender of this creature.
	 */
	public Creature(Coordinates location, GENDER gender) {
		setLocation(location);
		setGender(gender);
		
		children = new ArrayList<>();
	}
	
	/**
	 * Retrieves the location of the creature.
	 * @return The location of the creature.
	 */
	public Coordinates getLocation() {
		return location;
	}

	/**
	 * Sets the location for the creature.
	 * @param location The location for the creature.
	 */
	private void setLocation(Coordinates location) {
		this.location = location;
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
}
