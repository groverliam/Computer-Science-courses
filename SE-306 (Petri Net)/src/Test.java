import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author Robert Thompson
 * Dec 7, 2017
 */

public class Test implements ActionListener
{
	private static int places, transitions;
	private static int lastNumPlaces, lastNumTransitions;
	
    private static int myMatrix [][];
    private static int tempMatrix [][]; 
    private static int outMatrix[][];
    
	private static int result;
	
	private static TransitionLogic[] transitionsArray;
	
	private static int[] initialMarking;
	private static int[] currentMarking;
	
	private static ArrayList<int[]> reachableMarkings = new ArrayList<int[]>();
	
    private static JTextField inputField [][];
    private static JTextField initialInputField [];
    private static JButton minusB;
    private static JButton showMatrix;
    private static JButton inputMatrix;
    private static JButton initialMarkings;
    private static JPanel choosePanel [] = new JPanel[8];
	
    /**
     * Default constructor that sets the places and transitions equal to zero
     * Creates a two dimensional matrix of size 0
     * Calls the pick method  
     */
    Test()
    {
    	places = 0;
    	transitions = 0;
    	myMatrix = new int [0][0];
    	pick();
    }
    
    /**
     * Method that creates the GUI by setting the dimensions and text fields for user input
     */
    private static void getDimension()
    {
        JTextField r = new JTextField(5); 
        JTextField c = new JTextField(5); 

        JPanel panelChosen [] = new JPanel [2];
        
        panelChosen[0] = new JPanel();
        panelChosen[1] = new JPanel();
        
        panelChosen[0].add(new JLabel("Enter Dimensions") );
        
        panelChosen[1].add(new JLabel("Transitions:"));
        panelChosen[1].add(r);
        
        panelChosen[1].add(Box.createHorizontalStrut(15)); 
        
        panelChosen[1].add(new JLabel("Places:"));
        panelChosen[1].add(c);
          
        result = JOptionPane.showConfirmDialog(null, panelChosen, 
                 null,JOptionPane.OK_CANCEL_OPTION, 
                 JOptionPane.PLAIN_MESSAGE);

        lastNumPlaces = places;
        lastNumTransitions = transitions;

        if (result == 0)
        {

          if (c.getText().equals(""))
          {
             places = 0;
          }
          else
          {
             if (isInt(c.getText()))
             {
                 places = Integer.parseInt(c.getText());
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "Wrong Dimensions");
                 
                 places = lastNumPlaces;
                 transitions = lastNumTransitions;
                 
                 return;
             }
            
             if (isInt(r.getText()))
             {
                 transitions = Integer.parseInt(r.getText());
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "Wrong Dimensions");
                 
                 places = lastNumPlaces;
                 transitions = lastNumTransitions;
                 
                 return;
             }

          }

          if (places < 1 || transitions < 1)
          {
             JOptionPane.showConfirmDialog(null, "You entered wrong dimensions", 
                     "Error",JOptionPane.PLAIN_MESSAGE);
             
             places  = lastNumPlaces;
             transitions = lastNumTransitions;
          }
          else
          {
            tempMatrix = myMatrix;
            myMatrix = new int [transitions][places];
           
            if (!setElements(myMatrix, "Fill Input Matrix")) //filling the new matrix
            {
              //backup
              myMatrix = tempMatrix;
            }
            
          }
          
        }
        else if (result == 1)
        {
         places = lastNumPlaces;
         transitions = lastNumTransitions;
        }
    }
    
    /**
     * Method that is used to set the elements of the GUI 
     * @param matrix
     * @param title
     * @return true if the entered values are integers
     * @return false if the entered values are not integers
     */
    private static boolean setElements (int matrix[][], String title)
    {
    	int temp, temp1;
    	String tempString;
    	
    	transitionsArray = new TransitionLogic[transitions];
    	
        JPanel choosePanel [] = new JPanel [transitions + 2];
        choosePanel[0] = new JPanel();
        choosePanel[0].add(new Label(title));
        
        choosePanel[choosePanel.length - 1] = new JPanel();
        
        
        inputField  = new JTextField [matrix.length][matrix[0].length];

        for (temp = 1; temp <= matrix.length; temp++)
        {
            choosePanel[temp] = new JPanel();
            
            for (temp1 = 0; temp1 < matrix[0].length; temp1++)
            {
                inputField [temp - 1][temp1] = new JTextField(3);
                choosePanel[temp].add(inputField [temp - 1][temp1]);
                
                if (temp1 < matrix[0].length - 1)
                {
                	choosePanel[temp].add(Box.createHorizontalStrut(15));  
                }
                
            }//end numPlaces loop
            
        }//end numTransitions loop
        
        result = JOptionPane.showConfirmDialog(null, choosePanel, 
                null, JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
      
       
       if (result == 0)
       {
           checkTextField(inputField);
           
	       for (temp = 0; temp < matrix.length; temp++)
	       {
	    	   transitionsArray[temp] = new TransitionLogic(places);
	    	   
	        	for (temp1 = 0; temp1 < matrix[0].length; temp1++)
	            {
	                tempString = inputField[temp][temp1].getText();
	                 
	                 if (isInt(tempString))
	                 {
	                	 matrix [temp][temp1] = Integer.parseInt(inputField[temp][temp1].getText());
	                	 // Gets the input 
	                	 transitionsArray[temp].getInput()[temp] = temp;
	                	 transitionsArray[temp1].getInput()[temp1] = temp1;
	                 }
	                 else
	                 {
	                     JOptionPane.showMessageDialog(null, "You entered wrong elements");
	                     
	                     //backup
	                     places = lastNumPlaces;
	                     transitions = lastNumTransitions;
	                     
	                     return false;
	                 }                      
	             }
	       }
	       
	       return true;
       }
       else
       {
           return false;
       }
       
    }
    
    /**
     * Method that is used to set the space fields as zeros
     * @param field
     */
    private static void checkTextField (JTextField field[][])
    {
        for (int temp = 0; temp < field.length; temp++)
        {
            for (int temp1 = 0; temp1 < field[0].length; temp1++)
            {
                if (field[temp][temp1].getText().equals(""))
                {
                	field[temp][temp1].setText("0");
                }
            }
        }
    }
    
    /**
     * Method that is used for the user input of the input matrix, output matrix, and initial markings
     */
    private void pick()
    {
    	int temp;
    	
        for (temp = 0; temp < choosePanel.length; temp++)
        {
            choosePanel [temp] = new JPanel ();
        }
        
        
        choosePanel[1].add(Box.createHorizontalStrut(15)); 
        
        choosePanel[6].add(Box.createHorizontalStrut(15)); 
            
        inputMatrix = new JButton("Enter Input Matrix");
        inputMatrix.setPreferredSize(new Dimension(200,35));
        inputMatrix.addActionListener(this);
        choosePanel[2].add(inputMatrix);
     
        minusB = new JButton ("Enter Output Matrix");
        minusB.setPreferredSize(new Dimension(200,35));
        minusB.addActionListener(this);
        choosePanel[2].add(minusB);

        initialMarkings = new JButton ("Initial Markings");
        initialMarkings.setPreferredSize(new Dimension(200,35));
        initialMarkings.addActionListener(this);
        choosePanel[5].add(initialMarkings);
        
        JOptionPane.showConfirmDialog(null, choosePanel, null,
               JOptionPane.CLOSED_OPTION , JOptionPane.PLAIN_MESSAGE);
    }
    
    
    @Override
	public void actionPerformed (ActionEvent e)
	{
        if (e.getSource() == showMatrix)
        {
            showMatrix(myMatrix, "Your Matrix");
        }

        else if (e.getSource() == minusB)
        {
        	getDifferenceMatrix();
        }
        
        else if (e.getSource() == initialMarkings)
        {
            getReachableMarkings();
        }
        
        else if (e.getSource() == inputMatrix)
        {
            newMatrix();
        }		
	}  
    
    /**
     * Method that will calculate the difference between the output and input matrices
     */
    private static void getDifferenceMatrix()
    {
        if (myMatrix.length < 1)
        {
            JOptionPane.showMessageDialog(null, "You haven't entered any input matrix");
        }
        else
        {
		    int m2[][] = new int [transitions][places];
		    int sub[][] = new int [transitions][places];
		    int temp [][] = new int [transitions][places];
		    

		    if (setElements(m2, "Fill Output Matrix"))
		    {
		    	for (int i = 0; i < transitions;i++)
		    	{
		    		for (int j = 0; j < places;j++)
		    		{		    			
		    			transitionsArray[i].getOutput()[i] = i;
		    			transitionsArray[j].getOutput()[j] = j;
		    			
		    			temp[i][j] = (-1 * myMatrix[i][j]);
		    			sub[i][j] = m2[i][j] + temp[i][j];
		    		}
		    	}
		    	
		    	showMatrix(sub, "Difference Matrix Result");
		    	
		    }
        }//end else of checking
    }
    
   
    
    /**
     * NEW CODE BELOW
     */
	private static void reachableMarkingsLogic(int[] markings, ArrayList<Integer> firingPath, ArrayList<int[]> history)
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
					stop = true;
				}
			}
			
			if (!stop)
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				
				temp.addAll(firingPath);
				temp.add(firedTransitions.get(i));
				
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
	private static boolean reachableMarkingEquality (int[] first, int[] second)
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
	
    /**
     * END NEW CODE
     */
    
	
    
    private static void getReachableMarkings()
    {
    	String tempString = "";
    	JPanel imPanel [] = new JPanel [places];
    	
    	initialMarking = new int[places];
    	    	
    	for (int i = 0; i < places; i++)
    	{
    		imPanel[i] = new JPanel(); 
    		imPanel[i].add(new JLabel("Initial Marking "+ (i + 1)+":"));
    		imPanel[i].add(new JTextField(5)); 
    	}
        
         
    	result = JOptionPane.showConfirmDialog(null, imPanel, 
                null,JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.PLAIN_MESSAGE);
       
    	initialInputField  = new JTextField [initialMarking.length];

       
    	if (result == 0)
    	{
    		checkTextField(inputField);
           
    		for (int i = 0; i <= places; i++)
    		{
    			initialMarking[i] = -1;
        	   
    			tempString = initialInputField[i].getText();
    			
    			if (isInt(tempString))
    			{
	    			while (initialMarking[i] < 0)
	    			{
	    				initialMarking[i] = i;
	    			}
    			}
    			else
    			{
    				JOptionPane.showMessageDialog(null, "You entered wrong elements");
    			}
    		}
    	}
       
   		reachableMarkings.add(initialMarking.clone());
   		
   		reachableMarkingsLogic(getInitialMarking().clone(), new ArrayList<Integer>(), new ArrayList<int[]>());
   		
   		// Need to print the reachable marking below here
    }
    
    
    private static boolean isInt (String string)
    {
        int temp;
        
        if (string.length() == '0')
        {
            return false;
        }
        
        for (temp = 0; temp < string.length(); temp++)
        {
            if (string.charAt(temp) != '+' && string.charAt(temp) != '-'
                    && !Character.isDigit(string.charAt(temp)))
            {
                return false;
            }
        }
        
        return true;
    }
    
    private static void showMatrix (int[][] matrix, String title)
    {
       int temp, temp1;             
        
       JPanel panelToBeShown [] = new JPanel [matrix.length + 1];
       panelToBeShown[0] = new JPanel();
       panelToBeShown[0].add( new JLabel (title) );
   
       for (temp = 1; temp <= matrix.length; temp++)
       {
           panelToBeShown[temp] = new JPanel();
           
           for (temp1 = 0; temp1 < matrix[0].length; temp1++)
           {
               if (matrix[temp - 1][temp1] == -0)
               {
                  matrix[temp - 1][temp1] = 0; 
               }
               
               panelToBeShown[temp].add(new JLabel(Integer.toString(matrix[temp - 1][temp1])));
               
               if (temp1 < matrix[0].length - 1)
               {
            	   panelToBeShown[temp].add(Box.createHorizontalStrut(15)); 
               }
               
           }//end col loop
           
       }//end row loop
       
	    if (transitions == 0 || places == 0)
	    {
	        JOptionPane.showMessageDialog(null, "You haven't entered any input matrix");
	    }
	    else
	    {
	    	JOptionPane.showMessageDialog(null, panelToBeShown, null, 
	    			JOptionPane.PLAIN_MESSAGE, null);
	    }  
    }
    
    private static void newMatrix()
    {
    	getDimension();
    }
    
    private static int[] getInitialMarking()
    {
    	return initialMarking;
    }
     
}
