package com.game.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.game.model.Game;

/**
 * Save/resume game
 * 
 * @author igor
 *
 */
public class SerializerHelper {
	
	public static void saveGame(Game game){
		  FileOutputStream fileOut = null;
		  ObjectOutputStream out = null;
	      try
	      {
	    	 String tempDir = System.getProperty("java.io.tmpdir");
	         fileOut = new FileOutputStream(tempDir+File.separatorChar+"game.ser");
	         out = new ObjectOutputStream(fileOut);
	         out.writeObject(game);
	         out.close();
	         fileOut.close();
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }finally {
	    	   if(fileOut != null){
	    		   try {
	    			   fileOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	   }
	    	   if (out != null){
	    		try {
	    			  out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	   }	    	  
	      }
	}
	
	public static Game resumeGame(){
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		Game game = null;
		try{
			  String tempDir = System.getProperty("java.io.tmpdir");
	          fileIn = new FileInputStream(tempDir+File.separatorChar+"game.ser");
	          in = new ObjectInputStream(fileIn);
	          game = (Game) in.readObject();
	          in.close();
	       }catch(IOException i){
	          i.printStackTrace();
	       }catch(ClassNotFoundException c){
	          c.printStackTrace();
	       }
	       finally{
	    	   if(fileIn != null){
	    		   try {
					fileIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	   }
	    	   if (in != null){
	    		   try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	   }
	       }
	    return game;
	}

}
