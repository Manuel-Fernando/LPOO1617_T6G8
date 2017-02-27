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
	
	int posXclub=3;
	int posYclub=3;
	
	private void direcao (int posinX, int posinY, Map m, int mapLevel ){
	
		if ((m.searchElement(posinX, posinY) != 'X') && ((m.searchElement(posinX, posinY) != 'I'))){
			
			if(m.searchElement(1, 7)=='$' && posX==1 && posY==7){
				m.writeElement(1, 7, 'k');
				letter = 'O';
			}else if (m.searchElement(1, 7)=='O'){m.writeElement(1, 7, ' ');}
			
			if(posX!=1 || posY!=7){m.writeElement(posX, posY, ' ');}
			if (posinX == 1 && posinY == 7 && ((m.searchElement(1, 7) == 'k' || m.searchElement(1, 7) == '*'))){letter = '$';} 
			
			posX=posinX;
			posY=posinY;
			m.writeElement(posX, posY, letter);
			
			//Club part
			
			if(m.searchElement(1, 7)=='$' && posXclub==1 && posYclub==7 && (posX!=1 || posY!=7)){m.writeElement(1, 7, 'k');
			}else if (m.searchElement(1, 7)=='*'){m.writeElement(1, 7, ' ');}
			
			if((posXclub!=1 || posYclub!=7) && m.searchElement(posXclub, posYclub)=='*'){m.writeElement(posXclub, posYclub, ' ');}
			
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
			if (posXclub == 1 && posYclub == 7 && ((m.searchElement(1, 7) == 'k' || m.searchElement(1, 7) == '*'))){m.writeElement(posXclub, posYclub, '$');
			}else m.writeElement(posXclub, posYclub, '*'); 
				
		}
	}
	
	public void Movimento(int mapLevel, Map m){
		
		char dir=randomdirection();
		
		switch (dir){
		case 'w':
			direcao (posX-1, posY, m, mapLevel);
			break;
		case 'a':
			direcao (posX, posY-1, m, mapLevel);
			break;
		case 'd':
			direcao (posX, posY+1, m, mapLevel);
			break;
		case 's':
			direcao (posX+1, posY, m, mapLevel);
			break;			
		}
	}
}	
