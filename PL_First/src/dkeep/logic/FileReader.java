package dkeep.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

/**
 * Classe que l� um ficheiro de texto
 * @author Carolina e Manuel
 *
 */
public class FileReader {
	
	private File file;
	private Scanner input;
	private char[][] board;
	private Vector<String> info;
	private String type;
	private int numOgres;
	
	/**
	 * Contrutor que cria um objeto FileReader
	 * @throws FileNotFoundException
	 */
	public FileReader() throws FileNotFoundException{
		file = new File("game.txt");
		if (file.exists())
			input = new Scanner(file); 
		info = new Vector<String>();
	}
	
	/**
	 * M�todo que carrega o jogo que se encontra no ficheiro
	 * @return char[][] com o mapa do jogo
	 */
	public char[][] loadGame(){		
		int numLines = 0;
		int numCol = 0;
		String l;
		
		if (file.exists()){
			while(input.hasNextLine()){
				l = input.nextLine();
				info.add(l);
				if (numLines == 1)
					numCol = l.length();
				numLines++;
			}
		}
		
		return copyBoard(numLines, numCol);
		
	}
	
	/**
	 * M�todo que preenche o tabuleiro com a informa��o que se encontra no ficheiro
	 * @param numLines inteiro para o n�mero de linha do ficheiro
	 * @param numCol inteiro para o n�mero de colunas que ir� ter o mapa
	 * @return char [][] com o mapa de jogo
	 */
	public char[][] copyBoard(int numLines, int numCol){
		board = new char[numLines-2][numCol];
		
		String line;
		
		for (int i=0; i<info.size()-2; i++){
			line = info.elementAt(i);
			for (int j=0; j<numCol; j++){
				board[i][j]=line.charAt(j);
			}
		}
		
		type = info.elementAt(info.size()-2);
		numOgres =Integer.valueOf(info.elementAt(info.size()-1));
		return board;
	}
	
	/**
	 * M�todo que retorna o tipo de guarda de jogo
	 * @return String com o tipo de guarda
	 */
	public String getGuardType(){
		return type;
	}
	
	/**
	 * M�todo que retorna o n�mero de ogres do jogo
	 * @return inteiro com o n�mero de ogres
	 */
	public int getNumOgres(){
		return numOgres;
	}
	
	/**
	 * M�todo que verifica se o ficheiro existe
	 * @return true se o ficheiro existir
	 */
	public boolean isThere(){		
		if (!file.exists()){
			return true;
		} else {
			return false;
		}
	}

}
