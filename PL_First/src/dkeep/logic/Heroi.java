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

			if (mapLevel == 1){						
				if (m.searchElement(posinX, posinY) == 'k') {
//					m.writeElement(6, 0, 'S');
//					m.writeElement(5, 0, 'S');
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

			} else if (mapLevel == 2) {

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

				if (posinX == 1 && posinY == 0){
					if (count == 1){
						m.writeElement(posX, posY, ' ');
						posX=posinX;
						posY=posinY;
						m.writeElement(posX, posY, letter);
					} else {
						count=1;
						m.writeElement(1, 0, 'S');
					}
				} else {
					m.writeElement(posX, posY, ' ');
					posX=posinX;
					posY=posinY;
					m.writeElement(posX, posY, letter);
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


}
