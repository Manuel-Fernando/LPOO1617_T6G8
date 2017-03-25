package dkeep.logic;

/**
 * Classe que guarda guardas com comportamento do tipo Rookie
 * @author Carolina e Manuel
 *
 */
public class Rookie extends comportamentoGuarda {
	
	/**
	 * Construtor que cria o guarda numa dada posi��o
	 * @param PosXi inteiro com a posi��o em x
	 * @param PosYi inteiro com a posi��o m y
	 */
	public Rookie(int PosXi, int PosYi) {
		super(PosXi, PosYi);
	}

	/**
	 * M�todo que verifica qual a pr�xima dire��o de movimento do guarda
	 * @param mapLevel inteiro para o n�vel do mapa
	 * @param m Map como o mapa do jogo
	 * @return char com a dire��o do movimento
	 */
	public char Movimento (int mapLevel, Map m){
		
		char dir = guardtraject[i];
		i++;
		if (i==guardtraject.length){i=0;}
		
		movete(dir, mapLevel, m);
		
		return dir;
		
	}

}
