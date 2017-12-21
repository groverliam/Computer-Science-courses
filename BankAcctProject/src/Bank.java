import java.util.Scanner;
//Create a double that stands for amount
//Create an integer that will allow loop to continue until needs to stop.
//Create a variable that the user will choose to make his choice.
//Create BankAccount
//Create loop that will prompt user to select an option (allow for quit)
//Call the choice selected by user (print error if wrong choice)
//the program will use doubles so the user can enter decimals
//if user does not use a numeric value, print error
//Repeat loop by re-prompting list.
//create a method to make the menu easier
/**
 * 
 * @author Liam Grover
 * creates a bank account and works with the BankAccount class in order to:
 * prompt user for choice of action
 * display error messages where appropriate.
 *
 */
public class Bank 
{		

//Create a double that stands for amount
private double amt;
//Create an integer that will allow loop to continue until needs to stop.
private int n=1;
//Create a variable that the user will choose to make his choice.
private int choice;

//Create loop that will prompt user to select an option (allow for quit)
	public static void main (String[] args)
	{
		transaction();
	}
	/**
	 * Allows for a new transaction to be repeated.
	 */
public static void transaction()
{
	Scanner in = new Scanner(System.in);
	//Create BankAccount
	BankAccount acct1 = new BankAccount();

	
		while (n==1)
		{
			
			menu();
			choice = in.nextInt();
			//Call the choice selected by user (print error if wrong choice)
			if (choice==1)
			{
				System.out.println("What is the ammount to deposit?");
				amt = in.nextDouble();
				if (amt > 0)
				{
				acct1.deposit(amt);
				System.out.println("Your balance is now : $"+acct1.getBalance());
				n = 1;
				}
				//if invalid answer is given
				else
				{
					System.out.println("ERROR");
				}
			}
			else if (choice==2)
			{
				System.out.println("What is the ammount to withdraw?");
				amt = in.nextDouble();
				if (amt > 0)
				{
				acct1.withdraw(amt);
				System.out.println("Your balance is now : $"+acct1.getBalance());
				n = 1;
				}
				//if invalid answer is given
				else
				{
					System.out.println("ERROR");
				}
				
			}
			else if (choice == 3)
			{
				System.out.println("Your balance is : $"+acct1.getBalance());
				n = 1;
			}
			else if (choice ==4)
			{
				n = 0;
			}
			else
			{
				System.out.println("ERROR in answer choice.");	
			}

			//Repeat loop by re-prompting list.
		}
		}
	//a method to make the menu easier
	public static void menu()
	{
	System.out.println("What option would you like to choose?\n");
	System.out.println("1) Deposit");
	System.out.println("2) Withdrawal");
	System.out.println("3) Check Balance");
	System.out.println("4) Quit");

	}
}
