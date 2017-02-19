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
		{'X', ' ', 'I', ' ', 'I', ' ', 'X', 'K', ' ', 'X'},
		{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};
	int hero[] = {1,1};
	int guard[] = {1,8};
	char guardtraject[] = {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};
	char direction;
	int i=0;
	char letter; 
	
	// trata do movimento pelo tabuleiro de qualquer dos intervientes 
	public char move (int person[]){
		
		if (person==hero){
			Scanner sc = new Scanner(System.in); 
			direction = sc.next().charAt(0);
			//sc.close();
			letter='H';
			}
		else if (person==guard){
			direction=guardtraject[i];
			i++;
			if(i==guardtraject.length){i=0;}
			letter='G';
			}
		
		switch (direction){
			case 'w':
				if ((board[person[0]-1][person[1]] != 'X') && (board[person[0]-1][person[1]] != 'I') ){
					if (board[person[0]-1][person[1]] == 'K'){board[5][0]='S';board[6][0]='S';}
					board[person[0]][person[1]]=' ';
					person[0]--;
					board[person[0]][person[1]]=letter;
				}
				break;
			case 'a':
				if ((board[person[0]][person[1]-1] != 'X') && (board[person[0]][person[1]-1] != 'I') ){
					if (board[person[0]][person[1]-1] == 'K'){board[5][0]='S';board[6][0]='S';}
					board[person[0]][person[1]]=' ';
					person[1]--;
					board[person[0]][person[1]]=letter;
				} 
				break;
			case 'd':
				if ((board[person[0]][person[1]+1] != 'X') && (board[person[0]][person[1]+1] != 'I') ){
					if (board[person[0]][person[1]+1] == 'K'){board[5][0]='S';board[6][0]='S';}
					board[person[0]][person[1]]=' ';
					person[1]++;
					board[person[0]][person[1]]=letter;
				} 
				break;
			case 's':
				if ((board[person[0]+1][person[1]] != 'X') && (board[person[0]+1][person[1]] != 'I') ){
					if (board[person[0]][person[1]-1] == 'K'){board[5][0]='S';board[6][0]='S';}
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
	public boolean firstLevel () {
		
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				System.out.print(board[i][j]);
				System.out.print(' ');
			}	 		
			System.out.println();
		}
		System.out.println();
		
		while (move(hero) != 'q'){
			if(WinOrLoose('G')==-1){return false;}
			move(guard);
			for (int i=0; i<board.length; i++){
				for (int j=0; j<board[0].length; j++){
					System.out.print(board[i][j]);
					System.out.print(' ');
				}			
				System.out.println();
			} 
			System.out.println();
			if(WinOrLoose('G')==-1){return false;}
			else if(WinOrLoose('G')==1){return true;}
		}
		System.out.println("Erro!!!");
		return false;
	}
	
	public static void main(String[] args) {
		Game jogo = new Game ();
		System.out.println("Use:	 'w' 'a' 's' 'd' para se mover.\n");
		if(jogo.firstLevel()){
			System.out.println("Parabéns! Passou de Nível!!!");
		}
	}
}