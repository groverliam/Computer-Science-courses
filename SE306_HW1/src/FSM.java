import java.util.Scanner;
public class FSM {
	
	State state;
	Input input;
	Scanner in = new Scanner(System.in);
	FSM(){
		state = State.STATE0;
	}

	public void run(){
		int num;
		System.out.println("The car is in OFF state. What would you like to do next?");
		System.out.println("Choices: \n 2--Seat \n 0--Terminate ");
		while(true)
		{
			//enter a num from keyboard
			if(state!=State.STATE6)
			{
			System.out.println("\nPlease enter a number:");
			num = in.nextInt();
			//convert num to input & assign to input
			input = Input.fromInt(num);
			}
			
			
			
			System.out.println("");
			//switch(state)
			//case input
			//state transition
			switch(state)
			{
			
			case STATE0: //OFF
				if(input == Input.INPUT2)
				{
					state = State.STATE1;
					System.out.println("SEAT \nNEXT STATE: SEATED");
					System.out.println("\nThe car is in SEATED state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 3--Unseat \n 4--Belt \n 0--Terminate ");
				}
				else if (input == Input.INPUT0)
				{
					state = State.STATE6;
					System.out.println("\nTERMINATED");
				}
				else
				{
					System.out.println("\nERROR RETRY");
					System.out.println("\nThe car is in OFF state. What would you like to do next?");
					System.out.println("Choices: \n 2--Seat \n 0--Terminate ");
				}
				break;
					
			
			case STATE1: //SEATED
				if(input == Input.INPUT4)
				{
					state = State.STATE2;
					System.out.println("BELT \nNEXT STATE: READY");
					System.out.println("\nThe car is in READY state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 5--Unbelt \n 0--Terminate ");
				}
				else if(input == Input.INPUT3)
				{
					state = State.STATE0;
					System.out.println("UNSEAT \nNEXT STATE: OFF");
					System.out.println("\nThe car is in OFF state. What would you like to do next?");
					System.out.println("Choices: \n 2--Seat \n 0--Terminate ");
				}
				else if(input == Input.INPUT1)
				{
					state = State.STATE4;
					System.out.println("KEY IN \nNEXT STATE: TIMING");
					System.out.println("TIMER ON");
					System.out.println("\nThe car is in TIMER state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 4--Belt \n 6--Timer Expires \n 0--Terminate ");
				}
				else if (input == Input.INPUT0)
				{
					state = State.STATE6;
					System.out.println("\nTERMINATED");
				}
				else
				{
					System.out.println("\nERROR RETRY");
					System.out.println("\nThe car is in SEATED state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 3--Unseat \n 4--Belt \n 0--Terminate ");
				}
				break;
					
			case STATE2: //READY
				if(input == Input.INPUT5)
				{
					state = State.STATE1;
					System.out.print("UNBELTED \nNEXT STATE: SEATED");
					System.out.println("\nThe car is in SEATED state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 3--Unseat \n 4--Belt \n 0--Terminate ");
				}
				else if(input == Input.INPUT1)
				{
					state = State.STATE1;
					System.out.println("KEY IN \nNEXT STATE: BELTED");
					System.out.println("\nThe car is in BELTED state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 5--Unbelt \n 0--Terminate ");
				}
				else if (input == Input.INPUT0)
				{
					state = State.STATE6;
					System.out.println("\nTERMINATED");
				}
				else
				{
					System.out.println("\nERROR RETRY");
					System.out.println("\nThe car is in READY state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 5--Unbelt \n 0--Terminate ");
				}
				break;
				
			case STATE3: //BELTED
				if(input == Input.INPUT5)
				{
					state = State.STATE4;
					System.out.println("UNBELTED \nNEXT STATE: TIMING");
					System.out.println("TIMER ON");
					System.out.println("\nThe car is in TIMER state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 4--Belt \n 6--Timer Expires \n 0--Terminate ");
				}
				else if(input == Input.INPUT1)
				{
					state = State.STATE2;
					System.out.println("KEY IN \nNEXT STATE: READY");
					System.out.println("\nThe car is in READY state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 5--Unbelt \n 0--Terminate ");
				}
				else if (input == Input.INPUT0)
				{
					state = State.STATE6;
					System.out.println("\nTERMINATED");
				}
				else
				{
					System.out.println("\nERROR RETRY");
				}
				break;
				
			case STATE4: //TIMER
				if(input == Input.INPUT4)
				{
					state = State.STATE3;
					System.out.print("BELT \nNEXT STATE: BELTED");
					System.out.print("TIMER OFF");
					System.out.println("\nThe car is in BELTED state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 5--Unbelt \n 0--Terminate ");
				}
				else if(input == Input.INPUT1)
				{
					state = State.STATE1;
					System.out.println("KEY \nNEXT STATE: SEATED");
					System.out.println("TIMER OFF");
					System.out.println("\nThe car is in SEATED state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 3--Unseat \n 4--Belt \n 0--Terminate ");
				}
				else if(input == Input.INPUT6)
				{
					state = State.STATE5;
					System.out.println("TIMER EXPIRED \nNEXT STATE: BUZZER");
					System.out.println("BUZZER ON");
					System.out.println("\nThe car is in BUZZER state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 4--Belt \n 0--Terminate ");
				}
				else if (input == Input.INPUT0)
				{
					state = State.STATE6;
					System.out.println("\nTERMINATED");
				}
				else
				{
					System.out.println("\nERROR RETRY");
					System.out.println("\nThe car is in TIMER state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 4--Belt \n 6--Timer Expires \n 0--Terminate ");
				}
				break;
				
			case STATE5: //BUZZER
				if(input == Input.INPUT4)
				{
					state = State.STATE3;
					System.out.println("BELT \nNEXT STATE: BELTED");
					System.out.println("BUZZER OFF");
					System.out.println("\nThe car is in BELTED state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 5--Unbelt \n 0--Terminate ");
				}
				else if(input == Input.INPUT1)
				{
					state = State.STATE2;
					System.out.println("KEY \nNEXT STATE: READY");
					System.out.println("BUZZER OFF");
					System.out.println("\nThe car is in READY state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 5--Unbelt \n 0--Terminate ");
				}
				else if (input == Input.INPUT0)
				{
					state = State.STATE6;
					System.out.println("\nTERMINATED");
				}
				else
				{
					System.out.println("\nERROR RETRY");
					System.out.println("\nThe car is in BUZZER state. What would you like to do next?");
					System.out.println("Choices: \n 1--Key \n 4--Belt \n 0--Terminate ");
				}
				break;
			case STATE6: //TERMINATE
				return;
			}
			
		
				
		}
			
			
		}
	
	}
	

