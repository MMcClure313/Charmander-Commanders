import java.awt.BorderLayout;
import java.awt.Color;
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
	
	public MainMenuScreen() {
		
		this.setLayout(new BorderLayout());
		

		
		JLabel l1 = new JLabel("Start");
		JLabel l2 = new JLabel("Options");
		JLabel l3 = new JLabel("Quit");
		
		JLabel titleLabel = new JLabel("WORD GAME");
		titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
		optionsPanel.add(l1);
		optionsPanel.add(l2);
		optionsPanel.add(l3);

		
		add(optionsPanel, BorderLayout.CENTER);
		add(titleLabel, BorderLayout.NORTH);

		setBackground(new Color(255, 239, 205));
		
	
	}
	
	
	
}
