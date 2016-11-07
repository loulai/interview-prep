package rbadia.voidspace.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import rbadia.voidspace.model.Asteroid;
import rbadia.voidspace.model.BlackHole;
import rbadia.voidspace.model.Bullet;
import rbadia.voidspace.model.EnemyBullet;
import rbadia.voidspace.model.EnemyShip;
import rbadia.voidspace.model.Ship;
import rbadia.voidspace.sounds.SoundManager;


/**
 * Handles general game logic and status.
 */
public class GameLogic {
	private GameScreen gameScreen;
	private GameStatus status;
	private SoundManager soundMan;
	
	private Ship ship;
	private EnemyShip enemyShip;
	private EnemyShip enemyShip2;
	private Asteroid asteroid;
	private Asteroid asteroid2;
	private BlackHole hole;
	
	private List<Bullet> bullets;
	private List<EnemyBullet> enemyBullets;
	Random rand = new Random();
	/**
	 * Craete a new game logic handler
	 * @param gameScreen the game screen
	 */
	public GameLogic(GameScreen gameScreen){
		this.gameScreen = gameScreen;
		
		// initialize game status information
		status = new GameStatus();
		// initialize the sound manager
		soundMan = new SoundManager();
		
		// init some variables
		bullets = new ArrayList<Bullet>();
		enemyBullets = new ArrayList<EnemyBullet>();
		
	}

	/**
	 * Returns the game status
	 * @return the game status 
	 */
	public GameStatus getStatus() {
		return status;
	}

	public SoundManager getSoundMan() {
		return soundMan;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	/**
	 * Prepare for a new game.
	 */
	public void newGame(){
		status.setGameStarting(true);
		
		// init game variables
		bullets = new ArrayList<Bullet>();
	
		status.setShipsLeft(3);
		status.setGameOver(false);
		status.setAsteroidsDestroyed(0);
		status.setEnemyShipsDestroyed(0);
		status.setScore(0);
		status.setNewAsteroid(false);
				
		// init the ship and the asteroid
        newShip(gameScreen);
        this.hole = newHole(gameScreen);
        this.asteroid =newAsteroid(gameScreen);
        this.asteroid2 = newAsteroid(gameScreen);
        this.enemyShip = newEnemyShip(gameScreen); 
       this.enemyShip2 = newEnemyShip(gameScreen);
     
        
        // prepare game screen
        gameScreen.doNewGame();
        
        // delay to display "Get Ready" message for 1.5 seconds
		Timer timer = new Timer(1500, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				status.setGameStarting(false);
				status.setGameStarted(true);
			}
		
		});
		
		timer.setRepeats(false);
		timer.start();
	}

	public void newLevel(){
		
		
		status.setNextLevelStarting(true);
		
		// init game variables
		bullets = new ArrayList<Bullet>();
		enemyBullets = new ArrayList<EnemyBullet>();
	
		status.setGameOver(false);
		
		status.setAsteroidsDestroyed(status.getAsteroidsDestroyed()+1);
	
		status.setNewAsteroid(false);
				
		// init the ship and the asteroid
		
        newShip(gameScreen);
        this.enemyShip = newEnemyShip(gameScreen); 
        this.enemyShip2 = newEnemyShip(gameScreen);
        this.asteroid = newAsteroid(gameScreen);
        this.asteroid2=newAsteroid(gameScreen);
        this.hole = newHole(gameScreen);
       
        
        // prepare game screen
        gameScreen.doNextLevel();
        
        // delay to display "Get Ready" message for 1.5 seconds
		Timer timer = new Timer(1500, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				status.setNextLevelStarting(false);
				status.setNextLevelStarted(true);
			}
		});
		timer.setRepeats(false);
		timer.start();
		
}
	/**
	 * Check game or level ending conditions.
	 */
	public void checkConditions(){
		// check game over conditions
		if(!status.isGameOver() && status.isGameStarted()){
			if(status.getShipsLeft() == 0  ){
				gameOver();}
			else if (status.getAsteroidsDestroyed() == 5){
					newLevel();
					
				
				}
			}
		}
	
	
	/**
	 * Actions to take when the game is over.
	 */
	public void gameOver(){
		status.setGameStarted(false);
		status.setGameOver(true);
		gameScreen.doGameOver();
		
        // delay to display "Game Over" message for 3 seconds
		Timer timer = new Timer(3000, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				status.setGameOver(false);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	

	/**
	 * Fire a bullet from ship.
	 */
	public void fireBullet(){
		Bullet bullet = new Bullet(ship);
		bullets.add(bullet);
		soundMan.playBulletSound();
	}

	public void fireEnemyBullet(){
		EnemyBullet enemyBullet = new EnemyBullet(enemyShip);
		enemyBullet.add(enemyBullet);
		soundMan.playBulletSound();
		
	}
	
	/**
	 * Move a bullet once fired.
	 * @param bullet the bullet to move
	 * @return if the bullet should be removed from screen
	 */
	public boolean moveBullet(Bullet bullet){
		if(bullet.getY() - bullet.getSpeed() >= 0){
			bullet.translate(0, -bullet.getSpeed());
			return false;
		}
		else{
			return true;
		}
	}
	
	
	public boolean moveEnemyBullet(EnemyBullet enemyBullet){
		if(enemyBullet.getY() - enemyBullet.getSpeed() >= 0){
			enemyBullet.translate(0, -enemyBullet.getSpeed());
			//EnemyBullet.translate(rand.nextInt(), rand.nextInt());
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean moveEnemy(EnemyShip EnemyShip){
		if(EnemyShip.getY() - EnemyShip.getSpeed() >= 0){
//			EnemyShip.setLocation(rand.nextInt(), rand.nextInt());
			return false;
		}
		else{
			return true;
		}
	}
	/**
	 * Create a new ship (and replace current one).
	 */
	public Ship newShip(GameScreen screen){
		this.ship = new Ship(screen);
		return ship;
	}
	
	public EnemyShip newEnemyShip(GameScreen screen){
		//this.enemyShip = new EnemyShip(screen);
		return new EnemyShip (screen);
	}
	
	public BlackHole newHole(GameScreen screen){
		
		return new BlackHole (screen);
	}

	/**
	 * Create a new asteroid.
	 */
	public Asteroid newAsteroid(GameScreen screen){
		//this.asteroid = new Asteroid(screen);
		return new Asteroid(screen);
	}
	
	/**
	 * Returns the ship.
	 * @return the ship
	 */
	public Ship getShip() {
		return ship;
	}
	public EnemyShip getEnemyShip() {
		
		return enemyShip;
	}
	
	public BlackHole getHole() {
		
		return hole;
	}


	public EnemyShip getEnemyShip2() {
		return enemyShip2;
	}

	/**
	 * Returns the asteroid.
	 * @return the asteroid
	 */
	public Asteroid getAsteroid() {
		return asteroid;
	}
	public Asteroid getAsteroid2() {
		return asteroid2;
	}

	/**
	 * Returns the list of bullets.
	 * @return the list of bullets
	 */
	public List<Bullet> getBullets() {
		return bullets;
	}
	public List<EnemyBullet> getEnemyBullets() {
		return enemyBullets;
	}
	
//	public EnemyShip getEnemyShip(GameScreen screen){
//		return newEnemyShip(screen);
//	}
}
