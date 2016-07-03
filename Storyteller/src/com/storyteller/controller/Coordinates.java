/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

/**
 * Everything existing in the Storyteller world, be it a structure, a plant or a creature,
 * will need to be located somewhere. The Coordinates class will handle the location of
 * every element in the Storyteller 2-dimensional world.
 * @author pedromvaz
 * @version 0.01
 * @see World
 * @see Structure
 * @see Plant
 * @see Creature
 */
public class Coordinates {
	
	private double x;
	private double y;
	
	/**
	 * The Coordinates constructor. Every coordinate will be 2-dimensional at the start.
	 * @param x The coordinates starting X value.
	 * @param y The coordinates starting Y value.
	 */
	public Coordinates(double x, double y) {
		setX(x);
		setY(y);
	}

	/**
	 * Returns the current X value of the coordinates.
	 * @return The coordinates X value.
	 */
	public final double getX() {
		return x;
	}

	/**
	 * Sets the X value for the coordinates.
	 * @param x The coordinates X value.
	 */
	public final void setX(double x) {
		this.x = x;
	}

	/**
	 * Returns the current Y value of the coordinates.
	 * @return The coordinates Y value.
	 */
	public final double getY() {
		return y;
	}

	/**
	 * Sets the Y value for the coordinates.
	 * @param y The coordinates Y value.
	 */
	public final void setY(double y) {
		this.y = y;
	}
}
