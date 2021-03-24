package project2;

import java.util.Arrays;
public class Shaker
{
   public static int trackedSort(Integer array[])
    {
	  int compares = 0;//number of compares 
	  boolean swapped;// tracks if elements were swapped in this pass
	  
	  do {
		swapped = false;//reset swapped to false for a new pass
		for (int i =0; i<=  array.length  - 2;i++) {//for every element except the last
			compares++;//track the compare we just did

			if (array[ i ] > array[ i + 1 ]) {// if this element is greater than the element after it
				int temp = array[i];// hold our element in a temp variable
				array[i] = array[i+1];//move the next element into this element's place
				array[i+1]=temp;//move current element into the next place
				swapped = true;//set swapped to true since we just swapped.
			}
		}
		if (!swapped) {//if there wasn't any swaps in this pass
			break;//end the sort. We're done. 
		}
		// System.out.println("Shaker compares: " + compares);
		swapped = false; //reset swapped for our reverse pass
		for (int i= array.length - 2;i>=0;i--) {//for each element except the first, starting at one from the end and moving backwards
			compares++;//track the compare

			if (array[ i ] > array[ i + 1 ]) {//if this element is greater than the one after it
				int temp = array[i];//save our variable
				array[i] = array[i+1];//move the smaller element to it's new place
				array[i+1]=temp;//move our bigger element to it's new place
				swapped = true;//we swapped, so track it. 
			}
		}
	} while (swapped);//if we swapped, do it again
	  
	//sort should be finished here
     // System.out.println("Finished ShakerSort, Compares: " +compares); // TEST CODE, dumps out total compares from sort 
	 // System.out.println("Shaker compares: " + compares);
	  return compares;//return our total compares. 
}
   
   
   public static void main(String args[])//test main
   {
       Integer nums[] = {7, 5, 3, 2, 1, 12, 45};
       System.out.println("Original Array:");
       System.out.println(Arrays.toString(nums));
	   int compares = trackedSort(nums);
       System.out.println("Sorted Array");
       System.out.println(Arrays.toString(nums));
       System.out.println("Compares: " +compares);
   }
}