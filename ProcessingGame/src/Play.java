import processing.core.PApplet;

public class Play extends PApplet {
	
	public void setup() {
		size(600,400);
		background(255);
	}
	
	float ballX = 0;
	float ballY = 0;
	float speedX = 2;
	float speedY = 1;
	
	float hit = 0;
	float miss = 0;
	
	public void draw(){
		float paddle = 50;
		if(ballX < 0 || ballX > width)
			speedX = -speedX;
		
		if(ballY < 0 || ballY > height) {
			speedY = -speedY;
			float distance = abs(mouseX-ballX);
			if(distance < paddle) {
				hit = hit + 1;
			
			} else {
				miss = miss + 1; 
				fill(0);
			}
		} else {
			speedY = speedY + 1;
			
		}
		
		ballX = ballX + speedX;
		ballY = ballY + speedY;
		
		background(100,200,50);
		rect(mouseX-paddle,height-4,2*paddle,3);
		ellipse(ballX,ballY,20,20);
		fill(200,100,50);
		
		text("You caught it " + hit + " times", 10, 10);
		text("You missed it " + miss + " times", 10, 25);
	}
}
