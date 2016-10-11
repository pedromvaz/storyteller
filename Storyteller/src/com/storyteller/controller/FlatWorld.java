/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller;

/**
 * The FlatWorld is a World instance with a rectangular shape.
 * It uses a {@link Coordinates} object to determine its 2D size.
 * Since this world is of a rectangular shape, its area starts at point (0,0) and ends at the
 * point defined by the specified Coordinates.
 * @author pedromvaz
 * @version 0.02
 */
public class FlatWorld extends World {
	
	private Coordinates area;
	
	public FlatWorld(Coordinates area) {
		super();
		setArea(area);
	}

	/**
	 * Returns the area of this FlatWorld instance.
	 * @return A Coordinates object specifying how big this rectangular world is.
	 */
	public Coordinates getArea() {
		return area;
	}

	/**
	 * Sets the area for this FlatWorld instance.
	 * @param area The rectangular area for this world.
	 */
	private void setArea(Coordinates area) {
		this.area = area;
	}
	
	/**
	 * Adds a new Entity object to this world. This method makes sure that no Entity is found
	 * beyond the borders of the FlatWorld instance.
	 * @param entity The Entity object to be added to the world.
	 */
	@Override
	public void addEntity(Entity entity) {
		Coordinates entityLocation = entity.getLocation();
		double eX, eY;
		
		eX = entityLocation.getX();
		eY = entityLocation.getY();
		
		if (eX < 0) entityLocation.setX(0);
		if (eY < 0) entityLocation.setY(0);
		if (eX > getArea().getX()) entityLocation.setX(getArea().getX());
		if (eY > getArea().getY()) entityLocation.setY(getArea().getY());
		
		// TODO We should make sure that no two Entity objects are placed in the same location
		
		super.addEntity(entity);
	}
}
