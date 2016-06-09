package com.game.mission;

import java.util.Random;

import com.game.model.Position;
import com.game.utils.Utils;

/**
 * 
 * @author igor
 *
 */
public class ResqueFromTheMinesMission extends Mission{

	Random random = new Random();
	
	public ResqueFromTheMinesMission() {
		super(new int[]{0,0}, new int[]{25,0}, new int[]{0,5}, new int[]{25,5}, "Resque From The Mines");
		setObstacles();
		starGate = new Position(Utils.randInt(20, 25), Utils.randInt(0, 5));
	}

	@Override
	public void setObstacles() {
		for (int i=0; i<=5; i++){
			this.obstacles.add(new int[]{random.nextInt(25),random.nextInt(5)});
		}
	}

	@Override
	public void setEnemies() {
	}

}
