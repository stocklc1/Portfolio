public class Dragon extends Enemy{
	
	protected String magicBreath;
	
	public Dragon()
	{
		this.magicBreath = "fire";
		this.enemyName = "Dragon";
	}

	@Override
	public int calcActualEnemyAttack() {
		int randomEnemyAttack = randomNumber.nextInt(50);
		return (randomEnemyAttack + this.baseAttack) + 75;
	}
}
