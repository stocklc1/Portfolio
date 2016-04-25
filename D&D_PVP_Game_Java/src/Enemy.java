import java.util.Random;

public abstract class Enemy {
	Random randomNumber = new Random();
	protected String enemyName;
	protected int enemyHealth;
	protected int baseAttack;
	
		public Enemy(){
			this.enemyName = "Monster";
			this.enemyHealth = 1200;
			this.baseAttack = 100;
		}
		
	public abstract int calcActualEnemyAttack();
		
}
