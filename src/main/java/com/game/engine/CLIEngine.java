package com.game.engine;

import java.io.Console;
import java.util.Scanner;

/**
 * Console reader/writer
 * 
 * @author igor
 *
 */
public class CLIEngine implements GameEngine {
	
	@Override
	public String in() {
		Console console = System.console();
		if (console == null){
			Scanner scanner = new Scanner(System.in);
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
