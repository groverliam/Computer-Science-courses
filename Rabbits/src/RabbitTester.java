import java.util.Scanner;
public class RabbitTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Rabbits r = new Rabbits();
		System.out.println("How many months would you like to pass?");
		int ans = in.nextInt();
		//r.printProgression(ans);
		r.duplicate(ans);
		System.out.println(r.getKids()+" set of kids and "+r.getAdults()+" set of adults" );

	}

}
