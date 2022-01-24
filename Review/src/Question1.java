import java.util.Scanner;

/**
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

public class Question1
{
    public static String removeSpaces(String s, int index)
    {
        String temp = s.charAt(index) + "";
        if(temp.equals(" "))
        {
            temp = "";
        }
        if(index == s.length() - 1)
        {
            return temp;
        }
        return temp + removeSpaces(s,index + 1);
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input string: ");
        String input = sc.nextLine();
        System.out.println(removeSpaces(input,0));
    }
}
