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
	
	public GameView(char[][] board) throws IOException{
		this.board = board;
		
		try {
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
		//g.drawRect(143, 14, 500, 500);
		//g.setColor(Color.BLUE);
		
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				
				switch(board[i][j]){
				case 'X':
					//g.fillRect (j+35*j, i+35*i, 35, 35);
					//g.setColor(Color.WHITE);
					g.drawImage(wall, j+35*j, i+35*i, 35, 35, this);
					break;
				case 'H':
					//g.fillRect (i+35*i, j+35*j, 35, 35);
					g.drawImage(hero, j+35*j, i+35*i, 35, 35, this);
					break;
				case 'G':
					//g.fillRect (i+35*i, j+35*j, 35, 35);
					g.drawImage(guard, j+35*j, i+35*i, 35, 35, this);
					break;
				case 'g':
					//g.fillRect (i+35*i, j+35*j, 35, 35);
					g.drawImage(guardAsleep,  j+35*j, i+35*i, 35, 35, this);
					break;
				case 'k':
					//g.fillRect (i+35*i, j+35*j, 35, 35);
					g.drawImage(key,  j+35*j, i+35*i, 35, 35, this);
					break;
				case 'I':
					//g.fillRect (i+35*i, j+35*j, 35, 35);
					g.drawImage(lock,  j+35*j, i+35*i, 35, 35, this);
					break;
				case 'S':
					//g.fillRect (i+35*i, j+35*j, 35, 35);
					g.drawImage(lockOpen,  j+35*j, i+35*i, 35, 35, this);
					break;
				case 'O':
					//g.fillRect (i+35*i, j+35*j, 35, 35);
					g.drawImage(ogre,  j+35*j, i+35*i, 35, 35, this);
					break;
				case '*':
					//g.fillRect (i+35*i, j+35*j, 35, 35);
					g.drawImage(club,  j+35*j, i+35*i, 35, 35, this);
					break;
				case '+':
					//g.fillRect (i+35*i, j+35*j, 35, 35);
					g.drawImage(shield,  j+35*j, i+35*i, 35, 35, this);
					break;
				case 'A':
					//g.fillRect (i+35*i, j+35*j, 35, 35);
					g.drawImage(heroA,  j+35*j, i+35*i, 35, 35, this);
					break;
				case 'K':
					//g.fillRect (i+35*i, j+35*j, 35, 35);
					g.drawImage(heroA,  j+35*j, i+35*i, 35, 35, this);
					break;
				default:
					g.setColor(Color.WHITE);
					g.fillRect(j+35*j, i+35*i, 35, 35);		
					break;
				}
			}			
		} 
		
	}

}
