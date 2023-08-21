import java.util.ArrayList;
import java.util.Scanner;
class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nPhone: " + phoneNumber + "\nEmail: " + email;
    }
    public Object getFirstName() {
        return firstName;
    }
    public Object getLastName() {
        return lastName;
    }
}
class AddressBook {
    private ArrayList<Contact>contacts;
    public AddressBook() {
        contacts = new ArrayList<>();
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    public Contact findContactByName(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null;
    }
    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("xxxxxxxxxx");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("1. Add Contact");
            System.out.println("2. Find Contact by Name");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    Contact newContact = new Contact(firstName, lastName, phoneNumber, email);
                    addressBook.addContact(newContact);
                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    System.out.print("Enter First Name: ");
                    String searchFirstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String searchLastName = scanner.nextLine();
                    Contact foundContact = addressBook.findContactByName(searchFirstName, searchLastName);
                    if (foundContact != null) {
                        System.out.println("Contact Found:\n" + foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
                    System.out.println("All Contacts:");
                    addressBook.displayAllContacts();
                    break;
                case 4:
                    System.out.println("Exiting Address Book System");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
