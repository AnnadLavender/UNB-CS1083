import java.util.Scanner;
import java.io.*;

public class Question3
{
    public static void main(String[] args)
    {
        Scanner scanner = null;
        PrintWriter printWriter = null;
        String name;
        double score;
        String maxName = null;
        double maxScore = 0.0;
        try
        {
            scanner = new Scanner(new File("infile.txt"));
            printWriter = new PrintWriter("outfile.txt");
            while(scanner.hasNext())
            {
                name = scanner.next();
                score = scanner.nextDouble();
                if(maxScore < score)
                {
                    maxName = name;
                    maxScore = score;
                }
            }
            printWriter.println("Has highest score: " + maxName);
        }
        catch(IOException e)
        {
            System.out.println("Error in processing file.");
        }
        finally
        {
            try
            {
                System.out.println("Closing output file...");
                printWriter.close();
            }
            catch(Exception e)
            {
                System.out.println("Error in closing file.");
            }
        }
        System.out.println("The end!");
    }
}