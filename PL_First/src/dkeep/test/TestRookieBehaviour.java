package dkeep.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dkeep.logic.MapLevel1;
import dkeep.logic.Rookie;

public class TestRookieBehaviour {

	@Test
	public void testRookie() {
		MapLevel1 mapa = new MapLevel1();
		Rookie d = new Rookie(1,8);
		char guardDirection;
		
		guardDirection = d.Movimento(1, mapa);
		assertEquals(mapa.searchElement(1, 7),'G');
		guardDirection = d.Movimento(1, mapa);
		assertEquals(mapa.searchElement(2, 7),'G');
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		assertEquals(mapa.searchElement(5, 7),'G');
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		assertEquals(mapa.searchElement(6, 1),'G');
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		guardDirection = d.Movimento(1, mapa);
		assertEquals(mapa.searchElement(5, 8),'G');


	}

}
