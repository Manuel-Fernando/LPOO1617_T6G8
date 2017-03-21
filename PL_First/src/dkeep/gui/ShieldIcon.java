package dkeep.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ShieldIcon extends JPanel{
	
	private Image shield;

	public ShieldIcon() throws IOException{
		shield = ImageIO.read(new File("src/Imagens/shield.jpg"));
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(shield, 0, 0, 35, 35, this);	
	}

}
