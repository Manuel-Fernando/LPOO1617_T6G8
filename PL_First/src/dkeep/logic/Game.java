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
	Guard guard3;
	
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
	
	public void setTabuleiro(char [][] t, String type){
		tabuleiro = t; 
		board3.setBoard(tabuleiro);
		nivel=3;
		
		for (int i=0; i<tabuleiro.length; i++){
			for (int j=0; j<tabuleiro[0].length; j++){
				if(tabuleiro[i][j]=='H'){
					hero3 = new Heroi(i,j);
					hero1 = new Heroi(i,j);
				} else if(tabuleiro[i][j]=='A'){
					hero3 = new Heroi(i,j); 
					hero3.setHeroWithClub(true);
					hero3.setLetter('A');
				} else if (tabuleiro[i][j]=='K'){
					hero3 = new Heroi(i,j); 
				    hero3.setHeroWithKey(true);
				    hero3.setLetter('K');
				} else if(tabuleiro[i][j]=='O'){
					Ogre ogre = new Ogre(i,j);
					ogres.add(ogre);	
					ogreNumber++;
				} else if(tabuleiro[i][j]=='k'){
					for(Ogre x:ogres){
						x.setKeyPosition(i, j);
					}
				} else if(tabuleiro[i][j]=='+'){
					for(Ogre x:ogres){
						x.setArmPosition(i, j);
					}
				} else if(tabuleiro[i][j]=='G'){
					nivel=4;
					board1.setBoard(tabuleiro);
					if (type.equals("Rookie")){
						guard3=new Rookie(1,8);
						guard3.setposXY(i, j);
					} else if (type.equals("Drunken")){
						guard3=new Drunken(1,8);
						guard3.setposXY(i, j);
					} else if (type.equals("Suspicious")){
						guard3=new Suspicious(1,8);
						guard3.setposXY(i, j);
					}
					
				}
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

	public int level2(char dir, ArrayList <Ogre> ogrezz, int numOgres){

			hero2.Movimento(dir, 2, board2);
			if(loose.WinOrLoose((ogrezz.get(0)).getLetter(), board2, hero2)==1){return 4;}
			if(levelTwoLoose(ogrezz)){return -2;}
			
			for(int i=0; i<numOgres; i++){
				(ogrezz.get(i)).Movimento(2, board2, hero2.herowithclub, hero2.herowithkey);
			}
			if(levelTwoLoose(ogrezz)){return -2;}
			
			return 3;
	}
	
	public boolean levelTwoLoose(ArrayList <Ogre> ogrezz){
		if(!hero2.herowithclub){
			if(loose.WinOrLoose((ogrezz.get(0)).getLetter(), board2, hero2)==-1){return true;}
			if(loose.WinOrLoose('$', board2, hero2)==-1){return true;}
		}
		if(loose.WinOrLoose('*', board2, hero2)==-1){return true;}
		if(board2.searchElement(hero2.getX(), hero2.getY()) == '*'){return true;}	
		return false;
	}

	public int level3(char dir, ArrayList <Ogre> ogrezz, int numOgres){

		hero3.Movimento(dir, 2, board3);
		if(loose.WinOrLoose((ogrezz.get(0)).getLetter(), board3, hero3)==1){return 6;}
		if(ogreLevel3Loose(ogrezz)){return -3;}
		 

		for(int i=0; i<numOgres; i++){
			(ogrezz.get(i)).Movimento(2, board3, hero3.herowithclub, hero3.herowithkey);
		}
		if(ogreLevel3Loose(ogrezz)){return -3;}
		
		return 5;
} 
	
	public boolean ogreLevel3Loose(ArrayList <Ogre> ogrezz){
		if(!hero3.herowithclub){
			if(loose.WinOrLoose((ogrezz.get(0)).getLetter(), board3, hero3)==-1){return true;}
			if(loose.WinOrLoose('$', board3, hero3)==-1){return true;}
		}
		if(loose.WinOrLoose('*', board3, hero3)==-1){return true;}
		if(board3.searchElement(hero3.getX(), hero3.getY()) == '*'){return true;}	
		return false;
	}	
	
	public int jogo(char direc, String guardType, int numOgres){
		
		if (nivel !=4){
			Guard guarda=iniciateBadCaracters(guardType);
			if (nivel==1){
				tabuleiro = board1.board;
				estado = level1(direc, guarda); 
				if(estado==2){
					tabuleiro = board2.board;
					nivel=2;
				}
			}
			else if (nivel==2){estado = level2(direc, ogres, numOgres);}
			else if (nivel==3){estado = level3(direc, ogres, numOgres);}
		} else {
			if (nivel == 4){
				estado = level1(direc, guard3); 
				if(estado==2){
					tabuleiro = board2.board;
					nivel=2;
				}
			} 
		}

		
		return estado;
	}
	
	public Guard iniciateBadCaracters(String guardType){
		ogres.add(ogre);
		ogres.add(ogre1);
		ogres.add(ogre2);
		ogres.add(ogre3);
		ogres.add(ogre4);
		Guard guarda = null;

		if(guardType=="Suspicious"){guarda=suspicious;}
		else if(guardType=="Rookie"){guarda=rookie;}
		else if(guardType=="Drunken"){guarda=drunken;}
		
		return guarda;
	}
}
