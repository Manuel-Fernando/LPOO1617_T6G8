package dkeep.logic;
import dkeep.logic.Heroi;
import dkeep.logic.Map;

public class GameState {

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
