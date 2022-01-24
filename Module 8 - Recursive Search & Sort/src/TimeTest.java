/**
 * This is a driver program.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

public class TimeTest
{
    public static void main(String[] args)
    {
        int i = 0;
        long[] selectionSort = new long[11];
        long[] mergeSort = new long[11];
        int[] quantity = new int[11];
        int count = 0;

        while (i <= 100000)
        {
            ComparableDraw comparableDraw = new ComparableDraw(i);
            for (int j = 0; j <= i; j++)
            {
                ComparableTicket comparableTicket = new ComparableTicket((int)
                        (Math.random() * (9999 - 1000 + 1) + 1000));
                comparableDraw.addTicket(comparableTicket);
            }

            Sorter<ComparableTicket> ticketSorter = new Sorter<ComparableTicket>();
    
            long beforeMerge = System.currentTimeMillis();
            ticketSorter.mergeSort(comparableDraw.getTickets(),
                    comparableDraw.getTicketQuantity());
            long afterMerge = System.currentTimeMillis();
            mergeSort[count] = afterMerge - beforeMerge;
            
            long beforeSelection = System.currentTimeMillis();
            ticketSorter.selectionSort(comparableDraw.getTickets());
            long afterSelection = System.currentTimeMillis();
            selectionSort[count] = afterSelection - beforeSelection;
            
            quantity[count] = comparableDraw.getTicketQuantity();
            count++;
            i += 10000;
        }
        System.out.println("*** Selection Sort ***\n" +
                "Quantity  Duration(ms)\n========  ============");
        for(i = 0; i < selectionSort.length; i++)
        {
            System.out.printf("%6d%12d\n", quantity[i],selectionSort[i]);
        }
        
        System.out.println("\n*** Merge Sort ***\n" +
                "Quantity  Duration(ms)\n========  ============");
        for(i = 0; i < mergeSort.length; i++)
        {
            System.out.printf("%6d%12d\n", quantity[i],mergeSort[i]);
        }
    }
}