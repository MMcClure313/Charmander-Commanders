
import java.awt.*;
import java.io.File;
import java.util.Vector;

import javax.swing.*;

public class HangmanPanel extends JPanel {
	
	private JLabel guessesRemainingLabel;
	private JPanel imagePanel;
	
	private Vector<JLabel> images;
	private int imageIndex;
	private JLabel activeImage;
	

	
	
	public HangmanPanel(String imageFolder){
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Hangman"));
		guessesRemainingLabel = new JLabel("Guesses Remaining 999");
		
		imagePanel = new JPanel();
		imagePanel.setLayout(new FlowLayout());
		
		imageIndex = -1;
		images = new Vector<>();
		setImages(imageFolder);
		
		add(guessesRemainingLabel, BorderLayout.NORTH);
		add(imagePanel, BorderLayout.CENTER);
		
	}
	
	private void setImages(String imageFolder) {
		
		makeImageLabel(imageFolder + File.separator + "imageOne.png");
		makeImageLabel(imageFolder + File.separator + "imageTwo.png");
		makeImageLabel(imageFolder + File.separator + "imageThree.png");
		makeImageLabel(imageFolder + File.separator + "imageFour.png");
		makeImageLabel(imageFolder + File.separator + "imageFive.png");
		makeImageLabel(imageFolder + File.separator + "imageSix.png");
		makeImageLabel(imageFolder + File.separator + "imageSeven.png");
		makeImageLabel(imageFolder + File.separator + "imageEight.png");
			

	}
	
	private void makeImageLabel(String imagePath) {
		ImageIcon imageIcon = new ImageIcon(imagePath);	
		JLabel imageLabel = new JLabel(imageIcon);
		images.add(imageLabel);
	}
	
	
	public void updatePanel(int guesses, boolean correctGuess){
		System.out.print(guesses);
		
		guessesRemainingLabel.setText("Guesses Remaining " + guesses);
		
		if(!correctGuess) {
			imageIndex = images.size() - guesses - 1;
			activeImage = images.get(imageIndex);
			imagePanel.removeAll();
			imagePanel.add(activeImage);
			revalidate();
			repaint();
			
		}
			
	}
	

}
