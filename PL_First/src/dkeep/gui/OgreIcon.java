package dkeep.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class OgreIcon extends JPanel{
	
	private Image ogre;

	public OgreIcon() throws IOException{
		ogre = ImageIO.read(new File("src/Imagens/ogre.jpg"));
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ogre, 0, 0, 35, 35, this);	
	}


}
