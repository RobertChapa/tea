import java.util.*;
public class TextAdventure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Ready to play Text Embarked/Executed Adventure(TEA)?");
		String game = scan.next();
		
		String yes = "yes";
		String no = "no";
		
		if(game.equals(yes))
		{
			System.out.println("Let's goooooo! Enter go to start: ");
			String go = scan.next();
			System.out.println("Description: The last of the worlds old magic has nearly disappeared from the world. All that’s left are a handful of items that had previously been enchanted by the last Grand Witch.");
			System.out.println("Objective of the game: Acquire all the magic items left in the world to reignite the ‘well of magic’ and bring magic back into the world. Type next to continue: ");
			
		}
		else if(game.equals(no))
		{
			System.out.println("Maybe next time then.");
		}
		else
		{
			System.out.println("Invalid");
		}
		String next = scan.next();
		System.out.println("\"THE GRAND WITCH HAS BEEN LAID TO REST\"\r\n");
		String myLine = scan.nextLine();   
		System.out.println("The voice echoes in your mind. You wonder who that was. What that was.");
		myLine = scan.nextLine();   
		System.out.println("What do you do?");
		myLine = scan.nextLine();  
		System.out.println("1-Ask your sister if she heard that");
		System.out.println("2-Ask the void if anybody is there");
		System.out.println("3-Ask yourself if it was real");
		int myInteger = scan.nextInt();
		
		if(myInteger == 1)
		{
			System.out.println("\"Yup. Guess the Grand witch is dead.\"");
			myLine = scan.nextLine();
			System.out.println("\"The who?\"");
			myLine = scan.nextLine();
			System.out.println("\"The Grand Witch. Dust. Puddle.\"");
			myLine = scan.nextLine();
			System.out.println("\"?\"");
			myLine = scan.nextLine();
			System.out.println("\"Remember? We went to that day camp that one year and we got split it because I was older? and you went with the other kids to play witch. They told us all about the Grand Witch, the Order, and how magic was real and we even got to try riding brooms?\"");
			myLine = scan.nextLine();
			System.out.println("\"All we did was play dress up and pretend to cast spells with fake wands! And whats this about magic?\"");
			myLine = scan.nextLine();
			System.out.println("\"Yeah, like they went over it. Simple magic, advanced magic, magic cheats, etc. Not many bloodlines left, screening for magic potential, broom test.\"");
			myLine = scan.nextLine();
			System.out.println("\"Broom test?\"");
			myLine = scan.nextLine();
			System.out.println("\"yeah like in that scene in harry potter with the brooms. even being to call a broom to yourself was impressive. I was like one of three that could. Cant really do it anymore. Old magics gone.\"");
			myLine = scan.nextLine();
			System.out.println("\">:O\"");
			myLine = scan.nextLine();
			System.out.println("\"Did they not go over that in the kids class?\"");
			myLine = scan.nextLine();
			System.out.println("\"NoO! None of that! I never saw you do any of that stuff.\"");
			myLine = scan.nextLine();
			System.out.println("\"Oh yeah, no, of course not. They had the Grand Witch there just to amplify any nearby magic and still few of us could only summon a broom. That was about it. It was cool, but uneventful. When i got home i could barely knock over a broom from a distance\"");
			myLine = scan.nextLine();
			System.out.println("\">:O\"");
			myLine = scan.nextLine();
			System.out.println("\"Didnt mom take you bakc the next year ot learn all this stuff?\"");
			myLine = scan.nextLine();
			System.out.println("\"NoooOO!\"");
			myLine = scan.nextLine();
			System.out.println("\"Oh. welp. exposition.\"");
			myLine = scan.nextLine();
			System.out.println("What next?\n 1-Ask Mom\n 2-Take more time to proccess this\n 3-ah don beleve it");
			myInteger = scan.nextInt();
			
			if(myInteger == 1)
			{
				System.out.println("\"hey so whats this about magic\"");
				myLine = scan.nextLine();
				System.out.println("\"oh yeah, the grand witch will be missed deerly!\"");
				myLine = scan.nextLine();
				System.out.println("\"No! why is this the irst time im herring about this?\"");
				myLine = scan.nextLine();
				System.out.println("\"What do you mean? Didnt you go to whtich camp forever ago?\"");
				myLine = scan.nextLine();
				System.out.println("\"No!\"");
				myLine = scan.nextLine();
				System.out.println("\"Oh. well if you want to get up to date and still try magic stuff, theyre taking interns right now to try to reigntie the well of magic\"");
				myLine = scan.nextLine();
				System.out.println("\"Really! Who do I speak to about that?\"");
				myLine = scan.nextLine();
				System.out.println("\"The high council. Here, Gretchen owes me a favor anyway. Ill call them up. you should meet them in the back of the fabric store downtown. \"");
				myLine = scan.nextLine();
				System.out.println("What next?\n 1-Go downtown\n");
				myInteger = scan.nextInt();
				
				if(myInteger == 1)//roll for internship
				{
					System.out.println("\"Hello, im here for the internship.\"");
					myLine = scan.nextLine();
					System.out.println("\"Ah yes, your mother told me i should expect you. Your first so its all yours. Not many left even interested in this kind of thing. ANwyaways, the firs thing you need to pickup is 18k in perfume. we're no paying for it, figure it out.\"");
					myLine = scan.nextLine();
					System.out.println("\"Why perfume?\"");
					myLine = scan.nextLine();
					System.out.println("\"okay, so the grand witch had a familiar.\"");
					myLine = scan.nextLine();
					System.out.println("\"yes\"");
					myLine = scan.nextLine();
					System.out.println("\"and this familliar was just a whale she had enchanted\"");
					myLine = scan.nextLine();
					System.out.println("*Gives tedious look*");
					myLine = scan.nextLine();
					System.out.println("\"but its got hunted by wailers and was made into various goods and sold off peice by peice. And now all thats left is its ambergris which was used to make this case of perfumes, but that should be good enough\"");
					myLine = scan.nextLine();
					System.out.println("\"and so you want me to steal $18k worth of perfume\"");
					myLine = scan.nextLine();
					System.out.println("\"You dont have to steal it.\"");
					myLine = scan.nextLine();
					System.out.println("\"Because theres a little bit if magic whale in it?\"");
					myLine = scan.nextLine();
					System.out.println("\"yes, its being shipped to a perfume store about 8 miles from here\"");
					myLine = scan.nextLine();
					System.out.println("*At the perfume store*");
					myLine = scan.nextLine();
					System.out.println("\"The Truck with the shipment is still loaded, May as well just steal the whole truck.\"");
					myLine = scan.nextLine();
					///////////////Enter fight 
					
					///////////////win fight
					System.out.println("*At the fabric store*");
					myLine = scan.nextLine();
					System.out.println("\"Very good, now your next job is to retrieve the Ruby Kicks from the grand witches hoard\"");
					myLine = scan.nextLine();
					System.out.println("\"which is where? and what?\"");
					myLine = scan.nextLine();
					System.out.println("\"She kept a storage unit down town, the shoes are prbably there\"");
					myLine = scan.nextLine();
					System.out.println("*At the storage units*");
					myLine = scan.nextLine();
					//roll, 1-20, if x>15
					//roll, 1-20, if x>10
					//roll, 1-20, if x>5 fight anyway
					//fight
					
					System.out.println("*opens and searches storage unit*");
					myLine = scan.nextLine();
					System.out.println("*back at the fabric store*");
					myLine = scan.nextLine();
					System.out.println("\"Wow, these are nicer than i remember. \"");
					myLine = scan.nextLine();
					System.out.println("\"That was a lot of trouble for some shoes\"");
					myLine = scan.nextLine();
					System.out.println("\"Okay, your next item is the piece of wand that was stolen from teh grand witch by the science teacher.\"");
					myLine = scan.nextLine();
					System.out.println("\"A science teacher? \"");
					myLine = scan.nextLine();
					System.out.println("\"Yeah, its partially petrified its so old. He shows it off to his student when they learn about fossils\"");
					myLine = scan.nextLine();
					System.out.println("\"?\"");
					myLine = scan.nextLine();
					System.out.println("\"Its probably in his desk as the school. good luck\"");
					myLine = scan.nextLine();
					System.out.println("*Tredding the halls of the school*");
					myLine = scan.nextLine();
					System.out.println("*from the shadows a man approaches*");
					myLine = scan.nextLine();
					//ta fight ensues
					System.out.println("\"Wheres the petrified wood?\"");
					myLine = scan.nextLine();
					System.out.println("\"Youll never find it. He'll never let you have it.\"");
					myLine = scan.nextLine();
					System.out.println("\"!\"");
					myLine = scan.nextLine();
					//st fight ensues
					System.out.println("*back at the fabric store*");
					myLine = scan.nextLine();
					System.out.println("\"Alright! Now to reignite the well of magic, place the items in the well. And recite the incantation.\"");
					myLine = scan.nextLine();
					System.out.println("\"TadaSimSalaBimShazamHocusPocusAlakazamOpenSesame\"");
					myLine = scan.nextLine();
					System.out.println("Game Win");
					myLine = scan.nextLine();
					//winscreen
					
				}
				else if(myInteger == 2)
				{
					System.out.println("\"Hello, im here for the internship.\"");
					myLine = scan.nextLine();
					System.out.println("\"sorry its been taken.\"");
					myLine = scan.nextLine();
					//bad end
				}
			}
			else if(myInteger == 2)
			{
				System.out.println("*get busy with something else and forgets about it for 20 years*");
				myLine = scan.nextLine();
				//bad end
			}
			else if(myInteger == 3)
			{
				System.out.println("\"That was alot of informtion to make up right on the spot. You almost had me going there.\"");
				myLine = scan.nextLine();
				System.out.println("\"K\"");
				myLine = scan.nextLine();
				//bad end
			}
			//System.out.println("");
			//myLine = scan.nextLine();
		}
		else if(myInteger == 2)
		{
			System.out.println("\"Is anybody there?\"");
			myLine = scan.nextLine();
			System.out.println("\"...\"");
			myLine = scan.nextLine();
			System.out.println("(You remember the voice, but it'll fade from your memory)");
			myLine = scan.nextLine();
			System.out.println("Flowers for [A]ndroids");
		}
		else if(myInteger == 3)
		{
			System.out.println("\"was that real?\"");
			myLine = scan.nextLine();
			System.out.println("(X occurs and regains your attention.)");
			myLine = scan.nextLine();
			System.out.println("(you forget about the voice.)");
			myLine = scan.nextLine();
			System.out.println("Meaningless [C]ode");
		}
      
		// Closing the scanner
		scan.close();
	}

	    public static boolean chance()
	    {
	        Random rand = new Random();
	        int chance = rand.nextInt(10);
	        if (chance > 5)
	        {
	            return true;
	        }
	        else
	        {
	            return false;
	        }
	    }
	    public static boolean[] drop(String enemy, int enemyHealth, int enemyDamage, int playerHealth, int playerDamage, int elixirCount, int elixirHealth, int wins, boolean[] items, int itemCount, int level)
	    {
	        if (level == 2)
	        {
	            if (itemCount < 4)
	            {
	                System.out.println("You now have " +(itemCount+1)+ " items!");
	                items[wins-1] = true;
	            }
	        }
	        if (level == 3)
	        {
	            boolean chance = chance();
	            if ((chance == true) && (itemCount < 4))
	            {
	                System.out.println("You now have " +(itemCount+1)+ " items!");
	                items[wins-1] = true;
	            }
	        }
	        return items;
	    }
	    public static int[] choice(String enemy, int enemyHealth, int enemyDamage, int playerHealth, int playerDamage, int elixirCount, int elixirHealth, int wins, boolean[] items, int itemCount, int level)
	    {
	        Scanner scnr = new Scanner(System.in);
	        System.out.println("What would you like to do?\n\t> 1: Fight\n\t> 2: Drink elixir\n\t> 3: Run");
	        int enemyChoice = scnr.nextInt();
	        if (enemyChoice == 1)
	        {
	            int[] returned = fight(enemy, enemyHealth, enemyDamage, playerHealth, playerDamage, elixirCount, elixirHealth, wins, items, itemCount, level);
	            if (level == 3)
	            {
	                playerHealth = returned[0];
	            }
	            elixirCount = returned[1];
	            wins = returned[2];
	            itemCount = returned[3];
	            System.out.println("CHOICE FIGHT:" +playerHealth+ ", " +elixirCount+ ", " +wins+ ", " +itemCount);
	            return new int[]{playerHealth, elixirCount, wins, itemCount};
	        }
	        else if (enemyChoice == 2) {
	            int[] returned = elixir(enemy, enemyHealth, enemyDamage, playerHealth, playerDamage, elixirCount, elixirHealth, wins, items, itemCount, level);
	            if (level == 3)
	            {
	                playerHealth = returned[0];
	            }
	            elixirCount = returned[1];
	            wins = returned[2];
	            itemCount = returned[3];
	            System.out.println("CHOICE ELIXIR:" +playerHealth+ ", " +elixirCount+ ", " +wins+ ", " +itemCount);
	            return new int[]{playerHealth, elixirCount, wins, itemCount};
	        }
	        else if (enemyChoice == 3)
	        {
	            System.out.println("You run!");
	        }
	        else
	        {
	            System.out.println("What would you like to do?\n\t> 1: Fight\n\t> 2: Drink elixir\n\t> 3: Run");
	            enemyChoice = scnr.nextInt();
	        }
	        System.out.println("CHOICE:" +playerHealth+ ", " +elixirCount+ ", " +wins+ ", " +itemCount);
	        return new int[]{playerHealth, elixirCount, wins, itemCount};
	    }
	    public static int[] fight(String enemy, int enemyHealth, int enemyDamage, int playerHealth, int playerDamage, int elixirCount, int elixirHealth, int wins, boolean[] items, int itemCount, int level)
	    {
	        System.out.println("You've chosen to fight!");
	        playerHealth = playerHealth - enemyDamage;
	        enemyHealth = enemyHealth - playerDamage;
	        if (playerHealth <= 0)
	        {
	            playerHealth = 0;
	            System.out.println("You lost.");
	            int[] returned = {playerHealth, elixirCount, wins, itemCount};
	            if (level == 3)
	            {
	                playerHealth = returned[0];
	            }
	            elixirCount = returned[1];
	            wins = returned[2];
	            itemCount = returned[3];
	            System.out.println("LOST:" +playerHealth+ ", " +elixirCount+ ", " +wins+ ", " +itemCount);
	            return new int[]{playerHealth, elixirCount, wins, itemCount};
	        }
	        else if (enemyHealth <= 0)
	        {
	            System.out.println("You won! You now have " +playerHealth+ " HP!");
	            wins += 1;
	            items = drop(enemy, enemyHealth, enemyDamage, playerHealth, playerDamage, elixirCount, elixirHealth, wins, items, itemCount, level);
	            if (items[wins-1]==true||wins==4)
	            {
	                System.out.println("Hello");
	                itemCount += 1;
	            }
	            int[] returned = {playerHealth, elixirCount, wins, itemCount};
	            if (level == 3)
	            {
	                playerHealth = returned[0];
	            }
	            elixirCount = returned[1];
	            wins = returned[2];
	            itemCount = returned[3];
	            System.out.println("WON:" +playerHealth+ ", " +elixirCount+ ", " +wins+ ", " +itemCount);
	            return new int[]{playerHealth, elixirCount, wins, itemCount};
	        }
	        else
	        {
	            System.out.println("The " +enemy+ " now has " +enemyHealth+ " HP!\nYou now have " +playerHealth+ " HP!\n");
	            int[] returned = choice(enemy, enemyHealth, enemyDamage, playerHealth, playerDamage, elixirCount, elixirHealth, wins, items, itemCount, level);
	            if (level == 3)
	            {
	                playerHealth = returned[0];
	            }
	            elixirCount = returned[1];
	            wins = returned[2];
	            itemCount = returned[3];
	        }
	        System.out.println("FIGHT:" +playerHealth+ ", " +elixirCount+ ", " +wins+ ", " +itemCount);
	        return new int[]{playerHealth, elixirCount, wins, itemCount};
	    }
	    public static int[] elixir(String enemy, int enemyHealth, int enemyDamage, int playerHealth, int playerDamage, int elixirCount, int elixirHealth, int wins, boolean[] items, int itemCount, int level)
	    {
	        System.out.println("You check for elixir!");
	        if (elixirCount > 0) {
	            elixirCount -= 1;
	            playerHealth += elixirHealth;
	            System.out.println("You drank an elixir giving you " + playerHealth + " HP! You now have " + elixirCount + " elixir.");
	            int[] returned = choice(enemy, enemyHealth, enemyDamage, playerHealth, playerDamage, elixirCount, elixirHealth, wins, items, itemCount, level);
	            if (level == 3)
	            {
	                playerHealth = returned[0];
	            }
	            elixirCount = returned[1];
	            wins = returned[2];
	            itemCount = returned[3];
	        }
	        else if (elixirCount <= 0)
	        {
	            System.out.println("You are out of elixir!");
	            int[] returned = choice(enemy, enemyHealth, enemyDamage, playerHealth, playerDamage, elixirCount, elixirHealth, wins, items, itemCount, level);
	            if (level == 3)
	            {
	                playerHealth = returned[0];
	            }
	            elixirCount = returned[1];
	            wins = returned[2];
	            itemCount = returned[3];
	        }
	        System.out.println("ELIXIR:" +playerHealth+ ", " +elixirCount+ ", " +wins+ ", " +itemCount);
	        return new int[]{playerHealth, elixirCount, wins, itemCount};
	    }
	    public static void main(String[] args)
	    {
	        /*VARIABLES*/
	        Scanner scnr = new Scanner(System.in);
	        Random rand = new Random();
	        boolean running = false;
	        boolean[] items = new boolean[] {false, false, false, false};
	        String playerName;
	        int worldChoice;
	        int randomEnemy;
	        int randomEnemyDamage;
	        int randomEnemyHealth;
	        int playerHealth = 100;
	        int itemCount = 0;
	        int randomPlayerDamage;
	        int elixirCount = 3;
	        int wins = 0;

	        /*INTRO*/
	        System.out.println("Welcome to TEA");
	        System.out.println("Please enter a name: ");
	        playerName = scnr.next();

	        /*PATHS*/
	        System.out.println("Hello " +playerName+ ", please select a path\n\t> 1: Tutorial\n\t> 2: Tavern\n\t> 3: One last job");
	        worldChoice = scnr.nextInt();
	        while (!running)
	        {
	            if (worldChoice == 1)
	            {
	                System.out.println("Welcome to the tutorial!");
	                running = true;
	            }
	            else if (worldChoice == 2)
	            {
	                System.out.println("Intro");
	                running = true;
	            }
	            else if (worldChoice == 3)
	            {
	                System.out.println("Welcome to the last job!");
	                running = true;
	            }
	            else
	            {
	                System.out.println("Please select a path\n\t> 1: Tutorial\n\t> 2: Tavern\n\t> 3: One last job");
	                worldChoice = scnr.nextInt();
	                running = false;
	            }
	        }

	        /*GAME*/
	        while (running)
	        {
	            if (worldChoice == 2)
	            {
	                randomPlayerDamage = rand.nextInt(25+((itemCount+1)*15));
	                String[] enemies = new String[] {"Drivers", "Night Guards", "TAs", "Science Teacher"};
	                randomEnemy = itemCount;//rand.nextInt(enemies.length);
	                int[] enemyDamage = new int[] {15, 30, 40, 45};
	                randomEnemyDamage = rand.nextInt(enemyDamage[randomEnemy])+10;
	                int[] enemyHealth = new int[] {50, 75, 90, 150};
	                randomEnemyHealth = rand.nextInt(enemyHealth[randomEnemy])+25;
	                if(randomEnemy == 3)
	                {
	                    randomEnemyHealth = 150;
	                }
	                System.out.println("You're approached by a " +enemies[randomEnemy]+  " with " +randomEnemyHealth+ " HP!\nYou currently have " +playerHealth+ " HP!");
	                int[] returned = choice(enemies[randomEnemy], randomEnemyHealth, randomEnemyDamage, playerHealth, randomPlayerDamage, elixirCount, 15, wins, items, itemCount, 2);
	                elixirCount = 3;
	                wins = returned[2];
	                itemCount = returned[3];
	                System.out.println("MAIN:" +playerHealth+ ", " +elixirCount+ ", " +wins+ ", " +itemCount);
	                randomPlayerDamage = rand.nextInt(playerHealth+10);
	                System.out.println("\n--------------------------------------------------\n");
	                if (itemCount >= 4){
	                    running = false;
	                }
	            }
	            if (worldChoice == 3)
	            {
	                randomPlayerDamage = playerHealth+15;
	                String[] enemies = new String[] {"Drivers", "Night Guards", "TAs", "Science Teacher"};
	                randomEnemy = itemCount;//rand.nextInt(enemies.length);
	                int[] enemyDamage = new int[] {15, 30, 40, 45};
	                randomEnemyDamage = rand.nextInt(enemyDamage[randomEnemy])+10;
	                int[] enemyHealth = new int[] {50, 75, 90, 150};
	                randomEnemyHealth = rand.nextInt(enemyHealth[randomEnemy])+25;
	                if(randomEnemy == 3)
	                {
	                    randomEnemyHealth = 150;
	                }
	                System.out.println("You're approached by a " +enemies[randomEnemy]+  " with " +randomEnemyHealth+ " HP!\nYou currently have " +playerHealth+ " HP!");
	                int[] returned = choice(enemies[randomEnemy], randomEnemyHealth, randomEnemyDamage, playerHealth, randomPlayerDamage, elixirCount, 15, wins, items, itemCount, 3);
	                playerHealth = returned[0];
	                elixirCount = returned[1];
	                wins = returned[2];
	                itemCount = returned[3];
	                System.out.println("MAIN:" +playerHealth+ ", " +elixirCount+ ", " +wins+ ", " +itemCount);
	                randomPlayerDamage = rand.nextInt(playerHealth+10);
	                System.out.println("\n--------------------------------------------------\n");
	                if (itemCount >= 4){
	                    running = false;
	                }
	            }
	        }
	        /*boolean chance1 = chance();
	        System.out.println(chance1);
	        boolean chance2 = chance();
	        System.out.println(chance2);
	        boolean chance3 = chance();
	        System.out.println(chance3);
	        if ((chance1 == true)||(chance2 == true)||(chance3 == true))
	        {
	            System.out.println("GOODBYE");
	        }
	        else
	        {
	            System.out.println("Sucks");
	        }*/
	        System.out.println("THE END!");
}

	
}
