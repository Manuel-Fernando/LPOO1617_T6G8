package dkeep.logic;
import dkeep.logic.Heroi;
import dkeep.logic.Map;

public class GameState {

	boolean loose = false;  //variável que verifica se o jogo acabou

	/*
	 * Método para verificar se o jogo acabou
	 * 
	 * Argumentos de Entrada:
	 * over - char com a letra da entidade que provoca o fim do jogo (guarda ou ogre)
	 * m - board do nível em questão
	 * h - herói
	 * 
	 * Valores de Retorno:
	 * true - fim de jogo
	 * false -  jogo continua
	 * 
	 */

	public boolean WinOrLoose (char over, Map m, Heroi h) {	

		if (h.getX()==0 && (h.getX()==5 || h.getX()==6 || h.getX()==1)){
			return loose;
		}
		else if((m.searchElement(h.getX()+1, h.getY())==over) || (m.searchElement(h.getX(), h.getY()+1)==over)
				|| (m.searchElement(h.getX()-1, h.getY())==over) || (m.searchElement(h.getX(), h.getY()-1)==over)){
			System.out.println("Game Over!!!");
			loose = true;
			return loose;
		}else {
			return false;
		}
	} 
}
