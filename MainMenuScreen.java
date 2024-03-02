import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**
 * Main menu class to display elements.
 * @author matth
 *
 */
public class MainMenuScreen extends Screen {
	private Dimension windowSize;

	public MainMenuScreen(Dimension frameSize) {
		windowSize = frameSize;
		this.setLayout(new BorderLayout());
		

		
		JLabel l1 = new JLabel("Start");
		JLabel l2 = new JLabel("Options");
		JLabel l3 = new JLabel("Quit");
		
		JPanel titlePanel = new JPanel();
		
		System.out.println("" + windowSize.width + windowSize.height);
		
		titlePanel.setPreferredSize(new Dimension(windowSize.width/4, windowSize.height/4));
		JLabel titleLabel = new JLabel("WORD GAME");
		titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 50));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.setBackground(new Color(255, 239, 205));
		titlePanel.add(titleLabel);
		
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
		optionsPanel.add(l1);
		optionsPanel.add(l2);
		optionsPanel.add(l3);

		add(titlePanel, BorderLayout.PAGE_START);
		add(optionsPanel, BorderLayout.CENTER);
						
	
	}
	
	
	
}
