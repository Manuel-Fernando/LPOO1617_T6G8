package dkeep.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dkeep.logic.FileReader;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

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
	 * @throws IOException 
	 */
	public InitialMenu() throws IOException {
		initialize();
	}

	/** 
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		Image background = ImageIO.read(new File("src/Imagens/original.png"));
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 365);
		frame.setContentPane(new ImagePanel(background));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNum = new JLabel("Number of Ogres \r\n(max. 5)");
		lblNum.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblNum.setForeground(Color.WHITE);
		lblNum.setBounds(66, 74, 161, 14);
		frame.getContentPane().add(lblNum);
		
		JLabel lblNewLabel = new JLabel("Guard Personality");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(92, 126, 127, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(229, 71, 43, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDungeonKeep = new JLabel("Dungeon Keep");
		lblDungeonKeep.setForeground(Color.WHITE);
		lblDungeonKeep.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDungeonKeep.setBounds(156, 11, 200, 34);
		frame.getContentPane().add(lblDungeonKeep);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rookie", "Suspicious", "Drunken"}));
		comboBox.setBounds(229, 123, 100, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewGame.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null)); 
		btnNewGame.setBackground(Color.GRAY.darker());
		btnNewGame.setForeground(Color.WHITE);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String numOgres = textField.getText();
				
				
				if (numOgres.isEmpty()){
					JOptionPane.showMessageDialog(frame, "Please enter a number of Ogres!");
					
				} else {
					
					boolean validCaracter = true;
					
					try { 
						numberOgres = Integer.parseInt(numOgres);
				    } catch(NumberFormatException e) { 
				        validCaracter = false; 
				    }
					
					if (validCaracter){
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
					} else {
						JOptionPane.showMessageDialog(frame, "Please insert a number!");
					}
					

				}
				
			}
		});
		
		btnNewGame.setBounds(172, 169, 100, 25);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnCreate = new JButton("Create your Game");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCreate.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null)); 
		btnCreate.setBackground(Color.GRAY.darker());
		btnCreate.setForeground(Color.WHITE);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LevelCreator lvlMap = new LevelCreator();
					//lvlMap.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		});
		btnCreate.setBounds(172, 214, 100, 25);
		frame.getContentPane().add(btnCreate);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLoadGame.setForeground(Color.WHITE);
		btnLoadGame.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null)); 
		btnLoadGame.setBackground(Color.GRAY.darker());
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileReader file = new FileReader();
					
					try {
						new GameWindow(file.loadGame(), file.getGuardType(), file.getNumOgres());
					} catch (IOException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(frame, "Game not loaded successfully!");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		btnLoadGame.setBounds(172, 258, 100, 25);
		frame.getContentPane().add(btnLoadGame);
		
	}
}