package dkeep.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dkeep.gui.GameWindow.KeyLis;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LevelCreator extends JFrame implements MouseMotionListener, MouseListener{

	private JPanel frame;
	private JPanel mapa;
	private JTextField altura;
	private JTextField largura;
	private int n;
	private int m;
	private int posX;
	private int posY;
	private int finalposX;
	private int finalposY;
	private JPanel wall;
	private JPanel ogre;
	private JPanel shield;
	private JPanel hero;
	private JPanel key;
	private JPanel door;
	private JLabel lblWall;
	private JLabel lblOgre;
	private JLabel lblHero;
	private JLabel lblShield;
	private JLabel lblDoor;
	private JLabel lblKey;
	private JLabel lblPleaseInsertW;
	private JPanel clickedIcon;
	private int boardposX, boardposY;
	private String type;
	private char [][] newboard;
	JButton btnNewButton;
	
	private int heroiPresente;
	private boolean closedBoard;
	private boolean doorPresente;
	private boolean keyPresente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelCreator frame = new LevelCreator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LevelCreator() throws IOException{
		initialize();
		this.setFocusable(true);			
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.requestFocusInWindow();
	}

	/**
	 * Create the frame.
	 * @return 
	 * @throws IOException 
	 */
	public void initialize() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 550);
		frame = new JPanel();
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		frame.setLayout(null);
		
		JLabel lblCreateYourOwn = new JLabel("Create your own Map");
		lblCreateYourOwn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCreateYourOwn.setBounds(137, 11, 169, 22);
		frame.add(lblCreateYourOwn);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(28, 49, 27, 14);
		frame.add(lblSize);
		
		altura = new JTextField();
		altura.setBounds(65, 46, 86, 20);
		frame.add(altura);
		altura.setColumns(10);
		
		largura = new JTextField();
		largura.setBounds(191, 46, 86, 20);
		frame.add(largura);
		largura.setColumns(10);
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(166, 49, 15, 14);
		frame.add(lblX);
		
		lblPleaseInsertW = new JLabel("Please Insert W and H");
		lblPleaseInsertW.setVisible(false);
		lblPleaseInsertW.setBounds(149, 77, 46, 14);
		frame.add(lblPleaseInsertW);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (btnCreate.getText() == "Reset"){
					frame.remove(mapa);
					frame.remove(key);
					frame.remove(door);
					frame.remove(wall);
					frame.remove(ogre);
					frame.remove(hero);
					frame.remove(shield);
					frame.remove(lblWall);
					frame.remove(lblKey);
					frame.remove(lblDoor);
					frame.remove(lblOgre);
					frame.remove(lblShield);
					frame.remove(lblHero);
					frame.remove(btnNewButton);
					mapa.removeAll();
				}
				
				n = Integer.valueOf(altura.getText());
				m = Integer.valueOf(largura.getText());
				
				try {
					newboard = new char[n][m];
					mapa = new NewLevel(newboard);
					frame.repaint();		
					
					mapa.setBounds(28, 88, n*38, m*38);
					
					if ((int)(mapa.getBounds().getWidth()+mapa.getBounds().x+100)>640 || (int)(mapa.getBounds().getHeight()+mapa.getBounds().y+50)>550){
						setBounds(100, 100, (int)(mapa.getBounds().getWidth()+mapa.getBounds().x+150), (int)(mapa.getBounds().getHeight()+mapa.getBounds().y+70));
					}
					
					wall = new WallIcon();
					wall.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 86, 35, 35);
					frame.add(wall);
					wall.repaint();
					
					ogre = new OgreIcon();
					ogre.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 146, 35, 35);
					frame.add(ogre);
					ogre.repaint();
					
					hero = new HeroIcon();
					hero.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 210, 35, 35);
					frame.add(hero);
					hero.repaint();
					
					shield = new ShieldIcon();
					shield.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 276, 35, 35);
					frame.add(shield);
					shield.repaint();
					
					door = new DoorIcon();
					door.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 336, 35, 35);
					frame.add(door);
					door.repaint();
					
					key = new KeyIcon();
					key.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 396, 35, 35);
					frame.add(key);
					key.repaint();
					
					lblWall = new JLabel("Wall");
					lblWall.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 123, 27, 14);
					frame.add(lblWall);
					
					lblOgre = new JLabel("Ogre");
					lblOgre.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 184, 46, 14);
					frame.add(lblOgre);
					
					lblHero = new JLabel("Hero");
					lblHero.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 247, 27, 14);
					frame.add(lblHero);
					
					lblShield = new JLabel("Shield");
					lblShield.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 314, 35, 14);
					frame.add(lblShield);
					
					lblDoor = new JLabel("Door");
					lblDoor.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 376, 35, 14);
					frame.add(lblDoor);
					
					lblKey = new JLabel("Key");
					lblKey.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 436, 35, 14);
					frame.add(lblKey);
					
					btnNewButton = new JButton("Save and Play");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {

							closedBoard=true;
							heroiPresente=0;
							for (int i=0; i<newboard.length; i++){
								for (int j=0; j<newboard[0].length; j++){
									if (newboard[i][j]=='H') {heroiPresente++;}
									if (newboard[i][j]=='I') {doorPresente=true;}
									if (newboard[i][j]=='k') {keyPresente=true;}
									if((i==0 || j==0 || i==newboard.length-1 || j==newboard[0].length-1) && newboard[i][j]!='X' && newboard[i][j]!='I'){
										closedBoard=false;
									}
								}
							}
							if((heroiPresente==1) && closedBoard && doorPresente && keyPresente){
								try {
									new GameWindow(newboard);
								} catch (IOException e) {
									e.printStackTrace();
								}
								frame.setEnabled(false);
							}
						}
					});

					if ((int) (lblKey.getBounds().y + lblKey.getBounds().getHeight()+ 10) > (int) (mapa.getBounds().y + mapa.getBounds().getHeight()+ 10)){
						btnNewButton.setBounds(230, (int) (lblKey.getBounds().y + lblKey.getBounds().getHeight()+ 10), 150, 35);
					} else {
						btnNewButton.setBounds(230, (int) (mapa.getBounds().y + mapa.getBounds().getHeight()-10), 150, 35);
					}
					
					frame.add(btnNewButton);
					

					frame.add(mapa);
					frame.repaint();
					
					btnCreate.setText("Reset");
					
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}
		});
		
		
		btnCreate.setBounds(309, 45, 89, 23);
		frame.add(btnCreate);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {  //Mover o icon at� � posi��o desejada	
		
		posX = e.getX();
		posY = e.getY();
		
		clickedIcon.setBounds(posX-25, posY-45, 35, 35);
		clickedIcon.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) { 
		
	}

	@Override
	public void mousePressed(MouseEvent e) { //Saber qual o icon desejado
		
		posX = e.getX();
		posY = e.getY();
		
		if (posX>=wall.getBounds().getMinX() && posX<=wall.getBounds().getMaxX() &&
				posY>=wall.getBounds().getMaxY() && posY<=wall.getBounds().getMaxY()+35){

			clickedIcon = wall;
			type = "wall";
		} else if (posX>=hero.getBounds().getMinX() && posX<=hero.getBounds().getMaxX() &&
				posY>=hero.getBounds().getMaxY() && posY<=hero.getBounds().getMaxY()+35){

			clickedIcon = hero;
			type = "hero";
		} else if (posX>=ogre.getBounds().getMinX() && posX<=ogre.getBounds().getMaxX() &&
				posY>=ogre.getBounds().getMaxY() && posY<=ogre.getBounds().getMaxY()+35){

			clickedIcon = ogre;
			type = "ogre";
		} else if (posX>=shield.getBounds().getMinX() && posX<=shield.getBounds().getMaxX() &&
				posY>=shield.getBounds().getMaxY() && posY<=shield.getBounds().getMaxY()+35){

			clickedIcon = shield;
			type = "shield";
		} else if (posX>=key.getBounds().getMinX() && posX<=key.getBounds().getMaxX() &&
				posY>=key.getBounds().getMaxY() && posY<=key.getBounds().getMaxY()+35){

			clickedIcon = key;
			type = "key";
		} else if (posX>=door.getBounds().getMinX() && posX<=door.getBounds().getMaxX() &&
				posY>=door.getBounds().getMaxY() && posY<=door.getBounds().getMaxY()+35){

			clickedIcon = door;
			type = "door";
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) { //Saber at� onde o icon � levado
		
		finalposX = posX;
		finalposY = posY;
		
		boardposX = (int) Math.ceil((finalposX - 28)/35);
		boardposY = (int) Math.ceil((finalposY - 123)/35);
		
		switch(type){
		case "wall":
			newboard[boardposY][boardposX]='X';
			wall.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 86, 35, 35);
			break;
		case "hero":
			newboard[boardposY][boardposX]='H';
			hero.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 210, 35, 35);
			break;
		case "shield":
			newboard[boardposY][boardposX]='+';
			shield.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 276, 35, 35);
			break;
		case "ogre":
			newboard[boardposY][boardposX]='O';
			ogre.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 146, 35, 35);
			break;
		case "key":
			newboard[boardposY][boardposX]='k';
			key.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 396, 35, 35);
			break;
		case "door":
			newboard[boardposY][boardposX]='I';
			door.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 336, 35, 35);
			break;
		}
		
		frame.repaint();

	}
}
