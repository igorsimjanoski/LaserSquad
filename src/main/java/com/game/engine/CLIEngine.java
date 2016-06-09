package com.game.engine;

import java.io.Console;
import java.util.Scanner;

public class CLIEngine implements GameEngine {
	
	private Console console = System.console();
	Scanner scanner = new Scanner(System.in);
	//TODO use factory pattern to get out
	@Override
	public String in() {
		if (console == null){
			return scanner.nextLine();
		}else{
			return console.readLine();
		}
	}

	@Override
	public void out(String text) {
		System.out.println(text);

	}

}
