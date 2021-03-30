package model.doors;

import model.characters.*;
import model.others.*;

import java.util.*;

public class SecretCodeDoor extends LockableDoor {


	// ***** ATTRIBUTES *****

	private final String CODE;


	// ***** CONSTRUCTORS *****

	public SecretCodeDoor(String code, Place dest) {
		super(dest);
		this.CODE = code;
		System.out.println("SecretDoor " + dest.getName() + "initialized");
	}

	public SecretCodeDoor(String code, Place p1, Place p2) {
		super(p1, p2);
		this.CODE = code;
	}


	// ***** METHODS *****


	// === SETTER ===

	@Override
	public void unlock(){}

	public void unlock(String code) {
		Random rand = new Random();
		int tmp = rand.nextInt(10 + 1);
	
		if (this.CODE.equalsIgnoreCase(code)) {
			super.unlock();
			this.open();
			if(tmp % 2 == 0){
				System.out.print("\nVALID CODE. The door is now unlocked. Good Boy !\n");
			}
			else{
				System.out.print("\nVALID CODE. Good Gosh ! You're smarter than I thought ! You unlocked the door !\n");
			}
		}
		else {
			if(tmp % 2 == 0){
				System.out.print("\nERROR CODE. Hey buddy you won't be able to force the code. Even the Nazis are certainly smarter than you...\n");
			}
			else{
				System.out.print("\nERROR CODE. Hmmm, maybe you're not a good writer...\n");
			}
		}
	}


	// === OTHER ===

	@Override
	public void cross(Hero hero, String s) {
		s = s.toLowerCase();
		if (!this.isUnlock()) {
			Scanner sc = new Scanner(System.in);    //New scanner
			System.out.print("\nCODE : ");
			String code = sc.nextLine();            //The user enter the code

			this.unlock(code);
		}

		if (this.isUnlock()) {
			hero.setPlace(this.getPlaces().get(s));
		}
	}

}
