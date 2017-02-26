package dkeep.logic;

public class Game {
	
	MapLevel1 board1 = new MapLevel1();
	MapLevel2 board2 = new MapLevel2();
	GameState loose = new GameState();
	Heroi hero1 = new Heroi(1,1);
	Heroi hero2 = new Heroi(7,1);
	Guard guard = new Guard (1,8);
	Ogre ogre = new Ogre (1,4);
	int nivel = 1;
	int estado = 0;

	
	public char[][] tabuleiro1(){
		return board1.board;
	}
	
	public char[][] tabuleiro2(){
		return board2.board;
	}
	
	public int level1(char dir){

			hero1.Movimento(dir, 1, board1);
			if(loose.WinOrLoose(guard.getLetter(), board1, hero1)==1){return 2;}
			if(loose.WinOrLoose(guard.getLetter(), board1, hero1)==-1){return -1;}
			guard.Movimento(1, board1);
			if(loose.WinOrLoose(guard.getLetter(), board1, hero1)==-1){return -1;}
			return 1;
	}
	
	public int level2(char dir){

			hero2.Movimento(dir, 2, board2);
			if(loose.WinOrLoose(ogre.getLetter(), board2, hero2)==1){return 4;}
			if(loose.WinOrLoose(ogre.getLetter(), board2, hero2)==-1){return -2;}
			if(loose.WinOrLoose('*', board2, hero2)==-1){return -2;}
			if(loose.WinOrLoose('$', board2, hero2)==-1){return -2;}	
			ogre.Movimento(2, board2);
			if(loose.WinOrLoose(ogre.getLetter(), board2, hero2)==-1){return -2;}
			if(loose.WinOrLoose('*', board2, hero2)==-1){return -2;}
			if(loose.WinOrLoose('$', board2, hero2)==-1){return -2;}	
			return 3;
	}
	
	public int jogo(char direc){
		
		if (nivel==1){
			estado = level1(direc);
			if(estado==2){
				nivel=2;
			}
		}
		else if (nivel==2){
			estado = level2(direc);
		}
		return estado;
	}
}
