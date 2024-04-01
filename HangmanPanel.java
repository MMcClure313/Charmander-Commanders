
import javax.swing.*;

public class HangmanPanel extends JPanel {
	
	private JLabel guessesRemainingLabel;
	
	public HangmanPanel(){
		setBorder(BorderFactory.createTitledBorder("Hangman"));
		guessesRemainingLabel = new JLabel("Guesses Remaining 999");
		add(guessesRemainingLabel);
		
	}
	
	public void updatePanel(String guesses){
		guessesRemainingLabel.setText(guesses);
	}
	

}
