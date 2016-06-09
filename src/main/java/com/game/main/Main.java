package com.game.main;

import com.game.engine.CLIEngine;
import com.game.engine.GameEngine;
import com.game.mission.Mission;
import com.game.mission.ResqueFromTheMinesMission;
import com.game.model.A75;
import com.game.model.Game;
import com.game.model.Player;
import com.game.model.Position;
import com.game.model.RocketLauncher;
import com.game.model.SniperRifle;
import com.game.model.Weapon;
import com.game.utils.SerializerHelper;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameEngine cliEngine = new CLIEngine();
		
		Game game = null;
		Mission mission = null;
		Weapon weapon = null;
		while (true) {
			cliEngine.out("Please enter 1 for new mission OR 2 for resuming the game");
			String option = cliEngine.in();
			
			if (option.equals("1")){
				cliEngine.out("New game chosen");
				game = new Game();
				//TODO build a character and pick up a mission(only for new game)
				while (true){
					cliEngine.out("Let's build a character");
					cliEngine.out("Pick up a weapon, available options:");
					cliEngine.out("1. Rocket Launcher");
					cliEngine.out("2. Sniper Rifle");
					cliEngine.out("3. A75 Granades");
					option = cliEngine.in();
					switch (Integer.parseInt(option)) {
					case 1:
						weapon = new RocketLauncher();
						break;
					case 2:
						weapon = new SniperRifle();
						break;
					case 3:
						weapon = new A75();
						break;
					default:
						break;
					}
					break;
				}
				
				
				while (true){
					cliEngine.out("Pick up a mission:");
					cliEngine.out("1. Resque From the mines");
					cliEngine.out("2. Cyber hordes");
					
					String missionInput = cliEngine.in();
					
					if(missionInput.equals("1")){
						mission = new ResqueFromTheMinesMission();
					}else if (missionInput.equals("2")){
						//Mission mission = new CyberHordesMission();
					}
					break;
				}
				
				Player player = new Player();
				player.setWeapon(weapon);
				game = new Game(player, mission);
				
				break;
			}else if (option.equals("2")){
				cliEngine.out("Resume game selected");
				game = SerializerHelper.resumeGame();
				if (game == null){
					cliEngine.out("It looks like there is no saved game, please choose new game");
				}else{
					cliEngine.out("Game successfully loaded, your current status:");
					break;
				}
			}
			cliEngine.out("Invalid option selected");
		}
		
		Position currentPosition = game.getPlayer().getPosition();
		
		game.drawMission();
		cliEngine.out("Your current position is at:  " + "(" +currentPosition.getX() + "," + currentPosition.getY() + ")");

		boolean keepPlaying = true;
		while (keepPlaying){
			try{
				//cliEngine.out("What's your next move... punk?");
				String nextMove = cliEngine.in();
				
				if(nextMove.equals("8") || nextMove.equals("4") || nextMove.equals("6") || nextMove.equals("2")){
					game.decreaseEnergy();
				}
				
				if (nextMove.equals("8")){
					if(!game.moveUp()){
						cliEngine.out("You can't move up!");
					}
				}else if (nextMove.equals("4")){
					if(!game.moveLeft()){
						cliEngine.out("You can't move left!");
					}
				}else if (nextMove.equals("6")){
					if(!game.moveRight()){
						cliEngine.out("You can't move right!");
					}
				}else if (nextMove.equals("2")){
					if(!game.moveDown()){
						cliEngine.out("You can't move down!");
					}
				}else if (nextMove.equals("s")){
					cliEngine.out("You choose to save your game, are you sure?(Y|N)");
					String answer = cliEngine.in();
					if (answer.equalsIgnoreCase("y")){
						SerializerHelper.saveGame(game);
						keepPlaying = false;
					}else if (answer.equalsIgnoreCase("n")){
						
					}else{
						cliEngine.out("Unrecognized value");
					}
				}else if (nextMove.equals("d")){
					game.drawMission();
				}else if (nextMove.equals("f")){
					game.fire();
				}else{
					cliEngine.out("Unrecognized option");
				}
				if(game.starGateReached()){
					cliEngine.out("Well Done, you completed the mission! You earned " + game.getPlayer().getPoints() + " points.");
					System.exit(0);
				}
				game.drawMission();
				cliEngine.out("Energy: " + game.getPlayer().getEnergy() + ", Points: " + game.getPlayer().getPoints());
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
	}

}
