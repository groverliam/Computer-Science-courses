import java.util.Scanner;
import java.io.*;
public class MeanAndStdDev {

	public static void main(String[] args) {
		MyLinkedList Mlist = new MyLinkedList();
		MyLinkedList SDlist = new MyLinkedList();
		//double n = 0;
		double data;
		Calculations calc = new Calculations();
		Scanner in = new Scanner(System.in);
		Scanner scan;
	    File file = new File("/Users/admin/Desktop/CS/MeanAndStdDev/src/inputFile");
	    System.out.println("The data inputed from the file is: ");
	    try {
	        scan = new Scanner(file);

	        while(scan.hasNextDouble())
	        {
	            data = (scan.nextDouble() );
	    	    System.out.println(data);
	            Mlist.add(data);
	            SDlist.add(data);
	        }

	    } catch (FileNotFoundException e1) {
	            e1.printStackTrace();
	    }
		/*Mlist.add(67.2);
		Mlist.add(77.2);
		Mlist.add(68.3);
		Mlist.add(71.5);
		Mlist.add(69.0);
		Mlist.add(75.8);
		Mlist.add(73.3);
		Mlist.add(72.2);
		
		SDlist.add(67.2);
		SDlist.add(77.2);
		SDlist.add(68.3);
		SDlist.add(71.5);
		SDlist.add(69.0);
		SDlist.add(75.8);
		SDlist.add(73.3);
		SDlist.add(72.2);*/
		/*while(n != 1)
		{
		System.out.println("Enter data or type -1");
		data = in.nextDouble() ;
		if (data >= 0)
		{
			Mlist.add(data);
			SDlist.add(data);
		}
		else
		{
			n = 1;
		}
		}*/

		System.out.println("Pick your choice.");
		System.out.println("1) Mean");
		System.out.println("2) Standard Deviation");

		int choice = in.nextInt();
		if(choice == 1)
		{
			
			calc.getMean(Mlist);
		}
		else if(choice == 2)
		{
			System.out.println(calc.getStdDev(SDlist, Mlist));
		}

		else
		{
			System.out.println("INVALID SELECTION");

		}
		
	}

}
