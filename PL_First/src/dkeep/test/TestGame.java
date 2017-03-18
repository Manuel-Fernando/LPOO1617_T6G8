package dkeep.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dkeep.logic.Game;
import dkeep.logic.Ogre;

public class TestGame {

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
		
		ogres.add(ogre);
		ogres.add(ogre1);
		
		variavel = jogo.level2('s', ogres, 2);
		assertEquals(variavel, 3);		
	}

}
