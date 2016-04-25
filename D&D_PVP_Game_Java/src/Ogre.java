public class Ogre extends Enemy{
	protected int extraHeads;

	public Ogre()
	{
		this.extraHeads = 1;
		this.enemyName = "Ogre";
	}

	@Override
	public int calcActualEnemyAttack() {
		int randomEnemyAttack = randomNumber.nextInt(50);
		return randomEnemyAttack + this.baseAttack + 50;
	}
}
