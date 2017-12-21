package secondAttemptFixedPartition;

import java.util.*;

public class Fixed {

	public static void main(String[] args) {
		//ArrayList<Job> jobsWaiting = new ArrayList<Job>();
		//ArrayList<Job> jobsRunning = new ArrayList<Job>();
		Job[] jobsWaiting = new Job[9];
		Job[] jobsRunning = new Job[9];
		//FreePartitions f = new FreePartitions(); 
		boolean[] partitions = {false, false, false, false, false, false, false, false, false};
		double[] partitionSize = {100.0, 100.0, 75.0, 50.0, 50.0, 50.0, 25.0, 25.0, 25.0};
		jobsWaiting[0] = (new Job(54.3, "job 1"));
		jobsWaiting[1] = (new Job(99.9, "job 2"));
		jobsWaiting[2] = (new Job(70.3, "job 3"));
		jobsWaiting[3] = (new Job(50.4, "job 4"));
		jobsWaiting[4] = (new Job(76.9, "job 5"));
		int jobCount = 0;
		int jobRunningSize = 0;
		double tempSize;
		//printJobsWaiting(jobsWaiting);
		while (jobsWaiting.length != 0)
		{
			//printJobsRunning(jobsRunning);
			tempSize = jobsWaiting[jobCount].getSize();
			for(int i = 0; i < 9; i++) //9 is number of partitions
			{
				if(tempSize < partitionSize[i] && (partitions[i]==false))
				{
					setBusy(i, partitions);
					jobsWaiting[jobCount].startJob();
					jobsRunning[jobRunningSize] = (jobsWaiting[jobCount]);
					jobRunningSize++;
					updateJobsWaiting(i,jobsWaiting);
					//jobsWaiting.remove(i);
				}
				else
				{
					System.out.println("No available partitions for a job of that size.");
				}
			}





			runJobs(jobsRunning);
			update(jobsRunning, partitions);
			jobCount++;
		}



	}
	public static void updateJobsWaiting(int k, Job[] j)
	{
		for(int w = k; w < j.length; w++)
		{
				if(j[w+1] != null)
				{
					j[w]=j[w+1];
				}
				else
				{
					j[w] = null;
				}
				
			}
		}
	
	public static void runJobs(Job[] j)
	{
		for(int y = 0 ; y < j.length; y++)
		{
			j[y].countDownJob();
		}
	}
	public static void printJobsWaiting(Job[] j)
	{
		System.out.println("Jobs waiting: ");
		for(int i = 0; i < j.length; i++)
		{
			System.out.println((i+1)+ ") "+j[i].getName());
		}
	}
	public static void printJobsRunning(Job[] j)
	{
		int num;
		System.out.println("Jobs running: ");
		for(int i = 0; i < j.length; i++)
		{
			num = i+1;
			System.out.print(num+ ") "+ j[i].getName());
			System.out.println(" has "+j[i].getTime()+" seconds left.");
		}
	}
	/*public void clearJob(int i, Job[] j)
	{
		Scanner in = new Scanner(System.in);
		String ans;
		//int num;
		//printJobsWaiting();
		//System.out.println("What job would you like to remove?");
		//num = (in.nextInt()-1);
		System.out.println("The job you want to remove is : " +j[i].getName()+"\n Are you sure you want to remove it?");
		ans = in.nextLine().toLowerCase();
		if(ans.equals("yes"))
		{
			j.remove(i);
			System.out.println("The job was removed.");
		}
		else
		{
			System.out.println("The job was not removed.");
		}
	}*/
	public static void update(Job[] j, boolean[] p)
	{
		Job temp;
		for(int w = 0; w < j.length; w++)
		{
			if(j[w].getTime() != 0)
			{
				System.out.println(j[w].getName()+" is complete.");
				if(j[w+1] != null)
				{
					j[w]=j[w+1];
				}
				else
				{
					j[w] = null;
				}
				setFree(w, p);
			}
		}
	}
	public static void setFree(int desired, boolean[] p)
	{
		//int real = desired-1;
		if(p[desired] == true)
		{
			p[desired] = false;
		}
	}
	public static void setBusy(int desired, boolean[] p)
	{
		//int real = desired-1;
		if(p[desired] == false)
		{
			p[desired] = true;
		}
	}
	public boolean getStatus(int desired, boolean[] p)
	{
		return p[desired];
	}
}
