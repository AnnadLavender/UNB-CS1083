/**
 * This class represents a stack of Node objects
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */
public class Stack extends LinkedList
{
    public Stack()
    {
        super();
    }
    
    public void push(String temp)
    {
        insertAtTail(temp);
    }
    
    public String pop()
    {
        String temp;
        if(!isEmpty())
        {
            temp = getTail().getName();
            removeAtTail();
            
            return temp;
        }
        return null;
    }
    
    public String peek()
    {
        return getTail().getName();
    }
}