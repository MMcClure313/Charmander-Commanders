
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class GameScreen extends Screen implements Observer {
	
	//you just lost the game
	private HangmanGame game;
	
	//Components that observer manipulates
	private JLabel displayedPhrase;
	private JTextField guessEntryBox;
	private JLabel guessedLetters;
	private JLabel guessRemainingLabel;

	
	public GameScreen() throws IOException {	
		
		game = new HangmanGame("./default_words.csv", this);
		
		
		this.setLayout(new BorderLayout());

		//Screen uses grid layout cell (0,0) = imagePanel, cell(1,0) = gameplayPanel	
		JPanel gameScreenLayout = new JPanel();
		gameScreenLayout.setLayout(new GridLayout(1,2)); // Magic number bad
		
		//Create imagePanel
		JPanel imagePanel = new JPanel();
		imagePanel.setBorder(BorderFactory.createTitledBorder("Hangman"));
		guessRemainingLabel = new JLabel("Guesses Remaining 999");
		imagePanel.add(guessRemainingLabel);		
		
		//Create gameplayPanel
		JPanel gameplayPanel = new JPanel();
		gameplayPanel.setLayout(new BoxLayout(gameplayPanel, BoxLayout.Y_AXIS));
		
		//Create displayPanel
		JPanel displayPanel = new JPanel();
		displayedPhrase = new JLabel("ERROR");
		displayPanel.setBorder(BorderFactory.createTitledBorder("Phrase"));
		displayPanel.add(displayedPhrase);
		
		JPanel metaButtonPanel = new JPanel();
		metaButtonPanel.setBorder(BorderFactory.createEtchedBorder());
		metaButtonPanel.setLayout(new GridLayout(1,10));
		
		//Create guessPanel default flow layout
		JPanel guessPanel = new JPanel();
		
		guessEntryBox = new JTextField(10); //Magic number bad
		
		JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String input = guessEntryBox.getText();
            	if(input.length() == 1 && input.matches("[a-zA-Z]")) {
            		game.guessLetter(guessEntryBox.getText().trim().toLowerCase().charAt(0));
            		guessEntryBox.setText("");
            	}
            	else {
            		JOptionPane.showMessageDialog(guessPanel,
            			    "Invalid guess\nEnsure your guesses are only one letter",
            			    "",
            			    JOptionPane.WARNING_MESSAGE);
            		
            		guessEntryBox.setText("");
            	}
            }
        });
        
        JButton exitButton = new JButton("X");
        exitButton.setBackground(Color.red); 
        exitButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		//Shows confirmation
        		int optionSelect = JOptionPane.showConfirmDialog(
        				gameScreenLayout,
        			    "Quit to Main Menu?",
        			    "Quit Confirmation",
        			    JOptionPane.YES_NO_OPTION);
        		
        		
        		if(optionSelect == JOptionPane.YES_OPTION) {
        			returnToMenu();
        		}
        	}
        });
        
        guessPanel.setBorder(BorderFactory.createTitledBorder("Guess"));
		
		guessPanel.add(guessEntryBox);
		guessPanel.add(guessButton);
		
		//Create lettersPanel
		JPanel lettersPanel = new JPanel();
		
		lettersPanel.setBorder(BorderFactory.createTitledBorder("Guessed Letters"));
		
		guessedLetters = new JLabel("ERROR");
		lettersPanel.add(guessedLetters);
			
		//Add everything to game play panel
		gameplayPanel.add(displayPanel);
		gameplayPanel.add(guessPanel);
		gameplayPanel.add(lettersPanel);
		
		//Add everything to main screen
		gameScreenLayout.add(imagePanel);
		gameScreenLayout.add(gameplayPanel);
		
		metaButtonPanel.add(exitButton);
		for(int i = 0; i < 9; i++) {
			metaButtonPanel.add(new JPanel());
		}
		
		
		this.add(gameScreenLayout, BorderLayout.CENTER);
		this.add(metaButtonPanel, BorderLayout.NORTH);
		game.startGame();			
		
	}
	
    @Override
    public void updateDisplayedPhrase(String updateDisplayPhrase) {
        displayedPhrase.setText(updateDisplayPhrase);
    }
    
    @Override
    public void guessLetter(Character guess) {
    	game.guessLetter(guess);
    }
    
    @Override
    public void updateGuessedLetters(String guesses) {
    	guessedLetters.setText(guesses);
    }
    
    @Override
    public void updateGameState(String guessesRemaining, boolean gameOver, boolean gameWon) {
    	if(!gameOver) {
    		String text = "Guesses Remaining " + guessesRemaining;
    		guessRemainingLabel.setText(text);
    	}else {
    		if(gameWon) {
                JOptionPane.showMessageDialog(null, "!!! YOU WON !!!");
                returnToMenu();      		
    		}else {
                JOptionPane.showMessageDialog(null, "YOU LOSE :(");
                returnToMenu();  
    		}
    		
    	}
    }
    
    private void returnToMenu() {
		MainMenuScreen menuScreen = new MainMenuScreen();
    	menuScreen.switchToThis();
    }
    
    
	
}
