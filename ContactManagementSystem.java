import java.util.*;

class Contact {
    String name;
    String phoneNumber;
    String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void displayContact() {
        System.out.printf("| %-20s | %-15s | %-25s |\n", name, phoneNumber, email);
    }
}

public class ContactManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Contact> contacts = new ArrayList<>();

    public static void addContact() {
        System.out.println("\nEnter contact details:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phoneNumber, email));
        System.out.println("\nContact added successfully!");
    }
    public static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("\nNo contacts available.");
        } else {
            System.out.println("\nDisplaying all contacts:\n");
            System.out.println("|----------------------|-----------------|-------------------------|");
            System.out.printf("| %-20s | %-15s | %-25s |\n", "Name", "Phone Number", "Email");
            System.out.println("|----------------------|-----------------|-------------------------|");

            for (Contact contact : contacts) {
                contact.displayContact();
            }

            System.out.println("|----------------------|-----------------|-------------------------|");
        }
    }

    // Method to update a contact
    public static void updateContact() {
        System.out.print("\nEnter the name of the contact you want to update: ");
        String nameToUpdate = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(nameToUpdate)) {
                found = true;

                System.out.println("\nUpdating contact: " + contact.name);

                System.out.print("New Phone Number: ");
                contact.phoneNumber = scanner.nextLine();

                System.out.print("New Email: ");
                contact.email = scanner.nextLine();

                System.out.println("\nContact updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("\nContact not found.");
        }
    }
    public static void deleteContact() {
        System.out.print("\nEnter the name of the contact you want to delete: ");
        String nameToDelete = scanner.nextLine();

        boolean found = false;
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.name.equalsIgnoreCase(nameToDelete)) {
                iterator.remove();
                found = true;
                System.out.println("\nContact deleted successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("\nContact not found.");
        }
    }
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    displayContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("\nExiting... Goodbye!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        } while (choice != 5);
    }
}