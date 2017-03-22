package dkeep.gui;

import java.applet.Applet;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dkeep.logic.Game;
import java.awt.Font;

public class GameWindow extends JFrame{

	private JFrame frame;
	private JButton btnUp;
	private JButton btnDown;
	private JButton btnLeft;
	private JButton btnRight;
	private int variavel = 0;
	private static char dir = ' ';
	private static JLabel lblYouCanStart;
	private JPanel panel;
	private JPanel panel2; 
	private static Game jogo = new Game();
	private static int number = 2;
	private static String guard = "Rookie";
	private JLabel lblGame;
	private char [][] board;

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
		jogo.setTabuleiro(board);
		number=jogo.ogreNumber();
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
			
			return;
		case -2:
			frame.repaint();
			lblYouCanStart.setText("Game Over!!!");
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			panel2.setEnabled(false);
			
			return;
		case -3:
			frame.repaint();
			lblYouCanStart.setText("Game Over!!!");
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			panel.setEnabled(false);
			
			return;
		case 1:
			lblYouCanStart.setText("Level 1");
			frame.repaint();
			panel.requestFocusInWindow();
			break;
		case 2:
			panel.setVisible(false);
			
			panel2 = new GameView(jogo.getTabuleiro(), false);
			panel2.setBounds(32, 49, 361, 362);
			frame.getContentPane().add(panel2);
			
			panel2.setFocusTraversalKeysEnabled(false);
			panel2.setFocusable(true);		
			KeyLis key = new KeyLis();		
			panel2.addKeyListener(key);
			panel2.requestFocusInWindow();
			
			break;
		case 3:
			lblYouCanStart.setText("Level 2");
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
			return;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 658, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(467, 382, 117, 29);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnExit);
		
		btnUp = new JButton("Up");
		btnUp.setBounds(467, 108, 117, 29);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dir='w';
				variavel = jogo.jogo(dir, guard, number);
				try {
					checkGame(variavel);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		frame.getContentPane().add(btnUp);
		
		btnDown = new JButton("Down");
		btnDown.setBounds(467, 258, 117, 29);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dir='s';
				variavel = jogo.jogo(dir, guard, number);
				try {
					checkGame(variavel);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		frame.getContentPane().add(btnDown);
		
		btnLeft = new JButton("Left");
		btnLeft.setBounds(423, 186, 89, 29);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dir='a';
				variavel = jogo.jogo(dir, guard, number);
				try {
					checkGame(variavel);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		frame.getContentPane().add(btnLeft);

		btnRight = new JButton("Right");
		btnRight.setBounds(543, 186, 89, 29);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dir='d';
				variavel = jogo.jogo(dir, guard, number);
				try {
					checkGame(variavel);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		frame.getContentPane().add(btnRight);

		lblYouCanStart = new JLabel("Level 1");
		lblYouCanStart.setBounds(33, 434, 422, 16);
		frame.getContentPane().add(lblYouCanStart);

		panel = new GameView(jogo.getTabuleiro(), false);
		panel.setBounds(32, 49, 361, 362);
		frame.getContentPane().add(panel);

		lblGame = new JLabel("Game");
		lblGame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGame.setBounds(319, 11, 55, 27);
		frame.getContentPane().add(lblGame);

	}

	class KeyLis implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				dir='a';
				variavel = jogo.jogo(dir, guard, number);
				try {
					checkGame(variavel);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			case KeyEvent.VK_RIGHT:
				dir='d';
				variavel = jogo.jogo(dir, guard, number);
				try {
					checkGame(variavel);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			case KeyEvent.VK_UP:
				dir='w';
				variavel = jogo.jogo(dir, guard, number);
				try {
					checkGame(variavel);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			case KeyEvent.VK_DOWN:
				dir='s';
				variavel = jogo.jogo(dir, guard, number);
				try {
					checkGame(variavel);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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

}
