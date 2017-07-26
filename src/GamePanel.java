import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	// MEMBER VARIABLES
	Timer timer;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;

	int currentState = MENU_STATE;

	Font titleFont;
	Font textFont;

	Rocketship rs = new Rocketship(250, 700, 50, 50);

	static int arrowCase = 0;

	ObjectManager om = new ObjectManager();

	public static BufferedImage alienlmg;
	public static BufferedImage rocketlmg;
	public static BufferedImage bulletlmg;
	public static BufferedImage spacelmg;

	// CONSTRUCTOR
	GamePanel() {
		timer = new Timer(1000 / 60, this);

		titleFont = new Font("Arial", Font.PLAIN, 48);
		textFont = new Font("Arial", Font.PLAIN, 24);

		om.addObject(rs);

		try {
			alienlmg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketlmg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletlmg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			spacelmg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	// METHODS
	public void actionPerformed(ActionEvent arg0) {
		repaint();

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
	}

	public void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState += 1;

			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rs.right = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rs.left = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			om.addObject(new Projectile(rs.x + 20, rs.y, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rs.right = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rs.left = false;
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		om.manageEnemies();

		om.update();

		om.checkCollision();

		if (rs.isAlive == false) {
			currentState = END_STATE;

			om.reset();

			rs = new Rocketship(250, 700, 50, 50);

			om.addObject(rs);
		}

		om.getScore();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);

		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 25, 200);
		g.setFont(textFont);
		g.drawString("Press ENTER to start", 125, 300);
		g.drawString("Press SPACE for intructions", 95, 400);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);

		om.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);

		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 100, 100);
		g.setFont(textFont);
		g.drawString("You killed " + om.getScore() + " aliens", 150, 300);
		g.drawString("Press BACKSPACE to Restart", 100, 500);
	}

}
