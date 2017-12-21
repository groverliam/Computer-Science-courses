import java.util.ArrayList;

/**
 * @author Robert Thompson
 * Dec 7, 2017
 */

public class PetriNetLauncher
{
	public static void main(String[] args)
	{
		PetriNet rob = new PetriNet();
		
		System.out.println(rob.getUserInput());
		
		rob.reachableMarkingsLogic(rob.getInitialMarking().clone(), new ArrayList<Integer>(), new ArrayList<int[]>());
		rob.printReachableMarkings();
	}
}
