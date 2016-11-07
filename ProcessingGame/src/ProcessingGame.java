import processing.core.PApplet;

/** 
 * Description : Default game. Circles move around and the goal is to click on as many as possible, so that the score at the end 
 *               is the highest it can be. Circles have a randomly assigned value of 10, 20, 50 or 100. Uses processing.
 * Created on  : 3rd December 2014
 * @author loulai
 */

public class ProcessingGame extends PApplet {	
	
	int timeCounter = 0; //increments each time draw loop is run, so effectively acts as a time counter
	Disk[] totalDisks = new Disk[5]; //an array of empty Disk objects
	int score = 0; //score of the game
	int counter = 0; //used to resize the array of Disks, to make it seem like 1 disk has dissapeared
	
	
	/* runs when the game starts. Draws a canvas and generates an array of initialized Disks objects
	 * @return void no return
	 */
	public void setup() {
		size(800,600); //size of canvas
		background(255); //colour of canvas
		
		for(int i = 0; i < 5; i++){
			totalDisks[i] = new Disk(this); //generating 5 Disk objects
		}
	}

	public void draw() {
		timeCounter ++; //increment each time the draw loop is run
		if (timeCounter < 700 && totalDisks.length > 0) { //only runs for a certain amount of 'time', because the draw is called a certain amount of times a second
			//here it runs when draw is called less than 700 times
			background(100,100,100); //filling in the background each time
			
			for(int i = 0; i < totalDisks.length; i ++) { //moving each of the 5 disks
				Disk d = totalDisks[i];
				
				fill(100,100,100);
				d.move(); //move method defined previously in Disk class
				
				textSize(20); //having the score of the circles on it
				fill(10,0,0);
				textAlign(CENTER);
				text(d.getValue(), d.getX(), d.getY());
				
				/*if mouse is within the x and y radius of the circle, score is incremented and one disk is removed by resizing the original array */
				if(mousePressed){
					if(mouseX >= (d.getX() - 30) && mouseX <= (d.getX() + 30) && mouseY >= (d.getY() - 30) && mouseY <= (d.getY() + 30)){
						score = score + d.getValue(); //incrementing the score of the game
						
						//resizing the original array with 5 disks
						Disk[] tempDisks = new Disk[totalDisks.length - 1]; //temporary array of disks that is one shorter than previous dis array
						for (int k = 0; k < totalDisks.length; k++){
							if (i != k){
								tempDisks[counter] = totalDisks[k]; //copying each value
								counter++;
							}
						}
						totalDisks = tempDisks; //finally, changing to array that is to be displayed on screen
						counter = 0; //resetting counter so that the next time its run it starts at 0
					}
				}
				text(score, 70,70); //this displays the score on the top left corner
			}

		} else if(timeCounter >= 700 || totalDisks.length == 0) { //runs once the game is over 
			//i.e. once the 'timeCounter' is incremented by the draw counter more than 1000 times 
			// OR once the player has clicked on all disks
			if(score == 0){  
				background(100,100,100); //drawing on background
				textSize(50);
				text("Wow you suck\n"+ score, 400, 300); //displaying the score in the middle of the screen
			} else {
				background(100,100,100); 
				textSize(50);
				text("Your score:\n"+ score, 400, 300); 
			}
		}
	}
}