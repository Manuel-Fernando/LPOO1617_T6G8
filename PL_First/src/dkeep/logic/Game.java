package dkeep.logic;

import java.util.ArrayList;

/**
 * Classe que guarda o jogo
 * @author Carolina e Manuel
 *
 */
public class Game {

	/**
	 * Mapa do nível 1
	 */
	MapLevel1 board1 = new MapLevel1();
	
	/**
	 * Mapa do nível 2
	 */
	MapLevel2 board2 = new MapLevel2();
	
	/**
	 * Mapa do nível criado pelo utilzador/ lido do ficheiro
	 */
	MapLevel3 board3 = new MapLevel3();
	
	/**
	 * Estado de jogo
	 */
	GameState loose = new GameState();

	/**
	 * Guarda do tipo Rookie
	 */
	Guard rookie = new Rookie(1,8);
	
	/**
	 * Guarda do tipo Suspicious
	 */
	Guard suspicious = new Suspicious(1,8);
	
	/**
	 * Guarda do tipo Drunken
	 */
	Guard drunken = new Drunken(1,8);
	
	/**
	 * Guarda para o jogo lido do ficheiro
	 */
	Guard guard3;

	/**
	 * Heroi para o nível 1
	 */
	Heroi hero1 = new Heroi(1,1);
	
	/**
	 * Heroi para o nível 2
	 */
	Heroi hero2 = new Heroi(7,1);
	
	/**
	 * Heroi para o jogo lido do ficheiro
	 */
	Heroi hero3;

	/**
	 * Ogre
	 */
	Ogre ogre = new Ogre(1,4); 
	
	/**
	 * Ogre
	 */
	Ogre ogre1 = new Ogre(1,4);
	
	/**
	 * Ogre
	 */
	Ogre ogre2 = new Ogre(1,4);
	
	/**
	 * Ogre
	 */
	Ogre ogre3 = new Ogre(1,4);
	
	/**
	 * Ogre
	 */
	Ogre ogre4 = new Ogre(1,4);

	/**
	 * Números de ogres do jogo
	 */
	int ogreNumber=0;

	/**
	 * ArrayList com os ogres de jogo
	 */
	ArrayList <Ogre> ogres = new ArrayList <Ogre>(5);

	/**
	 * Nível de jogo
	 */
	int nivel = 1;
	
	/**
	 * Estado do jogo
	 */
	int estado = 0;

	/**
	 * Mapa de jogo
	 */
	char[][] tabuleiro = board1.board;

	/**
	 * Método que retorna o mapa de jogo
	 * @return char[][] com o mapa de jogo
	 */
	public char[][] getTabuleiro(){
		return tabuleiro;
	}

	/**
	 * Método que retorna a mapa de jogo do nível 1
	 * @return char [][] com o mapa de jogo do nível 1
	 */
	public char[][] tabuleiro1(){
		return board1.board;
	}

	/**
	 * Método que retorna o mapa de jogo do nível 2
	 * @return char [][] com o mapa de jogo do nível 2
	 */
	public char[][] tabuleiro2(){
		return board2.board;
	}

	/**
	 * Método que retorna o número de ogres do jogo
	 * @return inteiro com o número de ogres
	 */
	public int ogreNumber(){
		return ogreNumber;
	}

	/**
	 * Método que dado um mapa de jogo inicializaas personagens na posição correta
	 * @param t char [][] com o mapa de jogo
	 * @param type String com o tipo de guarda
	 */
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

	/**
	 * Método com a lógica de jogo para o nível 1
	 * @param dir char com a direção de movimento
	 * @param g Guard com o guarda do jogo
	 * @return inteiro com o estado de jogo (2 se o jogo continua; -1 se o jogo acaba)
	 */
	public int level1(char dir, Guard g){		

		hero1.Movimento(dir, 1, board1);
		if(loose.WinOrLoose(g.getLetter(), board1, hero1)==1){return 2;}
		if(loose.WinOrLoose(g.getLetter(), board1, hero1)==-1){return -1;}
		g.Movimento(1, board1);	

		if(loose.WinOrLoose(g.getLetter(), board1, hero1)==-1){return -1;}

		return 1;

	}

	/**
	 * Método para a lógica de jogo do nível 2
	 * @param dir char com a direção de movimento
	 * @param ogrezz ArrayList de tipo Ogre com os ogres do jogo
	 * @param numOgres inteiro com o número de ogres
	 * @return inteiro com o estado de jogo (4 se o jogo continua; -2 se o jogo terminar)
	 */
	public int level2(char dir, ArrayList <Ogre> ogrezz, int numOgres){

		hero2.Movimento(dir, 2, board2);
		if(loose.WinOrLoose((ogrezz.get(0)).getLetter(), board2, hero2)==1){return 4;}
		if(levelTwoLoose(ogrezz)){return -2;}

		for(int i=0; i<numOgres; i++){
			boolean heroPackage[]={hero2.herowithclub,hero2.herowithkey};
			(ogrezz.get(i)).Movimento(2, board2, heroPackage);
		}
		if(levelTwoLoose(ogrezz)){return -2;}

		return 3; 
	}

	/**
	 * Método que verifica o estado de jogo para o nível 2
	 * @param ogrezz ArrayList do tipo Ogre com os ogres do jogo
	 * @return boolean true se o jogo termina
	 */
	public boolean levelTwoLoose(ArrayList <Ogre> ogrezz){
		if(!hero2.herowithclub){
			if(loose.WinOrLoose((ogrezz.get(0)).getLetter(), board2, hero2)==-1){return true;}
			if(loose.WinOrLoose('$', board2, hero2)==-1){return true;}
		}
		if(loose.WinOrLoose('*', board2, hero2)==-1){return true;}
		if(board2.searchElement(hero2.getX(), hero2.getY()) == '*'){return true;}	
		return false;
	}

	/**
	 * Método para a lógica de jogo do nível criado pelo utilizador
	 * @param dir char com a direção de movimento
	 * @param ogrezz ArrayList do tipo Ogre com os ogres do jogo
	 * @param numOgres inteiro com o número de ogres
	 * @return inteiro com o estado do jogo (6 se o jogo continua; -3 se o jogo acaba)
	 */
	public int level3(char dir, ArrayList <Ogre> ogrezz, int numOgres){

		hero3.Movimento(dir, 2, board3);
		if(loose.WinOrLoose((ogrezz.get(0)).getLetter(), board3, hero3)==1){return 6;}
		if(ogreLevel3Loose(ogrezz)){return -3;}


		for(int i=0; i<numOgres; i++){
			boolean heroPackage[]={hero3.herowithclub,hero3.herowithkey};
			(ogrezz.get(i)).Movimento(2, board3, heroPackage);
		}
		if(ogreLevel3Loose(ogrezz)){return -3;}

		return 5;
	} 

	/**
	 * Método para verificar o estado de jogo do nível criado pelo utilizador
	 * @param ogrezz ArrayLis do tipo Ogre com os ogres de jogo
	 * @return boolean true caso o jogo termine
	 */
	public boolean ogreLevel3Loose(ArrayList <Ogre> ogrezz){
		if(!hero3.herowithclub){
			if(loose.WinOrLoose((ogrezz.get(0)).getLetter(), board3, hero3)==-1){return true;}
			if(loose.WinOrLoose('$', board3, hero3)==-1){return true;}
		}
		if(loose.WinOrLoose('*', board3, hero3)==-1){return true;}
		if(board3.searchElement(hero3.getX(), hero3.getY()) == '*'){return true;}	
		return false;
	}	
	
	/**
	 * Método que aplica as lógicas de jogo tendo em conta o nível 
	 * @param direc char com a direção de movimento
	 * @param guardType String com o tipo de guarda
	 * @param numOgres inteiro com o número de ogres
	 * @return inteiro com o estado de jogo
	 */
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

	/**
	 * Método que inicializa os guardas e ogres do jogo
	 * @param guardType String com o tipo de guarda
	 * @return Guard com o guarda inicializado
	 */
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
