package model_bis;


import javafx.scene.image.Image;
import model.characters.Animal;
import model.characters.Enemy;
import model.characters.Hero;
import model.characters.Monkey;
import model.doors.*;
import model.objects.*;
import model.others.Place;
import model.others.Script;

import java.util.ArrayList;

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
    public final Door secretPassage = new BurnableDoor(archivesRoom);
    public final Door experimToConda = new InfectedRoomDoor(condamnedSAS);
    public final Door condaToExperim = new Door(experimentsRoom);
    public final Door changToEntry = new CondemnedDoor(entry);
    public final Door meetToArch = new DestructableDoor(archivesRoom);
    public final Door archTomeet = new DestructableDoor(meetingRoom);
    public final Door transfToMeet = new LockedKeyDoor(1, meetingRoom);
    public final Door meetToTransf = new LockedKeyDoor(1, transferRoom);
    public final Door decontToExit = new LockedKeyDoor(2, exit);
    public final Door animToTransf = new SecretCodeDoor("IT", transferRoom);
    public final Door transfToanim = new Door(animalRoom);
    public final Door experimToReserv = new SecretCodeDoor("S A GREAT",productsReserve);
    public final Door reservToExperim = new Door(experimentsRoom);
    public final Door experimToDirty = new SecretCodeDoor("GAME",dirtyChangingRoom);
    public final Door dirtyToExperim = new Door( experimentsRoom);
    public final Door transfToChang = new Door(changingRoom);
    public final Door changToTransf = new Door(transferRoom);
    public final Door transfToExper = new Door(experimentsRoom);
    public final Door experToTransf = new Door(transferRoom);
    public final Door experimToMorg = new Door(morgue);
    public final Door morgToExperim = new Door(experimentsRoom);
    public final Door condaToDesert = new Door(desertedRoom);
    public final Door desertToConda = new Door(condamnedSAS);
    public final Door experimToCold = new Door(coldRoom);
    public final Door coldToExperim = new Door(experimentsRoom);
    public final Door coldToGarb = new Door(garbageRoom);
    public final Door garbToCold = new Door(coldRoom);
    public final Door dirtToDecon = new Door(decontaminationRoom);
    public final Door deconToDirt = new Door(dirtyChangingRoom);


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
    //public final Locker locker = new Locker(Script.DEFAULT_LOCKER_NAME, Script.DEFAULT_LOCKER_NAME,hero);
    public final NaziPoster naziPoster = new NaziPoster(Script.DEFAULT_NAZIPOSTER_NAME, Script.NAZI_POSTER);
    public final SexyPoster sexyPoster = new SexyPoster(Script.DEFAULT_SEXYPOSTER_NAME, Script.SEXY_POSTER);
    public final Walkman walkman = new Walkman(Script.DEFAULT_WALKMAN_NAME, Script.DEFAULT_WALKMAN_NAME);

    public final Enemy accountGuy = new Enemy("account guy", 45, 1, k1,
    Script.ACCOUNTGUY_DEFAULT, Script.ACCOUNTGUY_ATTACK, Script.ACCOUNTGUY_DEFEAT,Script.ACCOUNTGUY_DESCRIPT);

    public final Enemy zombieNazi = new Enemy("zombie nazi", 60, 4, fuse,
            Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK, Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);

    public final Enemy superNazi = new Enemy("super-nazi", 100, 8, k2,
            Script.BOSS_DEFAULT, Script.BOSS_ATTACCK, Script.BOSS_DEFEAT,Script.BOSS_DESCRIPT);

    //TEST MYPLACE =================================================================================================================
    private final MyImageView enemy = new MyImageView(zombieNazi, "assets/images/characters/ZombiNazi.png", 4, 4);

    private ArrayList<MyImageView> objectsTest = new ArrayList<>();

    public final MyPlace TEST = new MyPlace(
            "Test Room",
            false, true,
            new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, objectsTest);
    //FIN TEST =================================================================================================================

    // HERO CREATION
    public final Hero hero = new Hero("hero", desertedRoom);
    //public final MyHeroImageView heroTEST = new MyHeroImageView(hero, "assets/images/characters/CavemanFix.png", TEST);

    public GameRessources(){
        // DOORS ADDING TO ROOMS
        animalRoom.addDoor(animToTransf, "up");
        changingRoom.addDoor(changToTransf, "up");
        changingRoom.addDoor(changToEntry, "down");
        transferRoom.addDoor(transfToanim, "down");
        transferRoom.addDoor(transfToChang, "down");
        transferRoom.addDoor(transfToMeet, "right");
        transferRoom.addDoor(transfToExper, "up");
        meetingRoom.addDoor(meetToTransf, "left");
        meetingRoom.addDoor(meetToArch, "right");
        archivesRoom.addDoor(archTomeet, "left");
        experimentsRoom.addDoor(experToTransf, "down");
        experimentsRoom.addDoor(experimToMorg, "right");
        experimentsRoom.addDoor(experimToConda, "up");
        experimentsRoom.addDoor(experimToReserv, "up");
        experimentsRoom.addDoor(experimToCold, "left");
        experimentsRoom.addDoor(experimToDirty, "left");
        morgue.addDoor(morgToExperim, "left");
        morgue.addDoor(secretPassage, "down");
        condamnedSAS.addDoor(condaToExperim, "down");
        condamnedSAS.addDoor(condaToDesert, "up");
        desertedRoom.addDoor(desertToConda, "down");
        productsReserve.addDoor(reservToExperim, "down");
        coldRoom.addDoor(coldToExperim, "right");
        coldRoom.addDoor(coldToGarb, "up");
        garbageRoom.addDoor(garbToCold, "down");
        dirtyChangingRoom.addDoor(dirtyToExperim, "right");
        dirtyChangingRoom.addDoor(dirtToDecon, "left");
        decontaminationRoom.addDoor(deconToDirt, "right");
        decontaminationRoom.addDoor(decontToExit, "left");


        // ANIMALS ADDING TO ROOMS
        animalRoom.addAnimal(cat);
        experimentsRoom.addAnimal(monkey);
        experimentsRoom.addAnimal(mouse);


        // OBJECTS ADDING TO ROOMS
        animalRoom.addObject(catB);
        transferRoom.addObject(flint);
        transferRoom.addObject(electricityMeter);
        changingRoom.addObject(sexyPoster);
        //changingRoom.addObject(locker);
        //locker.addObj(walkman);
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
        desertedRoom.addAndCreateEnemy("zombie nazi", 60, 4, fuse,
                Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK, Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);
        //decontaminationRoom.addAndCreateEnemy(superNazi);

        //TEST
        //objectsTest.add(enemy);
    }
}
