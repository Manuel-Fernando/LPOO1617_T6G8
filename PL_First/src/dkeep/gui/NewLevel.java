package dkeep.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import dkeep.logic.Map;

public class NewLevel extends JPanel{

	private char[][] board;
	private Image wall;
	private Image hero;
	private Image guard;
	private Image key;
	private Image lock;
	private Image lockOpen;
	private Image guardAsleep;
	private Image ogre;
	private Image club;
	private Image shield;
	private Image heroA;
	private Map newMap = new Map();
	
	public NewLevel(int n, int m) throws IOException{

		try {
			board = new char[n][m];	
			for (int i=0; i<board.length; i++){
				for (int j=0; j<board[0].length; j++){
					board[i][j]=' ';
				}
			}			
			wall = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/wall.jpeg"));
			hero = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/hero.png"));
			guard = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/Guard.png"));
			key = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/key.jpg"));
			lock = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/lock.png"));
			lockOpen = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/lockOpen.jpeg"));
			guardAsleep = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/guardAsleep.jpg"));
			ogre = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/ogre.jpg"));
			club = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/club.jpeg"));
			shield = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/shield.jpg"));
			heroA = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/heroA.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GRAY);
		
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				g.fillRect (j+35*j, i+35*i, 35, 35);
			}
		}
		
	}

}
