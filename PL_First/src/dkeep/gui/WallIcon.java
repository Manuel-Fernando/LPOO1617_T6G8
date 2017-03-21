package dkeep.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class WallIcon extends JPanel{

	private Image wall;

	public WallIcon() throws IOException{
		wall = ImageIO.read(new File("src/Imagens/wall.jpeg"));
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(wall, 0, 0, 35, 35, this);	
	}


}
