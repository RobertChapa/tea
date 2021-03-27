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
			System.out.println("Objective of the game: Acquire all the magic items left in the world to reignite the ‘well of magic’ and bring magic back into the world.");
		}
		else if(game.equals(no))
		{
			System.out.println("Maybe next time then.");
		}
		else
		{
			System.out.println("Invalid");
		}
	}
}
