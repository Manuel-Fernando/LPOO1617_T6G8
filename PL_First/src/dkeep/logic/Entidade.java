package dkeep.logic;

public class Entidade {
	int posX, posY;
	char letter;
	
	public void Movimento(char dir){}
	
	public int getX(){
		return posX;
	}
	
	public int getY(){
		return posY;
	}
	
	public char getLetter(){
		return letter;
	}
}

