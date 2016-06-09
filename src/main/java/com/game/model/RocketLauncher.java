package com.game.model;

/**
 * Range of 5 points, direction dependant
 * 
 * @author igor
 *
 */
public class RocketLauncher implements Weapon {

	@Override
	public int getRange() {
		return 5;
	}

	@Override
	public boolean isDirectionDependant() {
		return true;
	}

	@Override
	public int getAmunition() {
		return 5;
	}



}
