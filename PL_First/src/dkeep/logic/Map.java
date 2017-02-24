package dkeep.logic;

public class Map {

	char [][] board; 
	
	/*
	 * Método para retornar o elemento de uma dada posição no quadro
	 */
	
	public char searchElement(int x, int y) {
		return board[x][y];
	}
	
	/*
	 * Método para alterar um elemento numa dada posição
	 */
	
	public void writeElement(int x, int y, char element){
		board[x][y]=element;	
	}
	
	/*
	 * Método para imprimir o quadro
	 */
	
	public void printBoard(){
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				System.out.print(board[i][j]);
				System.out.print(' ');
			}			
			System.out.println();
		} 	
	}
}

