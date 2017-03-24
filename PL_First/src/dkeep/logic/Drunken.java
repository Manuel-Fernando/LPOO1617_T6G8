package dkeep.logic;

import java.util.Random;

public class Drunken extends comportamentoGuarda{

	public Drunken(int PosXi, int PosYi) {
		super(PosXi, PosYi);
	}

	public char Movimento (int mapLevel, Map m){

		char dir;

		Random rn = new Random();
		
		int[] XY = {getX(), getY()};

		if (rn.nextInt(2)==0){ //Sleep 
			m.writeElement(XY, 'g');
			return ' ';

		} else {
			if (m.searchElement(getX(), getY())=='g'){dir=walkAfterSleep();}
			else {
				dir = guardtraject[i];
				i++;
			}
			
			m.writeElement(XY, 'G');
			if (i==guardtraject.length){i=0;}
			movete(dir, mapLevel, m);

			return dir;
		}

	}
	
	public char walkAfterSleep(){
		char dir;
		Random rn = new Random(); 
		if (rn.nextInt(2)==0){ //mode-se para a frente
			dir = guardtraject[i];
			i++;
		} else { //mode-se para tr�s
			if(i==0){ //se for a primeira posi��o
				dir = 's';
				i = 23;

			} else { //Andar de forma inversa
				dir=invertWalking();
				i = i-1;
			}
		}
		if (i<0){i=23;}
		return dir;
	}
	
	
	public char invertWalking(){
		char dir;
		switch (guardtraject[i-1]){
		case 'w':
			dir = 's';
			break;
		case 'a':
			dir = 'd';
			break;
		case 'd':
			dir = 'a';
			break;
		case 's':
			dir = 'w';
			break;
		default:
			dir = guardtraject[i];
			break;
		}
		return dir;
	}
}
