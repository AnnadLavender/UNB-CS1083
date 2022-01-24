import java.text.NumberFormat;

/**
 * This is a driver program
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */
public class LotteryDrawTest
{
    public static void main(String[] args)
    {
        LotteryDraw lotteryDraw = new LotteryDraw(20);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        for(int i = 1001;i <= 1010; i++)
        {
            LotteryTicket lotteryTicket = new LotteryTicket(i);
            lotteryDraw.addTicket(lotteryTicket);
        }

        System.out.print("Winning Numbers: ");
        for(int i = 0; i < lotteryDraw.getWinningNumbers().length; i++)
        {
            System.out.print(lotteryDraw.getWinningNumbers()[i] + " ");
        }

        System.out.println("\n\n        Tickets          " + "#Matched    " + "Prize\n=======================  ========  =========");
        for (int i = 0;i<10;i++)
        {
            System.out.println(lotteryDraw.getTicket(i).toString()
                    + Util.padLeft(lotteryDraw.getTicket(i).countWinningNumbers(lotteryDraw.getWinningNumbers()) + "", 7)
                    + Util.padLeft(numberFormat.format(lotteryDraw.getPrizeAmount(lotteryDraw.getTicket(i).countWinningNumbers(lotteryDraw.getWinningNumbers()))), 12));
        }
    }
}
