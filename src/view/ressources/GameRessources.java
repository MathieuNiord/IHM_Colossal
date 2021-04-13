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
import static view.ressources.ImageRessources.*;
public class GameRessources {

    // HERO CREATION
    public final static MyHeroImageView heroIm = new MyHeroImageView(Game.hero, ImageRessources.IMAGE_CAVEMAN_FRONT,4,4);


    // Animals
    public final static MyImageView catIm = new MyImageView(Game.cat, IMAGE_CAT, 2, 6, 45);
    public final static MyImageView monkeyIm = new MyImageView(Game.monkey, IMAGE_MONKEY, 4, 2, 45);
    public final static MyImageView mouseIm = new MyImageView(Game.mouse, IMAGE_MOUSE, 7, 6, 45);




    // Objects
    public final static MyImageView naziPosterIm = new MyImageView(Game.naziPoster, IMAGE_NAZIS_POSTER, 3, 0, 40);
    public final static MyImageView clubIm = new MyImageView(Game.club, IMAGE_HEART, 3, 5, 40);
    public final static MyImageView potionIm =new MyImageView(Game.potion, IMAGE_HEART, 4, 4, 40);
    public final static MyImageView bananaIm = new MyImageView(Game.banana, IMAGE_BANANA, 6, 7, 40);
    public final static MyImageView stickIm = new MyImageView(Game.stick, IMAGE_STICK, 3, 1, 40);
    public final static MyImageView flintIm = new MyImageView(Game.flint, IMAGE_FLINT, 7, 4, 40);
    public final static MyImageView fuseIm = new MyImageView(Game.fuse, IMAGE_HEART, 0, 0, 40);
    public final static MyImageView catBIm = new MyImageView(Game.catB, IMAGE_BESCHERELLE, 3, 7, 40);
    public final static MyImageView mouseBIm =new MyImageView(Game.mouseB, IMAGE_BESCHERELLE, 6, 1, 40);
    public final static MyImageView monkeyBIm = new MyImageView(Game.monkeyB, IMAGE_BESCHERELLE, 5, 1, 40);
    public final static MyImageView k1Im = new MyImageView(Game.k1, IMAGE_HEART, 0, 0, 40);
    public final static MyImageView k2Im = new MyImageView(Game.k2, IMAGE_HEART, 0, 0, 40);
    public final static MyImageView electricityMeterIm = new MyImageView(Game.electricityMeter, IMAGE_HEART, 7, 1, 40);
    public final static MyImageView lockerIm = new MyImageView(Game.locker, IMAGE_HEART, 7, 3, 40);
    public final static MyImageView sexyPosterIm = new MyImageView(Game.sexyPoster, IMAGE_HEART, 2, 0, 40);
    public final static MyImageView walkmanIm = new MyImageView(Game.walkman, IMAGE_HEART, 0, 0, 40);
    public final static MyImageView firedstickIm = new MyImageView(Game.firedStick, IMAGE_TORCH, 0, 0, 40);




    // Doors
    public final static MyImageView secretPassageIm = new MyImageView(Game.secretPassage, IMAGE_DOOR_UP, 4, 8);
    public final static MyImageView experimToCondaIm = new MyImageView(Game.experimAndConda, IMAGE_DOOR_UP, 6, 0);
    public final static MyImageView condaToExperimIm = new MyImageView(Game.experimAndConda, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView changToEntryIm = new MyImageView(Game.changAndEntry, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView meetToArchIm = new MyImageView(Game.changAndEntry, IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView archTomeetIm = new MyImageView(Game.meetAndArch, IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView transfToMeetIm = new MyImageView(Game.transfAndMeet, IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView meetToTransfIm = new MyImageView(Game.transfAndMeet, IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView decontToExitIm = new MyImageView(Game.decontAndExit, IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView animToTransfIm = new MyImageView(Game.animAndTransf, IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView transfToanimIm = new MyImageView(Game.animAndTransf, IMAGE_DOOR_DOWN, 2, 8);
    public final static MyImageView experimToReservIm = new MyImageView(Game.experimAndReserv, IMAGE_DOOR_UP, 2, 0);
    public final static MyImageView reservToExperimIm = new MyImageView(Game.experimAndReserv, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView experimToDirtyIm = new MyImageView(Game.experimAndDirty, IMAGE_DOOR_LEFT, 0, 6);
    public final static MyImageView dirtyToExperimIm = new MyImageView(Game.experimAndDirty, IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView transfToChangIm = new MyImageView(Game.transfAndChang, IMAGE_DOOR_DOWN, 6, 8);
    public final static MyImageView changToTransfIm = new MyImageView(Game.transfAndChang, IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView transfToExperIm = new MyImageView(Game.transfAndExper, IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView experToTransfIm = new MyImageView(Game.transfAndExper, IMAGE_DOOR_DOWN, 2, 8);
    public final static MyImageView experimToMorgIm = new MyImageView(Game.experimAndMort, IMAGE_DOOR_RIGHT, 8, 2);
    public final static MyImageView morgToExperimIm = new MyImageView(Game.experimAndMort, IMAGE_DOOR_UP, 0, 4);
    public final static MyImageView condaToDesertIm = new MyImageView(Game.condaAndDesert, IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView desertToCondaIm = new MyImageView(Game.condaAndDesert, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView experimToColdIm = new MyImageView(Game.experimAndCold, IMAGE_DOOR_LEFT, 0, 2);
    public final static MyImageView coldToExperimIm = new MyImageView(Game.experimAndCold, IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView coldToGarbIm = new MyImageView(Game.coldAndGarb, IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView garbToColdIm = new MyImageView(Game.coldAndGarb, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView dirtToDeconIm = new MyImageView(Game.dirtAndDecon, IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView deconToDirtIm =new MyImageView(Game.dirtAndDecon, IMAGE_DOOR_RIGHT, 8, 4);



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

    public final static Integer[][] animal_room_map_positions = {{2,5}};
    public final static Integer[][] transfer_room_map_positions = {{2,4}, {3,4}};
    public final static Integer[][] changing_room_map_positions = {{3,5}};
    public final static Integer[][] entry_room_map_positions = {{3,6}};
    public final static Integer[][] meeting_room_map_positions = {{4,4}};
    public final static Integer[][] archives_room_map_positions = {{5,4}};
    public final static Integer[][] experiments_room_map_positions = {{3, 2}, {4, 2}, {3, 3}, {4, 3}};
    public final static Integer[][] morgue_map_positions = {{5,2}};
    public final static Integer[][] condamned_sas_map_positions = {{4,1}};
    public final static Integer[][] deserted_room_map_positions = {{4,0}};
    public final static Integer[][] products_reserve_map_positions = {{3,1}};
    public final static Integer[][] garbage_room_map_positions = {{2,1}};
    public final static Integer[][] cold_room_map_positions = {{2,2}};
    public final static Integer[][] dirty_changing_room_map_positions = {{2,3}};
    public final static Integer[][] decontamination_room_map_positions = {{1,3}};
    public final static Integer[][] exit_map_positions = {{0,3}};

    public final static MyPlace myAnimalRoom = new MyPlace(Game.animalRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, animalRoomImList, animal_room_map_positions);
    public final static MyPlace  myTransferRoom =new MyPlace(Game.transferRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, transferRoomImList, transfer_room_map_positions); //LEFT
    public final static MyPlace  myChangingRoom= new MyPlace(Game.changingRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, changingRoomImList, changing_room_map_positions);
    public final static MyPlace  myEntryIm= new MyPlace(Game.entry, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, entryImList, entry_room_map_positions);
    public final static MyPlace  myMeetingRoom = new MyPlace(Game.meetingRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, meetingRoomImList, meeting_room_map_positions);
    public final static MyPlace  myArchivesRoom = new MyPlace(Game.archivesRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, archivesRoomImList, archives_room_map_positions);
    public final static MyPlace  myExperimentsRoom = new MyPlace(Game.experimentsRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, experimentsRoomImList, experiments_room_map_positions);
    public final static MyPlace  myMorgue = new MyPlace(Game.morgue, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, morgueImList, morgue_map_positions);
    public final static MyPlace  myCondamnedSAS = new MyPlace(Game.condamnedSAS, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, condamnedSASImList, condamned_sas_map_positions);
    public final static MyPlace  myDesertedRoom = new MyPlace(Game.desertedRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, desertedRoomImList, deserted_room_map_positions);
    public final static MyPlace  myProductsReserve = new MyPlace(Game.productsReserve, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, productsReserveImList, products_reserve_map_positions);
    public final static MyPlace  myGarbageRoom = new MyPlace(Game.garbageRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, garbageRoomImList, garbage_room_map_positions);
    public final static MyPlace  myColdRoom = new MyPlace(Game.coldRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, coldRoomImList, cold_room_map_positions);
    public final static MyPlace  myDirtyChangingRoom = new MyPlace(Game.dirtyChangingRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, dirtyChangingRoomImList, dirty_changing_room_map_positions);
    public final static MyPlace  myDecontaminationRoom =new MyPlace(Game.decontaminationRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, decontaminationRoomImList, decontamination_room_map_positions);
    public final static MyPlace  myExit = new MyPlace(Game.exit, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, exitImList, exit_map_positions);


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
