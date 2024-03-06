
public interface Observer {
    void updateDisplayedPhrase(String displayedPhrase);
    void updateGuessedLetters(String guesses);
    void updateGameState(String guessesRemaining, boolean gameOver, boolean gameWon);
    void guessLetter(Character guess);
}
