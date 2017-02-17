import java.util.Scanner;

public class Board{
	char [][] board = { {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
		{'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X'},
		{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
		{'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
		{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
		{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
		{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
		{'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
		{'X', ' ', 'I', ' ', 'I', ' ', 'X', 'K', ' ', 'X'},
		{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
	};
	
	public void play (){
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(' ');
		System.out.println("Nova direção");
		
		String direction;
		
		direction = sc.next();
		sc.close();
		
		
		
		int heroLine = 1;
		int heroColumn = 1;
		boolean hasKey = false;
		
		switch (direction){
		case "w":
			if (board[heroLine-1][heroColumn] != 'X'){
				board[heroLine][heroColumn]=' ';
		
				heroLine = heroLine-1;
				board[heroLine][heroColumn]='H';
				
				if (board[heroLine-1][heroColumn] == 'K'){
					hasKey = true;
				}
			}
			break;
		case "a":
			if (board[heroLine][heroColumn-1] != 'X'){
				board[heroLine][heroColumn]=' ';
				heroColumn = heroColumn-1;
				board[heroLine][heroColumn]='H';
			} 

			break;
		case "d":
			if (board[heroLine][heroColumn+1] != 'X'){
				board[heroLine][heroColumn]=' ';
				heroColumn = heroColumn+1;
				board[heroLine][heroColumn]='H';
			} 
			break;
		case "s":
			if (board[heroLine+1][heroColumn] != 'X'){
				board[heroLine][heroColumn]=' ';
				heroLine = heroLine+1;
				board[heroLine][heroColumn]='H';
			} 
			break;			
		}
		
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println(' ');
		}
		
		
		
		
	}
	
	
	





public static void main(String[] args) {
	// TODO Auto-generated method stub

	Board board = new Board ();

	for (int i=0; i<board.board.length; i++){
		for (int j=0; j<board.board[0].length; j++){
			System.out.print(board.board[i][j]);
		}
		System.out.println(' ');
	}
	
	board.play();
	
	


}

}