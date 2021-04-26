package model.others;

import java.util.Date;

public class Script {

    public static final String DEFAULT_NARRATOR = "GUID VOICE";
    private static final int CURRENT_YEAR = new Date().getYear() + 1900;

    // === WELCOME MESSAGES ===

    public static final String WELCOME_MESSAGE =
            "================  WELCOME  ================\n" +
            "Hello and welcome to our game The Colossal Caveman Adventure.\n" +
            "This game is the product of many hours of work and deserves to be fully appreciated.\n" +
            "Therefore if you are reluctant to a little dirty humor, if you hate bad scenarios\n" +
            "or if you have a heavy history with Nazism: DO NOT PLAY THIS GAME !\n" +
            "Conversely, we wish you a good game and hope for a good return.\n" +
            "===========================================\n\n";

    public static final String SYNOPSIS =
            "================  SYNOPSIS  ================\n" +
            "A caveman found frozen in the Arctic during 1984.\n" +
            "A team of Nazis researchers thaws it and took him prisoner of their laboratory.\n" +
            "You play this man and your goal is to escape from here alive...\n" +
            "=============================================";

    //BEGIN
    public static final String NAZI_BLAHBLAH = "Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah\n" +
                                               doSpaces("Nazi Researcher") + "Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah\n" +
                                               doSpaces("Nazi Researcher") + "Blah Blah Blah...(Nazi Blah Blah)\n\n";
    public static final String OTHER_NAZI_BLAHBLAH = "Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah\n" +
                                                     doSpaces("Other Nazi Researcher") + "Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah\n" +
                                                     doSpaces("Other Nazi Researcher") + "Blah Blah Blah ?\n\n";
    public static final String NAZI_JOKE = "Blah ? Blah Blah...BLAH ! (Nazi Joke)\n\n";
    public static final String NAZI_LAUGH = "HAACH HACH HACH HACH HACH HACH ! (Nazi Laugh)\n\n";
    public static final String CONTEXT_01 = "Wow, it's really cold in here...\n\n";
    public static final String CONTEXT_02 = "...You're hearing weird voices...\n\n";
    public static final String CONTEXT_03 = "Nazis leave the room\n\n";
    public static final String CONTEXT_04 = "You're finally waking up.";

    // === ENDING MESSAGES ===

    // - Ending message for the text adventure -
    public static final String YOU_WIN =
                    "You managed to run away from the lab and escape those fucking Nazis ! You are free !\n" +
                    doSpaces(DEFAULT_NARRATOR) + (CURRENT_YEAR - 1984) + " years later you are the head of the stock exchange, rising star of cinema and president\n" +
                    doSpaces(DEFAULT_NARRATOR) + "of the United States of America. Women run after you and men envy you, you are voted the\n" +
                    doSpaces(DEFAULT_NARRATOR) + "sexiest man in the world and your four children, Gaëtan, Benjamin, Mathieu and Thibault, have obtained\n" +
                    doSpaces(DEFAULT_NARRATOR) + "a superb rating for their project.\n\n" + "\t(Thanks for them...)\n\n";

    // - End messages for the JavaFx project -
    public static final String WIN_ENDING_1 = "You managed to run away from the lab and escape those fucking Nazis ! You are free ! " +
                                              "You even decide to change your name to \"" + Game.HERO.getName() + "\" which is certainly not" +
                                              "the better choice of your life but whatever you're free now !";
    public static final String WIN_ENDING_2 = (CURRENT_YEAR - 1984) + " years later you become the head of the stock exchange...";
    public static final String WIN_ENDING_3 = "... become a rising star of cinema...";
    public static final String WIN_ENDING_4 = "... and president of the United States of America.";
    public static final String WIN_ENDING_5 = "Women run after you and men envy you, you are voted the sexiest man in the world !";
    public static final String WIN_ENDING_6 = "... And potentially your four children, Gaëtan, Benjamin, Mathieu and Thibault, " +
                                              "have obtained a superb rating for their project.\n(Thanks for them...)";

    // - Other messages -
    public static final String YOU_LOOSE = "I thought this game was easy, you suck on a computer...You remind me of Psychology students...\n";
    public static final String GAME_OVER = "\nYou will quit the game in 5 seconds...\nSee you later ";
    public static final String CREDITS =
            "======================== CREDITS ========================\n" +
            "--- SCENARIO ---\n" +
            "BENJAMIN CHEVAIS\n" +
            "GAETAN FREJOUX\n" +
            "MATHIEU NIORD\n" +
            "THIBAULT RUCHER\n\n" +
            "--- STORYBOARD ---\n" +
            "BENJAMIN CHEVAIS\n" +
            "GAETAN FREJOUX\n" +
            "MATHIEU NIORD\n" +
            "THIBAULT RUCHER\n\n" +
            "--- DEVELOPMENT ---\n" +
            "BENJAMIN CHEVAIS\n" +
            "GAETAN FREJOUX\n" +
            "MATHIEU NIORD\n" +
            "THIBAULT RUCHER\n\n" +
            "--- SPECIAL GUESTS ---\n" +
            "IN THE ROLE OF HOUGA BOUGA :             YOU \n" +
            "IN THE ROLE OF THE ACCOUNT GUY : AFIDA TURNER\n" +
            "IN THE ROLE OF THE ZOMBIE NAZI : AFIDA TURNER\n" +
            "IN THE ROLE OF THE SUPER-NAZI  : AFIDA TURNER\n" +
            "ORIGINAL SOUND TRACK :         JONNY HALLIDAY\n" +
            "COFFEE OFFICER :                        WOMAN\n" +
            "OPERATIONS DIRECTOR :         THE RENDER DATE\n" +
            "=========================================================\n";

    public static final String THANKING_PLAYER = "...WE THANK YOU FOR PARTICIPATING IN OUR PROJECT\n\n\n";


    // === BATTLE ===

    public static final String BATTLE_BEGIN = "\n=========== BAAAAAAAATTLE ===========\n\nYou come face to face with a ";

    public static final String BATTLE_HELP = "\n=========== LIST OF COMMANDS ===========\n - attack\n - heal\n\nBEWARE OF WHAT YOU'RE WRITING OR YOU COULD HAVE A BAD PRESENT...\n\n";

    // === HERO ===
    public static final String ANGRY_HERO = "HOOOUGA BOOUGAAA !\n";


    // === ANIMALS ===

    //Cat
    public static final String CAT_TEXT01 = "Meeeeew mew meeew mew\n";

    public static final String CAT_TEXT02 = "Hello where are you from I came from Germany. " +
        "I saw all those \"glorious soldier\" who left you here. " +
        "They laughed and the boss said you were a stupid frenchy " +
        "caveman who could never find a way out of this mansion ! " +
        "Another said that for sure no one will find the password " +
        "because it's too smart, two letters I ... T. IT is the password !";

    public static final String CAT_DESCRIPT = "Ohw easy man ! It's one of those Nazi cats !\n";

    //Mouse
    public static final String MOUSE_TEXT01 = "krrih krrih…\n";

    public static final String MOUSE_TEXT02 = "Hey handsome ! Are you alone ? You look well built but obviously not very " +
            "smart. Are you in a psychology cursus ? Haha, I’m kidding, or... not ? Are " +
            "you homeless ? Hmm... no matter ! The password is \"S A GREAT\". I heard about " +
            "a potion that would make gas invulnerable in this room. Bye, come see me later. ";

    public static final String MOUSE_DESCRIPT = "A simple lab mouse locked in its cage. Looks like she's a female.\n";

    //Monkey
    public static final String MONKEY_TEXT01 = "Houhou HahaHaAAA !\n";

    public static final String MONKEY_TEXT02 = "Wuts up bru ? Comon u saw all da shit ? Wtf !? I m a f***ing monky in a " +
            "f***ing mansion in da f***ing 80's with da return of da f***ing Nazis : " +
            "wut da hell bru ? No waaay a die here ! and u know wut ma man ? Am starving " +
            "like a wulf, yep ! Go find me nice food and a give u da password u need for " +
            "escaping those bastards.";

    public static final String MONKEY_TEXT03 = "R u kiddin ? u thoght a m a stoopid \"cartoon monky\" bro ? oh, a see, cause " +
            "a m black... r u a f***ing racist ? ... Wait a minute... dat s not food dumbass, " +
            "it's a GOLD BANANA !? eh u know wut, a give u da password but only cause " +
            "a m better than u, u know wut u deserve ? dat a grab ma own shit and throw it " +
            "in ur face. Password is GAME, u understand ? u r in da game, in ma game, mine " +
            "not urs ! Pshht, go away !";

    public static final String MONKEY_DESCRIPT = "Do you know this monkey ? He calls you with great gestures. Maybe he's family ?\n";


    // === ENNEMIES ===

    //Account Guy
    public static final String ACCOUNTGUY_DEFAULT = "H1 1'M 7H3 4CC0UN7 9UY ! Y0U W4N7 70 83 MY FR13ND ?\n";
    public static final String ACCOUNTGUY_ATTACK = "1'M 83773R 7H4N Y0U ! D13 57000P1D !\n";
    public static final String ACCOUNTGUY_DEFEAT = "4444RRR9H = 1\n";
    public static final String ACCOUNTGUY_DESCRIPT = "He seems lonely, certainly the ACCOUNT GUY. Even Nazis don't understand him.\n";

    //Zombie
    public static final String ZOMBIE_DEFAULT  = "Grrrr…\n";
    public static final String ZOMBIE_ATTACK = "Grrrr…\n";
    public static final String ZOMBIE_DEFEAT = "Aaaaarghrrgrr...\n";
    public static final String ZOMBIEDESCRIPT = "So it was true, the Nazis created zombies ?! However, we are in the 80s, beware of the clichés.\n";

    //Final Boss
    public static final String BOSS_DEFAULT = "lah Blah Blah Blah Blah Blah Blah\n";
    public static final String BOSS_ATTACCK = "BlablablACHTUNG !\n";
    public static final String BOSS_DEFEAT = "AAAaarrrgh sooo...\n";
    public static final String BOSS_DESCRIPT = "Wow, what a big and strong man ! He's certainly a kind of final boss...\n";


    // === OBJECTS ===
    
    //Names
    public static final String DEFAULT_CLUB_NAME = "club";
    public static final String DEFAULT_KEY1_NAME = "key";
    public static final String DEFAULT_KEY2_NAME = "exit key";
    public static final String DEFAULT_FUSE_NAME = "missing_fuse";
    public static final String DEFAULT_STICK_NAME = "stick";
    public static final String DEFAULT_FLINT_NAME = "flint";
    public static final String DEFAULT_POTION_NAME = "potion";
    public static final String DEFAULT_BANANA_NAME = "banana";
    public static final String DEFAULT_LOCKER_NAME = "locker";
    public static final String DEFAULT_WALKMAN_NAME = "walkman";
    public static final String DEFAULT_FIREDSTICK_NAME = "fired stick";
    public static final String DEFAULT_NAZIPOSTER_NAME = "nazi poster";
    public static final String DEFAULT_SEXYPOSTER_1_NAME = "sexy poster 01";
    public static final String DEFAULT_SEXYPOSTER_2_NAME = "sexy poster 02";
    public static final String DEFAULT_BESCHERELLE_NAME = "bescherelle";
    public static final String DEFAULT_ELECTRICMETER_NAME = "electric meter";
    public static final String DEFAULT_CORPSE_NAME = "Corpse";

    //Descriptions
    public static final String KEY_DESCRIPT = "It's just a key...which can open model.doors or something, basic !";
    public static final String POTION_DESCRIPT = "It looks like a mystic solution.";
    public static final String ELECTRICMETER_DESCRIPT ="This electric meter is in operation";
    public static final String BANANA_DESCRIPT = "Looks like a banana straight from the 70s.";
    public static final String BESCH_DESCRIPT = "An artifact that holds the greatest of powers.";
    public static final String FLINT_DESCRIPT = "Just a stone that fell out of your underpants.";
    public static final String CLUB_DESCRIPT = "Wow ! Thanks this you're gonna destroy all those creepies";
    public static final String SEXY_POSTER = "A poster of a seeexy woman. Yum, what a beauty !";
    public static final String ELECTRICMETER_MISSING_DESCRIPT ="A fuse is missing on this electric meter";
    public static final String FUSE_DESCRIPT = "It should allow you to restore the power, if only you know how...";
    public static final String NAZI_POSTER = "You are looking at this poster. What a ugly Nazi face...";
    public static final String STICK_DESCRIPT = "A very basic stick. The researchers may have used it for experiments...";
    public static final String FIRED_STICK_DESCRIPT = "Wow ! Fire ! But what for ?";
    public static final String CORPSE_DESCRIPT = "It's a corpse... What else ?...";
    //Doors
    public static final String SECRET_CODE_DOOR_DESCRIPT = "Hey buddy you won't be able to force the code. Even the Nazis are certainly smarter than you...";
    public static final String BURNABLE_DOOR_DESCRIPT = "Wow it seems like a secret tunnel ! ...And a lot of spiders web... Maybe you can burn it ?";
    public static final String INFECTED_ROOM_DOOR_DESCRIPT = "You can see gas coming out of this door. Unless you're immune, better not to go in that room.";
    public static final String DESTRUCTABLE_DOOR_DESCRIPT = "It's doomed but it seems like fragile. Maybe you can smash it ?";
    public static final String CONDAMNED_DOOR_DESCRIPT = "It's doomed dude ! You can not enter in.";
    public static final String LOCKED_DOOR_DESCRIPT = "The door is locked. You can certainly find a key around stupid caveman.";

    
    // === HELP COMMANDS ===

    public static final String HELP_DEFAULT = "Vous devez vous échappez d'ici : Trouvez la sortie !\n" +
            "- Marchez sur les objets ou les animaux pour intéragir\n" +
            "- double-cliquez pour utiliser un objet\n" +
            "- certains objets sont fusionnables, essayez de les associer\n" +
            "- cliquez sur quelque chose pour obtenir des informations\n";

    public static String doSpaces(String size){
        int spaces = size.length() + 3;
        StringBuilder s= new StringBuilder();
        for(int i = 0 ; i< spaces ; i++){
            s.append(" ");
        }
        return s.toString();
    }
}
