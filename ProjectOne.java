import java.util.Scanner;
import java.util.Random;

public class ProjectOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        while (rows < 1 || rows > 10) {
            System.out.println("Invalid input. Number of rows must be between 1 and 10.");
            System.out.print("Enter number of rows: ");
            rows = sc.nextInt();
        }
        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();
        while (columns < 1 || columns > 10) {
            System.out.println("Invalid input. Number of columns must be between 1 and 10.");
            System.out.print("Enter number of columns: ");
            columns = sc.nextInt();
        }

        int[][] table = new int[rows][columns];
        loadTable(table);
        System.out.println("\nBefore:");
        outputTable(table);
        int[][] mask = getMask(table);
        System.out.println("\nAfter:");
        outputTable(mask);
    }

    public static void loadTable(int[][] table) {
        Random rng = new Random();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = rng.nextInt(100) - 49;
            }
        }
    }

    public static int[][] getMask(int[][] table) {
        int[][] mask = new int[table.length][table[0].length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] > 0) {
                    mask[i][j] = 1;
                } else {
                    mask[i][j] = 0;
                }
            }
        }
        return mask;
    }

    public static void outputTable(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%4d", table[i][j]);
            }
            System.out.println();
        }
    }
}