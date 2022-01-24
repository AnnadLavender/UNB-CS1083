import java.io.*;
import java.text.NumberFormat;

/**
 * Basic bank account class for CS1083. Balances are not permitted to go below $0.00
 * @author Ngoc Phuong Anh Nguyen
 */
public class BankAccount implements Serializable
{
    /**
     * Account number.
     */
    private int accountNumber;
    /**
     * Account balance stored as pennies.
     */
    private int balance;

    /**
     * Constructs a BankAccount object given the account number. The initial balance is
     * set to 0 pennies, which represents $0.00
     * @param accountNumberIn The given account number.
     */
    public BankAccount(int accountNumberIn)
    {
        accountNumber = accountNumberIn;
        balance = 0;
    }

    /**
     * Constructs a BankAccount object given the account number and an initial balance.
     * @param accountNumberIn The given account number.
     * @param balanceIn The initial balance in pennies.
     */
    public BankAccount(int accountNumberIn, int balanceIn)
    {
        accountNumber = accountNumberIn;
        balance = balanceIn;
    }

    /**
     * Accessor method for accountNumber.
     * @return The account number.
     */
    public int getAccountNumber()
    {
        return accountNumber;
    }

    /**
     * Accessor method for balance.
     * @return The balance in pennies.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Mutator method for balance.
     * @param balanceIn The new balance in pennies.
     */
    public void setBalance(int balanceIn)
    {
        balance = balanceIn;
    }

    /**
     * Deposits money into this account.
     * @param depositAmount The amount to be deposited in pennies.
     * @throws OverpaymentException Included here only to be consistent with the
     * overridden 'deposit' method in the child LineOfCredit class.
     */
    public void deposit(int depositAmount) throws OverpaymentException
    {
        balance += depositAmount;
    }

    /**
     * Withdraws money from this account
     * @param withdrawalAmount The amount to be withdrawn in pennies. The withdrawal
     *                         happens only if the balance will remain at least $0.00.
     * @throws InsufficientFundsException When the withdrawal attempts to reduce the
     * balance below $0.00.
     */
    public void withdraw(int withdrawalAmount) throws InsufficientFundsException
    {
        if(balance - withdrawalAmount < 0)
        {
            throw new InsufficientFundsException();
        }
        else
        {
            balance = balance - withdrawalAmount;
        }
    }

    /**
     * Supplies the account number and balance as a String.
     * @return A String representation of the account number and balance for this
     * BankAccount instance. The balance is formatted in currency format
     */
    @Override
    public String toString()
    {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return "BankAccount[" +
                "accountNumber = " + accountNumber +
                ", balance = " + numberFormat.format((double)balance/100) + "]\n";
    }
}
