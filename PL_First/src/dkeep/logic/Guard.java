package dkeep.logic;


public class Guard extends Entidade{
	
	comportamentoGuarda compGuarda;	

	public Guard(int PosXi, int PosYi){
		pos[0]=PosXi;
		pos[1]=PosYi;
		letter='G'; 
	}

	int i=0;
	char guardtraject[] = {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};
	
	protected void setposXY(int PosXi, int PosYi){
		pos[0]=PosXi;
		pos[1]=PosYi;
		
		switch(pos[0]){
		case 1:
			if (pos[1]==7){i=1;}
			else if (pos[1]==8){i=0;}
			break;
		case 2:
			if (pos[1]==7){i=2;}
			else if (pos[1]==8){i=23;}
			break;
		case 3:
			if (pos[1]==7){i=3;}
			else if (pos[1]==8){i=22;}
			break;
		case 4:
			if (pos[1]==7){i=4;}
			else if (pos[1]==8){i=21;}
			break;
		case 5:
			if (pos[1]==1){i=11;}
			else if (pos[1]==2){i=10;}
			else if (pos[1]==3){i=9;}
			else if (pos[1]==4){i=8;}
			else if (pos[1]==5){i=7;}
			else if (pos[1]==6){i=6;}
			else if (pos[1]==7){i=5;}
			else if (pos[1]==8){i=20;}
			break;
		case 6:
			if (pos[1]==1){i=12;}
			else if (pos[1]==2){i=13;}
			else if (pos[1]==3){i=14;}
			else if (pos[1]==4){i=15;}
			else if (pos[1]==5){i=16;}
			else if (pos[1]==6){i=17;}
			else if (pos[1]==7){i=18;}
			else if (pos[1]==8){i=19;}
			break;
		}

	}
	
	
	Guard(comportamentoGuarda cg){
		compGuarda = cg;
	}
	
	protected char Movimento (int mapLevel, Map m){

		compGuarda.movimento();
		return ' ';

	}

}	
