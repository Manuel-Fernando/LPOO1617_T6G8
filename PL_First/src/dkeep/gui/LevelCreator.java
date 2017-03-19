package dkeep.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LevelCreator extends JFrame implements MouseMotionListener, MouseListener{

	private JPanel contentPane;
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
	private JPanel guard;
	private JPanel hero;
	private JLabel lblWall;
	private JLabel lblOgre;
	private JLabel lblHero;
	private JLabel lblGuard;
	private JLabel lblPleaseInsertW;
	
	public void init(){
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}

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

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public LevelCreator() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateYourOwn = new JLabel("Create your own Map");
		lblCreateYourOwn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCreateYourOwn.setBounds(137, 11, 169, 22);
		contentPane.add(lblCreateYourOwn);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(28, 49, 27, 14);
		contentPane.add(lblSize);
		
		altura = new JTextField();
		altura.setBounds(65, 46, 86, 20);
		contentPane.add(altura);
		altura.setColumns(10);
		
		largura = new JTextField();
		largura.setBounds(191, 46, 86, 20);
		contentPane.add(largura);
		largura.setColumns(10);
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(166, 49, 15, 14);
		contentPane.add(lblX);
		
		lblPleaseInsertW = new JLabel("Please Insert W and H");
		lblPleaseInsertW.setVisible(false);
		lblPleaseInsertW.setBounds(149, 77, 46, 14);
		contentPane.add(lblPleaseInsertW);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				while (altura.getText().equals("") || largura.getText().equals("")){
//					lblPleaseInsertW.setVisible(true);
//				}
				
				if (btnCreate.getText() == "Reset"){
					contentPane.remove(mapa);
					contentPane.remove(wall);
					contentPane.remove(ogre);
					contentPane.remove(hero);
					contentPane.remove(guard);
					contentPane.remove(lblWall);
					contentPane.remove(lblOgre);
					contentPane.remove(lblGuard);
					contentPane.remove(lblHero);
					mapa.removeAll();
				}
				
				n = Integer.valueOf(altura.getText());
				m = Integer.valueOf(largura.getText());
				
				try {
					mapa = new NewLevel(n, m);
					mapa.setBounds(28, 88, n*38, m*38);
					
					if ((int)(mapa.getBounds().getWidth()+mapa.getBounds().x+100)>640 || (int)(mapa.getBounds().getHeight()+mapa.getBounds().y+50)>430){
						setBounds(100, 100, (int)(mapa.getBounds().getWidth()+mapa.getBounds().x+150), (int)(mapa.getBounds().getHeight()+mapa.getBounds().y+50));
					}
					
					wall = new WallIcon();
					wall.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 86, 35, 35);
					contentPane.add(wall);
					wall.repaint();
					
					ogre = new OgreIcon();
					ogre.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 146, 35, 35);
					contentPane.add(ogre);
					ogre.repaint();
					
					hero = new HeroIcon();
					hero.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 210, 35, 35);
					contentPane.add(hero);
					hero.repaint();
					
					guard = new GuardIcon();
					guard.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 276, 35, 35);
					contentPane.add(guard);
					guard.repaint();
					
					lblWall = new JLabel("Wall");
					lblWall.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 123, 27, 14);
					contentPane.add(lblWall);
					
					lblOgre = new JLabel("Ogre");
					lblOgre.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 184, 46, 14);
					contentPane.add(lblOgre);
					
					lblHero = new JLabel("Hero");
					lblHero.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 247, 27, 14);
					contentPane.add(lblHero);
					
					lblGuard = new JLabel("Guard");
					lblGuard.setBounds((int)(mapa.getBounds().getWidth()+mapa.getBounds().x + 50), 314, 35, 14);
					contentPane.add(lblGuard);

					contentPane.add(mapa);
					contentPane.repaint();
					
					btnCreate.setText("Reset");
					
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}
		});
		
		
		btnCreate.setBounds(309, 45, 89, 23);
		contentPane.add(btnCreate);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {  //Mover o icon até à posição desejada
		posX = e.getX();
		posY = e.getY();
		
		wall.setBounds(posX, posY, 35, 35);
		wall.repaint();
		
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
	public void mouseExited(MouseEvent e) { //Saber até onde o icon é levado
		finalposX = posX;
		finalposY = posY;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
