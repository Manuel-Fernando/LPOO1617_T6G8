package dkeep.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

/**
 * Classe que lê um ficheiro de texto
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
	 * Método que carrega o jogo que se encontra no ficheiro
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
	 * Método que preenche o tabuleiro com a informação que se encontra no ficheiro
	 * @param numLines inteiro para o número de linha do ficheiro
	 * @param numCol inteiro para o número de colunas que irá ter o mapa
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
	 * Método que retorna o tipo de guarda de jogo
	 * @return String com o tipo de guarda
	 */
	public String getGuardType(){
		return type;
	}
	
	/**
	 * Método que retorna o número de ogres do jogo
	 * @return inteiro com o número de ogres
	 */
	public int getNumOgres(){
		return numOgres;
	}
	
	/**
	 * Método que verifica se o ficheiro existe
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
