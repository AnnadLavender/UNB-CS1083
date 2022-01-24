/**
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

public class Question2
{
    public static void main(String[] args)
    { int[] array = {3, 5, 1, 2};
        mystery(array, 5);
    }
    public static void mystery(int[] array, int level)
    { if (level == 0)
        return;
        System.out.print("|");
        for (int i=0; i<array.length; i++)
        { if (array[i] >= level)
            System.out.print("*");
        else
            System.out.print(" ");
        }
        System.out.println("|");
        mystery(array, level-1);
    }
}
