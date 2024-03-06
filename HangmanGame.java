
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HangmanGame {
	
	private Observer observer;
	
	private WordGenerator wordGenerator;
	
    private String hiddenPhrase;
    private StringBuilder displayedPhrase;
    private List<Character> guessedLetters;
    
    private int incorrectGuesses;
    private static final int MAX_INCORRECT_GUESSES = 6;

    public HangmanGame(String wordBankFile, Observer observer) throws IOException {
    	
    	wordGenerator = new WordGenerator(wordBankFile);
    	this.observer = observer;
    	initializeGame();
    	
    }
    
    public void startGame() {
    	notifyObserver();
    }
    
    private void notifyObserver() {
        if (observer != null) {
        	
            observer.updateDisplayedPhrase(getDisplayedPhrase());
            StringBuilder sb = new StringBuilder();
            for(Character c : guessedLetters) {
            	sb.append(c);
            	sb.append(' ');
            }
            observer.updateGuessedLetters(sb.toString());
            int guessesRemaining = MAX_INCORRECT_GUESSES - incorrectGuesses;
            String text = "" + guessesRemaining;
            observer.updateGameState(text, isGameOver(), isGameWon());
            
            
        }
    }
    
    private void initializeGame() {
        hiddenPhrase = wordGenerator.getRandomWord();
        displayedPhrase = new StringBuilder("_".repeat(hiddenPhrase.length()));
        guessedLetters = new ArrayList<>();
        incorrectGuesses = 0;   
        
        System.out.print(hiddenPhrase); // FOR TESTING REMOVE LATER
    }

    private String getDisplayedPhrase() {
        return displayedPhrase.toString();
    }

    public boolean guessLetter(char letter) {
        if (guessedLetters.contains(letter)) {
            // Letter has already been guessed
            return false;
        }

        guessedLetters.add(letter);
        boolean found = false;
        for (int i = 0; i < hiddenPhrase.length(); i++) {
            if (hiddenPhrase.charAt(i) == letter) {
                displayedPhrase.setCharAt(i, letter);
                found = true;
            }
        }

        if (!found) {
            incorrectGuesses++;
        }
        
        notifyObserver();
        return found;
    }

    private boolean isGameOver() {
        return incorrectGuesses >= MAX_INCORRECT_GUESSES || !displayedPhrase.toString().contains("_");
    }
    
    private boolean isGameWon() {
    	return (MAX_INCORRECT_GUESSES - incorrectGuesses) != 0;
    }
}