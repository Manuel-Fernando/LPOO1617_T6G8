package dkeep.logic;

/**
 * Classe que guarda guardas com comportamento do tipo Rookie
 * @author Carolina e Manuel
 *
 */
public class Rookie extends comportamentoGuarda {
	
	/**
	 * Construtor que cria o guarda numa dada posição
	 * @param PosXi inteiro com a posição em x
	 * @param PosYi inteiro com a posição m y
	 */
	public Rookie(int PosXi, int PosYi) {
		super(PosXi, PosYi);
	}

	/**
	 * Método que verifica qual a próxima direção de movimento do guarda
	 * @param mapLevel inteiro para o nível do mapa
	 * @param m Map como o mapa do jogo
	 * @return char com a direção do movimento
	 */
	public char Movimento (int mapLevel, Map m){
		
		char dir = guardtraject[i];
		i++;
		if (i==guardtraject.length){i=0;}
		
		movete(dir, mapLevel, m);
		
		return dir;
		
	}

}
