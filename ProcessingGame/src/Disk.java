import processing.core.PApplet;
class Disk {
		//private variables of a Disk object, used when generating an ellipse
		private float x;
		private float y;
		private float rx;
		private float ry;
		
		//speed is the increment in movement of each disk, which is set to random between -5 and 5 upon initialization
		private float xSpeed;
		private float ySpeed;
		
		private int value;
		
		PApplet canvas;

		int col;
		
		public Disk ( PApplet canvas )
		{
			this.canvas = canvas;
			x = canvas.random(0, canvas.width); 
			y = canvas.random(0, canvas.height);
			rx = 60;
			ry = 60;
			xSpeed = canvas.random(-5, 5 );
			ySpeed = canvas.random(-5, 5 );
			
			int valueChooser = (int)((Math.random() * 4) + 1);
			
			if(valueChooser == 1) value = 10;
			else if (valueChooser == 2) value = 20;
			else if (valueChooser == 3) value = 50;
			else if (valueChooser == 4) value = 100;
			
			col = canvas.color(canvas.random(0,255), canvas.random(0,255), canvas.random(0,255));
		}
		
		/** update position based on speed
		 * 
		 */
		public void move() {
			x += xSpeed;
			y += ySpeed;
			// bouncing logic - see if the ball hits any of the edges
			// note how we are referring to the width and height
			// instance vars on the PApplet object

			if (x > canvas.width) {
				x = canvas.width;
				xSpeed *= -1;
				changeShape ();
			}
			if (x < 0) {
				x = 0;
				xSpeed *= -1;
				changeShape ();
			}
			if (y > canvas.height) {
				y = canvas.height;
				ySpeed *= -1;
				changeShape ();
			}
			if (y < 0) {
				y = 0;
				ySpeed *= -1;
				changeShape ();
			}
			// call the ellipse method on the PApplet object to draw
			// this object to the canvas
			canvas.fill(col);
			this.canvas.ellipse(x, y, rx, ry);
		}
		
		/** used in the move method, changes the shape of the disk
		 * 
		 */
		private void changeShape () {
			float tmp = rx;
			rx = ry;
			ry = tmp;
		}
		
		/** getter for x coord of disk
		 * @return float x coord
		 */
		public float getX() {
			return x;
		}
		
		/** getter for y coord of disk
		 * @return float y coord
		 */
		public float getY() {
			return y;
		}
		
		/** getter for x radius of disk
		 * @return float x radius
		 */
		public float getRX() {
			return rx;
		}
		
		/** getter for y radius of disk
		 * @return float y radius
		 */
		public float getRY(){
			return ry;
		}
		
		/** getter for the value (of score) disk
		 * @return int value that the disk has
		 */
		public int getValue() {
			return value;
		}
		
}
