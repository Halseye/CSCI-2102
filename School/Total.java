import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Eric Halsey
 * Due:2/24/2023
 */
/**
This program reads a file with numbers, and writes the numbers to another
file, lined up in a column and followed by their total.
*/
public class Total
{
        //Main method to run the program
    public static void main(String[] args) throws FileNotFoundException
    {
        //Declaration section
        double total = 0;

        // Promt the user for the input and output file names
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();
        System.out.print("Output file: ");
        String outputFileName = console.next();
        
        //Construct the Scanner and PrintWriter Objects for reading and writing
        File inputFile = new File(inputFileName);
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter(outputFileName);

            //While loop that uses the stored doubles from the input file and adds them to a total 
            while (in.hasNextDouble())
            {
                double value = in.nextDouble();
                out.printf("%15.2f\n", value);
                total = total + value;
            }            
            //prints the total into an output file
            out.printf("Total: %8.2f\n", total);

        //Closes the input and the output files
        in.close();
        out.close();
    }
}