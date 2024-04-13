import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerSelectionScreen extends Screen {
    private JLabel timerLabel;

    public TimerSelectionScreen() {
        setLayout(new BorderLayout());

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new GridLayout(2, 1));

        timerLabel = new JLabel("Select Timer Duration", SwingConstants.CENTER);
        selectionPanel.add(timerLabel);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        JButton threeMinutesButton = new JButton("3 Minutes");
        threeMinutesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGameWithTimer(180); // 3 minutes in seconds
            }
        });
        buttonsPanel.add(threeMinutesButton);

        JButton fiveMinutesButton = new JButton("5 Minutes");
        fiveMinutesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGameWithTimer(300); // 5 minutes in seconds
            }
        });
        buttonsPanel.add(fiveMinutesButton);

        selectionPanel.add(buttonsPanel);

        add(selectionPanel, BorderLayout.CENTER);
    }

    private void startGameWithTimer(int timeInSeconds) {
        GameScreen gameScreen = new GameScreen();
        gameScreen.switchToThis();
        gameScreen.startGameWithTimer(timeInSeconds);
    }
}
