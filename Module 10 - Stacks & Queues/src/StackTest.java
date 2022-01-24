/**
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */
public class StackTest
{
    public static void main(String[] args)
    {
        Stack stack = new Stack();
        
        stack.push("Kelvin");
        stack.push("Amy");
        stack.push("Lemon");
        
        System.out.println("List of the contents of the stack:");
        stack.displayInReverse();
        
        System.out.println("Size of the stack: "
                + stack.getSize());
        
        stack.pop();
        System.out.println("\nList of the contents of the stack after using pop():");
        stack.displayInReverse();
    
        System.out.println("Size of the stack: "
                + stack.getSize());
    
    }
}
