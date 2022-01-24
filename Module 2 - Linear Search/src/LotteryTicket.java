/**
 * This class represents a lottery ticket, with six numbers between 1 and 49.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

public class LotteryTicket
{
    /**
     * The largest possible number (49) on any ticket.
     */
    private static final int MAX_NUMBER = 49;
    /**
     * The smallest possible number (1) on any ticket.
     */
    private static final int MIN_NUMBER = 1;
    /**
     * The quantity of numbers (6) on each ticket.
     */
    public final int NUMBER_QTY = 6;
    /**
     * Six numbers between 1 and 49 with no duplicates, in unsorted order.
     */
    private int[] number = new int[NUMBER_QTY];
    /**
     * A unique identifier for the ticket.
     */
    private int ticketId;

    /**
     * This methods constructs a lottery ticket given a ticket id.
     * @param ticketIdIn The ID of the ticket.
     */
    public LotteryTicket(int ticketIdIn)
    {
        ticketId = ticketIdIn;
        chooseRandomNumbers();
    }

    /**
     * Accessor method for ticket id
     * @return The ticket ID.
     */
    public int getTicketId()
    {
        return ticketId;
    }

    /**
     * Accessor method that returns a reference to the numbers array.
     * @return A reference to the numbers array.
     */
    public int[] getNumbers()
    {
        return number;
    }

    /**
     *
     * @return A String that displays ticket id and the 6 numbers in the format like this example "1005: 16  6 3 31 10 26"
     */
    @Override
    public String toString()
    {
        String temp =":";

        for(int i = 0; i<number.length; i++)
        {

            temp += Util.padLeft(number[i]+"", 3);
        }
        return(getTicketId()+temp);
    }

    /**
     * Generates six pseudo-random integers between 1 and 49 without duplicates, populating the numbers array with these integer values. Inclusion of this method helps to simplify the code for the constructor.
     */
    private void chooseRandomNumbers()
    {
        int i = 0;

        while(i < number.length)
        {
            int rand = (int)(Math.random() * (MAX_NUMBER - MIN_NUMBER + 1)) + MIN_NUMBER;
            number[i] = rand;
            if(!duplicateNumber(i))
            {
                i++;
            }
        }
    }

    /**
     * Uses the linear search algorithm to check if numbers[i] is a duplicate of numbers[j] for all values of j that are less than i. In other words, checks to see if the most recently generated number is a duplicate of any of the previously generated numbers. Inclusion of this method simplifies the code for selecting random numbers for the ticket.
     * @param i The index of the most recently generated number
     * @return true if a duplicate is found, false otherwise.
     */
    private boolean duplicateNumber(int i)
    {
        boolean foundPosition = false;
        int j = 0;

        while(!foundPosition && j < number.length)
        {
            if(number[i] == number[j] && i!=j)
            {
                foundPosition = true;
            }
            j++;
        }
        return foundPosition;
    }

    /**
     * Repeatedly uses the linear search algorithm to check each of this ticket's numbers against the winning
     * numbers.
     * @param winningNumbers An array of six integers representing the winning numbers for a lottery draw. These will be six numbers between 1 and 49 without duplicates, in unsorted order.
     * @return The quantity of numbers on this ticket that match a winning number; this result will always be between 0 and 6.
     */
    public int countWinningNumbers(int[] winningNumbers)
    {
        int count = 0;

        for(int i = 0;i<number.length;i++)
        {
            for(int j = 0; j<winningNumbers.length; j++)
            {
                if(winningNumbers[j]==number[i])
                {
                    count++;
                }
            }
        }
        return count;
    }
}