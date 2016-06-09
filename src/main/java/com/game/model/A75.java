package com.game.model;

/**
 * A75 grenade, destroy 5 points in every direction
 * 
 * @author igor
 *
 */
public class A75 implements Weapon {

	@Override
	public int getRange() {
		return 5;
	}

	@Override
	public boolean isDirectionDependant() {
		return false;
	}

	@Override
	public int getAmunition() {
		return 3;
	}


}
