import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This 
 * @author Liam Grover
 *
 */
public class FixedPart implements Runnable{

	static int[] freePartitions = {25, 25, 25, 50, 50, 50, 75, 100, 100};
	static boolean[] busy = {false, false, false, false, false, false, false, false, false};
	static ArrayList<Job> wait =  new ArrayList<Job>();
	static ArrayList<Job> jobList = new ArrayList<Job>();
	Thread t;
	Job temp;
	int j = 0;
	int tempId;
	int tempSize;
	int tempTime;
	String[] data = new String[3];
	String str;
	int n = 0;
	File file;

	public FixedPart(File f)
	{
		file = f;
	}

	public void run()
	{

		Scanner scan;
		//File file = new File("/Users/admin/Desktop/CS/Op_Sys_3-24/src/inputFile");
		try {
			scan = new Scanner(file);
			while(scan.hasNext())
			{
				try{
					
				str = (scan.next());
				data = str.split(",");
				try {
					tempId = (int)Double.parseDouble(data[0]);
				} catch (NumberFormatException e) {
					//error
					tempId = -1;
					System.out.println("ERROR WITH \"ID\"");
				}
				try {
					tempSize = (int) Double.parseDouble(data[1]);
				} catch (NumberFormatException e) {
					//error
					tempSize = -1;
					System.out.println("ERROR WITH \"Size\"");
				}
				try {
					tempTime = (int)Double.parseDouble(data[2]);
				} catch (NumberFormatException e) {
					//error
					tempTime = -1;
					System.out.println("ERROR WITH \"Time\"");
				}
				if(tempId >= 0 && tempSize >= 0 && tempTime >= 0)
				{
					jobList.add(new Job(tempId,tempSize,tempTime));
				}
				else
				{
					System.out.println("ERROR WITH JOB");
				}
				n++;
				} catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("ERROR WITH JOB: Too many inputs for job.");
				}
				
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		int k = 8;

		while(!jobList.isEmpty() && j != n)
		{

			if(!jobList.get(j).isWaiting())
			{
				System.out.println("Job "+jobList.get(j).getJobId()+" is now waiting.");
			}



			if( jobList.get(j).getSize() <= freePartitions[k])
			{


				if(busy[k] == false)
				{

					busy[k] = true;
					jobList.get(j).setL(k);
					jobList.get(j).start();
					jobList.remove(j);

				}

				else
				{

					k--;
				}
			}
			k--;
			if(k==-1)
			{
				jobList.add(jobList.get(j));
				jobList.remove(j);
				k=8;
			}
		}


	}

	public void start()
	{

		if (t == null) {
			t = new Thread (this);
			t.start ();
		}
	}



}



