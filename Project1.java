import java.util.Scanner;
import java.util.Random;

public class Project1 {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    // Get number of rows and columns from user
    System.out.print("Enter number of rows (max 10): ");
    int rows = input.nextInt();
    while (rows <= 0 || rows > 10) {
      System.out.print("Invalid Input, number of rows must be 10 or smaller. Enter number of rows (max 10): ");
      rows = input.nextInt();
    }

    System.out.print("Enter number of columns (max 10): ");
    int columns = input.nextInt();
    while (columns <= 0 || columns > 10) {
      System.out.print("Invalid Input, number of columns must be 10 or smaller. Enter number of columns (max 10): ");
      columns = input.nextInt();
    }

    // Random Table Generator
    int[][] table = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        table[i][j] = rand.nextInt(99) - 49;
      }
    }

    // Output original table
    System.out.println("Before: ");
    outputTable(table, rows, columns);

    // Create and output masked table
    int[][] mask = getMask(table, rows, columns);
    System.out.println("After: ");
    outputTable(mask, rows, columns);
  }

  // Method to create mask from original table
  public static int[][] getMask(int[][] table, int rows, int columns) {
    int[][] mask = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            if (table[i][j] > 0) {
                mask[i][j] = 1;
            }
                else {
               mask[i][j] = 0;
            }
          }
        }
    
    return mask;
    }

  // Method to output table
  public static void outputTable(int[][] table, int rows, int columns) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        System.out.printf("%4d", table[i][j]);
      }
      System.out.println();
    }
  }
}