import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
/*Eric Halsey 
 * Due 3/3/2023
 * This program generates a random table of numbers and creates a masked version of the table where
 * cells with positive values are replaced with 1 and cells with non-positive values are replaced
 * with 0.
 */
public class Project2
{
    /**
   * The main method prompts the user to enter the number of rows and columns for the table,
   * After validating the user's input for the number of rows and columns, the program generates a 2D array of integers using the loadTable method, 
   * where each element of the array is a random integer between -49 and 49, inclusive. 
   * The program then uses the getMask method to create a new 2D array called "masked,"
   * where each element of the array is 1 if the corresponding element in the original array is positive, and 0 otherwise.
   * The program then outputs both the original and the masked tables to the console and writes the masked table 
   * to a file named "masked.txt" using the outputFileTable method. 
   * Finally, the program reads the contents of the file "masked.txt" and outputs them to the console using the readTable method.
   * @param args the command line arguments
   */
    public static void main(String[] args) 
    {
    // Declarations
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    int rows = 1;
    int columns = 1;
    boolean validInput = false;
    

    // Prompt user for valid number of rows and columns
    while (!validInput) {
        try {
            System.out.print("Enter number of rows (1-10): ");
            rows = input.nextInt();
            while (rows < 1 || rows > 10) {
                System.out.print("Invalid input. Number of rows must be between 1 and 10 inclusive. Enter number of rows (1-10): ");
                rows = input.nextInt();
            }

            System.out.print("Enter number of columns (1-10): ");
            columns = input.nextInt();
            while (columns < 1 || columns > 10) {
                System.out.print("Invalid input. Number of columns must be between 1 and 10 inclusive. Enter number of columns (1-10): ");
                columns = input.nextInt();
            }

            validInput = true;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer value.");
            input.nextLine(); // consume invalid input
        }
    }
    int[][] table = loadTable(rows, columns, rand);
    int[][] masked = getMask(table);
    System.out.printf("Unmasked:%n"); 
    outputTable(table);
    System.out.printf("%nMasked: %n");
    outputFileTable(masked);
    readTable();
    //line feed
    System.out.println("\n");
    //Close scanner object
    input.close();
    }





    /**
     * This segment of code defines a method named loadTable that takes three parameters: rows, columns, and rand.
     *  This method generates and returns a 2D array of integers with the given number of rows and columns.
     *  It initializes each element of the array with a random integer between -49 and 49, inclusive. 
     * This method can be used to create a table for further manipulation or analysis.
     * @param rows
     * @param columns
     * @param rand
     * @return
     */
    public static int[][] loadTable(int rows, int columns, Random rand) 
    {
        int[][] table = new int[rows][columns];
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                table[i][j] = rand.nextInt(99) - 49;
            }
        }
        return table;
    }
    
      /**
   * This method creates a masked version of the input table, where cells with positive values are
   * replaced with 1 and cells with non-positive values are replaced with 0.
   *
   * @param table the input table to be masked
   * @return the masked table
   */
    public static int[][] getMask(int[][] table) 
    {
        int rows = table.length;
        int columns = table[0].length;
        int[][] mask = new int[rows][columns];
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                if (table[i][j] > 0) 
                {
                    mask[i][j] = 1;
                } 
                else 
                {
                    mask[i][j] = 0;
                }
            }
        }
        return mask;
    }
    /**
   * This method outputs a table of numbers to the console.
   *
   * @param table the table to be output
   */
    public static void outputTable(int[][] table) 
    {
    int rows = table.length;
    int columns = table[0].length;
        for (int i = 0; i < rows; i++) 
        {
        for (int j = 0; j < columns; j++) 
        {
            System.out.printf("%4d", table[i][j]);
        }
        System.out.println();
        }
    }

    /**
     * this method outputs the file to the masked.txt file
     * @param table
     */
    public static void outputFileTable(int[][] table) 
    {
        try
        {
            PrintWriter out = new PrintWriter("masked.txt");
                int rows = table.length;
                int columns = table[0].length;
                for (int i = 0; i < rows; i++) 
                    {
                    for (int j = 0; j < columns; j++) 
                        {
                            out.printf("%4d", table[i][j]);
                        }
                    out.printf("%n");
                    }
            out.close();
        }
        catch(FileNotFoundException e)
        {
            System.err.print("Error: " + e.getMessage());
        }
        
        
    }
    /**
     * This method reads the masked.txt file and outputs whatever is in it to the console
     */
    public static void readTable()
    {
        try
        {
            Scanner scanner = new Scanner(new File("masked.txt"));
            while (scanner.hasNextLine()) 
            {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } 
        catch (FileNotFoundException exception) 
        {
            System.err.println("Error: " + exception.getMessage());
        }
       
    }
    
}