package dkeep.logic;

/**
 * Classe que guarda o mapa de jogo do nível criado pelo utilizador ou guardado num ficheiro
 * @author Utilizador
 *
 */
public class MapLevel3 extends Map {
	
	/**
	 * Mapa do jogo criado pelo utilizador/ lido do ficheiro
	 */
	static char [][]board3;
	
	/**
	 * Contrutor que guarda o mapa de jogo
	 */
	public MapLevel3(){
		board=board3;		
	}	
}