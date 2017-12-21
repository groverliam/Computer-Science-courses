import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class test {

	public static void main(String[] args) {

		    Scanner scan;
		    File file = new File("/Users/admin/Desktop/CS/TestFileInput/src/testfile");
		    try {
		        scan = new Scanner(file);

		        while(scan.hasNextDouble())
		        {
		            System.out.println( scan.nextDouble() );
		        }

		    } catch (FileNotFoundException e1) {
		            e1.printStackTrace();
		    }

		}
	}


