package dkeep.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dkeep.logic.Game;
import dkeep.logic.Ogre;

public class TestGame {
	
	char [][]map1={{'X','X','X','X','X'},
			{'X','H',' ','G','X'},
			{'I',' ','K','+','X'},
			{'I','k','O','A','X'},
			{'X','X','X','X','X'}};
	
	char [][]map3={{'X','X','X','X','X','X','X'},
			{'X','H',' ',' ',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ','X'},
			{'I','k',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ','O',' ','X'},
			{'X','X','X','X','X','X','X'}};

	@Test
	public void testlevel1() {
		Game jogo = new Game();
		int variavel = 0;
		variavel = jogo.jogo('d', "Rookie", 2);
		assertEquals(variavel, 1);		
	}
	
	@Test
	public void testlevel2() {
		Game jogo = new Game();
		int variavel = 0;
		Ogre ogre = new Ogre(1,4);
		Ogre ogre1 = new Ogre(1,4);
		
		ArrayList <Ogre> ogres = new ArrayList <Ogre>(5);
		ArrayList <Ogre> ogres2 = new ArrayList <Ogre>(5);
		ArrayList <Ogre> ogres3 = new ArrayList <Ogre>(5);
		
		ogres.add(ogre);
		ogres.add(ogre1);
		
		variavel = jogo.level2('s', ogres, 2);
		assertEquals(variavel, 3);	
		
		ogre = new Ogre(6,2);
		ogre1 = new Ogre(6,2);
		ogres2.add(ogre);
		ogres2.add(ogre1);
		
		variavel = jogo.level2('w', ogres2, 2);
		assertEquals(variavel, -2);	
		
		ogre = new Ogre(6,1);
		ogre1 = new Ogre(6,1);
		ogres3.add(ogre);
		ogres3.add(ogre1);
		
		variavel = jogo.level2('w', ogres3, 2);
		assertEquals(variavel, -2);	
		
	}
	
	@Test
	public void testlevel3() {
		Game jogo = new Game();
		jogo.setTabuleiro(map3, "Rookie");
		
		int variavel = 0;
		Ogre ogre = new Ogre(1,4);
		Ogre ogre1 = new Ogre(1,4);
		
		ArrayList <Ogre> ogres = new ArrayList <Ogre>(5);
		
		ogres.add(ogre);
		ogres.add(ogre1);
		
		variavel = jogo.level3('s', ogres, 2);
		assertEquals(variavel, 5);		
	}
	
	@Test
	public void testSetTabuleiro() {
		Game game = new Game();
		game.setTabuleiro(map1, "Rookie");

		char [][] map2 = game.getTabuleiro();

		boolean equal = true;

		for (int i=0; i<map1.length; i++){
			for (int j=0; j<map1[0].length; j++){
				if (map1[i][j]!=map2[i][j]){
					equal = false;
				}
			}
		}

		assertTrue(equal);
	}

}
