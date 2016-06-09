package com.game.model;

import java.io.Serializable;

import com.game.mission.Mission;

/**
 * Represent player. Defines energy, points, weapon and current position in the game
 * 
 * @author igor
 *
 */
public class Player implements Serializable{
	
	private Position position = new Position(0,0);
	
	/**
	 * Direction, keep last movement of the player
	 */
	private int[] direction = {0,0,1,0}; // left,up,right,down
	
	/**
	 * energy left
	 */
	private int energy = 20;
	
	/**
	 * points earned
	 */
	private int points = 0;

	/**
	 * weapon
	 */
	private Weapon weapon;
	
	/**
	 * @return the energy
	 */
	public int getEnergy() {
		return energy;
	}

	/**
	 * @param energy the energy to set
	 */
	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public void moveUp(){
		int y = position.getY();
		position.setY(y+1);
		setDirection(1);
	}
	
	public void moveDown(){
		int y = position.getY();
		position.setY(y-1);		
		setDirection(3);
	}
	
	public void moveRight(){
		int x = position.getX();
		position.setX(x+1);		
		setDirection(2);
	}
	
	public void moveLeft(){
		int x = position.getX();
		position.setX(x-1);		
		setDirection(0);
	}
	
	private void setDirection(int x){
		for(int y : direction){
			if (y == x){
				direction[y] = 1;
			}else{
				direction[y] = 0;
			}
		}
	}
	
	public String getDirectionSymbol(){
		if(isLeftDirection()){
			return "<";
		}else if(isUpDirection()){
			return "^";
		}else if(isRightDirection()){
			return ">";
		}else{
			return "+";
		}
	}
	
	public boolean isLeftDirection(){
		return direction[0] == 1;
	}
	
	public boolean isUpDirection(){
		return direction[1] == 1;
	}
	
	public boolean isRightDirection(){
		return direction[2] == 1;
	}
	
	public boolean isDownDirection(){
		return direction[3] == 1;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}
	
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * increase point by one
	 */
	public void increasePoint(){
		points+=1;
	}

	@Override
	public String toString(){
		return "";
	}

	/**
	 * @return the weapon
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * @param weapon the weapon to set
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	

}
