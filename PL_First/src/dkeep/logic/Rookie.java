package dkeep.logic;


public class Rookie extends comportamentoGuarda {

	public Rookie(int PosXi, int PosYi) {
		super(PosXi, PosYi);
		// TODO Auto-generated constructor stub
	}

	protected void Movimento (int mapLevel, Map m){
		
		char dir = guardtraject[i];
		i++;
		if (i==guardtraject.length){i=0;}
		
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
