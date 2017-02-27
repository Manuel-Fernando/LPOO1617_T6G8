package dkeep.logic;

public class Map {

	char [][] board; 
	
	/*
	 * M�todo para retornar o elemento de uma dada posi��o no quadro
	 */
	
	protected char searchElement(int x, int y) {
		return board[x][y];
	}
	
	/*
	 * M�todo para alterar um elemento numa dada posi��o
	 */
	
	protected void writeElement(int x, int y, char element){
		board[x][y]=element;	
	}

}

