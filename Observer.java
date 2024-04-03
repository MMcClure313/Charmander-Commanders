
public interface Observer {
    void updateDisplayedPhrase(String displayedPhrase);
    void updateGuessedLetters(String guesses);
    void updateGameState(String guessesRemaining, boolean gameOver, boolean gameWon, boolean correctGuess);
    void guessLetter(Character guess);
}
