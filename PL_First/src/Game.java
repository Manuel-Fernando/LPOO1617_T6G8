import java.util.Random;
import java.util.Scanner;


public class Game{
	char [][] board = { {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
			{'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X'},
			{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
			{'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
			{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
			{'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'} };

	char [][] board2 = { {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
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

	// trata do movimento pelo tabuleiro de qualquer dos intervientes 
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
			if ((board[person[0]-1][person[1]] != 'X') && (board[person[0]-1][person[1]] != 'I') ){
				
				if (person == hero){
					
					if (board == this.board){						
						if (board[person[0]-1][person[1]] == 'k') {
							for (int i=0; i<board.length; i++){
								for (int j=0; j<board[0].length; j++){
									if (board[i][j]=='I'&& j==0){
										board[i][j]='S';
									}
								}			
							} 
						}
						
						board[person[0]][person[1]]=' ';
						person[0]--;
						board[person[0]][person[1]]=heroLetter;
						
					} else if (board == this.board2) {
						
						if (board[person[0]-1][person[1]] == 'k') {
							heroLetter = 'K';
						}
						
						if (person[0]-1 == 1 && person[1] == 0){
							if (count == 1){
								board[person[0]][person[1]]=' ';
								person[0]--;
								board[person[0]][person[1]]=heroLetter;
							} else {
								count++;
								board[person[0]-1][person[1]] = 'S';
							}
						} else {
							board[person[0]][person[1]]=' ';
							person[0]--;
							board[person[0]][person[1]]=heroLetter;
						}
					}
					
				} else if (person == ogre){
					if (person[0]-1 == 1 && person[1] == 8){
						ogreLetter = '$';
					} 
					
					board[person[0]][person[1]]=' ';
					person[0]--;
					board[person[0]][person[1]]=ogreLetter;
					
				} else {
					board[person[0]][person[1]]=' ';
					person[0]--;
					board[person[0]][person[1]]=guardLetter;
				}
				
			}
			break;
		case 'a':
			if ((board[person[0]][person[1]-1] != 'X')) {

				if (person == hero){
					if (board == this.board){	
						if (board[person[0]][person[1]-1] != 'I'){
							if (board[person[0]][person[1]-1] == 'k'){
								for (int i=0; i<board.length; i++){
									for (int j=0; j<board[0].length; j++){
										if (board[i][j]=='I'&& j==0){
											board[i][j]='S';
										}

									}			
								} 
							}
							board[person[0]][person[1]]=' ';
							person[1]--;
							board[person[0]][person[1]]=heroLetter;
						}
					} else if (board == this.board2){	
						
						if (board[person[0]][person[1]-1] == 'k') {
							heroLetter = 'K';
						}

						if (person[0] == 1 && person[1]-1 == 0){
							if (count == 1){
								board[person[0]][person[1]]=' ';
								person[1]--;
								board[person[0]][person[1]]=heroLetter;
							} else {
								count++;
								board[person[0]][person[1]-1] = 'S';
							}
						} else {
							board[person[0]][person[1]]=' ';
							person[1]--;
							board[person[0]][person[1]]=heroLetter;
						}
					}
					
				} else if (person == ogre){
					if (board[person[0]][person[1]-1] != 'I'){
						
						if (person[0] == 1 && person[1]-1 == 8){
							ogreLetter = '$';
						}

						board[person[0]][person[1]]=' ';
						person[1]--;
						board[person[0]][person[1]]=ogreLetter;
					}
				} else {
					board[person[0]][person[1]]=' ';
					person[1]--;
					board[person[0]][person[1]]=guardLetter;
				}
				
			} 
			break;
		case 'd':
			if ((board[person[0]][person[1]+1] != 'X') && (board[person[0]][person[1]+1] != 'I') ){
				if (person == hero){

					if (board==this.board){
						if (board[person[0]][person[1]+1] == 'k'){
							for (int i=0; i<board.length; i++){
								for (int j=0; j<board[0].length; j++){
									if (board[i][j]=='I'&& j==0){
										board[i][j]='S';
									}

								}			
							} 
						}
						
						board[person[0]][person[1]]=' ';
						person[1]++;
						board[person[0]][person[1]]=heroLetter;
						
					} else if (board==this.board2){
						
						if (board[person[0]][person[1]+1] == 'k') {
							heroLetter = 'K';
						}
						
						if (person[0] == 1 && person[1]+1 == 0){
							if (count == 1){
								board[person[0]][person[1]]=' ';
								person[1]++;
								board[person[0]][person[1]]=heroLetter;
							} else {
								count++;
								board[person[0]][person[1]+1] = 'S';
							}
						} else {
							board[person[0]][person[1]]=' ';
							person[1]++;
							board[person[0]][person[1]]=heroLetter;
						}
						
					}
					
				}else if (person == ogre){
					if (person[0] == 1 && person[1]+1 == 8){
						ogreLetter = '$';
					}
					board[person[0]][person[1]]=' ';
					person[1]++;
					board[person[0]][person[1]]=ogreLetter;
					
				} else {
					board[person[0]][person[1]]=' ';
					person[1]++;
					board[person[0]][person[1]]=guardLetter;
				}
				
			} 
			break;
		case 's':
			if ((board[person[0]+1][person[1]] != 'X') && (board[person[0]+1][person[1]] != 'I') ){
				if (person == hero){

					if (board==this.board){
						if (board[person[0]+1][person[1]] == 'k'){
							for (int i=0; i<board.length; i++){
								for (int j=0; j<board[0].length; j++){
									if (board[i][j]=='I'&& j==0){
										board[i][j]='S';
									}
								}			
							} 
						}
						board[person[0]][person[1]]=' ';
						person[0]++;
						board[person[0]][person[1]]=heroLetter;
						
					} else if (board==this.board2){
						
						if (board[person[0]+1][person[1]] == 'k') {
							heroLetter = 'K';
						}
						
						if (person[0]+1 == 1 && person[1] == 0){
							if (count == 1){
								board[person[0]][person[1]]=' ';
								person[0]++;
								board[person[0]][person[1]]=heroLetter;
							} else {
								count++;
								board[person[0]+1][person[1]] = 'S';
							}
						} else {
							board[person[0]][person[1]]=' ';
							person[0]++;
							board[person[0]][person[1]]=heroLetter;
						}
					}
					
				}else if (person == ogre){
					if (person[0]+1 == 1 && person[1] == 8){
						ogreLetter = '$';
					}
					board[person[0]][person[1]]=' ';
					person[0]++;
					board[person[0]][person[1]]=ogreLetter;
					
				} else {
					board[person[0]][person[1]]=' ';
					person[0]++;
					board[person[0]][person[1]]=guardLetter;
				}
				
			} 
			break;			
		}
		return direction;
	}

	//vê se o jogador é casso e consequentemente perde o jogo
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

		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				System.out.print(board[i][j]);
				System.out.print(' ');
			}	 		
			System.out.println();
		}
		System.out.println();

		while (move(hero, board) != 'q'){
			if(WinOrLoose('G', board)==-1){return false;}
			move(guard, board);
			for (int i=0; i<board.length; i++){
				for (int j=0; j<board[0].length; j++){
					System.out.print(board[i][j]);
					System.out.print(' ');
				}			
				System.out.println();
			} 
			System.out.println();
			if(WinOrLoose('G', board)==-1){return false;}
			else if(WinOrLoose('G', board)==1){return true;}
		}
		System.out.println("Erro!!!");
		return false;
	}

	//trata da primera parte do jogo
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
			System.out.println("Parabéns! Passou de Nível!!!");

			if(jogo.secondLevel()){
				System.out.println("Parabéns! Ganhou!!!");
			}
		}

	}
}