/**
 * Enables names to be stored within a linked list
 * @author Ngoc Phuong Anh Nguyen - 3712361
*/
public class Node
{
	/**
	 * The data stored by this node - a name
	*/
	private String name;
	
	/** Points to the next node in the list
	*/
	private Node next;
	
	/**
	 * Points to the previous node in the list.
	 */
	private Node previous;
	
	/**
	 * Constructs an empty node
	*/
	public Node()
	{
		name = null;
		next = null;
		previous = null;
	}
	
	/** Constructs a node containing the given name
		@param nameIn The name to be inserted into
		              the new node
	*/
	public Node(String nameIn)
	{
		name = nameIn;
		next = null;
		previous = null;
	}
	
	// Accessor and mutator methods
	
	public void setName(String nameIn)
	{
		name = nameIn;
	}
	
	public void setNext(Node nextIn)
	{
		next = nextIn;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public Node getPrevious()
	{
		return previous;
	}
	
	public void setPrevious(Node previousIn)
	{
		previous = previousIn;
	}
}