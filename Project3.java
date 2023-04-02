import java.util.ArrayList;
import java.util.Scanner;

public class Project3 
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) 
    {
        while (true) 
        {
            displayMenu();
            String choice = scanner.nextLine().toLowerCase();
            switch (choice) 
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
                    break;
                    
            }
            System.out.printf("%n");
        }
    }

    private static void displayMenu() 
    {
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

    private static void performAdd() 
    {
        System.out.printf("Enter the element to add: %n");
        String element = scanner.nextLine();
        System.out.printf("Do you want to add the element at the end of the list? (Y/N): %n");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("y")) 
        {
            list.add(element);
            System.out.printf("Element added successfully.%n");
        } else 
        {
            System.out.printf("Enter the index to add the element at: %n");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if (index < 0 || index > list.size()) 
            {
                System.out.printf("Invalid index. Please try again.%n");
            } else 
            {
                list.add(index, element);
                System.out.printf("Element added successfully.%n");
            }
        }
    }

    private static void performDelete() 
    {
        System.out.printf("Do you want to delete the element by searching for it? (Y/N): %n");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("y")) 
        {
            System.out.printf("Enter the element to delete: %n");
            String element = scanner.nextLine();
            int index = list.indexOf(element);
            if (index == -1) 
            {
                System.out.printf("Element not found in list.%n");
            } else 
            {
                list.remove(index);
                System.out.printf("Element deleted successfully.%n");
            }
        } else 
        {
            System.out.printf("Enter the index to delete the element at: %n");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if (index < 0 || index >= list.size()) 
            {
                System.out.printf("Invalid index. Please try again.%n");
            } else 
            {
                list.remove(index);
                System.out.printf("Element deleted successfully.%n");
            }
        }
    }

    private static void performSearch() 
    {
        System.out.printf("Enter the element to search for: %n");
        String element = scanner.nextLine();
        int index = list.indexOf(element);
        if (index == -1) 
        {
            System.out.printf("Element not found in list.%n");
        } else 
        {
            System.out.printf("Element found at index " + index + ".%n");
        }
    }


    private static void performRetrieve() 
    {
        System.out.printf("Enter the index of the element to retrieve: %n");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        if (index < 0 || index >= list.size()) 
        {
            System.out.printf("Invalid index. Please try again.%n");
        } else 
        {
            String element = list.get(index);
            System.out.printf("Element at index " + index + " is " + element + ".%n");
        }
    }
    
    private static void performGetLength() 
    {
        int length = list.size();
        System.out.printf("Length of list is " + length + ".%n");
    }
    
    private static void performDisplayList() 
    {
        if (list.isEmpty()) 
        {
            System.out.printf("List is empty.%n");
        } else 
        {
            System.out.printf("List contents:%n");
            for (int i = 0; i < list.size(); i++) 
            {
                System.out.printf("%d. %s\n", i, list.get(i));
            }
        }
    }
}