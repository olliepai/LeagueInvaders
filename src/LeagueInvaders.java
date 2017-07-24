import javax.swing.JFrame;

public class LeagueInvaders {
	// MAIN METHOD
	public static void main(String[] args) {
		LeagueInvaders li = new LeagueInvaders();
	}

	// MEMBER VARIABLES
	JFrame mainFrame;

	final int width = 500;
	final int height = 800;

	// CONSTRUCTOR
	LeagueInvaders() {
		mainFrame = new JFrame();
		setup();
	}

	// METHODS
	void setup() {
		mainFrame.setVisible(true);
		// mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
