
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
    private int maxIncorrectGuesses;
    private static final int EASY_MAX_INCORRECT_GUESSES = 8;
    private static final int MEDIUM_MAX_INCORRECT_GUESSES = 6;
    private static final int HARD_MAX_INCORRECT_GUESSES = 4;

    public HangmanGame(String wordBankFile, Observer observer, String difficulty) throws IOException {
    	
    	wordGenerator = new WordGenerator(wordBankFile);
    	this.observer = observer;
    	initializeGame(difficulty);
    	
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
            int guessesRemaining = maxIncorrectGuesses - incorrectGuesses;
            String text = "" + guessesRemaining;
            observer.updateGameState(text, isGameOver(), isGameWon());
            
            
        }
    }
    
    private void initializeGame(String difficulty) {
        hiddenPhrase = wordGenerator.getRandomWord();
        displayedPhrase = new StringBuilder("_".repeat(hiddenPhrase.length()));
        guessedLetters = new ArrayList<>();
        
        switch (difficulty.toLowerCase()) {
	        case "easy":
	            maxIncorrectGuesses = EASY_MAX_INCORRECT_GUESSES;
	            break;
	        case "medium":
	            maxIncorrectGuesses = MEDIUM_MAX_INCORRECT_GUESSES;
	            break;
	        case "hard":
	            maxIncorrectGuesses = HARD_MAX_INCORRECT_GUESSES;
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid difficulty level");
	    }
        
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
        return incorrectGuesses >= maxIncorrectGuesses || !displayedPhrase.toString().contains("_");
    }
    
    private boolean isGameWon() {
    	return (maxIncorrectGuesses - incorrectGuesses) != 0;
    }
}