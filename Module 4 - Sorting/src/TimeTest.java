/**
 * This is a driver program.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

public class TimeTest
{
    public static void main(String[] args)
    {
        int i = 0;

        System.out.println("Quantity  Duration(ms)\n========  ============");

        while (i <= 100000)
        {
            ComparableDraw comparableDraw = new ComparableDraw(i);
            for (int j = 0; j <= i; j++)
            {
                ComparableTicket comparableTicket = new ComparableTicket((int)(Math.random() * (9999 - 1000 + 1) + 1000));
                comparableDraw.addTicket(comparableTicket);
            }

            Sorter<ComparableTicket> ticketSorter = new Sorter<ComparableTicket>();

            long before = System.currentTimeMillis();
//            ticketSorter.selectionSort(comparableDraw.getTickets());
            long after = System.currentTimeMillis();

            System.out.printf("%6d%12d\n", comparableDraw.getTicketQuantity(), (after - before));
            i += 10000;
        }
    }
}