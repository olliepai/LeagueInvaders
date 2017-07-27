import java.awt.Graphics;

public class Alien extends GameObject {
	// CONSTRUCTOR
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	// METHODS
	void update() {
		super.update();

		y += 3;
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.alienlmg, x, y, width, height, null);
	}
}
