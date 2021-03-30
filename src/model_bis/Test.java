
package model_bis;



import model.characters.Enemy;
import model.characters.Hero;
import model.doors.*;
import model.others.Place;
import model.others.Script;
import view.MyImageView;

import java.util.ArrayList;

public class Test {


    // ROOMS CREATION
    public final Place animalRoom = new Place("animal room", false, true);
    public final Place transferRoom = new Place("transfer room", false, true);
    /*
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
     */


    // DOORS CREATION
    public final Door animToTransf = new SecretCodeDoor("it", transferRoom);//new SecretCodeDoor("IT", transferRoom);
    public final Door transfToanim = new Door(animalRoom);
    /*
    public final Door secretPassage = new BurnableDoor(archivesRoom);
    public final Door experimToConda = new InfectedRoomDoor(condamnedSAS);
    public final Door condaToExperim = new Door(experimentsRoom);
    public final Door changToEntry = new CondemnedDoor(entry);
    public final Door meetToArch = new DestructableDoor(archivesRoom);
    public final Door archTomeet = new DestructableDoor(meetingRoom);
    public final Door transfToMeet = new LockedKeyDoor(1, meetingRoom);
    public final Door meetToTransf = new LockedKeyDoor(1, transferRoom);
    public final Door decontToExit = new LockedKeyDoor(2, exit);
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
    */

    //TEST MYPLACE =================================================================================================================
    public final Enemy zombieNazi = new Enemy("Nazi Zombie", 60, 4, null,
            Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK, Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);

    private final MyImageView enemy = new MyImageView(zombieNazi, "assets/images/characters/ZombiNazi.png", 4, 4);

    private final ArrayList<MyImageView> objectsTest = new ArrayList<>();

    //FIN TEST =================================================================================================================

    // HERO CREATION
    public final Hero hero = new Hero("hero", animalRoom);

    public Test() {

        // DOORS ADDING TO ROOMS
        animalRoom.addSimpleDoor(animToTransf);
        transferRoom.addSimpleDoor(transfToanim);
        /*changingRoom.addDoor(changToTransf, "up");
        changingRoom.addDoor(changToEntry, "down");
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
        */
    }
}
