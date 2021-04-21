package controller.entities;


import model.others.Place;
import view.classes.MyImageView;
import view.ressources.GameResources;

import java.util.ArrayList;

import static model.others.Game.*;
import static view.ressources.GameResources.*;
import static view.ressources.ImageResources.*;

public class EntitiesDatas {

    // - Hero -
    public final static MyHero MY_HERO = new MyHero(HERO, HERO_IM);

    // Animals
    public final static MyEntity MY_CAT = new MyEntity(CAT, CAT_IM);
    public final static MyEntity MY_MONKEY = new MyEntity(MONKEY, MONKEY_IM);
    public final static MyEntity MY_MOUSE = new MyEntity(MOUSE, MOUSE_IM);

    //Enemies objects
    public final static MyEntity MY_K_1 = new MyEntity(K_1, K_1_IM);
    public final static MyEntity MY_FUSE = new MyEntity(FUSE, FUSE_IM);
    public final static MyEntity MY_K_2 = new MyEntity(K_2, K_2_IM);

    // Enemies corpses
    public final static MyEntity MY_ACCOUNT_GUY_CORPSE = new MyEntity(ACCOUNT_GUY_CORPSE_IM);
    public final static MyEntity MY_NAZI_ZOMBIE_CORPSE = new MyEntity(NAZI_ZOMBIE_CORPSE_IM);
    public final static MyEntity MY_BOSS_CORPSE = new MyEntity(BOSS_CORPSE_IM);

    // Enemies
    public final static MyEntity MY_ACCOUNT_GUY = new MyEntity(ACCOUNT_GUY, ACCOUNT_GUY_IM, MY_ACCOUNT_GUY_CORPSE, MY_K_1);
    public final static MyEntity MY_ZOMBIE_NAZI = new MyEntity(ZOMBIE_NAZI, ZOMBIE_NAZI_IM, MY_NAZI_ZOMBIE_CORPSE, MY_FUSE);
    public final static MyEntity MY_SUPER_NAZI = new MyEntity(SUPER_NAZI, SUPER_NAZI_IM, MY_BOSS_CORPSE, MY_K_2);

    // Objects
    public final static MyEntity MY_NAZI_POSTER = new MyEntity(NAZI_POSTER, NAZI_POSTER_IM);
    public final static MyEntity MY_CLUB = new MyEntity(CLUB, CLUB_IM);
    public final static MyEntity MY_POTION =new MyEntity(POTION, POTION_IM);
    public final static MyEntity MY_BANANA = new MyEntity(BANANA, BANANA_IM);
    public final static MyEntity MY_STICK = new MyEntity(STICK, STICK_IM);
    public final static MyEntity MY_FLINT = new MyEntity(FLINT, FLINT_IM);
    public final static MyEntity MY_CAT_B = new MyEntity(CAT_B, CAT_B_IM);
    public final static MyEntity MY_MOUSE_B =new MyEntity(MOUSE_B, MOUSE_B_IM);
    public final static MyEntity MY_MONKEY_B = new MyEntity(MONKEY_B, MONKEY_B_IM);
    public final static MyEntity MY_ELECTRICITY_METER = new MyEntity(ELECTRICITY_METER, ELECTRICITY_METER_IM);
    public final static MyEntity MY_LOCKER = new MyEntity(LOCKER, LOCKER_IM);
    public final static MyEntity MY_SEXY_POSTER_1 = new MyEntity(SEXY_POSTER_1, SEXY_POSTER_IM_1);
    public final static MyEntity MY_SEXY_POSTER_2 = new MyEntity(SEXY_POSTER_2, SEXY_POSTER_IM_2);
    public final static MyEntity MY_WALKMAN = new MyEntity(WALKMAN, WALKMAN_IM);
    public final static MyEntity MY_FIREDSTICK = new MyEntity(FIRED_STICK, FIREDSTICK_IM);

    // Doors
    public final static MyEntity MY_SECRET_PASSAGE = new MyEntity(SECRET_PASSAGE, SECRET_PASSAGE_IM);
    public final static MyEntity MY_EXPERIM_TO_CONDA = new MyEntity(EXPERIM_AND_CONDA, EXPERIM_TO_CONDA_IM);
    public final static MyEntity MY_CONDA_TO_EXPERIM = new MyEntity(EXPERIM_AND_CONDA, CONDA_TO_EXPERIM_IM);
    public final static MyEntity MY_CHANG_TO_ENTRY = new MyEntity(CHANG_AND_ENTRY, CHANG_TO_ENTRY_IM);
    public final static MyEntity MY_MEET_TO_ARCH = new MyEntity(MEET_AND_ARCH, MEET_TO_ARCH_IM);
    public final static MyEntity MY_ARCH_TOMEET = new MyEntity(MEET_AND_ARCH, ARCH_TOMEET_IM);
    public final static MyEntity MY_TRANSF_TO_MEET = new MyEntity(TRANSF_AND_MEET, TRANSF_TO_MEET_IM);
    public final static MyEntity MY_MEET_TO_TRANSF = new MyEntity(TRANSF_AND_MEET, MEET_TO_TRANSF_IM);
    public final static MyEntity MY_DECONT_TO_EXIT = new MyEntity(DECONT_AND_EXIT, DECONT_TO_EXIT_IM);
    public final static MyEntity MY_ANIM_TO_TRANSF = new MyEntity(ANIM_AND_TRANSF, ANIM_TO_TRANSF_IM);
    public final static MyEntity MY_TRANSF_TOANIM = new MyEntity(ANIM_AND_TRANSF, TRANSF_TOANIM_IM);
    public final static MyEntity MY_EXPERIM_TO_RESERV = new MyEntity(EXPERIM_AND_RESERV, EXPERIM_TO_RESERV_IM);
    public final static MyEntity MY_RESERV_TO_EXPERIM = new MyEntity(EXPERIM_AND_RESERV, RESERV_TO_EXPERIM_IM);
    public final static MyEntity MY_EXPERIM_TO_DIRTY = new MyEntity(EXPERIM_AND_DIRTY, EXPERIM_TO_DIRTY_IM);
    public final static MyEntity MY_DIRTY_TO_EXPERIM = new MyEntity(EXPERIM_AND_DIRTY, DIRTY_TO_EXPERIM_IM);
    public final static MyEntity MY_TRANSF_TO_CHANG = new MyEntity(TRANSF_AND_CHANG, TRANSF_TO_CHANG_IM);
    public final static MyEntity MY_CHANG_TO_TRANSF = new MyEntity(TRANSF_AND_CHANG, CHANG_TO_TRANSF_IM);
    public final static MyEntity MY_TRANSF_TO_EXPER = new MyEntity(TRANSF_AND_EXPER, TRANSF_TO_EXPER_IM);
    public final static MyEntity MY_EXPER_TO_TRANSF = new MyEntity(TRANSF_AND_EXPER, EXPER_TO_TRANSF_IM);
    public final static MyEntity MY_EXPERIM_TO_MORG = new MyEntity(EXPERIM_AND_MORT, EXPERIM_TO_MORG_IM);
    public final static MyEntity MY_MORG_TO_EXPERIM = new MyEntity(EXPERIM_AND_MORT, MORG_TO_EXPERIM_IM);
    public final static MyEntity MY_CONDA_TO_DESERT = new MyEntity(CONDA_AND_DESERT, CONDA_TO_DESERT_IM);
    public final static MyEntity MY_DESERT_TO_CONDA = new MyEntity(CONDA_AND_DESERT, DESERT_TO_CONDA_IM);
    public final static MyEntity MY_EXPERIM_TO_COLD = new MyEntity(EXPERIM_AND_COLD, EXPERIM_TO_COLD_IM);
    public final static MyEntity MY_COLD_TO_EXPERIM = new MyEntity(EXPERIM_AND_COLD, COLD_TO_EXPERIM_IM);
    public final static MyEntity MY_COLD_TO_GARB = new MyEntity(COLD_AND_GARB, COLD_TO_GARB_IM);
    public final static MyEntity MY_GARB_TO_COLD = new MyEntity(COLD_AND_GARB, GARB_TO_COLD_IM);
    public final static MyEntity MY_DIRT_TO_DECON = new MyEntity(DIRT_AND_DECON, DIRT_TO_DECON_IM);
    public final static MyEntity MY_DECON_TO_DIRT =new MyEntity(DIRT_AND_DECON, DECON_TO_DIRT_IM);
    public final static MyEntity MY_EXIT_TO_DECON =new MyEntity(DECONT_AND_EXIT, EXIT_TO_DECON_IM);

    // Liste des images des lieux
    private final static ArrayList<MyEntity> animalRoomImList = new ArrayList<>();
    private final static ArrayList<MyEntity> transferRoomImList = new ArrayList<>(); //LEFT
    private final static ArrayList<MyEntity> changingRoomImList = new ArrayList<>();
    private final static ArrayList<MyEntity> entryImList = new ArrayList<>();
    private final static ArrayList<MyEntity> meetingRoomImList = new ArrayList<>();
    private final static ArrayList<MyEntity> archivesRoomImList = new ArrayList<>();
    private final static ArrayList<MyEntity> experimentsRoomImList = new ArrayList<>(); //TOP LEFT
    private final static ArrayList<MyEntity> morgueImList = new ArrayList<>();
    private final static ArrayList<MyEntity> condamnedSASImList = new ArrayList<>();
    private final static ArrayList<MyEntity> desertedRoomImList = new ArrayList<>();
    private final static ArrayList<MyEntity> productsReserveImList = new ArrayList<>();
    private final static ArrayList<MyEntity> garbageRoomImList = new ArrayList<>();
    private final static ArrayList<MyEntity> coldRoomImList = new ArrayList<>();
    private final static ArrayList<MyEntity> dirtyChangingRoomImList = new ArrayList<>();
    private final static ArrayList<MyEntity> decontaminationRoomImList = new ArrayList<>();
    private final static ArrayList<MyEntity> exitImList = new ArrayList<>();

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
            meetingRoomImList, MEETING_ROOM_MAP_POSITIONS, MY_ACCOUNT_GUY);
    public final static MyPlace MY_ARCHIVES_ROOM = new MyPlace(ARCHIVES_ROOM, BACKGROUND_DEFAULT,
            archivesRoomImList, ARCHIVES_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_EXPERIMENTS_ROOM = new MyPlace(EXPERIMENTS_ROOM, BACKGROUND_DEFAULT,
            experimentsRoomImList, EXPERIMENTS_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_MORGUE = new MyPlace(MORGUE, BACKGROUND_DEFAULT,
            morgueImList, MORGUE_MAP_POSITIONS);
    public final static MyPlace MY_CONDAMNED_SAS = new MyPlace(CONDAMNED_SAS, BACKGROUND_CORRIDOR,
            2,6,0,8,condamnedSASImList, CONDAMNED_SAS_MAP_POSITIONS);
    public final static MyPlace MY_DESERTED_ROOM = new MyPlace(DESERTED_ROOM, BACKGROUND_DEFAULT,
            desertedRoomImList, DESERTED_ROOM_MAP_POSITIONS, MY_ZOMBIE_NAZI);
    public final static MyPlace MY_PRODUCTS_RESERVE = new MyPlace(PRODUCTS_RESERVE, BACKGROUND_DEFAULT,
            productsReserveImList, PRODUCTS_RESERVE_MAP_POSITIONS);
    public final static MyPlace MY_GARBAGE_ROOM = new MyPlace(GARBAGE_ROOM, BACKGROUND_DEFAULT,
            garbageRoomImList, GARBAGE_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_COLD_ROOM = new MyPlace(COLD_ROOM, BACKGROUND_NO_lIGHT,
            coldRoomImList, COLD_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_DIRTY_CHANGING_ROOM = new MyPlace(DIRTY_CHANGINGROOM, BACKGROUND_DEFAULT,
            dirtyChangingRoomImList, DIRTY_CHANGING_ROOM_MAP_POSITIONS);
    public final static MyPlace MY_DECONTAMINATION_ROOM =new MyPlace(DECONTAMINATION_ROOM, BACKGROUND_DEFAULT,
            decontaminationRoomImList, DECONTAMINATION_ROOM_MAP_POSITIONS, MY_SUPER_NAZI);
    public final static MyPlace MY_EXIT = new MyPlace(EXIT, BACKGROUND_DEFAULT,
            exitImList, EXIT_MAP_POSITIONS);


    // - Add an object to a room thanks MyPlace -
    private static void addObject(MyPlace my_place, MyEntity obj){
        Place place = obtainPlace(my_place);
        if(place != null){
            my_place.getEntities().add(obj);
            if(!place.isEnlightened()){
                obj.view.setVisible(false);
            }
        }
    }

    // - find a entity with a MyImageView -
    public static MyEntity findEntity(MyImageView im){
        boolean find = false;
        MyEntity ret = null;

        MyPlace myPlace = PLACE_TO_MY_PLACE.get(MY_HERO.getModel().getPlace());
        for(MyEntity entity : myPlace.getEntities()){
            if(entity.view.equals(im)){
                find = true;
                ret = entity;
                break;
            }
        }
        if(!find){
            for(MyEntity entity : MY_HERO.inventory){
                if(entity.view.equals(im)){
                    find = true;
                    ret = entity;
                    break;
                }
            }
        }

        return ret;
    }

    public static MyEntity findEntityOnGridGame(MyImageView im){
        MyEntity ret = null;

        MyPlace myPlace = PLACE_TO_MY_PLACE.get(MY_HERO.getModel().getPlace());
        for(MyEntity entity : myPlace.getEntities()){
            if(entity.view.equals(im)){
                ret = entity;
                break;
            }
        }

        return ret;
    }

    // === INITIALIZATION ===
    private final static EntitiesDatas ENTITIES_DATAS = new EntitiesDatas();


    public EntitiesDatas(){
        // ADD DOORS TO ROOMS
        animalRoomImList.add(MY_ANIM_TO_TRANSF);
        changingRoomImList.add(MY_CHANG_TO_TRANSF);
        changingRoomImList.add(MY_CHANG_TO_ENTRY);
        transferRoomImList.add(MY_TRANSF_TOANIM);
        transferRoomImList.add(MY_TRANSF_TO_CHANG);
        transferRoomImList.add(MY_TRANSF_TO_MEET);
        transferRoomImList.add(MY_TRANSF_TO_EXPER);
        meetingRoomImList.add(MY_MEET_TO_ARCH);
        meetingRoomImList.add(MY_MEET_TO_TRANSF);
        archivesRoomImList.add(MY_ARCH_TOMEET);
        experimentsRoomImList.add(MY_EXPERIM_TO_COLD);
        experimentsRoomImList.add(MY_EXPERIM_TO_RESERV);
        experimentsRoomImList.add(MY_EXPERIM_TO_CONDA);
        experimentsRoomImList.add(MY_EXPERIM_TO_MORG);
        experimentsRoomImList.add(MY_EXPERIM_TO_DIRTY);
        experimentsRoomImList.add(MY_EXPER_TO_TRANSF);
        morgueImList.add(MY_MORG_TO_EXPERIM);
        morgueImList.add(MY_SECRET_PASSAGE);
        condamnedSASImList.add(MY_CONDA_TO_EXPERIM);
        condamnedSASImList.add(MY_CONDA_TO_DESERT);
        desertedRoomImList.add(MY_DESERT_TO_CONDA);
        productsReserveImList.add(MY_RESERV_TO_EXPERIM);
        coldRoomImList.add(MY_COLD_TO_EXPERIM);
        coldRoomImList.add(MY_COLD_TO_GARB);
        garbageRoomImList.add(MY_GARB_TO_COLD);
        dirtyChangingRoomImList.add(MY_DIRT_TO_DECON);
        dirtyChangingRoomImList.add(MY_DIRTY_TO_EXPERIM);
        decontaminationRoomImList.add(MY_DECON_TO_DIRT);
        decontaminationRoomImList.add(MY_DECONT_TO_EXIT);
        exitImList.add(MY_EXIT_TO_DECON);

        // ADD ANIMALS TO ROOMS
        animalRoomImList.add(MY_CAT);
        experimentsRoomImList.add(MY_MONKEY);
        experimentsRoomImList.add(MY_MOUSE);

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
        addObject(MY_ANIMAL_ROOM, MY_CAT_B);
        addObject(MY_TRANSFER_ROOM, MY_FLINT);
        addObject(MY_TRANSFER_ROOM, MY_ELECTRICITY_METER);
        addObject(MY_CHANGING_ROOM, MY_SEXY_POSTER_1);
        addObject(MY_CHANGING_ROOM, MY_LOCKER);
        addObject(MY_EXPERIMENTS_ROOM, MY_NAZI_POSTER);
        addObject(MY_COLD_ROOM, MY_BANANA);
        addObject(MY_GARBAGE_ROOM, MY_STICK);
        addObject(MY_ARCHIVES_ROOM, MY_CLUB);
        addObject(MY_ARCHIVES_ROOM, MY_MOUSE_B);
        addObject(MY_PRODUCTS_RESERVE, MY_POTION);
        addObject(MY_DESERTED_ROOM, MY_MONKEY_B);
        addObject(MY_DIRTY_CHANGING_ROOM, MY_SEXY_POSTER_2);
    }


}
