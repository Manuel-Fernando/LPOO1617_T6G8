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
	Ogre ogre1 = new Ogre(1,4);
	Ogre ogre2 = new Ogre(1,4);
	Ogre ogre3 = new Ogre(1,4);
	Ogre ogre4 = new Ogre(1,4);
	
	ArrayList <Ogre> ogres = new ArrayList <Ogre>(5);

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

	public int level2(char dir, ArrayList <Ogre> ogres, int numOgres){

			hero2.Movimento(dir, 2, board2);
			if(loose.WinOrLoose((ogres.get(0)).getLetter(), board2, hero2)==1){return 4;}
			//if(loose.WinOrLoose((ogres.get(0)).getLetter(), board2, hero2)==1){return 4;}
			if(!hero2.herowithclub){
				if(loose.WinOrLoose((ogres.get(0)).getLetter(), board2, hero2)==-1){return -2;}
				if(loose.WinOrLoose('$', board2, hero2)==-1){return -2;}
			}
			if(loose.WinOrLoose('*', board2, hero2)==-1){return -2;}
			if(board2.searchElement(hero2.getX(), hero2.getY()) == '*'){return -2;}	
			for(int i=0; i<numOgres; i++){
				(ogres.get(i)).Movimento(2, board2, hero2.herowithclub, hero2.herowithkey);
			}
			if(!hero2.herowithclub){
				if(loose.WinOrLoose((ogres.get(0)).getLetter(), board2, hero2)==-1){return -2;}
				if(loose.WinOrLoose('$', board2, hero2)==-1){return -2;}
			}
			if(loose.WinOrLoose('*', board2, hero2)==-1){return -2;}
			if(board2.searchElement(hero2.getX(), hero2.getY()) == '*'){return -2;}	
			return 3;
	}
	
	public int jogo(char direc, String guardType,int numOgres){
		
		ogres.add(ogre);
		ogres.add(ogre1);
		ogres.add(ogre2);
		ogres.add(ogre3);
		ogres.add(ogre4);
		Guard guarda = null;
		
		if(guardType=="Suspicious"){guarda=suspicious;}
		else if(guardType=="Rookie"){guarda=rookie;}
		else if(guardType=="Drunken"){guarda=drunken;}
		
		if (nivel==1){
			estado = level1(direc, guarda);
			if(estado==2){
				nivel=2;
			}
		}
		else if (nivel==2){
			estado = level2(direc, ogres, numOgres);
		}
		return estado;
	}
}
