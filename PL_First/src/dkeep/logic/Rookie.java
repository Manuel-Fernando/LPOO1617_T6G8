package dkeep.logic;


public class Rookie extends comportamentoGuarda {

	public Rookie(int PosXi, int PosYi) {
		super(PosXi, PosYi);
	}

	public char Movimento (int mapLevel, Map m){
		
		char dir = guardtraject[i];
		i++;
		if (i==guardtraject.length){i=0;}
		
		movete(dir, mapLevel, m);
		
		return dir;
		
	}

}
