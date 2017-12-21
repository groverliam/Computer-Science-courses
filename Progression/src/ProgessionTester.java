import java.util.Scanner;

public class ProgessionTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		/*Fibonacci f = new Fibonacci(); //creates new Fibonacci sequence.
		fibSequence = f.printProgression(8); //hard coded length to 9.
		System.out.println(fibSequence); //prints 9 numbers.*/
		
		Fibonacci h = new Fibonacci(2); 
		h.printProgression(8); 
		System.out.println(" "); 
		
		/*Fibonacci g = new Fibonacci(); //creates new Fibonacci sequence.
		System.out.println("How long would you like it to be?");
		int choice = in.nextInt();
		fibSequence = g.printProgression(choice); 
		System.out.println(fibSequence);*/
		
		

		
	}

}
