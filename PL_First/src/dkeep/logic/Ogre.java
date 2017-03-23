package dkeep.logic;

import java.util.Random;

public class Ogre extends Entidade{

	int keyPosx=1;
	int keyPosy=7;
	int armPosx=7;
	int armPosy=5;
	
	public Ogre(int PosXi, int PosYi){
		posX=PosXi;
		posY=PosYi; 
		letter='O';
	}
	
	public void setKeyPosition(int keyPosxi, int keyPosyi){
		keyPosx=keyPosxi;
		keyPosy=keyPosyi; 
	}
	
	public void setArmPosition(int armPosxi,int armPosyi){
		armPosx=armPosxi;
		armPosy=armPosyi;
	}
	
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
	
	public boolean findHero(Map m, int x, int y){
		if((m.searchElement(x+1, y) == 'H') || (m.searchElement(x, y+1) == 'H') || (m.searchElement(x-1, y) == 'H') || (m.searchElement(x, y-1) == 'H')){return true;}
		if((m.searchElement(x+1, y) == 'A') || (m.searchElement(x, y+1) == 'A') || (m.searchElement(x-1, y) == 'A') || (m.searchElement(x, y-1) == 'A')){return true;}
		if((m.searchElement(x+1, y) == 'K') || (m.searchElement(x, y+1) == 'K') || (m.searchElement(x-1, y) == 'K') || (m.searchElement(x, y-1) == 'K')){return true;}
		return false;
	}
	
	int posClub[]={3,3};
	int dontmove=0;
	
	private void direcao (int posin[], Map m, boolean herowithclub, boolean herowithkey){
	
			//se ja passaram as duas jogadas, liberta o ogre
			if(dontmove==3){
				dontmove=0;
				letter='O';
			}
			 
			//apagar posicao antiga
			clearOldOgrePosition(m, herowithclub, herowithkey);
			
			//se heroi a beira com taco reinicia contagem
			if(findHero(m, posX, posY) && herowithclub){ dontmove=1;}
			
			// posicao igual a antiga
			if(dontmove==1 || dontmove==2){
				dontmove++;
				posin[0]=posX;
				posin[1]=posY;
				letter='8';
			}

			//escrever posicao nova
			writeOgreNewPosition(posin, m, herowithclub, herowithkey);	
	}
	
	public void writeOgreNewPosition(int posin[], Map m, boolean herowithclub, boolean herowithkey){
		if (posin[0]==keyPosx && posin[1]==keyPosy && !herowithkey){m.writeElement(posin[0], posin[1], '$');}
		else {
			if(findHero(m, posin[0], posin[1]) && herowithclub){
				dontmove=1;
				letter='8';
			}
			m.writeElement(posin[0], posin[1], letter);
		}
		posX=posin[0];
		posY=posin[1];
		
	}
	
	//Club part

	private void clubDirection(Map m, boolean herowithclub, boolean herowithkey){

		//apagar posicao antiga
		clearOldClubPosition(m, herowithclub, herowithkey);
		
		posClub[0]=posX;
		posClub[1]=posY;
		switch (freeClubSpace(m)){
		case 'w':
			posClub[0]=posX-1;
			break;
		case 'a':
			posClub[1]=posY-1;
			break;
		case 'd':
			posClub[1]=posY+1;
			break;
		case 's':
			posClub[0]=posX+1;
			break;			
		}
		if (posClub[0] == keyPosx && posClub[1] == keyPosy && !herowithkey){m.writeElement(posClub[0], posClub[1], '$');
		}else m.writeElement(posClub[0], posClub[1], '*'); 
	} 

	public char freeClubSpace(Map m){
		char direction=randomdirection();
		while((direction=='w' && (m.searchElement(posX-1, posY)=='X' || m.searchElement(posX-1, posY)=='I'))||
				(direction=='a' && (m.searchElement(posX, posY-1)=='X' || m.searchElement(posX, posY-1)=='I'))||
				(direction=='d' && (m.searchElement(posX, posY+1)=='X' || m.searchElement(posX, posY+1)=='I'))||
				(direction=='s' && (m.searchElement(posX+1, posY)=='X' || m.searchElement(posX+1, posY)=='I'))){
			direction=randomdirection();
		}
		return direction;
	}

	public void clearOldClubPosition(Map m, boolean herowithclub, boolean herowithkey){
		if (posClub[0]==keyPosx && posClub[1]==keyPosy && !herowithkey && !(posX==keyPosx && posY==keyPosy)){
			m.writeElement(posClub[0], posClub[1], 'k');
		}else if(posClub[0]==armPosx && posClub[1]==armPosy && !herowithclub && !(posX==armPosx && posY==armPosy)){
			m.writeElement(posClub[0], posClub[1], '+');
		}else if(!(posClub[0]==posX && posClub[1]==posY)){
			m.writeElement(posClub[0], posClub[1], ' ');
		}

	}

	public void clearOldOgrePosition(Map m, boolean herowithclub, boolean herowithkey){
		if (posX==keyPosx && posY== keyPosy && !herowithkey){
			m.writeElement(posX, posY, 'k');
		}else if(posX==armPosx && posY==armPosy && !herowithclub){
			m.writeElement(posX, posY, '+');
		}else if(m.searchElement(posX, posY) != '*') {
			m.writeElement(posX, posY, ' ');
		}

	}


	public char Movimento(int mapLevel, Map m, boolean heroclub, boolean herokey){

		char dir=randomdirection();
		int pos[]={posX,posY};

		switch (dir){
		case 'w':
			pos[0]=posX-1;
			break;
		case 'a':
			pos[1]=posY-1;
			break;
		case 'd':
			pos[1]=posY+1;
			break;
		case 's':
			pos[0]=posX+1;
			break;			
		}
		if ((m.searchElement(pos[0], pos[1]) != 'X') && ((m.searchElement(pos[0], pos[1]) != 'I'))){direcao (pos, m, heroclub, herokey);}
		clubDirection(m, heroclub, herokey);
		return dir;
	}
}	
