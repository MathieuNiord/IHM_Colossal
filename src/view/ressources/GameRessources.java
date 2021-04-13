package view.ressources;


import javafx.scene.image.Image;
import model.others.Place;
import view.classes.MyHeroImageView;
import view.classes.MyImageView;
import view.classes.MyPlace;

import java.util.ArrayList;
import java.util.HashMap;


import static model.others.Game.*;
import static view.ressources.ImageRessources.*;
public class GameRessources {

    // HERO CREATION
    public final static MyHeroImageView HERO_IM = new MyHeroImageView(HERO, ImageRessources.IMAGE_CAVEMAN_FRONT,4,4);

    // Animals
    public final static MyImageView CAT_IM = new MyImageView(CAT, IMAGE_CAT, 2, 6, 45);
    public final static MyImageView MONKEY_IM = new MyImageView(MONKEY, IMAGE_MONKEY, 4, 2, 45);
    public final static MyImageView MOUSE_IM = new MyImageView(MOUSE, IMAGE_MOUSE, 7, 6, 45);

    // Enemies
    public final static MyImageView ACCOUNT_GUY_IM = new MyImageView(DESERTED_ROOM.getEnemies(), IMAGE_NAZI_ZOMBIE, 2, 6);
    public final static MyImageView NAZI_ZOMBIE_IM = new MyImageView(DESERTED_ROOM.getEnemies(), IMAGE_NAZI_ZOMBIE, 2, 6);
    public final static MyImageView BOSS_IM = new MyImageView(DESERTED_ROOM.getEnemies(), IMAGE_NAZI_ZOMBIE, 2, 6);

    // Objects
    public final static MyImageView NAZI_POSTER_IM = new MyImageView(NAZI_POSTER, IMAGE_NAZIS_POSTER, 3, 0, 40);
    public final static MyImageView CLUB_IM = new MyImageView(CLUB, IMAGE_HEART, 3, 5, 40);
    public final static MyImageView POTION_IM =new MyImageView(POTION, IMAGE_HEART, 4, 4, 40);
    public final static MyImageView BANANA_IM = new MyImageView(BANANA, IMAGE_BANANA, 6, 7, 40);
    public final static MyImageView STICK_IM = new MyImageView(STICK, IMAGE_STICK, 3, 1, 40);
    public final static MyImageView FLINT_IM = new MyImageView(FLINT, IMAGE_FLINT, 7, 4, 40);
    public final static MyImageView FUSE_IM = new MyImageView(FUSE, IMAGE_HEART, 0, 0, 40);
    public final static MyImageView CAT_B_IM = new MyImageView(CAT_B, IMAGE_BESCHERELLE, 3, 7, 40);
    public final static MyImageView MOUSE_B_IM =new MyImageView(MOUSE_B, IMAGE_BESCHERELLE, 6, 1, 40);
    public final static MyImageView MONKEY_B_IM = new MyImageView(MONKEY_B, IMAGE_BESCHERELLE, 5, 1, 40);
    public final static MyImageView K_1_IM = new MyImageView(K_1, IMAGE_HEART, 0, 0, 40);
    public final static MyImageView K_2_IM = new MyImageView(K_2, IMAGE_HEART, 0, 0, 40);
    public final static MyImageView ELECTRICITY_METER_IM = new MyImageView(ELECTRICITY_METER, IMAGE_HEART, 7, 1, 40);
    public final static MyImageView LOCKER_IM = new MyImageView(LOCKER, IMAGE_HEART, 7, 3, 40);
    public final static MyImageView SEXY_POSTER_IM = new MyImageView(SEXY_POSTER, IMAGE_HEART, 2, 0, 40);
    public final static MyImageView WALKMAN_IM = new MyImageView(WALKMAN, IMAGE_HEART, 0, 0, 40);
    public final static MyImageView FIREDSTICK_IM = new MyImageView(FIRED_STICK, IMAGE_TORCH, 0, 0, 40);


    // Doors
    public final static MyImageView SECRET_PASSAGE_IM = new MyImageView(SECRET_PASSAGE, IMAGE_DOOR_UP, 4, 8);
    public final static MyImageView EXPERIM_TO_CONDA_IM = new MyImageView(EXPERIM_AND_CONDA, IMAGE_DOOR_UP, 6, 0);
    public final static MyImageView CONDA_TO_EXPERIM_IM = new MyImageView(EXPERIM_AND_CONDA, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView CHANG_TO_ENTRY_IM = new MyImageView(CHANG_AND_ENTRY, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView MEET_TO_ARCH_IM = new MyImageView(CHANG_AND_ENTRY, IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView ARCH_TOMEET_IM = new MyImageView(MEET_AND_ARCH, IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView TRANSF_TO_MEET_IM = new MyImageView(TRANSF_AND_MEET, IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView MEET_TO_TRANSF_IM = new MyImageView(TRANSF_AND_MEET, IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView DECONT_TO_EXIT_IM = new MyImageView(DECONT_AND_EXIT, IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView ANIM_TO_TRANSF_IM = new MyImageView(ANIM_AND_TRANSF, IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView TRANSF_TOANIM_IM = new MyImageView(ANIM_AND_TRANSF, IMAGE_DOOR_DOWN, 2, 8);
    public final static MyImageView EXPERIM_TO_RESERV_IM = new MyImageView(EXPERIM_AND_RESERV, IMAGE_DOOR_UP, 2, 0);
    public final static MyImageView RESERV_TO_EXPERIM_IM = new MyImageView(EXPERIM_AND_RESERV, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView EXPERIM_TO_DIRTY_IM = new MyImageView(EXPERIM_AND_DIRTY, IMAGE_DOOR_LEFT, 0, 6);
    public final static MyImageView DIRTY_TO_EXPERIM_IM = new MyImageView(EXPERIM_AND_DIRTY, IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView TRANSF_TO_CHANG_IM = new MyImageView(TRANSF_AND_CHANG, IMAGE_DOOR_DOWN, 6, 8);
    public final static MyImageView CHANG_TO_TRANSF_IM = new MyImageView(TRANSF_AND_CHANG, IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView TRANSF_TO_EXPER_IM = new MyImageView(TRANSF_AND_EXPER, IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView EXPER_TO_TRANSF_IM = new MyImageView(TRANSF_AND_EXPER, IMAGE_DOOR_DOWN, 2, 8);
    public final static MyImageView EXPERIM_TO_MORG_IM = new MyImageView(EXPERIM_AND_MORT, IMAGE_DOOR_RIGHT, 8, 2);
    public final static MyImageView MORG_TO_EXPERIM_IM = new MyImageView(EXPERIM_AND_MORT, IMAGE_DOOR_UP, 0, 4);
    public final static MyImageView CONDA_TO_DESERT_IM = new MyImageView(CONDA_AND_DESERT, IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView DESERT_TO_CONDA_IM = new MyImageView(CONDA_AND_DESERT, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView EXPERIM_TO_COLD_IM = new MyImageView(EXPERIM_AND_COLD, IMAGE_DOOR_LEFT, 0, 2);
    public final static MyImageView COLD_TO_EXPERIM_IM = new MyImageView(EXPERIM_AND_COLD, IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView COLD_TO_GARB_IM = new MyImageView(COLD_AND_GARB, IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView GARB_TO_COLD_IM = new MyImageView(COLD_AND_GARB, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView DIRT_TO_DECON_IM = new MyImageView(DIRT_AND_DECON, IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView DECON_TO_DIRT_IM =new MyImageView(DIRT_AND_DECON, IMAGE_DOOR_RIGHT, 8, 4);



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

    public final static Integer[][] ANIMAL_ROOM_MAP_POSITIONS = {{2,5}};
    public final static Integer[][] TRANSFER_ROOM_MAP_POSITIONS = {{2,4}, {3,4}};
    public final static Integer[][] CHANGING_ROOM_MAP_POSITIONS = {{3,5}};
    public final static Integer[][] ENTRY_ROOM_MAP_POSITIONS = {{3,6}};
    public final static Integer[][] MEETING_ROOM_MAP_POSITIONS = {{4,4}};
    public final static Integer[][] ARCHIVES_ROOM_MAP_POSITIONS = {{5,4}};
    public final static Integer[][] EXPERIMENTS_ROOM_MAP_POSITIONS = {{3, 2}, {4, 2}, {3, 3}, {4, 3}};
    public final static Integer[][] MORGUE_MAP_POSITIONS = {{5,2}};
    public final static Integer[][] CONDAMNED_SAS_MAP_POSITIONS = {{4,1}};
    public final static Integer[][] DESERTED_ROOM_MAP_POSITIONS = {{4,0}};
    public final static Integer[][] PRODUCTS_RESERVE_MAP_POSITIONS = {{3,1}};
    public final static Integer[][] GARBAGE_ROOM_MAP_POSITIONS = {{2,1}};
    public final static Integer[][] COLD_ROOM_MAP_POSITIONS = {{2,2}};
    public final static Integer[][] DIRTY_CHANGING_ROOM_MAP_POSITIONS = {{2,3}};
    public final static Integer[][] DECONTAMINATION_ROOM_MAP_POSITIONS = {{1,3}};
    public final static Integer[][] EXIT_MAP_POSITIONS = {{0,3}};

    public final static MyPlace MY_ANIMAL_ROOM = new MyPlace(ANIMAL_ROOM, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, animalRoomImList, ANIMAL_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_TRANSFER_ROOM =new MyPlace(TRANSFER_ROOM, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, transferRoomImList, TRANSFER_ROOM_MAP_POSITIONS); //LEFT
    public final static MyPlace MY_CHANGING_ROOM = new MyPlace(CHANGING_ROOM, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, changingRoomImList, CHANGING_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_ENTRY_IM = new MyPlace(ENTRY, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, entryImList, ENTRY_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_MEETING_ROOM = new MyPlace(MEETING_ROOM, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, meetingRoomImList, MEETING_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_ARCHIVES_ROOM = new MyPlace(ARCHIVES_ROOM, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, archivesRoomImList, ARCHIVES_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_EXPERIMENTS_ROOM = new MyPlace(EXPERIMENTS_ROOM, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, experimentsRoomImList, EXPERIMENTS_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_MORGUE = new MyPlace(MORGUE, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, morgueImList, MORGUE_MAP_POSITIONS);
    public final static MyPlace MY_CONDAMNED_SAS = new MyPlace(CONDAMNED_SAS, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, condamnedSASImList, CONDAMNED_SAS_MAP_POSITIONS);
    public final static MyPlace MY_DESERTED_ROOM = new MyPlace(DESERTED_ROOM, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, desertedRoomImList, DESERTED_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_PRODUCTS_RESERVE = new MyPlace(PRODUCTS_RESERVE, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, productsReserveImList, PRODUCTS_RESERVE_MAP_POSITIONS);
    public final static MyPlace MY_GARBAGE_ROOM = new MyPlace(GARBAGE_ROOM, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, garbageRoomImList, GARBAGE_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_COLD_ROOM = new MyPlace(COLD_ROOM, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, coldRoomImList, COLD_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_DIRTY_CHANGING_ROOM = new MyPlace(DIRTY_CHANGINGROOM, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, dirtyChangingRoomImList, DIRTY_CHANGING_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_DECONTAMINATION_ROOM =new MyPlace(DECONTAMINATION_ROOM, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, decontaminationRoomImList, DECONTAMINATION_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_EXIT = new MyPlace(EXIT, new Image("assets/images/place/floor.png"),
            0, 8, 0, 8, exitImList, EXIT_MAP_POSITIONS);


    public final static HashMap<Place,MyPlace> PLACE_TO_MY_PLACE = new HashMap<>();

    private final GameRessources gameRessources = new GameRessources();

    private GameRessources(){
        // DOORS ADDING TO ROOMS
        animalRoomImList.add(ANIM_TO_TRANSF_IM);
        changingRoomImList.add(CHANG_TO_TRANSF_IM);
        changingRoomImList.add(CHANG_TO_ENTRY_IM);
        transferRoomImList.add(TRANSF_TOANIM_IM);
        transferRoomImList.add(TRANSF_TO_CHANG_IM);
        transferRoomImList.add(TRANSF_TO_MEET_IM);
        transferRoomImList.add(TRANSF_TO_EXPER_IM);
        meetingRoomImList.add(MEET_TO_ARCH_IM);
        meetingRoomImList.add(MEET_TO_TRANSF_IM);
        archivesRoomImList.add(ARCH_TOMEET_IM);
        experimentsRoomImList.add(EXPERIM_TO_COLD_IM);
        experimentsRoomImList.add(EXPERIM_TO_RESERV_IM);
        experimentsRoomImList.add(EXPERIM_TO_CONDA_IM);
        experimentsRoomImList.add(EXPERIM_TO_MORG_IM);
        experimentsRoomImList.add(EXPERIM_TO_DIRTY_IM);
        experimentsRoomImList.add(EXPER_TO_TRANSF_IM);
        morgueImList.add(MORG_TO_EXPERIM_IM);
        morgueImList.add(SECRET_PASSAGE_IM);
        condamnedSASImList.add(CONDA_TO_EXPERIM_IM);
        condamnedSASImList.add(CONDA_TO_DESERT_IM);
        desertedRoomImList.add(DESERT_TO_CONDA_IM);
        productsReserveImList.add(RESERV_TO_EXPERIM_IM);
        coldRoomImList.add(COLD_TO_EXPERIM_IM);
        coldRoomImList.add(COLD_TO_GARB_IM);
        garbageRoomImList.add(GARB_TO_COLD_IM);
        dirtyChangingRoomImList.add(DIRT_TO_DECON_IM);
        dirtyChangingRoomImList.add(DIRTY_TO_EXPERIM_IM);
        decontaminationRoomImList.add(DECON_TO_DIRT_IM);
        decontaminationRoomImList.add(DECONT_TO_EXIT_IM);


        // ANIMALS ADDING TO ROOMS
        animalRoomImList.add(CAT_IM);
        experimentsRoomImList.add(MONKEY_IM);
        experimentsRoomImList.add(MOUSE_IM);


        // OBJECTS ADDING TO ROOMS
        animalRoomImList.add(CAT_B_IM);
        transferRoomImList.add(FLINT_IM);
        transferRoomImList.add(ELECTRICITY_METER_IM);
        changingRoomImList.add(SEXY_POSTER_IM);
        changingRoomImList.add(LOCKER_IM);
        experimentsRoomImList.add(NAZI_POSTER_IM);
        coldRoomImList.add(BANANA_IM);
        garbageRoomImList.add(STICK_IM);
        archivesRoomImList.add(CLUB_IM);
        archivesRoomImList.add(MOUSE_B_IM);
        productsReserveImList.add(POTION_IM);
        desertedRoomImList.add(MONKEY_B_IM);
        dirtyChangingRoomImList.add(SEXY_POSTER_IM);

        // ENEMIES ADDING TO ROOM
        meetingRoomImList.add(ACCOUNT_GUY_IM);
        desertedRoomImList.add(NAZI_ZOMBIE_IM);
        exitImList.add(BOSS_IM);

        PLACE_TO_MY_PLACE.put(ANIMAL_ROOM, MY_ANIMAL_ROOM);
        PLACE_TO_MY_PLACE.put(TRANSFER_ROOM, MY_TRANSFER_ROOM);
        PLACE_TO_MY_PLACE.put(TRANSFER_ROOM, MY_TRANSFER_ROOM);
        PLACE_TO_MY_PLACE.put(CHANGING_ROOM, MY_CHANGING_ROOM);
        PLACE_TO_MY_PLACE.put(MEETING_ROOM, MY_MEETING_ROOM);
        PLACE_TO_MY_PLACE.put(ARCHIVES_ROOM, MY_ARCHIVES_ROOM);
        PLACE_TO_MY_PLACE.put(EXPERIMENTS_ROOM, MY_EXPERIMENTS_ROOM);
        PLACE_TO_MY_PLACE.put(MORGUE, MY_MORGUE);
        PLACE_TO_MY_PLACE.put(CONDAMNED_SAS, MY_CONDAMNED_SAS);
        PLACE_TO_MY_PLACE.put(DESERTED_ROOM, MY_DESERTED_ROOM);
        PLACE_TO_MY_PLACE.put(PRODUCTS_RESERVE, MY_PRODUCTS_RESERVE);
        PLACE_TO_MY_PLACE.put(GARBAGE_ROOM, MY_GARBAGE_ROOM);
        PLACE_TO_MY_PLACE.put(COLD_ROOM, MY_COLD_ROOM);
        PLACE_TO_MY_PLACE.put(DIRTY_CHANGINGROOM, MY_DIRTY_CHANGING_ROOM);
        PLACE_TO_MY_PLACE.put(DECONTAMINATION_ROOM, MY_DECONTAMINATION_ROOM);
        PLACE_TO_MY_PLACE.put(EXIT, MY_EXIT);

    }
}
