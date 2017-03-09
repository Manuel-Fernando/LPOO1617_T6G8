package dkeep.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dkeep.logic.MapLevel1;
import dkeep.logic.Suspicious;

public class TestSuspiciousBehaviour {

	@Test
	public void test() {
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
