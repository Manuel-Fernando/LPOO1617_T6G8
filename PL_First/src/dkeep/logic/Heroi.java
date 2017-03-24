package dkeep.logic;

public class Heroi extends Entidade{
	
	public Heroi(int PosXi, int PosYi){
		pos[0]=PosXi;
		pos[1]=PosYi;
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
							
							int []posij = {i,j};
							
							m.writeElement(posij, 'S');
						}
					}			
				}
			}
			
			m.writeElement(pos, ' ');
			pos[0]=posinX;
			pos[1]=posinY;
			m.writeElement(pos, letter);
		
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
		} else if (m.searchElement(posinX, posinY) != 'I') { 
			m.writeElement(pos, ' ');
			pos[0]=posinX;
			pos[1]=posinY;
			m.writeElement(pos, letter);
		}
		
	}
	
	public void openDoorLevel2 (Map m, int posinX, int posinY){
		if (count == 1){
			m.writeElement(pos, ' ');
			pos[0]=posinX;
			pos[1]=posinY;
			m.writeElement(pos, letter);
		} else {
			count=1;
			for (int i=0; i<m.board.length; i++){
				for (int j=0; j<m.board[0].length; j++){
					if(m.searchElement(i, j)=='I' && i==posinX && j==posinY){
						int []posij = {i,j};
						m.writeElement(posij, 'S');
					}
				}			
			}
		}
	}

	public void Movimento(char dir, int mapLevel, Map m){

		switch (dir){
		case 'w':
			direcao (pos[0]-1, pos[1], m, mapLevel);
			break;
		case 'a':
			direcao (pos[0], pos[1]-1, m, mapLevel);
			break;
		case 'd':
			direcao (pos[0], pos[1]+1, m, mapLevel);
			break;
		case 's':
			direcao (pos[0]+1, pos[1], m, mapLevel);
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
