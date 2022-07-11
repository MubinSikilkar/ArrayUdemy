import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone1 {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone1(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts=new ArrayList<>();
    }
    public boolean addNewContact(Contact contact){
        if (findContact(contact)!=-1){
            System.out.println("The contact" +contact+ " already exists in the phone");
            return false;
        }else {
            return myContacts.add(contact);
        }
    }
    private int findContact(Contact contact){
       return findContact(contact.getName());
    }
    private int findContact(String contactName){
        for (int i=0;i<myContacts.size();i++){
            Contact contact=myContacts.get(i);
            if (contact.getName().equals(contactName)){
                return  i;
            }

        }
        return -1;
    }
    public boolean updateContact( Contact oldContact, Contact newContact){
        if (findContact(oldContact)!=1){
         return myContacts.remove(oldContact) && myContacts.add(newContact);
        }else{
            return false;
        }
    }
    public boolean removeContact(Contact contact){
        if (findContact(contact)!=-1){
            return myContacts.remove(contact);
        }else {
            return false;
        }
    }
    public Contact queryContact(String name){
        for (int i=0;i<myContacts.size();i++){
            Contact contact= myContacts.get(i);
            if (contact.getName().equals(name)){
                return contact;
            }
        }
        return null;
    }
    public void printContacts() {
        System.out.println("Contact list: ");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println((i+1)+". "+contact.getName()+"-> "+contact.getPhoneNumber());
        }
    }
    
}
class Contact1{
    private String name;
    private String phoneNumber;

    public Contact1(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public static Contact createContact(String name, String phoneNumber){
        return new Contact(name, phoneNumber);

    }
}
class  Main4{
    private static Scanner sc= new Scanner(System.in);
    private static MobilePhone1 mobilePhone1= new MobilePhone1("8668638437");
    public static void main(String[] args) {

    }
}
