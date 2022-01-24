/**
 * This is a driver program.
 * @author Ngoc Phuong Anh Nguyen - 3712361
 */
public class StudentSearchTest
{
    /**
     * This method creates a randomly generated array of student objects
     * @param baseId A starting point for generating pseudo-random student id values.
     * @param arraySize The size of the desired array.
     * @param studentsNumber The number of array elements to fill in other words, the number of Student objects to be created and inserted into the array
     * @return a randomly generated array of student objects.
     */
    public static Student[] generateStudentArray(int baseId, int arraySize, int studentsNumber)
    {
        Student[] students = new Student[arraySize];
        String[] surname = {"Olson","Jackson","Tremblay","Roy","Gagnon","Bouchard","Anderson","Cameron","Hamilton","Morrison"};
        String[] givenName = {"Lucas","Amy","Logan","Jacob","Alex","Mellisa","Jason","Anna","Emma","Charlotte"};
        int i = 0;

        while(i<studentsNumber)
        {
            students[i] = new Student(
                    baseId + (int)(Math.random()*(80000 - 1 + 1)) + 1,
                    surname[(int)(Math.random()*(surname.length - 1 + 1))],
                    givenName[(int)(Math.random()*(givenName.length - 1 + 1))],
                    ((int)(Math.random()*(40-20+1))+20)/10.0
                    );
            int j=0;
            boolean found = false;

            while(!found && j<i)
            {
                if(students[i].getGivenNames().equals(students[j].getGivenNames()) && students[i].getSurname().equals(students[j].getSurname()))
                {
                    found = true;
                }
                j++;
            }

            if(!found)
            {
                baseId = students[i].getStudentId();
                i++;
            }
        }
        return students;
    }

    public static void main(String[] args)
    {
        Student[] student = generateStudentArray(3182811,20,10);

        for(int c = 0;c < 10;c++)
        {
            System.out.println("["+ c +"] "+student[c].toString());
        }

        System.out.println("\nSt. Id  Result\n======= =======");

        System.out.println(student[0].getStudentId()+"    "+StudentBinarySearch.studentBinarySearch(student,10,student[0].getStudentId()));
        System.out.println(student[9].getStudentId()+"    "+StudentBinarySearch.studentBinarySearch(student,10,student[9].getStudentId()));
        int temp = (int) (Math.random()*10);
        System.out.println(student[temp].getStudentId()+"    "+StudentBinarySearch.studentBinarySearch(student,10,student[temp].getStudentId()));

        System.out.println((student[0].getStudentId()-1)+"    "+StudentBinarySearch.studentBinarySearch(student,10,(student[0].getStudentId()-1)));
        System.out.println((student[9].getStudentId()+1)+"    "+StudentBinarySearch.studentBinarySearch(student,10,(student[9].getStudentId()+1)));
        System.out.println((student[temp].getStudentId()+1)+"    "+StudentBinarySearch.studentBinarySearch(student,10,(student[temp].getStudentId()+1)));
    }
}