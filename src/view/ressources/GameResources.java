package view.ressources;

import javafx.scene.text.Font;
import model.objects.Corpse;
import model.others.Place;
import model.others.Script;
import view.classes.MyHeroImageView;
import view.classes.MyImageView;
import view.classes.MyPlace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static model.others.Game.*;
import static view.ressources.ImageResources.*;

public class GameResources {

    //Fonts
    public final static Font MY_FONT_16 = Font.loadFont("file:src/assets/font/rainyhearts.ttf", 16);
    public final static Font MY_FONT_32 = Font.loadFont("file:src/assets/font/rainyhearts.ttf", 32);
    public final static Font MY_FONT_64 = Font.loadFont("file:src/assets/font/rainyhearts.ttf", 64);


    // Hero
    public final static MyHeroImageView HERO_IM = new MyHeroImageView(HERO, IMAGE_CAVEMAN_DEFAULT_FRONT,4,4);


    // Animals
    public final static MyImageView CAT_IM = new MyImageView(CAT, IMAGE_CAT, 2, 6, 45);
    public final static MyImageView MONKEY_IM = new MyImageView(MONKEY, IMAGE_MONKEY, 4, 2, 45);
    public final static MyImageView MOUSE_IM = new MyImageView(MOUSE, IMAGE_MOUSE, 7, 6, 45);

    //Enemies objects
    public final static MyImageView K_1_IM = new MyImageView(K_1, IMAGE_HEART, 5, 4);
    public final static MyImageView FUSE_IM = new MyImageView(FUSE, IMAGE_HEART, 5, 4);
    public final static MyImageView K_2_IM = new MyImageView(K_2, IMAGE_HEART, 5, 4);

    // Enemies corpses
    private final static Corpse ACCOUNT_GUY_CORPSE = new Corpse(Script.DEFAULT_CORPSE_NAME, Script.CORPSE_DESCRIPT);
    private final static Corpse NAZI_ZOMBIE_CORPSE = new Corpse(Script.DEFAULT_CORPSE_NAME, Script.CORPSE_DESCRIPT);
    private final static Corpse BOSS_CORPSE = new Corpse(Script.DEFAULT_CORPSE_NAME, Script.CORPSE_DESCRIPT);

    public final static MyImageView ACCOUNT_GUY_CORPSE_IM = new MyImageView(ACCOUNT_GUY_CORPSE, IMAGE_ACCOUNT_GUY_DEFEAT_FIX, 4, 4);
    public final static MyImageView NAZI_ZOMBIE_CORPSE_IM = new MyImageView(NAZI_ZOMBIE_CORPSE, IMAGE_NAZI_ZOMBIE_DEFEAT_FIX, 4, 4);
    public final static MyImageView BOSS_CORPSE_IM = new MyImageView(BOSS_CORPSE, IMAGE_BOSS_DEFEAT_FIX, 4, 4);

    // Enemies
    public final static MyImageView ACCOUNT_GUY_IM = new MyImageView(ACCOUNT_GUY,
            IMAGE_ACCOUNT_GUY_DEFAULT, IMAGE_ACCOUNT_GUY_BATTLE, IMAGE_ACCOUNT_GUY_OPENING, IMAGE_ACCOUNT_GUY_DEFEAT_ANIM, ACCOUNT_GUY_CORPSE_IM,
            K_1_IM,
            4, 4);
    public final static MyImageView ZOMBIE_NAZI_IM = new MyImageView(ZOMBIE_NAZI,
            IMAGE_NAZI_ZOMBIE_DEFAULT, IMAGE_NAZI_ZOMBIE_BATTLE, IMAGE_NAZI_ZOMBIE_OPENING, IMAGE_NAZI_ZOMBIE_DEFEAT_ANIM, NAZI_ZOMBIE_CORPSE_IM,
            FUSE_IM,
            4, 4);
    public final static MyImageView SUPER_NAZI_IM = new MyImageView(SUPER_NAZI,
            IMAGE_BOSS_DEFAULT, IMAGE_BOSS_BATTLE, IMAGE_BOSS_OPENING, IMAGE_BOSS_DEFEAT_ANIM, BOSS_CORPSE_IM,
            K_2_IM,
            4, 4);


    // Objects
    public final static MyImageView NAZI_POSTER_IM = new MyImageView(NAZI_POSTER, IMAGE_NAZIS_POSTER, 3, 0, 40);
    public final static MyImageView CLUB_IM = new MyImageView(CLUB, IMAGE_HEART, 3, 5);
    public final static MyImageView POTION_IM =new MyImageView(POTION, IMAGE_POTION, 4, 4);
    public final static MyImageView BANANA_IM = new MyImageView(BANANA, IMAGE_BANANA, 1, 7);
    public final static MyImageView STICK_IM = new MyImageView(STICK, IMAGE_STICK, 3, 1);
    public final static MyImageView FLINT_IM = new MyImageView(FLINT, IMAGE_FLINT, 7, 4);
    public final static MyImageView CAT_B_IM = new MyImageView(CAT_B, IMAGE_CAT_BESCHERELLE, 3, 7);
    public final static MyImageView MOUSE_B_IM =new MyImageView(MOUSE_B, IMAGE_BESCHERELLE, 6, 1);
    public final static MyImageView MONKEY_B_IM = new MyImageView(MONKEY_B, IMAGE_BESCHERELLE, 5, 1);
    public final static MyImageView ELECTRICITY_METER_IM = new MyImageView(ELECTRICITY_METER, IMAGE_HEART, 1, 1, 40);
    public final static MyImageView LOCKER_IM = new MyImageView(LOCKER, IMAGE_LOCKER_CLOSED, 7, 3);
    public final static MyImageView SEXY_POSTER_IM = new MyImageView(SEXY_POSTER, IMAGE_SEXY_POSTER, 2, 0);
    public final static MyImageView WALKMAN_IM = new MyImageView(WALKMAN, IMAGE_WALKMAN, 0, 0);
    public final static MyImageView FIREDSTICK_IM = new MyImageView(FIRED_STICK, IMAGE_TORCH, 0, 0);

    // Doors
    public final static MyImageView SECRET_PASSAGE_IM = new MyImageView(SECRET_PASSAGE, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView EXPERIM_TO_CONDA_IM = new MyImageView(EXPERIM_AND_CONDA, IMAGE_DOOR_UP, 6, 0);
    public final static MyImageView CONDA_TO_EXPERIM_IM = new MyImageView(EXPERIM_AND_CONDA, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView CHANG_TO_ENTRY_IM = new MyImageView(CHANG_AND_ENTRY, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView MEET_TO_ARCH_IM = new MyImageView(MEET_AND_ARCH, IMAGE_DOOR_RIGHT, 8, 4);
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
    public final static MyImageView MORG_TO_EXPERIM_IM = new MyImageView(EXPERIM_AND_MORT, IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView CONDA_TO_DESERT_IM = new MyImageView(CONDA_AND_DESERT, IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView DESERT_TO_CONDA_IM = new MyImageView(CONDA_AND_DESERT, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView EXPERIM_TO_COLD_IM = new MyImageView(EXPERIM_AND_COLD, IMAGE_DOOR_LEFT, 0, 2);
    public final static MyImageView COLD_TO_EXPERIM_IM = new MyImageView(EXPERIM_AND_COLD, IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView COLD_TO_GARB_IM = new MyImageView(COLD_AND_GARB, IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView GARB_TO_COLD_IM = new MyImageView(COLD_AND_GARB, IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView DIRT_TO_DECON_IM = new MyImageView(DIRT_AND_DECON, IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView DECON_TO_DIRT_IM =new MyImageView(DIRT_AND_DECON, IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView EXIT_TO_DECON_IM =new MyImageView(DECONT_AND_EXIT, IMAGE_DOOR_RIGHT, 8, 4);

    // Liste des images des lieux
    private final static ArrayList<MyImageView> animalRoomImList = new ArrayList<>();
    private final static ArrayList<MyImageView> transferRoomImList = new ArrayList<>(); //LEFT
    private final static ArrayList<MyImageView> changingRoomImList = new ArrayList<>();
    private final static ArrayList<MyImageView> entryImList = new ArrayList<>();
    private final static ArrayList<MyImageView> meetingRoomImList = new ArrayList<>();
    private final static ArrayList<MyImageView> archivesRoomImList = new ArrayList<>();
    private final static ArrayList<MyImageView> experimentsRoomImList = new ArrayList<>(); //TOP LEFT
    private final static ArrayList<MyImageView> morgueImList = new ArrayList<>();
    private final static ArrayList<MyImageView> condamnedSASImList = new ArrayList<>();
    private final static ArrayList<MyImageView> desertedRoomImList = new ArrayList<>();
    private final static ArrayList<MyImageView> productsReserveImList = new ArrayList<>();
    private final static ArrayList<MyImageView> garbageRoomImList = new ArrayList<>();
    private final static ArrayList<MyImageView> coldRoomImList = new ArrayList<>();
    private final static ArrayList<MyImageView> dirtyChangingRoomImList = new ArrayList<>();
    private final static ArrayList<MyImageView> decontaminationRoomImList = new ArrayList<>();
    private final static ArrayList<MyImageView> exitImList = new ArrayList<>();

    // Positions des lieux sur la map
    public final static Integer[][] ANIMAL_ROOM_MAP_POSITIONS = {{2,5}};
    public final static Integer[][] TRANSFER_ROOM_MAP_POSITIONS = {{2,4}, {3,4}};
    public final static Integer[][] CHANGING_ROOM_MAP_POSITIONS = {{3,5}};
    public final static Integer[][] ENTRY_ROOM_MAP_POSITIONS = {{3,6}};
    public final static Integer[][] MEETING_ROOM_MAP_POSITIONS = {{4,4}};
    public final static Integer[][] ARCHIVES_ROOM_MAP_POSITIONS = {{5,4}, {5,3}};
    public final static Integer[][] EXPERIMENTS_ROOM_MAP_POSITIONS = {{3,2}, {4,2}, {3,3}, {4,3}};
    public final static Integer[][] MORGUE_MAP_POSITIONS = {{5,2}};
    public final static Integer[][] CONDAMNED_SAS_MAP_POSITIONS = {{4,1}};
    public final static Integer[][] DESERTED_ROOM_MAP_POSITIONS = {{4,0}};
    public final static Integer[][] PRODUCTS_RESERVE_MAP_POSITIONS = {{3,1}};
    public final static Integer[][] GARBAGE_ROOM_MAP_POSITIONS = {{2,1}};
    public final static Integer[][] COLD_ROOM_MAP_POSITIONS = {{2,2}};
    public final static Integer[][] DIRTY_CHANGING_ROOM_MAP_POSITIONS = {{2,3}};
    public final static Integer[][] DECONTAMINATION_ROOM_MAP_POSITIONS = {{1,3}};
    public final static Integer[][] EXIT_MAP_POSITIONS = {{0,3}};

    // MyPlace
    public final static MyPlace MY_ANIMAL_ROOM = new MyPlace(ANIMAL_ROOM, BACKGROUND_DEFAULT,
            animalRoomImList, ANIMAL_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_TRANSFER_ROOM =new MyPlace(TRANSFER_ROOM, BACKGROUND_DEFAULT,
            transferRoomImList, TRANSFER_ROOM_MAP_POSITIONS); //LEFT
    public final static MyPlace MY_CHANGING_ROOM = new MyPlace(CHANGING_ROOM, BACKGROUND_DEFAULT,
            changingRoomImList, CHANGING_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_ENTRY_IM = new MyPlace(ENTRY, BACKGROUND_DEFAULT,
            entryImList, ENTRY_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_MEETING_ROOM = new MyPlace(MEETING_ROOM, BACKGROUND_DEFAULT,
             meetingRoomImList, MEETING_ROOM_MAP_POSITIONS, ACCOUNT_GUY_IM);
    public final static MyPlace MY_ARCHIVES_ROOM = new MyPlace(ARCHIVES_ROOM, BACKGROUND_DEFAULT,
             archivesRoomImList, ARCHIVES_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_EXPERIMENTS_ROOM = new MyPlace(EXPERIMENTS_ROOM, BACKGROUND_DEFAULT,
             experimentsRoomImList, EXPERIMENTS_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_MORGUE = new MyPlace(MORGUE, BACKGROUND_DEFAULT,
             morgueImList, MORGUE_MAP_POSITIONS);
    public final static MyPlace MY_CONDAMNED_SAS = new MyPlace(CONDAMNED_SAS, BACKGROUND_CORRIDOR,
             2,6,0,8,condamnedSASImList, CONDAMNED_SAS_MAP_POSITIONS);
    public final static MyPlace MY_DESERTED_ROOM = new MyPlace(DESERTED_ROOM, BACKGROUND_DEFAULT,
             desertedRoomImList, DESERTED_ROOM_MAP_POSITIONS, ZOMBIE_NAZI_IM);
    public final static MyPlace MY_PRODUCTS_RESERVE = new MyPlace(PRODUCTS_RESERVE, BACKGROUND_DEFAULT,
             productsReserveImList, PRODUCTS_RESERVE_MAP_POSITIONS);
    public final static MyPlace MY_GARBAGE_ROOM = new MyPlace(GARBAGE_ROOM, BACKGROUND_DEFAULT,
             garbageRoomImList, GARBAGE_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_COLD_ROOM = new MyPlace(COLD_ROOM, BACKGROUND_NO_lIGHT,
             coldRoomImList, COLD_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_DIRTY_CHANGING_ROOM = new MyPlace(DIRTY_CHANGINGROOM, BACKGROUND_DEFAULT,
             dirtyChangingRoomImList, DIRTY_CHANGING_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_DECONTAMINATION_ROOM =new MyPlace(DECONTAMINATION_ROOM, BACKGROUND_DEFAULT,
             decontaminationRoomImList, DECONTAMINATION_ROOM_MAP_POSITIONS, SUPER_NAZI_IM);
    public final static MyPlace MY_EXIT = new MyPlace(EXIT, BACKGROUND_DEFAULT,
             exitImList, EXIT_MAP_POSITIONS);

    // - HashMap Place => MyPlace -
    public final static HashMap<Place,MyPlace> PLACE_TO_MY_PLACE = new HashMap<>();

    // === METHODS ===

    // - Return a Place thanks the MyPlace -
    public static Place obtainPlace(MyPlace place){
        for(Map.Entry<Place, MyPlace> entry : PLACE_TO_MY_PLACE.entrySet()){
            if(entry.getValue().equals(place)){
                return entry.getKey();
            }
        }
        return null;
    }

    // - Add an object to a room thanks MyPlace -
    private static void addObject(MyPlace my_place, MyImageView obj){
        Place place = obtainPlace(my_place);
        if(place != null){
            my_place.getImages().add(obj);
            if(!place.isEnlightened()){
                obj.setVisible(false);
            }
        }
    }

    // - Reset GameResources -
    public static void reset() {
        // TODO - Reset the GameResources
    }

    // === INITIALIZATION ===
    private final static GameResources GAME_RESOURCES = new GameResources();

    // === CONSTRUCTOR ===
    private GameResources() {

        // ADD DOORS TO ROOMS
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
        exitImList.add(EXIT_TO_DECON_IM);

        // ADD ANIMALS TO ROOMS
        animalRoomImList.add(CAT_IM);
        experimentsRoomImList.add(MONKEY_IM);
        experimentsRoomImList.add(MOUSE_IM);

        // ADD SAME PLACES AND MYPLACES
        PLACE_TO_MY_PLACE.put(ANIMAL_ROOM, MY_ANIMAL_ROOM);
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

        // ADD OBJECTS TO ROOMS
        addObject(MY_ANIMAL_ROOM, CAT_B_IM);
        addObject(MY_TRANSFER_ROOM, FLINT_IM);
        addObject(MY_TRANSFER_ROOM, ELECTRICITY_METER_IM);
        addObject(MY_CHANGING_ROOM, SEXY_POSTER_IM);
        addObject(MY_CHANGING_ROOM, LOCKER_IM);
        addObject(MY_EXPERIMENTS_ROOM, NAZI_POSTER_IM);
        addObject(MY_COLD_ROOM, BANANA_IM);
        addObject(MY_GARBAGE_ROOM, STICK_IM);
        addObject(MY_ARCHIVES_ROOM, CLUB_IM);
        addObject(MY_ARCHIVES_ROOM, MOUSE_B_IM);
        addObject(MY_PRODUCTS_RESERVE, POTION_IM);
        addObject(MY_DESERTED_ROOM, MONKEY_B_IM);
        addObject(MY_DIRTY_CHANGING_ROOM, SEXY_POSTER_IM);
    }
}