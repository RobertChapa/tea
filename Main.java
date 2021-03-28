package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    //CHANCE: Returns true if greater then 5
    public static boolean chance() {
        Random rand = new Random();
        int chance = rand.nextInt(10);
        return chance > 5;
    }
    //DROP: Chances of an item dropping (much lower for difficult level) Returns array of items
    public static boolean[] drop(String enemy, int enemyHealth, int enemyDamage, int playerHealth, int playerDamage, int elixirCount, int elixirHealth, int wins, boolean[] items, int itemCount, int level) {
        //Level 2
        if (level == 2) {
            if (itemCount < 4) {
                items[wins-1] = true;
            }
        }
        //Level 3
        if (level == 3) {
            boolean chance = chance();
            if ((chance) && (itemCount < 4)) {
                items[wins-1] = true;
            }
        }
        return items;
    }
    //CHOICE: Registers user selections for combat
    public static int[] choice(String enemy, int enemyHealth, int enemyDamage, int playerHealth, int playerDamage, int elixirCount, int elixirHealth, int wins, boolean[] items, int itemCount, int level) {
        //ASK: Gets user input
        Scanner scnr = new Scanner(System.in);
        System.out.println("What would you like to do?\n\t> 1: Fight\n\t> 2: Drink elixir\n\t> 3: Run");
        String userInput = scnr.next();
        //FIGHT
        switch (userInput) {
            case "1": {
                int[] returned = fight(enemy, enemyHealth, enemyDamage, playerHealth, playerDamage, elixirCount, elixirHealth, wins, items, itemCount, level);
                if (level == 3)
                    playerHealth = returned[0];
                elixirCount = returned[1];
                wins = returned[2];
                itemCount = returned[3];
                return new int[]{playerHealth, elixirCount, wins, itemCount};
            }
            //ELIXIR
            case "2": {
                int[] returned = elixir(enemy, enemyHealth, enemyDamage, playerHealth, playerDamage, elixirCount, elixirHealth, wins, items, itemCount, level);
                if (level == 3)
                    playerHealth = returned[0];
                elixirCount = returned[1];
                wins = returned[2];
                itemCount = returned[3];
                return new int[]{playerHealth, elixirCount, wins, itemCount};
            }
            //RUN/SKIP
            case "3":
                System.out.println("You chose to run.\nHere comes another enemy!");
                break;
            //NOTHING SELECTED
            default:
                System.out.println("What would you like to do?\n\t> 1: Fight\n\t> 2: Drink elixir\n\t> 3: Run");
                userInput = scnr.next();
                break;
        }
        return new int[]{playerHealth, elixirCount, wins, itemCount};
    }
    //FIGHT: Possible fighting outcomes
    public static int[] fight(String enemy, int enemyHealth, int enemyDamage, int playerHealth, int playerDamage, int elixirCount, int elixirHealth, int wins, boolean[] items, int itemCount, int level) {
        System.out.println("You've chosen to fight!");
        playerHealth = playerHealth - enemyDamage;
        enemyHealth = enemyHealth - playerDamage;
        //FIGHT: Player died
        if (playerHealth <= 0) {
            playerHealth = 0;
            System.out.println("You lost.");
            int[] returned = {50, elixirCount, wins, itemCount};
            if (level == 3)
                playerHealth = returned[0];
            elixirCount = returned[1];
            wins = returned[2];
            itemCount = returned[3];
            return new int[]{playerHealth, elixirCount, wins, itemCount};
        }
        //FIGHT: Enemy died
        else if (enemyHealth <= 0) {
            System.out.println("You won! You now have " +playerHealth+ " HP!");
            wins += 1;
            items = drop(enemy, enemyHealth, enemyDamage, playerHealth, playerDamage, elixirCount, elixirHealth, wins, items, itemCount, level);
            if (items[wins - 1] ||wins==4)
                itemCount += 1;
            int[] returned = {playerHealth, elixirCount, wins, itemCount};
            if (level == 3)
                playerHealth = returned[0];
            elixirCount = returned[1];
            wins = returned[2];
            itemCount = returned[3];
            return new int[]{playerHealth, elixirCount, wins, itemCount};
        }
        //FIGHT: No ones dead yet
        else {
            System.out.println("The " +enemy+ " now has " +enemyHealth+ " HP!\nYou now have " +playerHealth+ " HP!\n");
            int[] returned = choice(enemy, enemyHealth, enemyDamage, playerHealth, playerDamage, elixirCount, elixirHealth, wins, items, itemCount, level);
            if (level == 3)
                playerHealth = returned[0];
            elixirCount = returned[1];
            wins = returned[2];
            itemCount = returned[3];
        }
        return new int[]{playerHealth, elixirCount, wins, itemCount};
    }
    //ELIXIR: Health potion
    public static int[] elixir(String enemy, int enemyHealth, int enemyDamage, int playerHealth, int playerDamage, int elixirCount, int elixirHealth, int wins, boolean[] items, int itemCount, int level) {
        //ELIXIR: use
        if (elixirCount > 0) {
            elixirCount -= 1;
            playerHealth += elixirHealth;
            System.out.println("You drank an elixir giving you " + playerHealth + " HP! You now have " + elixirCount + " elixir.");
            int[] returned = choice(enemy, enemyHealth, enemyDamage, playerHealth, playerDamage, elixirCount, elixirHealth, wins, items, itemCount, level);
            if (level == 3)
                playerHealth = returned[0];
            elixirCount = returned[1];
            wins = returned[2];
            itemCount = returned[3];
        }
        //ELIXIR: empty
        else if (elixirCount <= 0) {
            System.out.println("You are out of elixir!");
            int[] returned = choice(enemy, enemyHealth, enemyDamage, playerHealth, playerDamage, elixirCount, elixirHealth, wins, items, itemCount, level);
            if (level == 3)
                playerHealth = returned[0];
            elixirCount = returned[1];
            wins = returned[2];
            itemCount = returned[3];
        }
        return new int[]{playerHealth, elixirCount, wins, itemCount};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean running = false;
        boolean[] items = new boolean[] {false, false, false, false};
        String playerName;
        int randomEnemy;
        int randomEnemyDamage;
        int randomEnemyHealth;
        int playerHealth = 100;
        int itemCount = 0;
        int randomPlayerDamage;
        int elixirCount = 3;
        int wins = 0;

        System.out.println("Ready to play Text Embarked/Executed Adventure(TEA)?");
        String game = scan.next();
        System.out.println("Please enter a name: ");
        playerName = scan.next();

        String yes = "yes";
        String no = "no";

        if(game.equals(yes))
        {
            System.out.println("Hello " +playerName+ ", please select a difficulty\n\t> 1: Beginner\n\t> 2: Hard");
            String worldChoice = scan.next();
            while (!running) {
                if (worldChoice.equals("1"))
                    running = true;
                else if (worldChoice.equals("2"))
                    running = true;
                else {
                    System.out.println("Hello " +playerName+ ", please select a difficulty\n\t> 1: Beginner\n\t> 2: Hard");
                    worldChoice = scan.next();
                    running = false;
                }
            }
            System.out.println("Let's goooooo! Enter go to start: ");
            String go = scan.next();
            System.out.println("Description: The last of the world's old magic has nearly disappeared from the world. All that’s left are a handful of items that had previously been enchanted by the last Grand Witch.");
            System.out.println("Objective of the game: Acquire all the magic items left in the world to reignite the ‘Well of Magic’ and bring magic back into the world. Type next to continue: ");

            String next = scan.next();
            System.out.println("\"THE GRAND WITCH HAS BEEN LAID TO REST\"\r\n");
            String myLine = scan.nextLine();
            System.out.println("The voice echoes in your mind... You wonder who that was... What that was...");
            myLine = scan.nextLine();
            System.out.println("What do you do?");
            myLine = scan.nextLine();
            System.out.println("\t> 1: Ask your sister if she heard that");
            System.out.println("\t> 2: Ask the void if anybody is there");
            System.out.println("\t> 3: Ask yourself if it was real");
            int myInteger = scan.nextInt();

            if(myInteger == 1)
            {
                System.out.println("\"Yup. Guess the Grand Witch is dead.\"");
                myLine = scan.nextLine();
                System.out.println("\"The who?\"");
                myLine = scan.nextLine();
                System.out.println("\"The Grand Witch. Dust. Puddle.\"");
                myLine = scan.nextLine();
                System.out.println("\"?\"");
                myLine = scan.nextLine();
                System.out.println("\"Remember? We went to that day camp that one year and we got split up because I was older, and you went with the other kids to play witch. \nThey told us all about the Grand Witch, the High Council, and how magic was real and we even got to try riding brooms?\"");
                myLine = scan.nextLine();
                System.out.println("\"All we did was play dress up and pretend to cast spells with fake wands! And whats this about magic?\"");
                myLine = scan.nextLine();
                System.out.println("\"Yeah, like they went over it. Simple magic, advanced magic, magic cheats, etc... Not many bloodlines left, screening for magic potential, broom test.\"");
                myLine = scan.nextLine();
                System.out.println("\"Broom test?\"");
                myLine = scan.nextLine();
                System.out.println("\"Yeah, like in that scene in Harry Potter with the brooms. Even being able to call a broom to yourself was impressive. I was like one of three that could. \nCan't really do it anymore. Old magics gone.\"");
                myLine = scan.nextLine();
                System.out.println("\">:O\"");
                myLine = scan.nextLine();
                System.out.println("\"Did they not go over that in the kids class?\"");
                myLine = scan.nextLine();
                System.out.println("\"NoO! None of that! I never saw you do any of that stuff.\"");
                myLine = scan.nextLine();
                System.out.println("\"Oh yeah, no, of course not. They had the Grand Witch there just to amplify any nearby magic and still few of us could only summon a broom. \nThat was about it. It was cool, but uneventful. When I got home I could barely knock over a broom from a distance.\"");
                myLine = scan.nextLine();
                System.out.println("\">:O\"");
                myLine = scan.nextLine();
                System.out.println("\"Didn't mom take you back the next year to learn all this stuff?\"");
                myLine = scan.nextLine();
                System.out.println("\"NoooOO!\"");
                myLine = scan.nextLine();
                System.out.println("\"Oh... welp... exposition.\"");
                myLine = scan.nextLine();
                System.out.println("What next?\n\t> 1: Ask Mom\n\t> 2: Take more time to process this\n\t> 3: Ah don't believe it");
                myInteger = scan.nextInt();

                if(myInteger == 1)
                {
                    System.out.println("\"Hey so what's this about magic.\"");
                    myLine = scan.nextLine();
                    System.out.println("\"Oh yeah, the Grand Witch will be missed dearly!\"");
                    myLine = scan.nextLine();
                    System.out.println("\"No! Why is this the first time I'm hearing about this?\"");
                    myLine = scan.nextLine();
                    System.out.println("\"What do you mean? Didn't you go to witch camp forever ago?\"");
                    myLine = scan.nextLine();
                    System.out.println("\"No!\"");
                    myLine = scan.nextLine();
                    System.out.println("\"Oh... well if you want to get up to date and still try magic stuff, they're taking interns right now to try to reignite the Well of Magic.\"");
                    myLine = scan.nextLine();
                    System.out.println("\"Really!? Who do I speak to about that?\"");
                    myLine = scan.nextLine();
                    System.out.println("\"The High Council. Here, they owe me a favor anyway. I'll call them up. You should meet them in the back of the fabric store downtown.\"");
                    myLine = scan.nextLine();
                    System.out.println("What next?\n\t> 1: Go downtown\n\t> 2: Take a nap, then go downtown.");
                    myInteger = scan.nextInt();

                    if(myInteger == 1)//roll for internship
                    {
                        System.out.println("\"Hello, I'm here for the internship.\"");
                        myLine = scan.nextLine();
                        System.out.println("\"Ah yes, we've been expecting you. Your first so it's all yours. Not many younglings left even interested in this kind of thing. \nAnyway, the first thing you need to pickup is $18k in perfume. We're not paying for it. Figure it out.\"");
                        myLine = scan.nextLine();
                        System.out.println("\"Why perfume?\"");
                        myLine = scan.nextLine();
                        System.out.println("*sigh*\n\"Okay, so the Grand Witch had a familiar...\"");
                        myLine = scan.nextLine();
                        System.out.println("\"Yes\"");
                        myLine = scan.nextLine();
                        System.out.println("\"And this familiar was just a whale she had enchanted...\"");
                        myLine = scan.nextLine();
                        System.out.println("*Gives tedious look*");
                        myLine = scan.nextLine();
                        System.out.println("\"But it was hunted by whalers, made into various goods, and sold off piece by piece. \nNow all that's left is its ambergris, which was used to make this batch of perfumes, but one case should be enough for the spell.\"");
                        myLine = scan.nextLine();
                        System.out.println("\"And so you want me to steal $18k worth of perfume?\"");
                        myLine = scan.nextLine();
                        System.out.println("\"You don't have to steal it.\"");
                        myLine = scan.nextLine();
                        System.out.println("\"Because there's a little bit of magic whale in it?\"");
                        myLine = scan.nextLine();
                        System.out.println("\"Yes, it's being shipped to a perfume store about 8 miles from here.\"");
                        myLine = scan.nextLine();
                        System.out.println("...");
                        myLine = scan.nextLine();
                        System.out.println("*At the perfume store*");
                        myLine = scan.nextLine();
                        System.out.println("\"The truck with the shipment is still loaded... may as well just steal the whole truck.\"");
                        myLine = scan.nextLine();
                        ///////////////Enter fight
                        while (running) {
                            //BEGINNER
                            if (worldChoice.equals("1")) {
                                System.out.println("\n--------------------------------------------------\n");
                                //ENEMY: set up
                                randomPlayerDamage = rand.nextInt(25+((itemCount+1)*15));
                                String[] enemies = new String[] {"Driver", "Night Guard", "TA", "Science Teacher"};
                                randomEnemy = 0;
                                int[] enemyDamage = new int[] {15, 30, 40, 45};
                                randomEnemyDamage = rand.nextInt(enemyDamage[randomEnemy])+10;
                                int[] enemyHealth = new int[] {50, 75, 90, 150};
                                randomEnemyHealth = rand.nextInt(enemyHealth[randomEnemy])+25;
                                if(randomEnemy == 3)
                                    randomEnemyHealth = 150;
                                //ENEMY: appearance
                                System.out.println("You're approached by a " +enemies[randomEnemy]+  " with " +randomEnemyHealth+ " HP!\nYou currently have " +playerHealth+ " HP, " +elixirCount+ " elixir, and " +itemCount+ " items!");
                                //USER: updated stats
                                int[] returned = choice(enemies[randomEnemy], randomEnemyHealth, randomEnemyDamage, playerHealth, randomPlayerDamage, elixirCount, 15, wins, items, itemCount, 2);
                                elixirCount = 3;
                                wins = returned[2];
                                itemCount = returned[3];
                                randomPlayerDamage = rand.nextInt(playerHealth+10);
                                //END GAME
                                if (itemCount >= 1)
                                    running = false;
                            }
                            //ADVANCED
                            if (worldChoice.equals("2")) {
                                System.out.println("\n--------------------------------------------------\n");
                                //PLAYER: set up
                                randomPlayerDamage = playerHealth+15;
                                //ENEMY: set up
                                String[] enemies = new String[] {"Driver", "Night Guard", "TA", "Science Teacher"};
                                randomEnemy = 0;
                                int[] enemyDamage = new int[] {15, 30, 40, 45};
                                randomEnemyDamage = rand.nextInt(enemyDamage[randomEnemy])+10;
                                int[] enemyHealth = new int[] {50, 75, 90, 150};
                                randomEnemyHealth = rand.nextInt(enemyHealth[randomEnemy])+25;
                                if(randomEnemy == 3)
                                    randomEnemyHealth = 150;
                                //ENEMY: appearance
                                System.out.println("You're approached by a " +enemies[randomEnemy]+  " with " +randomEnemyHealth+ " HP!\nYou currently have " +playerHealth+ " HP!");
                                //USER: updated stats
                                int[] returned = choice(enemies[randomEnemy], randomEnemyHealth, randomEnemyDamage, playerHealth, randomPlayerDamage, elixirCount, 15, wins, items, itemCount, 3);
                                playerHealth = returned[0];
                                elixirCount = returned[1];
                                wins = returned[2];
                                itemCount = returned[3];
                                randomPlayerDamage = rand.nextInt(playerHealth+10);
                                //END GAME
                                if (itemCount >= 1)
                                    running = false;
                            }
                        }
                        ///////////////win fight
                        System.out.println("                                                                                                                      ./&@@@@@@%                                                    ");
                        System.out.println("                                                                             &#                           .@@@@(((((((((((((((((((((@@                                              ");
                        System.out.println("                                                                            @,*@                   (@@%((((((((((((((((((((((((((((((((@@                                           ");
                        System.out.println("                                                                            @*/@               @@((((((((((((((((((((((((((((((((((((((((@&                                         ");
                        System.out.println("                                                                        @#*,,*****&@         @(((((((((((((((((((((((((((((((((((((((((((((@                                        ");
                        System.out.println("                                                                      ,@*,,,,*******@      &%(((((((((((((((((((((((((((((((((((((((((((((((@                                       ");
                        System.out.println("                                                                      @(/****///////%@#####@((((((((((((((((((((((((((((((((((((((((((((((((@                                       ");
                        System.out.println("                                                                      @/*,,,,*******%&***,/%((((((((((((((((((((((((((((((((((((((((((((((((&#                                      ");
                        System.out.println("                                                                      @##((((#######&%     @((((((((((((((((((((((((((((((((((((((((((((((((@                                       ");
                        System.out.println("                                                                          @,,,***@          @((((((((((((((((((((((((((((((((((((((((((((((%@                                       ");
                        System.out.println("                                                                           @,,**@            @@(((((((((((((((((((((((((((((((((((((((((((&%                                        ");
                        System.out.println("                                                                          @/,,**@#              @@%((((((((((((((((((((((((((((((((((((((@                                          ");
                        System.out.println("                                                                       @@@@@@@@@@@@@@                 @@@(((((((((((((((((((((((((((((@@                                            ");
                        System.out.println("                                                                      #@%%###%%%%%%%@.                        #@@@@%(((((((((((((%@@                                                ");
                        System.out.println("                                                                      @/**,,,*******%%                                                                                              ");
                        System.out.println("                                                                  @%****,,,,,***********/@                                                                                          ");
                        System.out.println("                                                                 ,&****,,,,,,************(@                                                                                         ");
                        System.out.println("                                                                 ,&****,,,,,,************(@                                                                                         ");
                        System.out.println("                                                                 ,&****,,,,,,************(@                                                                                         ");
                        System.out.println("                                                                 ,&****,,,,,,************(@                                                                                         ");
                        System.out.println("                                                  *##############%&****,,,,,,************(@##############/                                                                          ");
                        System.out.println("                                                @                 ..........@..@..........                 @                                                                        ");
                        System.out.println("                                                @  @                       /@  @                        @  &,                                                                       ");
                        System.out.println("                                                @  @                       %(  @                        @  &,                                                                       ");
                        System.out.println("                                                @  @,,,,,,,,,,,,,,,,,,,,,,,&/..@,,,,,,,,,,,,,,,,,,,,,,,,@  &,                                                                       ");
                        System.out.println("                                                @  &*,,,.@((((((((((((((((((((((((((((((((((((((((&(,,,,@  &,                                                                       ");
                        System.out.println("                                                @  #@,,,.@( ((((((((((((((((((((((((((((((((((((((&(,,,(&  &,                                                                       ");
                        System.out.println("                                                @  ,@,,,.@( ((( .(.((( (( ( /(.(  ( ,((/. ( ((((((&(,,,&*  &,                                                                       ");
                        System.out.println("                                                @  .@,,,.@( ((((((((((((((((((((((((((((((((((((((&(,,,@.  &,                                                                       ");
                        System.out.println("                                                @   @,,,.@( (((((((.(.(,(/,(*(, .(**, ,.(*((((((((&(,,,@   &,                                                                       ");
                        System.out.println("                                                @   @,,,.@( ((((((((((((((((((((((((((((((((((((((&(,,,@   &,                                                                       ");
                        System.out.println("                                                @   @,,,.@( ((((((((((((((((((((((((((((((((((((((&(,,,@   &,                                                                       ");
                        System.out.println("                                                @   @,,,.@( ((((((((((((((((((((((((((((((((((((((&(,,,@   &,                                                                       ");
                        System.out.println("                                                @   @,,,.@( (((((((((((((((.((., (((((((((((((((((&(,,,@   &,                                                                       ");
                        System.out.println("                                                @   @,,,.@( ((((((((((((((((((((((((((((((((((((((&(,,,@   &,                                                                       ");
                        System.out.println("                                                @   @,,,.@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@(,,,@   &,                                                                       ");
                        System.out.println("                                                @   @,,,,,,,,,,,,,,,,,,,,,@../%,,,,,,,,,,,,,,,,,,,,,,,,@   &,                                                                       ");
                        System.out.println("                                                @   @,,,,,,,,,,,,,,,,,,,,,@..&(,,,,,,,,,,,,,,,,,,,,,,,,@   &,                                                                       ");
                        System.out.println("                                                @   @,,,,,,,,,,,,,,,,,,,,,@..@,,,,,,,,,,,,,,,,,,,,,,,,,@   &,                                                                       ");
                        System.out.println("                                                @   @,,,,,,,,,,,,,,,,,,,,,@..@.,,,,,,,,,,,,,,,,,,,,,,,,@   &,                                                                       ");
                        System.out.println("                                                @   @,,,,,,,,,,,,,,,,,,,,,@..@,,,,,,,,,,,,,,,,,,,,,,,,,@   &,                                                                       ");
                        System.out.println("                                                @   @,,,,,,,,,,,,,,,,,,,,/&..@,,,,,,,,,,,,,,,,,,,,,,,,,@   &,                                                                       ");
                        System.out.println("                                                @  .@,,,,,,,,,,,,,,,,,,,,@/. @,,,,,,,,,,,,,,,,,,,,,,,,,@.  &,                                                                       ");
                        System.out.println("                                                @  ,@,,,,,,,,,,,,,,,,,,,,@..%%,,,,,,,,,,,,,,,,,,,,,,,,,&/  &,                                                                       ");
                        System.out.println("                                                @  #@,,,,,,,,,,,,,,,,,,,,@..@.,,,,,,,,,,,,,,,,,,,,,,,,,/@  &,                                                                       ");
                        System.out.println("                                                @  &,,,,,,,,,,,,,,,,,,,,,.,(@,,,,,,,,,,,,,,,,,,,,,,,,,,,@  &,                                                                       ");
                        System.out.println("                                                @  @,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,@  &,                                                                       ");
                        System.out.println("                                                @  @,,,,,,,,,,.#@@@@@@@(,          .*%@@@@@@&*.,,,,,,,,,@  &,                                                                       ");
                        System.out.println("                                                @   @@@(                                            (@@@*  &,                                                                       ");
                        System.out.println("                                                @                                                          &,                                                                       ");
                        System.out.println("                                                 @@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&@,                                                                        ");
                        myLine = scan.nextLine();
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("...");
                        myLine = scan.nextLine();
                        System.out.println("*At the fabric store*");
                        myLine = scan.nextLine();
                        System.out.println("\"Very good, now your next job is to retrieve the Ruby Kicks from the Grand Witch's hoard.\"");
                        myLine = scan.nextLine();
                        System.out.println("\"Which is where? And what?\"");
                        myLine = scan.nextLine();
                        System.out.println("\"She kept a storage unit down town, the shoes are probably there.\"");
                        myLine = scan.nextLine();
                        System.out.println("...");
                        myLine = scan.nextLine();
                        System.out.println("*At the storage units*");
                        myLine = scan.nextLine();
                        //roll, 1-20, if x>15
                        //roll, 1-20, if x>10
                        //roll, 1-20, if x>5 fight anyway
                        //fight
                        boolean chance1 = chance();
                        // System.out.println(chance1);
                        boolean chance2 = chance();
                        // System.out.println(chance2);
                        boolean chance3 = chance();
                        // System.out.println(chance3);
                        if (chance1 || chance2 || chance3)
                        {
                            System.out.println("You narrowly avoided some guards.");
                            myLine = scan.nextLine();
                            running = true;
                        }
                        else
                        {
                            System.out.println("HEY!");
                            myLine = scan.nextLine();
                            running = true;
                        }
                        ///////////////Enter fight
                        while (running) {
                            //BEGINNER
                            if (worldChoice.equals("1")) {
                                System.out.println("\n--------------------------------------------------\n");
                                //ENEMY: set up
                                randomPlayerDamage = rand.nextInt(25+((itemCount+1)*15));
                                String[] enemies = new String[] {"Driver", "Night Guard", "TA", "Science Teacher"};
                                randomEnemy = 1;
                                int[] enemyDamage = new int[] {15, 30, 40, 45};
                                randomEnemyDamage = rand.nextInt(enemyDamage[randomEnemy])+10;
                                int[] enemyHealth = new int[] {50, 75, 90, 150};
                                randomEnemyHealth = rand.nextInt(enemyHealth[randomEnemy])+25;
                                if(randomEnemy == 3)
                                    randomEnemyHealth = 150;
                                //ENEMY: appearance
                                System.out.println("You're approached by a " +enemies[randomEnemy]+  " with " +randomEnemyHealth+ " HP!\nYou currently have " +playerHealth+ " HP, " +elixirCount+ " elixir, and " +itemCount+ " items!");
                                //USER: updated stats
                                int[] returned = choice(enemies[randomEnemy], randomEnemyHealth, randomEnemyDamage, playerHealth, randomPlayerDamage, elixirCount, 15, wins, items, itemCount, 2);
                                elixirCount = 3;
                                wins = returned[2];
                                itemCount = returned[3];
                                randomPlayerDamage = rand.nextInt(playerHealth+10);
                                //END GAME
                                if (itemCount >= 2)
                                    running = false;
                            }
                            //ADVANCED
                            if (worldChoice.equals("2")) {
                                System.out.println("\n--------------------------------------------------\n");
                                //PLAYER: set up
                                randomPlayerDamage = playerHealth+15;
                                //ENEMY: set up
                                String[] enemies = new String[] {"Driver", "Night Guard", "TA", "Science Teacher"};
                                randomEnemy = 1;
                                int[] enemyDamage = new int[] {15, 30, 40, 45};
                                randomEnemyDamage = rand.nextInt(enemyDamage[randomEnemy])+10;
                                int[] enemyHealth = new int[] {50, 75, 90, 150};
                                randomEnemyHealth = rand.nextInt(enemyHealth[randomEnemy])+25;
                                if(randomEnemy == 3)
                                    randomEnemyHealth = 150;
                                //ENEMY: appearance
                                System.out.println("You're approached by a " +enemies[randomEnemy]+  " with " +randomEnemyHealth+ " HP!\nYou currently have " +playerHealth+ " HP!");
                                //USER: updated stats
                                int[] returned = choice(enemies[randomEnemy], randomEnemyHealth, randomEnemyDamage, playerHealth, randomPlayerDamage, elixirCount, 15, wins, items, itemCount, 3);
                                playerHealth = returned[0];
                                elixirCount = returned[1];
                                wins = returned[2];
                                itemCount = returned[3];
                                randomPlayerDamage = rand.nextInt(playerHealth+10);
                                //END GAME
                                if (itemCount >= 2)
                                    running = false;
                            }
                        }
                        ///////////////win fight
                        System.out.println("*Opens and searches storage unit*");
                        myLine = scan.nextLine();
                        System.out.println("                                           /*/                                                                                                                                      ");
                        System.out.println("            ###.                         ###(###.                                                                                                                                   ");
                        System.out.println("            (,(%#% ###%,,..       ,,,//#//###(#((#,**%#(*,*.                                                                                                                        ");
                        System.out.println("             #%#####./####(#,%/(#%%####%#%#*.%##%%#%#/.#/#,/,                                                                                                                       ");
                        System.out.println("             ####################%*%*#/,(&##(%%#%%%%%%%%%&%&%*,                                                                                                                     ");
                        System.out.println("              #%#################%#%###%%%%%%%##%%# ,(,,(##%#%,#                                                                                                                    ");
                        System.out.println("             ,#############(######%%%%%%%%%%%%%%*%%% &%, *#%#&##(                                                                                                                   ");
                        System.out.println("             ########################%%%%#%%%%%%% ###%%&%###%###%,                                                                                                                  ");
                        System.out.println("             #########################%%%%###%%%##%%########(##%% .                                                                                                                 ");
                        System.out.println("             ###########################%%###%%%%%*%%%#### .,  .   ..                                                                                                               ");
                        System.out.println("             #######################%%%#%######%%%% % ###%./. ... %&&(                                                                                                              ");
                        System.out.println("             #&######################%%#####%##%#%%%%%#%#%#.**.%#%##%#.  %(*                                                                                                        ");
                        System.out.println("             (######################%###%###########%#%&####%#####%###      .                                                                                                       ");
                        System.out.println("            .%################%%%###%%%%##############%#%.%%#####%./    .... .  #*                                                                                                  ");
                        System.out.println("            #####(#############%%%%#%%%%#%##########%%#%#%#%#%## ,/*,  .&#%#&# .%*                                                                                                  ");
                        System.out.println("           #####################%#%%%%#%%%%%#%######%##%%#/#.#%%%  .,,%%#%####(                                                                                                     ");
                        System.out.println("         /#&#########%########%#%%%%#%%%%%%%############%#%%&#&#%%%%##%%####%  ..  &#                                                                                               ");
                        System.out.println("        (#%###################%########%%%#%#############%%%%%%%%#%%#####,,......#%%##*.                                                                                            ");
                        System.out.println("        %%#####(##(##(###############%#%#%%###(##########%%%#%#%%&#%%%#%%.&&*//%%%#####      #   #.                                                                                 ");
                        System.out.println("      *#################################################%%%%%%%#%&#%###%%%#..&%######   .. #.#, ..#                                                                                 ");
                        System.out.println("     %#&##########(##((####%%%##########%%%###########%#%%%%%%##%%%##%@#########%#.,... .%####*%#      *  (/,                                                                       ");
                        System.out.println("     #%##################%############################%%%%%%###%%%####%%#.%%######  &&. %#%####.     #%(#,  #                                                                       ");
                        System.out.println("    ######(################%#####(#(###%%%############%%%%%##%#%%######%##(%##%####%######### ,.,..%###((#%%     *                                                                  ");
                        System.out.println("   %#########################%####(####################%%%%%###%##%%####%######.##((#########  &&, %######(    #((//(/    (#(((((((                                                 ");
                        System.out.println("   #%################(#####%####(#(###########%#######%##%%%#%##%#########%%%######%(%#&#&%#############..,,.  ####(#*   .*(,.#((((#..          .       %(                          ");
                        System.out.println("   ###################################################%%%%%%%%###%%%%%##############%#####//%#//##########,* ,%#####.*.,.,####/.#/(#(.                 %/..                         ");
                        System.out.println("  .%#############################(##%%#%%%%############%%%%%%#%%############%%###################% ,%#%%# %##########, %..&%##%###&% *. .    .    .@//  . ..                        ");
                        System.out.println("  *&##################################%##%############%####%##%#######%%%%##################################(*/#####.#(#######,##*##.#*(......%(#/... .........                     ");
                        System.out.println("  &&#####################%%###########%%%######################%#%#%%%%%%%#%%%%###%%%%#%#################################%#(* &######%*&%%&.... .... .....,.,..,                    ");
                        System.out.println("  ...&%&%%##%%%##%#####################%%%%%#%############%%%%%%#%####%#%%##%%####%%%%%%%%#%%#########################%######(&%%(%@,......, .......,,.,...,,.,,                    ");
                        System.out.println("  *........... .@&%&&%&&%%%%%&%%%#%%%%%%%%%%#%######%#######%%%%%%%#%%%%%%%%%%%%%##%%%%%%##%%%###%%%%%#%%##%%/(%%%#%%%%@&  ..,. ..., ,, ..,...,.,..,,,....,*..*,                    ");
                        System.out.println("  ,.,. ........................................ ..   ...,/(#%&&@&&@@@&&&&&@&@@&@@@@@&&&&%%###(((/(/*,.   ............... ., .,.......,......,,......,.,,,,,,,*                      ");
                        System.out.println(" & .,.............,.  .,,.........,,...............,...............................................................,, ...*,.,..,...,.,,,.....,..**,.,,.,,*                          ");
                        System.out.println(" ,#.@%&%..........,........,..,,,,,,,,,.,,,,....,..........,,.........................................................,,,....,....,,..,,,....,,,,*,,,..                             ");
                        System.out.println("  ......., *&&&%%&%&&&%&@#,..,,,*,,,,*,,,,..,,,,.,,,,,,,,,,..,....,,...,..........................,........,,,,,. .#@&& ,,,,..,,,,.,,.,..,,.,,**,,..                                ");
                        System.out.println("  ./, ...........,.,.,,,,,.,,,,,,.,,,,,,,,,,,,,,,,,,,,,.....,*(#&&&&&&%&&%%%&%&&%%%%&&&&&&&&&&&%&&&&&&&&&&&&&%(,..,,.,,.,,,,,,,,.,.,..(%(((((//*,,.                                 ");
                        System.out.println("       .,(%&@%(,  ..,.,.....,.,,..,,,.,.,,,,,..,,,,,,..,,,,,,,,..,,..,....,,............,..,..............,,..,.,..,.,,,.../&&%%%%#####((/**...                                     ");
                        System.out.println("                                                         ...*(/((#%&&&&&&@@@@&%#((**,,..   ...   ..   .,/(%&&@&@&&&&&&&&&&&&%%%###(//*,.                                            ");
                        myLine = scan.nextLine();
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("...");
                        myLine = scan.nextLine();
                        System.out.println("*Back at the fabric store*");
                        myLine = scan.nextLine();
                        System.out.println("\"Wow, these are nicer than I remember.\"");
                        myLine = scan.nextLine();
                        System.out.println("\"That was a lot of trouble for some shoes.\"");
                        myLine = scan.nextLine();
                        System.out.println("\"Okay, your next item is the piece of wand that was stolen from the Grand Witch by the science teacher.\"");
                        myLine = scan.nextLine();
                        System.out.println("\"A science teacher?\"");
                        myLine = scan.nextLine();
                        System.out.println("\"Yeah, it's partially petrified it's so old. He shows it off to his students when they learn about fossils.\"");
                        myLine = scan.nextLine();
                        System.out.println("\"?\"");
                        myLine = scan.nextLine();
                        System.out.println("\"It's probably in his desk at the school. Good luck.\"");
                        myLine = scan.nextLine();
                        System.out.println("...");
                        myLine = scan.nextLine();
                        System.out.println("*Treading the halls of the school*");
                        myLine = scan.nextLine();
                        System.out.println("...");
                        myLine = scan.nextLine();
                        System.out.println("*From the shadows, a man approaches*");
                        myLine = scan.nextLine();
                        running = true;
                        //ta fight ensues
                        ///////////////Enter fight
                        while (running) {
                            //BEGINNER
                            if (worldChoice.equals("1")) {
                                System.out.println("\n--------------------------------------------------\n");
                                //ENEMY: set up
                                randomPlayerDamage = rand.nextInt(25+((itemCount+1)*15));
                                String[] enemies = new String[] {"Driver", "Night Guard", "TA", "Science Teacher"};
                                randomEnemy = 2;
                                int[] enemyDamage = new int[] {15, 30, 40, 45};
                                randomEnemyDamage = rand.nextInt(enemyDamage[randomEnemy])+10;
                                int[] enemyHealth = new int[] {50, 75, 90, 150};
                                randomEnemyHealth = rand.nextInt(enemyHealth[randomEnemy])+25;
                                if(randomEnemy == 3)
                                    randomEnemyHealth = 150;
                                //ENEMY: appearance
                                System.out.println("You're approached by a " +enemies[randomEnemy]+  " with " +randomEnemyHealth+ " HP!\nYou currently have " +playerHealth+ " HP, " +elixirCount+ " elixir, and " +itemCount+ " items!");
                                //USER: updated stats
                                int[] returned = choice(enemies[randomEnemy], randomEnemyHealth, randomEnemyDamage, playerHealth, randomPlayerDamage, elixirCount, 15, wins, items, itemCount, 2);
                                elixirCount = 3;
                                wins = returned[2];
                                itemCount = returned[3];
                                randomPlayerDamage = rand.nextInt(playerHealth+10);
                                //END GAME
                                if (itemCount >= 3)
                                    running = false;
                            }
                            //ADVANCED
                            if (worldChoice.equals("2")) {
                                System.out.println("\n--------------------------------------------------\n");
                                //PLAYER: set up
                                randomPlayerDamage = playerHealth+15;
                                //ENEMY: set up
                                String[] enemies = new String[] {"Driver", "Night Guard", "TA", "Science Teacher"};
                                randomEnemy = 2;
                                int[] enemyDamage = new int[] {15, 30, 40, 45};
                                randomEnemyDamage = rand.nextInt(enemyDamage[randomEnemy])+10;
                                int[] enemyHealth = new int[] {50, 75, 90, 150};
                                randomEnemyHealth = rand.nextInt(enemyHealth[randomEnemy])+25;
                                if(randomEnemy == 3)
                                    randomEnemyHealth = 150;
                                //ENEMY: appearance
                                System.out.println("You're approached by a " +enemies[randomEnemy]+  " with " +randomEnemyHealth+ " HP!\nYou currently have " +playerHealth+ " HP!");
                                //USER: updated stats
                                int[] returned = choice(enemies[randomEnemy], randomEnemyHealth, randomEnemyDamage, playerHealth, randomPlayerDamage, elixirCount, 15, wins, items, itemCount, 3);
                                playerHealth = returned[0];
                                elixirCount = returned[1];
                                wins = returned[2];
                                itemCount = returned[3];
                                randomPlayerDamage = rand.nextInt(playerHealth+10);
                                //END GAME
                                if (itemCount >= 3)
                                    running = false;
                            }
                        }
                        ///////////////win fight
                        System.out.println("\"Wheres the petrified wood?\"");
                        myLine = scan.nextLine();
                        System.out.println("\"You'll never find it. He'll never let you have it.\"");
                        myLine = scan.nextLine();
                        System.out.println("\"!\"");
                        myLine = scan.nextLine();
                        running = true;
                        //st fight ensues
                        ///////////////Enter fight
                        while (running) {
                            //BEGINNER
                            if (worldChoice.equals("1")) {
                                System.out.println("\n--------------------------------------------------\n");
                                //ENEMY: set up
                                randomPlayerDamage = rand.nextInt(25+((itemCount+1)*15));
                                String[] enemies = new String[] {"Driver", "Night Guard", "TA", "Science Teacher"};
                                randomEnemy = 3;
                                int[] enemyDamage = new int[] {15, 30, 40, 45};
                                randomEnemyDamage = rand.nextInt(enemyDamage[randomEnemy])+10;
                                int[] enemyHealth = new int[] {50, 75, 90, 150};
                                randomEnemyHealth = rand.nextInt(enemyHealth[randomEnemy])+25;
                                if(randomEnemy == 3)
                                    randomEnemyHealth = 150;
                                //ENEMY: appearance
                                System.out.println("You're approached by a " +enemies[randomEnemy]+  " with " +randomEnemyHealth+ " HP!\nYou currently have " +playerHealth+ " HP, " +elixirCount+ " elixir, and " +itemCount+ " items!");
                                //USER: updated stats
                                int[] returned = choice(enemies[randomEnemy], randomEnemyHealth, randomEnemyDamage, playerHealth, randomPlayerDamage, elixirCount, 15, wins, items, itemCount, 2);
                                elixirCount = 3;
                                wins = returned[2];
                                itemCount = returned[3];
                                randomPlayerDamage = rand.nextInt(playerHealth+10);
                                //END GAME
                                if (itemCount >= 4)
                                    running = false;
                            }
                            //ADVANCED
                            if (worldChoice.equals("2")) {
                                System.out.println("\n--------------------------------------------------\n");
                                //PLAYER: set up
                                randomPlayerDamage = playerHealth+15;
                                //ENEMY: set up
                                String[] enemies = new String[] {"Driver", "Night Guard", "TA", "Science Teacher"};
                                randomEnemy = 3;//rand.nextInt(enemies.length);
                                int[] enemyDamage = new int[] {15, 30, 40, 45};
                                randomEnemyDamage = rand.nextInt(enemyDamage[randomEnemy])+10;
                                int[] enemyHealth = new int[] {50, 75, 90, 150};
                                randomEnemyHealth = rand.nextInt(enemyHealth[randomEnemy])+25;
                                if(randomEnemy == 3)
                                    randomEnemyHealth = 150;
                                //ENEMY: appearance
                                System.out.println("You're approached by a " +enemies[randomEnemy]+  " with " +randomEnemyHealth+ " HP!\nYou currently have " +playerHealth+ " HP!");
                                //USER: updated stats
                                int[] returned = choice(enemies[randomEnemy], randomEnemyHealth, randomEnemyDamage, playerHealth, randomPlayerDamage, elixirCount, 15, wins, items, itemCount, 3);
                                playerHealth = returned[0];
                                elixirCount = returned[1];
                                wins = returned[2];
                                itemCount = returned[3];
                                randomPlayerDamage = rand.nextInt(playerHealth+10);
                                //END GAME
                                if (itemCount >= 4)
                                    running = false;
                            }
                        }
                        ///////////////win fight
                        System.out.println("                                                                                               ,&(.                                                                                 ");
                        System.out.println("                                                                                               .&&/                                                                                 ");
                        System.out.println("                                                                                                &&                                                                                  ");
                        System.out.println("                                                                                                &                                                                                   ");
                        System.out.println("                                                                                                *                                                                                   ");
                        System.out.println("                                                                                                                         (                                                          ");
                        System.out.println("                                                                                                                      *&&&&                                                         ");
                        System.out.println("                                                                                                                    %&%                                                             ");
                        System.out.println("                                                                                                                  ,                                                                 ");
                        System.out.println("                                                                   &&&&&                %                                                                                           ");
                        System.out.println("                                                                         /%&.           &&&                                                                                         ");
                        System.out.println("                                                                                       *&&&&&.        /%&                                                                           ");
                        System.out.println("                                                                                       #&&&&&&&&&&&&&&&(                                                                            ");
                        System.out.println("                                                                                      ,&&&&&&&&&&&&&&&                                                                              ");
                        System.out.println("                                                                                 (&&&&&&&&&&&&&&&&&&&                                                                               ");
                        System.out.println("                                                                               .&&&&&&&&&&&&&&&&&&&&&.                                                                              ");
                        System.out.println("                                                                                     .&&&&&&&&&&&&&&&&&                &%,                                                          ");
                        System.out.println("                                                                                   %&&% &&&&&&&&&&&&&&&&.                  %&&&&%                                                   ");
                        System.out.println("                                                                               .&&&/    &&&&&&           .                     *                                                    ");
                        System.out.println("                                                                            %&&&,       #&&%                                                                                        ");
                        System.out.println("                                                                        ,&&&&.          .(                                                                                          ");
                        System.out.println("                                                                     &&&&&                                                                                                          ");
                        System.out.println("                                                                 /&&&&%                            ,                                                                                ");
                        System.out.println("                                                              &&&&&/                              #*                                                                                ");
                        System.out.println("                                                          #&&&&&,                                .&(                                                                                ");
                        System.out.println("                                                      .&&&&&&                                    &&&                                                                                ");
                        System.out.println("                                                   &&&&&&&                                      *%&&                                                                                ");
                        System.out.println("                                               /&&&&&&%                                                                                                                             ");
                        System.out.println("                                           .&&&&&&&(                                                                                                                                ");
                        System.out.println("                                        &&&&&&&&,                                                                                                                                   ");
                        System.out.println("                                    (&&&&&&&&.                                                                                                                                      ");
                        System.out.println("                                /&&&&&&&&&                                                                                                                                          ");
                        System.out.println("                                 %&&&&%                                                                                                                                             ");
                        System.out.println("                                   #                                                                                                                                                ");
                        myLine = scan.nextLine();
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("...");
                        myLine = scan.nextLine();
                        System.out.println("*Back at the fabric store*");
                        myLine = scan.nextLine();
                        System.out.println("\"Alright! Now to reignite the Well of Magic. Place the items in the well, and recite the incantation.\"");
                        myLine = scan.nextLine();
                        System.out.println("\"TadaSimSalaBimShazamHocusPocusAlakazamOpenSesame.\"");
                        myLine = scan.nextLine();
                        System.out.println("Game Win.");
                        myLine = scan.nextLine();
                        //win-screen
                        System.out.println("                                                                                                                                                                ");
                        System.out.println("                  /*** **,**                                                                      @                                                             ");
                        System.out.println("                   ** */*                                    ##                                  @@                                                             ");
                        System.out.println("              /  ,* .,***,**                                 ###                            @,     @@@@@                                %%                      ");
                        System.out.println("                    **,            @@@@@@@@@@@@@@@          %# #                                *##@@@                                  %%%                     ");
                        System.out.println("                    /*         @@@@@@@@@@@@@@@@@@@@@        ## ###%   ##                        @    &                /                 %%%                   @@");
                        System.out.println("                     *     (@@@@@@@            @@@@@     #       ###                                                 @@@       %%%%%%%.         /%#          .@@");
                        System.out.println("                         @@@@@@          %@@@ @@@@@@       %  (# #/                 @@@               @              @@               #%   %.                @@ ");
                        System.out.println("                      /@@@@@.           @@@@@@@@@@         #  #  # #                @@                              @@/              %%%%  %/%               @& ");
                        System.out.println("  @@@. @@,          *@@@@@              @@@@@@@@           #%      ##(             /@@               %              @@              #%%        %             @  ");
                        System.out.println("   @/ @%           @@@@@                                                           @@                @             @@     @@       #%%           %          @.  ");
                        System.out.println("  ,. @@*@@       @@@@@                                                             @@                @         @@@@@@@                                      @   ");
                        System.out.println("     @          @@@@                                                         &@@& @@                @*       /    @@                                            ");
                        System.out.println("               @@@@                                                        /&     @@                @     @@@@@   @@          @@@         .   @@@.&@@@     @    ");
                        System.out.println("             ,@@@,                 @@           @       @@@@@@@    @&    @@@ @@   @    @@@   @@    .@  @@@% @@    @*    @@   @@.  @   .@ @@@ @@&    &@          ");
                        System.out.println("             @@@                 @@&/@ @    @@.@@@    @@@   @@@ @@@     @@   @@. #@    @@% ,@@&    @@ @(    @@   ,@     @@  @@     @  @@@ @    @@@              ");
                        System.out.println("            @@@                 @@     @   @@@@ @@  @@@    @@@@ @@*          @@# @     @@ @@ @     @@    @@@@    @@     @   @@     @ @@@  @       @@@           ");
                        System.out.println("           #@@@                @@     @@ & @@@  @   @@  @@@  @  @@     @   @@#@, @     @@@@  @    @@    @ (@/    @%     @  @@     @@ @@   @    .     @@         ");
                        System.out.println("           @@@                 ,@@@@@@  @&@@    @   @@@@@   *@        @% ,&&@@@  @      @    (@@  @@   &   @@@   @   @      @@  @@%  @@   @  @       @          ");
                        System.out.println("           @@@                       @@                     @@               @@  @   @            @@             @ @                 @    @  @    @@.      @    ");
                        System.out.println("           @@@%                 #@@@                        @                                     @,                                                       @@   ");
                        System.out.println("            /@@@           &@@@@                           @@                                                                                                   ");
                        System.out.println("               @@@@@@@@@@@@%                              &@                  &@@@@@@@@@@@@@@@@@@@@@@@@@%(,.                                                    ");
                        System.out.println("                                                          @*        *@@@@@@@@@,                                          (                      .  ..           ");
                        System.out.println("                           &                            .@      @@@@@,                  /                                  .(((((            .   ....           ");
                        System.out.println("                            @                          @@       @@@@@             @.  @@@                              ((    ((/                 .. ...         ");
                        System.out.println("                    @@       @                       @@                          @@@ % @@*                                /.((((((                .             ");
                        System.out.println("                   @@@         @                   @@                                @@%@@@@                              ((                                    ");
                        System.out.println("              @  @ @@@@@@@@      @@            @@@                                   *@                                  /(                                     ");
                        System.out.println("                  @ /&@@              ,@@@@&                                          @                                                                         ");
                        System.out.println("                  @/   @@#                                                                                                                                      ");
                    }
                    else if(myInteger == 2)
                    {
                        System.out.println("\"Hello, im here for the internship.\"");
                        myLine = scan.nextLine();
                        System.out.println("\"Sorry, it's been taken.\"");
                        myLine = scan.nextLine();
                        System.out.println("Thanks for playing!");
                        System.exit(0);
                        //bad end
                    }
                }
                else if(myInteger == 2)
                {
                    System.out.println("*You get busy with something else and forget about this for 20 years*");
                    myLine = scan.nextLine();
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                    //bad end
                }
                else if(myInteger == 3)
                {
                    System.out.println("\"That was alot of information to make up right on the spot. You almost had me going there.\"");
                    myLine = scan.nextLine();
                    System.out.println("\"K\"");
                    myLine = scan.nextLine();
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                    //bad end
                }
            }
            else if(myInteger == 2)
            {
                System.out.println("\"Is anybody there?\"");
                myLine = scan.nextLine();
                System.out.println("\"...\"");
                myLine = scan.nextLine();
                System.out.println("(You remember the voice, but it'll fade from your memory)");
                myLine = scan.nextLine();
                //System.out.println("Flowers for [A]ndroids");
                System.out.println("Thanks for playing!");
                System.exit(0);
                //bad end
            }
            else if(myInteger == 3)
            {
                System.out.println("\"was that real?\"");
                myLine = scan.nextLine();
                System.out.println("(Something distracts you. It regains your attention.)");
                myLine = scan.nextLine();
                System.out.println("(you forget about the voice.)");
                myLine = scan.nextLine();
                //System.out.println("Meaningless [C]ode");
                System.out.println("Thanks for playing!");
                System.exit(0);
                //bad end
            }

        }
        else if(game.equals(no))
        {
            System.out.println("Maybe next time then.");
        }
        else
        {
            System.out.println("Invalid");
        }

        // Closing the scanner
        scan.close();
    }
}
