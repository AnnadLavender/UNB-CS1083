/**	A simple Student class to demonstrate sorting of objects
	@author Andrew McAllister
*/

public class Student
{
	/** The student id number */
	private int studentId;
	/** The student's surname */
	private String surname;
	/** The student's given name(s) */
	private String givenNames;
	/** The student's grade point average */
	private double gpa;
  
	/** Constructs a Student instance given values for
		each of the instance variables
		@param studentIdIn The student's "student id"
		@param surnameIn The student's surname
		@param givenNamesIn The student's given name(s)
		@param gpaIn The student's grade point average
	*/
	public Student(int studentIdIn,
                   String surnameIn,
                   String givenNamesIn,
                   double gpaIn)
	{	studentId = studentIdIn;
		surname = surnameIn;
    	givenNames = givenNamesIn;
    	gpa = gpaIn;
    }

	/** Accessor for studentId 
		@return The student id number
	*/
	public int getStudentId()
	{	return studentId;
	}

	/** Accessor for surname 
		@return The student's surname
	*/
	public String getSurname()
	{	return surname;
	}

	/** Accessor for givenNames 
		@return The student's given name(s)
	*/
	public String getGivenNames()
	{	return givenNames;
	}

	/** Updates the student's grade point average
		@param gpaIn The new grade point average
	*/
	public void setGpa(double gpaIn)
	{	gpa = gpaIn;
	}
	
	/** A standard toString() method.
		@return A String representation of the
				Student object
	*/
	public String toString()
	{	return "Student[studentId="
			+ studentId
			+ ", surname="
			+ surname
			+ ", givenNames="
			+ givenNames
			+ ", gpa="
			+ gpa
			+ "]";
	}

}  // end Student class

