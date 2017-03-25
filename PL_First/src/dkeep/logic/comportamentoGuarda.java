package dkeep.logic;

/**
 * Classe que guarda o comportamento do guarda
 * @author Carolina e Manuel
 *
 */
public class comportamentoGuarda extends Guard {
	
	/**
	 * Construtor que cria um guarda om um determinado comportamento numa dada posi��o do mapa
	 * @param PosXi inteiro para a posi��o em x
	 * @param PosYi inteiro para a posi��o em y
	 */
	public comportamentoGuarda(int PosXi, int PosYi) {
		super(PosXi, PosYi);
		
	}

	/**
	 * M�todo para movimentar o guarda
	 */
	protected void movimento(){}
	
	/**
	 * M�todo para verificar se o guarda pode mover-se e, se puder, atualiza o quadro com as posi��es corretas
	 * @param posinX inteiro com a posi��o em x
	 * @param posinY inteiro com a posi��o em y
	 * @param m - Map com o mapa do jogo
	 * @param mapLevel n�vel
	 */
	protected void direcao (int posinX, int posinY, Map m, int mapLevel ){
		
		if ((m.searchElement(posinX, posinY) != 'X') && ((m.searchElement(posinX, posinY) != 'I'))){
			
			m.writeElement(pos, ' ');
			pos[0]=posinX; 
			pos[1]=posinY;
			m.writeElement(pos, letter);
				
		}
	}
	
	/**
	 * M�todo para mover o guarda numa determinada dire��o
	 * @param dir char com a dire��o do movimento
	 * @param mapLevel inteiro com o n�vel
	 * @param m Map com o mapa do n�vel
	 */
	protected void movete(char dir, int mapLevel, Map m){
		switch (dir){
		case 'w':
			direcao (pos[0]-1, pos[1], m, mapLevel);
			break;
		case 'a':
			direcao (pos[0], pos[1]-1, m, mapLevel);
			break;
		case 'd':
			direcao (pos[0], pos[1]+1, m, mapLevel);
			break;
		case 's':
			direcao (pos[0]+1, pos[1], m, mapLevel);
			break;			
		}
	}

}
