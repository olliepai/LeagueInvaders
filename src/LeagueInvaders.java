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

	GamePanel gp;

	// CONSTRUCTOR
	LeagueInvaders() {
		mainFrame = new JFrame();
		gp = new GamePanel();

		setup();

	}

	// METHODS
	void setup() {
		mainFrame.add(gp);
		mainFrame.addKeyListener(gp);

		mainFrame.setVisible(true);
		mainFrame.setSize(width, height);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gp.startGame();
	}
}
