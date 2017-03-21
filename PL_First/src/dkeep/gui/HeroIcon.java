package dkeep.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class HeroIcon extends JPanel{
	
	private Image hero;
	
	public HeroIcon() throws IOException{
		hero = ImageIO.read(new File("src/Imagens/hero.png"));
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(hero, 0, 0, 35, 35, this);	
	}

}
