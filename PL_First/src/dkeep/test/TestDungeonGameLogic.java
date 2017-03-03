package dkeep.test;

import static org.junit.Assert.*;

import org.junit.Test;
import dkeep.logic.Map;
import dkeep.logic.Heroi;
import dkeep.logic.GameState;

public class TestDungeonGameLogic {

	char [][]map={{'X','X','X','X','X'},
			{'X','H',' ','G','X'},
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}};
	
	@Test
	public void testMoveHeroIntoToFreeCell() {
		Map mapa = new Map();
		mapa.setBoard(map);
		Heroi hero = new Heroi(1,1);
		assertEquals(mapa.searchElement(1, 1),'H');
		hero.Movimento('s', 1, mapa);
		assertEquals(mapa.searchElement(2, 1),'H');
	}
	
	@Test
	public void testMoveHeroIntoToWall() {
		Map mapa = new Map();
		mapa.setBoard(map);
		Heroi hero = new Heroi(1,1);
		assertEquals(mapa.searchElement(1, 1),'H');
		hero.Movimento('w', 1, mapa);
		assertEquals(mapa.searchElement(1, 1),'H');
		assertEquals(mapa.searchElement(0, 1),'X');
	}
	
	@Test
	public void testHeroIsCapturedByGuard(){
		Map mapa = new Map();
		mapa.setBoard(map);
		Heroi hero = new Heroi(1,1);
		GameState estadoJogo = new GameState(); 
		assertFalse(estadoJogo.WinOrLoose ('G', mapa, hero)==-1);
		hero.Movimento('d', 1, mapa);
		assertTrue(estadoJogo.WinOrLoose ('G', mapa, hero)==-1);
	}
	
	@Test
	public void testMoveHeroPassesCloseDoor() {
		Map mapa = new Map();
		mapa.setBoard(map);
		Heroi hero = new Heroi(1,1);
		assertEquals(mapa.searchElement(1, 1),'H');
		hero.Movimento('s', 1, mapa);
		hero.Movimento('a', 1, mapa);
		assertEquals(mapa.searchElement(2, 0),'I');
		assertEquals(mapa.searchElement(2, 1),'H');
	}
	
	@Test
	public void testMoveHeroCathTheKey() {
		Map mapa = new Map();
		mapa.setBoard(map);
		Heroi hero = new Heroi(1,1);
		assertEquals(mapa.searchElement(1, 1),'H');
		hero.Movimento('s', 1, mapa);
		hero.Movimento('s', 1, mapa);
		assertEquals(mapa.searchElement(2, 0),'S');
		assertEquals(mapa.searchElement(3, 0),'S');
	}
	
	@Test
	public void testMoveHeroPassesLevel() {
		Map mapa = new Map();
		mapa.setBoard(map);
		GameState estadoJogo = new GameState();
		Heroi hero = new Heroi(1,1);
		assertEquals(mapa.searchElement(1, 1),'H');
		hero.Movimento('s', 1, mapa);
		hero.Movimento('s', 1, mapa);
		hero.Movimento('a', 1, mapa);
		assertEquals(mapa.searchElement(3, 0),'H');
		assertTrue(estadoJogo.WinOrLoose ('G', mapa, hero)==1);
	}
}
