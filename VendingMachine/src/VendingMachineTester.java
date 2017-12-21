//Liam Grover
import java.util.Scanner;
public class VendingMachineTester {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		String answer; //yes or no
		String drink; //coke or pepsi
		
		VendingMachineClass coke = new VendingMachineClass();
		VendingMachineClass pepsi = new VendingMachineClass(8);
		
		System.out.println("Would you like to insert a token for a soda?");
		answer= in.next();
		
		while (answer.equals("yes"))
		{
			System.out.println("Would you like a coke or pepsi?");
			drink= in.next();
			
			if(drink.equals("coke"))
			{
				System.out.println("You entered 1 token.");
				coke.tokenCounter();
				coke.canSubtract();
				System.out.println("Please take your coke :)");
				//System.out.println("There are: "+ coke.getTokenNumber() + "in the coke machine");
				
				if(coke.getCans()== 0)
				{
					coke.canRefill();
					System.out.println("\nThere are: "+ coke.getCans() +" coke cans left to buy.");
					System.out.println("There are: "+ coke.getTokenNumber() + " in the coke machine.");
				}
				else
				{
					System.out.println("\nThere are: "+ coke.getCans() +" tokens coke cans left to buy.");
					System.out.println("There are: "+ coke.getTokenNumber() + " tokens in the coke machine.");
				}
			}
			else
			{
				System.out.println("You entered 1 token.");
				pepsi.tokenCounter();
				pepsi.canSubtract();
				System.out.println("Please take your pepsi :)");
				//System.out.println("There are: "+ pepsi.getTokenNumber() + "in the pepsi machine");
				
				if(pepsi.getCans()== 0)
				{
					pepsi.canRefill();
					System.out.println("\nThere are: "+ pepsi.getCans() +" pepsi cans left to buy.");
					System.out.println("There are: "+ pepsi.getTokenNumber() + " tokens in the pepsi machine.");
				}
				else
				{
					System.out.println("\nThere are: "+ pepsi.getCans() +" pepsi cans left to buy.");
					System.out.println("There are: "+ pepsi.getTokenNumber() + " tokens in the pepsi machine.");
				}
			}
			System.out.println("\nWould you like to insert a token for another soda?");
			answer= in.next();
		}
		System.out.println("Have a great day :)");
		System.out.println("\nThere are: "+ coke.getCans() +" tokens coke cans left to buy.");
		System.out.println("There are: "+ coke.getTokenNumber() + " tokens in the coke machine.");
		System.out.println("There are: "+ pepsi.getCans() +" pepsi cans left to buy.");
		System.out.println("There are: "+ pepsi.getTokenNumber() + " tokens in the pepsi machine.");
	}

}
