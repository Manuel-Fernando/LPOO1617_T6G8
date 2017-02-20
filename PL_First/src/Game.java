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

	char [][] board2 = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
						{'I', ' ', ' ', ' ', 'O', ' ', ' ', 'k', 'X'},
						{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
						{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};

	int hero[] = {1,1};
	int guard[] = {1,8};
	int ogre[] = {1,4};
	int club[] = {7,7};
	char guardtraject[] = {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};
	char direction;
	int i=0;
	char heroLetter, guardLetter, ogreLetter; 
	int count = 0;
	boolean herowithkey=false;
	
	public void printboard(char [][] board){
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				System.out.print(board[i][j]);
				System.out.print(' ');
			}			
			System.out.println();
		} 	
	}
	
	public char randomdirection(){
		Random rn = new Random();
		int range = 4 - 1 + 1;
		int randomNum =  rn.nextInt(range) + 1;

		if (randomNum==1){return 'w';}
		else if (randomNum==2){return 'a';}
		else if (randomNum==3){return 's';}
		else if (randomNum==4){return 'd';}
		
		return ' ';
	}
	
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
				if(board[1][7]=='$' && person[0]==1 && person[1]==7){board[1][7]='k';
				}else if (board[1][7]=='O'){board[1][7]=' ';}
				
				if(person[0]!=1 || person[1]!=7){board[person[0]][person[1]]=' ';}
				if (person0 == 1 && person1 == 7 && !herowithkey){ogreLetter = '$';} 
				
				person[0]=person0;
				person[1]=person1;
				board[person[0]][person[1]]=ogreLetter;
				
			}else if (person == club){	
				if(board[1][7]=='$' && person[0]==1 && person[1]==7 && (ogre[0]!=1 || ogre[1]!=7)){board[1][7]='k';
				}else if (board[1][7]=='*'){board[1][7]=' ';}
				
				if((person[0]!=1 || person[1]!=7) && board[person[0]][person[1]]=='*'){board[person[0]][person[1]]=' ';}
				
				direction=randomdirection();
				while((direction=='w' && ogre[0]==1)||(direction=='a' && ogre[1]==1)
					||(direction=='d' && ogre[1]==7)||(direction=='s' && ogre[0]==7)){
					direction=randomdirection();
				}
				switch (direction){
					case 'w':
						person[0]=ogre[0]-1;
						person[1]=ogre[1];
						break;
					case 'a':
						person[0]=ogre[0];
						person[1]=ogre[1]-1;
						break;
					case 'd':
						person[0]=ogre[0];
						person[1]=ogre[1]+1;
						break;
					case 's':
						person[0]=ogre[0]+1;
						person[1]=ogre[1];
						break;			
				}
				if (person[0] == 1 && person[1] == 7 && !herowithkey){board[person[0]][person[1]]='$';
				}else board[person[0]][person[1]]='*'; 
		
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

			direction=randomdirection();
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

		printboard(board1);
		System.out.println();

		while (move(hero, board1) != 'q'){
			if(WinOrLoose('G', board1)==-1){printboard(board1);return false;}
			move(guard, board1);
			printboard(board1);
			System.out.println();
			if(WinOrLoose('G', board1)==-1){return false;}
			if(WinOrLoose('G', board1)==1){return true;}
		}
		System.out.println("Erro!!!");
		return false;
	}

	//trata da segunda parte do jogo
	public boolean secondLevel () {

		hero[0] = 7;
		hero[1] = 1;

		printboard(board2);
		System.out.println();

		while (move(hero, board2) != 'q'){
			if(WinOrLoose('O', board2)==-1){printboard(board2);return false;}
			if(WinOrLoose('*', board2)==-1){printboard(board2);return false;}
			if(WinOrLoose('$', board2)==-1){printboard(board2);return false;}
			move(ogre, board2);
			direcao (3, 3, club, board2);
			printboard(board2);
			System.out.println();
			if(WinOrLoose('O', board2)==-1){return false;}
			if(WinOrLoose('*', board2)==-1){printboard(board2);return false;}
			if(WinOrLoose('$', board2)==-1){printboard(board2);return false;}
			if(WinOrLoose('O', board2)==1){return true;}
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