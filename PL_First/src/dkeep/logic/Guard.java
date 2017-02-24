package dkeep.logic;

public class Guard extends Entidade{

	
	public Guard(int PosXi, int PosYi){
		posX=PosXi;
		posY=PosYi;
		letter='G';
	}
	
	int i=0;
	char guardtraject[] = {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};
	public void direcao (int posinX, int posinY, Map m, int mapLevel ){
	
		if ((m.searchElement(posinX, posinY) != 'X') && ((m.searchElement(posinX, posinY) != 'I'))){
			
			m.writeElement(posX, posY, ' ');
			posX=posinX;
			posY=posinY;
			m.writeElement(posX, posY, letter);
				
		}
	}
	public void Movimento(int mapLevel, Map m){
		
		char dir=guardtraject[i];
		i++;
		if(i==guardtraject.length){i=0;}
		
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
