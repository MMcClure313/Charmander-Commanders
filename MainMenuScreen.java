import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;


/**
 * Main menu class to display elements.
 * @author matth TayorF
 *
 */
public class MainMenuScreen extends Screen {
	
	public MainMenuScreen() {
		
		this.setLayout(new BorderLayout());
		
		// Get Main Menu screen Logo
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/WordGameTitle.png"));
		Image image = imageIcon.getImage();
		Image newImage = image.getScaledInstance(350, 200, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newImage);
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBackground(new Color(128, 128, 128));
		optionsPanel.setLayout(null);
		add(optionsPanel, BorderLayout.CENTER);
		
		// Set Main Menu Screen Logo
		JLabel titleLabel = new JLabel(imageIcon);
		titleLabel.setBounds(83, 0, 245, 80);
		optionsPanel.add(titleLabel);
		titleLabel.setLabelFor(this);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		// Create Start, Options, and Quit button
		JButton startBtn = new JButton("Start");
		startBtn.setFont(new Font("Arial Black", Font.BOLD, 12));
		startBtn.setBounds(159, 110, 89, 23);
		optionsPanel.add(startBtn);
		
		JButton optionsBtn = new JButton("Options");
		optionsBtn.setFont(new Font("Arial Black", Font.BOLD, 12));
		optionsBtn.setBounds(159, 144, 89, 23);
		optionsPanel.add(optionsBtn);
		
		JButton quitBtn = new JButton("Quit");
		quitBtn.setFont(new Font("Arial Black", Font.BOLD, 12));
		quitBtn.setBounds(159, 178, 89, 23);
		optionsPanel.add(quitBtn);
		
		
		// Button Action Listeners
		// Start button action to start the game
		/*
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform actions when Start button is clicked
                // Switch to the game screen
            	GameScreen gameScreen = null;
				try {
					gameScreen = new GameScreen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	gameScreen.switchToThis();
                
            }
        });*/
        // Options button to change settings
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform actions when Options button is clicked
                // Change difficulty, set Theme
            	OptionsScreen optionsScreen = new OptionsScreen();
            	optionsScreen.switchToThis();
            	//ScreenManager.getInstance().switchScreen(new OptionsScreen());
                
            }
        });
        // Quit button to exit the application
        quitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //exit the application
                System.exit(0);
            }
        });

        
        // Set background color
		setBackground(new Color(255, 255, 255));
		
	
	}
}
	
	
