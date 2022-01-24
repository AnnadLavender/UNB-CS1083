import java.io.*;
import java.text.NumberFormat;
import java.util.Scanner;
/**
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */
public class UpdateAccounts
{
    public static void main(String[] args) throws IOException
    {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        final int MAX_ACCOUNT = 100;
        int bankAccountQuantity = 0;
        String bankAccountRecord;
        BankAccount[] bankAccounts = new BankAccount[MAX_ACCOUNT];
        BankAccount bankAccount;
        
        File inFile = new File("opening_balances.txt");
        Scanner fileScanner;
        
        fileScanner = new  Scanner(inFile);
        
        while(fileScanner.hasNext())
        {
            bankAccountRecord = fileScanner.nextLine();
            if (bankAccountQuantity < MAX_ACCOUNT)
            {
                Scanner recordScanner = new Scanner(bankAccountRecord);
                int accountNumber = recordScanner.nextInt();
                int balance = recordScanner.nextInt();
                
                bankAccount = new BankAccount(accountNumber,balance);
                bankAccounts[bankAccountQuantity] = bankAccount;
                bankAccountQuantity++;
            }
        }
        fileScanner.close();
        
        File inFile2 = new File("transactions.txt");
        fileScanner = new Scanner(inFile2);
    
        while(fileScanner.hasNext())
        {
            String transactionRecord;
            transactionRecord = fileScanner.nextLine();
            Scanner transactionScanner = new Scanner(transactionRecord);
    
            int position = findAccount
                    (bankAccounts,bankAccountQuantity,transactionScanner.nextInt());
            String type = transactionScanner.next();
            int amount = transactionScanner.nextInt();
            try
            {
                if(type.equals("D"))
                {
                    bankAccounts[position].deposit(amount);
                }
                else if(type.equals("W"))
                {
                    bankAccounts[position].withdraw(amount);
                }
            }
            catch(Exception e)
            {
                System.out.println("**** " + e.getMessage() + " Exception ****\n" +
                                    bankAccounts[position].toString() +
                                    "Transaction type: " + type +
                                    "\tTransaction Amount: " +
                                    numberFormat.format((double) amount / 100) +"\n");
            }
        }
        fileScanner.close();
        
        PrintWriter writer;
        ObjectOutputStream ooStream = null;
        BankAccount accountFromFile;
    
        writer = new PrintWriter("closing_balances.txt");
        for(int i = 0; i < bankAccountQuantity; i++)
        {	writer.println(bankAccounts[i].getAccountNumber()
                + "\t" + bankAccounts[i].getBalance());
        }
        writer.close();
        try
        {
            ooStream = new ObjectOutputStream(new FileOutputStream("accounts.obj"));
            fileScanner = new Scanner(new File("closing_balances.txt"));
            while (fileScanner.hasNext())
            {	accountFromFile
                    = new BankAccount(fileScanner.nextInt(),//Bank Account
                    fileScanner.nextInt());      // Balance
                ooStream.writeObject(accountFromFile);
            } // end while
    
            ooStream.flush();
        }
        catch(IOException e)
        {
            System.err.println("Error in creating object file.");
            System.exit(1);
        }
        finally
        {
            try
            {
                fileScanner.close();
                ooStream.close();
                
            }
            catch(IOException e)
            {
                System.err.println("Error in closing files.");
                System.exit(1);
            }
        }
        System.out.println("Files created: closing_balances.txt\n" + " " +
                           "              accounts.obj");
    
        ObjectInputStream inStream = null;
        
        try
        {
            inStream = new ObjectInputStream(new FileInputStream("accounts.obj"));
    
            try
            {
                System.out.println("Accounts retrieved from accounts.obj\n" +
                                    "====================================");
                while(true)
                {
                    accountFromFile = (BankAccount)inStream.readObject();
                    System.out.print(accountFromFile.toString());
                }
            }
            catch(EOFException e){}
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("Can't find the BankAccount class.");
            System.exit(1);
        }
        catch(IOException e)
        {
            System.err.println("Error in reading accounts.obj");
            System.exit(1);
        }
        finally
        {
            try
            {
                inStream.close();
            }
            catch  (IOException e)
            {
                System.err.println("Error in closing accounts.obj");
            }
        }
    }
    
    private static int findAccount(BankAccount[] temp, int quantity, int account)
    {
        int foundPosition = -1;
        int low = 0;
        int high = quantity - 1;
        int mid;
        
        while(foundPosition == -1 && low <= high)
        {
            mid = (low + high) / 2;
            if(temp[mid].getAccountNumber() == account)
            {
                foundPosition = mid;
            }
            else
            {
                if(account > temp[mid].getAccountNumber())
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        return foundPosition;
    }
}