package dkeep.logic;

public class Game {
	
	MapLevel1 board1= new MapLevel1();
	MapLevel2 board2= new MapLevel2();
	
	//trata da primera parte do jogo
	public boolean firstLevel () {
		Heroi hero = new Heroi(1,1);

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
	

}
