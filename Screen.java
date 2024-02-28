
import javax.swing.JPanel;

public abstract class Screen extends JPanel{
	
	public void switchToThis() {
        ScreenManager.getInstance().switchScreen(this);
    }

}
