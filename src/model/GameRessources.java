package model;


import imageView.MyImageView;
import model.characters.Animal;
import model.characters.Enemy;
import model.characters.Hero;
import model.characters.Monkey;
import model.doors.*;
import model.objects.*;
import model.others.Place;
import model.others.Script;

public class GameRessources {


        // ROOMS CREATION
    public final Place animalRoom = new Place("animal room", false, true);
    public final Place transferRoom = new Place("transfer room", false, true);
    public final Place changingRoom = new Place("changing room", false, true);
    public final Place entry = new Place("entry", false, true);
    public final Place meetingRoom = new Place("meeting room", false, true);
    public final Place archivesRoom = new Place("archives room", false, true);
    public final Place experimentsRoom = new Place("experiments room", false, true);
    public final Place morgue = new Place("morgue", false, true); // on éclaire la pièce ?
    public final Place condamnedSAS = new Place("condamned sas", true, true);
    public final Place desertedRoom = new Place("deserted room", false, true);
    public final Place productsReserve = new Place("products reserve", false, true);
    public final Place garbageRoom = new Place("garbage room", false, true);
    public final Place coldRoom = new Place("cold room", false, false);
    public final Place dirtyChangingRoom = new Place("dirty changingroom", false, true); // est ce qu'on pourrait pas l'enlever ?
    public final Place decontaminationRoom = new Place("decontamination room", false, true);
    public final Place exit = new Place("exit", false, true);


        // DOORS CREATION
    public final Door secretPassage = new BurnableDoor(archivesRoom, null);
    public final Door experimAndConda = new InfectedRoomDoor(experimentsRoom, condamnedSAS);
    public final Door changAndEntry = new CondemnedDoor(changingRoom, entry);
    public final Door meetAndArch = new DestructableDoor(meetingRoom, archivesRoom);
    public final Door transfAndMeet = new LockedKeyDoor(1, transferRoom, meetingRoom);
    public final Door decontAndExit = new LockedKeyDoor(2, decontaminationRoom, exit);
    public final Door animAndTransf = new SecretCodeDoor("IT", animalRoom, transferRoom);
    public final Door experimAndReserv = new SecretCodeDoor("S A GREAT", experimentsRoom, productsReserve);
    public final Door experimAndDirty = new SecretCodeDoor("GAME", experimentsRoom, dirtyChangingRoom);
    public final Door transfAndChang = new Door(transferRoom, changingRoom);
    public final Door transfAndExper = new Door(transferRoom, experimentsRoom);
    public final Door experimAndMort = new Door(experimentsRoom, morgue);
    public final Door condaAndDesert = new Door(condamnedSAS, desertedRoom);
    public final Door experimAndCold = new Door(experimentsRoom, coldRoom);
    public final Door coldAndGarb = new Door(coldRoom, garbageRoom);
    public final Door dirtAndDecon = new Door(dirtyChangingRoom, decontaminationRoom);


    // HERO CREATION
    public final Hero hero = new Hero("hero",animalRoom);


    // ANIMALS CREATION
    public final Animal cat = new Animal("cat",1,Script.CAT_TEXT01,Script.CAT_TEXT02,Script.CAT_DESCRIPT);
    public final Animal mouse = new Animal("mouse",2,Script.MOUSE_TEXT01,Script.MOUSE_TEXT02,Script.MOUSE_DESCRIPT);
    public final Animal monkey = new Monkey("monkey",3,Script.MONKEY_TEXT01,Script.MONKEY_TEXT02,Script.MONKEY_TEXT03,Script.MONKEY_DESCRIPT);


    // OBJECTS CREATION
    public final Weapon club = new Weapon(Script.DEFAULT_CLUB_NAME, Script.CLUB_DESCRIPT);
    public final Potion potion = new Potion(Script.DEFAULT_POTION_NAME, Script.POTION_DESCRIPT);
    public final Banana banana = new Banana(Script.DEFAULT_BANANA_NAME, Script.BANANA_DESCRIPT);
    public final Stick stick = new Stick(Script.DEFAULT_STICK_NAME, Script.STICK_DESCRIPT);
    public final Flint flint = new Flint(Script.DEFAULT_FLINT_NAME, Script.FLINT_DESCRIPT);
    public final Fuse fuse = new Fuse(Script.DEFAULT_FUSE_NAME, Script.FUSE_DESCRIPT);
    public final Bescherelle catB = new Bescherelle(Script.DEFAULT_BESCHERELLE_NAME, Script.BESCH_DESCRIPT);
    public final Bescherelle mouseB = new Bescherelle(Script.DEFAULT_BESCHERELLE_NAME, Script.MOUSE_DESCRIPT);
    public final Bescherelle monkeyB = new Bescherelle(Script.DEFAULT_BESCHERELLE_NAME, Script.MONKEY_DESCRIPT);
    public final Key k1 = new Key(Script.DEFAULT_KEY1_NAME, Script.KEY_DESCRIPT);
    public final Key k2 = new Key(Script.DEFAULT_KEY2_NAME, Script.KEY_DESCRIPT);
    public final ElectricityMeter electricityMeter = new ElectricityMeter(Script.DEFAULT_ELECTRICMETER_NAME, Script.ELECTRICMETER_DESCRIPT, coldRoom);
    public final Locker locker = new Locker(Script.DEFAULT_LOCKER_NAME, Script.DEFAULT_LOCKER_NAME,hero);
    public final NaziPoster naziPoster = new NaziPoster(Script.DEFAULT_NAZIPOSTER_NAME, Script.NAZI_POSTER);
    public final SexyPoster sexyPoster = new SexyPoster(Script.DEFAULT_SEXYPOSTER_NAME, Script.SEXY_POSTER);
    public final Walkman walkman = new Walkman(Script.DEFAULT_WALKMAN_NAME, Script.DEFAULT_WALKMAN_NAME);

    public final Enemy accountGuy = new Enemy("account guy", 45, 1, k1,
    Script.ACCOUNTGUY_DEFAULT, Script.ACCOUNTGUY_ATTACK, Script.ACCOUNTGUY_DEFEAT,Script.ACCOUNTGUY_DESCRIPT);

    public final Enemy zombieNazi = new Enemy("zombie nazi", 60, 4, fuse,
            Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK, Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);

    public final Enemy superNazi = new Enemy("super-nazi", 100, 8, k2,
            Script.BOSS_DEFAULT, Script.BOSS_ATTACCK, Script.BOSS_DEFEAT,Script.BOSS_DESCRIPT);

    public GameRessources(){
        // DOORS ADDING TO ROOMS
        animalRoom.addDoor(animAndTransf, "up");
        changingRoom.addDoor(transfAndChang, "up");
        changingRoom.addDoor(changAndEntry, "down");
        entry.addDoor(changAndEntry, "up"); // doit on vraiment lui ajouter la porte ?
        transferRoom.addDoor(animAndTransf, "down");
        transferRoom.addDoor(transfAndChang, "down");
        transferRoom.addDoor(transfAndMeet, "right");
        transferRoom.addDoor(transfAndExper, "up");
        meetingRoom.addDoor(transfAndMeet, "left");
        meetingRoom.addDoor(meetAndArch, "right");
        archivesRoom.addDoor(meetAndArch, "left");
        experimentsRoom.addDoor(transfAndExper, "down");
        experimentsRoom.addDoor(experimAndMort, "right");
        experimentsRoom.addDoor(experimAndConda, "up");
        experimentsRoom.addDoor(experimAndReserv, "up");
        experimentsRoom.addDoor(experimAndCold, "left");
        experimentsRoom.addDoor(experimAndDirty, "left");
        morgue.addDoor(experimAndMort, "left");
        morgue.addDoor(secretPassage, "down");
        condamnedSAS.addDoor(experimAndConda, "down");
        condamnedSAS.addDoor(condaAndDesert, "up");
        desertedRoom.addDoor(condaAndDesert, "down");
        productsReserve.addDoor(experimAndReserv, "down");
        coldRoom.addDoor(experimAndCold, "right");
        coldRoom.addDoor(coldAndGarb, "up");
        garbageRoom.addDoor(coldAndGarb, "down");
        dirtyChangingRoom.addDoor(experimAndDirty, "right");
        dirtyChangingRoom.addDoor(dirtAndDecon, "left");
        decontaminationRoom.addDoor(dirtAndDecon, "right");
        decontaminationRoom.addDoor(decontAndExit, "left");
        exit.addDoor(decontAndExit, "right");  // doit on vraiment lui ajouter la porte ?


        // ANIMALS ADDING TO ROOMS
        animalRoom.addAnimal(cat);
        experimentsRoom.addAnimal(monkey);
        experimentsRoom.addAnimal(mouse);


        // OBJECTS ADDING TO ROOMS
        animalRoom.addObject(catB);
        transferRoom.addObject(flint);
        transferRoom.addObject(electricityMeter);
        changingRoom.addObject(sexyPoster);
        changingRoom.addObject(locker);
        locker.addObj(walkman);
        experimentsRoom.addObject(naziPoster);
        coldRoom.addObject(banana);
        garbageRoom.addObject(stick);
        archivesRoom.addObject(club);
        archivesRoom.addObject(mouseB);
        productsReserve.addObject(potion);
        desertedRoom.addObject(monkeyB);
        dirtyChangingRoom.addObject(sexyPoster);

        // ENEMIES ADDING TO ROOMS
        //meetingRoom.addAndCreateEnemy(accountGuy);
        //desertedRoom.addAndCreateEnemy(zombieNazi);
        //decontaminationRoom.addAndCreateEnemy(superNazi);
    }
}
