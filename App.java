
import javax.swing.SwingUtilities;

public class App {
	
	public void run() {
        ScreenManager.getInstance();
    }
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App app = new App();
            app.run();
        });
    }
    
}