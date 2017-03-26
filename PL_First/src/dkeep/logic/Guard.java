package dkeep.logic;

/**
 * Classe que guarda personagens do tipo guarda
 * @author Carolina e Manuel
 *
 */
public class Guard extends Entidade{
	
	/**
	 * Tipo de guarda
	 */
	private comportamentoGuarda compGuarda;	
	
	/**
	 * Contrutor que cria um guarda numa determinada posição e atribui o char 'G' à sua letra
	 * @param PosXi inteiro para a posição em x
	 * @param PosYi inteiro para a posição em y
	 */
	public Guard(int PosXi, int PosYi){
		pos[0]=PosXi;
		pos[1]=PosYi;
		letter='G'; 
	}

	/**
	 * Iterador
	 */
	protected int i=0;
	
	/**
	 * Trajeto do guarda
	 */
	protected char guardtraject[] = {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};
	
	/**
	 * Método que coloca o guarda numa determinada posição do mapa
	 * @param PosXi inteiro para a posição em x 
	 * @param PosYi inteiro para a posição em y
	 */
	protected void setposXY(int PosXi, int PosYi){
		pos[0]=PosXi;
		pos[1]=PosYi;
		
		switch(pos[0]){
		case 1:
			if (pos[1]==7){i=1;}
			else if (pos[1]==8){i=0;}
			break;
		case 2:
			if (pos[1]==7){i=2;}
			else if (pos[1]==8){i=23;}
			break;
		case 3:
			if (pos[1]==7){i=3;}
			else if (pos[1]==8){i=22;}
			break;
		case 4:
			if (pos[1]==7){i=4;}
			else if (pos[1]==8){i=21;}
			break;
		case 5:
			if (pos[1]==1){i=11;}
			else if (pos[1]==2){i=10;}
			else if (pos[1]==3){i=9;}
			else if (pos[1]==4){i=8;}
			else if (pos[1]==5){i=7;}
			else if (pos[1]==6){i=6;}
			else if (pos[1]==7){i=5;}
			else if (pos[1]==8){i=20;}
			break;
		case 6:
			if (pos[1]==1){i=12;}
			else if (pos[1]==2){i=13;}
			else if (pos[1]==3){i=14;}
			else if (pos[1]==4){i=15;}
			else if (pos[1]==5){i=16;}
			else if (pos[1]==6){i=17;}
			else if (pos[1]==7){i=18;}
			else if (pos[1]==8){i=19;}
			break;
		}

	}
	
	/**
	 * Contrutor que cria uma personagem do tipo guarda, atribuindo-a um determinado comportamento
	 * @param cg comportamentoGuarda para o comportamento do guarda
	 */
	Guard(comportamentoGuarda cg){
		compGuarda = cg;
	}
	
	/**
	 * Método para movimentar o guarda
	 * @param mapLevel inteiro para o nível do jogo
	 * @param m Map com o mapa do jogo
	 * @return char vazio
	 */
	protected char Movimento (int mapLevel, Map m){

		compGuarda.movimento();
		return ' ';

	}

}	
