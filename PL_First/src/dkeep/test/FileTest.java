package dkeep.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import dkeep.logic.FileCreator;
import dkeep.logic.FileReader;

public class FileTest {
	
	char [][]map={{'X','X','X','X','X'},
			{'X','H',' ','G','X'},
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}};

	@Test
	public void testFile() throws FileNotFoundException {
		FileCreator fileC = new FileCreator();
		fileC.saveGame(map, "Rookie",1);
		
		FileReader fileR = new FileReader();
		char [][] map2 = fileR.loadGame();
		
		boolean equal = true;
		
		for (int i=0; i<map.length; i++){
			for (int j=0; j<map[0].length; j++){
				if (map[i][j]!=map2[i][j]){
					equal = false;
				}
			}
		}
		
		assertTrue(equal);
	}

}
