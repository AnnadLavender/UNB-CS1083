public class BinaryTree
{
	private BinaryTreeNode root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	/**
	 * Insert the root of the binary tree.
	 * @param ticketIdIn The ticket id.
	 * @throws IllegalArgumentException
	 */
	public void insert(int ticketIdIn) throws IllegalArgumentException
	{
		if (root == null)
		{
			root = new BinaryTreeNode(ticketIdIn);
		}
		else
		{
			root.insert(ticketIdIn);
		}
	}
	
	public void displayPreOrder()
	{
		System.out.println ("*** Beginning of preorder display ***");
		if (root != null)
			root.displayPreOrder("");
		System.out.println ("****** End of preorder display ******");
	}
}