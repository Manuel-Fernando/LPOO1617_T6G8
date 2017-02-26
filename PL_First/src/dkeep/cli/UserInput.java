package dkeep.cli;

import java.util.Scanner;

import dkeep.logic.Game;
import dkeep.logic.GameState;
import dkeep.logic.Guard;
import dkeep.logic.Heroi;
import dkeep.logic.MapLevel1;
import dkeep.logic.MapLevel2;
import dkeep.logic.Ogre;

public class UserInput {
	
	/*
	 * M�todo para ler a dire��o introduzida pelo utilizador
	 * Par�metros de saida:
	 * char - dire��o introduzida
	 */
	
	public static char readDirection (){
		Scanner sc = new Scanner(System.in); 
		char direction = sc.next().charAt(0);
		//sc.close();
		return direction;
	}
	public static boolean level1(MapLevel1 board1, Heroi hero, Guard guard, GameState loose){
		while(true){
			board1.printBoard();			
			char dir = readDirection();
			hero.Movimento(dir, 1, board1);
			if(loose.WinOrLoose(guard.getLetter(), board1, hero)==1){return true;}
			if(loose.WinOrLoose(guard.getLetter(), board1, hero)==-1){return false;}
			guard.Movimento(1, board1);
			if(loose.WinOrLoose(guard.getLetter(), board1, hero)==-1){return false;}
		}
	}
	
	public static boolean level2(MapLevel2 board2, Heroi hero, Ogre ogre, GameState loose){
		while(true){
			board2.printBoard();			
			char dir = readDirection();
			hero.Movimento(dir, 2, board2);
			if(loose.WinOrLoose(ogre.getLetter(), board2, hero)==1){return true;}
			if(loose.WinOrLoose(ogre.getLetter(), board2, hero)==-1){return false;}
			if(loose.WinOrLoose('*', board2, hero)==-1){return false;}
			if(loose.WinOrLoose('$', board2, hero)==-1){return false;}	
			ogre.Movimento(2, board2);
			board2.printBoard();
			if(loose.WinOrLoose(ogre.getLetter(), board2, hero)==-1){return false;}
			if(loose.WinOrLoose('*', board2, hero)==-1){return false;}
			if(loose.WinOrLoose('$', board2, hero)==-1){return false;}	
		}
	}


	public static void main(String[] args) {
		
		MapLevel1 board1 = new MapLevel1();
		GameState loose = new GameState();
		Heroi hero = new Heroi(1,1);
		Guard guard = new Guard (1,8);
		boolean result;
		
		System.out.println(' ');
		System.out.println("Use:	 'w' 'a' 's' 'd' para se mover.\n");
		
		result=level1(board1, hero, guard, loose);

		if (result){
			System.out.println("Parabéns Passou de Nível!!!");
			MapLevel2 board2 = new MapLevel2();
			Heroi hero2 = new Heroi(7,1);
			Ogre ogre = new Ogre (1,4);
			
			result=level2(board2, hero2, ogre, loose);
			if (result){
				board2.printBoard();
				System.out.println("Parabéns Ganhou o Jogo!!!");	
			}
			else if (!result){
				board2.printBoard();
				System.out.println("Perdeu o Jogo!!!");
			}
		}
		else if (!result){
			board1.printBoard();
			System.out.println("Perdeu o Jogo!!!");
		}
	}
}
