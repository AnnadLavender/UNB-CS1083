/**
 * This is a driver program.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */

public class ListTest
{
	public static void main(String[] args)
	{
		LinkedList nameList = new LinkedList();
		
//******************************** Empty list *********************************
		System.out.println("\n********** Empty list **********");
		System.out.println("\nDisplay a empty list:");
		nameList.display();
		System.out.println("\nDisplay the list in reverse:");
		nameList.displayInReverse();
		
		System.out.println("\nSize of the list: " + nameList.getSize());
		
		if(nameList.getSize() == 0)
		{
			System.out.println("Correct – size() returns 0");
		}
		else
		{
			System.out.println("incorrect – size() should returns 0");
		}
		
		nameList.insertAtTail("Kelvin");
		System.out.println("\nDisplay a list after input at the end:");
		nameList.display();
		
		nameList.insertAtHead("Anna");
		System.out.println("\nDisplay a list after input at the beginning:");
		nameList.display();
		
		nameList.removeAtTail();
		System.out.println("\nDisplay a list after remove at the end:");
		nameList.display();
		
		nameList.removeAtHead();
		System.out.println("\nDisplay a list after remove at the beginning:");
		nameList.display();
		
//**************************** List with one name *****************************
		System.out.println("\n********** List with one name **********");
		nameList.insertInOrder("Tom");
		System.out.println("\nDisplay a list after input \"Tom\":");
		nameList.display();
		System.out.println("\nDisplay the list in reverse:");
		nameList.displayInReverse();
		
		System.out.println("\nSize of the list: " + nameList.getSize());
		
		if(nameList.getSize() == 1)
		{
			System.out.println("Correct – size() returns 1");
		}
		else
		{
			System.out.println("incorrect – size() should returns 1");
		}
		nameList.insertAtTail("Johan");
		System.out.println("\nDisplay a list after input at the end:");
		nameList.display();
		
		nameList.insertAtHead("Andrew");
		System.out.println("\nDisplay a list after input at the beginning:");
		nameList.display();
		
		nameList.removeAtTail();
		System.out.println("\nDisplay a list after remove at the end:");
		nameList.display();
		
		nameList.removeAtHead();
		System.out.println("\nDisplay a list after remove at the beginning:");
		nameList.display();
		
		nameList.remove("Tom");
		
//*************************** List with five names ****************************
		System.out.println("\n********** List with five names **********");
		String[] names = {"May", "Darcy","Tom", "Ben", "Jeff"};
		
		for(int i = 0; i < names.length; i++)
		{
			nameList.insertInOrder(names[i]);
		}
		
		System.out.println("\nDisplay a list after input 5 names:");
		nameList.display();
		
		System.out.println("\nDisplay the list in reverse:");
		nameList.displayInReverse();
		
		System.out.println("\nSize of the list: " + nameList.getSize());
		
		if(nameList.getSize() == 5)
		{
			System.out.println("Correct – size() returns 5");
		}
		else
		{
			System.out.println("incorrect – size() should returns 5");
		}
		
		nameList.insertAtTail("Emily");
		System.out.println("\nDisplay a list after input at the end:");
		nameList.display();
		
		nameList.insertAtHead("James");
		System.out.println("\nDisplay a list after input at the beginning:");
		nameList.display();
		
		nameList.removeAtTail();
		System.out.println("\nDisplay a list after remove at the end:");
		nameList.display();
		
		nameList.removeAtHead();
		System.out.println("\nDisplay a list after remove at the beginning:");
		nameList.display();
	}
}