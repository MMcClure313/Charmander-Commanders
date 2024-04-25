import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		
		JButton deleteButton = new JButton("Delete save");
		deleteButton.setBackground(Color.red);

		add(backButton, BorderLayout.NORTH);
		add(deleteButton, BorderLayout.SOUTH);
		
		JPanel container = new JPanel(new GridLayout(2,2, 10, 10));
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
        		int optionSelect = JOptionPane.showConfirmDialog(
        				container,
        			    "Are you absolutely sure you want to delete your save?",
        			    "Delete confirmation",
        			    JOptionPane.YES_NO_OPTION);
        		
        		
        		if(optionSelect == JOptionPane.YES_OPTION) {
        			StatsManager.getInstance().deleteSave();
                    ScreenManager.getInstance().switchScreen(new StatsScreen());
        			
        		}
        	}
				
		});
		
		JPanel totalPanel = new JPanel();
		totalPanel.setBorder(BorderFactory.createTitledBorder("Users Stats"));
		totalPanel.setLayout(new GridLayout(3, 1));
		
		JLabel winsLabel = new JLabel("User Wins: " + StatsManager.getInstance().getCSVal(0));
		winsLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		JLabel lossLabel = new JLabel("User Losses: " + StatsManager.getInstance().getCSVal(1));
		lossLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		JLabel pointsLabel = new JLabel("Points: " + StatsManager.getInstance().getCSVal(10));
		pointsLabel.setFont(new Font("Serif", Font.PLAIN, 30));

		totalPanel.add(winsLabel);
		totalPanel.add(lossLabel);
		totalPanel.add(pointsLabel);
		
		
		JPanel normalPanel = new JPanel();
		normalPanel.setBorder(BorderFactory.createTitledBorder("Normal Mode"));
		normalPanel.setLayout(new GridLayout(2, 1));

		JLabel NwinsLabel = new JLabel("Wins: " + StatsManager.getInstance().getCSVal(2));
		NwinsLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		JLabel NlossLabel = new JLabel("Losses: " + StatsManager.getInstance().getCSVal(3));
		NlossLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		
		normalPanel.add(NwinsLabel);
		normalPanel.add(NlossLabel);
		
		

		JPanel timedPanel = new JPanel();
		timedPanel.setBorder(BorderFactory.createTitledBorder("Timed Mode"));
		timedPanel.setLayout(new GridLayout(3, 1));

		JLabel TwinsLabel = new JLabel("Wins: " + StatsManager.getInstance().getCSVal(4));
		TwinsLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		JLabel TlossLabel = new JLabel("Losses: " + StatsManager.getInstance().getCSVal(5));
		TlossLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		JLabel bestTimeLabel = new JLabel("Fastest Time (seconds): " + StatsManager.getInstance().getCSVal(6));
		bestTimeLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		
		timedPanel.add(TwinsLabel);
		timedPanel.add(TlossLabel);
		timedPanel.add(bestTimeLabel);

		
		JPanel endlessPanel = new JPanel();
		endlessPanel.setBorder(BorderFactory.createTitledBorder("Endless Mode"));
		endlessPanel.setLayout(new GridLayout(3, 1));

		JLabel EwordsLabel = new JLabel("Correct Words in Endless: " + StatsManager.getInstance().getCSVal(8));
		EwordsLabel.setFont(new Font("Serif", Font.PLAIN, 22));
		JLabel EGamesLabel = new JLabel("Endless Games Played: " + StatsManager.getInstance().getCSVal(9));
		EGamesLabel.setFont(new Font("Serif", Font.PLAIN, 22));
		JLabel EStreak = new JLabel("Highest Endless Streak: " + StatsManager.getInstance().getCSVal(7));
		EStreak.setFont(new Font("Serif", Font.PLAIN, 22));
		
		endlessPanel.add(EwordsLabel);
		endlessPanel.add(EGamesLabel);
		endlessPanel.add(EStreak);
		



		
		container.add(totalPanel);
		container.add(normalPanel);
		container.add(timedPanel);
		container.add(endlessPanel);
		
		add(container, BorderLayout.CENTER);
	}

}
