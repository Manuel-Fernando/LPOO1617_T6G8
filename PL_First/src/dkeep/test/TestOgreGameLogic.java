package dkeep.test;

import static org.junit.Assert.*;
import dkeep.logic.MapLevel2;
import dkeep.logic.Heroi;
import dkeep.logic.GameState;

import org.junit.Test;

public class TestOgreGameLogic {

	@Test
	public void testIfLooseNearOgre() {
		MapLevel2 mapa = new MapLevel2();
		Heroi hero = new Heroi(1,2);
		GameState estadoJogo = new GameState(); 
		hero.Movimento('d', 2, mapa);
		assertTrue(estadoJogo.WinOrLoose ('O', mapa, hero)==-1);
	}
	
	@Test
	public void testIfCatchesTheKey() {
		MapLevel2 mapa = new MapLevel2();
		Heroi hero = new Heroi(1,6);
		hero.Movimento('d', 2, mapa);
		hero.Movimento('a', 2, mapa);
		assertEquals(mapa.searchElement(1, 6),'K');
		assertEquals(mapa.searchElement(1, 7),' ');
	}
	
	@Test
	public void testIfHeroFailExitWithoutKey() {
		MapLevel2 mapa = new MapLevel2();
		Heroi hero = new Heroi(2,1);
		hero.Movimento('w', 2, mapa);
		hero.Movimento('a', 2, mapa);
		assertEquals(mapa.searchElement(1, 0),'I');
		assertEquals(mapa.searchElement(1, 1),'H');
	}
	
	@Test
	public void testIfHeroExitWitTheKey() {
		char percurso[] = {'w', 's', 'a', 'a', 'a', 'a', 'a', 'a', 'w', 'a'};
		MapLevel2 mapa = new MapLevel2();
		Heroi hero = new Heroi(2,7);
		for(int i=0; i<percurso.length; i++){
			hero.Movimento(percurso[i], 2, mapa);
		}
		assertEquals(mapa.searchElement(1, 0),'S');
		hero.Movimento('a', 2, mapa);
		assertEquals(mapa.searchElement(1, 0),'K');
	}
	
	@Test
	public void testIfHeroExitWitTheKeyAndWin() {
		char percurso[] = {'w', 's', 'a', 'a', 'a', 'a', 'a', 'a', 'w', 'a'};
		MapLevel2 mapa = new MapLevel2();
		GameState estadoJogo = new GameState(); 
		Heroi hero = new Heroi(2,7);
		for(int i=0; i<percurso.length; i++){
			hero.Movimento(percurso[i], 2, mapa);
		}
		assertEquals(mapa.searchElement(1, 0),'S');
		hero.Movimento('a', 2, mapa);
		assertEquals(mapa.searchElement(1, 0),'K');
		assertTrue(estadoJogo.WinOrLoose ('O', mapa, hero)==1);
	}
}
