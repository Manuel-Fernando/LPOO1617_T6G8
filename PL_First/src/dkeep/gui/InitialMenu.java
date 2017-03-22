package dkeep.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dkeep.logic.FileReader;

public class InitialMenu extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private int numberOgres;
	private String typeGuard;

	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialMenu window = new InitialMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InitialMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNum = new JLabel("Number of Ogres \r\n(max. 5)");
		lblNum.setBounds(36, 74, 161, 14);
		frame.getContentPane().add(lblNum);
		
		JLabel lblNewLabel = new JLabel("Guard Personality");
		lblNewLabel.setBounds(36, 126, 127, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(229, 71, 43, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDungeonKeep = new JLabel("Dungeon Keep");
		lblDungeonKeep.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDungeonKeep.setBounds(156, 11, 116, 34);
		frame.getContentPane().add(lblDungeonKeep);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rookie", "Suspicious", "Drunken"}));
		comboBox.setBounds(173, 123, 100, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblChooseANumber = new JLabel("Choose a number of Ogres");
		lblChooseANumber.setBounds(286, 74, 138, 14);
		frame.getContentPane().add(lblChooseANumber);
		lblChooseANumber.setVisible(false);
		
		JButton btnNewGame = new JButton("New Game");
		
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String numOgres = textField.getText();
				
				
				if (numOgres.isEmpty()){
					JOptionPane.showMessageDialog(frame, "Please enter a number of Ogres!"); 
					
				} else {
					
					numberOgres = Integer.parseInt(numOgres);
					
					if (numberOgres>5){
						JOptionPane.showMessageDialog(frame, "Please enter a valid number of Ogres! (between 1 and 5)");
					} else {
						int index = comboBox.getSelectedIndex();
						typeGuard = (String) comboBox.getItemAt(index);
						
						
						try {
							GameWindow gameWindow = new GameWindow (numberOgres, typeGuard);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}
				
			}
		});
		
		btnNewGame.setBounds(190, 281, 100, 34);
		frame.getContentPane().add(btnNewGame);
		
		JLabel lblCreateYourOwn = new JLabel("Create your own map for the game");
		lblCreateYourOwn.setBounds(36, 187, 236, 14);
		frame.getContentPane().add(lblCreateYourOwn);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LevelCreator lvlMap = new LevelCreator();
					lvlMap.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		});
		btnCreate.setBounds(295, 183, 100, 28);
		frame.getContentPane().add(btnCreate);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileReader file = new FileReader();
					try {
						new GameWindow(file.loadGame());
					} catch (IOException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(frame, "Game not loaded successfully!");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		btnLoadGame.setBounds(295, 232, 100, 34);
		frame.getContentPane().add(btnLoadGame);
		
		JLabel lblLoadYourGame = new JLabel("Load your game");
		lblLoadYourGame.setBounds(36, 242, 179, 14);
		frame.getContentPane().add(lblLoadYourGame);
		
	}
}
