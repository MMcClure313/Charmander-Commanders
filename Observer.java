
public interface Observer {
    void updateDisplayedPhrase(String displayedPhrase);
    void updateGuessedLetters(String guesses);
    void guessLetter(Character guess);
}
