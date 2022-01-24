/**
 * This is a driver program.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

import java.text.NumberFormat;

public class ComparableDrawTest
{
    public static void main(String[] args)
    {
        ComparableDraw comparableDraw = new ComparableDraw(20);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        for(int i = 0; i < 10; i++)
        {
            ComparableTicket comparableTicket = new ComparableTicket((int) (Math.random() * (9999 - 1000 + 1) + 1000));
            comparableDraw.addTicket(comparableTicket);
        }

        System.out.print("Winning Numbers: ");
        for(int i = 0; i < comparableDraw.getWinningNumbers().length; i++)
        {
            System.out.print(comparableDraw.getWinningNumbers()[i] + " ");
        }

        System.out.println("\n\n   Unsorted Tickets      "
                + "#Matched    "
                + "Prize\n=======================  ========  =========");
        for (int i = 0;i<comparableDraw.getTicketQuantity();i++)
        {
            System.out.println(
                    comparableDraw.getTickets()[i].toString() + Util.padLeft(
                            comparableDraw.getTickets()[i].countWinningNumbers(
                                    comparableDraw.getWinningNumbers()
                            ) + "", 7
                    ) + Util.padLeft(
                            numberFormat.format(
                                    comparableDraw.getPrizeAmount(
                                            comparableDraw.getTickets()[i].countWinningNumbers(
                                                    comparableDraw.getWinningNumbers()
                                            )
                                    )
                            ), 12
                    )
            );
        }

        Sorter<ComparableTicket> ticketSorter = new Sorter<ComparableTicket>();
//        ticketSorter.selectionSort(comparableDraw.getTickets());
        ticketSorter.mergeSort(comparableDraw.getTickets(), comparableDraw.getTicketQuantity());
        System.out.println("\n\n    Sorted Tickets       " + "#Matched    " + "Prize\n=======================  ========  =========");
        for (int i = 0;i< comparableDraw.getTicketQuantity();i++)
        {
            System.out.println(
                    comparableDraw.getTickets()[i].toString() + Util.padLeft(
                            comparableDraw.getTickets()[i].countWinningNumbers(
                                    comparableDraw.getWinningNumbers()
                            ) + "", 7
                    ) + Util.padLeft(
                            numberFormat.format(
                                    comparableDraw.getPrizeAmount(
                                            comparableDraw.getTickets()[i].countWinningNumbers(
                                                    comparableDraw.getWinningNumbers()
                                            )
                                    )
                            ), 12
                    )
            );
        }
    }
}
