import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class practiseArray {

        private ArrayList<String> groceryList = new ArrayList<>();

        public void addGroceryItem(String item) {
            groceryList.add(item);

        }

        public void printGroceryItem() {
            System.out.println("The number of Grocery items are " + groceryList.size());
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
            System.out.println("The item " + theItem + " has been removed");
        }

        public String findGroceryItem(String findItem) {
            int position = groceryList.indexOf(findItem);
            if(position>=0){
                return groceryList.get(position);
            }
            return null;

        }

    }


class Main1{
    private static practiseArray groceryList = new practiseArray();
  private static  Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int choice =0;
        printInstructions();
        while (!quit){
            System.out.print("Enter your choice ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryItem();
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
                    searchItem();
                    break;
                case 6:
                    quit= true;
                    break;




            }
        }
    }
    public static void printInstructions(){
        System.out.println("\n Print");
        System.out.println("\t 0- Print Instructions");
        System.out.println("\t 1- Print Grocery List");
        System.out.println("\t 2- Add Items");
        System.out.println("\t 3- Modify Items");
        System.out.println("\t 4- Remove Items");
        System.out.println("\t 5- Search for Items");
        System.out.println("\t 6- Exit the application");



    }
    public static void addItem(){
        System.out.println("Please enter the grocery item ");
        groceryList.addGroceryItem(sc.nextLine());
    }
    public static void modifyItem(){
        System.out.println("Enter item number ");
        int itemNo= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter replacement item ");
        String newItem = sc.nextLine();
        groceryList.modifyGroceryItem(itemNo-1,newItem);
    }
    public static void removeItem(){
        System.out.println("Enter the item number to be removed");
        int itemNo= sc.nextInt();
        sc.nextLine();
        groceryList.removeGroceryItem(itemNo-1);

    }
    public static void searchItem(){
        System.out.println("Enter the item to search ");
        String item = sc.nextLine();
       if (groceryList.findGroceryItem(item) !=null){
           System.out.println("Item "+item+ " is found in the List");

       }else {
           System.out.println("Item " +item+ " not found in the List ");
       }
    }
}
