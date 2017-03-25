package dkeep.logic;

/**
 * Classe que guarda o mapa de jogo do nível 1
 * @author Carolina e Manuel
 *
 */
public class MapLevel1 extends Map {
	
	/**
	 * Contrutor que cria um mapa de jogo do nível 1
	 */
	public MapLevel1(){
		char [][]board1 = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
							{'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X'},
							{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
							{'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
							{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
							{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
							{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
							{'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
							{'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X'},
							{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'} };
		board=board1;
	}	
}
