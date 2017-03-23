package dkeep.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

public class FileReader {
	
	private File file;
	private Scanner input;
	private char[][] board;
	private Vector<String> info;
	
	public FileReader() throws FileNotFoundException{
		file = new File("game.txt");
		input = new Scanner(file); 
		info = new Vector<String>();
	}
	
	public char[][] loadGame(){		
		int numLines = 0;
		int numCol = 0;
		String l;
		
		if (file.exists()){
			while(input.hasNextLine()){
				l = input.nextLine();
				info.add(l);
				if (numLines == 1)
					numCol = l.length();
				numLines++;
			}
		}
		
		return copyBoard(numLines, numCol);
		
	}
	
	public char[][] copyBoard(int numLines, int numCol){
		board = new char[numLines-1][numCol];
		
		String line;
		for (int i=0; i<info.size()-1; i++){
			line = info.elementAt(i);
			for (int j=0; j<numCol; j++){
				board[i][j]=line.charAt(j);
			}
		}
		return board;
	}

}
