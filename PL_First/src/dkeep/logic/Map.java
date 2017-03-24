package dkeep.logic;

public class Map {

	char [][] board; 
	
	/*
	 * M�todo para retornar o elemento de uma dada posi��o no quadro
	 */
	
	public char searchElement(int x, int y) {
		return board[x][y];
	}
	
	/*
	 * M�todo para alterar um elemento numa dada posi��o
	 */
	
	protected void writeElement(int []pos, char element){
		board[pos[0]][pos[1]]=element;	
	}
	
	public void setBoard(char [][]board){
		this.board=board;
		
	}
	
	public char [][] getBoard(){
		return board;
	}

}

