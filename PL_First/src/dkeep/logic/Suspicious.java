package dkeep.logic;

import java.util.Random;

public class Suspicious extends comportamentoGuarda {

	public Suspicious(int PosXi, int PosYi) {
		super(PosXi, PosYi);
	}

	int count=0;
	char dir;
	char[] guardInverse = {'d','w','w','w','w','d','d','d','d','d','d','w','a','a','a','a','a','a','a','s','s','s','s','s'};

	public String getName(){return "Suspicious";}

	public char Movimento (int mapLevel, Map m){

		Random rn = new Random();
		int range = 2 - 1 + 1;
		int randomNum =  rn.nextInt(range) + 1;

		if (randomNum==1){ // anda para a frente
			
			dir = guardtraject[i];
			i++;
			if (i==guardtraject.length){i=0;}
			count++;

		} else {  // anda para trás
			
			if (i==0){
				i=23;
				dir = guardInverse[i];
			} else {
				i--;
				dir = guardInverse[i];
			}
			
			count++;
		}		
		
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
		
		return dir;
	}

}
