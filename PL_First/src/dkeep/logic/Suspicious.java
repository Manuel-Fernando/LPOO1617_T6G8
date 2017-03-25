package dkeep.logic;

import java.util.Random;

/**
 * Classe que guarda os guardas com comportamento do tipo Suspicious
 * @author Carolina e Manuel
 *
 */
public class Suspicious extends comportamentoGuarda {
	
	/**
	 * Contrutor que cria o guarda numa dada posi��o
	 * @param PosXi inteiro para a posi��o em x
	 * @param PosYi inteiro para a posi��o em y
	 */
	public Suspicious(int PosXi, int PosYi) {
		super(PosXi, PosYi);
	}
	
	char dir;
	char[] guardInverse = {'d','w','w','w','w','d','d','d','d','d','d','w','a','a','a','a','a','a','a','s','s','s','s','s'};
	
	/**
	 * M�todo que verifica qual a pr�xima dire��o do movimento do guarda
	 * @param mapLevel inteiro para o n�vel do mapa
	 * @param m Map com o mapa de jogo
	 * @return char com a dire��o de movimento
	 */
	public char Movimento (int mapLevel, Map m){

		Random rn = new Random(); 
		if (rn.nextInt(2)==0){ // anda para a frente
			
			dir = guardtraject[i];
			i++;
			if (i==guardtraject.length){i=0;}

		} else {  // anda para tr�s
			
			if (i==0){
				i=23;
				dir = guardInverse[i];
			} else {
				i--;
				dir = guardInverse[i];
			}
		}		
		
		movete(dir, mapLevel, m);
		
		return dir;
	}

}
