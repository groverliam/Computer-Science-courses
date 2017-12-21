import java.util.Arrays;
import java.util.Scanner;


public class PhoneBook {
	public static void main (String [] args)
	{
		final int INIT = 0; //No option selected
		final int ADD = 1; //Add a contact
		final int CHANGE = 2; //Change contact
		final int DISPLAY = 3; //Display one contact
		final int REMOVE = 4; //Remove contact
		final int SHOWALL = 5; //Show all contacts
		final int EXIT = 6; // option to quit the program
		final int LENGTH = 100; //Array will be preset to allow 100 contacts.
		int currentSize= 0;
		String firstName;
		String lastName;
		String phoneNumber;
		int personSelection;
		int choice;
		Person contacts = new Person();
		Person[] persons = new Person[LENGTH]; //length will increase every time the user adds a person.
		Person aPerson;
		Scanner in = new Scanner (System.in); 
		int option = INIT; 
		while (option != EXIT)
		{
			/* 
			 * Prompt the user to select an option
			 */
			System.out.println ("Please select an option: \n"
					+ "1. Add a contact\n" 
					+ "2. Change a contact\n" 
					+ "3. Display a contact\n"
					+ "4. Remove a contact\n"
					+ "5. Show all\n"
					+ "6. Exit the program");
			/*
			 * Read the option
			 */
			option = in.nextInt();
			/*
			 * Perform an action based on the option selected
			 */
			switch (option)
			{
			case ADD: 
				/*
				 * Add a contact
				 */
				System.out.println("What is the first name of the contact you would like to add.");
				firstName = in.next();
				System.out.println("What is the last name of the contact.");
				lastName = in.next();
				System.out.println("What is the phone number of the contact.");
				phoneNumber = in.next();
				aPerson = new Person(firstName, lastName, phoneNumber);
				persons[currentSize] = aPerson;
				currentSize++;
				break;
			case CHANGE: 
				/*
				 * Change a contact
				 */
				System.out.println("What number contact would you like to change?");
				personSelection= in.nextInt();
				System.out.println("You chose: " + persons[personSelection-1].getFirstName() + "'s contact." );

				System.out.println("What would you like to change about it?");
				System.out.println("1) The first name? ");
				System.out.println("2) The last name? ");
				System.out.println("3) Or the phone number? ");
				choice= in.nextInt();
				if(choice == 1)
				{
					System.out.println("What would you like to change the first name to?");
					firstName = in.next();
					persons[personSelection-1].setFirstName(firstName);
				}
				else if(choice == 2)
				{
					System.out.println("What would you like to change the last name to?");
					lastName = in.next();
					persons[personSelection-1].setLastName(lastName);
				}
				else
				{
					System.out.println("What would you like to change the phone number to?");
					phoneNumber = in.next();
					persons[personSelection-1].setPhoneNumber(phoneNumber);
				}
				break;
			case DISPLAY: 
				/*
				 * Display one contact
				 */
				System.out.println("What number contact would you like to see?");
				personSelection= in.nextInt();
				System.out.println ((personSelection-1)+ ") The phone number of " + persons[personSelection-1].getFirstName() + " " +
						persons[personSelection-1].getLastName() + " is " + persons[personSelection-1].getPhoneNumber() + ".\n");
				break;
			case REMOVE: 
				/*
				 * Remove a contact
				 */
				System.out.println("What number contact would you like to remove?");
				personSelection= in.nextInt();

				contacts.removePerson(personSelection, currentSize, persons);
				currentSize--;
				/*
for(int i= 0; i < currentSize; i ++)
{
if(i== currentSize-1)
{
System.out.println ((currentSize)+ ") The phone number of " + persons[i].getFirstName() + " " +
persons[i].getLastName() + " is " + persons[i].getPhoneNumber() + ".\n");
}
else
{
System.out.println ((currentSize)+ ") The phone number of " + persons[i].getFirstName() + " " +
persons[i].getLastName() + " is " + persons[i].getPhoneNumber() + ".\n" + ", ");
}
}
				 */
				System.out.println("Contact Removed");
				break;
			case SHOWALL:
				//Step through the array
				//get the name and state of the door 
				for(int i =0; i < currentSize  ; i++)
				{
					System.out.println ((i+1)+ ") The phone number of " + persons[i].getFirstName() + 
							" "+ persons[i].getLastName() +" is " + persons[i].getPhoneNumber() + ".\n");
				}
				break;
			case EXIT: 
				/*
				 * Exit the program
				 * Do nothing and allow the loop to terminate.
				 */ 
				break;
			default:
				/*
				 * An invalid option was selected.
				 * Print a error message. 
				 * The user will be re-prompted on the next iteration of the loop.
				 */
				System.out.println ("An invalid option was selected. " +
						"No action will be taken.\n"); 
			} // end switch 
		} // end while
	} // end main
}
