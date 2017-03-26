package dkeep.logic;

import java.util.Random;

/**
 * Classe que guarda personagens do tipo Ogre
 * @author Carolina e Manuel
 *
 */
public class Ogre extends Entidade{

	/**
	 * Posição em x para a chave
	 */
	private int keyPosx=1;
	
	/**
	 * Posição em y para a chave
	 */
	private int keyPosy=7;
	
	/**
	 * Posição em x para a armadura
	 */
	private int armPosx=7;
	
	/**
	 * Posição em y para a armadura
	 */
	private int armPosy=5;
	
	/**
	 * Contrutor que cria o ogre numa determinada posição
	 * @param PosXi inteiro para a posição em x
	 * @param PosYi inteiro para a posição em y
	 */
	public Ogre(int PosXi, int PosYi){
		pos[0]=PosXi;
		pos[1]=PosYi; 
		letter='O';
	}
	
	/**
	 * Método para guardar a posição da chave no mapa de jogo
	 * @param keyPosxi inteiro com a posição em x da chave
	 * @param keyPosyi inteiro com a posição em y da chave
	 */
	public void setKeyPosition(int keyPosxi, int keyPosyi){
		keyPosx=keyPosxi;
		keyPosy=keyPosyi; 
	}
	
	/**
	 * Método para guardar a posição da armadura no mapa de jogo
	 * @param armPosxi inteiro para a posição em x d aarmadura
	 * @param armPosyi inteiro para a posição em y da armadura
	 */
	public void setArmPosition(int armPosxi,int armPosyi){
		armPosx=armPosxi;
		armPosy=armPosyi;
	}
	
	/**
	 * Método para definir aleatóriamente a direção de movimento do ogre
	 * @return char com a direção de movimento
	 */
	private char randomdirection(){
		Random rn = new Random();
		int range = 4 - 1 + 1;
		int randomNum =  rn.nextInt(range) + 1;

		if (randomNum==1){return 'w';}
		else if (randomNum==2){return 'a';}
		else if (randomNum==3){return 's';} 
		else if (randomNum==4){return 'd';}
		
		return ' ';
	}
	
	/**
	 * Método para procurar o heroi numa posição adjacente ao ogre
	 * @param m Map com o mapa de jogo
	 * @param x inteiro com a posição x do ogre
	 * @param y inteiro coma posição y do ogre
	 * @return true se o heroi estiver numa posição adjacente ao ogre
	 */
	public boolean findHero(Map m, int x, int y){
		if((m.searchElement(x+1, y) == 'H') || (m.searchElement(x, y+1) == 'H') || (m.searchElement(x-1, y) == 'H') || (m.searchElement(x, y-1) == 'H')){return true;}
		if((m.searchElement(x+1, y) == 'A') || (m.searchElement(x, y+1) == 'A') || (m.searchElement(x-1, y) == 'A') || (m.searchElement(x, y-1) == 'A')){return true;}
		if((m.searchElement(x+1, y) == 'K') || (m.searchElement(x, y+1) == 'K') || (m.searchElement(x-1, y) == 'K') || (m.searchElement(x, y-1) == 'K')){return true;}
		return false;
	}
	
	/**
	 * Posição do club
	 */
	private int posClub[]={3,3};
	
	/**
	 * Contador para parar o ogre
	 */
	private int dontmove=0;
	
	/**
	 * Método mover o ogre para uma determinada posição e caso o heroi tenha armadura não move o ogre
	 * @param posin posição em x e y para onde o ogre se vai mover
	 * @param m Map com o mapa de jogo
	 * @param heroPachage boolean[] com true na posição 0 se o heroi tem armadura e true na posição 1 se o heroi tem chave
	 */
	private void direcao (int posin[], Map m, boolean[] heroPachage){
	
			//se ja passaram as duas jogadas, liberta o ogre
			if(dontmove==3){
				dontmove=0;
				letter='O';
				heroPachage[0]=false;
			}
			 
			//apagar posicao antiga
			clearOldOgrePosition(m, heroPachage);
			
			//se heroi a beira com taco reinicia contagem
			if(findHero(m, pos[0], pos[1]) && heroPachage[0]){ dontmove=1;}
			
			// posicao igual a antiga
			if(dontmove==1 || dontmove==2){
				dontmove++;
				posin[0]=pos[0];
				posin[1]=pos[1];
				letter='8';
			}

			//escrever posicao nova
			writeOgreNewPosition(posin, m, heroPachage);	
	}
	
	/**
	 * Método que coloca o ogre na nova posição do tabuleiro.
	 * @param posin posição em x e y para onde o ogre se vai mover
	 * @param m Map com o mapa de jogo
	 * @param heroPachage boolean[] com true na posição 0 se o heroi tem armadura e true na posição 1 se o heroi tem chave
	 */
	public void writeOgreNewPosition(int posin[], Map m, boolean[] heroPachage){
		if (posin[0]==keyPosx && posin[1]==keyPosy && !heroPachage[1]){m.writeElement(posin, '$');}
		else {
			if(findHero(m, posin[0], posin[1]) && heroPachage[0]){
				dontmove=1;
				letter='8';
			} 
			m.writeElement(posin, letter);
			
		}
		pos[0]=posin[0];
		pos[1]=posin[1];
		
	}
	
	//Club part

	/**
	 * Método para mover o club à volta do ogre
	 * @param m Map com o mapa de jogo
	 * @param heroPachage boolean[] com true na posição 0 se o heroi tem armadura e true na posição 1 se o heroi tem chave
	 */
	private void clubDirection(Map m, boolean[] heroPachage){

		//apagar posicao antiga
		clearOldClubPosition(m, heroPachage);
		
		posClub[0]=pos[0];
		posClub[1]=pos[1];
		switch (freeClubSpace(m)){
		case 'w':
			posClub[0]=pos[0]-1;
			break;
		case 'a':
			posClub[1]=pos[1]-1;
			break;
		case 'd':
			posClub[1]=pos[1]+1;
			break;
		case 's':
			posClub[0]=pos[0]+1;
			break;			
		}
		if (posClub[0] == keyPosx && posClub[1] == keyPosy && !heroPachage[1]){m.writeElement(posClub, '$');
		}else m.writeElement(posClub, '*'); 
	} 

	/**
	 * Método para verificar se o club pode mover-se para uma determinada posição
	 * @param m Map com o mapa de jogo
	 * @return char com a direção na qual o club se vai mover
	 */
	public char freeClubSpace(Map m){
		char direction=randomdirection();
		while((direction=='w' && (m.searchElement(pos[0]-1, pos[1])=='X' || m.searchElement(pos[0]-1, pos[1])=='I'))||
				(direction=='a' && (m.searchElement(pos[0], pos[1]-1)=='X' || m.searchElement(pos[0], pos[1]-1)=='I'))||
				(direction=='d' && (m.searchElement(pos[0], pos[1]+1)=='X' || m.searchElement(pos[0], pos[1]+1)=='I'))||
				(direction=='s' && (m.searchElement(pos[0]+1, pos[1])=='X' || m.searchElement(pos[0]+1, pos[1])=='I'))){
			direction=randomdirection();
		}
		return direction;
	}

	/**
	 * Método para apagar a posição anterior do club
	 * @param m Map com o mapa de jogo
	 * @param heroPachage boolean[] com true na posição 0 se o heroi tem armadura e true na posição 1 se o heroi tem chave
	 */
	public void clearOldClubPosition(Map m, boolean[] heroPachage){
		if (posClub[0]==keyPosx && posClub[1]==keyPosy && !heroPachage[1] && !(pos[0]==keyPosx && pos[1]==keyPosy)){
			m.writeElement(posClub, 'k');
		}else if(posClub[0]==armPosx && posClub[1]==armPosy && !heroPachage[0] && !(pos[0]==armPosx && pos[1]==armPosy)){
			m.writeElement(posClub, '+');
		}else if(!(posClub[0]==pos[0] && posClub[1]==pos[1])){
			m.writeElement(posClub, ' ');
		}

	}

	/**
	 * Método para apagar a posição anterior do ogre
	 * @param m Map com o mapa de jogo
	 * @param heroPachage boolean[] com true na posição 0 se o heroi tem armadura e true na posição 1 se o heroi tem chave
	 */
	public void clearOldOgrePosition(Map m, boolean[] heroPachage){
		if (pos[0]==keyPosx && pos[1]== keyPosy && !heroPachage[1]){
			m.writeElement(pos, 'k');
		}else if(pos[0]==armPosx && pos[1]==armPosy && !heroPachage[0]){
			m.writeElement(pos, '+');
		}else if(m.searchElement(pos[0], pos[1]) != '*') {
			m.writeElement(pos, ' ');
		}

	}


	/**
	 * Método para movimentar o ogre
	 * @param mapLevel inteiro com o nível de jogo
	 * @param m Map com o mapa de jogo
	 * @param heroPackage boolean[] com true na posição 0 se o heroi tem armadura e true na posição 1 se o heroi tem chave
	 * @return char com a direção
	 */
	public char Movimento(int mapLevel, Map m, boolean[] heroPackage){

		char dir=randomdirection();
		int pos2[]={pos[0],pos[1]};

		switch (dir){
		case 'w':
			pos2[0]=pos[0]-1;
			break;
		case 'a':
			pos2[1]=pos[1]-1;
			break;
		case 'd':
			pos2[1]=pos[1]+1;
			break;
		case 's':
			pos2[0]=pos[0]+1;
			break;			
		}
		if ((m.searchElement(pos2[0], pos2[1]) != 'X') && ((m.searchElement(pos2[0], pos2[1]) != 'I'))){direcao (pos2, m, heroPackage);}
		clubDirection(m, heroPackage);
		return dir;
	}
}	
