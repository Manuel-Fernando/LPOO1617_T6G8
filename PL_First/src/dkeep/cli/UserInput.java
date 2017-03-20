package dkeep.cli;

import java.util.Scanner;
import dkeep.logic.Game;

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

	public static void printBoard(char [][]board){
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				System.out.print(board[i][j]);
				System.out.print(' ');
			}			
			System.out.println();
		} 	System.out.println();
	}



	public static void main(String[] args) {

		Game jogo = new Game();
		int variavel = 0;

		System.out.println(' ');
		System.out.println("Use:	 'w' 'a' 's' 'd' para se mover.\n");

		printBoard(jogo.tabuleiro1());
		while(true){
			variavel = jogo.jogo(readDirection(), "Rookie", 1);
			switch (variavel){
			case -1:
				printBoard(jogo.tabuleiro1());
				System.out.println("Perdeu o Jogo!!!\n"); 
				return;
			case -2:
				printBoard(jogo.tabuleiro2());
				System.out.println("Perdeu o Jogo!!!\n"); 
				return;
			case 1:
				printBoard(jogo.tabuleiro1());
				break;
			case 2:
				System.out.println("Passou de Nível...\n");
				printBoard(jogo.tabuleiro2());
				break;
			case 3:
				printBoard(jogo.tabuleiro2());
				break;
			case 4:
				printBoard(jogo.tabuleiro2());
				System.out.println("Ganhou o Jogo!!!\n"); 
				return;
			}
		}
	}
}
	