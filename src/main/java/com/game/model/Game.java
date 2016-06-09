package com.game.model;

import java.io.Serializable;
import java.util.List;

import com.game.mission.Mission;

public class Game implements Serializable{
	
	private Player player;
	
	private Mission mission;
	
	public Game(){}
	
	public Game(Player player, Mission mission){
		this.player = player;
		this.mission = mission;
	}
	
	public boolean moveUp(){
		
		Position position = player.getPosition();
		
		int y = position.getY();
		boolean pathClean = mission.pathUpClean(position);
		
		if(pathClean){
			player.moveUp();
		}else{
			return false;
		}
		return true;
	}
	
	public boolean moveDown(){
		
		Position position = player.getPosition();
		
		boolean pathClean = mission.pathDownClean(position);
		
		if(pathClean){
			player.moveDown();
		}else{
			return false;
		}
		return true;
	}

	public boolean moveRight(){
		
		Position position = player.getPosition();
		
		boolean pathClean = mission.pathRightClean(position);
		
		if(pathClean){
			player.moveRight();
		}else{
			return false;
		}
		return true;
	}

	public boolean moveLeft(){
		
		Position position = player.getPosition();
		
		boolean pathClean = mission.pathLeftClean(position);
		
		if(pathClean){
			player.moveLeft();
		}else{
			return false;
		}
		return true;
	}
	
	public String describeGame(){
		StringBuilder sb = new StringBuilder();
		sb.append("");
		
		return sb.toString();
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the mission
	 */
	public Mission getMission() {
		return mission;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @param mission the mission to set
	 */
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	
	public void drawMission(){
		int player_x = player.getPosition().getX();
		int player_y = player.getPosition().getY();
		
		int width = mission.getWidth();
		int height = mission.getHeight();
		
		Position starGate = mission.getStarGate();
		
		for(int h=height; h>=0; h--){
			for (int i=0;i<=width;i++){
				//check if this coordinate is obstacle
				//check if this coordinate is current player position
				//TODO: other? enemies? energy?
				if(mission.hasObstacle(i, h)){
					System.out.print("@");
				}else if((i == starGate.getX()) && (h == starGate.getY())){
					System.out.print("O");
				}else if((player_x==i) &&(player_y == h)){
					System.out.print(player.getDirectionSymbol());
				}else if ((i==width) || (i==0) || (h==height) || (h==0)){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * Check if player reached star gate
	 * 
	 * @return
	 */
	public boolean starGateReached(){
		boolean starGateReached = false;
		try {
			Position starGatePosition = mission.getStarGate();
			if(starGatePosition.equals(player.getPosition())){
				starGateReached = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return starGateReached;
	}
	
	public void decreaseEnergy(){
		int energy = player.getEnergy();
		if(energy == 0){
			System.out.println("Game Over! You don't have any energy left");
			System.exit(0);
		}else{
			energy-=1;
			player.setEnergy(energy);
		}
	}
	
	public void fire(){
		Weapon weapon = player.getWeapon();
		
		int range = weapon.getRange();
		boolean isDirectionDependant = weapon.isDirectionDependant(); 
		
		
		boolean isLeft = player.isLeftDirection();
		boolean isRight = player.isRightDirection();
		boolean isUp = player.isUpDirection();
		boolean isDown = player.isDownDirection();

		if (!isDirectionDependant){
			isLeft = true;
			isRight = true;
			isUp = true;
			isDown = true;
		}
		
		int playerX = player.getPosition().getX();
		int playerY = player.getPosition().getY();
		
		if (isLeft){
			for(int x=playerX; x>=(playerX-range); x--){
				if(mission.hasObstacle(x, playerY)){
					mission.destroyObstacle(x, playerY);
					player.increasePoint();
				}
			}
		}
		
		if(isRight){
			for(int x=playerX; x<=(playerX+range); x++){
				if(mission.hasObstacle(x, playerY)){
					mission.destroyObstacle(x, playerY);
					player.increasePoint();
				}
			}		
		}
		
		if(isDown){
			for(int y=playerY; y>=(playerY-range); y--){
				if(mission.hasObstacle(playerX, y)){
					mission.destroyObstacle(playerX, y);
					player.increasePoint();
				}
			}	
		}
		
		if(isUp){
			for(int y=playerY; y<=(playerY+range); y++){
				if(mission.hasObstacle(playerX, y)){
					mission.destroyObstacle(playerX, y);
					player.increasePoint();
				}
			}		
		}
	}
	
}
