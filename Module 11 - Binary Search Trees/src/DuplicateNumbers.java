/**
 * This is the driver program.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

public class DuplicateNumbers
{
    public static void main(String[] args)
    {
        int[] array = {500000, 200000, 100000, 300000, 700000, 600000, 800000};
        try
        {
            BinaryTree binaryTree = new BinaryTree();
            for(int i = 0; i < array.length; i++)
            {
                binaryTree.insert(array[i]);
            }
            binaryTree.displayPreOrder();
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        
        System.out.println("\n***** Array of 20 numbers (100000-999999) *****\n");
        
        int[] a = new int[20];
        
        for(int i = 0; i < a.length; i++)
        {
            a[i] = (int)(Math.random()*(999999 - 100000 + 1) + 100000);
        }
        
        a[2] = a[6];
        a[12] = a[6];
        a[18] = a[6];
        
        int count = 0;
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + "\t");
            count++;
            if(count % 5 == 0)
            {
                System.out.println();
            }
        }
        count = 0;
        System.out.println("\n***************** End of Array *****************\n");
        System.out.println("Inserting Values in the Tree:");
        BinaryTree binary = new BinaryTree();
        for(int i = 0; i < a.length; i++)
        {
            binary.insert(a[i]);
            int same = 0;
            for(int j = 0; j < i; j++)
            {
                if(a[i] == a[j])
                {
                    System.out.println("Duplicate found: Number " + a[i]
                            + " is already in the tree.");
                    same++;
                    break;
                }
            }
            if(same == 0)
            {
                count++;
            }
        }
        System.out.println("A total of " + count + " numbers were added.\n");
        binary.displayPreOrder();
    }
}
