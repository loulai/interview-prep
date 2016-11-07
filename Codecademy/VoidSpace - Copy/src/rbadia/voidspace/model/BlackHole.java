package rbadia.voidspace.model;

	import java.awt.Rectangle;
	import java.util.Random;

	import rbadia.voidspace.main.GameScreen;

	public class BlackHole extends Rectangle {
		private static final long serialVersionUID = 1L;
		
		public static final int DEFAULT_SPEED = 1;
		
		private int holeWidth = 200;
		private int holeHeight = 200;
		private int speed = DEFAULT_SPEED;

		private Random rand = new Random();
		
		/**
		 * Crates a new hole at a random x location at the top of the screen 
		 * @param screen the game screen
		 */
		public BlackHole(GameScreen screen){
			this.setLocation(
	        		rand.nextInt(screen.getWidth() - holeWidth - 100),
	        		0);
			this.setSize(holeWidth, holeHeight);
		}
		
		public int getHoleWidth() {
			return holeWidth;
		}
		public int getHoleHeight() {
			return holeHeight;
		}

		/**
		 * Returns the current hole speed
		 * @return the current hole speed
		 */
		public int getSpeed() {
			return speed;
		}
		
		/**
		 * Set the current hole speed
		 * @param speed the speed to set
		 */
		public void setSpeed(int speed) {
			this.speed = speed;
		}
		
		/**
		 * Returns the default hole speed.
		 * @return the default hole speed
		 */
		public int getDefaultSpeed(){
			return DEFAULT_SPEED;
		}
	}


