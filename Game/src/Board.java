import java.util.Scanner;

public class Board{

	//Definição do quadro
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

	//Método para executar movimentos 
	public boolean movements (String direction, char [][] b, boolean win) {

		//Descobrir a posição de H		
		int heroLine = 0;
		int heroColumn = 0;

		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				if (board[i][j]=='H'){
					heroLine = i;
					heroColumn = j;
				}				
			}
		}

		//Associar cada direção a uma ação
		switch (direction){
		case "w":
			//Verifica se não existe um X
			if (board[heroLine - 1][heroColumn] != 'X' && board[heroLine - 1][heroColumn] != 'I') {

				//Verificar se existe um K e, se houver, mudar I para S
				if (board[heroLine - 1][heroColumn] == 'K'){
					for (int i=0; i<board.length; i++){
						for (int j=0; j<board[0].length; j++){
							if (board[i][j]=='I')
								board[i][j]='S';
						}
					}					
					board[heroLine][heroColumn]=' ';		
					board[heroLine - 1][heroColumn]='H';				

					// Verificar se existe um S -> ganha
				} else if (board[heroLine - 1][heroColumn] == 'S') {					
					board[heroLine][heroColumn]=' ';		
					board[heroLine - 1][heroColumn]='H';
					win = true;		

					// Verificar se é um espaço em branco
				} else if (board[heroLine - 1][heroColumn] == ' ') {
					board[heroLine][heroColumn]=' ';		
					board[heroLine - 1][heroColumn]='H';	
				} 

				//Caso seja I ou X
			} else {
				System.out.println("Posição não válida!");
			}
			break;

		case "a":
			if (board[heroLine][heroColumn - 1] != 'X' && board[heroLine][heroColumn - 1] != 'I') {

				//Verificar se existe um K e, se houver, mudar I para S
				if (board[heroLine][heroColumn - 1] == 'K'){
					for (int i=0; i<board.length; i++){
						for (int j=0; j<board[0].length; j++){
							if (board[i][j]=='I')
								board[i][j]='S';
						}
					}					
					board[heroLine][heroColumn]=' ';		
					board[heroLine][heroColumn - 1]='H';				

					// Verificar se existe um S -> ganha
				} else if (board[heroLine][heroColumn - 1] == 'S') {					
					board[heroLine][heroColumn]=' ';		
					board[heroLine][heroColumn - 1]='H';
					win = true;		

					// Verificar se é um espaço em branco
				} else if (board[heroLine][heroColumn - 1] == ' ') {
					board[heroLine][heroColumn]=' ';		
					board[heroLine][heroColumn - 1]='H';

					//Caso seja X ou I	
				} else {
					System.out.println("Posição não válida!");
				}

				//Caso seja X ou I
			} else {
				System.out.println("Posição não válida!");
			}
			break;

		case "s":
			if (board[heroLine + 1][heroColumn] != 'X' && board[heroLine + 1][heroColumn] != 'I') {

				//Verificar se existe um K e, se houver, mudar I para S
				if (board[heroLine + 1][heroColumn] == 'K'){
					for (int i=0; i<board.length; i++){
						for (int j=0; j<board[0].length; j++){
							if (board[i][j] == 'I')
								board[i][j] = 'S';
						}
					}					
					board[heroLine][heroColumn]=' ';		
					board[heroLine + 1][heroColumn]='H';				

					// Verificar se existe um S -> ganha
				} else if (board[heroLine + 1][heroColumn] == 'S') {					
					board[heroLine][heroColumn]=' ';		
					board[heroLine + 1][heroColumn]='H';
					win = true;		

					// Verificar se é um espaço em branco
				} else if (board[heroLine + 1][heroColumn] == ' ') {
					board[heroLine][heroColumn]=' ';		
					board[heroLine + 1][heroColumn]='H';

					//Caso seja X ou I	
				} else {
					System.out.println("Posição não válida!");
				}

				//Caso seja I ou X
			} else {
				System.out.println("Posição não válida!");
			}
			break;

		case "d":
			if (board[heroLine][heroColumn + 1] != 'X' && board[heroLine][heroColumn + 1] != 'I') {

				//Verificar se existe um K e, se houver, mudar I para S
				if (board[heroLine][heroColumn + 1] == 'K'){
					for (int i=0; i<board.length; i++){
						for (int j=0; j<board[0].length; j++){
							if (board[i][j]=='I')
								board[i][j]='S';
						}
					}					
					board[heroLine][heroColumn]=' ';		
					board[heroLine][heroColumn + 1]='H';				

					// Verificar se existe um S -> ganha
				} else if (board[heroLine][heroColumn + 1] == 'S') {					
					board[heroLine][heroColumn]=' ';		
					board[heroLine][heroColumn + 1]='H';
					win = true;		

					// Verificar se é um espaço em branco
				} else if (board[heroLine][heroColumn + 1] == ' ') {
					board[heroLine][heroColumn]=' ';		
					board[heroLine][heroColumn + 1]='H';

					//Caso seja I	
				} else {
					System.out.println("Posição não válida!");
				}

				//Caso seja I ou X
			} else {
				System.out.println("Posição não válida!");
			}
			break;
		}

		System.out.println(' ');	

		//Descobrir nova posição do Heroe
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				if (board[i][j]=='H'){
					heroLine = i;
					heroColumn = j;
				}				
			}
		}
		
		//Verifica se existe um guarda
		if (board[heroLine - 1][heroColumn] == 'G' || board[heroLine + 1][heroColumn] == 'G' || board[heroLine][heroColumn - 1] == 'G' || board[heroLine][heroColumn + 1] == 'G') {
			System.out.println("Foi capturado! Perdeu o jogo");
			System.exit(0);
		}

		return win;
	}
	

	//Método para implementar as regras do jogo
	public boolean play () {

		//Desenhar o quadro
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				System.out.print(board[i][j]);
				System.out.print(' ');
			}
			System.out.println(' ');
		}

		//Ler o que foi introduzido pelo utilizador
		Scanner sc = new Scanner(System.in);

		System.out.println(' ');
		System.out.println("Escolha uma direção:");
		System.out.println("Utilize as teclas w,a,s,d");

		//Verificar se o utilizador introduziu algo e se é válido
		boolean validInput = sc.hasNext();
		boolean validKey = false;
		String direction = null;

		while (!validKey) {

			while (!validInput){
				validInput = sc.hasNext();			
			}

			if (validInput) {
				direction = sc.next();
				direction = direction.toLowerCase();

				if (direction.equals("w") || direction.equals("a") || direction.equals("s") || direction.equals("d")) {
					validKey = true;
				}
			}
		}
		
		boolean win = false;
		
		win = movements (direction, board, win);
		
		return win;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Board board = new Board ();

		boolean win = false;

		while (!win){
			win=board.play();		
		}

		System.out.println("Ganhou!");

	}

}