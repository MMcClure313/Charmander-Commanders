
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

	
	public GameScreen() throws IOException {	
		
		game = new HangmanGame("Hangman_wordbank.csv", this);
		
		//Screen uses grid layout cell (0,0) = imagePanel, cell(1,0) = gameplayPanel
		this.setLayout(new GridLayout(1,2)); //Magic number bad
		
		//Create imagePanel
		JPanel imagePanel = new JPanel();
		imagePanel.setBorder(BorderFactory.createTitledBorder("Hangman"));
		
		//Create gameplayPanel
		JPanel gameplayPanel = new JPanel();
		gameplayPanel.setLayout(new BoxLayout(gameplayPanel, BoxLayout.Y_AXIS));
		
		//Create displayPanel
		JPanel displayPanel = new JPanel();
		displayedPhrase = new JLabel("ERROR");
		displayPanel.setBorder(BorderFactory.createTitledBorder("Phrase"));
		displayPanel.add(displayedPhrase);
		
		//Create guessPanel default flow layout
		JPanel guessPanel = new JPanel();
		
		guessEntryBox = new JTextField(10); //Magic number bad
		
		JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	game.guessLetter(guessEntryBox.getText().trim().charAt(0));
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
		this.add(imagePanel);
		this.add(gameplayPanel);
		
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
	
}