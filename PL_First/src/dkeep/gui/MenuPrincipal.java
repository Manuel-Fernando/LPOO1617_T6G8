package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dkeep.logic.Game;
import dkeep.logic.Map;
import dkeep.logic.MapLevel1;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame implements KeyListener{

	private static JFrame frame1;
	private static JFrame frame2;
	private JTextField textField1;
	private static int number;
	private static String guard;
	private static Game jogo = new Game();
	private static char dir = ' ';
	private static JLabel lblYouCanStart;
	private static JButton btnNewGame;
	private JPanel panel;
	private JPanel panel2;
	private int variavel = 0;
	private JButton btnUp;
	private JButton btnDown;
	private JButton btnLeft;
	private JButton btnRight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame1.setVisible(true);
					frame2.requestFocusInWindow();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public MenuPrincipal() throws IOException {
		addKeyListener(this);
		initialize();
		
	}
	
	public static String printBoard(char [][]board){
		String s=new String();
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				s=s+board[i][j]+' ';
			}s=s+'\n';			
		} 	
		return s;
	}
	
	public void checkGame (int var) throws IOException{
		switch (variavel){
		case -1:
			frame2.repaint();
			//textArea.setText(printBoard(jogo.tabuleiro1()));
			lblYouCanStart.setText("Perdeu o Jogo!!!");
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			
			return;
		case -2:
			frame2.repaint();
			//textArea.setText(printBoard(jogo.tabuleiro2()));; 
			lblYouCanStart.setText("Perdeu o Jogo!!!");
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			
			return;
		case 1:
			frame2.repaint();
			//textArea.setText(printBoard(jogo.tabuleiro1()));
			break;
		case 2:
			//textArea.setText(printBoard(jogo.tabuleiro2()));
			panel.setVisible(false);
			
			panel2 = new GameView(jogo.getTabuleiro(), false);
			panel2.setBounds(10, 116, 361, 362);
			frame2.getContentPane().add(panel2);
			
			lblYouCanStart.setText("Nivel 2");
			frame2.repaint();
			break;
		case 3:
			frame2.repaint();
			//textArea.setText(printBoard(jogo.tabuleiro2()));
			break;
		case 4:
			frame2.repaint();
			//textArea.setText(printBoard(jogo.tabuleiro2()));
			lblYouCanStart.setText("Ganhou o Jogo!!!");
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			
			return;
		}					

	}


	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame2 = new JFrame();
		frame2.setVisible(false);
		frame2.setBounds(100, 100, 658, 497);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
	
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(467, 382, 117, 29);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		frame2.getContentPane().add(btnExit);
		
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
		//btnUp.setEnabled(false);
		frame2.getContentPane().add(btnUp);
		
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

		//btnDown.setEnabled(false);
		frame2.getContentPane().add(btnDown);
		
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
		//btnLeft.setEnabled(false);
		frame2.getContentPane().add(btnLeft);
		
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
		//btnRight.setEnabled(false);
		frame2.getContentPane().add(btnRight);
		
		lblYouCanStart = new JLabel("You can start a new game");
		lblYouCanStart.setBounds(33, 434, 203, 16);
		frame2.getContentPane().add(lblYouCanStart);
		
		panel = new GameView(jogo.getTabuleiro(), false);
		panel.setBounds(32, 49, 361, 362);
		frame2.getContentPane().add(panel);
		
		/*
		 * Menu Inicial para ajustar defini��es jogo
		 * 
		 */
		
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 450, 300);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblNum = new JLabel("Number of Ogres \r\n(max. 5)");
		lblNum.setBounds(36, 74, 126, 14);
		frame1.getContentPane().add(lblNum);
		
		JLabel lblNewLabel = new JLabel("Guard Personality");
		lblNewLabel.setBounds(36, 126, 92, 14);
		frame1.getContentPane().add(lblNewLabel);
		
		textField1 = new JTextField();
		textField1.setBounds(173, 74, 43, 20);
		frame1.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		JLabel lblDungeonKeep = new JLabel("Dungeon Keep");
		lblDungeonKeep.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDungeonKeep.setBounds(156, 11, 116, 34);
		frame1.getContentPane().add(lblDungeonKeep);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rookie", "Suspicious", "Drunken"}));
		comboBox.setBounds(173, 123, 100, 20);
		frame1.getContentPane().add(comboBox);
		
		JButton btnNewGame = new JButton("New Game");
		
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String numOgres = textField1.getText();	
				number = Integer.parseInt(numOgres);
				
				if (number>5){
					number = 5;
				}

				int index = comboBox.getSelectedIndex();
				guard = (String) comboBox.getItemAt(index);
				
				//frame1.setVisible(false);
				frame2.setVisible(true);
				frame2.requestFocusInWindow();

			}
		});
		
		btnNewGame.setBounds(172, 183, 100, 34);
		frame1.getContentPane().add(btnNewGame);
	}
	
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
