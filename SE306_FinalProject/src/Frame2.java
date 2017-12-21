
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame2 implements ActionListener 
{
     private static int numPlaces, numTransitions; 
     private static int myMatrix [][];
     private static int tempMatrix [][]; 
     private static int initMarkings[];
     
     private static JTextField inputField [][];
     private static int result;
     private static JButton minusB;
     private static JButton showMatrix;
     private static JButton inputMatrix;
     private static JButton initialMarkings;
     private static JPanel choosePanel [] = new JPanel[8];
     private static int lastnumPlaces , lastnumTransitions ;
     private static int[] initM;
     
     Frame2 ()
     {
         numPlaces = numTransitions = 0;
         myMatrix = new int [0][0];
         pick();
     }

     private static void getDimension() 
    {
      JTextField r = new JTextField(5); 
      JTextField c = new JTextField(5); 

      JPanel panelChosen [] = new JPanel [2];
       panelChosen [0] = new JPanel();
       panelChosen [1] = new JPanel();
      panelChosen[0].add(new JLabel("Enter Dimensions") );
      panelChosen[1].add(new JLabel("numTransitions:"));
      panelChosen[1].add(r);
      panelChosen[1].add(Box.createHorizontalStrut(15)); 
      panelChosen[1].add(new JLabel("numPlaces:"));
      panelChosen[1].add(c);
        
      result = JOptionPane.showConfirmDialog(null, panelChosen, 
               null,JOptionPane.OK_CANCEL_OPTION, 
               JOptionPane.PLAIN_MESSAGE);

      lastnumPlaces = numPlaces;
      lastnumTransitions = numTransitions;

       if(result == 0)
       {
         
         if(c.getText().equals(""))
             numPlaces = 0;
         else
         {
             if(isInt(c.getText()))
             {
                 numPlaces = Integer.parseInt(c.getText());
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "Wrong Dimensions");
                 numPlaces = lastnumPlaces;
                 numTransitions = lastnumTransitions;
                 return;
             }
            
             if(isInt(r.getText()))
             {
                 numTransitions = Integer.parseInt(r.getText());
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "Wrong Dimensions");
                 numPlaces = lastnumPlaces;
                 numTransitions = lastnumTransitions;
                 return;
             }
          
         }
       if(numPlaces < 1 || numTransitions < 1)
       {
           JOptionPane.showConfirmDialog(null, "You entered wrong dimensions", 
                   "Error",JOptionPane.PLAIN_MESSAGE);
           numPlaces  = lastnumPlaces;
           numTransitions = lastnumTransitions;
          
       }
       else
       {
           tempMatrix = myMatrix;
           myMatrix = new int [numTransitions][numPlaces];
            if(!setElements(myMatrix, "Fill Input matrix")) //filling the new matrix
            {
                //backup
                
                myMatrix = tempMatrix;
            }
       }
       }
       else if(result == 1)
       {
           numPlaces = lastnumPlaces;
           numTransitions = lastnumTransitions;
       }
     }//end get Dimension

    private static boolean setElements(int matrix [][], String title )
    {
        int temp, temp1;           
        String tempString;
        
       JPanel choosePanel [] = new JPanel [numTransitions+2];
       choosePanel[0] = new JPanel();
       choosePanel[0].add(new Label(title ));
       choosePanel[choosePanel.length-1] = new JPanel();
       choosePanel[choosePanel.length-1].add(new Label("consider space field as zeros"));
       inputField  = new JTextField [matrix.length][matrix[0].length];

       for(temp = 1; temp <= matrix.length; temp++)
       {
           choosePanel[temp] = new JPanel();
           
           
           for(temp1 = 0; temp1 < matrix[0].length; temp1++)
           {
               inputField [temp-1][temp1] = new JTextField(3);
               choosePanel[temp].add(inputField [temp-1][temp1]);
               
               if(temp1 < matrix[0].length -1)
               {
               choosePanel[temp].add(Box.createHorizontalStrut(15));  
               }
               
           }//end numPlaces loop
           
       }//end numTransitions loop
       
       result = JOptionPane.showConfirmDialog(null, choosePanel, 
               null, JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
     
      
      if(result == 0)
      {
          checkTextField(inputField);
       for(temp = 0; temp < matrix.length; temp++)
       {
        for(temp1 = 0; temp1 < matrix[0].length; temp1++)
            {
                tempString = inputField[temp][temp1].getText();
                
                
                if(isInt(tempString))
                {
                matrix [temp][temp1] = Integer.parseInt(inputField[temp][temp1].getText());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You entered wrong elements");
                    
                    //backup
                    numPlaces = lastnumPlaces;
                    numTransitions = lastnumTransitions;
                    
                    return false;
                }                      
            }
       }
       return true;
    }
      else
          return false;
    
      
    }//end get Inputs
    
    //for setting spaced fields as zeros
     private static void checkTextField (JTextField field [][] )
     {
         for(int temp = 0; temp < field.length; temp++)
         {
             for(int temp1 = 0; temp1 < field[0].length; temp1++)
             {
                 if(field[temp][temp1].getText().equals(""))
                 field[temp][temp1].setText("0");
             }
         }
     }//end reset
     
    private void pick ()
    {
        int temp;
        
        
        for(temp = 0; temp < choosePanel.length; temp++)
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
    public  void actionPerformed(ActionEvent e) 
    {
        
        if(e.getSource() == showMatrix)
        {
            showMatrix( myMatrix, "Your Matrix");
        }

        else if(e.getSource() == minusB)
        {
            get();
        }
        
        else if(e.getSource() == initialMarkings)
        {
            getReachableMarks();
        }
        
        else   if(e.getSource() == inputMatrix)
        {
            newMatrix();
        }
    }//end action performed

    
   
private static void getReachableMarks() 
{
	JPanel imPanel [] = new JPanel [numPlaces];
	for(int i = 0; i < numPlaces; i++)
	{
		imPanel[i] = new JPanel(); 
		imPanel[i].add(new JLabel("Initial Marking "+(i+1)+":"));
		imPanel[i].add(new JTextField(5)); 
	}
    
	
     
   result = JOptionPane.showConfirmDialog(null, imPanel, 
            null,JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.PLAIN_MESSAGE);
		
		
}

private static void get ()
{

    if(myMatrix.length < 1)
        {
            JOptionPane.showMessageDialog(null, "You haven't entered any input matrix");
        }
        else
        {
    int m2[][]=new int [numTransitions][numPlaces];
    int sub[][] = new int [numTransitions][numPlaces];
    int temp [][] = new int [numTransitions][numPlaces];


    if(setElements(m2, "Fill Output Matrix"))
    {

for(int i=0;i<numTransitions;i++)
{
for(int j=0;j<numPlaces;j++)
{
    //temp[i][j]=(-1*m2[i][j]);
	temp[i][j] = (-1*myMatrix[i][j]);
    sub[i][j]=m2[i][j]+temp[i][j];
}
}
    showMatrix(sub, "A Result");
    }
        }//end else of checking
}  
   private static boolean isInt (String str)
   {
       int temp;
       if (str.length() == '0')
           return false;
       
       for(temp = 0; temp < str.length();temp++)
       {
           if(str.charAt(temp) != '+' && str.charAt(temp) != '-'
                   && !Character.isDigit(str.charAt(temp)))
           {
               return false;
           }
       }
       return true;
   }
   
    private static void showMatrix(int [][] matrix, String title )
    {
        int temp, temp1;             
        
       JPanel panelToBeShown [] = new JPanel [matrix.length+1];
       panelToBeShown[0] = new JPanel ();
       panelToBeShown[0].add( new JLabel (title) );
   
       for(temp = 1; temp <= matrix.length; temp++)
       {
           panelToBeShown[temp] = new JPanel();
           
           
           for(temp1 = 0; temp1 < matrix[0].length; temp1++)
           {
               if(matrix[temp-1][temp1] == -0)
               {
                  matrix[temp-1][temp1] = 0; 
               }
               panelToBeShown[temp].add(new JLabel(Integer.toString(matrix[temp-1][temp1])));
               
               if(temp1 < matrix[0].length -1)
               {
               panelToBeShown[temp].add(Box.createHorizontalStrut(15)); 
               }
               
           }//end col loop
           
       }//end row loop
       
    if(numTransitions == 0 || numPlaces == 0)
    {
        JOptionPane.showMessageDialog(null, "You haven't entered any input matrix");
    }
    else
    {
    
    JOptionPane.showMessageDialog(null, panelToBeShown, null, 
            JOptionPane.PLAIN_MESSAGE, null);
    }  
    }//end show Matrix

    private static void newMatrix ()
    {        
        getDimension();
    }
     public static void main (String [] args)
    {
        Frame2 m1 = new Frame2 ();
        
    }
}//end class

