package dkeep.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dkeep.logic.Drunken;
import dkeep.logic.GameState;
import dkeep.logic.Heroi;
import dkeep.logic.Map;
import dkeep.logic.MapLevel1;
import dkeep.logic.MapLevel2;
import dkeep.logic.Ogre;
import dkeep.logic.Rookie;
import dkeep.logic.Suspicious;

public class TestPITMutations {
	
	char [][]map={{'X','X','X','X','X'},
			{'X','H',' ','G','X'},
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}};

	@Test
	public void testToCheckMoviment() {
		MapLevel1 mapa = new MapLevel1();
		Drunken d = new Drunken(1,8);
		char guardDirection;
		int posX = 1;
		int posY = 8;
		
		boolean outcome1 = false, outcome2 = false, outcome3 = false, outcome4 = false, outcome5 = false;
		while(!outcome1 || !outcome2 || !outcome3 || !outcome4 || !outcome5){
			guardDirection = d.Movimento(1, mapa);
			
			if((guardDirection=='w')){
				assertEquals(mapa.searchElement(posX-1, posY),'G');
				posX--;
				outcome1=true;
			}else if(guardDirection=='a'){
				assertEquals(mapa.searchElement(posX, posY-1),'G');
				posY--;
				outcome2=true;
			}else if(guardDirection=='d'){
				assertEquals(mapa.searchElement(posX, posY+1),'G');
				posY++;
				outcome3=true;
			}else if(guardDirection=='s'){
				assertEquals(mapa.searchElement(posX+1, posY),'G');
				posX++;
				outcome4=true;
			}else if(guardDirection==' '){
				assertEquals(mapa.searchElement(posX, posY),'g');
				outcome5=true;
			}
		}
		
		
	}

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
	
	@Test(timeout=1000)
	public void testSomeRandomBehaviour() {
		MapLevel2 mapa = new MapLevel2();
		char ogreDirection;
		int posX=1, posY=4;
		Ogre ogre = new Ogre(posX,posY);
		boolean outcome1 = false, outcome2 = false, outcome3 = false, outcome4 = false;
		while(!outcome1 || !outcome2 || !outcome3 || !outcome4){
			ogreDirection=ogre.Movimento(2, mapa, false, false);
			if((ogreDirection=='w') && (mapa.searchElement(posX-1, posY)!='X')){
				assertEquals(mapa.searchElement(posX-1, posY),'O');
				posX--;
				outcome1=true;
			}else if(ogreDirection=='a' && ((mapa.searchElement(posX, posY-1)!='X') || (mapa.searchElement(posX, posY-1)!='I'))){
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
		assertTrue(hero.heroWithKey());
		assertEquals(mapa.searchElement(1, 7),' ');
	}
	
	@Test
	public void testIfCatchesTheClub() {
		MapLevel2 mapa = new MapLevel2();
		Heroi hero = new Heroi(6,5);
		hero.Movimento('s', 2, mapa);
		assertEquals(mapa.searchElement(7, 5),'A');
		assertTrue(hero.heroWithClub());
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
	
	@Test
	public void test() {
		MapLevel1 mapa = new MapLevel1();
		Rookie d = new Rookie(1,8);
		char guardDirection;
		int posX = 1;
		int posY = 8;
		
		boolean outcome1 = false, outcome2 = false, outcome3 = false, outcome4 = false;
		while(!outcome1 || !outcome2 || !outcome3 || !outcome4){
			guardDirection = d.Movimento(1, mapa);
			
			if((guardDirection=='w')){
				assertEquals(mapa.searchElement(posX-1, posY),'G');
				posX--;
				outcome1=true;
			}else if(guardDirection=='a'){
				assertEquals(mapa.searchElement(posX, posY-1),'G');
				posY--;
				outcome2=true;
			}else if(guardDirection=='d'){
				assertEquals(mapa.searchElement(posX, posY+1),'G');
				posY++;
				outcome3=true;
			}else if(guardDirection=='s'){
				assertEquals(mapa.searchElement(posX+1, posY),'G');
				posX++;
				outcome4=true;
			}
		}

	}
	
	@Test
	public void test1() {
		MapLevel1 mapa = new MapLevel1();
		Suspicious d = new Suspicious(1,8);
		char guardDirection;
		int posX = 1;
		int posY = 8;
		int count = 0;

		boolean outcome1 = false, outcome2 = false, outcome3 = false, outcome4 = false;
		while (count < 7){
			while(!outcome1 || !outcome2 || !outcome3 || !outcome4){
				guardDirection = d.Movimento(1, mapa);

				if((guardDirection=='w')){
					assertEquals(mapa.searchElement(posX-1, posY),'G');
					posX--;
					outcome1=true;
				}else if(guardDirection=='a'){
					assertEquals(mapa.searchElement(posX, posY-1),'G');
					posY--;
					outcome2=true;
				}else if(guardDirection=='d'){
					assertEquals(mapa.searchElement(posX, posY+1),'G');
					posY++;
					outcome3=true;
				}else if(guardDirection=='s'){
					assertEquals(mapa.searchElement(posX+1, posY),'G');
					posX++;
					outcome4=true;
				}
			}
			count++;
		}
	}

}
