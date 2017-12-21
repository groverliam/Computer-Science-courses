import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class mainMem {

	public static void main(String[] args) {
		String str;
		ArrayList<Job> jobTable = new ArrayList<Job>();
		String[] data = new String[3];
		int n = 0;
		int tempId;
		int tempSize;
		int tempTime;
		//MMT[] mmt = {new MMT(1), new MMT(2), new MMT(3), new MMT(4), new MMT(5), new MMT(6), new MMT(7), new MMT(8), new MMT(9), new MMT(10)};
		int availF;
		boolean allDone = false;
		boolean MTfull = false;
		int am = 0;
		Job temp;
		boolean apples = false;
		HashMap<Integer,Boolean> mem = new HashMap<Integer, Boolean>();
		mem.put(1, true);
		mem.put(2, true);
		mem.put(3, true);
		mem.put(4, true);
		mem.put(5, true);
		mem.put(6, true);
		mem.put(7, true);
		mem.put(8, true);
		mem.put(9, true);
		mem.put(10, true);

		int f = 0;


		Scanner scan;
		File file = new File("/Users/admin/Desktop/CS/Op_Sys_Lab2Second/src/inputFile");
		try {
			scan = new Scanner(file);
			while(scan.hasNext())
			{
				str = (scan.next());
				data = str.split(",");
				tempId = (int)Double.parseDouble(data[0]);
				tempSize = (int) Double.parseDouble(data[1]);
				tempTime = (int)Double.parseDouble(data[2]);
				jobTable.add(new Job(tempId,tempSize,tempTime));
				n++;
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		for(int i = 0; i < n; i++)
		{
			jobTable.get(i).page();

		}//Pages

		printJobsinTable(jobTable);
		printPTs(jobTable);
		System.out.println("MEMORY MAP CHUNKS AVAILABLE:" +mem.values()+"\n");


		while( apples != true)
		{
			System.out.println("MEMORY MAP CHUNKS AVAILABLE:" +mem.values()+"\n");
			for(int w = 0; w < jobTable.size(); w++)
			{
				for(int a = 0; a < jobTable.get(w).getNumPages(); a++)
				{
					//for(int q= 1; q <= 10; q++)

					if(mem.get(1))
					{
						mem.replace(1, false);
						jobTable.get(w).getPage(a).setML(1);
						jobTable.get(w).getPage(a).setRunning();
						printPTs(jobTable);
						
					}
					else if(mem.get(2))
					{
						mem.replace(2, false);
						jobTable.get(w).getPage(a).setML(2);
						jobTable.get(w).getPage(a).setRunning();
						printPTs(jobTable);

					}
					else if(mem.get(3))
					{
						mem.replace(3, false);
						jobTable.get(w).getPage(a).setML(3);
						jobTable.get(w).getPage(a).setRunning();
						printPTs(jobTable);

					}
					else if(mem.get(4))
					{
						mem.replace(4, false);
						jobTable.get(w).getPage(a).setML(4);
						jobTable.get(w).getPage(a).setRunning();
						printPTs(jobTable);

					}
					else if(mem.get(5))
					{
						mem.replace(5, false);
						jobTable.get(w).getPage(a).setML(5);
						jobTable.get(w).getPage(a).setRunning();
						printPTs(jobTable);

					}
					else if(mem.get(6))
					{
						mem.replace(6, false);
						jobTable.get(w).getPage(a).setML(6);
						jobTable.get(w).getPage(a).setRunning();
						printPTs(jobTable);

					}
					else if(mem.get(7))
					{
						mem.replace(7, false);
						jobTable.get(w).getPage(a).setML(7);
						jobTable.get(w).getPage(a).setRunning();
						printPTs(jobTable);

					}
					else if(mem.get(8))
					{
						mem.replace(8, false);
						jobTable.get(w).getPage(a).setML(8);
						jobTable.get(w).getPage(a).setRunning();
						printPTs(jobTable);

					}
					else if(mem.get(9))
					{
						mem.replace(9, false);
						jobTable.get(w).getPage(a).setML(9);
						jobTable.get(w).getPage(a).setRunning();
						printPTs(jobTable);

					}
					else if(mem.get(10))
					{
						mem.replace(10, false);
						jobTable.get(w).getPage(a).setML(10);
						jobTable.get(w).getPage(a).setRunning();
						printPTs(jobTable);

					}
					else
					{
						System.out.print("MUST WAIT UNTIL SPACE FREES UP BEFORE NEXT JOB.\n\n\n\n");
						a--;
					}
				
					for(int i = 0; i < jobTable.size(); i++)
					{
						am = jobTable.get(i).getNumPages();
						for(int k = 0; k < am; k++)
						{
							if(jobTable.get(i).getPage(k).running() && !jobTable.get(i).getPage(k).complete())
							{
								jobTable.get(i).getPage(k).minusOne();
								if(jobTable.get(i).getPage(k).getTime() > 0)
								{
								System.out.println("Job "+jobTable.get(i).getId()+"'s Page# "+jobTable.get(i).getPage(k).getId()+"'s Time left is "+jobTable.get(i).getPage(k).getTime()+" seconds.\n");
								}
								else if(jobTable.get(i).getPage(k).getTime() <= 0 )
								{
									jobTable.get(i).getPage(k).endJob();
									mem.replace(jobTable.get(i).getPage(k).getML(), true);
									jobTable.get(i).getPage(k).setML(999);
									System.out.println("Job "+jobTable.get(i).getId()+"'s Page# "+jobTable.get(i).getPage(k).getId()+" is done.\n");
								}
							}

						}

					}


				}
			}
			for(int i = 0; i < jobTable.size(); i++)
			{
				am = jobTable.get(i).getNumPages();
				for(int k = 0; k < am; k++)
				{
					if(jobTable.get(i).getPage(k).getML() != 999)
					{
						apples = false;
						k = am;
					}
					else
					{
						apples = true;
					}
				}
			}
		}
		//System.out.println(jobTable.get(0).getPage(0).getML());
		
		
		for(int x = 1; x <= 10; x++)
		{
			if(!mem.get(x))
			{
				for(int i = 0; i < jobTable.size(); i++)
				{
					am = jobTable.get(i).getNumPages();
					for(int k = 0; k < am; k++)
					{
						if(jobTable.get(i).getPage(k).running() && !jobTable.get(i).getPage(k).complete())
						{
							jobTable.get(i).getPage(k).minusOne();
							if(jobTable.get(i).getPage(k).getTime() > 0)
							{
							System.out.println("Job "+jobTable.get(i).getId()+"'s Page# "+jobTable.get(i).getPage(k).getId()+"'s Time left is "+jobTable.get(i).getPage(k).getTime()+" seconds.\n");
							}
							else if(jobTable.get(i).getPage(k).getTime() <= 0 )
							{
								jobTable.get(i).getPage(k).endJob();
								mem.replace(jobTable.get(i).getPage(k).getML(), true);
								jobTable.get(i).getPage(k).setML(999);
								System.out.println("Job "+jobTable.get(i).getId()+"'s Page# "+jobTable.get(i).getPage(k).getId()+" is done.\n");
							}
						}

					}

				}
			}
		}
		
		
		
		
		
		System.out.println("MEMORY MAP TABLE AVAILABLE: ");
		for(int x = 1; x <= 10; x++)
		{
			System.out.println("MEMORY MAP CHUNK # "+x+": " +mem.get(x)+".");
		}
		System.out.println("\n");
		printPTs(jobTable);
		

	}


	public static void printJobsinTable(ArrayList<Job> j)
	{

		System.out.println("Jobs in Table: ");

		for(int i = 0; i < j.size(); i++)
		{
			j.get(i).print();

		}

		System.out.println("\n");

	}

	public static void pageAll(ArrayList<Job> j)
	{
		for(int i = 0; i < j.size(); i++)
		{
			j.get(i).page();

		}
	}

	public static void printPTs(ArrayList<Job> j)
	{

		for(int i = 0; i < j.size(); i++)
		{
			System.out.println("Job "+j.get(i).getId()+" Page Table: ");

			for(int k = 0; k < j.get(i).getNumPages(); k++)
			{

				if(j.get(i).getPage(k).complete())
				{
					System.out.println("ID: "+j.get(i).getPage(k).getId()+" Memory map location: Finished");
				}
				else if(j.get(i).getPage(k).getML() != (-1))
				{
					System.out.println("ID: "+j.get(i).getPage(k).getId()+" Memory map location: "+ j.get(i).getPage(k).getML());
				}
				else
				{
					System.out.println("ID: "+j.get(i).getPage(k).getId()+" Memory map location: N/A");
				}
			}
			System.out.println("\n");

		}
	}

	public static Job getPage(ArrayList<Job> j)
	{
		Job temp;
		int am;
		for(int i = 0; i < j.size(); i++)
		{
			am = j.get(i).getNumPages();
			for(int k = 0; k < am; k++)
			{
				temp = j.get(i).getPage(k);
				if(!temp.complete())
				{
					return temp;
				}

			}

		}
		System.out.println("No more jobs");
		//done = complete();
		return null;
	}
	public static boolean complete()
	{
		return true;
	}


}
