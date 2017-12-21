import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author Robert Thompson
 * Dec 7, 2017
 */

public class PetriNet
{
	Scanner scan = new Scanner(System.in);
	
	String input = "";
	String output = "";
	
	int places = 0;
	int transitions = 0;
	
	TransitionLogic[] transitionsArray;
	
	int[] initialMarking;
	int[] currentMarking;
	
	ArrayList<int[]> reachableMarkings = new ArrayList<int[]>();
	
	public PetriNet() {}
	
	public int getPlaces()
	{
		return places;
	}
	
	public int getTransitions()
	{
		return transitions;
	}
	
	public String getOutput()
	{
		return output;
	}
	
	public int[] getInitialMarking()
	{
		return initialMarking;
	}
	
	public ArrayList<int[]> getReachableMarking()
	{
		return reachableMarkings;
	}
	
	public void setPlaces (int places)
	{
		this.places = places;
	}
	
	public void setTransitions (int transitions)
	{
		this.transitions = transitions;
	}
	
	public void setInput (String input)
	{
		this.input = input;
	}
	
	public void setOutput (String output)
	{
		this.output = output;
	}
	
	public void setInitialMarking (int[] initialMarking)
	{
		this.initialMarking = initialMarking;
	}
	
	public void setReachableMarking (ArrayList<int[]> reachableMarking)
	{
		this.reachableMarkings = reachableMarking;
	}
	
	public TransitionLogic[] getTrans()
	{
		return transitionsArray;
	}
	
	public void setTransitions (TransitionLogic[] transitions)
	{
		this.transitionsArray = transitions;
	}
	
	
	public String getUserInput()
	{
		String stats = "";
		
		System.out.println("PETRI NET PROJECT");
		
		while (places <= 0)
		{
			System.out.println("Please enter a number of places: ");
			places = scan.nextInt();
		}
		
		while (transitions <= 0)
		{
			System.out.println("Please enter a number of transitions: ");
			transitions = scan.nextInt();
		}
		
		
		initialMarking = new int[places];
		
		transitionLogic();
		initialMarkingLogic();
		
		reachableMarkings.add(initialMarking.clone());
		
		System.out.println("Adding Marking to Reachable Markings: " + Arrays.toString(initialMarking));
		
		stats = "\nPlaces: " + places + "\nTransitions: " + transitions 
				+ "\nInput: " + input + "\nOutput: " + output 
				+ "\nInitial Marking: " + Arrays.toString(initialMarking);
		
		return stats;
		
	}
	
	public void transitionLogic()
	{
		transitionsArray = new TransitionLogic[transitions];
		
		String temp = "";
		
		for (int i = 1; i <= transitions; i++)
		{
			transitionsArray[i - 1] = new TransitionLogic(places);
			
			System.out.println("Enter Input for Transition t" + i);
			temp = "t" + i + ": (";
			
			for (int j = 1; j <= places; j++)
			{
				transitionsArray[i - 1].getInput()[j - 1] = -1;
				
				while (transitionsArray[i - 1].getInput()[j - 1] < 0)
				{
					System.out.println("p" + j + ": ");
					transitionsArray[i - 1].getInput()[j - 1] = scan.nextInt();
				}
				
				if (j == places)
				{
					temp += transitionsArray[i - 1].getInput()[j - 1] + ")";
				}
				else
				{
					temp += transitionsArray[i - 1].getInput()[j - 1] + ", ";
				}
			}
			
			System.out.println(temp);
			input += temp;
			
			
			System.out.println("Enter Output for Transition t" + i);
			temp = "t" + i + ": (";
			
			for (int k = 1; k <= places; k++)
			{
				transitionsArray[i - 1].getOutput()[k - 1] = -1;
				
				while (transitionsArray[i - 1].getOutput()[k - 1] < 0)
				{
					System.out.println("p" + k + ": ");
					transitionsArray[i - 1].getOutput()[k - 1] = scan.nextInt();
				}
				
				if (k == places)	
				{
					temp += transitionsArray[i - 1].getOutput()[k - 1] + ")";
				}
				else			
				{
					temp += transitionsArray[i - 1].getOutput()[k - 1] + ", ";
				}
			}
			
			System.out.println(temp);
			output += temp;
		}
	}
	
	public void initialMarkingLogic()
	{
		String temp = "";
		
		System.out.println("Please enter the initial marking: ");
		temp = "InitialMarking: (";
		
		for (int i = 1; i <= places; i++)
		{
			initialMarking[i - 1] = -1;
			
			while (initialMarking[i - 1] < 0)
			{
				System.out.println("p" + i + ": ");
				initialMarking[i - 1] = scan.nextInt();
			}
			
			if (i == places)	
			{
				temp += initialMarking[i - 1] + ")";
			}
			else			
			{
				temp += initialMarking[i - 1] + ", ";
			}
		}
		
		System.out.println(temp);
	}
	
	public void reachableMarkingsLogic(int[] markings, ArrayList<Integer> firingPath, ArrayList<int[]> history)
	{
		ArrayList<int[]> foundMarkings = new ArrayList<int[]>();
		ArrayList<Integer> firedTransitions = new ArrayList<Integer>();
		
		history.add(markings);
		
		boolean transitionFireable = false;
		
		for (int i = 0; i< transitionsArray.length; i++)
		{
			currentMarking = markings.clone();
			
			if (transitionsArray[i].isTransitionFireable(currentMarking))
			{
				transitionFireable = true;
				
				currentMarking = transitionsArray[i].subtractInputTransition(currentMarking.clone());
				currentMarking = transitionsArray[i].addOutputTransition(currentMarking.clone());
				
				for (int j = 0; j < reachableMarkings.size(); j++)
				{
					if (reachableMarkingEquality(reachableMarkings.get(j), currentMarking))
					{
						j = reachableMarkings.size() - 1;
					}
					else if (j == reachableMarkings.size() - 1)
					{
						reachableMarkings.add(currentMarking.clone());
						foundMarkings.add(currentMarking.clone());
						firedTransitions.add(i + 1);
					}
				}
			}
		}
		
		if (!transitionFireable)
		{
			System.out.println("Marking " + Arrays.toString(markings) + " is not fireable.");
			System.out.println("Path of Marking " + Arrays.toString(markings) + ": " + Arrays.toString(firingPath.toArray()));
		}
		
		int[] wArray;
		/*
		for (int i = 0; i < foundMarkings.size(); i++)
		{
			for (int j = 0; j < history.size(); j++)
			{
				if (reachableMarkingComparison(history.get(j), foundMarkings.get(i)))
				{
					wArray = foundMarkings.get(i).clone();
					foundMarkings.set(i, setW(wArray.clone(), history.get(j).clone()));
					
					for (int k = 0; k < reachableMarkings.size(); k++)
					{
						if (reachableMarkingEquality(reachableMarkings.get(k), wArray))
						{
							reachableMarkings.set(k, setW(wArray.clone(), history.get(j).clone()));
						}
					}
				}
			}
		}
		*/
		
		for (int i = 0; i < history.size(); i++)
		{
			for (int j = i + 1; j < history.size(); j++)
			{
				if (reachableMarkingEquality(history.get(i), history.get(j)))
				{
					history.remove(j);
				}
			}
		}
		
		for (int i = 0; i < reachableMarkings.size(); i++)
		{
			for (int j = i + 1; j < reachableMarkings.size(); j++)
			{
				if (reachableMarkingEquality(reachableMarkings.get(i), reachableMarkings.get(j)))
				{
					reachableMarkings.remove(j);
				}
			}
		}
		
		for (int i = 0; i < foundMarkings.size(); i++)
		{
			for (int j = i + 1; j < foundMarkings.size(); j++)
			{
				if (reachableMarkingEquality(foundMarkings.get(i), foundMarkings.get(j)))
				{
					foundMarkings.remove(j);
				}
			}
		}
		
		
		boolean stop = false;
		
		for (int i = 0; i < foundMarkings.size(); i++)
		{
			for (int j = 0; j < foundMarkings.get(i).length; j++)
			{
				if (foundMarkings.get(i)[j] > 3)
				{
					System.out.println("going over 3");
					stop = true;
				}
			}
			
			if (!stop)
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				
				temp.addAll(firingPath);
				temp.add(firedTransitions.get(i));
				
				//  need to add the fired transition to each marking being sent to findReachableMarkings
					// we start with a path
					// then we find new items for the path
					// then need to find the next level with updated path
				reachableMarkingsLogic(foundMarkings.get(i).clone(), temp, history);
			}
		}
	}
	
	/**
	 * Method that is used to determine if the markings are different or are equal
	 * @param first marking
	 * @param second marking
	 * @return true if equal and false if different
	 */
	public boolean reachableMarkingEquality (int[] first, int[] second)
	{
		for (int i = 0; i < first.length; i++)
		{
			if (first[i] != second[i])
			{
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Method that is used to determine which marking is greater than or equal to the other
	 * @param first marking
	 * @param second marking 
	 * @return true if the first marking is less than or equal to the second marking
	 * @return false if the first marking is not less than or equal to the second marking
	 */
	public boolean reachableMarkingComparison (int[] first, int[] second)
	{
		for (int i = 0; i < first.length; i++)
		{
			if ((first[i] != -1) && (second[i] != -1))
			{
				if (! (first[i] <= second[i]) )
				{
					return false;
				}
			}
			else
			{
				if (first[i] < second[i])
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Method that prints the reachable markings
	 */
	public void printReachableMarkings()
	{
		int[] printArray;
		
		for (int i = 0; i< reachableMarkings.size(); i++)
		{
			printArray = reachableMarkings.get(i).clone();
			System.out.println("M" + i + ": " +Arrays.toString(printArray));
		}
	}
	
	
	/*
	public int[] setW (int[] first, int[] second)
	{
		int[] array = new int[first.length];
		
		for (int i = 0; i < first.length; i++)
		{
			if ((first[i] != -1) && (second[i] != -1))
			{
				array[i] = first[i] - second[i];
				
				if (array[i] > 0)
				{
					first[i] = -1;
				}
			}
			else if (first[i] < second[i]) {}
		}
		
		return first;
	}
	*/
}
