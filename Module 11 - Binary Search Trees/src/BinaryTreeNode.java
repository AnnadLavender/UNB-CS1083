public class BinaryTreeNode
{
	private int ticketId;
	private BinaryTreeNode left, right;
	
	public BinaryTreeNode(int ticketIdIn)
	{
		ticketId  = ticketIdIn;
		left  = null;
		right = null;
	}
	
	public void setTicketId(int ticketIdIn)
	{
		ticketId = ticketIdIn;
	}
	
	public int getTicketId()
	{
		return ticketId;
	}
	
	public BinaryTreeNode getLeft()
	{
		return left;
	}
	
	public BinaryTreeNode getRight()
	{
		return right;
	}
	
	/**
	 * Display the subtree rooted at this
	 * @param indent The indentation of the output.
	*/
	public void displayPreOrder(String indent)
	{
		System.out.println(indent + ticketId);
		if (left != null)
			left.displayPreOrder("    " + indent);
		if (right != null)
			right.displayPreOrder("    " + indent);
	}
	
	/**
	 * Inserts a given String into the subtree rooted at this. Maintains the
	 * basic property of a binary tree, which is that all smaller values go
	 * into the left subtree, and all larger values go into the right subtree.
	 * @param ticketIdIn The id of the ticket.
	 */
	public void insert(int ticketIdIn)
	{
		if (ticketIdIn < ticketId)
		{
			if (left == null)
				left = new BinaryTreeNode(ticketIdIn);
			else
				left.insert(ticketIdIn);
		}
		else if(ticketIdIn > ticketId)
		{
			if (right == null)
				right = new BinaryTreeNode(ticketIdIn);
			else
				right.insert(ticketIdIn);
		}
	} // end insert method
} // end class