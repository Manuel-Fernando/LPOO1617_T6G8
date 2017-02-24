package dkeep.logic;

public class Map {

	char [][] board; 
	
	public char searchElement(int x, int y) {
		return board[x][y];
	}
	
	public void writeElement(int x, int y, char element){
		board[x][y]=element;	
	}
}

