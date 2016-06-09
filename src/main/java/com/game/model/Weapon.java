package com.game.model;

import java.io.Serializable;

public interface Weapon extends Serializable{
	
	/**
	 * Get amunition
	 * 
	 * @return
	 */
	public int getAmunition();
	
	/**
	 * Range in steps(coordinates)
	 * 
	 * @return
	 */
	public int getRange();
	
	/**
	 * If weapon fires in direction of last movement
	 * @return
	 */
	public boolean isDirectionDependant();
	
}
