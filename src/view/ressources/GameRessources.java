package view.ressources;


import javafx.scene.image.Image;
import model.others.Game;
import model.others.Place;
import view.classes.MyGridPane;
import view.classes.MyHeroImageView;
import view.classes.MyImageView;
import view.classes.MyPlace;

import java.util.ArrayList;
import java.util.HashMap;

public class GameRessources {

    // HERO CREATION
    public final static MyHeroImageView heroIm = new MyHeroImageView(Game.hero, ImageRessources.IMAGE_CAVEMAN_FRONT,4,4);


    // Animals
    public final static MyImageView catIm = new MyImageView(Game.cat, "assets/images/characters/cat.gif", 2, 6, 45);
    public final static MyImageView monkeyIm = new MyImageView(Game.monkey, "assets/images/characters/cat.gif", 4, 2, 45);
    public final static MyImageView mouseIm = new MyImageView(Game.mouse, "assets/images/characters/cat.gif", 7, 6, 45);




    // Objects
    public final static MyImageView naziPosteIm = new MyImageView(Game.naziPoster, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView clubIm = new MyImageView(Game.club, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView potionIm =new MyImageView(Game.potion, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView bananaIm = new MyImageView(Game.banana, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView stickIm = new MyImageView(Game.stick, "assets/images/objects/Stick.png", 3, 0, 40);
    public final static MyImageView flintIm = new MyImageView(Game.flint, "assets/images/objects/Flint.png", 3, 0, 40);
    public final static MyImageView fuseIm = new MyImageView(Game.fuse, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView catBIm = new MyImageView(Game.catB, "assets/images/objects/NazisPoster.png", 3, 7, 40);
    public final static MyImageView mouseBIm =new MyImageView(Game.mouseB, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView monkeyBIm = new MyImageView(Game.monkeyB, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView k1Im = new MyImageView(Game.k1, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView k2Im = new MyImageView(Game.k2, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView electricityMeterIm = new MyImageView(Game.electricityMeter, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView lockerIm = new MyImageView(Game.locker, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView naziPosterIm =new MyImageView(Game.naziPoster, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView sexyPosterIm = new MyImageView(Game.sexyPoster, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView walkmanIm = new MyImageView(Game.walkman, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final static MyImageView firedstickIm = new MyImageView(Game.firedStick, "assets/images/objects/NazisPoster.png", 3, 0, 40);




    // Doors
    public final static MyImageView secretPassageIm = new MyImageView(Game.secretPassage, "assets/images/place/BasicDoor.png", 4, 8);
    public final static MyImageView experimToCondaIm = new MyImageView(Game.experimAndConda, "assets/images/place/BasicDoor.png", 6, 0);
    public final static MyImageView condaToExperimIm = new MyImageView(Game.experimAndConda, "assets/images/place/BasicDoor.png", 4, 8);
    public final static MyImageView changToEntryIm = new MyImageView(Game.changAndEntry, "assets/images/place/BasicDoor.png", 4, 8);
    public final static MyImageView meetToArchIm = new MyImageView(Game.changAndEntry, "assets/images/place/BasicDoor.png", 8, 4);
    public final static MyImageView archTomeetIm = new MyImageView(Game.meetAndArch, "assets/images/place/BasicDoor.png", 0, 4);
    public final static MyImageView transfToMeetIm = new MyImageView(Game.transfAndMeet, "assets/images/place/BasicDoor.png", 8, 4);
    public final static MyImageView meetToTransfIm = new MyImageView(Game.transfAndMeet, "assets/images/place/BasicDoor.png", 0, 4);
    public final static MyImageView decontToExitIm = new MyImageView(Game.decontAndExit, "assets/images/place/BasicDoor.png", 0, 4);
    public final static MyImageView animToTransfIm = new MyImageView(Game.animAndTransf, "assets/images/place/BasicDoor.png", 4, 0);
    public final static MyImageView transfToanimIm = new MyImageView(Game.animAndTransf, "assets/images/place/BasicDoor.png", 2, 8);
    public final static MyImageView experimToReservIm = new MyImageView(Game.experimAndReserv, "assets/images/place/BasicDoor.png", 2, 0);
    public final static MyImageView reservToExperimIm = new MyImageView(Game.experimAndReserv, "assets/images/place/BasicDoor.png", 4, 8);
    public final static MyImageView experimToDirtyIm = new MyImageView(Game.experimAndDirty, "assets/images/place/BasicDoor.png", 0, 6);
    public final static MyImageView dirtyToExperimIm = new MyImageView(Game.experimAndDirty, "assets/images/place/BasicDoor.png", 8, 4);
    public final static MyImageView transfToChangIm = new MyImageView(Game.transfAndChang, "assets/images/place/BasicDoor.png", 6, 8);
    public final static MyImageView changToTransfIm = new MyImageView(Game.transfAndChang, "assets/images/place/BasicDoor.png", 4, 0);
    public final static MyImageView transfToExperIm = new MyImageView(Game.transfAndExper, "assets/images/place/BasicDoor.png", 4, 0);
    public final static MyImageView experToTransfIm = new MyImageView(Game.transfAndExper, "assets/images/place/BasicDoor.png", 2, 8);
    public final static MyImageView experimToMorgIm = new MyImageView(Game.experimAndMort, "assets/images/place/BasicDoor.png", 8, 2);
    public final static MyImageView morgToExperimIm = new MyImageView(Game.experimAndMort, "assets/images/place/BasicDoor.png", 0, 4);
    public final static MyImageView condaToDesertIm = new MyImageView(Game.condaAndDesert, "assets/images/place/BasicDoor.png", 4, 0);
    public final static MyImageView desertToCondaIm = new MyImageView(Game.condaAndDesert, "assets/images/place/BasicDoor.png", 4, 8);
    public final static MyImageView experimToColdIm = new MyImageView(Game.experimAndCold, "assets/images/place/BasicDoor.png", 0, 2);
    public final static MyImageView coldToExperimIm = new MyImageView(Game.experimAndCold, "assets/images/place/BasicDoor.png", 8, 4);
    public final static MyImageView coldToGarbIm = new MyImageView(Game.coldAndGarb, "assets/images/place/BasicDoor.png", 4, 0);
    public final static MyImageView garbToColdIm = new MyImageView(Game.coldAndGarb, "assets/images/place/BasicDoor.png", 4, 8);
    public final static MyImageView dirtToDeconIm = new MyImageView(Game.dirtAndDecon, "assets/images/place/BasicDoor.png", 0, 4);
    public final static MyImageView deconToDirtIm =new MyImageView(Game.dirtAndDecon, "assets/images/place/BasicDoor.png", 8, 4);



    private static ArrayList<MyImageView> animalRoomImList = new ArrayList<>();
    private static ArrayList<MyImageView> transferRoomImList = new ArrayList<>(); //LEFT
    private static ArrayList<MyImageView> changingRoomImList = new ArrayList<>();
    private static ArrayList<MyImageView> entryImList = new ArrayList<>();
    private static ArrayList<MyImageView> meetingRoomImList = new ArrayList<>();
    private static ArrayList<MyImageView> archivesRoomImList = new ArrayList<>();
    private static ArrayList<MyImageView> experimentsRoomImList = new ArrayList<>(); //TOP LEFT
    private static ArrayList<MyImageView> morgueImList = new ArrayList<>();
    private static ArrayList<MyImageView> condamnedSASImList = new ArrayList<>();
    private static ArrayList<MyImageView> desertedRoomImList = new ArrayList<>();
    private static ArrayList<MyImageView> productsReserveImList = new ArrayList<>();
    private static ArrayList<MyImageView> garbageRoomImList = new ArrayList<>();
    private static ArrayList<MyImageView> coldRoomImList = new ArrayList<>();
    private static ArrayList<MyImageView> dirtyChangingRoomImList = new ArrayList<>();
    private static ArrayList<MyImageView> decontaminationRoomImList = new ArrayList<>();
    private static ArrayList<MyImageView> exitImList = new ArrayList<>();


    public final static MyPlace myAnimalRoom = new MyPlace(Game.animalRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,animalRoomImList);
    public final static MyPlace  myTransferRoom =new MyPlace(Game.transferRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,transferRoomImList); //LEFT
    public final static MyPlace  myChangingRoom= new MyPlace(Game.changingRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,changingRoomImList);
    public final static MyPlace  myEntryIm= new MyPlace(Game.entry, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,entryImList);
    public final static MyPlace  myMeetingRoom = new MyPlace(Game.meetingRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,meetingRoomImList);
    public final static MyPlace  myArchivesRoom = new MyPlace(Game.archivesRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,archivesRoomImList);
    public final static MyPlace  myExperimentsRoom = new MyPlace(Game.experimentsRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,experimentsRoomImList);
    public final static MyPlace  myMorgue = new MyPlace(Game.morgue, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,morgueImList);
    public final static MyPlace  myCondamnedSAS = new MyPlace(Game.condamnedSAS, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,condamnedSASImList);
    public final static MyPlace  myDesertedRoom = new MyPlace(Game.desertedRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,desertedRoomImList);
    public final static MyPlace  myProductsReserve = new MyPlace(Game.productsReserve, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,productsReserveImList);
    public final static MyPlace  myGarbageRoom = new MyPlace(Game.garbageRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,garbageRoomImList);
    public final static MyPlace  myColdRoom = new MyPlace(Game.coldRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,coldRoomImList);
    public final static MyPlace  myDirtyChangingRoom = new MyPlace(Game.dirtyChangingRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,dirtyChangingRoomImList);
    public final static MyPlace  myDecontaminationRoom =new MyPlace(Game.decontaminationRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,decontaminationRoomImList);
    public final static MyPlace  myExit = new MyPlace(Game.exit, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,exitImList);


    public final static HashMap<Place,MyPlace> placeToMyPlace = new HashMap<>();

    public GameRessources(){
        // DOORS ADDING TO ROOMS
        animalRoomImList.add(animToTransfIm);
        changingRoomImList.add(changToTransfIm);
        changingRoomImList.add(changToEntryIm);
        transferRoomImList.add(transfToanimIm);
        transferRoomImList.add(transfToChangIm);
        transferRoomImList.add(transfToMeetIm);
        transferRoomImList.add(transfToExperIm);
        meetingRoomImList.add(meetToArchIm);
        meetingRoomImList.add(meetToTransfIm);
        archivesRoomImList.add(archTomeetIm);
        experimentsRoomImList.add(experimToColdIm);
        experimentsRoomImList.add(experimToReservIm);
        experimentsRoomImList.add(experimToCondaIm);
        experimentsRoomImList.add(experimToMorgIm);
        experimentsRoomImList.add(experimToDirtyIm);
        experimentsRoomImList.add(experToTransfIm);
        morgueImList.add(morgToExperimIm);
        morgueImList.add(secretPassageIm);
        condamnedSASImList.add(condaToExperimIm);
        condamnedSASImList.add(condaToDesertIm);
        desertedRoomImList.add(desertToCondaIm);
        productsReserveImList.add(reservToExperimIm);
        coldRoomImList.add(coldToExperimIm);
        coldRoomImList.add(coldToGarbIm);
        garbageRoomImList.add(garbToColdIm);
        dirtyChangingRoomImList.add(dirtToDeconIm);
        dirtyChangingRoomImList.add(dirtyToExperimIm);
        decontaminationRoomImList.add(deconToDirtIm);
        decontaminationRoomImList.add(decontToExitIm);


        // ANIMALS ADDING TO ROOMS
        animalRoomImList.add(catIm);
        experimentsRoomImList.add(monkeyIm);
        experimentsRoomImList.add(mouseIm);


        // OBJECTS ADDING TO ROOMS
        animalRoomImList.add(catBIm);
        transferRoomImList.add(flintIm);
        transferRoomImList.add(electricityMeterIm);
        changingRoomImList.add(sexyPosterIm);
        changingRoomImList.add(lockerIm);
        experimentsRoomImList.add(naziPosterIm);
        coldRoomImList.add(bananaIm);
        garbageRoomImList.add(stickIm);
        archivesRoomImList.add(clubIm);
        archivesRoomImList.add(mouseBIm);
        productsReserveImList.add(potionIm);
        desertedRoomImList.add(monkeyBIm);
        dirtyChangingRoomImList.add(sexyPosterIm);

        placeToMyPlace.put(Game.animalRoom,myAnimalRoom);
        placeToMyPlace.put(Game.transferRoom,myTransferRoom);
        placeToMyPlace.put(Game.transferRoom,myTransferRoom);
        placeToMyPlace.put(Game.changingRoom,myChangingRoom);
        placeToMyPlace.put(Game.meetingRoom,myMeetingRoom);
        placeToMyPlace.put(Game.archivesRoom,myArchivesRoom);
        placeToMyPlace.put(Game.experimentsRoom,myExperimentsRoom);
        placeToMyPlace.put(Game.morgue,myMorgue);
        placeToMyPlace.put(Game.condamnedSAS,myCondamnedSAS);
        placeToMyPlace.put(Game.desertedRoom,myDesertedRoom);
        placeToMyPlace.put(Game.productsReserve,myProductsReserve);
        placeToMyPlace.put(Game.garbageRoom,myGarbageRoom);
        placeToMyPlace.put(Game.coldRoom,myColdRoom);
        placeToMyPlace.put(Game.dirtyChangingRoom,myDirtyChangingRoom);
        placeToMyPlace.put(Game.decontaminationRoom,myDecontaminationRoom);
        placeToMyPlace.put(Game.exit,myExit);

    }
}
