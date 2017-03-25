package dkeep.logic;

/**
 * Classe que guarda o mapa de jogo do nível 2
 * @author Carolina e Manuel
 *
 */
public class MapLevel2 extends Map {
	
	/**
	 * Contrutor que cria o mapa de jogo do nível 2
	 */
	public MapLevel2(){
		char [][]board2 ={{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
				{'I', ' ', ' ', ' ', 'O', ' ', ' ', 'k', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', 'H', ' ', ' ', ' ', '+', ' ', ' ', 'X'},
				{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};

		board=board2;		
	}	

}
