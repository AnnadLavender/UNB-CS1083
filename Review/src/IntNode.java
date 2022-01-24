/**
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

public class IntNode
{ private int val;
    private IntNode next;
    // Constructor
    public IntNode(int valIn)
    { val = valIn;
        next = null;
    }
    public IntNode getNext()
    { return next;
    }
    public void setNext(IntNode nextIn)
    { next = nextIn;
    }
}
