package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dkeep.logic.Game;
import dkeep.logic.MapLevel1;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal {

	private JFrame frame;
	private JTextField textField;
	private boolean state = false;
	static int number;
	static String guard;
	static Game jogo;
	static char dir = ' ';
	static JLabel lblYouCanStart;
	static JTextArea textArea;
	static JButton btnNewGame;
	int variavel = 0;
	JButton btnUp;
	JButton btnDown;
	JButton btnLeft;
	JButton btnRight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
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
	
	public void checkGame (int var){
		switch (variavel){
		case -1:
			textArea.setText(printBoard(jogo.tabuleiro1()));
			lblYouCanStart.setText("Perdeu o Jogo!!!");
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			
			return;
		case -2:
			textArea.setText(printBoard(jogo.tabuleiro2()));; 
			lblYouCanStart.setText("Perdeu o Jogo!!!");
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			
			return;
		case 1:
			textArea.setText(printBoard(jogo.tabuleiro1()));
			break;
		case 2:
			textArea.setText(printBoard(jogo.tabuleiro2()));
			lblYouCanStart.setText("Nivel 2");
			break;
		case 3:
			textArea.setText(printBoard(jogo.tabuleiro2()));
			break;
		case 4:
			textArea.setText(printBoard(jogo.tabuleiro2()));
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
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumberOfOgres = new JLabel("Number of Ogres");
		lblNumberOfOgres.setBounds(20, 19, 127, 16);
		frame.getContentPane().add(lblNumberOfOgres);
		
		JLabel lblGuardPersonality = new JLabel("Guard Personality");
		lblGuardPersonality.setBounds(20, 40, 110, 16);
		frame.getContentPane().add(lblGuardPersonality);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setBounds(143, 14, 33, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rookie", "Suspicious", "Drunken"}));
		comboBox.setBounds(142, 36, 100, 27);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewGame = new JButton("New Game");		
		btnNewGame.setBounds(305, 35, 117, 29);
		frame.getContentPane().add(btnNewGame);
	
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnExit.setBounds(305, 243, 117, 29);
		frame.getContentPane().add(btnExit);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		textArea.setEditable(false);
		textArea.setBounds(20, 85, 203, 187);
		frame.getContentPane().add(textArea);
		
		btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dir='w';
				variavel = jogo.jogo(dir, guard, number);
				checkGame(variavel);

			}
		});
		btnUp.setEnabled(false);
		btnUp.setBounds(305, 88, 117, 29);
		frame.getContentPane().add(btnUp);
		
		btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dir='s';
				variavel = jogo.jogo(dir, guard, number);
				checkGame(variavel);
			}
		});

		btnDown.setEnabled(false);
		btnDown.setBounds(305, 202, 117, 29);
		frame.getContentPane().add(btnDown);
		
		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dir='a';
				variavel = jogo.jogo(dir, guard, number);
				checkGame(variavel);
			}
		});
		btnLeft.setEnabled(false);
		btnLeft.setBounds(231, 144, 89, 29);
		frame.getContentPane().add(btnLeft);
		
		btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dir='d';
				variavel = jogo.jogo(dir, guard, number);
				checkGame(variavel);
			}
		});
		btnRight.setEnabled(false);
		btnRight.setBounds(355, 144, 89, 29);
		frame.getContentPane().add(btnRight);
		
		lblYouCanStart = new JLabel("You can start a new game");
		lblYouCanStart.setBounds(20, 392, 203, 16);
		frame.getContentPane().add(lblYouCanStart);
		
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnUp.setEnabled(true);
				btnDown.setEnabled(true);
				btnLeft.setEnabled(true);
				btnRight.setEnabled(true);
				
				jogo = new Game();

				String numOgres = textField.getText();	
				number = Integer.parseInt(numOgres);
				
				if (number>5){
					number = 5;
				}
			
				int index = comboBox.getSelectedIndex();
				guard = (String) comboBox.getItemAt(index);

				textArea.setText(printBoard(jogo.tabuleiro1()));
				
				lblYouCanStart.setText("Nivel 1");
			}
		});
		
		
	}
}
