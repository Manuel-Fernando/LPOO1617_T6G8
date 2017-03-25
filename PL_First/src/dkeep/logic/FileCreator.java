package dkeep.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Classe que cria um ficheiro de texto
 * @author Carolina e Manuel
 *
 */
public class FileCreator {
	
	/**
	 * File para o ficheiro a ser criado
	 */
	private File file;
	
	/**
	 * Contrutor que cria um ficheiro com o nome game.txt
	 */
	public FileCreator(){
		file = new File("game.txt");
	}
	
	/**
	 * Método que guarda o jogo no ficheiro
	 * @param board char[][] com o mapa do jogo
	 * @param type String com o tipo de guarda
	 * @param number inteiro com o número de ogres do jogo
	 * @throws FileNotFoundException
	 */
	public void saveGame(char[][]board, String type, int number) throws FileNotFoundException{
		
		PrintWriter output = new PrintWriter(file);
		
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				
				if (board[i][j] == '*'){
					output.print(' ');
				} else{
					output.print(board[i][j]);
				}
			}
		  output.println();
		} 
		output.println(type); 
		output.println(number);
		
		output.close();
	}

}
