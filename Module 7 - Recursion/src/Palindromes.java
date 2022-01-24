import static java.lang.Character.isLetter;

/**
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */
public class Palindromes
{
    public static boolean isPalindrome(String s)
    {
        String temp = s.toLowerCase();
        String clean = "";
        for(int i = 0; i < s.length(); i++)
        {
            if(isLetter(temp.charAt(i)) == true)
            {
                clean += temp.charAt(i);
            }
        }
        return isPalindrome(clean,0);
    }
    
    private static boolean isPalindrome(String s, int index)
    {
        if(index == s.length() - index)
        {
            return true;
        }
        if(s.charAt(index) != s.charAt(s.length() - 1 - index))
        {
            return false;
        }
        if(index < s.length() - index - 1)
        {
            return isPalindrome(s, index + 1);
        }
        return true;
    }
    public static void main(String[] args)
    {
        String s[] = {"radar", "a", "","Able was I ere I saw Elba", "A man, a plan, a canal, Panama!",
                        "Borrow or rob?", "Was it a cat I saw?",
                        "lavender", "rose", "lily", "chemistry"};
        
        for(int i = 0; i < s.length; i++)
        {
            if(isPalindrome(s[i]))
            {
                System.out.println("Yes!\t\"" + s[i] + "\"");
            }
            else
            {
                System.out.println("No...\t\"" + s[i] + "\"");
            }
        }
    }
}
