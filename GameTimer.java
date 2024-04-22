public class GameTimer extends Thread {
    private int timeInSeconds;
    private boolean running;

    public GameTimer(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
        this.running = false;
    }

    public void startTimer() {
        running = true;
        start();
    }

    public void pauseTimer() {
        running = false;
    }

    public void resetTimer() {
        running = false;
        timeInSeconds = 0;
    }

    public int getTimeRemaining() {
        return timeInSeconds;
    }

    @Override
    public void run() {
        while (timeInSeconds > 0 && running) {
            try {
                sleep(1000); // Sleep for 1 second
                timeInSeconds--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}