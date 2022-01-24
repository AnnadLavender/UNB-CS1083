/**
 * Provides a variety of methods for searching a Student object.
 * @author Ngoc Phuong Anh Nguyen - 3712361
*/
public class StudentBinarySearch
{
	/**
	 * Constant to signify an unsuccessful search.
	 */
	public static final int NOTFOUND = -1;

	/**
	 * Searches for a index of a Student object in an array of Student object, sorted by student ID(ascending order) using the binary search algorithm.
	 * @param stu A sorted array of Student objects, in ascending order according to their student id values.
	 * @param count A counter indicating how many Student objects are in the array.
	 * @param studentID A student ID value.
	 * @return The index where a Student object with the given student id value is located.
	 */
	public static int studentBinarySearch(Student[] stu, int count, int studentID)
	{
		int foundPosition = NOTFOUND;
		int low = 0;
		int high = count - 1;
		int mid;
		
		while(foundPosition == NOTFOUND && low <= high)
		{
			mid = (low + high) / 2;
			if(stu[mid].getStudentId() == studentID)
			{
				foundPosition = mid;
			}
			else if(studentID > stu[mid].getStudentId())
			{
				low = mid + 1;
			}
			else
				high = mid - 1;
		}
		return foundPosition;
	}
}