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
		System.out.println("Enter the digits of the safe!");
		while(true)
		{
			//enter a num from keyboard
			System.out.println("Please enter a number:");
			num = in.nextInt();
			
			//convert num to input & assign to input
			input = Input.fromInt(num);
			
			//switch(state)
			//case input
			//state transition
			switch(state)
			{
			
			case STATE0:
				if(input == Input.INPUT2)
				{
					state = State.STATE1;
					System.out.print("Passed 1st, 3 LEFT: ");
				}
				else
				{
					System.out.println("WRONG INPUT");
					state = State.STATE0;
				}
				break;
					
			
			case STATE1:
				if(input == Input.INPUT0)
				{
					state = State.STATE2;
					System.out.print("Passed 2nd, 2 LEFT: ");
				}
				else
				{
					System.out.println("WRONG INPUT");
					state = State.STATE0;
				}
				break;
					
			case STATE2:
				if(input == Input.INPUT1)
				{
					state = State.STATE3;
					System.out.print("Passed 3rd, 1 LEFT: ");
				}
				else
				{
					System.out.println("WRONG INPUT");
					state = State.STATE0;
				}
				break;
				
			case STATE3:
				if(input == Input.INPUT7)
				{
					state = State.STATE4;
					System.out.print("Passed All \n");
				}
				else
				{
					System.out.println("WRONG INPUT");
					state = State.STATE0;
				}
				break;
				
			case STATE4:
				System.out.println("Good fucking job");
				return;
			}
			
		
				
		}
			
			
		}
	}
	

