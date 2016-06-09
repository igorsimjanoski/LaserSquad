package com.game.mission;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.game.model.Position;

/**
 * Represents mission(level). Instances that extends this class can set obstacles and enemies
 * 
 * @author igor
 *
 */
public abstract class Mission implements Serializable{
	
	private String missionName;
	private int[] x1;
	private int[] x2;
	private int[] y1;
	private int[] y2;
	
	protected Position starGate;
	protected List<int[]> obstacles = new ArrayList<int[]>();
	protected List<int[]> enemies = new ArrayList<int[]>();
	
	public abstract void setObstacles();
	public abstract void setEnemies();

	public Mission(int[] x1, int[]x2, int[] y1, int[] y2, String missionName){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.missionName = missionName;
	}
	
	public boolean pathUpClean(Position position){
		boolean pathClean = false;
		int newPositionX = position.getX();
		int newPositionY = position.getY()+1;
		if (newPositionY <= y1[1]){
			//check obstacles
			if (!hasObstacle(newPositionX, newPositionY)){
				pathClean = true;
			}
		}
		return pathClean;
	}

	public boolean pathDownClean(Position position){
		boolean pathClean = false;
		int newPositionX = position.getX();
		int newPositionY = position.getY()-1;
		if (newPositionY >= x1[1]){
			if (!hasObstacle(newPositionX, newPositionY)){
				pathClean = true;
			}
		}
		return pathClean;
	}
	
	public boolean pathLeftClean(Position position){
		boolean pathClean = false;
		int newPositionX = position.getX()-1;
		int newPositionY = position.getY();
		if (newPositionX >= x1[0]){
			if (!hasObstacle(newPositionX, newPositionY)){
				pathClean = true;
			}
		}
		return pathClean;
	}

	public boolean pathRightClean(Position position){
		boolean pathClean = false;
		int newPositionX = position.getX()+1;
		int newPositionY = position.getY();
		if (newPositionX <= x2[0]){
			if (!hasObstacle(newPositionX, newPositionY)){
				pathClean = true;
			}
		}
		return pathClean;
	}

	/**
	 * @return the obstacles
	 */
	public List<int[]> getObstacles() {
		return obstacles;
	}
	
	public boolean hasObstacle(int x, int y){
		boolean hasObstacle = false;
		try {
			for(int[] i : obstacles){
				if ((i[0] == x) && (i[1] == y)){
					hasObstacle = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return hasObstacle;
	}
	
	public void destroyObstacle(int x, int y){
		int index = 0;
		try {
			for(int i=0; i<obstacles.size();i++){
				if ((obstacles.get(i)[0] == x) && (obstacles.get(i)[1] == y)){
					index = i;
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		obstacles.remove(index);
	}
	
	public int getWidth(){
		return y2[0]-y1[0];
	}

	public int getHeight(){
		return y2[1]-x1[1];
	}

	/**
	 * @return the starGate
	 */
	public Position getStarGate() {
		return starGate;
	}	
}
