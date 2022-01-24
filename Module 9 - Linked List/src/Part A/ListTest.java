/**
 * This is a driver program.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */
public class ListTest
{
	public static void main(String[] args)
	{
		LinkedList nameList = new LinkedList();
		
//*************************** Display an empty list ***************************
		System.out.println("\nDisplay an empty list:");
		nameList.display();
		
//********************* Remove a name from the empty list *********************
		System.out.println("\nRemove a name from the empty list:");
		if(nameList.remove("Amy"))
		{
			System.out.println("Failed – improper result returned by remove()");
		}
		else
		{
			System.out.println("Correct – remove() returned false");
		}
		
//*********** Call getHead() for empty list and display the result ************
		System.out.println("\nCall getHead() on the empty list and display the result: ");
		if(nameList.getHead() == null)
		{
			System.out.println("Correct - getHead() returned null");
		}
		else
		{
			System.out.println("Incorrect - getHead() did not returned null");
		}
	
//************************ Check if the list is empty *************************
		System.out.println("\nCheck if the list is empty:");
		if(nameList.isEmpty())
		{
			System.out.println("This list is empty");
		}
		else
		{
			System.out.println("This list is not empty");
		}
		
//************************ Add "Tom" to the empty list ************************
		nameList.insertInOrder("Tom");
		
		//************************* Display the list **************************
		System.out.println("\nDisplay a list after add \"Tom\":");
		nameList.display();
		
		//************************** Use getHead() ****************************
		System.out.println("\nCall getHead() on the list and display the result:");
		if(nameList.getHead() == null)
		{
			System.out.println("getHead() returned null");
		}
		else
		{
			System.out.println("getHead() did not returned null");
		}
		
		//************************** Use isEmpty() ****************************
		System.out.println("\nCheck if the list is empty:");
		if(nameList.isEmpty())
		{
			System.out.println("This list is empty");
		}
		else
		{
			System.out.println("This list is not empty");
		}
		
		//************************ Use remove("Tom") **************************
		System.out.println("\nRemove \"Tom\":");
		nameList.remove("Tom");
		System.out.println("The list after removing \"Tom\":");
		nameList.display();
		
		//*************** Use isEmpty() after removing "Tom" ******************
		System.out.println("\nCheck if the list is empty:");
		if(nameList.isEmpty())
		{
			System.out.println("This list is empty");
		}
		else
		{
			System.out.println("This list is not empty");
		}
		
//******************** Add and display a list with 5 names ********************
		String[] names = {"Tom", "May", "Darcy", "Ben", "Jeff"};
		for(int i = 0; i < names.length; i++)
		{
			nameList.insertInOrder(names[i]);
		}
		nameList.insertHead("Kevin");
		nameList.insertEnd("AAAAAAAAAAAA");
		System.out.println("\nDisplay a list with five names:");
		nameList.display();
		
//************** Attempt to remove the last node of the list ***************
		int count = 0;
		Node temp = nameList.getHead();
		while(temp!=null)
		{
			count++;
			temp = temp.getNext();
		}
		int count2 = 0;
		temp = nameList.getHead();
		while(nameList.getHead().getNext()!=null)
		{
			count2++;
			temp = temp.getNext();
			if(count2 == (count/2))
			{
				nameList.remove(temp.getName());
				System.out.println("\nDisplay a list after removing the node from the " +
						"middle of the list:");
				nameList.display();
				break;
			}
		}
		
//************** Attempt to remove the first node of the list ***************
		nameList.remove(nameList.getHead().getName());
		System.out.println("\nDisplay a list after removing the first node from the list:");
		nameList.display();
		
//************** Attempt to remove the last node of the list ***************
		temp = nameList.getHead();
		while(nameList.getHead().getNext()!=null)
		{
			temp = temp.getNext();
			if(temp.getNext() == null)
			{
				nameList.remove(temp.getName());
				System.out.println("\nDisplay a list after removing the last node from " +
						"the list:");
				nameList.display();
				break;
			}
		}
		
		System.out.println("Remove at end:");
		nameList.removeAtEnd();
		nameList.display();
	}
}