public class Words
{
   /**
      Removes all short words (length <= 3) from an array. The 
      order of the remaining element is left unchanged. The unused
      end of the array is filled with empty strings.
      @param words the array from which the short words are to be removed
   */
   public static void removeShortWords(String[] words)
   {
      // your work here
	   String temp;
	   for ( int i = 0 ; i < words.length ; i++)
	   {
		   if (words[i].length() <= 3)
		   {
			   words[i]="";
		   }

	   }
	   for(int i =  (words.length-1) ; i >1  ; i--)
	   {
		   if (words[i-2] == "")
		   {
			   temp = words[i-2];
			   words[i-2] = words[i];
			   words[i] = temp;
		   }
	   }
	   for(int i =  (words.length-1) ; i >0  ; i--)
	   {
		   if (words[i-1] == "")
		   {
			   temp = words[i-1];
			   words[i-1] = words[i];
			   words[i] = temp;
		   }
	   }


   }

}