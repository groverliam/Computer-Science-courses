public class Swapper
{
   /**
      This method swaps adjacent elements of the given array
      @param values an array
   */
   public void swapAdjacentElements(int[] values)
   {
      // your work here
	   int x = values.length;
	   int temp;
	   if (x % 2 == 0)
	   {
		   for (int i = 1 ; i < x ; i+=2 )
		   {
			   temp = values[i-1];
			   values[i-1] = values[i];
			   values[i] = temp;
		   }
	   }
	   else
	   {
		   for (int i = 1 ; i < (x-1) ; i+= 2)
		   {
			   temp = values[i-1];
			   values[i-1] = values[i];
			   values[i] = temp;
		   }
	   }
   }
   // This method is used to check your work
   public int[] check(int[] values)
   {
      swapAdjacentElements(values);
      return values;
   }
}
