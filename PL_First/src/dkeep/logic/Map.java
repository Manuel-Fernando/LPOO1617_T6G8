package dkeep.logic;

/**
 * Classe que guarda o mapa de jogo
 * @author Carolina e Manuel
 *
 */
public class Map {

	char [][] board; 
	
	/**
	 * Método para retornar o elemento de uma dada posição no mapa de jogo
	 * @param x inteiro com a posição em x
	 * @param y inteiro com a posição em y
	 * @return char com o elemento da pasição
	 */
	public char searchElement(int x, int y) {
		return board[x][y];
	}
	
	/**
	 * Método para atribuir uma elemento a uma dada posição do mapa de jogo
	 * @param pos array de inteiros com a posição x e y no mapa de jogo
	 * @param element char com o elemento a introduzir
	 */
	protected void writeElement(int []pos, char element){
		board[pos[0]][pos[1]]=element;	
	}
	
	/**
	 * Método para atribuir um determinado mapa de jogo 
	 * @param board char[][] a atribuir
	 */
	public void setBoard(char [][]board){
		this.board=board;
		
	}
	
	/**
	 * Método para retornar o mapa de jogo 
	 * @return char[][] com o mapa de jogo
	 */
	public char [][] getBoard(){
		return board;
	}

}

