package dkeep.logic;

import java.util.ArrayList;

public class Game {
	
	MapLevel1 board1 = new MapLevel1();
	MapLevel2 board2 = new MapLevel2();
	MapLevel3 board3 = new MapLevel3();
	GameState loose = new GameState();
	
	Guard rookie = new Rookie(1,8);
	Guard suspicious = new Suspicious(1,8);
	Guard drunken = new Drunken(1,8);
	
	Heroi hero1 = new Heroi(1,1);
	Heroi hero2 = new Heroi(7,1);
	Heroi hero3;
	
	Ogre ogre = new Ogre(1,4);
	Ogre ogre1 = new Ogre(1,4);
	Ogre ogre2 = new Ogre(1,4);
	Ogre ogre3 = new Ogre(1,4);
	Ogre ogre4 = new Ogre(1,4);
	
	int ogreNumber=0;
	
	ArrayList <Ogre> ogres = new ArrayList <Ogre>(5);

	int nivel = 1;
	int estado = 0;
	
	char[][] tabuleiro = board1.board;
	
	public char[][] getTabuleiro(){
		return tabuleiro;
	}

	public char[][] tabuleiro1(){
		return board1.board;
	}
	
	public char[][] tabuleiro2(){
		return board2.board;
	}
	
	public int ogreNumber(){
		return ogreNumber;
	}
	
	public void setTabuleiro(char [][] t){
		tabuleiro = t; 
		board3.setBoard(tabuleiro);
		nivel=3;
		for (int i=0; i<tabuleiro.length; i++){
			for (int j=0; j<tabuleiro[0].length; j++){
				if(tabuleiro[i][j]=='H'){hero3 = new Heroi(i,j);}
				else if(tabuleiro[i][j]=='O'){Ogre ogre = new Ogre(i,j);
											  ogres.add(ogre);	
											  ogreNumber++;} 
				else if(tabuleiro[i][j]=='k'){for(Ogre x:ogres){x.setKeyPosition(i, j);}}
				else if(tabuleiro[i][j]=='+'){for(Ogre x:ogres){x.setArmPosition(i, j);}}
			}
		}			
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

	public int level3(char dir, ArrayList <Ogre> ogres, int numOgres){

		hero3.Movimento(dir, 2, board3);
		if(loose.WinOrLoose((ogres.get(0)).getLetter(), board3, hero3)==1){return 6;}
		if(!hero3.herowithclub){
			if(loose.WinOrLoose((ogres.get(0)).getLetter(), board3, hero3)==-1){return -3;}
			if(loose.WinOrLoose('$', board3, hero3)==-1){return -3;}
		}
		if(loose.WinOrLoose('*', board3, hero3)==-1){return -3;}
		if(board3.searchElement(hero3.getX(), hero3.getY()) == '*'){return -3;}	
		for(int i=0; i<numOgres; i++){
			(ogres.get(i)).Movimento(2, board3, hero3.herowithclub, hero3.herowithkey);
		}
		if(!hero3.herowithclub){
			if(loose.WinOrLoose((ogres.get(0)).getLetter(), board3, hero3)==-1){return -3;}
			if(loose.WinOrLoose('$', board3, hero3)==-1){return -3;}
		}
		if(loose.WinOrLoose('*', board3, hero3)==-1){return -3;}
		if(board3.searchElement(hero3.getX(), hero3.getY()) == '*'){return -3;}	
		return 5;
}
	
	public int jogo(char direc, String guardType, int numOgres){


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
			tabuleiro = board1.board;
			estado = level1(direc, guarda);
			if(estado==2){
				tabuleiro = board2.board;
				nivel=2;
			}
		}
		else if (nivel==2){
			estado = level2(direc, ogres, numOgres);
		}
		else if (nivel==3){
			estado = level3(direc, ogres, numOgres);
		}
		return estado;
	}
}
