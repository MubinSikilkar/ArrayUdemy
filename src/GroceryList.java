import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified");
    }

    public void removeGroceryItem(int position) {
        String theItem = groceryList.get(position);
        groceryList.remove(position);
        System.out.println("Grocery item " + theItem + " has been removed  ");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.print("The updated grocery list is " + groceryList.get(i));
        }
    }

    public String findItem(String searchItem) {
        // boolean exists = groceryList.contains(searchItem);
        int position = groceryList.indexOf(searchItem);
        if (position >= 0) {
            return groceryList.get(position);
        }
        return null;
    }
}

class Main {
    private static Scanner sc = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit) {
            System.out.println("Enter your choice ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;

            }

        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0- To print the choice of options ");
        System.out.println("\t 1- To print the list of Grocery Items ");
        System.out.println("\t 2- To add an item to the Grocery list ");
        System.out.println("\t 3- To modify an item in the Grocery List");
        System.out.println("\t 4- To remove an item from the grocery list");
        System.out.println("\t 5- to search for an item in the Grocery List");
        System.out.println("\t 6- To quit the application");
    }

    public static void addItem() {
        System.out.print("Please Enter Grocery item: ");
        groceryList.addGroceryItem(sc.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Enter item number: ");
        int itemNo = sc.nextInt();
        sc.nextLine();
        System.out.print(" Enter replacement item : ");
        String newItem = sc.nextLine();
        groceryList.modifyGroceryItem(itemNo - 1, newItem);

    }

    public static void removeItem() {
        System.out.print("Enter the item number: ");
        int itemNo = sc.nextInt();
        sc.nextLine();
        groceryList.removeGroceryItem(itemNo - 1);

    }

    public static void searchForItem() {
        System.out.print("Enter item to search ");
        String searchItem = sc.nextLine();
        if (groceryList.findItem(searchItem) != null) {
            System.out.println("Found Grocery item " + searchItem + " in our list");
        } else {
            System.out.println(searchItem + " is not in our list");
        }
    }
}
