package dkeep.logic;

public class Entidade {
	
	int posX, posY;
	char letter;
	
	protected void Movimento(char dir){}
	
	protected int getX(){
		return posX;
	}
	
	protected int getY(){
		return posY;
	}
	
	protected char getLetter(){
		return letter;
	}
}

