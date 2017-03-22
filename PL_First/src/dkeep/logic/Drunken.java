package dkeep.logic;

import java.util.Random;

public class Drunken extends comportamentoGuarda{

	public Drunken(int PosXi, int PosYi) {
		super(PosXi, PosYi);
	}

	public char Movimento (int mapLevel, Map m){
		
		char dir;

		Random rn = new Random();
		int range = 2 - 1 + 1;
		int randomNum =  rn.nextInt(range) + 1;
		
		if (randomNum==1){ //Sleep
			
			m.writeElement(getX(), getY(), 'g');
			
			return ' ';

		} else {
			
			if (m.searchElement(getX(), getY())=='g'){
				
				rn = new Random();
				range = 2 - 1 + 1;
				randomNum =  rn.nextInt(range) + 1;
				
				if (randomNum==1){ //mode-se para a frente
					dir = guardtraject[i];
					i++;
				} else { //mode-se para tr�s

					if(i==0){ //se for a primeira posi��o
						
						dir = 's';
						i = 23;
								
					} else { //Andar de forma inversa

						switch (guardtraject[i-1]){
						case 'w':
							dir = 'w';
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

						i = i-1;
					}
				}

				if (i<0){
					i=23;
				}
				
			} else {
				dir = guardtraject[i];
				i++;
			}
			
			m.writeElement(getX(), getY(), 'G');

			if (i==guardtraject.length){i=0;}

			movete(dir, mapLevel, m);
			
			return dir;
			
		}
		
	}
}
