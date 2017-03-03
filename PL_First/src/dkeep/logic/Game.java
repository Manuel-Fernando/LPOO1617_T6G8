package dkeep.logic;

import java.util.ArrayList;

public class Game {
	
	MapLevel1 board1 = new MapLevel1();
	MapLevel2 board2 = new MapLevel2();
	GameState loose = new GameState();
	
	Guard rookie = new Rookie(1,8);
	Guard suspicious = new Suspicious(1,8);
	Guard drunken = new Drunken(1,8);
	
	Heroi hero1 = new Heroi(1,1);
	Heroi hero2 = new Heroi(7,1);
	
	Ogre ogre = new Ogre(1,4);
	Ogre ogre1 = new Ogre(4,4);
	
	ArrayList <Ogre> ogres = new ArrayList <Ogre>(2);

	int nivel = 1;
	int estado = 0;

	public char[][] tabuleiro1(){
		return board1.board;
	}
	
	public char[][] tabuleiro2(){
		return board2.board;
	}
	

	public int level1(char dir, Guard g){		
			
			hero1.Movimento(dir, 1, board1);
			if(loose.WinOrLoose(g.getLetter(), board1, hero1)==1){return 2;}
			if(loose.WinOrLoose(g.getLetter(), board1, hero1)==-1){return -1;}
			g.Movimento(1, board1);	

			if(loose.WinOrLoose(g.getLetter(), board1, hero1)==-1){return -1;}

			return 1;

	}

	public int level2(char dir, ArrayList <Ogre> ogres){

			hero2.Movimento(dir, 2, board2);
			if(loose.WinOrLoose((ogres.get(0)).getLetter(), board2, hero2)==1){return 4;}
			if(loose.WinOrLoose((ogres.get(0)).getLetter(), board2, hero2)==1){return 4;}
			if(!hero2.herowithclub){
				if(loose.WinOrLoose((ogres.get(0)).getLetter(), board2, hero2)==-1){return -2;}
				if(loose.WinOrLoose('$', board2, hero2)==-1){return -2;}
			}
			if(loose.WinOrLoose('*', board2, hero2)==-1){return -2;}
			if(board2.searchElement(hero2.getX(), hero2.getY()) == '*'){return -2;}	
			(ogres.get(0)).Movimento(2, board2, hero2.herowithclub, hero2.herowithkey);
			(ogres.get(1)).Movimento(2, board2, hero2.herowithclub, hero2.herowithkey);
			if(!hero2.herowithclub){
				if(loose.WinOrLoose((ogres.get(0)).getLetter(), board2, hero2)==-1){return -2;}
				if(loose.WinOrLoose('$', board2, hero2)==-1){return -2;}
			}
			if(loose.WinOrLoose('*', board2, hero2)==-1){return -2;}
			if(board2.searchElement(hero2.getX(), hero2.getY()) == '*'){return -2;}	
			return 3;
	}
	
	public int jogo(char direc){
		
		ogres.add(ogre);
		ogres.add(ogre1);
		
		if (nivel==1){
			estado = level1(direc, drunken);
			if(estado==2){
				nivel=2;
			}
		}
		else if (nivel==2){
			estado = level2(direc, ogres);
		}
		return estado;
	}
}
