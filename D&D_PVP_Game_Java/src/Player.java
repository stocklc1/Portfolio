import java.util.Random;

public class Player {
	
	Random randomNumber = new Random();
	
	protected String playerName;
	protected String mageClassDescription;
	protected String mageBonusDescription;
	protected String mageStatsInformation;
	protected String warriorClassDescription;
	protected String warriorBonusDescription;
	protected String warriorStatsInformation;
	protected String rangerClassDescription;
	protected String rangerBonusDescription;
	protected String rangerStatsInformation;
	protected String humanDescription;
	protected String dwarfDescription;
	protected String elfDescription;
	protected int baseHealth;
	protected int baseAttack;
	protected int startHealth;
	protected int startAttack;
	protected int baseBonusPercent;
	protected int endBonusPercent;
	protected boolean mageSelected;
	protected boolean warriorSelected;
	protected boolean rangerSelected;
	protected final String classFiles[] = {"MageClassPicture.PNG", "WarriorClassPicture.PNG", "RangerClassPicture.PNG"};
	protected final String raceFiles[] = {"HumanRacePicture.png", "ElfRacePicture.png", "DwarfRacePicture.png"};
	protected Weapon Weapon;
	protected int gold;
	
	public Player()
	{
		this.Weapon = new Weapon();
		this.playerName = "Player";
		this.mageSelected = false;
		this.warriorSelected = false;
		this.rangerSelected = false;
		this.baseHealth = 1300;
		this.baseAttack = 100;
		this.startHealth = 1300;
		this.startAttack = 100;
		this.baseBonusPercent = 25;
		this.endBonusPercent = 25;
		this.gold = 0;
		//All descriptions are from http://worldofwarcraft.com--
		this.humanDescription = "<html>Recent discoveries have shown that humans are descended from the barbaric vrykul, half-giant warriors who live in Northrend.</html>"; 
		this.dwarfDescription = "<html>The bold and courageous dwarves are an ancient race descended from the earthen—beings of living stone created by the titans when the world was young.</html>"; 
		this.elfDescription = "<html>The ancient and reclusive elves have played a pivotal role in shaping Azeroth’s fate throughout its history. More than ten thousand years ago, their heroics during the War of the Ancients helped stave off the demonic Burning Legion’s first invasion. </html>"; 
		this.mageClassDescription = "<html>Mages demolish their foes with arcane incantations. Although they wield powerful offensive spells, mages are fragile and lightly armored, making them particularly vulnerable to close-range attacks. Wise mages make careful use of their spells to keep their foes at a distance or hold them in place.</html>";
		this.mageBonusDescription = "<html>The mage recieves a bonus to their damage. They recieve a critical strike percentage bonus to all of their damage attacks. A chance to do double damage.<br><br>Base Critical Strike Chance: " + this.baseBonusPercent + "%</html>";
		this.mageStatsInformation = "<html>Base Health(Vitality): " + this.baseHealth + "<br>Base Attack(Intellect): " + this.baseAttack + "</html>";
		this.warriorClassDescription = "<html>Warriors equip themselves carefully for combat and engage their enemies head-on, letting attacks glance off their heavy armor. They use diverse combat tactics and a wide variety of weapon types to protect their more vulnerable allies.</html>";
		this.warriorBonusDescription = "<html>The warrior recieves a bonus to their damage. They recieve a critical strike percentage bonus to all of their damage attacks. A chance to do double damage.<br><br>Base Critical Strike Chance: " + this.baseBonusPercent + "%</html>";
		this.warriorStatsInformation = "<html>Base Health(Vitality): " + this.baseHealth + "<br>Base Attack(Strength): " + this.baseAttack + "</html>";
		this.rangerClassDescription = "<html>Rangers battle their foes at a distance. Though their missile weapons are effective at short and long ranges, rangers are also highly mobile. They can evade or restrain their foes to control the arena of battle.</html>";
		this.rangerBonusDescription = "<html>The ranger recieves a bonus to their damage. They recieve a critical strike percentage bonus to all of their damage attacks. A chance to do double damage.<br><br>Base Critical Strike Chance: " + this.baseBonusPercent + "%</html>";
		this.rangerStatsInformation = "<html>Base Health(Vitality): " + this.baseHealth + "<br>Base Attack(Dexterity): " + this.baseAttack + "</html>";
	}
	
	public int calcBonusPercent() {
		int extraBonusPercent = randomNumber.nextInt(25);
		return extraBonusPercent + this.baseBonusPercent;
	}
	
	public int startHealth() {
		int extraHealth = randomNumber.nextInt(500);
		return extraHealth + this.baseHealth;
	}
	
	public int startAttack() {
		int extraAttack = randomNumber.nextInt(100);
		return extraAttack + this.baseAttack;
	}
}
