import java.text.NumberFormat;

/**
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */
public class AccountTest3
{
    public static void main(String[] args)
    {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        char[] transactionType = {'d', 'd', 'w', 'w'};
        int[] transactionAmount = {5000, 5000, 15000, 10000};

        System.out.println("******* Testing a bank account *******\n");

        BankAccount bankAccount = new BankAccount(1000);
        System.out.println(bankAccount);
        System.out.println(" Type      Amount   Balance\n" +
                "========  ========  ========");
        
        for (int i = 0; i < transactionType.length; i++)
        {
            if(transactionType[i] == 'd')
            {
                System.out.print("Deposit " +
                        Util.padLeft(numberFormat.format(transactionAmount[i]/100),10));
                
                try
                {
                    bankAccount.deposit(transactionAmount[i]);
                    System.out.println(Util.padLeft(numberFormat.format(
                            bankAccount.getBalance()/100),10));
                }
                catch (OverpaymentException e)
                {
                    System.out.println("("+e.getMessage()+")");
                }
            }
            else if(transactionType[i] =='w')
            {
                System.out.print("Withdraw" +
                        Util.padLeft(numberFormat.format(transactionAmount[i]/100),10));
                
                try
                {
                    bankAccount.withdraw(transactionAmount[i]);
                    System.out.println(Util.padLeft(numberFormat.format(
                            bankAccount.getBalance()/100),10));
                }
                catch(InsufficientFundsException e)
                {
                    System.out.println("  (" + e.getMessage() + ")");
                }
            }
        }

        System.out.println("\n******* Testing a line of credit *******\n");
        
        LineOfCredit lineOfCredit = new LineOfCredit(1001,-20000,-7500);
        System.out.println(lineOfCredit);
        System.out.println(" Type      Amount   Balance\n" +
                "========  ========  ========");
       
        for (int i = 0; i < transactionType.length; i++)
        {
            if(transactionType[i] == 'd')
            {
                System.out.print("Deposit " +
                        Util.padLeft(numberFormat.format(transactionAmount[i]/100),10));

                try
                {
                    lineOfCredit.deposit(transactionAmount[i]);
                    System.out.println(Util.padLeft(numberFormat.format(
                            lineOfCredit.getBalance()/100),10));
                }
                catch (OverpaymentException e)
                {
                    System.out.println("  (" + e.getMessage() + ")");
                }
            }

            else if(transactionType[i] == 'w')
            {
                System.out.print("Withdraw" +
                        Util.padLeft(numberFormat.format(transactionAmount[i]/100),10));

                try
                {
                    lineOfCredit.withdraw(transactionAmount[i]);
                    System.out.println(Util.padLeft(numberFormat.format(
                            lineOfCredit.getBalance()/100),10));
                }
                catch (InsufficientFundsException e)
                {
                    System.out.println("  (" + e.getMessage() + ")");
                }
            }
        }
    }
}
