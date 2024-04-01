
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

public class OptionsScreen extends Screen{
	
	
	
	public OptionsScreen()
	{
		setMinimumSize(new Dimension(500, 305));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBackground(new Color(255, 255, 255));
		add(optionsPanel);
		optionsPanel.setLayout(null);
		
		//Title label
		JLabel optionsLabel = new JLabel("Options");
		optionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		optionsLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		optionsLabel.setBounds(137, 11, 173, 22);
		optionsPanel.add(optionsLabel);
		
		
		// Header Labels
		JLabel difficultyLabel = new JLabel("Difficulty");
		difficultyLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		difficultyLabel.setBounds(335, 44, 165, 23);
		optionsPanel.add(difficultyLabel);
		
		JLabel themeLabel = new JLabel("Theme");
		themeLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		themeLabel.setBounds(166, 44, 109, 23);
		optionsPanel.add(themeLabel);
		
		JLabel settingsLabel = new JLabel("Settings");
		settingsLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		settingsLabel.setBounds(6, 44, 82, 23);
		optionsPanel.add(settingsLabel);
		
		JLabel timerLabel = new JLabel("Timer");
		timerLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		timerLabel.setBounds(6, 95, 46, 14);
		optionsPanel.add(timerLabel);
		
		
		
		//Difficulty buttons
		JRadioButton easyBtn = new JRadioButton("Easy");
		easyBtn.setSelected(true);
		easyBtn.setFont(new Font("Arial Black", Font.PLAIN, 11));
		easyBtn.setBounds(335, 77, 109, 23);
		optionsPanel.add(easyBtn);
		
		JRadioButton mediumBtn = new JRadioButton("Medium");
		mediumBtn.setFont(new Font("Arial Black", Font.PLAIN, 11));
		mediumBtn.setBounds(335, 116, 109, 23);
		optionsPanel.add(mediumBtn);
		
		JRadioButton hardBtn = new JRadioButton("Hard");
		hardBtn.setFont(new Font("Arial Black", Font.PLAIN, 11));
		hardBtn.setBounds(335, 154, 109, 23);
		optionsPanel.add(hardBtn);
		
		//Group difficulty buttons together
		ButtonGroup difficultyBtnGroup = new ButtonGroup();
		difficultyBtnGroup.add(easyBtn);
		difficultyBtnGroup.add(mediumBtn);
		difficultyBtnGroup.add(hardBtn);
		
		
		//Timer on and off buttons
		JRadioButton onBtn = new JRadioButton("On");
		onBtn.setFont(new Font("Arial Black", Font.PLAIN, 11));
		onBtn.setBounds(6, 116, 109, 23);
		optionsPanel.add(onBtn);
		
		JRadioButton offBtn = new JRadioButton("Off");
		offBtn.setSelected(true);
		offBtn.setFont(new Font("Arial Black", Font.PLAIN, 11));
		offBtn.setBounds(6, 142, 109, 23);
		optionsPanel.add(offBtn);
		
		//Group timer on and off button together
		ButtonGroup timerBtnGroup = new ButtonGroup();
		timerBtnGroup.add(offBtn);
		timerBtnGroup.add(onBtn);
		
		
		// Box for the user to select the theme
		JComboBox<String> themeBox = new JComboBox<String>();
		themeBox.setBounds(137, 69, 173, 22);
		themeBox.addItem("Default");
		optionsPanel.add(themeBox);
		
		
		
		// Main menu button to return to the main menu screen
		JButton mainMenuBtn = new JButton("Main Menu");
		mainMenuBtn.setFont(new Font("Arial Black", Font.BOLD, 12));
		mainMenuBtn.setBounds(166, 244, 124, 23);
		optionsPanel.add(mainMenuBtn);
		
		JButton beginBtn = new JButton("Begin");
		beginBtn.setFont(new Font("Arial Black", Font.BOLD, 12));
		beginBtn.setBounds(166, 150, 124, 23);
		optionsPanel.add(beginBtn);
		
		// Action listener for the main menu button
		mainMenuBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform actions when MainMenu button is clicked
                // Return back to the Main Menu
            	ScreenManager.getInstance().switchScreen(new MainMenuScreen());
                
            }
        });

		
		//So this is where all the settings are going to go for the game. We'll make GameScreen construct with a few paramaters for difficulty, timed, and themes in order to make it work.
		beginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GameScreen gmScreen = null;
				
				try {
					String difficulty = "";
					
				    for (Enumeration buttons = difficultyBtnGroup.getElements(); buttons.hasMoreElements();) {
				        AbstractButton button = (AbstractButton) buttons.nextElement();

				        if (button.isSelected()) {
				            difficulty = button.getText();
				            break;
				        }
				    }
					
					gmScreen = new GameScreen(difficulty);
					
				} catch(IOException e1) {
					e1.printStackTrace();
				}
				
				gmScreen.switchToThis();
			}
			
		});
		
		
		
		
	}
}