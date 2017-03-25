package dkeep.logic;

import java.util.Random;

/**
 * Classe que guarda guardas com o comportamento do tipo drunken
 * @author Carolina e Manuel
 *
 */
public class Drunken extends comportamentoGuarda{
	
	/**
	 * Construtor que cria um guarda comportamento do tipo drunken numa determinada posição.
	 * @param PosXi inteiro com a posição em x
	 * @param PosYi inteiro com a posção em y
	 */
	public Drunken(int PosXi, int PosYi) {
		super(PosXi, PosYi);
	}
	
	/**
	 * Método que verifica qual a próxima direção de movimento do guarda
	 *  @param mapLevel inteiro com o nível do jogo
	 *  @param m Map com o mapa do jogo
	 *  @return char com a direção do movimento
	 */
	public char Movimento (int mapLevel, Map m){

		char dir;

		Random rn = new Random();
		
		int[] XY = {getX(), getY()};

		if (rn.nextInt(2)==0){ //Sleep 
			m.writeElement(XY, 'g');
			return ' ';

		} else {
			if (m.searchElement(getX(), getY())=='g'){dir=walkAfterSleep();}
			else {
				dir = guardtraject[i];
				i++;
			}
			
			m.writeElement(XY, 'G');
			if (i==guardtraject.length){i=0;}
			movete(dir, mapLevel, m);

			return dir;
		}

	}
	
	/**
	 * Método que verifica qual a próxima direção de movimento após este acordar.
	 * @return char com a direção de movimento
	 */
	public char walkAfterSleep(){
		char dir;
		Random rn = new Random(); 
		if (rn.nextInt(2)==0){ //mode-se para a frente
			dir = guardtraject[i];
			i++;
		} else { //mode-se para trï¿½s
			if(i==0){ //se for a primeira posiï¿½ï¿½o
				dir = 's';
				i = 23;

			} else { //Andar de forma inversa
				dir=invertWalking();
				i = i-1;
			}
		}
		if (i<0){i=23;}
		return dir;
	}
	
	/**
	 * Método que verifica qual a próxima direção de movimento caso o guarda inverta o sentido do movimento
	 * @return char com a direção do movimento
	 */
	public char invertWalking(){
		char dir;
		switch (guardtraject[i-1]){
		case 'w':
			dir = 's';
			break;
		case 'a':
			dir = 'd';
			break;
		case 'd':
			dir = 'a';
			break;
		case 's':
			dir = 'w';
			break;
		default:
			dir = guardtraject[i];
			break;
		}
		return dir;
	}
}
