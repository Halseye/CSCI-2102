import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
This program reads a file with numbers, and writes the numbers to another
file, lined up in a column and followed by their total.
*/
public class Total2
{

    public static void main(String[] args) throws FileNotFoundException
    {
        double total = 0;
        Scanner console = new Scanner(System.in);
        String inputFileName = console.next();
        String outputFileName = console.next();
        File inputFile = new File(inputFileName);
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter(outputFileName);
        

        System.out.print("Input file: ");
        System.out.print("Output file: ");

            while (in.hasNextDouble())
            {
                double value = in.nextDouble();
                out.printf("%15.2f\n", value);
                total = total + value;
            }
        out.printf("Total: %8.2f\n", total);

    in.close();
    out.close();
    }
}