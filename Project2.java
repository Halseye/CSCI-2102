import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.NumberFormatException;
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
   * The main method prompts the user to enter the number of rows and columns for the table, generates
   * a random table of numbers, and outputs the original table and the masked table.
   *
   * @param args the command line arguments
   */
    public static void main(String[] args) throws FileNotFoundException, InputMismatchException
    {
    
        // Declarations
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int rows;
        int columns;
        rows = 1;
        columns = 1;
        boolean validInput = false;

        while (!validInput)
        {
            try
            {
                // Get number of rows from user
                System.out.printf("Enter number of rows (1-10): ");
                rows = input.nextInt();
                    while (rows < 1 || rows > 10) 
                        {
                            System.out.printf("Invalid input. Number of rows must be between 1 and 10 inclusive. Enter number of rows (1-10): ");
                            rows = input.nextInt();
                        }
                
                // Get number of columns from user
                System.out.printf("Enter number of columns (1-10): ");
                columns = input.nextInt();
                    while (columns < 1 || columns > 10) 
                        {
                            System.out.printf("Invalid input. Number of columns must be between 1 and 10 inclusive. Enter number of columns (1-10): ");
                            columns = input.nextInt();
                        }
                validInput = true;
            }

            catch(InputMismatchException Exception)
                {
                    System.out.println("Invalid input. Please enter an integer value.");
                    input.nextLine();
                }
        }
        // Load table
        int[][] table = loadTable(rows, columns, rand);
        
        // Output original table to masked.txt
        outputTable(table);
        
        // Create and output masked table
        int[][] mask = getMask(table);
        System.out.printf("After:%n");
        readTable(mask);
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
    
    public static void readTable(int[][] table)
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

        catch(NumberFormatException exception)
        {
            System.err.println("Error: " + exception.getMessage());
        }
        catch (FileNotFoundException exception) 
        {
            System.err.println("Error: " + exception.getMessage());
        }
       
    }
    
}