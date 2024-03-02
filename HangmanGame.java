import java.util.HashSet;
import java.util.Set;

public class HangmanGame {
    private HangmanGameLogic gameLogic;
    private StringBuilder displayedPhrase;
    private Set<Character> guessedLetters;
    private int incorrectGuesses;

    public HangmanGame(int maxIncorrectGuesses) {
        gameLogic = new HangmanGameLogic();
        displayedPhrase = new StringBuilder("_".repeat(gameLogic.getHiddenPhrase().length()));
        guessedLetters = new HashSet<>();
        incorrectGuesses = 0;
    }

    public String getDisplayedPhrase() {
        return displayedPhrase.toString();
    }

    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public boolean guessLetter(char letter) {
        if (guessedLetters.contains(letter)) {
            // Letter has already been guessed
            return false;
        }

        guessedLetters.add(letter);
        boolean found = gameLogic.guessLetter(letter, displayedPhrase);
        if (!found) {
            incorrectGuesses++;
        }

        return found;
    }

    public boolean isGameOver() {
        return incorrectGuesses >= gameLogic.getMaxIncorrectGuesses() || !displayedPhrase.toString().contains("_");
    }

    public String getHiddenPhrase() {
        return gameLogic.getHiddenPhrase();
    }
}
