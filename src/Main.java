import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("123456");


    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {

            System.out.println("\nEnter action: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down");
                    quit = true;
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

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - shutdown");
        System.out.println("1 - print contacts");
        System.out.println("2 - add contact");
        System.out.println("3 - update contact");
        System.out.println("4 - remove contact");
        System.out.println("5 - query contact");
        System.out.println("6 - print available actions");
        System.out.println("Choose action: ");
    }

    private static void addNewContact() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter number: ");
        String number = scanner.nextLine();
        Contact contact = Contact.createContact(name, number);
        if (mobilePhone.addNewContact(contact)) {
            System.out.println("New contact added: " + name + " " + number);
        } else {
            System.out.println("Cannot add: " + name + " " + number);
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existing = mobilePhone.queryContact(name);
        if (existing == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existing, newContact)) {
            System.out.println("Updated");
        } else {
            System.out.println("Error updating");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existing = mobilePhone.queryContact(name);
        if (existing == null) {
            System.out.println("Contact not found");
            return;
        }
        if (mobilePhone.removeContact(existing)) {
            System.out.println("Contact deleted");
        } else {
            System.out.println("Error deleting contact");
        }
}

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existing = mobilePhone.queryContact(name);
        if (existing == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + existing.getName() + " phone number is: " + existing.getNumber());
    }
}
