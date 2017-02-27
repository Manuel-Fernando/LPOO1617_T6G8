package dkeep.logic;

import java.util.Random;

public class Drunken extends comportamentoGuarda{

	public Drunken(int PosXi, int PosYi) {
		super(PosXi, PosYi);
		// TODO Auto-generated constructor stub
	}

	protected void Movimento (int mapLevel, Map m){
		
		//System.out.println("i inicial " + i);
		char dir;

		Random rn = new Random();
		int range = 2 - 1 + 1;
		int randomNum =  rn.nextInt(range) + 1;
		
		//System.out.println("sleep??  " + randomNum);
		
		if (randomNum==1){ //Sleep
			
			m.writeElement(getX(), getY(), 'g');

		} else {
			
			if (m.searchElement(getX(), getY())=='g'){
				
				//System.out.println("Mudar para G");
				
				rn = new Random();
				range = 2 - 1 + 1;
				randomNum =  rn.nextInt(range) + 1;
				
				//System.out.println("Sentido  " + randomNum);
				
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
				
				//System.out.println("i final  " + i);
				
			} else {
				dir = guardtraject[i];
				i++;
			}
			
			m.writeElement(getX(), getY(), 'G');
			
			//System.out.println("dire��o  " + dir);

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

}
