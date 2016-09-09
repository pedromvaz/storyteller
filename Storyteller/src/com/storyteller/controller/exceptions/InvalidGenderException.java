/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storyteller.controller.exceptions;

/**
 * This exception occurs whenever an method is invoked and the gender of the creature involved
 * is inappropriate.
 * @author pedromvaz
 * @version 0.01
 * @see Creature
 */
public class InvalidGenderException extends Exception {
	
	public InvalidGenderException() {
		super();
	}
	
	public InvalidGenderException(String message) {
		super(message);
	}
}
