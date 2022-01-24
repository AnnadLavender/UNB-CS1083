/**
 * A simple linked list class.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */
public class LinkedList
{
	/**
	 * Points to the first node in the list.
		Is null if and only if the list is empty.
	*/
	private Node head;
	
	/**
	 * Points to the last node in the list.
	 */
	private Node tail;
	/**
	 * Number of Nodes in the list.
	 */
	private int size = 0;
	/** Constructs an empty list
	*/
	public LinkedList()
	{
		head = null;
	}

	/**	Accessor for head
		@return The head of the list
	*/
	public Node getHead()
	{
		return head;
	}
	
	/**	Indicates if the list is empty
		@return true if the list is empty, false
		        otherwise
	*/
	public boolean isEmpty()
	{
		return head == null;
	}
	
	/**
	 * Displays the names in the list, one name per line
	*/
	public void display()
	{
		System.out.println("*** Start of list ***");
		Node current = head;
		while (current != null)
		{	System.out.println(current.getName());
			current = current.getNext();
		}
		System.out.println("*** End of list ***");
	}
	
	/** Creates a new Node with the given name.
		Inserts this new Node into the list so the list
		is maintained in ascending order alphabetically 
		by name. Assumes the list is sorted prior to 
		this operation. Duplicate names are
		permitted in the list.
		@param nameIn The name to be inserted into
		              the list
	*/
	public void insertInOrder(String nameIn)
	{
		Node newNode = new Node(nameIn);
		
		if(head == null)
		{
			head = tail = newNode;
			head.setPrevious(null);
			tail.setNext(null);
			size++;
			return;
		}
		
		boolean found = false;
		Node current = head;
		Node previous = null;
		
		while (!found)
		{
		    if(nameIn.compareTo(current.getName()) <= 0)
            {
                found = true;
            }
		    else
		    {
		        previous = current;
		        current = current.getNext();
		        found = current == null;
		        if (found) tail = previous;
		    }
		} // end while
		
        if (previous == null)
        { 	// Insert ahead of the first node
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
		}
        else
        {
			newNode.setNext(previous.getNext());
			previous.setNext(newNode);
        	newNode.setPrevious(previous);
        	if(newNode.getNext() != null)
			{
				current.setPrevious(newNode);
			}
        	else if(newNode.getNext() == null)
			{
				tail = newNode;
			}
//			        	System.out.println("tail: " +tail.getName());
		}
		size++;
	}
	
	/**	Searches the list for a node containing nameIn. If
		found, removes that node from the list and returns
		true. Otherwise, makes no change to the list and  
		returns false.
		@param nameIn The name to remove from the list
		@return true if a node is removed, false otherwise
	*/
  	public boolean remove(String nameIn)
  	{
    	if (head == null)
      		return false;

    	// The list has at least one Node.
    	// Find the given name in the list.

    	Node current  = head;

    	boolean found = false;

    	while (!found)
    	{
    		if(nameIn.equals(current.getName()))
      		 	found = true;
      		else
      		{
        		current = current.getNext();
        		found = current == null;
      		}
    	} // end while

    	// Remove only if the name was found
    	
    	if (current != null)
    	{ 	// The name was found.
    		
    		if (head == current)
         		head = current.getNext();
    		
			if(current.getNext() != null)
			{
				current.getNext().setPrevious(current.getPrevious());
			}
			
			if(current.getPrevious() != null)
			{
				current.getPrevious().setNext(current.getNext());
			}
			size--;
      		return true;
    	}
   		return false;
  	} // end remove
	
	public Node getTail()
	{
		return tail;
	}
	
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Displays the list in the same fashion as the current
	 * display() method, but in reverse order
	 */
	public void displayInReverse()
	{
		System.out.print("*** Start of list ***");
		Node current = head;
		String output ="";
		while (current != null)
		{
			output = "\n" + current.getName() + output;
			current = current.getNext();
		}
		System.out.println(output);
		System.out.println("*** End of list ***");
	}
	
	/**
	 * Inserts a new Node with the given name at the
	 * beginning of the list.
	 * @param nameIn The input name
	 */
	public void insertAtHead(String nameIn)
	{
		Node newNode = new Node(nameIn);
		if(head == null)
		{
			head = tail = newNode;
			head.setPrevious(null);
			tail.setNext(null);
		}
		else
		{
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
		}
		size++;
	}
	
	/**
	 * Inserts a new Node with the given name at the
	 * end of the list.
	 * @param nameIn The input name.
	 */
	public void insertAtTail(String nameIn)
	{
		Node newNode = new Node(nameIn);
		
		if(head == null)
		{
			head = tail = newNode;
			head.setPrevious(null);
		}
		else
		{
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}
		tail.setNext(null);
		size++;
		
	}
	
	/**
	 * Removes the first Node in the list.
	 * @return True if successful, false otherwise.
	 */
	public boolean removeAtHead()
	{
		Node current = head;
		if(head == null)
		{
			return false;
		}
		head = current.getNext();
		size--;
		return true;
	}
	
	/**
	 * Removes the last Node in the list.
	 * @return True if successful, false otherwise.
	 */
	public boolean removeAtTail()
	{
		if(head == null)
		{
			return false;
		}
		if (tail.getPrevious()!=null)
		{
			tail = tail.getPrevious();
			tail.setNext(null);
			size--;
			return true;
		}
		else
		{
			return false;
		}
		
	}
} // end LinkedList class