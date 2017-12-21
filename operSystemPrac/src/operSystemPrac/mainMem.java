
package operSystemPrac;
import java.util.*;

public class mainMem {

	public static void main(String[] args) 
	{
		double mainMem = 128.0;
		ArrayList job = new ArrayList<>();
		job.add(20.4);
		job.add(0.6);
		job.add(3.7);
		job.add(40.5);
		job.add(26.3);
		job.add(0.7);
		job.add(50.2);
		
		int numOfPartitions = 1;
		double jobSize;
		
		System.out.println("MEMORY = "+mainMem+" kB");
		System.out.println("There are "+numOfPartitions+" partitions");
		for(int i = 0; i < job.size(); i++)
		{
		jobSize= (double) job.get(i);
		
		if (jobSize < mainMem)
		{
			System.out.println("JOB SIZE = "+jobSize+" kB");
			mainMem = mainMem - jobSize;
			numOfPartitions++;
		}
		else
		{
			System.out.println("JOB SIZE = "+jobSize+" kB");
			System.out.println("JOB SIZE TOO LARGE FOR "+mainMem+" kB partition.\n");
			//System.out.println("\n\tMEMORY FULL");
		}
		System.out.println("There are "+numOfPartitions+" partitions");
		System.out.println("MEMORY AVAILABLE= "+mainMem+" kB");
		}


	}

}
