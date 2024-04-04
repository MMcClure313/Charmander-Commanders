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
		optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
		add(optionsPanel, BorderLayout.CENTER);
		
		// Set Main Menu Screen Logo
		JLabel titleLabel = new JLabel(imageIcon);
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(titleLabel);
				
		// Create Start, Options, and Quit button
		JButton startBtn = new JButton("Start");
		startBtn.setFont(new Font("Arial Black", Font.BOLD, 12));
		startBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(startBtn);
		
		JButton statsBtn = new JButton("Statistics");
		statsBtn.setFont(new Font("Arial Black", Font.BOLD, 12));
		statsBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(statsBtn);
		
		JButton quitBtn = new JButton("Quit");
		quitBtn.setFont(new Font("Arial Black", Font.BOLD, 12));
		quitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(quitBtn);
		
	
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
        
        statsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScreenManager.getInstance().switchScreen(new StatsScreen());
            }
        });
        
        // Set background color
		setBackground(new Color(255, 255, 255));
		
	
	}
}
	
	
