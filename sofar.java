import java.util.Scanner;

public class Gam 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
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
			System.out.println("Main Story");
		else if(myInteger == 2)
		{
			System.out.println("\"Is anybody there?\"");
			myLine = scan.nextLine();
			System.out.println("\"...\"");
			myLine = scan.nextLine();
			System.out.println("(You remember the voice, but it'll fade from your memory)");
			myLine = scan.nextLine();
			System.out.println("Ending A");
		}
		else if(myInteger == 3)
		{
			System.out.println("\"was that real?\"");
			myLine = scan.nextLine();
			System.out.println("(X occurs and regains your attention.)");
			myLine = scan.nextLine();
			System.out.println("(you forget about the voice.)");
			myLine = scan.nextLine();
			System.out.println("Ending B");
		}
      
		// Closing the scanner
		scan.close();
	}
}
