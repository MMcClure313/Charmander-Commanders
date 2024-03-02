import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class GameScreen extends Screen {
	private Dimension windowSize;
	
	public GameScreen(Dimension FrameWindow) {
		windowSize = FrameWindow;
		
		this.setLayout(new BorderLayout());
		
		
		
		
		//The top panel, going to be used to read the word length, display hidden and revealed letters
		//Whatever gameScreen logic that we have will read from gameLogic to get the correct 
		JPanel wordPanel = new JPanel();
		wordPanel.setPreferredSize(new Dimension((windowSize.width), windowSize.height/4));
		wordPanel.setBackground(new Color(122, 122, 122));
		//titleLabel.setFont(new Font("Arial", Font.BOLD, 50));

		//WestAligned Grid Panel that will carry the elements of gameplay
		JPanel playPanel = new JPanel();
		playPanel.setLayout(new GridLayout(3, 1));
		
		
		//The three panels made here are for debug purposes. They will likely be made in a seperate class that communicates with the word game logic, and then returns information to here to be displayed
		JPanel guessedPanel = new JPanel();
		guessedPanel.setPreferredSize(new Dimension(windowSize.width/3*2, windowSize.height/4));
		guessedPanel.setBackground(Color.RED);
		
		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(windowSize.width/3*2, windowSize.height/4));
		textPanel.setBackground(Color.GREEN);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(windowSize.width/3*2, windowSize.height/4));
		buttonPanel.setBackground(Color.BLUE);
		
		playPanel.add(guessedPanel);
		playPanel.add(textPanel);
		playPanel.add(buttonPanel);
		
		
		
		add(wordPanel, BorderLayout.NORTH);
		add(playPanel, BorderLayout.WEST);
		
		
		
		
		
		
		
	}
	
}
