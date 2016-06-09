package com.game.mission;

import java.util.Random;

import com.game.model.Position;
import com.game.utils.Utils;

public class ResqueFromTheMinesMission extends Mission{

	Random random = new Random();
	
	public ResqueFromTheMinesMission() {
		super(new int[]{0,0}, new int[]{15,0}, new int[]{0,5}, new int[]{15,5}, "Resque From The Mines");
		setObstacles();
		starGate = new Position(Utils.randInt(10, 15), Utils.randInt(0, 5));
	}

	@Override
	public void setObstacles() {
		for (int i=0; i<=2; i++){
			this.obstacles.add(new int[]{random.nextInt(15),random.nextInt(5)});
		}
	}

	@Override
	public void setEnemies() {
	}


}
