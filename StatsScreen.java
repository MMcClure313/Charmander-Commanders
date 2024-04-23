import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatsScreen extends Screen{
	
	public StatsScreen() {
		
		setLayout(new BorderLayout());
		
		JButton backButton = new JButton("Back");
		
		backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ScreenManager.getInstance().switchScreen(new MainMenuScreen());
             
            }
        });
		
		add(backButton, BorderLayout.NORTH);
		
		JPanel container = new JPanel(new FlowLayout());
		
		JLabel winsLabel = new JLabel("Wins: " + StatsManager.getInstance().getWins());
		JLabel lossLabel = new JLabel("Losses: " + StatsManager.getInstance().getLosses());
		JLabel pointsLabel = new JLabel("Points: " + StatsManager.getInstance().getPoints());
		
		container.add(winsLabel);
		container.add(lossLabel);
		container.add(pointsLabel);
		
		add(container, BorderLayout.CENTER);
	}

}
