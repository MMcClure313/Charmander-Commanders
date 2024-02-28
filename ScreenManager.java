
import javax.swing.*;
import java.awt.*;


/**
 * Singleton class main frame of application and transitions between screens.
 */
public class ScreenManager extends JFrame{
	
	private static ScreenManager INSTANCE; // Singleton instance
    private CardLayout cardLayout;
	
    /**
     * Retrieves the singleton instance of ScreenManager.
     * @return The singleton instance of ScreenManager.
     */
	public static synchronized ScreenManager getInstance() {
		if (INSTANCE == null) {
            INSTANCE = new ScreenManager();
        }
        return INSTANCE;
	}
	
	/**
     * Private constructor creates initial singleton object
     */
	private ScreenManager() {
		
		setTitle("Word Games");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        
        // During integration change this to whatever the first screen should be
        // Most likely main menu
        
        MainMenuScreen menu = new MainMenuScreen();
        switchScreen(menu);
              
        
        pack();
        setVisible(true);
    }
	
	/**
     * Switches to the specified screen.
     * @param screen The screen to switch to.
     */
	public void switchScreen(Screen screen) {
		
		getContentPane().removeAll(); // Remove current screen
        add(screen, screen.getClass().getName()); // Add new screen
        repaint();
        revalidate();
        cardLayout.show(getContentPane(), screen.getClass().getName()); // Show new screen
    }



}
