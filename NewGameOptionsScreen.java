import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameOptionsScreen extends Screen {
    
    public NewGameOptionsScreen() {
        setLayout(new BorderLayout());
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(3, 1));

        JLabel difficultyLabel = new JLabel("Select Difficulty:");
        JComboBox<String> difficultyComboBox = new JComboBox<>(new String[]{"Easy", "Medium", "Hard"});
        optionsPanel.add(difficultyLabel);
        optionsPanel.add(difficultyComboBox);

        // Timer options
        JLabel timerLabel = new JLabel("Enable Timer:");
        JCheckBox timerCheckBox = new JCheckBox();
        optionsPanel.add(timerLabel);
        optionsPanel.add(timerCheckBox);

        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String difficulty = (String) difficultyComboBox.getSelectedItem();
                boolean enableTimer = timerCheckBox.isSelected();
                
                startNewGame(difficulty, enableTimer);
            }
        });
        optionsPanel.add(startGameButton);

        add(optionsPanel, BorderLayout.CENTER);
    }

    private void startNewGame(String difficulty, boolean enableTimer) {
        GameScreen gameScreen = new GameScreen(difficulty, enableTimer);
        gameScreen.switchToThis();
    }
}
