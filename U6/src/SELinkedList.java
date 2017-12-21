
/**
 * Title: Agile U6 - Statistical Package
 * 
 * Description: This class allows for the calculation of the mean, variance, standard deviation, correlation, z scores, normal distribution values,
 * regression parameters, and t distribution values. The methods used for calculation are used in the linked list class
 * in order for a more clear and precise traversal of the linked lists and also to use specific linked list objects
 * within the SELinkedList class itself.
 *
 * @author Robert Thompson, Alexander Kaczynski, Liam Grover
 * April 5, 2017
 */
public class SELinkedList<E>
{
	private static class SENode<E>{
		private double element;
		private SENode<E> next;
		public SENode(double e){
			this.element = e;
			next = null;
		}
		public double getElement(){ return element; }
		public SENode<E> getNext() { return next; }
		public void setNext(SENode<E> n) { this.next = n; }
	}

	private SENode<E> head = null;
	private SENode<E> tail = null;
	private int size = 0;

	SELinkedList zScoreList;
	SELinkedList probValueList;
	SELinkedList tDistList;

	public SELinkedList()
	{
		head = null; 
		tail = null;
		size = 0; 
	}

	/**
	 * Add an element to the linked list
	 * @param e
	 */
	public void add(double v)
	{
		SENode temp = new SENode(v); // Creates temp node to add to the linked list 
		SENode newNode = head; // newNode node is set to the head of the linked list

		if (head == null) // If the head of the linked list is null, temp node becomes the head of the list
		{
			head = temp;
		}
		else
		{
			while (newNode.getNext() != null) // While loop that runs until the list is full
			{
				newNode = newNode.getNext(); // Sets the newNode to the next node in the list
			}
			newNode.setNext(temp); // Temp node is set to the next node in the link
		}
		size++; // Increases the size of the list
	}

	/**
	 * Gets the value at the specific index of the linked list
	 * @param index
	 * @return
	 */
	public double getValue(int index)
	{
		SENode temp = head; // Creates a temp node and sets it equal to the head node of the list

		// For loop that returns each value of the linked list until its iterated through the whole list
		for (int i = 0; i < index; i++)
		{
			temp = temp.getNext(); // Gets the node at the specific index in the list 
		}

		return temp.getElement(); // Gets the element at the specific node in the list

	}

	/**
	 * Prints the list
	 */
	public String print()
	{
		SENode temp = head;
		while (temp != null)
		{
			System.out.println(temp.getElement());
			temp = temp.getNext();
		}
		return "";
	}

	/**
	 * Returns the size of the linked list
	 * @return
	 */
	public int size()
	{
		return size; // Returns the size of the list
	}

	/**
	 * Boolean that returns if the method is empty via size being equal to 0
	 * @return size of the list
	 */
	public boolean isEmpty()
	{
		return size == 0; // Size of the list is equal to zero
	}

	/**
	 * Calculates the mean of the list
	 * @return mean value
	 */
	public double getMean(SELinkedList list)
	{
		double mean;
		double sum = 0;
		SENode temp = list.head;

		while (temp != null)
		{
			sum = sum + temp.getElement();
			temp = temp.getNext();
		}
		mean = sum / size();

		return mean;
	}

	/**
	 * Calculates the variance of the list
	 * @return variance value
	 */
	public double getVariance(SELinkedList list)
	{
		double average = getMean(list);
		double sum = 0;
		double var = 0;
		SENode temp = head;

		while (temp != null)
		{
			sum = sum + Math.pow(temp.getElement() - average, 2);
			temp = temp.getNext();
		}
		var = sum / (size() - 1);
		return var;
	}

	/**
	 * Calculates the standard deviation of the list
	 * @return standard deviation
	 */
	public double getStandardDeviation(SELinkedList list)
	{
		double stdDev = 0;
		stdDev = Math.sqrt(getVariance(list));

		return stdDev;
	}

	/**
	 * Calculates the sum of the list 
	 * @param list
	 * @param count
	 * @return sum of the list
	 */
	public double sum(SELinkedList list)
	{
		double sum = 0;
		SENode temp = list.head;

		while (temp != null)
		{
			sum = sum + temp.getElement();
			temp = temp.getNext();
		}

		return sum;
	}

	/**
	 * Calculates the values in the list squared and adds them to get the sum 
	 * @param list
	 * @param count
	 * @return sum of the values squared
	 */
	public double sumSquared(SELinkedList list)
	{
		double sum = 0;
		SENode temp = list.head;

		while (temp != null)
		{
			sum = sum + (Math.pow(temp.getElement(), 2));
			temp = temp.getNext();
		}

		return sum;
	}

	/**
	 * Calculates the product of the x and y values and adds it to the sum
	 * @param x
	 * @param y
	 * @param count
	 * @return
	 */
	public double sumXY(SELinkedList x, SELinkedList y)
	{
		double sum = 0;
		SENode xVal = x.head;
		SENode yVal = y.head;

		while (xVal != null || yVal != null)
		{
			sum = sum + (xVal.getElement() * yVal.getElement());
			xVal = xVal.getNext();
			yVal = yVal.getNext();
		}

		return sum;

	}

	/**
	 * Calculates the correlation between the two lists
	 * @param x
	 * @param y
	 * @param count
	 * @return correlation value
	 */
	public double getCorrelation(SELinkedList x, SELinkedList y)
	{
		double xSum = sum(x);
		double ySum = sum(y);
		double xxSum = sumSquared(x);
		double yySum = sumSquared(y);
		double xySum = sumXY(x, y);

		double corr;
		double corrNum;
		double corrDenom;


		if (x.size() == y.size())
		{
			int size = x.size();

			corrNum = (size * xySum) - (xSum * ySum);
			corrDenom = Math.sqrt( ((size * xxSum) - Math.pow(xSum, 2)) 
					* ((size * yySum) - Math.pow(ySum, 2)) );
			corr = corrNum / corrDenom;
		}
		else
		{
			corr = 0;
		}

		return corr;

	}

	/**
	 * Calculates the correlation squared between the two lists
	 * @param x
	 * @param y
	 * @param count
	 * @return correlation squared value
	 */
	public double correlationSquared(SELinkedList x, SELinkedList y)
	{
		double corrSquared;

		corrSquared = Math.pow(getCorrelation(x, y), 2);

		return corrSquared;
	}

	/**
	 * Calculates the z scores of the list 
	 * @return zScoreList
	 */
	public SELinkedList getZScores(SELinkedList list)
	{
		zScoreList = new SELinkedList(); // Linked list to store the z score calculations

		double zScore; // Variable to store the z score calculations 
		double mean = getMean(list); // Variable to store the getMean() method calculation
		double stdDev = getStandardDeviation(list); // Variable to store the getStandardDeviation() method calculation

		// For loop that runs until the end of the list
		for (int i = 0; i < this.size(); i++)
		{
			// Calculates the z score by taking the list at the given index - the mean / the standard deviation
			zScore = (this.getValue(i) - mean) / stdDev; 

			// Adds the calculation to the linked list
			zScoreList.add(zScore);
		}

		// Returns the linked list
		return zScoreList;
	}

	public SELinkedList getProbability(SELinkedList list)
	{		
		probValueList = new SELinkedList(); // Linked list to store the probability calculations
		getZScores(list); // Calls the getZScores method to calculate the zScores for use in the probability calculation

		double probability = 0; // Variable to store the probability calculation
		double integral = 0; // Variable to store the integral calculation

		double zValue = 0; // Variable to store the z score at the specific index

		double dx = 0; // Variable to store delta x
		double rectangles = 4; // Variable to store the number of rectangles

		double inputValue = 0; // Variable to store the middle riemann sums calculation
		double functionValue = 0; // Variable to store the function value calculation

		double sum = 0; // Variable to store the sum of all the function value calculations

		// For loop that runs until the end of the linked list
		for (int i = 0; i < this.zScoreList.size(); i++)
		{	
			// Calculates delta x by taking the z score at the given index / the number of rectangle
			dx = this.zScoreList.getValue(i) / rectangles;

			zValue = this.zScoreList.getValue(i);

			// Sets the sum variable equal to zero
			sum = 0;

			// If statement that only runs if dx is greater than 0
			if (zValue > 0)
			{
				// Outputs that the z score is greater than 0
				// System.out.println("Z > 0");

				// For loop that runs until it is less than or equal to the number of rectangles
				for (int k = 1; k <= rectangles; k++)
				{
					// Calculates the input value 
					inputValue = (2 * k - 1) * (dx / 2);

					// Calculates the function value
					functionValue = (1 / Math.sqrt(2 * Math.PI)) * Math.exp((-0.5) * Math.pow(inputValue, 2));

					// Adds the functionValue calculation to the sum variable
					sum = sum + functionValue;

				}

				// Calculates the integral value
				integral = sum * dx;
				// Outputs the integral value
				// System.out.println("Integral: " + integral);

				// Calculates the probability value by adding 0.5 because the z score is greater than 0
				probability = 0.5 + integral;
				// Outputs the probability calculation
				// System.out.println("Probability: " + probability);

				// Adds the probability calculation to the probValueList 
				probValueList.add(probability);
			}

			// Else if statement that will only run if the zValue is less than zero
			else if (zValue < 0)
			{
				// Sets the sum variable equal to zero
				sum = 0;

				// Outputs that z score is less than zero
				// System.out.println("Z < 0");

				// For loop that runs until it is less than or equal to the number of rectangles
				for (int k = 1; k <= rectangles; k++)
				{
					// Calculates the input value 
					inputValue = (2 * k - 1) * (dx / 2);

					// Calculates the function value
					functionValue = (1 / Math.sqrt(2 * Math.PI)) * Math.exp((-0.5) * Math.pow(inputValue, 2));

					// Adds the functionValue calculation to the sum variable
					sum = sum + functionValue;

				}

				// Calculates the integral value
				integral = sum * dx;
				// Outputs the integral value
				// System.out.println("Integral: " + integral);

				// Calculates the probability value by subtracting 0.5 because the z score is less than 0
				probability = 0.5 - Math.abs(integral);
				// Outputs the probability calculation
				// System.out.println("Probability: " + probability);

				// Adds the probability calculation to the probValueList 
				probValueList.add(probability);
			}

			// Else statement will only be executed if the z score is equal to zero
			else
			{
				// Adds the 0.5 to the probValue list because the z score is equal to zero
				probValueList.add(0.5);
			}
			// System.out.println();
		}

		// Returns the probValueList
		return probValueList;
	}

	public double getBeta1(SELinkedList x, SELinkedList y)
	{
		double xxSum = sumSquared(x);
		double xySum = sumXY(x, y);
		double xMean = getMean(x);
		double yMean = getMean(y);

		double reg1Num;
		double reg1Denom;
		double reg1 = 0;

		if (x.size() == y.size())
		{
			int size = x.size();

			reg1Num = xySum - (size * xMean * yMean);

			reg1Denom= xxSum - (size * Math.pow(xMean, 2));


			reg1 = reg1Num / reg1Denom;
		}
		else
		{
			xxSum = 0;
		}

		return reg1;
	}

	public double getBeta0(SELinkedList x, SELinkedList y)
	{
		double xMean = getMean(x);
		double yMean = getMean(y);

		double reg0;

		reg0 = yMean - (getBeta1(x, y) * xMean);

		return reg0;
	}
	public SELinkedList getTDistribution(SELinkedList x)
	{
		tDistList = new SELinkedList();
		double gamma1 = 0;
		double gamma2 = 0;
		double tFunction;
		int q = -1;
		double variable  = .95;//x-val
		System.out.println("T-Distribution: ");

		for (int i = 0; i < x.size(); i++)
		{

			double dof = x.getValue(i); //(x.size() - 1);
			double n = dof + 1;//x.size();


			double temp1 = (dof - 0.5) * Math.log(dof + 4.5) - (dof + 4.5);
			double temp2 = 1.0 + 76.18009173 / (dof + 0) - 86.50532033/ (dof + 1) + 24.01409822 / (dof + 2) -  1.231739516 / (dof + 3) + 0.00120858003 / (dof + 4) - 0.00000536382 / (dof + 5);
			gamma1= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
			gamma1 = Math.exp(gamma1);

			temp1 = (n - 0.5) * Math.log(n + 4.5) - (n + 4.5);
			temp2 = 1.0 + 76.18009173 / (n + 0) - 86.50532033/ (n + 1) + 24.01409822 / (n + 2) -  1.231739516 / (n + 3) + 0.00120858003 / (n + 4) - 0.00000536382 / (n + 5);
			gamma2= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
			gamma2 = Math.exp(gamma2); 

			tFunction = (gamma2/((Math.sqrt(dof*Math.PI)*gamma1))*(Math.pow((1+((variable*variable)/dof)),(-(n/2)))));
			
			System.out.println("-----------------------------------------------------------------------------------------------");

			if(i == 0)
			{
				
				q=-1;

				while(q == -1)
				{

					if (tFunction >= .489 && tFunction <= .491)
					{
						System.out.println("p= "+tFunction+"\t|\tDegrees of Freedom: "+dof+"\t|\tX-Value: "+variable);
						System.out.println("-----------------------------------------------------------------------------------------------");

						tDistList.add(tFunction);
						q=0;
					}
					else if (tFunction < .489)
					{
						variable = variable - .0005;
						
						
						
						temp1 = (dof - 0.5) * Math.log(dof + 4.5) - (dof + 4.5);
						temp2 = 1.0 + 76.18009173 / (dof + 0) - 86.50532033/ (dof + 1) + 24.01409822 / (dof + 2) -  1.231739516 / (dof + 3) + 0.00120858003 / (dof + 4) - 0.00000536382 / (dof + 5);
						gamma1= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
						gamma1 = Math.exp(gamma1);

						temp1 = (n - 0.5) * Math.log(n + 4.5) - (n + 4.5);
						temp2 = 1.0 + 76.18009173 / (n + 0) - 86.50532033/ (n + 1) + 24.01409822 / (n + 2) -  1.231739516 / (n + 3) + 0.00120858003 / (n + 4) - 0.00000536382 / (n + 5);
						gamma2= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
						gamma2 = Math.exp(gamma2); 

						tFunction = (gamma2/((Math.sqrt(dof*Math.PI)*gamma1))*(Math.pow((1+((variable*variable)/dof)),(-(n/2)))));

					}
					else if (tFunction > .491)
					{
						variable = variable + .0005;
						
						
						
						temp1 = (dof - 0.5) * Math.log(dof + 4.5) - (dof + 4.5);
						temp2 = 1.0 + 76.18009173 / (dof + 0) - 86.50532033/ (dof + 1) + 24.01409822 / (dof + 2) -  1.231739516 / (dof + 3) + 0.00120858003 / (dof + 4) - 0.00000536382 / (dof + 5);
						gamma1= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
						gamma1 = Math.exp(gamma1);

						temp1 = (n - 0.5) * Math.log(n + 4.5) - (n + 4.5);
						temp2 = 1.0 + 76.18009173 / (n + 0) - 86.50532033/ (n + 1) + 24.01409822 / (n + 2) -  1.231739516 / (n + 3) + 0.00120858003 / (n + 4) - 0.00000536382 / (n + 5);
						gamma2= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
						gamma2 = Math.exp(gamma2); 

						tFunction = (gamma2/((Math.sqrt(dof*Math.PI)*gamma1))*(Math.pow((1+((variable*variable)/dof)),(-(n/2)))));

					}
				}
			}
			else if(i == 1)
			{
				q=-1;

				while(q == -1)
				{
					if (tFunction >= .120 && tFunction <= .122)
					{
						System.out.println("p= "+tFunction+"\t|\tDegrees of Freedom: "+dof+"|\tX-Value: "+variable);
						System.out.println("-----------------------------------------------------------------------------------------------");

						tDistList.add(tFunction);
						q=0;
					}
					else if (tFunction < .120)
					{
						variable = variable - .0005;
						
						
						
						temp1 = (dof - 0.5) * Math.log(dof + 4.5) - (dof + 4.5);
						temp2 = 1.0 + 76.18009173 / (dof + 0) - 86.50532033/ (dof + 1) + 24.01409822 / (dof + 2) -  1.231739516 / (dof + 3) + 0.00120858003 / (dof + 4) - 0.00000536382 / (dof + 5);
						gamma1= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
						gamma1 = Math.exp(gamma1);

						temp1 = (n - 0.5) * Math.log(n + 4.5) - (n + 4.5);
						temp2 = 1.0 + 76.18009173 / (n + 0) - 86.50532033/ (n + 1) + 24.01409822 / (n + 2) -  1.231739516 / (n + 3) + 0.00120858003 / (n + 4) - 0.00000536382 / (n + 5);
						gamma2= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
						gamma2 = Math.exp(gamma2); 

						tFunction = (gamma2/((Math.sqrt(dof*Math.PI)*gamma1))*(Math.pow((1+((variable*variable)/dof)),(-(n/2)))));

					}
					else if (tFunction > .122)
					{
						variable = variable + .0005;
						
						
						
						temp1 = (dof - 0.5) * Math.log(dof + 4.5) - (dof + 4.5);
						temp2 = 1.0 + 76.18009173 / (dof + 0) - 86.50532033/ (dof + 1) + 24.01409822 / (dof + 2) -  1.231739516 / (dof + 3) + 0.00120858003 / (dof + 4) - 0.00000536382 / (dof + 5);
						gamma1= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
						gamma1 = Math.exp(gamma1);

						temp1 = (n - 0.5) * Math.log(n + 4.5) - (n + 4.5);
						temp2 = 1.0 + 76.18009173 / (n + 0) - 86.50532033/ (n + 1) + 24.01409822 / (n + 2) -  1.231739516 / (n + 3) + 0.00120858003 / (n + 4) - 0.00000536382 / (n + 5);
						gamma2= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
						gamma2 = Math.exp(gamma2); 

						tFunction = (gamma2/((Math.sqrt(dof*Math.PI)*gamma1))*(Math.pow((1+((variable*variable)/dof)),(-(n/2)))));

					}
				}
			}
			else if(i == 2)
			{
				q=-1;

				while(q == -1)
				{
					if (tFunction >= .001 && tFunction <= .003)
					{
						System.out.println("p= "+tFunction+"\t|\tDegrees of Freedom: "+dof+"\t|\tX-Value: "+variable);
						System.out.println("-----------------------------------------------------------------------------------------------");

						tDistList.add(tFunction);
						q=0;
					}
					else if (tFunction < .001)
					{
						variable = variable - .0005;
						
						
						
						temp1 = (dof - 0.5) * Math.log(dof + 4.5) - (dof + 4.5);
						temp2 = 1.0 + 76.18009173 / (dof + 0) - 86.50532033/ (dof + 1) + 24.01409822 / (dof + 2) -  1.231739516 / (dof + 3) + 0.00120858003 / (dof + 4) - 0.00000536382 / (dof + 5);
						gamma1= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
						gamma1 = Math.exp(gamma1);

						temp1 = (n - 0.5) * Math.log(n + 4.5) - (n + 4.5);
						temp2 = 1.0 + 76.18009173 / (n + 0) - 86.50532033/ (n + 1) + 24.01409822 / (n + 2) -  1.231739516 / (n + 3) + 0.00120858003 / (n + 4) - 0.00000536382 / (n + 5);
						gamma2= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
						gamma2 = Math.exp(gamma2); 

						tFunction = (gamma2/((Math.sqrt(dof*Math.PI)*gamma1))*(Math.pow((1+((variable*variable)/dof)),(-(n/2)))));

					}
					else if (tFunction > .003)
					{
						variable = variable + .0005;
						
						
						
						temp1 = (dof - 0.5) * Math.log(dof + 4.5) - (dof + 4.5);
						temp2 = 1.0 + 76.18009173 / (dof + 0) - 86.50532033/ (dof + 1) + 24.01409822 / (dof + 2) -  1.231739516 / (dof + 3) + 0.00120858003 / (dof + 4) - 0.00000536382 / (dof + 5);
						gamma1= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
						gamma1 = Math.exp(gamma1);

						temp1 = (n - 0.5) * Math.log(n + 4.5) - (n + 4.5);
						temp2 = 1.0 + 76.18009173 / (n + 0) - 86.50532033/ (n + 1) + 24.01409822 / (n + 2) -  1.231739516 / (n + 3) + 0.00120858003 / (n + 4) - 0.00000536382 / (n + 5);
						gamma2= temp1 + Math.log(temp2 * Math.sqrt(2 * Math.PI));
						gamma2 = Math.exp(gamma2); 

						tFunction = (gamma2/((Math.sqrt(dof*Math.PI)*gamma1))*(Math.pow((1+((variable*variable)/dof)),(-(n/2)))));

					}
				}
			}

			//tDistList.add(tFunction);

		}

		return tDistList;
	}	

}
