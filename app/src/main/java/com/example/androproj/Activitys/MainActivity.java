package com.example.androproj.Activitys;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androproj.R;
import com.example.androproj.loginFragment.LoginFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import dm.GameProduct;

public class MainActivity extends AppCompatActivity {

    boolean loginStatus = false;
    private FirebaseAuth mAuth;
    LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        addData();
    }

    public void regFunc() {
        String email = ((EditText) findViewById(R.id.UsernameRegPage)).getText().toString();
        String password = ((EditText) findViewById(R.id.passordRegPage)).getText().toString();
        getmAuth().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Account created ", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Couldn't create account try entering you info again", Toast.LENGTH_LONG).show();
                    }

                });
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    public void addData() {

        List<GameProduct> gameProducts = new ArrayList<GameProduct>();
        ////Action games////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        GameProduct gameProduct = new GameProduct("god_of_war", "God of War: Ragnarök", "Sony Computer Entertainment",
                "action", "2022", R.drawable.gow, "In God of War, players control Kratos, a Spartan warrior who is sent by the Greek gods to kill Ares, the god of war. ... Armed with the Blades of Chaos, a weapon made out of two daggers attached to chains, Kratos rumbles through ancient Athens and other locations on a murderous quest to terminate the rogue god");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("Max_Payne_2", "Max Payne 2", " Remedy Entertainment,",
                "action", "2003", R.drawable.max_payne_2, "Max Payne 2: The Fall of Max Payne is a violent, film-noir love story. Dark, tragic, and intense, the in-depth story is a thrill-ride of shocking twists and revelations. Love hurts. The fierce, yet stylish action sequences and slow-motion gunplay that has become synonymous with Max Payne is back and better than ever.");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("dying_light", "Dying Light", "Techland,",
                "action", "2015", R.drawable.dying_light_cover, "Dying Light is a 2015 survival horror video game developed by Techland and published by Warner Bros. Interactive Entertainment. The game's story follows an undercover agent named Kyle Crane who is sent to infiltrate a quarantine zone in a Middle-eastern city called Harran.");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("gta5", "Grand Theft Auto 5", " Rockstar Games,",
                "action", "2003", R.drawable.gta, "Grand Theft Auto V is a 2013 action-adventure game developed by Rockstar North and published by Rockstar Games. It is the seventh main entry in the Grand Theft Auto series, following 2008's Grand Theft Auto IV, and the fifteenth instalment overall. Set within the fictional state of San Andreas, based on Southern California, the single-player story follows three protagonists—retired bank robber Michael De Santa, street gangster Franklin Clinton, and drug dealer and gunrunner Trevor Philips—and their attempts to commit heists while under pressure from a corrupt government agency and powerful criminals. The open world design lets players freely roam San Andreas' open countryside and the fictional city of Los Santos, based on Los Angeles.");
        gameProducts.add(gameProduct);

        ////Adventure Games////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gameProduct = new GameProduct("the_witcher_3_wild_hunt", "The Witcher 3: Wild Hunt", "CD Projekt RED",
                "adventure", "2015", R.drawable.witcher3, "The Witcher 3: Wild Hunt is the third and final installment in the series of games developed by CD Projekt RED featuring the witcher Geralt of Rivia. The game was originally scheduled for release in late 2014, then pushed back to 24 February 2015, and finally released on 19 May 2015.[3] During the first two weeks since release it had sold more than 4 million copies worldwide,[4] more than doubling the total sales of its predecessor, The Witcher 2: Assassins of Kings.[5]");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("r_o_t_t_r", "Rise of the Tomb Raider", "crystal dynamics",
                "adventure", "2015", R.drawable.tomb_rider, "Rise of the Tomb Raider is a 2015 action-adventure video game developed by Crystal Dynamics and published by Microsoft Studios and Square Enix's European subsidiary. It is the sequel to the 2013 video game Tomb Raider and the eleventh entry in the Tomb Raider series. Its story follows Lara Croft as she ventures into Siberia in search of the legendary city of Kitezh while battling the paramilitary organization Trinity, which intends to uncover the city's promise of immortality. Lara must traverse the environment and combat enemies with firearms and stealth as she explores semi-open hubs. In these hubs she can raid challenge tombs to unlock new rewards, complete side missions, and scavenge for resources which can be used to craft useful materials. Development of Rise of the Tomb Raider closely followed the conclusion of development of the 2013 reboot. Player feedback was considered during development, with the team reducing the number of quick time events and introducing more puzzles and challenge tombs. The team traveled to several locations in Turkey, including Cappadocia, Istanbul and Ephesus, to design Kitezh. Rhianna Pratchett returned as the game's writer while Bobby Tahouri replaced Jason Graves as the game's composer. Camilla Luddington returned to provide voice and motion-capture work for Lara. Powered by the Foundation engine, the game was also developed by Eidos Montreal and Nixxes Software. Rise of the Tomb Raider was announced at E3 2014 by Microsoft Studios. It was revealed as a timed exclusive for Xbox 360 and Xbox One at Gamescom 2014, which sparked player outrage and criticism from the gaming press and community. The game was praised, with critics liking its graphics, gameplay, and characterization; however, some reviewers felt that it did not take enough risks. By November 2021, the game had sold around 11.8 million copies.[1] Several downloadable story and content additions have been released for digital purchase. Square Enix released the game for Microsoft Windows and PlayStation 4 in 2016. A sequel, Shadow of the Tomb Raider, was released in September 2018.");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("broken_sword", "Broken Sword", "interactive",
                "adventure", "2015", R.drawable.broken_sword, "Broken Sword is a series of adventure games. The first game in the series, Broken Sword: The Shadow of the Templars, was released and developed in 1996 by British developer Revolution Software. Its sequel, Broken Sword II: The Smoking Mirror, was released a year later, and was followed by Broken Sword: The Sleeping Dragon in 2003, Broken Sword: The Angel of Death in 2006, and Broken Sword 5: The Serpent's Curse in 2013. A remake of the first game in the series, known as Broken Sword: Shadow of the Templars – The Director's Cut, was released in 2009, and a remake of the second game in the series, Broken Sword: The Smoking Mirror – Remastered, in 2010 for iOS devices; other platforms followed in 2011.");
        gameProducts.add(gameProduct);


        ////first person shooter Games////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gameProduct = new GameProduct("escape_from_tarkov", "Escape From Tarkov", "Battlestate Games",
                "fps", "beta", R.drawable.escape_from_tarkov, " Escape from Tarkov is a story-based experience that challenges all comers to escape the city with their lives. Matches are session-based and inhabited not only by human players but AI-driven Scavs to fill the world – ensuring a constant air of danger)");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("metro_2033", "Metro 2033", "4A Games",
                "fps", "2016", R.drawable.metro, "Metro (Russian: Метро) is a franchise consisting of novels and video games, which began with the release of Dmitry Glukhovsky's Metro 2033 novel in 2005. Although it began in Russia, the project enjoys plenty of popularity in Poland, Romania, Hungary, Ukraine and Germany as well. Ukrainian studio 4A Games had developed three video games set in the universe: Metro 2033 (2010), Metro: Last Light (2013) and Metro Exodus (2019). All of the Metro stories share the same setting – the fictional world of Glukhovsky's original novel. Although it described only his own vision of a post-apocalyptic Moscow, the books of the extended universe take place in a wide variety of different areas. Among these are: Moscow, St. Petersburg, Leningrad Oblast, Nizhny Novgorod, Tver Oblast, Moscow Oblast, Kola Peninsula, Rostov-on-Don, Samara, Novosibirsk, Yekaterinburg, and the Kaliningrad oblast. Some of the books in the series are set in other locations outside of Russia, such as Ukraine, Belarus, United Kingdom, Italy, Poland, and Antarctica.");
    gameProducts.add(gameProduct);
        gameProduct = new GameProduct("bioshock", "BioShock", "Interactive games",
                "fps", "2017", R.drawable.bioshock, " Escape from Tarkov is a story-based experience that challenges all comers to escape the city with their lives. Matches are session-based and inhabited not only by human players but AI-driven Scavs to fill the world – ensuring a constant air of danger)");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("prey", "Prey", "Bethesda Softworks",
                "fps", "2018", R.drawable.prey, "Prey is a first-person shooter video game developed by Arkane Studios and published by Bethesda Softworks. It was released worldwide on 5 May 2017, for Microsoft Windows, PlayStation 4 and Xbox One.");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("apex", "Apex", "Electronic Arts",
                "fps", "2018", R.drawable.apex_legends_cover, " Apex Legends is a free-to-play battle royale-hero shooter game developed by Respawn Entertainment and published by Electronic Arts. It was released for Microsoft Windows, PlayStation 4, and Xbox One in February 2019, and for Nintendo Switch in March 2021.");
        gameProducts.add(gameProduct);


        ////Puzzle Games////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gameProduct = new GameProduct("the_witness", "The Witness", "??? games",
                "puzzle", "2016", R.drawable.the_witness, "The Witness is a 2016 puzzle video game developed and published by Thekla, Inc.[a] Inspired by Myst, the game involves the exploration of an open world island filled with natural and man-made structures. The player progresses by solving puzzles, which are based on interactions with grids presented on panels around the island or paths hidden within the environment. The game provides no direct instructions for how these puzzles are to be solved, requiring the player to identify the meaning of symbols in the puzzles. A central design element to the game was how these puzzles are presented so that the player can achieve a moment of inspiration through trial and error and gain that comprehension themselves. Announced in 2009, The Witness had a lengthy development period. Jonathan Blow, the game's lead designer, started work on the title in 2008, shortly after releasing Braid. The financial success of Braid allowed him to hire a larger production team without ceding creative control over the final product. To create the game's visual language, the team developed their own game engine and retained artists, architects, and landscape architects to design the structures on the island. This required a protracted development process, and the game's release was delayed from 2013 to 2016. Blow desired to create a game around non-verbal communication, wanting players to learn from observation and to come to epiphanies in finding solutions and leading to a greater sense of involvement and accomplishment with each success. The game includes around 650 puzzles, though the player is not required to solve them all to finish the game. The Witness was released for Microsoft Windows and PlayStation 4 in January 2016, with later versions released for the Xbox One, Nvidia Shield, macOS, and iOS. Original plans for release on the PlayStation 3 and Xbox 360 were abandoned as the game engine became more demanding, and the team ultimately opted for an initial release on Windows and the PlayStation 4, with support for other platforms following. The Witness received generally favorable reviews from critics, who praised the difficult but surmountable puzzles and the game's art and setting. Within a week of release, the game had sold over 100,000 copies, which was about as many copies as Braid had done within a year of its release, nearly recouping all of the development costs for the game");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("tetris", "Tetris", "EA Mobile",
                "puzzle", "2000", R.drawable.tetris, "Tetris is a puzzle video game created by Soviet software engineer Alexey Pajitnov in 1984. It has been published by several companies for multiple platforms, most prominently during a dispute over the appropriation of the rights in the late 1980s");
        gameProducts.add(gameProduct);


        ////Roll-Playing-Games Games////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gameProduct = new GameProduct("fallout_76_steel_reign", "Fallout 76: steel reign", "Bethesda Game Studios",
                "rpg", "2021", R.drawable.fallout_76_steel_reign, "Steel Reign is the eighth major update for Fallout 76, following Locked & Loaded. It features the conclusion to the Brotherhood of Steel storyline introduced in Steel Dawn, as well as a system of crafting legendary items and the introduction of legendary power armor. It was followed by Fallout Worlds");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("god_of_war", "God of War: Ragnarök", "Sony Computer Entertainment",
                "rpg", "2022", R.drawable.gow, "In God of War, players control Kratos, a Spartan warrior who is sent by the Greek gods to kill Ares, the god of war. ... Armed with the Blades of Chaos, a weapon made out of two daggers attached to chains, Kratos rumbles through ancient Athens and other locations on a murderous quest to terminate the rogue god");
        gameProduct = new GameProduct("the_witcher_3_wild_hunt", "The Witcher 3: Wild Hunt", "CD Projekt RED",
                "rpf", "2015", R.drawable.witcher3, "The Witcher 3: Wild Hunt is the third and final installment in the series of games developed by CD Projekt RED featuring the witcher Geralt of Rivia. The game was originally scheduled for release in late 2014, then pushed back to 24 February 2015, and finally released on 19 May 2015.[3] During the first two weeks since release it had sold more than 4 million copies worldwide,[4] more than doubling the total sales of its predecessor, The Witcher 2: Assassins of Kings.[5]");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("cyberpunk", "Cyberpunk 2077", "CD Projekt RED",
                "rpg", "2021", R.drawable.cyberpunk, "Cyberpunk 2077 is an action role-playing video game developed and published by CD Projekt. The story takes place in Night City, an open world set in the Cyberpunk universe");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("dark_souls", "Dark Souls", "FromSoftware Inc.",
                "rpg", "2021", R.drawable.dark_souls_cover_art, "Dark Souls is a 2011 action role-playing game developed by FromSoftware and published by Namco Bandai Games. A spiritual successor to FromSoftware's Demon's Souls, the game is the second installment in the Souls series");
        gameProducts.add(gameProduct);


        ////sports Games////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gameProduct = new GameProduct("fifa21", "FIFA21", "EA Games",
                "sports", "2022", R.drawable.fifa_21, "FIFA is a series of association football video games developed and released annually by Electronic Arts under the EA Sports label. As of 2011, the FIFA franchise has been localised into 18 languages and available in 51 countries.");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("ufc_4", "UFC 4", "EA Games",
                "sports", "2019", R.drawable.ufc_4, "Like its predecessor, UFC 4 is a fighting game based on the mixed martial arts promotion Ultimate Fighting Championship (UFC). There are 229 unique fighters, with 81 alternate versions. The game features a career mode, which was designed to be an 'onboarding experience' to teach the player the basics of four MMA disciplines which include boxing, kickboxing, wrestling, and jiujitsu. The goal of the career mode, which allows players to create their own custom fighter, is to become the G.O.A.T. (which stands for 'greatest of all time''). As players progress in the game, they can choose to accept or decline fights, which will affect the development of the fighter's career. The control scheme was also improved and streamlined to make the game more accessible.[1] Multiplayer modes, including Blitz Battles, and Online World Championships, would also be available. In addition to fighting in the The Octagon, players can also fight in Backyard and Kumite, which resembles an underground fighting arena.[2] However, unlike its predecessor, Ultimate Team would not return in UFC 4.[3]");
        gameProducts.add(gameProduct);

        gameProduct = new GameProduct("steep", "Steep", "Ubisoft Montpellier,",
                "sports", "2020", R.drawable.steep, "Steep is a sports video game developed by Ubisoft Annecy and published by Ubisoft. It was released worldwide on 2 December 2016 for Microsoft Windows, PlayStation 4 and Xbox One. Developed by Ubisoft Annecy beginning in 2013, it was their first original game.");
        gameProducts.add(gameProduct);

        gameProduct = new GameProduct("nhl21", "NHL 21", "Electronic Arts",
                "sports", "2020", R.drawable.nhl_21_cover_art, "NHL 21 is an ice hockey simulation video game developed by EA Vancouver and published by EA Sports. It is the 30th installment in the NHL game series and was released for the PlayStation 4, PlayStation 5, and Xbox One consoles in October 2020.");
        gameProducts.add(gameProduct);


        ////Strategy Games////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gameProduct = new GameProduct("scom2", "Scom 2", " Feral Interactive",
                "strategy", "2016", R.drawable.scom2, "XCOM 2 is a 2016 turn-based tactics video game developed by Firaxis Games and published by 2K Games. ... XCOM, a military organization trying to fight off an alien invasion, has lost the war and is now a resistance force against the occupation of Earth and the established totalitarian regime and military dictatorship.");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("starcraft", "StarCraft II: Wings of Liberty", " Feral Interactive",
                "strategy", "2016", R.drawable.starcraft_ii___box_art, "StarCraft II: Wings of Liberty is a science fiction real-time strategy video game developed and published by Blizzard Entertainment. It was released worldwide in July 2010 for Microsoft Windows and Mac OS X.");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("civilization", "Civilization VI", " Ed Beach",
                "strategy", "2016", R.drawable.civilization_vi, "Sid Meier's Civilization VI is a turn-based strategy 4X video game developed by Firaxis Games, published by 2K Games, and distributed by Take-Two Interactive. The Mobile port was published by Aspyr Media. ");
        gameProducts.add(gameProduct);


        ////Survival Games////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        gameProduct = new GameProduct("rust", "Rust", "Double Eleven",
                "survival", "2013", R.drawable.rust, "ust is a multiplayer-only survival video game developed by Facepunch Studios. ... The objective of Rust is to survive in the wilderness using gathered or stolen materials. Players must successfully manage their hunger, thirst, and health, or risk dying.");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("escape_from_tarkov", "Escape From Tarkov", "Battlestate Games",
                "survival", "beta", R.drawable.escape_from_tarkov, " Escape from Tarkov is a story-based experience that challenges all comers to escape the city with their lives. Matches are session-based and inhabited not only by human players but AI-driven Scavs to fill the world – ensuring a constant air of danger)");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("scum", "Scum", "Devolver Digital",
                "survival", "2013", R.drawable.scum, "Scum is an upcoming multiplayer online survival game, developed by Croatian studio Gamepires, available under the Steam Early Access program. The game is described as a 'prison riot survival game' and will feature an open world.");
        gameProducts.add(gameProduct);
        gameProduct = new GameProduct("ark", "ARK: Survival Evolved", "Studio Wildcard",
                "survival", "2013", R.drawable.ark, "Ark: Survival Evolved is a 2017 action-adventure survival video game developed by Studio Wildcard. In the game, players must survive being stranded on an island filled with roaming dinosaurs and other prehistoric animals, natural hazards, and potentially hostile human players. ");
        gameProducts.add(gameProduct);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://androproj-a6872-default-rtdb.europe-west1.firebasedatabase.app/");

        for (GameProduct gameProduct1 : gameProducts) {
            DatabaseReference databaseRef = database.getReference("games").child(gameProduct1.getId());
            try {
//            databaseRef.setValue(databaseRef);
                databaseRef.setValue(gameProduct1);

            } catch (Exception e) {
                Log.e("tag", e.getMessage());
            }
        }
    }
}