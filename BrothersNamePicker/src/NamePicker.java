import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NamePicker {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] brothers = {
				"james","baxter","alberto","schwartz",
                "woodin", "billy","brandon", "colin",
                "frankie","kearney","john brown",
                "J rod","jo lo","liam","matt brown","manheimer","max",
                "mike Allegretta","toto","paul matt","vincent",
                "richie","rj","scott","anthony", "Connor", "Bryan", "Urim", "Giorgio",
                "Evan", "Tyler", "Joey", "Austin"
		};
		System.out.println("How many brothers are needed?");
		int count = in.nextInt();
		while (count != 0)
		{
		
			for (int i = 0; i < count; i++)
			{
				int num = ThreadLocalRandom.current().nextInt(0, brothers.length);
				System.out.println(brothers[num]);
			}
			System.out.println("How many brothers are needed?");
			count = in.nextInt();
		}

	}

}
