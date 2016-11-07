package rbadia.voidspace.model;

import java.awt.Rectangle;

import rbadia.voidspace.main.GameScreen;

/**
 * Represents a ship/space craft.
 *
 */
public class EnemyShip extends Rectangle {
	private static final long serialVersionUID = 1L;
	
	public static final int DEFAULT_SPEED = 7;
	private static final int Y_OFFSET = 375; // initial y distance of the ship from the bottom of the screen 
	private static final int OFFSET = 100; // initial y distance of the ship from ship2
	
	private int ShipWidth = 25;
	private int ShipHeight = 25;
	private int Speed = DEFAULT_SPEED;
	
	
	/**
	 * Creates a new ship at the default initial location. 
	 * @param screen the game screen
	 */
	public EnemyShip(GameScreen screen){
		this.setLocation((screen.getWidth() - ShipWidth-OFFSET)/2,
				screen.getHeight() - ShipHeight - Y_OFFSET-OFFSET);
		this.setSize(ShipWidth, ShipHeight);
	
	}
	
	/**
	 * Get the default ship width
	 * @return the default ship width
	 */
	public int getShipWidth() {
		return ShipWidth;
	}
	
	/**
	 * Get the default ship height
	 * @return the default ship height
	 */
	public int getShipHeight() {
		return ShipHeight;
	}
	
	/**
	 * Returns the current ship speed
	 * @return the current ship speed
	 */
	public int getSpeed() {
		return Speed;
	}
	
	/**
	 * Set the current ship speed
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.Speed = speed;
	}
	
	/**
	 * Returns the default ship speed.
	 * @return the default ship speed
	 */
	public int getDefaultSpeed(){
		return DEFAULT_SPEED;
	}
	////////////////////////////////////////////////////
	
	
	
	
	
	
}