package dkeep.logic;


/**
 * Classe que guarda as v�rias personagens do jogo
 * @author Carolina e Manuel
 *
 */
public class Entidade {
	
	/**
	 * Letra associada a cada personagem
	 */
	char letter;
	
	/**
	 * int[] com a posi��o em x e y de cada perconagem 
	 */
	int []pos = new int[2];
	
	/**
	 * M�todo que movimenta a personagem
	 * @param dir dire��o do movimento (a, s, d, ou w)
	 */
	protected void Movimento(char dir){}
	
	/**
	 * M�todo que retorna a posi��o em x da personagem
	 * @return inteiro com a posi��o em x
	 */
	protected int getX(){
		return pos[0];
	}
	
	/**
	 * M�todo que retorna a posi��o em y da personagem
	 * @return inteiro com a posi��o em y 
	 */
	protected int getY(){
		return pos[1];
	}
	
	/**
	 * M�todo que retorna a letra associada a cada personagem
	 * @return char com a letra de cada personagem
	 */
	protected char getLetter(){
		return letter;
	}
	
	/**
	 * M�todo que atribui uma letra a uma personagem
	 * @param l char com a letra a atribuir
	 */
	protected void setLetter(char l){
		letter = l;
	}
}

