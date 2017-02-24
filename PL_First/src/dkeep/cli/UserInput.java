package dkeep.cli;

import java.util.Scanner;

import dkeep.logic.Game;
import dkeep.logic.GameState;
import dkeep.logic.Guard;
import dkeep.logic.Heroi;
import dkeep.logic.MapLevel1;

public class UserInput {
	
	/*
	 * Método para ler a direção introduzida pelo utilizador
	 * Parâmetros de saida:
	 * char - direção introduzida
	 */
	
	public static char readDirection (){
		System.out.println(' ');
		System.out.println("Use:	 'w' 'a' 's' 'd' para se mover.\n");
		Scanner sc = new Scanner(System.in); 
		char direction = sc.next().charAt(0);
		//sc.close();
		return direction;
	}

	public static void main(String[] args) {
		
		MapLevel1 board1 = new MapLevel1();
		GameState loose = new GameState();
		Heroi hero = new Heroi(1,1);
		Guard guard = new Guard (1,8);
		int mapLevel = 1;
		
		do {			
			board1.printBoard();			
			char dir = readDirection();
			hero.Movimento(dir, mapLevel, board1);
			guard.Movimento(mapLevel, board1);			
			
		} while (!loose.WinOrLoose(guard.getLetter(), board1, hero));

	}
}
