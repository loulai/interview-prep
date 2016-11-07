package rbadia.voidspace.model;
import java.awt.Rectangle;

/**
 * Represents a bullet fired by a ship.
 */
public class EnemyBullet extends Rectangle {
	private static final long serialVersionUID = 1L;
	
	private int bulletWidth = 8;
	private int bulletHeight = 8;
	private int speed = 12;

	/**
	 * Creates a new bullet above the ship, centered on it
	 * @param enemyShip
	 */
	public EnemyBullet(EnemyShip EnemyShip) {
		this.setLocation(EnemyShip.x + EnemyShip.width/2 - bulletWidth/2,
				EnemyShip.y - bulletHeight);
		this.setSize(bulletWidth, bulletHeight);
	}

	/**
	 * Return the bullet's speed.
	 * @return the bullet's speed.
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Set the bullet's speed
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}