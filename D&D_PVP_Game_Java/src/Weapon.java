import java.util.Random;

public class Weapon {
	Random randomNumber = new Random();
	
	protected final String weaponFiles[] = {"Axe.PNG","Sword.PNG", "Wand.PNG","Staff.PNG", "Bow.PNG", "Gun.PNG"};
	protected String normalWeaponText; 
	protected String specialWeaponText; 
	protected int normalWeaponMinDamage;
	protected int specialWeaponMinDamage;
	protected int normalWeaponMaxDamage;
	protected int specialWeaponMaxDamage;
	protected boolean normalIsEquipped; 
	protected boolean specialIsEquipped;
	
	public Weapon()
	{
		this.normalIsEquipped = false;
		this.specialIsEquipped = false;
		this.normalWeaponMinDamage = 25;
		this.specialWeaponMinDamage = 150;
		this.normalWeaponMaxDamage  = 50;
		this.specialWeaponMaxDamage = 300;
		this.normalWeaponText = "<html>Min Damage - " + this.normalWeaponMinDamage + "<br>Max Damage - " + this.normalWeaponMaxDamage + "<br>Cost - Free</html>";
		this.specialWeaponText = "<html>Min Damage - " + this.specialWeaponMinDamage + "<br>Max Damage - " + this.specialWeaponMaxDamage + "<br>Cost - 500 Gold</html>";
	}
	
	public int calculateNormalWeaponDamage(){
		int normalWeaponRange = randomNumber.nextInt(this.normalWeaponMaxDamage);
		return normalWeaponRange;
		
	}
	
	public int calculateSpecialWeaponDamage(){
		int specialWeaponRange = randomNumber.nextInt(this.specialWeaponMaxDamage);
		return specialWeaponRange;	
	}

}
