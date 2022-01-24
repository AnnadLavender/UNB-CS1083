/**
 * This class represents a Lottery Draw.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

public class LotteryDraw
{
    /**
     * Indicates the $ prize amount for each possible number of winning numbers (0 to 6) that a LotteryTicket can match.
     */
    private static final double[] prizeAmount = {0.0, 0.0, 10.0, 100.0, 1000.0, 100000.0, 1000000.0};

    /**
     * The current number of LotteryTicket objects in the tickets array.
     */
    private int ticketQty = 0;

    /**
     * An array of LotteryTicket objects.
     */
    private LotteryTicket[] tickets;

    /**
     * A single LotteryTicket representing the winning numbers for this draw.
     */
    private LotteryTicket winningNumbers;

    /**
     * Constructs a lottery draw given the maximum quantity of tickets for this draw
     * @param maxTickets The maximum quantity of tickets for this draw.
     */
    public LotteryDraw(int maxTickets)
    {
        tickets = new LotteryTicket[maxTickets];
        winningNumbers = new LotteryTicket(1000);
    }

    /**
     * Accessor method for a single LotteryTicket.
     * @param index The index from which to retrieve a LotteryTicket.
     * @return A reference to the LotteryTicket in position 'index' (or null in the case of an invalid index).
     */
    public LotteryTicket getTicket(int index)
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
     * Adds a LotteryTicket to this draw
     * @param t The LotteryTicket to be added
     * @return false if the draw is full and cannot accept any more tickets, true otherwise.
     */
    public boolean addTicket(LotteryTicket t)
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
