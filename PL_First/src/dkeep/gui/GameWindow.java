package dkeep.gui;

import java.applet.Applet;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dkeep.logic.FileCreator;
import dkeep.logic.Game;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.Color;

public class GameWindow extends JFrame{

	private JFrame frame;
	private JButton btnUp;
	private JButton saveGame;
	private JButton btnDown;
	private JButton btnLeft;
	private JButton btnRight;
	private int variavel = 0;
	private static char dir = ' ';
	private static JLabel lblYouCanStart;
	private JPanel panel;
	private JPanel panel2; 
	private static Game jogo = new Game();
	private static int number = 0;
	private static String guard = "Rookie";
	private JLabel lblGame;
	private char [][] board;
	private int w;
	private int h;
	private boolean newLevel = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow(number, guard);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @wbp.parser.constructor
	 */
	public GameWindow(int n, String g) throws IOException {
		number = n;
		guard = g;
		initialize();
		panel.setFocusTraversalKeysEnabled(false);
		panel.setFocusable(true);		
		KeyLis key = new KeyLis();		
		panel.addKeyListener(key);
		panel.requestFocusInWindow();
	}
	 
	public GameWindow(char [][] b) throws IOException {
		board = b;
		h = b.length;
		w = b[0].length;
		newLevel = true;
		jogo.setTabuleiro(board, guard);
		number=jogo.ogreNumber();
		initialize();
		panel.setFocusTraversalKeysEnabled(false);
		panel.setFocusable(true);		
		KeyLis key = new KeyLis();		
		panel.addKeyListener(key);
		panel.requestFocusInWindow();
	}
	
	public GameWindow(char [][] b, String type, int n) throws IOException {
		board = b;
		h = b.length;
		w = b[0].length;
		newLevel = true;
		guard = type;
		jogo.setTabuleiro(board, guard);
		number = n;
		//number=jogo.ogreNumber();
		initialize();
		panel.setFocusTraversalKeysEnabled(false);
		panel.setFocusable(true);		
		KeyLis key = new KeyLis();		
		panel.addKeyListener(key);
		panel.requestFocusInWindow();
	}
	
	
	public void checkGame (int var) throws IOException{
		switch (variavel){
		case -1:
			frame.repaint();
			lblYouCanStart.setText("Game Over!!!");
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			panel.setEnabled(false);
			saveGame.setEnabled(false);
			break;
		case -3:
			frame.repaint();
			lblYouCanStart.setText("Game Over!!!");
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			panel.setEnabled(false);
			saveGame.setEnabled(false);
			
			return;
		case -2:
			frame.repaint();
			lblYouCanStart.setText("Game Over!!!");
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			panel2.setEnabled(false);
			saveGame.setEnabled(false);
			
			return;

		case 1:
			lblYouCanStart.setText("Level 1");
			frame.repaint();
			panel.requestFocusInWindow();
			break;
		case 2:
			panel.setVisible(false);
			
			panel2 = new GameView(jogo.getTabuleiro(), false);
			panel2.setBounds(32, 49, 323, 323);
			frame.getContentPane().add(panel2);
			lblYouCanStart.setText("Level 2");
			panel2.setFocusTraversalKeysEnabled(false);
			panel2.setFocusable(true);		
			KeyLis key = new KeyLis();		
			panel2.addKeyListener(key);
			panel2.requestFocusInWindow();
			break;
		case 3:
			frame.repaint();
			panel.requestFocusInWindow();
			panel2.requestFocusInWindow();
			break;
		case 4:
			frame.repaint();
			lblYouCanStart.setText("You won!!!");
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			panel.setEnabled(false);
			panel2.setEnabled(false);
			saveGame.setEnabled(false);
			return;
		case 5:
			lblYouCanStart.setText("Created Level");
			frame.repaint();
			panel.requestFocusInWindow();
			break;
		case 6:
			frame.repaint();
			lblYouCanStart.setText("You won!!!");
			btnUp.setEnabled(false); 
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			panel.setEnabled(false);
			saveGame.setEnabled(false);
			return;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		Image background = ImageIO.read(new File("src/Imagens/original.png"));
		frame = new JFrame();
		frame.setBounds(100, 100, 658, 497);
		frame.setContentPane(new ImagePanel(background));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	
		JButton btnExit = new JButton("Exit");
		btnExit.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnExit.setBackground(Color.GRAY.darker());
		btnExit.setForeground(Color.WHITE);
		btnExit.setBounds(470, 390, 100, 25);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnExit);
		
		btnUp = new JButton("Up");
		btnUp.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUp.setBackground(Color.GRAY.darker());
		btnUp.setForeground(Color.WHITE);
		btnUp.setBounds(490, 150, 60, 25);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goWhereSentYou('w');

			}
		});
		frame.getContentPane().add(btnUp);
		
		btnDown = new JButton("Down");
		btnDown.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDown.setBackground(Color.GRAY.darker());
		btnDown.setForeground(Color.WHITE);
		btnDown.setBounds(490, 250, 60, 25);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goWhereSentYou('s');
			}
		});

		frame.getContentPane().add(btnDown);
		
		btnLeft = new JButton("Left");
		btnLeft.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLeft.setBackground(Color.GRAY.darker());
		btnLeft.setForeground(Color.WHITE);
		btnLeft.setBounds(435, 200, 60, 25);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goWhereSentYou('a');
			}
		});

		frame.getContentPane().add(btnLeft);

		btnRight = new JButton("Right");
		btnRight.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRight.setBackground(Color.GRAY.darker());
		btnRight.setForeground(Color.WHITE);
		btnRight.setBounds(543, 200, 60, 25);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goWhereSentYou('d');
			}
		});

		frame.getContentPane().add(btnRight);

		saveGame = new JButton("Save Game");
		saveGame.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		saveGame.setBackground(Color.GRAY.darker());
		saveGame.setForeground(Color.WHITE);
		saveGame.setBounds(470, 340,  100, 25);
		saveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileCreator file = new FileCreator();
				
				try {
					file.saveGame(jogo.getTabuleiro(), guard, number);
					JOptionPane.showMessageDialog(frame, "Game saved successfully!");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});

		frame.getContentPane().add(saveGame);
		
		lblYouCanStart = new JLabel("Level 1");
		lblYouCanStart.setForeground(Color.WHITE);
		lblYouCanStart.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		lblYouCanStart.setBounds(33, 425, 422, 16);
		frame.getContentPane().add(lblYouCanStart);

		panel = new GameView(jogo.getTabuleiro(), false);
		
		if (newLevel){
			if (w*36>=359 || h*36>=359){
				panel.setBounds(32, 49, w*36, h*36);
				frame.setBounds(100, 100, (int)(panel.getBounds().getWidth()+panel.getBounds().x+220), (int)(panel.getBounds().getHeight()+panel.getBounds().y+70));
				btnUp.setBounds((int) (panel.getBounds().getWidth()+panel.getBounds().x + 80), 150, 60, 25);
				btnDown.setBounds((int) (panel.getBounds().getWidth()+panel.getBounds().x + 80), 250, 60, 25);
				btnRight.setBounds((int) (panel.getBounds().getWidth()+panel.getBounds().x + 130), 200, 60, 25);
				btnLeft.setBounds((int) (panel.getBounds().getWidth()+panel.getBounds().x + 30), 200, 60, 25);
				btnExit.setBounds((int) (panel.getBounds().getWidth()+panel.getBounds().x +60), 390, 100, 25);
				saveGame.setBounds((int) (panel.getBounds().getWidth()+panel.getBounds().x + 60), 340,  100, 25);
			} else if (w*36<359 || h*36<359){
				panel.setBounds(32, 49, w*36, h*36);
			}
		} else {
			panel.setBounds(32, 49, 359, 359);
		}
		frame.getContentPane().add(panel);

		lblGame = new JLabel("Dungeon Keep");
		lblGame.setForeground(Color.WHITE);
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGame.setBounds(250, 11, 150, 27);
		frame.getContentPane().add(lblGame);

	}

	class KeyLis implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				goWhereSentYou('a');
				break;
			case KeyEvent.VK_RIGHT:
				goWhereSentYou('d');
				break;
			case KeyEvent.VK_UP:
				goWhereSentYou('w');
				break;
			case KeyEvent.VK_DOWN:
				goWhereSentYou('s');
				break;
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

	}
	
	public void goWhereSentYou(char direcao){
		variavel = jogo.jogo(direcao, guard, number);
		try {
			checkGame(variavel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}