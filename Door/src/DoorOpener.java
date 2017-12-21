import java.util.Scanner;

public class DoorOpener 
{

	public static void main(String[] args) 
	{
		/*
		 * The following options can be selected by the user
		 */
		final int INIT = 0; // no option selected
		final int OPEN = 1; // option to open the door
		final int CLOSE = 2; // option to close the door
		final int STATUS = 3; // option to get the status of the door
		final int ADD = 4; 
		final int SHOWALL = 5;
		final int EXIT = 6; // option to quit the program

		final int LENGTH = 5; //The max size
		int currentSize= 0; //The current size
		String name;
		String state;
		int doorSelection;
		/*
		 * Instantiate a door
		 */
		Door[] doors = new Door[LENGTH];

		/*
		 * Instantiate a Scanner for the user to input an option from the console. 
		 */
		Scanner in = new Scanner (System.in); 
		/*
		 * The initial status of the door is INIT.
		 * It is used to indicate that the user has not yet selected an option
		 * and should be prompted to do so.
		 */
		int option = INIT; 
		/*
		 * Perform the option selected by the user until they choose to exit.
		 */
		while (option != EXIT)
		{
			/* 
			 * Prompt the user to select an option
			 */
			System.out.println ("Please select an option: \n"
					+ "1. Open the door\n" 
					+ "2. Close the door\n" 
					+ "3. Get the status of the door\n"
					+ "4. Add a door\n"
					+ "5. Show all doors\n"
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
			case OPEN: 
				/*
				 * Open the door
				 */
				System.out.print("Select a door: ");
				doorSelection= in.nextInt();
				//myDoor.open();
				doors[doorSelection-1].open();
				System.out.println ("You opened the door.\n");
				break;
			case CLOSE: 
				/*
				 * Close the door
				 */
				System.out.print("Select a door: ");
				doorSelection= in.nextInt();
				//myDoor.close();
				doors[doorSelection-1].close();
				System.out.println ("You closed the door.\n");
				break;
			case STATUS: 
				/*
				 * Get the status of the door
				 */
				System.out.print("Select a door: ");
				doorSelection= in.nextInt();
				System.out.println ("The " + doors[doorSelection-1].getName() + " door is " 
						+ doors[doorSelection-1].getState()+ ".\n");
				break;
			case ADD:
				System.out.print("Enter a name for door: ");
				name= in.next();
				System.out.print("Enter a state for door: ");
				state= in.next();
				Door aDoor = new Door(name, state);
				doors[currentSize] = aDoor;
				currentSize++;
				break;
			case SHOWALL:
				//Step through the array
				//get the name and state of the door 
				for(int i =0; i < currentSize  ; i++)
				{
					System.out.println ("The door that is named " + doors[i].getName() + " is " 
							+ doors[i].getState()+ ".\n");
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
} // end class