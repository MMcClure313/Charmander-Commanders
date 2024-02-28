public class HangmanGame {
    private String hiddenPhrase;
    private StringBuilder displayedPhrase;
    private List<Character> guessedLetters;
    private int incorrectGuesses;
    private static final int MAX_INCORRECT_GUESSES = 6;

    public HangmanGame() {
        hiddenPhrase = WordGenerator.getRandomWord();
        displayedPhrase = new StringBuilder("_".repeat(hiddenPhrase.length()));
        guessedLetters = new ArrayList<>();
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

        return found;
    }

    public boolean isGameOver() {
        return incorrectGuesses >= MAX_INCORRECT_GUESSES || !displayedPhrase.toString().contains("_");
    }

    public String getHiddenPhrase() {
        return hiddenPhrase;
    }
}
