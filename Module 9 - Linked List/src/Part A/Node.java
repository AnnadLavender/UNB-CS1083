/** Enables names to be stored within a 
	linked list
	@author Andrew McAllister
*/
public class Node
{
	/**	The data stored by this node - a name
	*/
	private String name;
	
	/** Points to the next node in the list
	*/
	private Node next;
	
	/** Constructs an empty node
	*/
	public Node()
	{	name = null;
		next = null;
	}
	
	/** Constructs a node containing the given name
		@param nameIn The name to be inserted into
		              the new node
	*/
	public Node(String nameIn)
	{	name = nameIn;
		next = null;
	}
	
	// Accessor and mutator methods
	
	public void setName(String nameIn)
	{	name = nameIn;
	}
	
	public void setNext(Node nextIn)
	{	next = nextIn;
	}
	
	public String getName()
	{	return name;
	}
	
	public Node getNext()
	{
		return next;
	}

}

