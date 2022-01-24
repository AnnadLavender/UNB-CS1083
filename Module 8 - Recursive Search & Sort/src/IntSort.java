/** Class with a utility method for sorting an int array
	using the bubble sort algorithm
	@author Andrew McAllister
*/
public class IntSort
{	/** Uses the bubble sort algorithm to sort an integer
		array into ascending order.
		@param array The array to be sorted
	*/
	public static void bubbleSort(int[] array)
	{	int temp;
		
		// The value of pass goes from 1 to N-1
		for (int pass=1; pass<array.length; pass++)
		{	// Compare a series of adjacent pairs
			for (int i=0; i<array.length-pass; i++)
				if (array[i] > array[i+1])
				{	// Swap array[i] with array[i+1]
					temp       = array[i];
					array[i]   = array[i+1];
					array[i+1] = temp;
				}
		}
	} // end bubbleSort()

} // end class
