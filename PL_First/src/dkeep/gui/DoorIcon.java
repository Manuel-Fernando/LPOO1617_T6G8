package dkeep.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DoorIcon extends JPanel{
	
	private Image door;

	public DoorIcon() throws IOException{
		door = ImageIO.read(new File("C:/Users/Utilizador/git/LPOO1617_T6G8/PL_First/src/Imagens/lock.png"));
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(door, 0, 0, 35, 35, this);	
	}

}
