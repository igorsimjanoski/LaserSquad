package com.game.model;

import java.io.Serializable;

public class Position implements Serializable{
	
	private int x;
	private int y;
	
	public Position(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString(){
		return "("+this.x+","+this.y+")";
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == null) {
			return false;
		}
		if (!Position.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }	
		final Position other = (Position) obj;
		if(this.x == other.getX() && (this.y == other.getY())){
			return true;
		}else{
			return false;
		}
	}
	
}
