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
	
	public void writeElement(int x, int y, char element){
		board[x][y]=element;	
	}
	
	/*
	 * M�todo para imprimir o quadro
	 */
	
	public void printBoard(){
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				System.out.print(board[i][j]);
				System.out.print(' ');
			}			
			System.out.println();
		} 	System.out.println();
	}
}

