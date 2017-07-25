import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	// MEMBER VARIABLES
	int speed;

	// CONSTRUCTOR
	Rocketship(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		speed = 5;
	}

	// METHODS
	void update() {
		if (GamePanel.arrowCase == 1) {
			x += 1;
		}
		if (GamePanel.arrowCase == 2) {
			x -= 1;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
