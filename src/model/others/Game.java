package model.others;

import model.characters.*;
import model.doors.*;
import model.objects.*;

import java.util.Scanner;
import java.util.Random;

public class Game {


	/*** === ATTRIBUTES === ***/

	private int party = 1;

	// === INSTANTIATIONS ===

	// - Places -
	public static final Place ANIMAL_ROOM = new Place("animal room", false, true);
	public static final Place TRANSFER_ROOM = new Place("transfer room", false, true);
	public static final Place CHANGING_ROOM = new Place("changing room", false, true);
	public static final Place ENTRY = new Place("entry", false, true);
	public static final Place MEETING_ROOM = new Place("meeting room", false, true);
	public static final Place ARCHIVES_ROOM = new Place("archives room", false, true);
	public static final Place EXPERIMENTS_ROOM = new Place("experiments room", false, true);
	public static final Place MORGUE = new Place("morgue", false, true); // on éclaire la pièce ?
	public static final Place CONDAMNED_SAS = new Place("condamned sas", true, true);
	public static final Place DESERTED_ROOM = new Place("deserted room", false, true);
	public static final Place PRODUCTS_RESERVE = new Place("products reserve", false, true);
	public static final Place GARBAGE_ROOM = new Place("garbage room", false, true);
	public static final Place COLD_ROOM = new Place("cold room", false, false);
	public static final Place DIRTY_CHANGINGROOM = new Place("dirty changingroom", false, true); // est ce qu'on pourrait pas l'enlever ?
	public static final Place DECONTAMINATION_ROOM = new Place("decontamination room", false, true);
	public static final Place EXIT = new Place("exit", false, true);

	// - Doors -
	public static final Door SECRET_PASSAGE = new BurnableDoor(ARCHIVES_ROOM, null);
	public static final Door EXPERIM_AND_CONDA = new InfectedRoomDoor(EXPERIMENTS_ROOM, CONDAMNED_SAS);
	public static final Door CHANG_AND_ENTRY = new CondemnedDoor(CHANGING_ROOM, ENTRY);
	public static final Door MEET_AND_ARCH = new DestructableDoor(MEETING_ROOM, ARCHIVES_ROOM);
	public static final Door TRANSF_AND_MEET = new LockedKeyDoor(1, TRANSFER_ROOM, MEETING_ROOM);
	public static final Door DECONT_AND_EXIT = new LockedKeyDoor(2, DECONTAMINATION_ROOM, EXIT);
	public static final Door ANIM_AND_TRANSF = new SecretCodeDoor("IT", ANIMAL_ROOM, TRANSFER_ROOM);
	public static final Door EXPERIM_AND_RESERV = new SecretCodeDoor("S A GREAT", EXPERIMENTS_ROOM, PRODUCTS_RESERVE);
	public static final Door EXPERIM_AND_DIRTY = new SecretCodeDoor("GAME", EXPERIMENTS_ROOM, DIRTY_CHANGINGROOM);
	public static final Door TRANSF_AND_CHANG = new Door(TRANSFER_ROOM, CHANGING_ROOM);
	public static final Door TRANSF_AND_EXPER = new Door(TRANSFER_ROOM, EXPERIMENTS_ROOM);
	public static final Door EXPERIM_AND_MORT = new Door(EXPERIMENTS_ROOM, MORGUE);
	public static final Door CONDA_AND_DESERT = new Door(CONDAMNED_SAS, DESERTED_ROOM);
	public static final Door EXPERIM_AND_COLD = new Door(EXPERIMENTS_ROOM, COLD_ROOM);
	public static final Door COLD_AND_GARB = new Door(COLD_ROOM, GARBAGE_ROOM);
	public static final Door DIRT_AND_DECON = new Door(DIRTY_CHANGINGROOM, DECONTAMINATION_ROOM);


	// - Animals -
	public static final Animal CAT = new Animal("cat",1,Script.CAT_TEXT01,Script.CAT_TEXT02,Script.CAT_DESCRIPT);
	public static final Animal MOUSE = new Animal("mouse",2,Script.MOUSE_TEXT01,Script.MOUSE_TEXT02,Script.MOUSE_DESCRIPT);
	public static final Monkey MONKEY = new Monkey("monkey",3,Script.MONKEY_TEXT01,Script.MONKEY_TEXT02,Script.MONKEY_TEXT03,Script.MONKEY_DESCRIPT);


	// - Objects -
	public static final Weapon CLUB = new Weapon(Script.DEFAULT_CLUB_NAME, Script.CLUB_DESCRIPT);
	public static final Potion POTION = new Potion(Script.DEFAULT_POTION_NAME, Script.POTION_DESCRIPT);
	public static final Banana BANANA = new Banana(Script.DEFAULT_BANANA_NAME, Script.BANANA_DESCRIPT);
	public static final Stick STICK = new Stick(Script.DEFAULT_STICK_NAME, Script.STICK_DESCRIPT);
	public static final Flint FLINT = new Flint(Script.DEFAULT_FLINT_NAME, Script.FLINT_DESCRIPT);
	public static final Fuse FUSE = new Fuse(Script.DEFAULT_FUSE_NAME, Script.FUSE_DESCRIPT);
	public static final Bescherelle CAT_B = new Bescherelle(Script.DEFAULT_BESCHERELLE_NAME, Script.BESCH_DESCRIPT);
	public static final Bescherelle MOUSE_B = new Bescherelle(Script.DEFAULT_BESCHERELLE_NAME, Script.BESCH_DESCRIPT);
	public static final Bescherelle MONKEY_B = new Bescherelle(Script.DEFAULT_BESCHERELLE_NAME, Script.BESCH_DESCRIPT);
	public static final Key K_1 = new Key(Script.DEFAULT_KEY1_NAME, Script.KEY_DESCRIPT);
	public static final Key K_2 = new Key(Script.DEFAULT_KEY2_NAME, Script.KEY_DESCRIPT);
	public static final ElectricityMeter ELECTRICITY_METER = new ElectricityMeter(Script.DEFAULT_ELECTRICMETER_NAME, Script.ELECTRICMETER_DESCRIPT, COLD_ROOM);
	public static final FiredStick FIRED_STICK = new FiredStick(Script.DEFAULT_FIREDSTICK_NAME, Script.FIRED_STICK_DESCRIPT);
	public static final NaziPoster NAZI_POSTER = new NaziPoster(Script.DEFAULT_NAZIPOSTER_NAME, Script.NAZI_POSTER);
	public static final SexyPoster SEXY_POSTER = new SexyPoster(Script.DEFAULT_SEXYPOSTER_NAME, Script.SEXY_POSTER);
	public static final Walkman WALKMAN = new Walkman(Script.DEFAULT_WALKMAN_NAME, Script.DEFAULT_WALKMAN_NAME);


	// - Hero -
	public final static Hero HERO = new Hero(ANIMAL_ROOM);


	// - Locker -
	public static final Locker LOCKER = new Locker(Script.DEFAULT_LOCKER_NAME, Script.DEFAULT_LOCKER_NAME, HERO);


	// - Enemies -
	public static final Enemy ACCOUNT_GUY = new Enemy("account guy", 45, 1, K_1,
	Script.ACCOUNTGUY_DEFAULT, Script.ACCOUNTGUY_ATTACK, Script.ACCOUNTGUY_DEFEAT,Script.ACCOUNTGUY_DESCRIPT);

	public static final Enemy ZOMBIE_NAZI = new Enemy("zombie nazi", 60, 4, FUSE,
			Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK, Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);

	public static final Enemy SUPER_NAZI = new Enemy("super-nazi", 100, 8, K_2,
		Script.BOSS_DEFAULT, Script.BOSS_ATTACCK, Script.BOSS_DEFEAT,Script.BOSS_DESCRIPT);


	/*** === CONSTRUCTOR === ***/
	public Game(String heroName) {

		// HERO INITIALIZATION
		HERO.setName(heroName);

		// DOORS ADDING TO ROOMS
		ANIMAL_ROOM.addDoor(ANIM_AND_TRANSF, "up");
		CHANGING_ROOM.addDoor(TRANSF_AND_CHANG, "up");
		CHANGING_ROOM.addDoor(CHANG_AND_ENTRY, "down");
		ENTRY.addDoor(CHANG_AND_ENTRY, "up");
		TRANSFER_ROOM.addDoor(ANIM_AND_TRANSF, "down");
		TRANSFER_ROOM.addDoor(TRANSF_AND_CHANG, "down");
		TRANSFER_ROOM.addDoor(TRANSF_AND_MEET, "right");
		TRANSFER_ROOM.addDoor(TRANSF_AND_EXPER, "up");
		MEETING_ROOM.addDoor(TRANSF_AND_MEET, "left");
		MEETING_ROOM.addDoor(MEET_AND_ARCH, "right");
		ARCHIVES_ROOM.addDoor(MEET_AND_ARCH, "left");
		EXPERIMENTS_ROOM.addDoor(TRANSF_AND_EXPER, "down");
		EXPERIMENTS_ROOM.addDoor(EXPERIM_AND_MORT, "right");
		EXPERIMENTS_ROOM.addDoor(EXPERIM_AND_CONDA, "up");
		EXPERIMENTS_ROOM.addDoor(EXPERIM_AND_RESERV, "up");
		EXPERIMENTS_ROOM.addDoor(EXPERIM_AND_COLD, "left");
		EXPERIMENTS_ROOM.addDoor(EXPERIM_AND_DIRTY, "left");
		MORGUE.addDoor(EXPERIM_AND_MORT, "left");
		MORGUE.addDoor(SECRET_PASSAGE, "down");
		CONDAMNED_SAS.addDoor(EXPERIM_AND_CONDA, "down");
		CONDAMNED_SAS.addDoor(CONDA_AND_DESERT, "up");
		DESERTED_ROOM.addDoor(CONDA_AND_DESERT, "down");
		PRODUCTS_RESERVE.addDoor(EXPERIM_AND_RESERV, "down");
		COLD_ROOM.addDoor(EXPERIM_AND_COLD, "right");
		COLD_ROOM.addDoor(COLD_AND_GARB, "up");
		GARBAGE_ROOM.addDoor(COLD_AND_GARB, "down");
		DIRTY_CHANGINGROOM.addDoor(EXPERIM_AND_DIRTY, "right");
		DIRTY_CHANGINGROOM.addDoor(DIRT_AND_DECON, "left");
		DECONTAMINATION_ROOM.addDoor(DIRT_AND_DECON, "right");
		DECONTAMINATION_ROOM.addDoor(DECONT_AND_EXIT, "left");
		EXIT.addDoor(DECONT_AND_EXIT, "right");

		// ANIMALS ADDING TO ROOMS
		ANIMAL_ROOM.addAnimal(CAT);
		EXPERIMENTS_ROOM.addAnimal(MONKEY);
		EXPERIMENTS_ROOM.addAnimal(MOUSE);

		// OBJECTS ADDING TO ROOMS
		ANIMAL_ROOM.addObject(CAT_B);
		TRANSFER_ROOM.addObject(FLINT);
		TRANSFER_ROOM.addObject(ELECTRICITY_METER);
		CHANGING_ROOM.addObject(SEXY_POSTER);
		CHANGING_ROOM.addObject(LOCKER);
		LOCKER.addObj(WALKMAN);
		EXPERIMENTS_ROOM.addObject(NAZI_POSTER);
		COLD_ROOM.addObject(BANANA);
		GARBAGE_ROOM.addObject(STICK);
		ARCHIVES_ROOM.addObject(CLUB);
		ARCHIVES_ROOM.addObject(MOUSE_B);
		PRODUCTS_RESERVE.addObject(POTION);
		DESERTED_ROOM.addObject(MONKEY_B);
		DIRTY_CHANGINGROOM.addObject(SEXY_POSTER);

		// ENEMIES ADDING TO ROOMS
		MEETING_ROOM.addAndCreateEnemy(ACCOUNT_GUY);
		DESERTED_ROOM.addAndCreateEnemy(ZOMBIE_NAZI);
		DECONTAMINATION_ROOM.addAndCreateEnemy(SUPER_NAZI);
	}


	/*** === METHODS === ***/

	// === COMMANDS ===

	public void battle(Hero hero, Enemy enemy){

		//===VARIABLES
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int eHeal; 																										//Enemy heal
		String input;
		String[] tabInput;
		int count;

		//===BATTLE OPENING
		sysClear();
		System.out.println(Script.BATTLE_BEGIN + enemy.NAME);
		pressAnyKeyToContinue();
		sysClear();
		enemy.opening();
		enemy.descript();
		System.out.println(Script.BATTLE_HELP);
		sleep(1000);

		//===BATTLE AREA
		while (hero.isAlive() && !enemy.isDefeat()) {

			//===ENEMY TURN
			eHeal = rand.nextInt(10+1);																			//The enemy got 10% of luck to cure itself
			System.out.println("\n========== " + enemy.NAME.toUpperCase() + " turn : ==========");
			sleep(1000);
			if (eHeal == 1) {
				enemy.heal(10);
			}
			else {
				enemy.attack();
			}
			hero.setLife(enemy.getDamage());
			sleep(1000);
			if (hero.getHP() == 0) {
				break;
			}
			//===HERO TURN
			System.out.println("\n========== Your turn : ==========\n\nLIFE : " + hero.getHP() + "\n");
			System.out.print("Choice :>");
			//Count of the number of words
			input = sc.nextLine();
			tabInput = input.split(" ");
			count = tabInput.length;

			switch (count) {
				case 1 :
					switch (tabInput[0]) {
						case "attack":
							hero.attack(enemy);                                                            				//Attack the enemy
							break;
						case "heal":
							hero.heal();                                                                        		//Cure the player
							break;
						default : printLetterByLetter("Haha I know you can't read but make a little effort if you don't want to end up in mush...You pass your turn !\n", Script.DEFAULT_NARRATOR);
					}
					pressAnyKeyToContinue();
					break;
				
				case 2:
					printLetterByLetter("You have no time for 2-words commands, you're fighting ! So please only 1 command, I know that you aren't a genius but make some effort.\n", Script.DEFAULT_NARRATOR);
					pressAnyKeyToContinue();
					break;

				default :
					printLetterByLetter("Whatever ! You pass your turn !\n", Script.DEFAULT_NARRATOR);
					pressAnyKeyToContinue();
			}
			sysClear();
		}

		//===ONCE ENEMY IS DEFEATED
		if (enemy.isDefeat()) {
			System.out.println("============= END OF THE BATTLE : " + enemy.NAME + " DEFEATED =============");
			enemy.defeat();
			printLetterByLetter("Good Game, you defeat this bad Nazi crap !\n", Script.DEFAULT_NARRATOR);
			hero.getPlace().addObject(enemy.getItem());
			printLetterByLetter("An object fell from the corpse of " + enemy.NAME + ". Looks like the " + enemy.getItem().NAME + "\n", Script.DEFAULT_NARRATOR);
			hero.take(enemy.getItem().NAME);
			enemy.loot();
			hero.getPlace().setEnemy(null);
			pressAnyKeyToContinue();
			sysClear();
		}
		else {
			gameOver();
		}
	}

	public void help() {
		System.out.println(Script.HELP_DEFAULT);
	}


	// === OTHER ===

	public void Play(){
		if (this.party < 2){																							//Don't need a new synopsis and context after a game over
			sysClear();
			System.out.print(Script.SYNOPSIS + "\n");
			pressAnyKeyToContinue();
			sysClear();
			openingGame();
		}
		while(this.HERO.isAlive() && !this.HERO.getPlace().getName().equals("exit") && !this.HERO.isQuit()){
			this.PlayATurn();
		}
		this.gameOver();
	}

	public void PlayATurn(){
		sysClear();
		if (this.HERO.getPlace().isContainsEnemies()) {
			battle(this.HERO, this.HERO.getPlace().getEnemy());
		}
		this.displayEnvironment();
		cmdPush(2);
		System.out.print("\nCurrent HP : " + this.HERO.getHP() + "\n");
		this.HERO.showInventory();
		System.out.print("\n\nCommand :> ");
		int count; 																										//count of words
		String input; 																									//input String
		String[] tabInput = new String[0]; 																				//Tab of words
		Scanner scanner = new Scanner(System.in); 																		//Scanner for input

		if(scanner.hasNext()){
			input = scanner.nextLine();
			tabInput = input.split(" "); 																			//Split the input into the tab when the char is "space"
		}
		System.out.println();
		count = tabInput.length; 																						//count is equal to the number of words
		switch (count) {

			case 1:
				switch (tabInput[0].toLowerCase()) {
					case "help":
						this.help(); 																					//show commandsbreak;
						break;
					case "quit":
						this.HERO.quit(this.HERO.getName()); 																//exit prompt
						break;
					case "inventory":
						this.HERO.showInventory();
						break;
					default: System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;

			case 2:
				switch (tabInput[0].toLowerCase()) {
					case "go":
						this.HERO.go(tabInput[1]);
						break;
					case "take":
						this.HERO.take(tabInput[1]);
						break;
					case "use":
						this.HERO.use(tabInput[1]);
						break;
					case "look":
						this.HERO.lookAt(tabInput[1]);
						break;
					case "talk":
						this.HERO.talk(tabInput[1]);
						break;
					default:  System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;

			case 3:
				switch (tabInput[0].toLowerCase()) {
					case "go":
						this.HERO.go(tabInput[1]+" "+tabInput[2]);
						break;
					case "look":
						this.HERO.lookAt(tabInput[1]+" "+tabInput[2]);
						break;
					case "use":
						this.HERO.use(tabInput[1],tabInput[2]);
						break;
					default : System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;

			default : System.out.println("Wrong input, write \"help\" if you're lost with commands");
		}
		pressAnyKeyToContinue();
	}

	//Game Over - with Loose, Win and default exceptions
	public void gameOver() {

		//LOOSE ENDING
		if (this.HERO.getHP() <= 0) {

			Scanner sc = new Scanner(System.in);
			String choice;

			sysClear();
			printLetterByLetter(Script.YOU_LOOSE, Script.DEFAULT_NARRATOR);
			cmdPush(30);
			System.out.print("Continue ? : ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("YES") || choice.equalsIgnoreCase("Y")) {
				this.party++;
				this.HERO.setLife(-(Hero.DEFAULT_HP));																	//-100 cause setLife() remove life to the Hero, so -(-100) = +100
				this.Play();																							//You return where you were before die
			}
			else{
				this.HERO.quit(this.HERO.getName());
			}
		}

		//WIN ENDING
		else if (!this.HERO.isQuit()){
			sysClear();
			printLetterByLetter(Script.YOU_WIN, Script.DEFAULT_NARRATOR);
			sleep(10000);

			//CREDITS
			sysClear();
			System.out.print(Script.CREDITS);
			sleep(10000);

			//THANKING
			sysClear();
			printLetterByLetter(Script.THANKING_PLAYER, "DEVELOPERS");
			sleep(5000);

			pressAnyKeyToContinue();
			this.HERO.quit(this.HERO.getName());
		}
		//ONLY QUIT
		else {
			this.HERO.quit(this.HERO.getName());
		}
	}

	//Only for a context in the beginning
	public static void openingGame() {
		printLetterByLetter(Script.CONTEXT_01, Script.DEFAULT_NARRATOR);
		pressAnyKeyToContinue();
		sysClear();
		printLetterByLetter(Script.CONTEXT_02, Script.DEFAULT_NARRATOR);
		sleep(2000);
		printLetterByLetter(Script.NAZI_BLAHBLAH, "Nazi Researcher");
		sleep(2000);
		printLetterByLetter(Script.OTHER_NAZI_BLAHBLAH, "Other Nazi Researcher");
		sleep(2000);
		printLetterByLetter(Script.NAZI_JOKE, "Nazi's Funny Guy");
		sleep(2000);
		printLetterByLetter(Script.NAZI_LAUGH, "All the Nazis");
		sleep(3000);
		printLetterByLetter(Script.CONTEXT_03, Script.DEFAULT_NARRATOR);
		pressAnyKeyToContinue();
		sysClear();
		printLetterByLetter(Script.CONTEXT_04, Script.DEFAULT_NARRATOR);
		sysClear();
	}


	// === DISPLAY ===

	//Display the environment
	public void displayEnvironment() {
		System.out.println("\n" + this.HERO.getPlace().toString());
	}

	//Display effect for dialogs
	public static void printLetterByLetter(String s, String whom) {
		System.out.print("\n" + whom.toUpperCase() + " : ");															//Display the character who talks
		System.out.println(s);
	}

	//To clean the prompt
	public static void sysClear(){
		try
		{
			//On PowerShell
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			//On Bash
			//new ProcessBuilder("cmd", "/c", "clear").inheritIO().start().waitFor();
		}
		catch (final Exception e)
		{
			System.out.println("Error");
		}
		System.out.flush();
	}

	public static void pressAnyKeyToContinue() {
		System.out.print("\nPress Enter key to continue...");
		Scanner scanner = new Scanner(System.in);
		try
		{
			scanner.nextLine();
		}
		catch(Exception ignored){}
	}

	public static void cmdPush(int howmuch) {
		for (int i = 0; i < howmuch; i++) {
			System.out.println();
		}
	}

	//Just cause I don't want to throw exception anytime
	public static void sleep(int time){
		try{
			Thread.sleep(time);
		}
		catch (Exception e){
			System.out.println("Error");
		}
	}


	// === MAIN ===

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game.sysClear();
		System.out.println(Script.WELCOME_MESSAGE);
		System.out.print("\n\nPlease, choose your name : ");
		Game g = new Game(sc.nextLine());
		Game.printLetterByLetter("Ok so you choose \"HOUGA BOUGA\" as gamer tag. You agreed ? \n\n1 - Yes for sure\t2 - Yes I've no other choice\n\n", Script.DEFAULT_NARRATOR);
		System.out.print("\nAnswer : ");
		sc.nextLine();
		Game.printLetterByLetter("As you want HOUGA BOUGA !\n", Script.DEFAULT_NARRATOR);
		Game.pressAnyKeyToContinue();
		g.Play();
	}

}