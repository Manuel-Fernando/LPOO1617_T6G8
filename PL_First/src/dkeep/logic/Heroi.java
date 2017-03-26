package dkeep.logic;

/**
 * Classe que guarda personagens do tipo Heroi
 * @author Carolina e Manuel
 *
 */
public class Heroi extends Entidade{
	
	/**
	 * Contrutor que cria o heroi numa dada posi��o e atribui 'H' � letra da entidade
	 * @param PosXi inteiro para a posi��o em x
	 * @param PosYi inteiro para a posi��o em y
	 */
	public Heroi(int PosXi, int PosYi){
		pos[0]=PosXi;
		pos[1]=PosYi;
		letter='H';
	}
	
	/**
	 * Contador
	 */
	private int count = 0;
	
	/**
	 * Her�i com chave
	 */
	boolean herowithkey = false;
	
	/**
	 * Her�i com armadura
	 */
	boolean herowithclub = false;
	
	/**
	 * M�todo que verifica se o heroi pode mover-se. Se for poss�vel o movimento, este move-se tendo em conta o n�vel de jogo
	 * @param posinX inteiro para a posi��o em x
	 * @param posinY inteiro para a posi��o em y
	 * @param m Map com o mapa de jogo
	 * @param mapLevel inteiro com o n�vel de jogo
	 */
	private void direcao (int posinX, int posinY, Map m, int mapLevel ){
		if ((m.searchElement(posinX, posinY) != 'X') && ((m.searchElement(posinX, posinY) != 'I') || herowithkey)){
			if (mapLevel == 1){int []posss = {posinX, posinY}; direcaoMapLevel1(posss, m);} 
			else if (mapLevel == 2) {int []posss = {posinX, posinY}; direcaoMapLevel2(posss, m);}
		}
	}
	 
	/**
	 * M�todo que move o heroi no n�vel 1 e abre as portas caso este apanhe a chave
	 * @param posinXY array de inteiro com a posi��o x e y do heroi
	 * @param m Map com o mapa de jogo
	 */
	public void direcaoMapLevel1(int []posinXY, Map m){					
			if (m.searchElement(posinXY[0], posinXY[1]) == 'k') {
				for (int i=0; i<m.board.length; i++){
					for (int j=0; j<m.board[0].length; j++){
						if(m.searchElement(i, j)=='I' && j==0){ 
							
							int []posij = {i,j};
							
							m.writeElement(posij, 'S');
						}
					}			
				}
			}
			
			m.writeElement(pos, ' ');
			pos[0]=posinXY[0];
			pos[1]=posinXY[1];
			m.writeElement(pos, letter);
	}

	/**
	 * M�todo que move o heroi no n�vel 2. 
	 * Fica armado (A) caso apanhe a armadura e muda para K caso apanhe a chave. 
	 * Abre a porta caso este se aproxime desta.
	 * @param posinXY array de inteiros com  posi��o x e y do heroi
	 * @param m Map com o mapa de jogo
	 */
	public void direcaoMapLevel2(int []posinXY, Map m){
		if (m.searchElement(posinXY[0], posinXY[1]) == '+') {
			herowithclub = true;
			if(herowithkey){letter = 'K';
			}else
				letter = 'A';
		}
		if (m.searchElement(posinXY[0], posinXY[1]) == 'k') {
			letter = 'K';
			herowithkey=true;
		}

		if (posinXY[0] == 0 || posinXY[1] == 0 || posinXY[0] == m.board.length-1|| posinXY[1] == m.board[0].length-1){
			openDoorLevel2 (m, posinXY);
		} else if (m.searchElement(posinXY[0], posinXY[1]) != 'I') { 
			m.writeElement(pos, ' ');
			pos[0]=posinXY[0];
			pos[1]=posinXY[1];
			m.writeElement(pos, letter);
		}
		
	}
	
	/**
	 * M�todo que s� abre a porta do n�vel 2 depois de o heroi usar 1 movimento
	 * @param m Map com o mapa de jogo
	 * @param posinXY array de inteiros com a posi��o x e y do her�i
	 */
	public void openDoorLevel2 (Map m, int []posinXY){
		if (count == 1){
			m.writeElement(pos, ' ');
			pos[0]=posinXY[0];
			pos[1]=posinXY[1];
			m.writeElement(pos, letter);
		} else {
			count=1;
			for (int i=0; i<m.board.length; i++){
				for (int j=0; j<m.board[0].length; j++){
					if(m.searchElement(i, j)=='I' && i==posinXY[0] && j==posinXY[1]){
						int []posij = {i,j};
						m.writeElement(posij, 'S');
					}
				}			
			}
		}
	}
	
	/**
	 * M�todo que movimenta o heroi numa determinada dire��o
	 * @param dir char para a dire��o de movimento
	 * @param mapLevel inteiro para o n�vel de jogo
	 * @param m Map com o mapa de jogo
	 */
	public void Movimento(char dir, int mapLevel, Map m){

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
	
	/**
	 * M�todo que informa se oher�i tem chave
	 * @return true caso o her�i tenha a chave
	 */
	public boolean heroWithKey(){
		return herowithkey;
	}
	
	/**
	 * M�todo que informa se o her�i tem a armadura
	 * @return true caso o her�i tenha a armadura
	 */
	public boolean heroWithClub(){
		return herowithclub;
	}
	
	/**
	 * M�todo que altera o estado de posse da chave
	 * @param key boolean true caso tenha apanhado a chave
	 */
	public void setHeroWithKey(boolean key){
		herowithkey = key;
	}
	
	/**
	 * M�todo que altera o estado de posse da armadura
	 * @param arm boolean true caso o het�i tenha apanhado a chave
	 */
	public void setHeroWithClub(boolean arm){
		herowithclub = arm;
	}


}
