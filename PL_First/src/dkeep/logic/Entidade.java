package dkeep.logic;


/**
 * Classe que guarda as várias personagens do jogo
 * @author Carolina e Manuel
 *
 */
public class Entidade {
	
	/**
	 * Letra associada a cada personagem
	 */
	char letter;
	
	/**
	 * int[] com a posição em x e y de cada perconagem 
	 */
	int []pos = new int[2];
	
	/**
	 * Método que movimenta a personagem
	 * @param dir direção do movimento (a, s, d, ou w)
	 */
	protected void Movimento(char dir){}
	
	/**
	 * Método que retorna a posição em x da personagem
	 * @return inteiro com a posição em x
	 */
	protected int getX(){
		return pos[0];
	}
	
	/**
	 * Método que retorna a posição em y da personagem
	 * @return inteiro com a posição em y 
	 */
	protected int getY(){
		return pos[1];
	}
	
	/**
	 * Método que retorna a letra associada a cada personagem
	 * @return char com a letra de cada personagem
	 */
	protected char getLetter(){
		return letter;
	}
	
	/**
	 * Método que atribui uma letra a uma personagem
	 * @param l char com a letra a atribuir
	 */
	protected void setLetter(char l){
		letter = l;
	}
}

