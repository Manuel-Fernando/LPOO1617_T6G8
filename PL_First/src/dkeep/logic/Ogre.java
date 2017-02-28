package dkeep.logic;

import java.util.Random;

public class Ogre extends Entidade{

	
	public Ogre(int PosXi, int PosYi){
		posX=PosXi;
		posY=PosYi;
		letter='O';
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
	
	private void direcao (int posinX, int posinY, Map m, boolean herowithclub, boolean herowithkey){
	
		if ((m.searchElement(posinX, posinY) != 'X') && ((m.searchElement(posinX, posinY) != 'I'))){
			//se ja passaram as duas jogadas, liberta o ogre
			if(dontmove==3){
				dontmove=0;
				letter='O';
			}
			
			//apagar posicao antiga
			if (posX==1 && posY==7 && !herowithkey){
				m.writeElement(posX, posY, 'k');
			}else if(posX==7 && posY==5 && !herowithclub){
				m.writeElement(posX, posY, '+');
			}else if(m.searchElement(posX, posY) != '*') {
				m.writeElement(posX, posY, ' ');
			}
			
			//se heroi a beira com taco reinicia contagem
			if(findHero(m, posX, posY) && herowithclub){
				dontmove=1;
			}
			
			// posicao igual a antiga
			if(dontmove==1 || dontmove==2){
				dontmove++;
				posinX=posX;
				posinY=posY;
				letter='8';
			}
			
			//escrever posicao nova
			if (posinX==1 && posinY==7 && !herowithkey){
				m.writeElement(posinX, posinY, '$');
			}else {
				if(findHero(m, posinX, posinY) && herowithclub){
					dontmove=1;
					letter='8';
				}
				m.writeElement(posinX, posinY, letter);
			}
			
			posX=posinX;
			posY=posinY;

			
			
			
			//Club part
			
			//apagar posicao antiga
			if (posXclub==1 && posYclub==7 && !herowithkey && !(posX==1 && posY==7)){
				m.writeElement(posXclub, posYclub, 'k');
			}else if(posXclub==7 && posYclub==5 && !herowithclub && !(posX==7 && posY==5)){
				m.writeElement(posXclub, posYclub, '+');
			}else if(!(posXclub==posX && posYclub==posY)){
				m.writeElement(posXclub, posYclub, ' ');
			}
			
			
			char direction=randomdirection();
			while((direction=='w' && posX==1)||(direction=='a' && posY==1)
				||(direction=='d' && posY==7)||(direction=='s' && posX==7)){
				direction=randomdirection();
			}
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
			if (posXclub == 1 && posYclub == 7 && !herowithkey){m.writeElement(posXclub, posYclub, '$');
			}else m.writeElement(posXclub, posYclub, '*'); 

		}
	}

	public void Movimento(int mapLevel, Map m, boolean heroclub, boolean herokey){
		
		char dir=randomdirection();
		
		switch (dir){
		case 'w':
			direcao (posX-1, posY, m, heroclub, herokey);
			break;
		case 'a':
			direcao (posX, posY-1, m, heroclub, herokey);
			break;
		case 'd':
			direcao (posX, posY+1, m, heroclub, herokey);
			break;
		case 's':
			direcao (posX+1, posY, m, heroclub, herokey);
			break;			
		}
	}
}	
