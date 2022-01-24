/**
 * This class represents a Lottery Draw.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

public class ComparableDraw
{
    /**
     * Indicates the $ prize amount for each possible number of winning numbers (0 to 6) that a ComparableTicket can match.
     */
    private static final double[] prizeAmount = {0.0, 0.0, 10.0, 100.0, 1000.0, 100000.0, 1000000.0};

    /**
     * The current number of ComparableTicket objects in the tickets array.
     */
    private int ticketQty = 0;

    /**
     * An array of ComparableTicket objects.
     */
    private ComparableTicket[] tickets;

    /**
     * A single ComparableTicket representing the winning numbers for this draw.
     */
    private ComparableTicket winningNumbers;

    /**
     * Constructs a lottery draw given the maximum quantity of tickets for this draw
     * @param maxTickets The maximum quantity of tickets for this draw.
     */
    public ComparableDraw(int maxTickets)
    {
        tickets = new ComparableTicket[maxTickets];
        winningNumbers = new ComparableTicket(0);
    }

    /**
     * Accessor method for a single ComparableTicket.
     * @param index The index from which to retrieve a ComparableTicket.
     * @return A reference to the ComparableTicket in position 'index' (or null in the case of an invalid index).
     */
    public ComparableTicket getTicket(int index)
    {
        if(index<tickets.length && index>=0)
        {
            return tickets[index];
        }
        else
        {
            return null;
        }
    }

    /**
     * Accessor method for an array of tickets.
     * @return a reference to the entire array of tickets.
     */
    public ComparableTicket[] getTickets()
    {
        return tickets;
    }

    public int getTicketQuantity()
    {
        return ticketQty;
    }

    /**
     * Adds a ComparableTicket to this draw
     * @param t The ComparableTicket to be added
     * @return false if the draw is full and cannot accept any more tickets, true otherwise.
     */
    public boolean addTicket(ComparableTicket t)
    {
        if(ticketQty<tickets.length)
        {
            tickets[ticketQty] = t;
            ticketQty++;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns the prize amount won for any ticket with a given quantity of numbers that match the winning numbers
     * @param n The quantity of matching numbers
     * @return The prize amount in dollars (0.0 in the case of an invalid value for n)
     */
    public double getPrizeAmount(int n)
    {
        double prize = 0.0;

        if(n<=6 && n>=0)
        {
            prize = prizeAmount[n];
        }
        return prize;
    }

    public int[] getWinningNumbers()
    {
        return winningNumbers.getNumbers();
    }
}
