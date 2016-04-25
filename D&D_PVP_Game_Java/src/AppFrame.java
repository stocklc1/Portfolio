
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;

import java.awt.Rectangle;
import java.awt.SystemColor;
import java.util.Random;

import javax.swing.border.SoftBevelBorder;

//---------------------------------------------------------------------------------------------------------------------
//Programming Assignment #3 – PVP Game
//Chris Stockley, w0271204
//March 11th, 2015
//Some code used/learned from stackoverflow.com and the included resources.
//---------------------------------------------------------------------------------------------------------------------
public class AppFrame extends JFrame {
	JOptionPane nameError = new JOptionPane();
	private final int ANIMATION_DELAY = 700;//700 ms
	private Timer timer = new Timer(ANIMATION_DELAY, new TimerHandler());
	Player newPlayer = new Player();
	Dragon currentDragon = new Dragon();
	Ogre currentOgre = new Ogre();
	int playerResetHealth;
	int enemyResetHealth;
	int enemyExtraHealth = 100;
	//-------------------------------------------------------------------------------------------[START BUTTONS/OTHERS]
	//Creation of all buttons and others.
	final JLabel lblPlayerName = new JLabel("");
	final JButton btnMage = new JButton("Mage");
	final JButton btnWarrior = new JButton("Warrior");
	final JButton btnRanger = new JButton("Ranger");
	final JButton btnHuman = new JButton("Human");
	final JButton btnElf = new JButton("Elf");
	final JButton btnDwarf = new JButton("Dwarf");
	final JButton btnRandomStats = new JButton("Random Stats");
	final JButton btnCreateCharacter = new JButton("Create");
	final JButton btnNewEnemy = new JButton("New Enemy");
	final JButton btnStartGame = new JButton("Adventure");
	final JLabel lblNewEnemy = new JLabel("");
	final JButton btnFight = new JButton("Fight Enemy");
	final JButton btnArmory = new JButton("Armory");
	final JLabel lblEnemyName = new JLabel("");
	final JLabel lblGamePlay = new JLabel("");
	final JLabel lblGold = new JLabel("Gold: 0 ");
	final JLabel lblPlayerHealth = new JLabel("");
	final JLabel lblEnemyHealth = new JLabel("");
	final JLabel lblVs = new JLabel("VS");
	final JLabel lblNewPlayerClass = new JLabel("");
	final JLabel lblWeapon2Name = new JLabel("");
	final JLabel lblWeapon1Name = new JLabel("");
	final JLabel lblWeapon2Description = new JLabel("");
	final JLabel lblWeapon1Description = new JLabel("");
	final JLabel lblArmory = new JLabel("Armory - Item Selection");
	final JLabel lblWeapon1 = new JLabel("");
	final JLabel lblWeapon2 = new JLabel("");
	final JLabel lblRaceLabel = new JLabel("      Race");
	final JLabel lblCharacterCreation = new JLabel("Character Creation Screen");
	final JLabel lblRaceDescription = new JLabel("Race Description");
	final JLabel lblClassBonusDescription = new JLabel("Class Bonus Description");
	final JLabel lblStatsInformation = new JLabel("Stats Information");
	final JLabel lblRandomizedStats = new JLabel("Randomized Stats");
	final JLabel lblCharacterName = new JLabel("Character Name");
	final JLabel lblClassLabel = new JLabel("      Class");
	final JLabel lblRacePicture = new JLabel("");
	final JLabel lblClassPicture = new JLabel("");
	final JPanel panelGameplay = new JPanel();
	final JPanel panelCharacterCreation = new JPanel();

	//---------------------------------------------------------------------------------------------[END BUTTONS/OTHERS]
	
	//---------------------------------------------------------------------------------------------------[START IMAGES]
	//Class Pictures.
	private final String enemyFiles[] = {"Dragon.png", "Ogre.PNG"};
	private Icon[] classIcons = {
			new ImageIcon(getClass().getResource(newPlayer.classFiles[0])),
			new ImageIcon(getClass().getResource(newPlayer.classFiles[1])),
			new ImageIcon(getClass().getResource(newPlayer.classFiles[2]))
			};
	//Race Pictures.
	private Icon[] raceIcons = {
			new ImageIcon(getClass().getResource(newPlayer.raceFiles[0])),
			new ImageIcon(getClass().getResource(newPlayer.raceFiles[1])),
			new ImageIcon(getClass().getResource(newPlayer.raceFiles[2]))
			};
	//Weapon Picture.
	private Icon[] weaponIcons = {
			new ImageIcon(getClass().getResource(newPlayer.Weapon.weaponFiles[0])),
			new ImageIcon(getClass().getResource(newPlayer.Weapon.weaponFiles[1])),
			new ImageIcon(getClass().getResource(newPlayer.Weapon.weaponFiles[2])),
			new ImageIcon(getClass().getResource(newPlayer.Weapon.weaponFiles[3])),
			new ImageIcon(getClass().getResource(newPlayer.Weapon.weaponFiles[4])),
			new ImageIcon(getClass().getResource(newPlayer.Weapon.weaponFiles[5]))
			};
	//Enemy
	private Icon[] enemyIcons = {
			new ImageIcon(getClass().getResource(enemyFiles[0])), 
			new ImageIcon(getClass().getResource(enemyFiles[1]))
			};
	//----------------------------------------------------------------------------------------------------[END IMAGES]
	private JPanel contentPane;
	private JTextField txtName;
	private JLabel lblClassDescription;
	private JPanel panelArmory;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppFrame frame = new AppFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppFrame() {
		//------------------------------------------------------------------------------------------------------------
		setPreferredSize(new Dimension(1000, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 539);
		//------------------------------------------------------------------------------------------------------------
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		//------------------------------------------------------------------------------------------------------------
		panelCharacterCreation.setBackground(SystemColor.menu);
		contentPane.add(panelCharacterCreation, "name_19100842265735");
		panelCharacterCreation.setLayout(null);
		//------------------------------------------------------------------------------------------------------------
		contentPane.add(panelGameplay, "name_218749218339598");
		panelGameplay.setLayout(null);
		//------------------------------------------------------------------------------------------------------------
		lblClassPicture.setOpaque(true);
		lblClassPicture.setBackground(Color.WHITE);
		lblClassPicture.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblClassPicture.setBounds(150, 84, 128, 130);
		panelCharacterCreation.add(lblClassPicture);
		//------------------------------------------------------------------------------------------------------------
		lblRacePicture.setOpaque(true);
		lblRacePicture.setBackground(Color.WHITE);
		lblRacePicture.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblRacePicture.setBounds(288, 84, 128, 130);
		panelCharacterCreation.add(lblRacePicture);
		//------------------------------------------------------------------------------------------------------------
		lblClassLabel.setOpaque(true);
		lblClassLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblClassLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblClassLabel.setBackground(new Color(216, 191, 216));
		lblClassLabel.setForeground(Color.BLACK);
		lblClassLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClassLabel.setBounds(21, 41, 119, 32);
		panelCharacterCreation.add(lblClassLabel);
		//------------------------------------------------------------------------------------------------------------
		lblRaceLabel.setOpaque(true);
		lblRaceLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRaceLabel.setForeground(Color.BLACK);
		lblRaceLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRaceLabel.setBackground(new Color(216, 191, 216));
		lblRaceLabel.setAlignmentX(0.5f);
		lblRaceLabel.setBounds(426, 41, 119, 32);
		panelCharacterCreation.add(lblRaceLabel);	
		//------------------------------------------------------------------------------------------------------------
		lblCharacterCreation.setForeground(Color.BLACK);
		lblCharacterCreation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblCharacterCreation.setBackground(Color.WHITE);
		lblCharacterCreation.setAlignmentX(0.5f);
		lblCharacterCreation.setBounds(148, 5, 276, 32);
		panelCharacterCreation.add(lblCharacterCreation);
		//------------------------------------------------------------------------------------------------------------
		lblClassDescription = new JLabel("Class Description");
		lblClassDescription.setForeground(Color.BLACK);
		lblClassDescription.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 9));
		lblClassDescription.setVerticalAlignment(SwingConstants.TOP);
		lblClassDescription.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblClassDescription.setBackground(new Color(216, 191, 216));
		lblClassDescription.setOpaque(true);
		lblClassDescription.setBounds(21, 225, 257, 74);
		panelCharacterCreation.add(lblClassDescription);
		//-------------------------------------------------------------------------------------------------------------
		lblRaceDescription.setForeground(Color.BLACK);
		lblRaceDescription.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 9));
		lblRaceDescription.setVerticalAlignment(SwingConstants.TOP);
		lblRaceDescription.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRaceDescription.setOpaque(true);
		lblRaceDescription.setBackground(new Color(216, 191, 216));
		lblRaceDescription.setBounds(288, 225, 257, 74);
		panelCharacterCreation.add(lblRaceDescription);
		//------------------------------------------------------------------------------------------------------------
		lblClassBonusDescription.setForeground(Color.BLACK);
		lblClassBonusDescription.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 9));
		lblClassBonusDescription.setVerticalAlignment(SwingConstants.TOP);
		lblClassBonusDescription.setOpaque(true);
		lblClassBonusDescription.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblClassBonusDescription.setBackground(new Color(216, 191, 216));
		lblClassBonusDescription.setBounds(21, 313, 172, 166);
		panelCharacterCreation.add(lblClassBonusDescription);
		//------------------------------------------------------------------------------------------------------------
		lblStatsInformation.setForeground(Color.BLACK);
		lblStatsInformation.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 9));
		lblStatsInformation.setVerticalAlignment(SwingConstants.TOP);
		lblStatsInformation.setOpaque(true);
		lblStatsInformation.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblStatsInformation.setBackground(new Color(216, 191, 216));
		lblStatsInformation.setBounds(373, 313, 172, 166);
		panelCharacterCreation.add(lblStatsInformation);
		//------------------------------------------------------------------------------------------------------------
		lblRandomizedStats.setForeground(Color.BLACK);
		lblRandomizedStats.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 9));
		lblRandomizedStats.setVerticalAlignment(SwingConstants.TOP);
		lblRandomizedStats.setOpaque(true);
		lblRandomizedStats.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRandomizedStats.setBackground(new Color(216, 191, 216));
		lblRandomizedStats.setBounds(203, 313, 160, 55);
		panelCharacterCreation.add(lblRandomizedStats);
		//------------------------------------------------------------------------------------------------------------
		lblCharacterName.setEnabled(false);
		lblCharacterName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCharacterName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharacterName.setBounds(203, 408, 160, 14);
		panelCharacterCreation.add(lblCharacterName);
		//------------------------------------------------------------------------------------------------------------
		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtName.setBounds(203, 425, 160, 20);
		panelCharacterCreation.add(txtName);
		txtName.setColumns(10);
		//------------------------------------------------------------------------------------------------------------
		panelArmory = new JPanel();
		contentPane.add(panelArmory, "name_203633544636148");
		panelArmory.setLayout(null);
		//------------------------------------------------------------------------------------------------------------
		lblWeapon1.setBorder(null);
		lblWeapon1.setBackground(Color.WHITE);
		lblWeapon1.setOpaque(true);
		lblWeapon1.setBounds(119, 101, 130, 128);
		panelArmory.add(lblWeapon1);
		lblWeapon1.addMouseListener(new MouseAdapter() {  
		    public void mouseClicked(MouseEvent e) {  
		    	lblWeapon1.setBorder(new LineBorder(Color.YELLOW, 4));
		    	lblWeapon2.setBorder(null);
		    	newPlayer.Weapon.normalIsEquipped = true;
		    	newPlayer.Weapon.specialIsEquipped = false;
		    	btnStartGame.setEnabled(true);
		    	
		    }  
		}); 
		//------------------------------------------------------------------------------------------------------------
		lblWeapon2.setEnabled(false);
		lblWeapon2.setOpaque(true);
		lblWeapon2.setBorder(null);
		lblWeapon2.setBackground(Color.WHITE);
		lblWeapon2.setBounds(301, 101, 130, 128);
		panelArmory.add(lblWeapon2);
		lblWeapon2.addMouseListener(new MouseAdapter() {  
		    public void mouseClicked(MouseEvent e) {  
		    	if (lblWeapon2.isEnabled())
		    	{
			    	lblWeapon1.setBorder(null);
			    	lblWeapon2.setBorder(new LineBorder(Color.YELLOW, 4));
			    	newPlayer.Weapon.normalIsEquipped = false;
			    	newPlayer.Weapon.specialIsEquipped = true;
			    	newPlayer.gold = newPlayer.gold - 500;
		    	}
		    }  
		});
		//------------------------------------------------------------------------------------------------------------
		lblArmory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblArmory.setBounds(137, 6, 256, 36);
		panelArmory.add(lblArmory);
		//------------------------------------------------------------------------------------------------------------
		lblWeapon1Description.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblWeapon1Description.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeapon1Description.setVerticalAlignment(SwingConstants.TOP);
		lblWeapon1Description.setBounds(119, 261, 130, 49);
		panelArmory.add(lblWeapon1Description);
		lblWeapon1Description.setText(newPlayer.Weapon.normalWeaponText);
		//------------------------------------------------------------------------------------------------------------
		lblWeapon2Description.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblWeapon2Description.setVerticalAlignment(SwingConstants.TOP);
		lblWeapon2Description.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeapon2Description.setBounds(301, 261, 130, 49);
		panelArmory.add(lblWeapon2Description);
		lblWeapon2Description.setText(newPlayer.Weapon.specialWeaponText);
		//------------------------------------------------------------------------------------------------------------
		lblWeapon1Name.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblWeapon1Name.setBounds(158, 75, 46, 14);
		panelArmory.add(lblWeapon1Name);
		//------------------------------------------------------------------------------------------------------------
		lblWeapon2Name.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblWeapon2Name.setBounds(347, 76, 46, 14);
		panelArmory.add(lblWeapon2Name);
		//------------------------------------------------------------------------------------------------------------
		lblNewPlayerClass.setBackground(Color.WHITE);
		lblNewPlayerClass.setOpaque(true);
		lblNewPlayerClass.setBounds(82, 71, 130, 128);
		panelGameplay.add(lblNewPlayerClass);
		//------------------------------------------------------------------------------------------------------------
		lblNewEnemy.setOpaque(true);
		lblNewEnemy.setBackground(Color.WHITE);
		lblNewEnemy.setBounds(337, 71, 130, 128);
		panelGameplay.add(lblNewEnemy);
		//------------------------------------------------------------------------------------------------------------
		lblVs.setFont(new Font("Dialog", Font.BOLD, 36));
		lblVs.setHorizontalAlignment(SwingConstants.CENTER);
		lblVs.setVerticalAlignment(SwingConstants.TOP);
		lblVs.setBounds(245, 112, 68, 47);
		panelGameplay.add(lblVs);
		//------------------------------------------------------------------------------------------------------------
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlayerName.setBounds(82, 46, 130, 14);
		panelGameplay.add(lblPlayerName);
		//------------------------------------------------------------------------------------------------------------
		lblEnemyName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnemyName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyName.setBounds(337, 46, 130, 14);
		panelGameplay.add(lblEnemyName);
		//------------------------------------------------------------------------------------------------------------
		lblGamePlay.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblGamePlay.setBackground(Color.WHITE);
		lblGamePlay.setOpaque(true);
		lblGamePlay.setVerticalAlignment(SwingConstants.TOP);
		lblGamePlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblGamePlay.setBounds(82, 229, 385, 128);
		panelGameplay.add(lblGamePlay);
		//------------------------------------------------------------------------------------------------------------
		lblGold.setBounds(477, 443, 72, 14);
		panelGameplay.add(lblGold);
		//------------------------------------------------------------------------------------------------------------
		lblPlayerHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerHealth.setForeground(Color.GREEN);
		lblPlayerHealth.setBounds(82, 210, 130, 14);
		panelGameplay.add(lblPlayerHealth);
		//------------------------------------------------------------------------------------------------------------
		lblEnemyHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyHealth.setForeground(Color.GREEN);
		lblEnemyHealth.setBounds(337, 210, 130, 14);
		panelGameplay.add(lblEnemyHealth);
		//------------------------------------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------------[START CREATED BUTTONS]
		//Randomize Stats Button./-------------------------------------------------------------[START RANDOMIZE STATS]
		btnRandomStats.setEnabled(false);
		btnRandomStats.setBounds(203, 374, 160, 23);
		panelCharacterCreation.add(btnRandomStats);
		btnRandomStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setEnabled(true);
				lblCharacterName.setEnabled(true);
				btnCreateCharacter.setEnabled(true);
				//btnCreateCharacter.setEnabled(true);
				newPlayer.endBonusPercent = newPlayer.calcBonusPercent();
				newPlayer.startHealth = newPlayer.startHealth();
				newPlayer.startAttack = newPlayer.startAttack();
				playerResetHealth = newPlayer.startHealth;
				enemyResetHealth = currentDragon.enemyHealth;
				lblRandomizedStats.setText("<html>Health: " + Integer.toString(newPlayer.startHealth) + "<br>Attack: " + Integer.toString(newPlayer.startAttack) +"<br>Percent Bonus: " + Integer.toString(newPlayer.endBonusPercent) + "%</html>");
			}
		});//------------------------------------------------------------------------------------[END RANDOMIZE STATS]
		
		//---------------------------------------------------------------------------------------[START CLASS BUTTONS]
		//All class picture are from: http://imageshack.com/f/855/2i4k.png--
		//Mage Selection Button.--------------------------------------------------------------------------[START MAGE]						 					
		btnMage.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMage.setBounds(21, 84, 119, 32);
		panelCharacterCreation.add(btnMage);
		btnMage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newPlayer.mageSelected = true;
				newPlayer.warriorSelected = false;
				newPlayer.rangerSelected = false;
				lblClassPicture.setIcon(classIcons[0]); 
				lblClassBonusDescription.setText(newPlayer.mageBonusDescription);
				lblStatsInformation.setText(newPlayer.mageStatsInformation);
				lblClassDescription.setText(newPlayer.mageClassDescription);
				btnMage.setEnabled(false);
				btnWarrior.setEnabled(true);
				btnRanger.setEnabled(true);
				if (raceSelected())
					btnRandomStats.setEnabled(true);
			}
		});
		//--------------------------------------------------------------------------------------------------[END MAGE]
	
		//Warrior Selection Button.--------------------------------------------------------------------[START WARRIOR]				
		btnWarrior.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnWarrior.setBounds(20, 134, 119, 32);
		panelCharacterCreation.add(btnWarrior);
		btnWarrior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPlayer.mageSelected = false;
				newPlayer.warriorSelected = true;
				newPlayer.rangerSelected = false;
				lblClassPicture.setIcon(classIcons[1]); 
				lblClassBonusDescription.setText(newPlayer.warriorBonusDescription);
				lblStatsInformation.setText(newPlayer.warriorStatsInformation);
				lblClassDescription.setText(newPlayer.warriorClassDescription);
				btnMage.setEnabled(true);
				btnWarrior.setEnabled(false);
				btnRanger.setEnabled(true);
				if (raceSelected())
					btnRandomStats.setEnabled(true);
			}
		});		
		//-----------------------------------------------------------------------------------------------[END WARRIOR]
		
		//Ranger Selection Button.//Mage Selection Button.----------------------------------------------[START RANGER]
		btnRanger.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRanger.setBounds(21, 182, 119, 32);
		panelCharacterCreation.add(btnRanger);
		btnRanger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPlayer.mageSelected = false;
				newPlayer.warriorSelected = false;
				newPlayer.rangerSelected = true;
				lblClassPicture.setIcon(classIcons[2]); 
				lblClassBonusDescription.setText(newPlayer.rangerBonusDescription);
				lblStatsInformation.setText(newPlayer.rangerStatsInformation);
				lblClassDescription.setText(newPlayer.rangerClassDescription);
				btnMage.setEnabled(true);
				btnWarrior.setEnabled(true);
				btnRanger.setEnabled(false);
				if (raceSelected())
					btnRandomStats.setEnabled(true);
			}
		});
		//------------------------------------------------------------------------------------------------[END RANGER]
		//-----------------------------------------------------------------------------------------[END CLASS BUTTONS]
	
		//----------------------------------------------------------------------------------------[START RACE BUTTONS]
		//Human Selection Button.------------------------------------------------------------------------[START HUMAN]
		//Human race picture is from: http://media.blizzard.com/wow/media/artwork/wow-leader/varian-wrynn-full.jpg
		btnHuman.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHuman.setBounds(426, 84, 119, 32);
		panelCharacterCreation.add(btnHuman);
		btnHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRacePicture.setIcon(raceIcons[0]); 
				lblRaceDescription.setText(newPlayer.humanDescription);
				btnHuman.setEnabled(false);
				btnElf.setEnabled(true);
				btnDwarf.setEnabled(true);
				if(classSelected())
					btnRandomStats.setEnabled(true);
			}
		});//----------------------------------------------------------------------------------------------[END HUMAN]
		
		//Elf Selection Button.----------------------------------------------------------------------------[START ELF]					      
		//Elf race picture is from: http://desktop.freewallpaper4.me/view/original/5733/world-of-warcraft-night-elf.jpg
		btnElf.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnElf.setBounds(426, 131, 119, 32);
		panelCharacterCreation.add(btnElf);
		btnElf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRacePicture.setIcon(raceIcons[1]); 
				lblRaceDescription.setText(newPlayer.elfDescription);
				btnHuman.setEnabled(true);
				btnElf.setEnabled(false);
				btnDwarf.setEnabled(true);
				if(classSelected())
					btnRandomStats.setEnabled(true);
			}
		});//------------------------------------------------------------------------------------------------[END ELF]
		
		//Dwarf Selection Button.------------------------------------------------------------------------[START DWARF]
		//Dwarf race picture is from: http://avatars.guildlaunch.net/character_files/7034430/avatar7136.jpg
		btnDwarf.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDwarf.setBounds(426, 182, 119, 32);
		panelCharacterCreation.add(btnDwarf);
			btnDwarf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblRacePicture.setIcon(raceIcons[2]); 
					lblRaceDescription.setText(newPlayer.dwarfDescription);
					btnHuman.setEnabled(true);
					btnElf.setEnabled(true);
					btnDwarf.setEnabled(false);
					if(classSelected())
						btnRandomStats.setEnabled(true);
			}
		});//----------------------------------------------------------------------------------------------[END DWARF]
		//------------------------------------------------------------------------------------------[END RACE BUTTONS]
		
		//Create Character Button.------------------------------------------------------------[START CREATE CHARACTER]
		btnCreateCharacter.setEnabled(false);
		btnCreateCharacter.setBounds(203, 456, 160, 23);
		panelCharacterCreation.add(btnCreateCharacter);
		btnCreateCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nameValidation(txtName.getText()))
				{
					panelCharacterCreation.setVisible(false);
					panelArmory.setVisible(true);
					if(newPlayer.mageSelected == true)
					{
						lblNewPlayerClass.setIcon(classIcons[0]);
						lblWeapon1.setIcon(weaponIcons[2]); 
						lblWeapon2.setIcon(weaponIcons[3]);
						lblWeapon1Name.setText("Wand");
						lblWeapon2Name.setText("Staff");
					}
					if(newPlayer.warriorSelected == true)
					{
						lblNewPlayerClass.setIcon(classIcons[1]);
						lblWeapon1.setIcon(weaponIcons[0]); 
						lblWeapon2.setIcon(weaponIcons[1]);
						lblWeapon1Name.setText("Axe");
						lblWeapon2Name.setText("Sword");
					}
					if(newPlayer.rangerSelected == true)
					{
						lblNewPlayerClass.setIcon(classIcons[2]);
						lblWeapon1.setIcon(weaponIcons[4]); 
						lblWeapon2.setIcon(weaponIcons[5]);
						lblWeapon1Name.setText("Bow");
						lblWeapon2Name.setText("Gun");
					}	
					newPlayer.playerName = txtName.getText();
					lblPlayerName.setText(newPlayer.playerName);
				}
				else
					JOptionPane.showMessageDialog(null, "Names Must Contain Letters Only");
				
					
			}
		});//-----------------------------------------------------------------------------------[END CREATE CHARACTER]
		
		//Fight Button-----------------------------------------------------------------------------------[START FIGHT]
		btnFight.setBounds(82, 371, 385, 23);
		panelGameplay.add(btnFight);
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFight.setEnabled(false);	
				timer.start();
			}
		});//Fight Button----------------------------------------------------------------------------------[END FIGHT]
		
		//New Enemy Button---------------------------------------------------------------------------[START NEW ENEMY]
		btnNewEnemy.setEnabled(false);
		btnNewEnemy.setBounds(82, 405, 385, 23);
		panelGameplay.add(btnNewEnemy);
		btnNewEnemy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enemyExtraHealth += 50;
				findEnemy();
				btnFight.setEnabled(true);
				btnArmory.setEnabled(false);
				btnNewEnemy.setEnabled(false);
				newPlayer.startHealth = playerResetHealth;
				currentDragon.enemyHealth = enemyResetHealth + enemyExtraHealth;
			}
		});//New Enemy Button Button.------------------------------------------------------------------[END NEW ENEMY]
		
		//Armory Button---------------------------------------------------------------------------------[START Armory]
		btnArmory.setEnabled(false);
		btnArmory.setBounds(82, 439, 385, 23);
		panelGameplay.add(btnArmory);
		btnArmory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelGameplay.setVisible(false);
				panelArmory.setVisible(true);
				if(newPlayer.gold >= 500)
					lblWeapon2.setEnabled(true);
			}
		});//Armory Button--------------------------------------------------------------------------------[END Armory]

		
		
		//-------------------------------------------------------------------------------------------[START STARTGAME]
		btnStartGame.setEnabled(false);
		btnStartGame.setBounds(119, 329, 312, 73);
		panelArmory.add(btnStartGame);
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelArmory.setVisible(false);
				panelGameplay.setVisible(true);
				findEnemy();
			}
		});//------------------------------------------------------------------------------------------[END STARTGAME]
		
		//---------------------------------------------------------------------------------------[END CREATED BUTTONS]		
		
	}//-----------------------------------------------------------------------------------------------[END AppFrame()]
	
	//----------------------------------------------------------------------------------------------[START VALIDATION]
	//Validation for if the race of the character is selected.
	public boolean raceSelected(){
		if(btnDwarf.isEnabled() && btnElf.isEnabled() && btnHuman.isEnabled())
			return false;
		else
			return true;
	}
	//Validation for if the class of the character is selected.
	public boolean classSelected(){
		if(btnMage.isEnabled() && btnWarrior.isEnabled() && btnRanger.isEnabled())
			return false;
		else
			return true;
	}
	//Validation for if the name of the character is all letters.
	public boolean nameValidation(String name) {
	    char[] chars = name.toCharArray();
	    int tempNum = 0;
	    for (char c : chars) {
	        tempNum += 1;
	    	if(!Character.isLetter(c)) {
	            return false;
	        }
	    }
	    if (tempNum == 0)
	    	return false;

	    return true;
	}//-----------------------------------------------------------------------------------------------[END VALIDATION]
	
	
	private class TimerHandler implements ActionListener//---------------------------------------[START TIMER HANDLER]
	{
		@Override public void actionPerformed(ActionEvent actionEvent)
		{
			fightEnemy();
		}
	}//--------------------------------------------------------------------------------------------[END TIMER HANDLER]
	
	public void findEnemy(){//---------------------------------------------------------------------[START findEnemy()]
		
		Random randomNumber = new Random();
		int randomEnemy = randomNumber.nextInt(2);
		
		if (randomEnemy == 0)
			{
				lblNewEnemy.setIcon(enemyIcons[0]); 
				lblEnemyName.setText(currentDragon.enemyName);
			}
		else
			{
				lblNewEnemy.setIcon(enemyIcons[1]); 
				lblEnemyName.setText(currentOgre.enemyName);
			}
	}//----------------------------------------------------------------------------------------------[End findEnemy()]
	
	public void fightEnemy(){
		if(newPlayer.startHealth > 0 && currentDragon.enemyHealth > 0) //-------------------------[START fightEnemy()]
		{
			Random randomNumber = new Random();
			int bonusRange = randomNumber.nextInt(100);
			int playerCurrentAttack = 0;
			int enemyCurrentAttack = 0;
			
			enemyCurrentAttack = currentDragon.calcActualEnemyAttack();
			
			if (newPlayer.Weapon.normalIsEquipped == true)
				if(bonusRange >= 1 && bonusRange <= newPlayer.endBonusPercent)
					playerCurrentAttack = (newPlayer.Weapon.calculateNormalWeaponDamage() + newPlayer.startAttack) * 2;
				else
					playerCurrentAttack = newPlayer.Weapon.calculateNormalWeaponDamage() + newPlayer.startAttack;
			
			if (newPlayer.Weapon.specialIsEquipped == true)
				if(bonusRange >= 1 && bonusRange <= newPlayer.endBonusPercent)
					playerCurrentAttack = (newPlayer.Weapon.calculateSpecialWeaponDamage() + newPlayer.startAttack) * 2;
				else
					playerCurrentAttack = newPlayer.Weapon.calculateSpecialWeaponDamage() + newPlayer.startAttack;
			
			newPlayer.startHealth = newPlayer.startHealth - enemyCurrentAttack;
			currentDragon.enemyHealth = currentDragon.enemyHealth - playerCurrentAttack;
			lblPlayerHealth.setText("Health: " + newPlayer.startHealth);
			lblEnemyHealth.setText("Health: " + currentDragon.enemyHealth);
			lblGamePlay.setText("<html>" + newPlayer.playerName  + " hits enemy for " +Integer.toString(playerCurrentAttack) + "<br>Enemy hit " +  newPlayer.playerName + " for " + Integer.toString(enemyCurrentAttack) + "</html>");
		}
		else if (newPlayer.startHealth > 0 && currentDragon.enemyHealth <= 0)
		{
			lblGamePlay.setText("<html> Enemy Dead<br>" + newPlayer.playerName + " Earned 50 gold");
			newPlayer.gold += 50;
			btnNewEnemy.setEnabled(true);
			btnArmory.setEnabled(true);
			lblGold.setText("Gold: " + newPlayer.gold);
			newPlayer.startAttack = newPlayer.startAttack + 25;
			timer.stop();
		}
		else if (newPlayer.startHealth <= 0)
			lblGamePlay.setText("<html> Player Dead<br>Game Over");
	}//---------------------------------------------------------------------------------------------[END fightEnemy()]
	
}//-----------------------------------------------------------------------------------------------------[End AppFrame]
