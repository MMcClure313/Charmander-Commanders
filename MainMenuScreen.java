
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;



/**
 * Main menu class to display elements.
 * @author matth
 *
 */
public class MainMenuScreen extends Screen {
	private Dimension windowSize;

	public MainMenuScreen() {
		
		this.setLayout(new BorderLayout());
		
		//Create Title panel and text		
		JPanel titlePanel = new JPanel();
		
		JLabel titleLabel = new JLabel("WORD GAME"); // Title text
		titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 50));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.setBackground(new Color(255, 239, 205));
		titlePanel.add(titleLabel); // Add title to panel
		
		//Create Options panel and buttons
		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
		
		JButton newGameButton = new JButton("New Game");
		JButton optionsButton = new JButton("Options");
		JButton quitButton = new JButton("Quit");
		
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					newGameButtonClicked();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
		optionsPanel.add(newGameButton);
		optionsPanel.add(optionsButton);
		optionsPanel.add(quitButton);
		
		


		add(titlePanel, BorderLayout.PAGE_START);
		add(optionsPanel, BorderLayout.CENTER);
						
	
	}
	
	private void newGameButtonClicked() throws IOException {
		GameScreen gameScreen = new GameScreen();
		gameScreen.switchToThis();
	}
	
	
	
}