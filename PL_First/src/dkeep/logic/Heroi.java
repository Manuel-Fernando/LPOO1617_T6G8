package dkeep.logic;

public class Heroi extends Entidade{

	
	public Heroi(int PosXi, int PosYi){
		posX=PosXi;
		posY=PosYi;
		letter='H';
	}
	
	int count = 0;
	boolean herowithkey = false;
	boolean herowithclub = false;
	
	private void direcao (int posinX, int posinY, Map m, int mapLevel ){
		if ((m.searchElement(posinX, posinY) != 'X') && ((m.searchElement(posinX, posinY) != 'I') || herowithkey)){
			if (mapLevel == 1){direcaoMapLevel1(posinX, posinY, m);} 
			else if (mapLevel == 2) {direcaoMapLevel2(posinX, posinY, m);}
		}
	}
	 
	public void direcaoMapLevel1(int posinX, int posinY, Map m){					
			if (m.searchElement(posinX, posinY) == 'k') {
				for (int i=0; i<m.board.length; i++){
					for (int j=0; j<m.board[0].length; j++){
						if(m.searchElement(i, j)=='I' && j==0){
							m.writeElement(i, j, 'S');
						}
					}			
				}
			}
			m.writeElement(posX, posY, ' ');
			posX=posinX;
			posY=posinY;
			m.writeElement(posX, posY, letter);
		
	}

	public void direcaoMapLevel2(int posinX, int posinY, Map m){
		if (m.searchElement(posinX, posinY) == '+') {
			herowithclub = true;
			if(herowithkey){letter = 'K';
			}else
				letter = 'A';
		}
		if (m.searchElement(posinX, posinY) == 'k') {
			letter = 'K';
			herowithkey=true;
		}

		if (posinX == 0 || posinY == 0 || posinX == m.board.length-1|| posinY == m.board[0].length-1){
			openDoorLevel2 (m, posinX, posinY);
		} else { 
			m.writeElement(posX, posY, ' ');
			posX=posinX;
			posY=posinY;
			m.writeElement(posX, posY, letter);
		}
		
	}
	
	public void openDoorLevel2 (Map m, int posinX, int posinY){
		if (count == 1){
			m.writeElement(posX, posY, ' ');
			posX=posinX;
			posY=posinY;
			m.writeElement(posX, posY, letter);
		} else {
			count=1;
			for (int i=0; i<m.board.length; i++){
				for (int j=0; j<m.board[0].length; j++){
					if(m.searchElement(i, j)=='I'){
						m.writeElement(i, j, 'S');
					}
				}			
			}
		}
	}

	public void Movimento(char dir, int mapLevel, Map m){

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
	
	public boolean heroWithKey(){
		return herowithkey;
	}
	public boolean heroWithClub(){
		return herowithclub;
	}
	
	public void setHeroWithKey(boolean key){
		herowithkey = key;
	}
	
	public void setHeroWithClub(boolean arm){
		herowithclub = arm;
	}


}
