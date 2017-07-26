import java.awt.Graphics;

public class Projectile extends GameObject {
	// MEMBER VARIABLES
	int speed = 10;

	// CONSTRUCTOR
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	// METHODS
	void update() {
		super.update();

		y -= speed;

		if (y < 0) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.bulletlmg, x, y, width, height, null);
	}
}
