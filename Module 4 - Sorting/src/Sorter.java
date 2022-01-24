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
            int min = i;

            for(int j = i + 1; j < n; j++)
            {
                if(array[min] != null && array[min].compareTo(array[j]) > 0)
                {
                    min = j;
                }
            }

            temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }
}
