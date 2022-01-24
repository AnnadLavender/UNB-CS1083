/** A simple linked list class.
	@author Andrew McAllister
*/
public class LinkedList
{
	/** Points to the first node in the list.
		Is null if and only if the list is empty.
	*/
	private Node head;
	
	/** Constructs an empty list
	*/
	public LinkedList()
	{	head = null;
	}
	
	//=============================================
	//  methods
	
	/**	Accessor for head
		@return The head of the list
	*/
	public Node getHead()
	{	return head;
	}
	
	/**	Indicates if the list is empty
		@return true if the list is empty, false
		        otherwise
	*/
	public boolean isEmpty()
	{	return head == null;
	}
	
	/** Displays the names in the list, one name per
		line
	*/
	public void display()
	{	System.out.println("*** Start of list ***");
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

    	if (head == null)
    	{ 	head = newNode;
      		return;
    	}

    	// The list already has at least one Node.
    	// Find the correct insertion spot in the list.

    	Node current  = head;
    	Node previous = null;

    	boolean found = false;

    	while (!found)
    	{ 	if(nameIn.compareTo(current.getName()) <= 0)
      		 	found = true;
      		else
      		{ 	previous = current;
        		current = current.getNext();
        		found = current == null;
      		}
    	} // end while

    	// Determine the position of the insertion

    	if (previous == null)
    	{ 	// Insert ahead of the first node
      		newNode.setNext(head);
      		head = newNode;
    	}
    	else
    	{ 	// Insert between previous and current
      		// This also works for insertion at end of list
      		newNode.setNext(previous.getNext());
      		previous.setNext(newNode);
    	}
  	} // end insertInOrder

	public void insertHead(String nameIn)
	{
		Node newNode = new Node(nameIn);
		
		if (head == null)
		{ 	head = newNode;
			return;
		}
		else
		{
			newNode.setNext(head);
			head = newNode;
		}
	}
	
	public void insertEnd(String nameIn)
	{
		Node newNode = new Node(nameIn);
		if(head == null)
		{
			head = newNode;
			return;
		}
		newNode.setNext(null);
		Node last = head;
		while(last.getNext() != null)
		{
			last = last.getNext();
		}
		last.setNext(newNode);
		return;
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
    	Node previous = null;

    	boolean found = false;

    	while (!found)
    	{ 	if(nameIn.equals(current.getName()))
      		 	found = true;
      		else
      		{ 	previous = current;
        		current = current.getNext();
        		found = current == null;
      		}
    	} // end while

    	// Remove only if the name was found
    	
    	if (current != null)
    	{ 	// The name was found.
    		if (head == current)
         		head = current.getNext();
      		else
         		previous.setNext(current.getNext());
      		return true;
    	}

   		return false;

  	} // end remove
	
	public boolean removeAtHead()
	{
		Node current = head;
		if(head == null)
		{
			return false;
		}
		head = current.getNext();
//		size--;
		return true;
	}
	
	public boolean removeAtEnd()
	{
		if(head == null)
		{
			return false;
		}
		Node current = head;
		while (current.getNext().getNext() != null)
			current = current.getNext();
		if(current != null)
		{
			current.setNext(null);
			return true;
		}
		else
		{
			return false;
		}
	}

} // end LinkedList class