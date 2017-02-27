package dkeep.logic;


public class Guard extends Entidade{
	
	comportamentoGuarda compGuarda;	

	public Guard(int PosXi, int PosYi){
		posX=PosXi;
		posY=PosYi;
		letter='G';
	}

	
	/*
	public Guard(){
		letter='G';
	}
	*/
	
	protected void setposX(int PosXi){
		posX=PosXi;
	}
	
	protected void setposY(int PosYi){
		posY=PosYi;
	}
	
	
	Guard(comportamentoGuarda cg){
		compGuarda = cg;
	}
	
	protected void Movimento (int mapLevel, Map m){

		compGuarda.movimento();

	}

}	
