/**
 * This class represents a Lottery Draw.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

public class Sorter<SomeType extends Comparable<SomeType>>
{
    /**
     *This method sorts elements in an array from smallest to largest.
     * @param array The unsorted array.
     */
    public void selectionSort(SomeType[] array)
    {
        int n = array.length;
        SomeType temp;

        for(int i = 0; i < n - 1; i++)
        {
            int max = i;

            for(int j = i + 1; j < n; j++)
            {
                if(array[max] != null && array[max].compareTo(array[j]) > 0)
                {
                    max = j;
                }
            }

            temp = array[max];
            array[max] = array[i];
            array[i] = temp;
        }
    }
    
    /**
     * Merges two adjacent subrange of an array
     * @param array The array with entries to be merged
     * @param from Index of first element of the first range
     * @param mid Index of last element of the first range
     * @param to Index of first element of the second range
     */
    @SuppressWarnings("unchecked")
    public void merge(SomeType[] array, int from, int mid, int to)
    {
        int n = to - from + 1;
        
        Object[] b = new Object[n];
        int i1 = from;
        int i2 = mid + 1;
        int j = 0;
    
        if(array[i1] != null && array[i2] != null)
        {
            while(i1 <= mid && i2 <= to)
            {
                if(array[i1].compareTo(array[i2]) <= 0)
                {
                    b[j] = array[i1];
                    i1++;
                }
                else
                {
                    b[j] = array[i2];
                    i2++;
                }
                j++;
            }
    
            while(i1 <= mid)
            {
                b[j] = array[i1];
                i1++;
                j++;
            }
    
            while(i2 <= to)
            {
                b[j] = array[i2];
                i2++;
                j++;
            }
    
            for (j = 0; j < n; j++)
                array[from + j] = (SomeType) b[j];
        }
    }
    
    /**
     * Sorts a range within an array with merge sort
     * @param array The array to be sorted
     * @param from The first index of the range
     * @param to The last index of the range
     */
    public void mergeSort(SomeType[] array, int from, int to)
    {
        if (from == to) return;
    
        int mid = (from + to) / 2;
    
        mergeSort(array, from, mid);
        mergeSort(array, mid + 1, to);
        merge(array, from, mid, to);
    }
    
    /**
     * Convenience method for the recursive mergeSort
     * @param array The array to be sorted
     * @param qty THe number of elements to be sorted.
     */
    public void mergeSort(SomeType[] array,int qty)
    {
        if (qty < 2 || qty > array.length)
            return;
        mergeSort(array, 0, qty - 1);
    }
}