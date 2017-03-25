package dkeep.logic;

/**
 * Classe que guarda o comportamento do guarda
 * @author Carolina e Manuel
 *
 */
public class comportamentoGuarda extends Guard {
	
	/**
	 * Construtor que cria um guarda om um determinado comportamento numa dada posição do mapa
	 * @param PosXi inteiro para a posição em x
	 * @param PosYi inteiro para a posição em y
	 */
	public comportamentoGuarda(int PosXi, int PosYi) {
		super(PosXi, PosYi);
		
	}

	/**
	 * Método para movimentar o guarda
	 */
	protected void movimento(){}
	
	/**
	 * Método para verificar se o guarda pode mover-se e, se puder, atualiza o quadro com as posições corretas
	 * @param posinX inteiro com a posição em x
	 * @param posinY inteiro com a posição em y
	 * @param m - Map com o mapa do jogo
	 * @param mapLevel nível
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
	 * Método para mover o guarda numa determinada direção
	 * @param dir char com a direção do movimento
	 * @param mapLevel inteiro com o nível
	 * @param m Map com o mapa do nível
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
