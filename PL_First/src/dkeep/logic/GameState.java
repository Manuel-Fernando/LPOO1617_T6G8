package dkeep.logic;
import dkeep.logic.Heroi;
import dkeep.logic.Map;

/**
 * Classe que guarda o estado de jogo
 * @author Carolina e Manuel
 *
 */
public class GameState {
	
	/**
	 * Método que verifica se herói perdeu o jogo
	 * @param over char com a letra que caracteriza a personagem que provoca a final de jogo (ogre ou guarda)
	 * @param m Map com o mapa de jogo
	 * @param h Heroi com o herói do jogo
	 * @return inteiro com o estado de jogo (-1 se perder e 1 se pode continuar a jogar)
	 */
	public int WinOrLoose (char over, Map m, Heroi h) {	

		if (h.getY()==0 || h.getX()==0 || h.getY()==m.board[0].length-1 || h.getX()==m.board.length-1){
			return 1;
		}
		else if((m.searchElement(h.getX()+1, h.getY())==over) || (m.searchElement(h.getX(), h.getY()+1)==over)
				|| (m.searchElement(h.getX()-1, h.getY())==over) || (m.searchElement(h.getX(), h.getY()-1)==over)){
			return -1;
		}else {
			return 0;
		}
	} 
}
