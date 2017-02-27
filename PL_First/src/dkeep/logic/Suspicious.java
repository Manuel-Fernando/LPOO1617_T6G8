package dkeep.logic;


public class Suspicious extends comportamentoGuarda {

	public Suspicious(int PosXi, int PosYi) {
		super(PosXi, PosYi);
		// TODO Auto-generated constructor stub
	}

	int count=0;
	char dir;
	char[] guardInverse = {'d','w','w','w','w','d','d','d','d','d','d','w','a','a','a','a','a','a','a','s','s','s','s','s'};

	protected void Movimento (int mapLevel, Map m){
		
		if (count<5){
			
			//System.out.println("i inicial frente " + i);
			dir = guardtraject[i];
			i++;
			if (i==guardtraject.length){i=0;}
			//System.out.println("i final frente " + i);
			count++;
			
		} else if (count>=5 && count<=8){
			//System.out.println("i inicial atrás " + i);
			if (i==0){
				i=23;
				dir = guardInverse[i];
			} else {
				i--;
				dir = guardInverse[i];
			}
			//System.out.println("i final atrás " + i);
		
			count++;
			
		} else{	
			//System.out.println("i inicial pausa " + i);
			count=0;
			dir = guardtraject[i];
			i++;
			if (i==guardtraject.length){i=0;}
			//System.out.println("i final pausa " + i);
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
		

	}

}
