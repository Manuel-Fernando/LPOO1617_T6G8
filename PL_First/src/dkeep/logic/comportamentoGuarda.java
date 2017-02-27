package dkeep.logic;


public class comportamentoGuarda extends Guard {

	public comportamentoGuarda(int PosXi, int PosYi) {
		super(PosXi, PosYi);
		// TODO Auto-generated constructor stub
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

}
