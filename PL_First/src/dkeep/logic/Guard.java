package dkeep.logic;


public class Guard extends Entidade{
	
	comportamentoGuarda compGuarda;	

	public Guard(int PosXi, int PosYi){
		posX=PosXi;
		posY=PosYi;
		letter='G';
	}

	
	protected void setposX(int PosXi){
		posX=PosXi;
	}
	
	protected void setposY(int PosYi){
		posY=PosYi;
	}
	
	
	Guard(comportamentoGuarda cg){
		compGuarda = cg;
	}
	
	protected char Movimento (int mapLevel, Map m){

		compGuarda.movimento();
		return ' ';

	}

}	
