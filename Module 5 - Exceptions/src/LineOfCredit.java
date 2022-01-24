import java.text.NumberFormat;

/**
 * Line of credit class for CS1083 With a line of credit, the "balance" variable
 * represents how much money the customer has borrowed. The balance is at most $0.00,
 * meaning no money is currently owed on this account. Or the balance can be a negative
 * amount, indicating the amount currently owed.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */
public class LineOfCredit extends BankAccount
{
    /**
     * Credit limit in pennies - a negative number, indicating the maximum amount that can
     * be borrowed on this line of credit.
     */
    private int creditLimit;

    /**
     * Constructs a LineOfCredit object given an account number and credit limit.
     * @param accountNumberIn The given account number.
     * @param creditLimitIn The given credit limit in pennies (a negative amount).
     */
    public LineOfCredit(int accountNumberIn, int creditLimitIn)
    {
        super(accountNumberIn);
        creditLimit = creditLimitIn;
    }

    /**
     * Constructs a LineOfCredit object given an account number, initial balance, and
     * credit limit.
     * @param accountNumberIn The given account number.
     * @param creditLimitIn The given credit limit in pennies (a negative amount).
     * @param balanceIn The given balance in pennies (0 or a negative amount)
     */
    public LineOfCredit(int accountNumberIn, int creditLimitIn, int balanceIn)
    {
        super(accountNumberIn,balanceIn);
        creditLimit = creditLimitIn;
    }

    /**
     * Accessor method for creditLimit.
     * @return The credit limit in pennies.
     */
    public int getCreditLimit()
    {
        return creditLimit;
    }

    /**
     * Mutator method for creditLimit.
     * @param creditLimitIn The given credit limit in pennies.
     */
    public void setCreditLimit(int creditLimitIn)
    {
        creditLimit = creditLimitIn;
    }

    /**
     * Deposits money into this account, which represents a payment on the amount owed.
     * The deposit is performed only if the payment does not take the balance above $0.00.
     * @param depositAmount The amount to be deposited in pennies.
     * @throws OverpaymentException When the deposit attempts to increase the balance to
     * be greater than $0.00.
     */
    @Override
    public void deposit(int depositAmount) throws OverpaymentException
    {
        if(getBalance() + depositAmount > 0)
        {
            throw new OverpaymentException();
        }
        else
        {
            super.deposit(depositAmount);
        }
    }

    /**
     *
     * @param withdrawalAmount The amount to be withdrawn in pennies. The withdrawal
     *                         happens only if the balance will remain at least $0.00.
     * @throws InsufficientFundsException
     */
    @Override
    public void withdraw(int withdrawalAmount) throws InsufficientFundsException
    {
        if(getBalance() - withdrawalAmount < creditLimit)
        {
            throw new InsufficientFundsException();
        }
        else
        {
            setBalance(getBalance() - withdrawalAmount);
        }
    }

    @Override
    public String toString()
    {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return "LineOfCredit[" +
                "accountNumber = " + getAccountNumber() +
                ", balance = " + numberFormat.format(getBalance()/100) +
                ", creditLimit = " + numberFormat.format(getCreditLimit()/100) + "]\n";
    }
}
