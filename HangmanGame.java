
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
    private String difficulty;
    

    public HangmanGame(String wordBankFile, Observer observer, String difficulty) throws IOException {
    	this.difficulty = difficulty;
    	wordGenerator = new WordGenerator(wordBankFile);
    	this.observer = observer;
    	initializeGame();
    	
    }
    
    public void startGame() {
    	notifyObserver(true);
    }
    
    private void notifyObserver(boolean guessCorrect) {
        if (observer != null) {
        	
            observer.updateDisplayedPhrase(getDisplayedPhrase());
            StringBuilder sb = new StringBuilder();
            for(Character c : guessedLetters) {
            	sb.append(c);
            	sb.append(' ');
            }
            observer.updateGuessedLetters(sb.toString());
            int guessesRemaining = maxIncorrectGuesses - incorrectGuesses;
            observer.updateGameState(guessesRemaining, isGameOver(), isGameWon(), guessCorrect);
            
            
        }
    }
    
    private void initializeGame() {

        generateNewWord();
        incorrectGuesses = 0;   
        

    }
    
    private void generateNewWord() {
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
        
        System.out.println(hiddenPhrase);
        
    }
    
    protected String getHiddenPhrase(){
    	return hiddenPhrase;
    }
    
    protected void addIncorrectGuesses() {
    	maxIncorrectGuesses++;
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
        
        notifyObserver(found);
        return found;
    }

    private boolean isGameOver() {
        return incorrectGuesses >= maxIncorrectGuesses || !displayedPhrase.toString().contains("_");
    }
    
    private boolean isGameWon() {
    	return (maxIncorrectGuesses - incorrectGuesses) != 0;
    }
    
    public void nextWord() {
    	generateNewWord();
    	int guessesRemaining = maxIncorrectGuesses - incorrectGuesses;
    	observer.updateDisplayedPhrase(getDisplayedPhrase());
        StringBuilder sb = new StringBuilder();
        for(Character c : guessedLetters) {
        	sb.append(c);
        	sb.append(' ');
        }
        observer.updateGuessedLetters(sb.toString());
    	observer.updateGameState(guessesRemaining, false, false, true);
    }
}