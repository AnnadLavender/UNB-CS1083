/**
 * Question 5
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

public class LinkedList
{ private IntNode head;
    // Constructor
    public LinkedList()
    { head = null;
    }
    public IntNode getHead()
    { return head;
    }
    //*** The method you write for this question
    //*** will be inserted here
    
    public int size()
    {
        IntNode current = head;
        int size = 0;
        
        while(current != null)
        {
            current = current.getNext();
            size++;
        }
        return size;
    }
} // end LinkedList class
