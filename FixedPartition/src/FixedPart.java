import java.util.ArrayList;

public class FixedPart {

	public static void main(String[] args) {
		double[] freePartitions = {25.0, 25.0, 25.0, 50.0, 50.0, 50.0, 75.0, 100.0, 100.0};
		boolean[] busy = {false, false, false, false, false, false, false, false, false};
		int[] wait = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		Job[] jobList = new Job[9];
		jobList[0] = (new Job(67.0, "Job 1"));
		jobList[1] = (new Job( 1.4, "Job 2"));
		jobList[2] = (new Job(89.1, "Job 3"));
		jobList[3] = (new Job(36.9, "Job 4"));
		jobList[4] = (new Job(25.1, "Job 5"));
		jobList[5] = (new Job(24.9, "Job 6"));
		jobList[6] = (new Job(10.3, "Job 7"));
		jobList[7] = (new Job(47.0, "Job 8"));
		jobList[8] = (new Job(90.4, "Job 9"));

		for(int j = 0; j < jobList.length; j++)
		{
			int k = 8;
			//jobSizeRunning = jobList[j].getSize();
			insertWait(j, wait);
			System.out.println("Job "+(j+1)+" is now waiting.");

				if(getWaitJob(j, wait) < freePartitions[k])
				{
					if(busy[k]== false)
					{
						System.out.println("Job "+(j+1)+" is now running.");
						busy[k] = true;
						jobList[j].setTime(5);
						updateWaitList(wait, j);

					}
				}
				else 
				{
					
				}
			
			for(int w = 0; w < j; w++)
			{
				if(jobList[w].getTime() <= 5)
				{
			countDown(w, jobList);
				}
			}
			for(int w = j+1; w < jobList.length; w++)
			{
				if(jobList[w].getTime() <= 5)
				{
			countDown(w, jobList);
				}
			}
			k--;
		}
		
		


	}

	public static boolean jobsRunning(boolean[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			if (a[i]==true)
			{
				return true;
			}
		}
		return false;
	}
	
	public static int getWaitJob(int d, int[] wait)
	{
		return wait[d];
	}
	
	public static void insertWait(int d, int[] wait)
	{
		for(int i = 0; i < wait.length; i++)
		{
			if(wait[i] == 0)
			{
				wait[i] = d;
				//System.out.println("Job "+(i+1)+" is now waiting.");
			}
		}
	}
	
	public static void updateWaitList(int[] wait, int q)
	{
		//double temp;
		for (int i = q ; i < wait.length; i++)
		{
			if(wait[i] != 0)
			{
				wait[i-1]= wait[i];
			}
			if(i == 8)
			{
				//do nothing
			}
			else if(wait[i+1] == 0)
			{
				wait[i] = 0;
			}
		}
	}
	
	public static  void countDown(int j, Job[] b)
	{
				if(b[j].getTime() != 0)
				{
				//b[i].setTime();
				b[j].count();
				System.out.println("Job "+(j+1)+" has "+ b[j].getTime()+ " seconds left.");
				}
				else if (b[j].getTime() == 0)
				{
					//System.out.println("Job "+(i+1)+" is complete.");
					
				}
				}
			
}

