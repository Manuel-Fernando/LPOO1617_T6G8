package dkeep.logic;

/**
 * Classe que guarda o mapa de jogo
 * @author Carolina e Manuel
 *
 */
public class Map {

	char [][] board; 
	
	/**
	 * M�todo para retornar o elemento de uma dada posi��o no mapa de jogo
	 * @param x inteiro com a posi��o em x
	 * @param y inteiro com a posi��o em y
	 * @return char com o elemento da pasi��o
	 */
	public char searchElement(int x, int y) {
		return board[x][y];
	}
	
	/**
	 * M�todo para atribuir uma elemento a uma dada posi��o do mapa de jogo
	 * @param pos array de inteiros com a posi��o x e y no mapa de jogo
	 * @param element char com o elemento a introduzir
	 */
	protected void writeElement(int []pos, char element){
		board[pos[0]][pos[1]]=element;	
	}
	
	/**
	 * M�todo para atribuir um determinado mapa de jogo 
	 * @param board char[][] a atribuir
	 */
	public void setBoard(char [][]board){
		this.board=board;
		
	}
	
	/**
	 * M�todo para retornar o mapa de jogo 
	 * @return char[][] com o mapa de jogo
	 */
	public char [][] getBoard(){
		return board;
	}

}

