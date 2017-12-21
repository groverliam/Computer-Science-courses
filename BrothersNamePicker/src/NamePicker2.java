import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class NamePicker2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final String[] BROTHERS = {
				"james","baxter","alberto","schwartz","woodin",
				"billy","brandon", "colin",
				"frankie","kearney","john brown",
				"J rod","jo lo","liam","matt brown","manheimer","max",
				"mike Allegretta","toto","paul matt","vincent",
				"richie","rj","scott","anthony", "Connor", "Bryan", "Urim", "Giorgio", 
                 "Evan", "Tyler", "Joey", "Austin"
		};
                System.out.println("There are "+ (BROTHERS.length-1)+ " brothers.");
		System.out.println("How many brothers are needed?");
		int count = in.nextInt();
                int needed= count;
                String n;
		while (count != 0)
		{
                     ArrayList<String> picked = new ArrayList<String>();
                   
			for (int i = 0; i < needed; i++)
			{
				int num = ThreadLocalRandom.current().nextInt(0, BROTHERS.length);
				if (picked.contains(BROTHERS[num]))
                                {
                                    needed--;
                                    i--;
                                    //System.out.println("Count is: "+ count);
                                }
                                else
                                {
                                    picked.add(BROTHERS[num]);
                                    //System.out.println("Count is: "+ count);
                                }
			}
                        System.out.println(picked);
                        System.out.println("The amount of brothers picked is: "+ picked.size());


                        /*for(String p: picked)
                        {
                            System.out.println(picked);
                        }*/
			System.out.println("How many brothers are needed?");
			count = in.nextInt();
                        needed= count;
		}

	}

}

