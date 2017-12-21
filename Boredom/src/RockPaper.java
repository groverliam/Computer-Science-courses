import java.util.Scanner;
import java.util.Random;

public class RockPaper 
{
	public static void main (String[] args)
	{
		int ans;
		int rand;
		int ans2;
		Scanner in = new Scanner (System.in);
		Random randomGenerator = new Random();
		//rand num
		
		System.out.println("WELCOME TO ROCK PAPER SCISSORS!");
		System.out.println("YOU KNOW THE RULES, HAVE FUN!");
		
		menu();
		System.out.println("CHOOSE YOUR TACTIC!");
		ans= in.nextInt();
		while(ans >= 1 && ans <= 3)
		{
			rand = randomGenerator.nextInt(2);
			//rand for later
			
		//if statements for player
			if(ans == 1)
			{
				System.out.println("Your choice is rock!");
			}
			else if(ans == 2)
			{
				System.out.println("Your choice is paper!");
			}
			else
			{
				System.out.println("Your choice is scissors!");
			}
			
		// if statements for computer
			if(rand == 0)
			{
				ans2=1;
				System.out.println("Computer chose rock!");
			}
			else if(rand == 1)
			{
				ans2=1;
				System.out.println("Computer chose paper!");
			}
			else
			{
				ans2=1;
				System.out.println("Computer chose scissors!");
			}
		
		//player vs Computer
			if(ans==1 && ans2==2)
			{
				System.out.println(" ");
				System.out.println("You LOSER! :P");
			}
			else if(ans==1 && ans2==3)
			{
				System.out.println(" ");
				System.out.println("YOU WIN! :)");
			}
			else if(ans==2 && ans2==1)
			{
				System.out.println(" ");
				System.out.println("YOU WIN! :)");
			}
			else if(ans==2 && ans2==3)
			{
				System.out.println(" ");
				System.out.println("You LOSER! :P");
			}
			else if(ans==3 && ans2==1)
			{
				System.out.println(" ");
				System.out.println("You LOSER! :P");
			}
			else if(ans==3 && ans2==2)
			{
				System.out.println(" ");
				System.out.println("YOU WIN! :)");
			}
			else
			{
				System.out.println(" ");
				System.out.println("It was a TIE");
			}
			
			//REPEAT BEGINNING
			System.out.println("PLAY AGAIN?!?!");
			menu();
			System.out.println("CHOOSE YOUR TACTIC!");
			ans= in.nextInt();
		}
		System.out.println("BYE LOSER! ");
	}
	public static void menu()
	{
			System.out.println("CHOOSE YOUR TACTIC!");
			System.out.println("1) ROCK");
			System.out.println("2) PAPER");
			System.out.println("3) SCISSORS");
			System.out.println("4) QUIT :(");
			//while loop will be made for quitting
	}
}
