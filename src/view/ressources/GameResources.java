package view.ressources;

import javafx.scene.text.Font;
import java.util.HashMap;
import java.util.Map;

import model.others.Place;
import view.classes.MyHeroImageView;
import view.classes.MyImageView;
import controller.entities.MyPlace;

import static view.ressources.ImageResources.*;

public class GameResources {

    /*** === ATTRIBUTES === ***/

    //Fonts
    public final static Font MY_FONT_16 = Font.loadFont("file:src/assets/font/rainyhearts.ttf", 16);
    public final static Font MY_FONT_32 = Font.loadFont("file:src/assets/font/rainyhearts.ttf", 32);
    public final static Font MY_FONT_64 = Font.loadFont("file:src/assets/font/rainyhearts.ttf", 64);


    // Hero
    public final static MyHeroImageView HERO_IM = new MyHeroImageView(IMAGE_CAVEMAN_DEFAULT_FRONT,4,4);


    // Animals
    public final static MyImageView CAT_IM = new MyImageView(IMAGE_CAT, 2, 6, 45);
    public final static MyImageView MONKEY_IM = new MyImageView(IMAGE_MONKEY, 4, 2, 45);
    public final static MyImageView MOUSE_IM = new MyImageView(IMAGE_MOUSE, 7, 6, 45);

    //Enemies objects
    public final static MyImageView K_1_IM = new MyImageView(IMAGE_KEY, 5, 4);
    public final static MyImageView FUSE_IM = new MyImageView(IMAGE_FUSE, 5, 4);
    public final static MyImageView K_2_IM = new MyImageView(IMAGE_KEY, 5, 4);

    // Enemies corpses
    public final static MyImageView ACCOUNT_GUY_CORPSE_IM = new MyImageView(IMAGE_ACCOUNT_GUY_DEFEAT_FIX, 4, 4);
    public final static MyImageView NAZI_ZOMBIE_CORPSE_IM = new MyImageView(IMAGE_NAZI_ZOMBIE_DEFEAT_FIX, 4, 4);
    public final static MyImageView BOSS_CORPSE_IM = new MyImageView(IMAGE_BOSS_DEFEAT_FIX, 4, 4);

    // Enemies
    public final static MyImageView ACCOUNT_GUY_IM = new MyImageView(
            IMAGE_ACCOUNT_GUY_DEFAULT, IMAGE_ACCOUNT_GUY_BATTLE, URL_ACCOUNT_GUY_OPENING, URL_ACCOUNT_CUY_DEFEAT,4, 4);
    public final static MyImageView ZOMBIE_NAZI_IM = new MyImageView(
            IMAGE_NAZI_ZOMBIE_DEFAULT, IMAGE_NAZI_ZOMBIE_BATTLE, URL_NAZI_ZOMBIE_OPENING, URL_NAZI_ZOMBIE_DEFEAT,4, 4);
    public final static MyImageView SUPER_NAZI_IM = new MyImageView(
            IMAGE_BOSS_DEFAULT, IMAGE_BOSS_BATTLE, URL_BOSS_OPENING, URL_BOSS_DEFEAT,4, 4);


    // Objects
    public final static MyImageView NAZI_POSTER_IM = new MyImageView(IMAGE_NAZIS_POSTER, 3, 0, 40);
    public final static MyImageView CLUB_IM = new MyImageView(IMAGE_CLUB, 3, 5, 45);
    public final static MyImageView POTION_IM =new MyImageView(IMAGE_POTION, 4, 4);
    public final static MyImageView BANANA_IM = new MyImageView(IMAGE_BANANA, 1, 7);
    public final static MyImageView STICK_IM = new MyImageView(IMAGE_STICK, 3, 1);
    public final static MyImageView FLINT_IM = new MyImageView(IMAGE_FLINT, 7, 4);
    public final static MyImageView CAT_B_IM = new MyImageView(IMAGE_CAT_BESCHERELLE, 3, 7);
    public final static MyImageView MOUSE_B_IM =new MyImageView(IMAGE_BESCHERELLE, 6, 1);
    public final static MyImageView MONKEY_B_IM = new MyImageView(IMAGE_BESCHERELLE, 5, 1);
    public final static MyImageView ELECTRICITY_METER_IM = new MyImageView(IMAGE_ELECTRIC_METER_MISSINGFUSE, 3, 0, 40);
    public final static MyImageView LOCKER_IM = new MyImageView(IMAGE_LOCKER_CLOSED, 7, 3);
    public final static MyImageView SEXY_POSTER_IM_1 = new MyImageView(IMAGE_SEXY_POSTER, 2, 0, 50);
    public final static MyImageView SEXY_POSTER_IM_2 = new MyImageView(IMAGE_SEXY_POSTER, 2, 0, 50);
    public final static MyImageView WALKMAN_IM = new MyImageView(IMAGE_WALKMAN, 0, 0);
    public final static MyImageView FIREDSTICK_IM = new MyImageView(IMAGE_TORCH, 0, 0);

    // Doors
    public final static MyImageView SECRET_PASSAGE_IM = new MyImageView(IMAGE_SECRET_PASSAGE, 4, 8);
    public final static MyImageView EXPERIM_TO_CONDA_IM = new MyImageView(IMAGE_GAS_DOOR, 6, 0);
    public final static MyImageView CONDA_TO_EXPERIM_IM = new MyImageView(IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView CHANG_TO_ENTRY_IM = new MyImageView(IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView MEET_TO_ARCH_IM = new MyImageView(IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView ARCH_TOMEET_IM = new MyImageView(IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView TRANSF_TO_MEET_IM = new MyImageView(IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView MEET_TO_TRANSF_IM = new MyImageView(IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView DECONT_TO_EXIT_IM = new MyImageView(IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView ANIM_TO_TRANSF_IM = new MyImageView(IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView TRANSF_TOANIM_IM = new MyImageView(IMAGE_DOOR_DOWN, 2, 8);
    public final static MyImageView EXPERIM_TO_RESERV_IM = new MyImageView(IMAGE_DOOR_UP, 2, 0);
    public final static MyImageView RESERV_TO_EXPERIM_IM = new MyImageView(IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView EXPERIM_TO_DIRTY_IM = new MyImageView(IMAGE_DOOR_LEFT, 0, 6);
    public final static MyImageView DIRTY_TO_EXPERIM_IM = new MyImageView(IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView TRANSF_TO_CHANG_IM = new MyImageView(IMAGE_DOOR_DOWN, 6, 8);
    public final static MyImageView CHANG_TO_TRANSF_IM = new MyImageView(IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView TRANSF_TO_EXPER_IM = new MyImageView(IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView EXPER_TO_TRANSF_IM = new MyImageView(IMAGE_DOOR_DOWN, 2, 8);
    public final static MyImageView EXPERIM_TO_MORG_IM = new MyImageView(IMAGE_DOOR_RIGHT, 8, 2);
    public final static MyImageView MORG_TO_EXPERIM_IM = new MyImageView(IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView CONDA_TO_DESERT_IM = new MyImageView(IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView DESERT_TO_CONDA_IM = new MyImageView(IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView EXPERIM_TO_COLD_IM = new MyImageView(IMAGE_DOOR_LEFT, 0, 2);
    public final static MyImageView COLD_TO_EXPERIM_IM = new MyImageView(IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView COLD_TO_GARB_IM = new MyImageView(IMAGE_DOOR_UP, 4, 0);
    public final static MyImageView GARB_TO_COLD_IM = new MyImageView(IMAGE_DOOR_DOWN, 4, 8);
    public final static MyImageView DIRT_TO_DECON_IM = new MyImageView(IMAGE_DOOR_LEFT, 0, 4);
    public final static MyImageView DECON_TO_DIRT_IM =new MyImageView(IMAGE_DOOR_RIGHT, 8, 4);
    public final static MyImageView EXIT_TO_DECON_IM =new MyImageView(IMAGE_DOOR_RIGHT, 8, 4);

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

    // - HashMap Place => MyPlace -
    public final static HashMap<Place,MyPlace> PLACE_TO_MY_PLACE = new HashMap<>();


    /*** === CONSTRUCTOR === ***/
    private GameResources() {}


    /*** === METHODS === ***/

    // - Return a Place thanks the MyPlace -
    public static Place obtainPlace(MyPlace place){
        for(Map.Entry<Place, MyPlace> entry : PLACE_TO_MY_PLACE.entrySet()){
            if(entry.getValue().equals(place)){
                return entry.getKey();
            }
        }
        return null;
    }


    /*** === INITIALIZATION === ***/
    private final static GameResources GAME_RESOURCES = new GameResources();
}
