
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.BorderFactory;

public class OptionsScreen extends Screen{
	
	private JComboBox<String> gameModeComboBox;
	private JComboBox<String> themeComboBox;
	private JComboBox<String> difficultyComboBox;
	
	public OptionsScreen() {
		
		this.setLayout(new BorderLayout());
		
		JPanel gameModePanel = new JPanel();
		JPanel themePanel = new JPanel();
		JPanel difficultyPanel = new JPanel();
	
		gameModePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		themePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		difficultyPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel centerContainer = new JPanel();
		centerContainer.setLayout(new GridLayout(1, 3));
		
		JLabel modeLabel = new JLabel("Game Mode");
		gameModePanel.add(modeLabel);
        
        String[] gameModes = {"Normal", "Streak", "Timed"};
        gameModeComboBox = new JComboBox<>(gameModes);
        gameModePanel.add(gameModeComboBox);
		
		JLabel themeLabel = new JLabel("Theme");
		themePanel.add(themeLabel);
		
        String[] themes = {"Default", "Space", "Western", "Ocean"};
        themeComboBox = new JComboBox<>(themes);
        themePanel.add(themeComboBox);
		
		JLabel difficultyLabel = new JLabel("Difficulty");
		difficultyPanel.add(difficultyLabel);
		
        String[] difficulties = {"Easy", "Medium", "Hard"};
        difficultyComboBox = new JComboBox<>(difficulties);
        difficultyPanel.add(difficultyComboBox);
		
		centerContainer.add(gameModePanel);
		centerContainer.add(themePanel);
		centerContainer.add(difficultyPanel);
		
		JPanel topButtonPanel = new JPanel();
		topButtonPanel.setBorder(BorderFactory.createEtchedBorder());
		topButtonPanel.setLayout(new GridLayout(1,10));
		
		JButton mainMenuButton = new JButton("Main Menu");
		mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform actions when MainMenu button is clicked
                // Return back to the Main Menu
            	ScreenManager.getInstance().switchScreen(new MainMenuScreen());
                
            }
        });
		
		topButtonPanel.add(mainMenuButton);
		for(int i = 0; i < 6; i++) {
			topButtonPanel.add(new JPanel());
		}		
		add(topButtonPanel, BorderLayout.NORTH);
		
		JPanel bottomButtonPanel = new JPanel();
		bottomButtonPanel.setBorder(BorderFactory.createEtchedBorder());
		bottomButtonPanel.setLayout(new GridLayout(1,3));
			
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					startButtonAction();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
        });
		bottomButtonPanel.add(new JPanel());
		bottomButtonPanel.add(startButton);
		bottomButtonPanel.add(new JPanel());

		
		add(bottomButtonPanel, BorderLayout.SOUTH);
		
		add(centerContainer, BorderLayout.CENTER);
	}
	
	private void startButtonAction() throws IOException {
		
		GameScreen gmScreen = null;
		
		String selectedMode = (String) gameModeComboBox.getSelectedItem();
		String selectedTheme = (String) themeComboBox.getSelectedItem();
		String selectedDifficulty = (String) difficultyComboBox.getSelectedItem();
		
		switch (selectedMode) {
	        case "Normal":
	        	gmScreen = new GameScreen(selectedDifficulty, selectedTheme, false);
	            break;
	        case "Streak":
	        	gmScreen = new GameScreen(selectedDifficulty, selectedTheme, true);
	            break;
	        case "Timed":
	        	gmScreen = new GameScreen(selectedDifficulty, selectedTheme, false, 90);
	        	break;
	        default:
	            throw new IllegalArgumentException("Invalid mode");
	    }

		
		gmScreen.switchToThis();
	}
		

}
