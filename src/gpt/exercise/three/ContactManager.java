package gpt.exercise.three;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactManager {
    static private ArrayList<Contact> contactsList = new ArrayList<>();

    static Scanner keyBoard = new Scanner(System.in);

    // A method to add a new contact to the contact list
    private static boolean addContact() {
        Contact newContact = createContact();
        boolean isAdded = false;

        if (newContact != null) {
            if (contactsList.isEmpty()) {
                contactsList.add(newContact);
            } else {
                for (Contact contact : contactsList) {
                    if (contact.getPhoneNumber().equals(newContact.getPhoneNumber())
                    || contact.getEmail().equals(newContact.getEmail())) {
                        System.out.println("Contact already exist");
                        return isAdded;
                    }
                }
                contactsList.add(newContact);
            }
            isAdded = true;
        }
        return isAdded;
    }

    //A method to display contacts in the contact list
    private static void showContacts() {
        String separator = "-";
        int index = 1;

        System.out.println("\nContacts List:");
        try {
            if (contactsList.isEmpty()) {
                System.out.println(separator.repeat(20));
                System.out.println("No contacts\n");
            } else {
                for (Contact contact : contactsList) {
                    System.out.println(separator.repeat(20));
                    System.out.println(index + ". " + contact);
                    index++;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("No contact list");
        }
    }

    //A method to display the main menu and submenus
    public static void menu() {
        int userChoice = -1;
        boolean quitMenu = false;

        System.out.println("Welcome to the Contact Manager!");
        do {
            System.out.println("""
                
                1. Add new contact
                2. Show all contacts
                3. Exit""");

            boolean validOption = false;
            do {
                try {
                    userChoice = getUserChoice();
                    validOption = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid option");
                    break;
                }
            } while(!validOption);

            if (validOption) {
                switch (userChoice) {
                    case 1 -> {
                        if (addContact()) {
                            System.out.println("Contact added successfully");
                        } else {
                            System.out.println("Contact not added");
                        }
                        System.out.print("\n");
                    }
                    case 2 -> showContacts();
                    case 3 -> {
                        quitMenu = true;
                        System.out.println("Goodbye!");
                    }
                    default -> System.out.println("Incorrect option, please try again");
                }
            }
        } while(!quitMenu);

    }

    // A method to get & return the user's choice (int) from keyboard
    private static int getUserChoice() {
        int userChoice;

        System.out.print(">> ");
        try {
            userChoice = keyBoard.nextInt();
            keyBoard.nextLine();
            return userChoice;
        } catch (InputMismatchException e) {
            keyBoard.nextLine();
            throw new IllegalArgumentException(e);
        }
    }

    // A method to get & return the user's input (String) from keyboard
    private static String getUserInput() {
        String userInput;
        try {
            userInput = keyBoard.nextLine();
            return userInput;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(e);
        }
    }

    // A method that creates & return an object of the Contact class
    private static Contact createContact() {
        String enteredName = "";
        String enteredEmail = "";
        String enteredPhoneNumber = "";
        boolean correctInput;

        do {
            correctInput = false;
            System.out.println("Enter contact name: ");
            System.out.print(">> ");
            try {
                enteredName = getUserInput();
                if (!isBlankInput(enteredName)) {
                    correctInput = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid contact name");
            }
        } while (!correctInput);
        do {
            correctInput = false;
            System.out.println("Enter contact email: ");
            System.out.print(">> ");
            try {
                enteredEmail = getUserInput();
                if (!isBlankInput(enteredEmail)) {
                    correctInput = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid contact email");
            }
        } while (!correctInput);
        do {
            correctInput = false;
            System.out.println("Enter phone number: ");
            System.out.print(">> ");
            try {
                enteredPhoneNumber = getUserInput();
                if (!isBlankInput(enteredPhoneNumber)) {
                    correctInput = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid phone number");
            }
        } while (!correctInput);

        return new Contact(enteredName, enteredEmail, enteredPhoneNumber);
    }

    // A method that checks if an input (String) is blank
    private static boolean isBlankInput(String input) {
        if (input.isBlank()) {
            System.out.println("You can't create a contact with an empty field");
        }
        return input.isBlank();
    }
}
