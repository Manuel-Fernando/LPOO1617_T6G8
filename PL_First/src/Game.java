import java.util.Random;
import java.util.Scanner;


public class Game{
	char [][] board1 = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
						{'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X'},
						{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
						{'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
						{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
						{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
						{'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X'},
						{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'} };

	char [][] board2 = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
						{'I', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'k', 'X'},
						{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};

	int hero[] = {1,1};
	int guard[] = {1,8};
	int ogre[] = {1,4};
	char guardtraject[] = {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};
	char direction;
	int i=0;
	char heroLetter, guardLetter, ogreLetter; 
	int count = 0;
	boolean herowithkey=false;
	
	//move os intervenientes
	public void direcao (int person0, int person1, int person[], char [][] board){
		
		if ((board[person0][person1] != 'X') && ((board[person0][person1] != 'I') || (herowithkey && person==hero))){
			
			if (person == hero){
				if (board == board1){						
					if (board[person0][person1] == 'k') {
						board[5][0]='S';
						board[6][0]='S';
					}
					board[person[0]][person[1]]=' ';
					person[0]=person0;
					person[1]=person1;
					board[person[0]][person[1]]=heroLetter;
					
				} else if (board == board2) {
					
					if (board[person0][person1] == 'k') {
						heroLetter = 'K';
						herowithkey=true;
					}
					
					if (person0 == 1 && person1 == 0){
						if (count == 1){
							board[person[0]][person[1]]=' ';
							person[0]=person0;
							person[1]=person1;
							board[person[0]][person[1]]=heroLetter;
						} else {
							count=1;
							board[1][0] = 'S';
						}
					} else {
						board[person[0]][person[1]]=' ';
						person[0]=person0;
						person[1]=person1;
						board[person[0]][person[1]]=heroLetter;
					}
				}
				
			}else if (person == ogre){
				if(board[1][8]=='$'){board[1][8]='k';}
				else {board[person[0]][person[1]]=' ';}
				
				if (person0 == 1 && person1 == 8 && !herowithkey){ogreLetter = '$';} 
				
				person[0]=person0;
				person[1]=person1;
				board[person[0]][person[1]]=ogreLetter;
				
			}else if (person == guard){
				board[person[0]][person[1]]=' ';
				person[0]=person0;
				person[1]=person1;
				board[person[0]][person[1]]=guardLetter;
			}else {
				System.out.print("Erro!!!");
				return;
			}	
		}
	}

	//trata do movimento pelo tabuleiro de qualquer dos intervientes 
	public char move (int person[], char [][] board){

		if (person==hero){
			Scanner sc = new Scanner(System.in); 
			direction = sc.next().charAt(0);
			//sc.close();
			if (heroLetter != 'K') {
				heroLetter='H';
			}


		} else if (person==guard){

			direction=guardtraject[i];
			i++;
			if(i==guardtraject.length){i=0;}
			guardLetter='G';

		} else if (person==ogre){

			Random rn = new Random();
			int range = 4 - 1 + 1;
			int randomNum =  rn.nextInt(range) + 1;

			if (randomNum==1){direction='w';}
			else if (randomNum==2){direction='a';}
			else if (randomNum==3){direction='s';}
			else if (randomNum==4){direction='d';}
			ogreLetter = 'O';
		}

		switch (direction){
			case 'w':
				direcao (person[0]-1, person[1], person, board);
				break;
			case 'a':
				direcao (person[0], person[1]-1, person, board);
				break;
			case 'd':
				direcao (person[0], person[1]+1, person, board);
				break;
			case 's':
				direcao (person[0]+1, person[1], person, board);
				break;			
		}
		return direction;
	}

	//v� se o jogador perde ou ganha o jogo
	public int WinOrLoose (char over, char [][] board) {	

		if (hero[1]==0 && (hero[0]==5 || hero[0]==6 || hero[0]==1)){
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
	public boolean firstLevel () {

		for (int i=0; i<board1.length; i++){
			for (int j=0; j<board1[0].length; j++){
				System.out.print(board1[i][j]);
				System.out.print(' ');
			}	 		
			System.out.println();
		}
		System.out.println();

		while (move(hero, board1) != 'q'){
			if(WinOrLoose('G', board1)==-1){return false;}
			move(guard, board1);
			for (int i=0; i<board1.length; i++){
				for (int j=0; j<board1[0].length; j++){
					System.out.print(board1[i][j]);
					System.out.print(' ');
				}			
				System.out.println();
			} 
			System.out.println();
			if(WinOrLoose('G', board1)==-1){return false;}
			else if(WinOrLoose('G', board1)==1){return true;}
		}
		System.out.println("Erro!!!");
		return false;
	}

	//trata da segunda parte do jogo
	public boolean secondLevel () {

		hero[0] = 8;
		hero[1] = 1;

		for (int i=0; i<board2.length; i++){
			for (int j=0; j<board2[0].length; j++){
				System.out.print(board2[i][j]);
				System.out.print(' ');
			}	 		
			System.out.println();
		}
		System.out.println();

		while (move(hero, board2) != 'q'){
			if(WinOrLoose('O', board2)==-1){return false;}
			move(ogre, board2);
			for (int i=0; i<board2.length; i++){
				for (int j=0; j<board2[0].length; j++){
					System.out.print(board2[i][j]);
					System.out.print(' ');
				}			
				System.out.println();
			} 
			System.out.println();
			if(WinOrLoose('O', board2)==-1){return false;}
			else if(WinOrLoose('O', board2)==1){return true;}
		}
		System.out.println("Erro!!!");
		return false;
	}

	public static void main(String[] args) {

		Game jogo = new Game ();
		System.out.println("Use:	 'w' 'a' 's' 'd' para se mover.\n");
		if(jogo.firstLevel()){
			System.out.println("Parab�ns! Passou de N�vel!!!");
			if(jogo.secondLevel()){
				System.out.println("Parab�ns! Ganhou!!!");
			}
		}
	}
}