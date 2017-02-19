import java.util.Random;
import java.util.Scanner;

public class SecondLevel {

	int ogre[] = {4,1};
	int hero[] = {8,1};	
	char direction;
	int i=0;
	char letter; 

	char [][] board = { {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'k', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};


	// trata do movimento pelo tabuleiro de qualquer dos intervientes 
	public char move (int person[]){

		if (person==hero){
			Scanner sc = new Scanner(System.in); 
			direction = sc.next().charAt(0);
			//sc.close();
			letter='H';
		}

		else if (person==ogre){

			Random rn = new Random();
			int range = 4 - 1 + 1;
			int randomNum =  rn.nextInt(range) + 1;

			if (randomNum==1){direction='w';}
			else if (randomNum==2){direction='a';}
			else if (randomNum==3){direction='s';}
			else if (randomNum==4){direction='d';}
			letter = 'O';

		}

		switch (direction){
		case 'w':
			if ((board[person[0]-1][person[1]] != 'X') && (board[person[0]-1][person[1]] != 'I') ){
				if (board[person[0]-1][person[1]] == 'k'){board[1][0]='S';}
				board[person[0]][person[1]]=' ';
				person[0]--;
				board[person[0]][person[1]]=letter;
			}
			break;
		case 'a':
			if ((board[person[0]][person[1]-1] != 'X') && (board[person[0]][person[1]-1] != 'I') ){
				if (board[person[0]][person[1]-1] == 'k'){board[1][0]='S';}
				board[person[0]][person[1]]=' ';
				person[1]--;
				board[person[0]][person[1]]=letter;
			} 
			break;
		case 'd':
			if ((board[person[0]][person[1]+1] != 'X') && (board[person[0]][person[1]+1] != 'I') ){
				if (board[person[0]][person[1]+1] == 'k'){board[1][0]='S';}
				board[person[0]][person[1]]=' ';
				person[1]++;
				board[person[0]][person[1]]=letter;
			} 
			break;
		case 's':
			if ((board[person[0]+1][person[1]] != 'X') && (board[person[0]+1][person[1]] != 'I') ){
				if (board[person[0]][person[1]-1] == 'k'){board[1][0]='S';}
				board[person[0]][person[1]]=' ';
				person[0]++;
				board[person[0]][person[1]]=letter;
			} 
			break;			
		}
		return direction;
	}

	//vê se o jogador é casso e consequentemente perde o jogo
	public int WinOrLoose (char over) {

		if (hero[1]==0 && (hero[0]==5 || hero[0]==6)){
			return 1;
		}
		else if((board[hero[0]+1][hero[1]]==over) || (board[hero[0]][hero[1]+1]==over)
				|| (board[hero[0]-1][hero[1]]==over) || (board[hero[0]][hero[1]-1]==over)){
			System.out.println("Game Over!!!");
			return -1;
		}
		return 0;
	} 

	//trata da primera parte do jogo
	public boolean secondLevel () {

		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				System.out.print(board[i][j]);
				System.out.print(' ');
			}	 		
			System.out.println();
		}
		System.out.println();

		while (move(hero) != 'q'){
			if(WinOrLoose('O')==-1){return false;}
			move(ogre);
			for (int i=0; i<board.length; i++){
				for (int j=0; j<board[0].length; j++){
					System.out.print(board[i][j]);
					System.out.print(' ');
				}			
				System.out.println();
			} 
			System.out.println();
			if(WinOrLoose('O')==-1){return false;}
			else if(WinOrLoose('O')==1){return true;}
		}
		System.out.println("Erro!!!");
		return false;
	}


}
