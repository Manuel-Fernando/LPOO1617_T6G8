package dkeep.test;

import static org.junit.Assert.*;
import dkeep.logic.MapLevel2;
import dkeep.logic.Ogre;

import org.junit.Test;

public class TestOgreAleatority {

	@Test(timeout=1000)
	public void testSomeRandomBehaviour() {
		MapLevel2 mapa = new MapLevel2();
		char[][] board={{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};
		mapa.setBoard(board);
		char ogreDirection;
		int posX=4, posY=4;
		Ogre ogre = new Ogre(posX,posY);
		boolean outcome1 = false, outcome2 = false, outcome3 = false, outcome4 = false;
		while(!outcome1 || !outcome2 || !outcome3 || !outcome4){
			ogreDirection=ogre.Movimento(2, mapa, false, false);
			if((ogreDirection=='w') && (mapa.searchElement(posX-1, posY)!='X')){
				assertEquals(mapa.searchElement(posX-1, posY),'O');
				posX--;
				outcome1=true;
			}else if(ogreDirection=='a' && (mapa.searchElement(posX, posY-1)!='X')){
				assertEquals(mapa.searchElement(posX, posY-1),'O'); 
				posY--;
				outcome2=true;
			}else if(ogreDirection=='d' && (mapa.searchElement(posX, posY+1)!='X')){
				assertEquals(mapa.searchElement(posX, posY+1),'O');
				posY++;
				outcome3=true;
			}else if(ogreDirection=='s' && (mapa.searchElement(posX+1, posY)!='X')){
				assertEquals(mapa.searchElement(posX+1, posY),'O');
				posX++;
				outcome4=true;
			}
		}
	}

}
