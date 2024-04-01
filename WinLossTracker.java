import javax.swing.*;
import java.awt.*;

public class WinLossTracker extends JPanel {
    private int totalWins = 0;
    private int totalLosses = 0;
    private JLabel winsLabel;
    private JLabel lossesLabel;

    public WinLossTracker() {
        setLayout(new GridLayout(2, 1));
        winsLabel = new JLabel("Total Wins: " + totalWins);
        lossesLabel = new JLabel("Total Losses: " + totalLosses);
        add(winsLabel);
        add(lossesLabel);
    }

    public void incrementWins() {
        totalWins++;
        updateLabels();
    }

    public void incrementLosses() {
        totalLosses++;
        updateLabels();
    }

    private void updateLabels() {
        winsLabel.setText("Total Wins: " + totalWins);
        lossesLabel.setText("Total Losses: " + totalLosses);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("WinLossTracker Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 100);
            WinLossTracker tracker = new WinLossTracker();
            frame.add(tracker);
            frame.setVisible(true);

            tracker.incrementWins();
            tracker.incrementWins();
            tracker.incrementLosses();
            tracker.incrementWins();
        });
    }
}
