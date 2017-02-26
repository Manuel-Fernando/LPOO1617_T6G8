package dkeep.logic;
import dkeep.logic.Heroi;
import dkeep.logic.Map;

public class GameState {


	/*
	 * M�todo para verificar se o jogo acabou
	 * 
	 * Argumentos de Entrada:
	 * over - char com a letra da entidade que provoca o fim do jogo (guarda ou ogre)
	 * m - board do n�vel em quest�o
	 * h - her�i
	 * 
	 * Valores de Retorno:
	 * true - fim de jogo
	 * false -  jogo continua
	 * 
	 */

	public int WinOrLoose (char over, Map m, Heroi h) {	

		if (h.getY()==0 && (h.getX()==5 || h.getX()==6 || h.getX()==1)){
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
