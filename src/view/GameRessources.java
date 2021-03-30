package view;


import javafx.scene.image.Image;
import model.characters.Animal;
import model.characters.Enemy;
import model.characters.Hero;
import model.characters.Monkey;
import model.doors.*;
import model.objects.*;
import model.others.Game;
import model.others.Place;
import model.others.Script;
import view.MyHeroImageView;
import view.MyImageView;
import view.MyPlace;

import java.util.ArrayList;

public class GameRessources {

    // HERO CREATION
    public final MyHeroImageView heroIm = new MyHeroImageView(Game.hero,ImageRessources.imageCavemanFront,4,4);


    // Animals
    public MyImageView catIm = new MyImageView(Game.cat, "assets/images/characters/cat.gif", 2, 2, 45);
    public MyImageView monkeyIm = new MyImageView(Game.monkey, "assets/images/characters/cat.gif", 2, 2, 45);
    public MyImageView mouseIm = new MyImageView(Game.mouse, "assets/images/characters/cat.gif", 2, 2, 45);




    // Objects
    public MyImageView naziPosteIm = new MyImageView(Game.naziPoster, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView clubIm = new MyImageView(Game.club, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView potionIm =new MyImageView(Game.potion, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView bananaIm = new MyImageView(Game.banana, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView stickIm = new MyImageView(Game.stick, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView flintIm = new MyImageView(Game.flint, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView fuseIm = new MyImageView(Game.fuse, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView catBIm = new MyImageView(Game.catB, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView mouseBIm =new MyImageView(Game.mouseB, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView monkeyBIm = new MyImageView(Game.monkeyB, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView k1Im = new MyImageView(Game.k1, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView k2Im = new MyImageView(Game.k2, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView electricityMeterIm = new MyImageView(Game.electricityMeter, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    //public final Locker locker = new Locker(Script.DEFAULT_LOCKER_NAME, Script.DEFAULT_LOCKER_NAME,hero);
    public final MyImageView naziPosterIm =new MyImageView(Game.naziPoster, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView sexyPosterIm = new MyImageView(Game.sexyPoster, "assets/images/objects/NazisPoster.png", 3, 0, 40);
    public final MyImageView walkmanIm = new MyImageView(Game.walkman, "assets/images/objects/NazisPoster.png", 3, 0, 40);




    // Doors
    public final MyImageView secretPassageIm = new MyImageView(Game.secretPassage, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView experimToCondaIm = new MyImageView(Game.experimAndConda, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView condaToExperimIm = new MyImageView(Game.experimAndConda, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView changToEntryIm = new MyImageView(Game.changAndEntry, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView meetToArchIm = new MyImageView(Game.changAndEntry, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView archTomeetIm = new MyImageView(Game.meetAndArch, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView transfToMeetIm = new MyImageView(Game.transfAndMeet, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView meetToTransfIm = new MyImageView(Game.transfAndMeet, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView decontToExitIm = new MyImageView(Game.decontAndExit, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView animToTransfIm = new MyImageView(Game.animAndTransf, "assets/images/place/BasicDoor.png", 5, 0);
    public final MyImageView transfToanimIm = new MyImageView(Game.animAndTransf, "assets/images/place/BasicDoor.png", 3, 8);
    public final MyImageView experimToReservIm = new MyImageView(Game.experimAndReserv, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView reservToExperimIm = new MyImageView(Game.experimAndReserv, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView experimToDirtyIm = new MyImageView(Game.experimAndDirty, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView dirtyToExperimIm = new MyImageView(Game.experimAndDirty, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView transfToChangIm = new MyImageView(Game.transfAndChang, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView changToTransfIm = new MyImageView(Game.transfAndChang, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView transfToExperIm = new MyImageView(Game.transfAndExper, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView experToTransfIm = new MyImageView(Game.transfAndExper, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView experimToMorgIm = new MyImageView(Game.experimAndMort, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView morgToExperimIm = new MyImageView(Game.experimAndMort, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView condaToDesertIm = new MyImageView(Game.condaAndDesert, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView desertToCondaIm = new MyImageView(Game.condaAndDesert, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView experimToColdIm = new MyImageView(Game.experimAndCold, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView coldToExperimIm = new MyImageView(Game.experimAndCold, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView coldToGarbIm = new MyImageView(Game.coldAndGarb, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView garbToColdIm = new MyImageView(Game.coldAndGarb, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView dirtToDeconIm = new MyImageView(Game.dirtAndDecon, "assets/images/place/BasicDoor.png", 3, 0);
    public final MyImageView deconToDirtIm =new MyImageView(Game.dirtAndDecon, "assets/images/place/BasicDoor.png", 3, 0);



    private ArrayList<MyImageView> animalRoomImList = new ArrayList<>();
    private ArrayList<MyImageView> transferRoomImList1 = new ArrayList<>(); //LEFT
    private ArrayList<MyImageView> transferRoomImList2 = new ArrayList<>(); //RIGHT
    private ArrayList<MyImageView> changingRoomImList = new ArrayList<>();
    private ArrayList<MyImageView> entryImList = new ArrayList<>();
    private ArrayList<MyImageView> meetingRoomImList = new ArrayList<>();
    private ArrayList<MyImageView> archivesRoomImList = new ArrayList<>();
    private ArrayList<MyImageView> experimentsRoomImList1 = new ArrayList<>(); //TOP LEFT
    private ArrayList<MyImageView> experimentsRoomImList2 = new ArrayList<>(); //TOP RIGHT
    private ArrayList<MyImageView> experimentsRoomImList3 = new ArrayList<>(); //BOTTOM LEFT
    private ArrayList<MyImageView> experimentsRoomImList4 = new ArrayList<>(); //BOTTOM RIGHT
    private ArrayList<MyImageView> morgueImList = new ArrayList<>();
    private ArrayList<MyImageView> condamnedSASImList = new ArrayList<>();
    private ArrayList<MyImageView> desertedRoomImList = new ArrayList<>();
    private ArrayList<MyImageView> productsReserveImList = new ArrayList<>();
    private ArrayList<MyImageView> garbageRoomImList = new ArrayList<>();
    private ArrayList<MyImageView> coldRoomImList = new ArrayList<>();
    private ArrayList<MyImageView> dirtyChangingRoomImList = new ArrayList<>();
    private ArrayList<MyImageView> decontaminationRoomImList = new ArrayList<>();
    private ArrayList<MyImageView> exitImList = new ArrayList<>();


    public final MyPlace myAnimalRoom = new MyPlace(Game.animalRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,animalRoomImList);
    public final MyPlace  myTransferRoom1 =new MyPlace(Game.transferRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,transferRoomImList1); //LEFT
    public final MyPlace  myTransferRoom2 = new MyPlace(Game.transferRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,transferRoomImList2); //RIGHT
    public final MyPlace  myChangingRoom= new MyPlace(Game.changingRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,changingRoomImList);
    public final MyPlace  myEntryIm= new MyPlace(Game.entry, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,entryImList);
    public final MyPlace  myMeetingRoom = new MyPlace(Game.meetingRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,meetingRoomImList);
    public final MyPlace  myArchivesRoom = new MyPlace(Game.archivesRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,archivesRoomImList);
    public final MyPlace  myExperimentsRoom1 = new MyPlace(Game.experimentsRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,experimentsRoomImList1); //TOP LEFT
    public final MyPlace  myExperimentsRoom2 = new MyPlace(Game.experimentsRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,experimentsRoomImList2); //TOP RIGHT
    public final MyPlace  myExperimentsRoom3 = new MyPlace(Game.experimentsRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,experimentsRoomImList3); //BOTTOM LEFT
    public final MyPlace  myExperimentsRoom4 = new MyPlace(Game.experimentsRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,experimentsRoomImList4); //BOTTOM RIGHT
    public final MyPlace  myMorgue = new MyPlace(Game.morgue, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,morgueImList);
    public final MyPlace  myCondamnedSAS = new MyPlace(Game.condamnedSAS, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,condamnedSASImList);
    public final MyPlace  myDesertedRoom = new MyPlace(Game.desertedRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,desertedRoomImList);
    public final MyPlace  myProductsReserve = new MyPlace(Game.productsReserve, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,productsReserveImList);
    public final MyPlace  myGarbageRoom = new MyPlace(Game.garbageRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,garbageRoomImList);
    public final MyPlace  myColdRoom = new MyPlace(Game.coldRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,coldRoomImList);
    public final MyPlace  myDirtyChangingRoom = new MyPlace(Game.dirtyChangingRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,dirtyChangingRoomImList);
    public final MyPlace  myDecontaminationRoom =new MyPlace(Game.decontaminationRoom, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,decontaminationRoomImList);
    public final MyPlace  myExit = new MyPlace(Game.exit, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8,exitImList);






    public GameRessources(){

        animalRoomImList.add(catIm);
        animalRoomImList.add(naziPosteIm);
        animalRoomImList.add(animToTransfIm);

        transferRoomImList1.add(transfToanimIm);

    }
}
