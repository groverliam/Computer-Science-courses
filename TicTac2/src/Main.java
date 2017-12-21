import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String choice;
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to play or watch?");
		choice = in.next();
		choice = choice.toLowerCase();
		if (choice.equals("play"))
		{
			System.out.println("Would you like to play a friend or computer?");
			choice = in.next();
			if (choice.equals("friend"))
			{
				PvP p = new PvP();
			}
			else //computer
			{
				PvAI pai = new PvAI();
			}
		
		
		}
		else
		{
			AIvAI ai = new AIvAI();
		}
	}

}
