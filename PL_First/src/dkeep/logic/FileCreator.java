package dkeep.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileCreator {
	
	private File file;
	
	public FileCreator(){
		file = new File("game.txt");
	}
	
	public void saveGame(char[][]board) throws FileNotFoundException{
		
		PrintWriter output = new PrintWriter(file);
		
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				output.print(board[i][j]);
			}
		  output.println();
		} output.println(); 
		
		output.close();
	}

}
