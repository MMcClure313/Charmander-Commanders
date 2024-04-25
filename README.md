# Group 6's Hangman
This application is a bite-size hangman application with all the functionality a player would need to play hangman.

On starting the application, a main menu appears with Start Statistics and Quit. 
Start will provide the user with an options menu to select the difficulty and theme they would like.
Statistics will bring the user to a minimal page displaying wins and losses, and points. It breaks down every wins and losses based on game modes, and specific stats related to specifics of the game mode.
Quit will close the application.

Within the hangman game, you will be introduced to the main game screen.
The left side is where the hangman is drawn upon guessing incorrectly.
The top right is the word to be guessed. It begins as all underlines, but as correct letters are guessed, the appropriate letters are then updated.
The middle right is your guessing field. You put in a single character to be guessed and click guess. There is power ups in the guessing field that takes 50 of your points, as shown in the stats screen, to either get a random letter guessed, or return a guess to the player.
The bottom right is the letters that have already been guessed.

On the upper left is an exit button for the game. This will exit you to the main menu, after ensuring you want to leave.

When the game of hangman is complete, the player is prompted that they have won or lost. Dismissing or pressing any option on a notification will return the user to the main menu. If the player is in endless mode, then the application will instead generate a new word for you to guess, the game only ending when you quit or run out of guesses.

## To start the application:
Download the github repo into a java workspace. Our group worked with eclipse, and can not guarantee that the application will run off of other java IDEs. Run the application off of the App.java file.
