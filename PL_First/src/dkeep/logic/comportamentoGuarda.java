package dkeep.logic;


public class comportamentoGuarda extends Guard {

	public comportamentoGuarda(int PosXi, int PosYi) {
		super(PosXi, PosYi);
		
	}

	int i=0;
	char guardtraject[] = {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};

	protected void movimento(){}
	
	protected void direcao (int posinX, int posinY, Map m, int mapLevel ){
		
		if ((m.searchElement(posinX, posinY) != 'X') && ((m.searchElement(posinX, posinY) != 'I'))){
			
			m.writeElement(posX, posY, ' ');
			posX=posinX;
			posY=posinY;
			m.writeElement(posX, posY, letter);
				
		}
	}
	
	protected void movete(char dir, int mapLevel, Map m){
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
