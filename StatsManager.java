
public class StatsManager {
    private static StatsManager INSTANCE; // Singleton instance
    private int wins;
    private int losses;

    private StatsManager() {
        wins = 0;
        losses = 0;
    }

    public static synchronized StatsManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StatsManager();
        }
        return INSTANCE;
    }

    public void incrementWins() {
        wins++;
    }

    public void incrementLosses() {
        losses++;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
}
