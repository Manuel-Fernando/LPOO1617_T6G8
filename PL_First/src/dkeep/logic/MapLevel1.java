package dkeep.logic;

public class MapLevel1 extends Map {
	
	MapLevel1(){
		char [][]board1 = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
							{'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X'},
							{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
							{'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
							{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
							{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
							{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
							{'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
							{'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X'},
							{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'} };
		board=board1;
	}	
}