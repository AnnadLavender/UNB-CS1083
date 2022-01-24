/**
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */
public class GreatestCommonDivisor
{
    public static int gcd(int x, int y)
    {
        if(y == 0)
        {
            return x;
        }
        return gcd(y,x%y);
    }
    
    public static int gcd(int x, int y, String indent)
    {
        if(y == 0)
        {
            System.out.println(indent + "Returning: "
                        + gcd(x,y) + " from gcd(" + x + "," + y + ")");
            return x;
        }
        System.out.println(indent + "Calling: gcd(" + y + "," + x%y + ")");
        gcd(y,x%y,indent + "\t");
        System.out.println(indent + "Returning: "
                    + gcd(x,y) + " from gcd(" + x + "," + y + ")");
        
        return gcd(y,x%y);
    }
    
    public static void main(String[] args)
    {
        int x,y;
        System.out.println("x \t y\tgcd(x,y)\n" + "==\t==\t========");
        for(int i = 0; i < 10; i++)
        {
            x = (int)(Math.random() * (20 - 5 + 1)) + 5;
            y = (int)(Math.random() * (20 - 5 + 1)) + 5;
            System.out.println(x +"\t" + y + "\t" + gcd(x,y));
            
        }
        
        for(int i = 0; i < 2; i++)
        {
            x = (int)(Math.random() * (20 - 5 + 1)) + 5;
            y = (int)(Math.random() * (20 - 5 + 1)) + 5;
            
            System.out.println("\n***** " + "gcd(" + x + "," + y + ") *****");
            System.out.println("***** RESULT: " + gcd(x,y,"") + " *****");
        }
    }
}
