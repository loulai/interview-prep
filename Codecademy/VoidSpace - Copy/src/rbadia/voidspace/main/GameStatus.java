package rbadia.voidspace.main;

/**
 * Container for game flags and/or status variables.
 */
public class GameStatus {
	// game flags
	private boolean gameStarted = false;
	private boolean gameStarting = false;
	private boolean gameOver = false;
	private boolean nextLevelStarted = false;
	private boolean nextLevelStarting = false;
	
	// status variables
	private boolean newShip;
	private boolean newEnemyShip;
	private boolean newAsteroid;
	private boolean newAsteroid2;
	private long asteroidsDestroyed = 0;
	private int shipsLeft;
	private int enemyShipsDestroyed;
	private int score;
	public boolean isNewHole;
	private boolean newHole;
	
	public GameStatus(){
		
	}
	
	/**
	 * Indicates if the game has already started or not.
	 * @return if the game has already started or not
	 */
	public synchronized boolean isGameStarted() {
		return gameStarted;
	}
	
	
	
	
	public synchronized void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}
	
	/**
	 * Indicates if the game is starting ("Get Ready" message is displaying) or not.
	 * @return if the game is starting or not.
	 */
	public synchronized boolean isGameStarting() {
		return gameStarting;
	}
	
	public synchronized void setGameStarting(boolean gameStarting) {
		this.gameStarting = gameStarting;
	}
	
	/**
	 * Indicates if the game has ended and the "Game Over" message is displaying.
	 * @return if the game has ended and the "Game Over" message is displaying.
	 */
	public synchronized boolean isGameOver() {
		return gameOver;
	}
	
	public synchronized void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	
	
	/**
	 * Indicates if a new ship should be created/drawn.
	 * @return if a new ship should be created/drawn
	 */
	public synchronized boolean isNewShip() {
		return newShip;
	}

	public synchronized void setNewShip(boolean newShip) {
		this.newShip = newShip;
	}

	/**
	 * Indicates if a new asteroid should be created/drawn.
	 * @return if a new asteroid should be created/drawn
	 */
	public synchronized boolean isNewAsteroid() {
		return newAsteroid;
	}

	public synchronized void setNewAsteroid(boolean newAsteroid) {
		this.newAsteroid = newAsteroid;
	}
	
	public synchronized boolean isNewAsteroid2() {
		return newAsteroid;
	}

	public synchronized void setNewAsteroid2(boolean newAsteroid2) {
		this.newAsteroid2 = newAsteroid2;
	}

	/**
	 * Returns the number of asteroid destroyed. 
	 * @return the number of asteroid destroyed
	 */
	public synchronized long getAsteroidsDestroyed() {
		return asteroidsDestroyed;
	}

	public synchronized void setAsteroidsDestroyed(long asteroidsDestroyed) {
		this.asteroidsDestroyed = asteroidsDestroyed;
	}

	/**
	 * Returns the number ships/lives left.
	 * @return the number ships left
	 */
	public synchronized int getShipsLeft() {
		return shipsLeft;
	}

	public synchronized void setShipsLeft(int shipsLeft) {
		this.shipsLeft = shipsLeft;
	}
	
	/**
	 * Returns the number of enemy ships destroyed
	 * @return the number of enemy ships destroyed
	 */
	public synchronized int getEnemyShipsDestroyed() {
		return enemyShipsDestroyed;
	}

	
	public synchronized void setEnemyShipsDestroyed(int enemyShipsDestroyed) {
		this.enemyShipsDestroyed = enemyShipsDestroyed;
	}

	
	/**
	 * Returns the score
	 * @return the score obtain
	 */
	public synchronized int getScore() {
		return score;
	}
	
	public synchronized void setScore(int score) {
		this.score = score;
	}


	public synchronized boolean isNextLevelStarted() {
		return nextLevelStarted;
	}
	public synchronized boolean isNextLevelStarting() {
		return nextLevelStarting;
	}
	public synchronized void setNextLevelStarted(boolean nextLevelStarted) {
		this.nextLevelStarted = nextLevelStarted;
	}
	public synchronized void setNextLevelStarting(boolean nextLevelStarting) {
		this.nextLevelStarting = nextLevelStarting;
	}

	public synchronized boolean isNewEnemyShip() {
		// TODO Auto-generated method stub
		return newEnemyShip;
	}
	public synchronized void setNewEnemyShip(boolean newEnemyShip) {
		this.newEnemyShip = newEnemyShip;
	}
	public synchronized boolean isNewEnemyShip2() {
		// TODO Auto-generated method stub
		return newEnemyShip;
	}
	public synchronized void setNewEnemyShip2(boolean newEnemyShip) {
		this.newEnemyShip = newEnemyShip;
	}

	public void setNewHole(boolean newHole) {
		// TODO Auto-generated method stub
		this.newHole = newHole;
	}
	
	
	
}
