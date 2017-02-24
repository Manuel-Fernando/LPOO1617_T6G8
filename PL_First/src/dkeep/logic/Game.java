package dkeep.logic;

public class Game {
	
	Game(){
		MapLevel1 board1= new MapLevel1();
		MapLevel2 board2= new MapLevel2();
	}
	
	
	
	//trata da primera parte do jogo
	public boolean firstLevel (char dir) {
		
		Heroi hero = new Heroi(1,1);
		Guard guard = new Guard (1,8);
		GameState game = new GameState();
		
		
		hero.Movimento(dir, 1, board1);
		guard.Movimento(1, board1);
		
		return false;		
	}
}
