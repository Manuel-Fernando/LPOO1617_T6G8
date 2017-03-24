package dkeep.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameView extends JPanel{

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
	
	public GameView(char[][] board, boolean newLevel) throws IOException{
		this.board = board;
		
		try {
			
			if(newLevel){
				for (int i=0; i<board.length; i++){
					for (int j=0; j<board[0].length; j++){
						if(i==0 || j== 0 || i==board.length-1 || j==board[0].length-1){board[i][j]='X';}
						else {board[i][j]=' ';}
					}
				}			
			}
			
			wall = ImageIO.read(new File("src/Imagens/wall.jpeg"));
			hero = ImageIO.read(new File("src/Imagens/hero.png"));
			guard = ImageIO.read(new File("src/Imagens/Guard.png"));
			key = ImageIO.read(new File("src/Imagens/key.jpg"));
			lock = ImageIO.read(new File("src/Imagens/lock.png"));
			lockOpen = ImageIO.read(new File("src/Imagens/lockOpen.jpeg"));
			guardAsleep = ImageIO.read(new File("src/Imagens/guardAsleep.jpg"));
			ogre = ImageIO.read(new File("src/Imagens/ogre.jpg"));
			club = ImageIO.read(new File("src/Imagens/club.jpeg"));
			shield = ImageIO.read(new File("src/Imagens/shield.jpg"));
			heroA = ImageIO.read(new File("src/Imagens/heroA.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);				
		
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				
				switch(board[i][j]){
				case 'X':
					g.drawImage(wall, j+35*j, i+35*i, 35, 35, this);
					break;
				case 'H':
					g.drawImage(hero, j+35*j, i+35*i, 35, 35, this);
					break;
				case 'G':
					g.drawImage(guard, j+35*j, i+35*i, 35, 35, this);
					break;
				case 'g':
					g.drawImage(guardAsleep,  j+35*j, i+35*i, 35, 35, this);
					break;
				case 'k':
					g.drawImage(key,  j+35*j, i+35*i, 35, 35, this);
					break;
				case 'I':
					g.drawImage(lock,  j+35*j, i+35*i, 35, 35, this);
					break;
				case 'S':
					g.drawImage(lockOpen,  j+35*j, i+35*i, 35, 35, this);
					break;
				case 'O':
					g.drawImage(ogre,  j+35*j, i+35*i, 35, 35, this);
					break;
				case '*':
					g.drawImage(club,  j+35*j, i+35*i, 35, 35, this);
					break;
				case '+':
					g.drawImage(shield,  j+35*j, i+35*i, 35, 35, this);
					break;
				case 'A':
					g.drawImage(heroA,  j+35*j, i+35*i, 35, 35, this);
					break;
				case 'K':
					g.drawImage(heroA,  j+35*j, i+35*i, 35, 35, this);
					break;
				default:
					g.setColor(Color.WHITE.darker());
					g.fillRect(j+35*j, i+35*i, 35, 35);		
					break;
				}
			}			
		} 
		
	}

}
