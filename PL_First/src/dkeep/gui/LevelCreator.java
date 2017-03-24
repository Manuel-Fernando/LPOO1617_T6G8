package dkeep.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import dkeep.gui.GameWindow.KeyLis;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LevelCreator extends JFrame implements MouseMotionListener, MouseListener{

	private JFrame frame;
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
	private JPanel clickedIcon;
	private int boardposX, boardposY;
	private String type;
	private char [][] newboard;
	private JButton btnNewButton;
	private boolean canCreate = false;
	
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
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LevelCreator() throws IOException{
		initialize();
		frame.setFocusable(true);			
		frame.addMouseListener(this);
		frame.addMouseMotionListener(this);
		frame.requestFocusInWindow();
	}

	/**
	 * Create the frame.
	 * @return 
	 * @throws IOException 
	 */
	public void initialize() throws IOException {		
		Image background = ImageIO.read(new File("src/Imagens/original.png"));
		frame = new JFrame();
		
		frame.setBounds(100, 100, 640, 550);
		ImagePanel imagePanel = new ImagePanel(background);
		frame.setContentPane(imagePanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblCreateYourOwn = new JLabel("Create your own Map");
		lblCreateYourOwn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateYourOwn.setForeground(Color.WHITE);
		lblCreateYourOwn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCreateYourOwn.setBounds(225, 11, 200, 22);
		frame.getContentPane().add(lblCreateYourOwn);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setForeground(Color.WHITE);
		lblSize.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblSize.setBounds(190, 49, 27, 14);
		frame.getContentPane().add(lblSize);
		
		altura = new JTextField();
		altura.setBounds(225, 46, 50, 20);
		frame.getContentPane().add(altura);
		altura.setColumns(10);
		
		largura = new JTextField();
		largura.setBounds(300, 46, 50, 20);
		frame.getContentPane().add(largura);
		largura.setColumns(10);
		
		JLabel lblX = new JLabel("x");
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblX.setBounds(280, 49, 15, 14);
		frame.getContentPane().add(lblX);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCreate.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null)); 
		btnCreate.setBackground(Color.GRAY.darker());
		btnCreate.setForeground(Color.WHITE);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				canCreate = true;

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

				if(altura.getText().isEmpty() || largura.getText().isEmpty()){
					JOptionPane.showMessageDialog(frame, "Please insert valid numbers!");
				} else {
					
					boolean validCaracter = true;
					boolean validSize = true;
					try { 
						n = Integer.valueOf(altura.getText());
						m = Integer.valueOf(largura.getText());
						
						if (n<6 || m<6 || n>15 || m>15){
							JOptionPane.showMessageDialog(frame, "Minimum size: 6 and Maximum size: 15");
							validSize = false;
						}
						
				    } catch(NumberFormatException e) { 
				        validCaracter = false; 
				    }

					if (validCaracter && validSize){
						try {
							newboard = new char[n][m];
							mapa = new GameView(newboard, true);
							frame.repaint();		

							mapa.setBounds(28, 88, m*36, n*36);

							if ((int)(mapa.getBounds().getWidth()+mapa.getBounds().x+100)>640 || (int)(mapa.getBounds().getHeight()+mapa.getBounds().y+50)>550){
								System.out.println("aqui");
								frame.setBounds(100, 100, (int)(mapa.getBounds().getWidth()+mapa.getBounds().x+150), (int)(mapa.getBounds().getHeight()+mapa.getBounds().y+70));
							}

							wall = new WallIcon();
							wall.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 86, 35, 35);
							frame.getContentPane().add(wall);
							wall.repaint();

							ogre = new OgreIcon();
							ogre.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 146, 35, 35);
							frame.getContentPane().add(ogre);
							ogre.repaint();

							hero = new HeroIcon();
							hero.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 210, 35, 35);
							frame.getContentPane().add(hero);
							hero.repaint();

							shield = new ShieldIcon();
							shield.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 276, 35, 35);
							frame.getContentPane().add(shield);
							shield.repaint();

							door = new DoorIcon();
							door.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 336, 35, 35);
							frame.getContentPane().add(door);
							door.repaint();

							key = new KeyIcon();
							key.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 396, 35, 35);
							frame.getContentPane().add(key);
							key.repaint();

							lblWall = new JLabel("Wall");
							lblWall.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
							lblWall.setForeground(Color.WHITE);
							lblWall.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 123, 27, 14);
							frame.getContentPane().add(lblWall);

							lblOgre = new JLabel("Ogre");
							lblOgre.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
							lblOgre.setForeground(Color.WHITE);
							lblOgre.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 184, 46, 14);
							frame.getContentPane().add(lblOgre);

							lblHero = new JLabel("Hero");
							lblHero.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
							lblHero.setForeground(Color.WHITE);
							lblHero.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 247, 27, 14);
							frame.getContentPane().add(lblHero);

							lblShield = new JLabel("Shield");
							lblShield.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
							lblShield.setForeground(Color.WHITE);
							lblShield.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 314, 35, 14);
							frame.getContentPane().add(lblShield);

							lblDoor = new JLabel("Door");
							lblDoor.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
							lblDoor.setForeground(Color.WHITE);
							lblDoor.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 376, 35, 14);
							frame.getContentPane().add(lblDoor);

							lblKey = new JLabel("Key");
							lblKey.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
							lblKey.setForeground(Color.WHITE);
							lblKey.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 436, 35, 14);
							frame.getContentPane().add(lblKey);

							btnNewButton = new JButton("Save and Play");
							btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
							btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null)); 
							btnNewButton.setBackground(Color.GRAY.darker());
							btnNewButton.setForeground(Color.WHITE);
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
									}else {
										JOptionPane.showMessageDialog(frame, "You have to add walls, exit door, key, Ogres and 1 hero!");
									}
								}
							});

							if ((int) (lblKey.getBounds().y + lblKey.getBounds().getHeight()+ 10) > (int) (mapa.getBounds().y + mapa.getBounds().getHeight()+ 10)){
								btnNewButton.setBounds(300, (int) (lblKey.getBounds().y + lblKey.getBounds().getHeight()+ 10), 90, 25);
							} else {
								btnNewButton.setBounds(300, (int) (mapa.getBounds().y + mapa.getBounds().getHeight()-10), 90, 25);
							}

							frame.getContentPane().add(btnNewButton);


							frame.getContentPane().add(mapa);
							frame.repaint();

							btnCreate.setText("Reset");

						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (validSize){
						JOptionPane.showMessageDialog(frame, "Please insert a number!");
					}
					
				}
				
			}
		});
		
		
		btnCreate.setBounds(380, 45, 89, 23);
		frame.getContentPane().add(btnCreate);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {  //Mover o icon at� � posi��o desejada	
		
		posX = e.getX();
		posY = e.getY();
		
		if (clickedIcon != null){
			clickedIcon.setBounds(posX-25, posY-45, 35, 35);
			clickedIcon.repaint();
		}
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

		if(canCreate){
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
			} else {
				type = "empty";
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) { //Saber at� onde o icon � levado

		if (canCreate){
			finalposX = posX;
			finalposY = posY;

			boardposX = (int) Math.ceil((finalposX - 28)/35);
			boardposY = (int) Math.ceil((finalposY - 123)/35);

			if (boardposX< newboard[0].length && boardposY< newboard.length){

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
				case "empty":
					break;	
				}

			}
			frame.repaint();
		}
	}
}
