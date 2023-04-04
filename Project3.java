import java.util.ArrayList;
import java.util.Scanner;
/*
 * Eric Halsey
 * Due 4/3/23
 */
public class Project3 
{

    //globally declared to be used throughout
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> list = new ArrayList<>();
    /*
     * This program displays a menu of options to the user and performs the selected action.
     * 
     * @param args the command line arguments
     * 
     * This program uses the Scanner class to read input from the user and the printf method 
     * to format and display output to the console.
     * 
     * 
     * 
     * The performAction method takes an integer parameter representing the user's menu choice 
     * and returns void.
     * 
     * The performDisplayList method takes no parameters and returns void.
     * 
     * The validateInput method takes a String parameter representing the user's input 
     * and returns a boolean indicating whether the input is valid.
     * 
     * The getInput method takes no parameters and returns a String representing the user's input.
     */
    public static void main(String[] args) 
    {
        while (true) 
        {
            displayMenu();
            String choice = scanner.nextLine().toLowerCase();
            switch (choice) // case and breaks for all of the methods available in the menu
            {
                case "add":
                    performAdd();
                    break;
                case "delete":
                    performDelete();
                    break;
                case "search":
                    performSearch();
                    break;
                case "retrieve":
                    performRetrieve();
                    break;
                case "get length":
                    performGetLength();
                    break;
                case "display list":
                    performDisplayList();
                    break;
                case "exit":
                    System.out.printf("Exiting program...%n");
                    return;
                default:
                    System.out.printf("Invalid choice. Please try again.%n");
                    
            }
            //line feed
            System.out.printf("%n");
        }
    }
/**
 * Displays the menu options for the user to select from.
 * 
 * @param none
 * @return none
 */
    private static void displayMenu() 
    {
        //specific user instructions
        System.out.printf("Instruction: Please type in the name of the function you would like to use.%n");
        System.out.printf("Menu:%n");
        System.out.printf("1. Add%n");
        System.out.printf("2. Delete%n");
        System.out.printf("3. Search%n");
        System.out.printf("4. Retrieve%n");
        System.out.printf("5. Get length%n");
        System.out.printf("6. Display list%n");
        System.out.printf("7. Exit%n");
        System.out.printf("Enter your choice: ");
    }
/**
 * Adds an element to the list at a specified index or at the end of the list.
 *
 * @param None explicit, takes input from the user through the console.
 * @return None
 */
    private static void performAdd() 
    {
        // Prompt the user for the element to add
        System.out.printf("Enter the element to add: %n");
        String element = scanner.nextLine();

        // Prompt the user for the location to add the element
        System.out.printf("Do you want to add the element at the end of the list? (Y/N): %n");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("y")) 
        {
            // If the user chooses to add the element to the end of the list, add it and print a success message
            list.add(element);
            System.out.printf("Element added successfully.%n");
        } else 
        {
            // If the user chooses to add the element at a specific index, prompt for the index and add the element
            System.out.printf("Enter the index to add the element at: %n");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if (index < 0 || index > list.size()) 
            {
                // If the index is invalid, print an error message
                System.out.printf("Invalid index. Please try again.%n");
            } else 
            {
                 // If the index is valid, add the element and print a success message
                list.add(index, element);
                System.out.printf("Element added successfully.%n");
            }
        }
    }

/**
 * This method prompts the user to delete an element from the list. 
 * If the user chooses to search for the element by value,
 * it searches for the element in the list and deletes it if found. If the user chooses to delete by index, 
 * it prompts for the index and deletes the element at that index. If the index entered is out of bounds, 
 * it displays an error message.
 * 
 * @param none
 * @return none
 */
    private static void performDelete() 
    {
        // Prompt user to choose whether to delete element by searching for it or by index
        System.out.printf("Do you want to delete the element by searching for it? (Y/N): %n");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("y")) 
        {
            // Delete element by searching for it
            System.out.printf("Enter the element to delete: %n");
            String element = scanner.nextLine();
            int index = list.indexOf(element);
            if (index == -1) 
            {
                // Element not found in list
                System.out.printf("Element not found in list.%n");
            } else 
            {
                // Element found in list, remove it
                list.remove(index);
                System.out.printf("Element deleted successfully.%n");
            }
        } else 
        {
            // Delete element by index
            System.out.printf("Enter the index to delete the element at: %n");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if (index < 0 || index >= list.size()) 
            {
                // Invalid index specified
                System.out.printf("Invalid index. Please try again.%n");
            } else 
            {
                // Valid index specified, remove element at that index
                list.remove(index);
                System.out.printf("Element deleted successfully.%n");
            }
        }
    }

    /**
     * Searches the list for the specified element and returns its index if found.
     * 
     * @return If element is found, returns the index of the element in the list. If element is not found, returns -1.
     * 
     * @param element the element to search for in the list.
     */
    private static void performSearch() 
    {
        // Prompt user to enter the element to search for
        System.out.printf("Enter the element to search for: %n");

        // Read the user input
        String element = scanner.nextLine();

        // Find the index of the element in the list
        int index = list.indexOf(element);

         // Check if element was found or not
        if (index == -1) 
        {
            System.out.printf("Element not found in list.%n");
        } else 
        {
            System.out.printf("Element found at index " + index + ".%n");
        }
    }

    /**
     * Retrieves an element from the list at the specified index.
     * Prompts the user to enter the index of the element to retrieve,
     * and displays the element at that index if it exists.
     */
    private static void performRetrieve() 
    {
         // Get user input
        System.out.printf("Enter the index of the element to retrieve: %n");
        int index = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

         // Check if the index is out of bounds
        if (index < 0 || index >= list.size()) 
        {
            System.out.printf("Invalid index. Please try again.%n");
        } else 
        {
            String element = list.get(index); // Retrieve element at specified index
            System.out.printf("Element at index " + index + " is " + element + ".%n");
        }
    }
    
    /**
     * Gets the length of the list.
     * @param none
     * @return The length of the list.
     */
    private static void performGetLength() 
    {
        // Checks the length of the array and displays it
        int length = list.size();
        System.out.printf("Length of list is " + length + ".%n");
    }
    /**
     * Displays the contents of the list.
     * If the list is empty, prints a message indicating that the list is empty.
     * @param none
     * @return none
     */
    private static void performDisplayList() 
    {
        if (list.isEmpty()) 
        {
            System.out.printf("List is empty.%n");
        } else 
        {
            // Loop through the list and print each element with its index
            System.out.printf("List contents:%n");
            for (int i = 0; i < list.size(); i++) 
            {
                System.out.printf("%d. %s\n", i, list.get(i));
            }
        }
    }
}