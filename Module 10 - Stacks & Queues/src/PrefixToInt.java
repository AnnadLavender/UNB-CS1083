/**
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

import static java.lang.Character.isDigit;

public class PrefixToInt
{
    public static String convert(String prefix)
    {
        Stack stack = new Stack();
        
        for(int i = prefix.length() - 1; i >= 0; i--)
        {
            if(isDigit(prefix.charAt(i)))
            {
                String character = "" + prefix.charAt(i);
                stack.push(character);
            }
            else if(prefix.charAt(i) == '+'
                    || prefix.charAt(i) == '-'
                    || prefix.charAt(i) == '*'
                    || prefix.charAt(i) == '/')
            {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                
                String input = "(" + operand1 + prefix.charAt(i) + operand2 + ")";
                stack.push(input);
            }
        }
        Node current = stack.getHead();
        String output ="";
        while (current != null)
        {
            output = current.getName();
            current = current.getNext();
        }
        return output;
    }
    
    public static void main(String[] args)
    {
        String[] testExpression = {"+47", "*+23-85", "*-9/41-/763",
                                    "+-*1234", "+3*-/59+821"};
        
        for(int i = 0; i < testExpression.length; i++)
        {
            System.out.println("\nPrefix: " + testExpression[i]
                    + "\nInfix: " + convert(testExpression[i]));
        }
    }
}
