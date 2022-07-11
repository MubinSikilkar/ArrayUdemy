

import java.util.ArrayList;
import java.util.Scanner;

class Main3{
    private static Scanner sc= new Scanner(System.in);
    private static MobilePhone mobilePhone= new MobilePhone("I-Phone-13-Pro-Max");
    public static void main(String[] args) {
        boolean quit= false;
        startPhone();
        printActions();
        while (!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = sc.nextInt();
            sc.nextLine();
            switch(action){
                case 0:
                    System.out.println("\nShutting down...");
                    quit=true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;

            }

        }

    }
    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = sc.nextLine();
        System.out.println("Enter phone number: ");
        String phone = sc.nextLine();
        Contact newContact= Contact.createContact(name,phone);
        if (mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added: name = "+name+", phone = "+phone);
        }else{
            System.out.println("Cannot add "+name+" already on file");
        }
    }
    private static void updateContact(){
        System.out.println("Enter existing name: ");
        String name = sc.nextLine();
       Contact existingContactRecord= mobilePhone.queryContact(name);
       if (existingContactRecord==null) {
           System.out.println("Contact not found");
           return;
       }
        System.out.println("Enter the new contact name");
       String newName= sc.nextLine();
        System.out.println("Enter the new phone number");
        String newNumber= sc.nextLine();
        Contact newContact = Contact.createContact(newName,newNumber);
        if (mobilePhone.updateContact(existingContactRecord,newContact)){
            System.out.println("Successfully updating record ");
        }else {
            System.out.println("Error updating record");
        }
    }
    private static void removeContact() {
        System.out.println("Enter existing name: ");
        String name = sc.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted ");
        }else{
            System.out.println("Error in deleting the contact ");
        }
    }
    private static void queryContact() {
        System.out.println("Enter existing name: ");
        String name = sc.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name "+existingContactRecord.getName()+" phone Number "+existingContactRecord.getPhoneNumber());

    }

    public static void startPhone(){
        System.out.println("Assalam walekum ");
    }
    public static void printActions(){
        System.out.println("\nAvailable actions: \npress ");
        System.out.println("\t0 - Shutdown\n" +
                "\t1 - To print contacts\n"+
                "\t2 - To add a new contact\n"+
                "\t3 - Update contact\n"+
                "\t4 - To remove a contact\n"+
                "\t5 - To query a  contact\n"+
                "\t6 - To print a list of available actions");
        System.out.println("Choose your action: ");
    }

}

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContact;


    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContact = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        myContact.add(contact);
        return true;
    }


    private int findContact(Contact contact) {
        return this.myContact.indexOf(contact);

    }
    private int findContact(String contactName){
        for (int i=0;i<this.myContact.size();i++){
            Contact contact= this.myContact.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }

        }
        return -1;
    }
    public boolean updateContact(Contact oldContact,Contact newContact){
        int foundPosition= findContact(oldContact);
        if (foundPosition<0){
            System.out.println(oldContact.getName()+" was not found");
            return false;
        } else if (findContact(newContact.getName())!= -1) {
            System.out.println("Contact with name "+newContact.getName()+ " already exists. Update not successful ");
            return false;
        }
        this.myContact.set(foundPosition,newContact);
        System.out.println(oldContact.getName()+", was replaced by "+newContact.getName());
        return true;
    }
    public String queryContact(Contact contact){
        if (findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }
    public Contact queryContact(String name){
        int position = findContact(name);
        if (position>=0){
            return this.myContact.get(position);
        }
        return null;
    }
    public boolean removeContact(Contact contact){
        int foundPosition= findContact(contact);
        if (foundPosition<0){
            System.out.println(contact.getName()+" was not found");
            return false;
        }
        this.myContact.remove(foundPosition);
        System.out.println(contact.getName()+", was removed");
        return true;
    }
    public void printContacts(){
        System.out.println("Contact list ");
        for (int i=0;i<this.myContact.size(); i++){
            System.out.println((i+1)+"."+this.myContact.get(i).getName()+" ->"+
                    this.myContact.get(i).getPhoneNumber());
        }
    }



    }



class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

}
