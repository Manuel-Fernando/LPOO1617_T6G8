package dkeep.logic;

public class Entidade {

	char letter;
	int []pos = new int[2];
	
	protected void Movimento(char dir){}
	
	protected int getX(){
		return pos[0];
	}
	
	protected int getY(){
		return pos[1];
	}
	
	protected char getLetter(){
		return letter;
	}
	
	protected void setLetter(char l){
		letter = l;
	}
}

