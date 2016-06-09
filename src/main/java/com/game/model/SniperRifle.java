package com.game.model;

/**
 * Range of 10 points, very precise weapon, direction dependent 
 * @author igor
 */
public class SniperRifle implements Weapon {

	@Override
	public int getRange() {
		return 10;
	}

	@Override
	public boolean isDirectionDependant() {
		return true;
	}

	@Override
	public int getAmunition() {
		return 3;
	}
}
