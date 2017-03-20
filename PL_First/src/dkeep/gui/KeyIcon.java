package dkeep.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class KeyIcon extends JPanel{

	private Image key;

	public KeyIcon() throws IOException{
		key = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/key.jpg"));
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(key, 0, 0, 35, 35, this);	
	}

}
