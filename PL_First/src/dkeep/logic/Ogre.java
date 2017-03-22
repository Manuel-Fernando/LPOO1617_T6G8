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
	
	private boolean findHero(Map m, int x, int y){
		if((m.searchElement(x+1, y) == 'H') || (m.searchElement(x, y+1) == 'H') || (m.searchElement(x-1, y) == 'H') || (m.searchElement(x, y-1) == 'H')){return true;}
		if((m.searchElement(x+1, y) == 'A') || (m.searchElement(x, y+1) == 'A') || (m.searchElement(x-1, y) == 'A') || (m.searchElement(x, y-1) == 'A')){return true;}
		if((m.searchElement(x+1, y) == 'K') || (m.searchElement(x, y+1) == 'K') || (m.searchElement(x-1, y) == 'K') || (m.searchElement(x, y-1) == 'K')){return true;}
		return false;
	}
	
	int posXclub=3;
	int posYclub=3;
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
			if(findHero(m, posX, posY) && herowithclub){
				dontmove=1;
			}
			
			// posicao igual a antiga
			if(dontmove==1 || dontmove==2){
				dontmove++;
				posin[0]=posX;
				posin[1]=posY;
				letter='8';
			}

			//escrever posicao nova
			if (posin[0]==keyPosx && posin[1]==keyPosy && !herowithkey){
				m.writeElement(posin[0], posin[1], '$');
			}else {
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


		char direction=freeClubSpace(m);
		switch (direction){
		case 'w':
			posXclub=posX-1;
			posYclub=posY;
			break;
		case 'a':
			posXclub=posX;
			posYclub=posY-1;
			break;
		case 'd':
			posXclub=posX;
			posYclub=posY+1;
			break;
		case 's':
			posXclub=posX+1;
			posYclub=posY;
			break;			
		}
		if (posXclub == keyPosx && posYclub == keyPosy && !herowithkey){m.writeElement(posXclub, posYclub, '$');
		}else m.writeElement(posXclub, posYclub, '*'); 

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
		if (posXclub==keyPosx && posYclub==keyPosy && !herowithkey && !(posX==keyPosx && posY==keyPosy)){
			m.writeElement(posXclub, posYclub, 'k');
		}else if(posXclub==armPosx && posYclub==armPosy && !herowithclub && !(posX==armPosx && posY==armPosy)){
			m.writeElement(posXclub, posYclub, '+');
		}else if(!(posXclub==posX && posYclub==posY)){
			m.writeElement(posXclub, posYclub, ' ');
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
		int pos[]={0,0};

		switch (dir){
		case 'w':
			pos[0]=posX-1;
			pos[1]=posY;
			break;
		case 'a':
			pos[0]=posX;
			pos[1]=posY-1;
			break;
		case 'd':
			pos[0]=posX;
			pos[1]=posY+1;
			break;
		case 's':
			pos[0]=posX+1;
			pos[1]=posY;
			break;			
		}
		if ((m.searchElement(pos[0], pos[1]) != 'X') && ((m.searchElement(pos[0], pos[1]) != 'I'))){direcao (pos, m, heroclub, herokey);}
		clubDirection(m, heroclub, herokey);
		return dir;
	}
}	
