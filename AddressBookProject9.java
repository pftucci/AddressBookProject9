import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookProject9 {
	
	static ArrayList<ContactProject9> contactsInAddressBook = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		
		
		int menuChoice = 0;
	
		
		do {
			menu();
			menuChoice = input.nextInt();
			input.nextLine();
			
			switch (menuChoice) {
				case 1:
					contactsInAddressBook.add(getContactDetails(input));
					break;
				case 2:
					displayAllContacts();
					editAContact(input);
					break;
				case 3: 
					displayAllContacts();
					deleteAContact(input);
					break;
				case 4:
					displayAllContacts();
					break;
			}	
		} while (menuChoice != 5);
		
	}
		
	public static void menu() {
		if (contactsInAddressBook.isEmpty()) {
			System.out.println("There are no contacts stored.");
		} else {
			System.out.println("\nAddress Book: ");
			for (ContactProject9 c:contactsInAddressBook){
			System.out.print("\n" + c.getStringToPrint() + "\n");
			}
		}
		
		System.out.println("\nWhat would you like to do? Select an option from the menu.");
		System.out.println("1) Add a new contact");
		System.out.println("2) Edit an existing contact");
		System.out.println("3) Delete an existing contact");
		System.out.println("4) Display all contacts");
		System.out.println("5) Exit");
	}
	
	public static ContactProject9 getContactDetails(Scanner input) {
		ContactProject9 x = null;
		
		System.out.println("Enter contact's name.");
		String contactName = input.nextLine();
		
		System.out.println("Enter contact's email.");
		String contactEmail = input.nextLine();
		
		System.out.println("Enter contact's phone number.");
		String contactPhoneNumber = input.nextLine();

		try {
			x = new ContactProject9(contactName, contactEmail, contactPhoneNumber);	
		} catch (InvalidPhoneNumberException e) {
			System.out.println(e.getMessage());
			x = getContactDetails(input);
		} catch (InvalidEmailException e) {
			System.out.println(e.getMessage());
			x = getContactDetails(input);
		}
		
		return x;
			
	}	
	
	public static void editAContact(Scanner input) {
	
		System.out.println("Which contact would you like to edit? Enter its index.");
		int contactToEdit = input.nextInt();
		
		ContactProject9 selectedContact = contactsInAddressBook.get(contactToEdit);
	
		System.out.println("What would you like to edit about contact?\n");
		System.out.println("1) Edit Name: " + selectedContact.getName());
		System.out.println("2) Edit Email: " + selectedContact.getEmail());
		System.out.println("3) Edit Phone number: " + selectedContact.getPhoneNumber());
		System.out.println("4) Exit to Main Menu");
		int editOption = input.nextInt();
		input.nextLine();
		
		switch (editOption) {
			case 1:
				selectedContact.getName();
				System.out.println("Enter new name.");
				String newName = input.nextLine();
				selectedContact.setName(newName);
				break;
			case 2:
				selectedContact.getEmail();
				while (true) {
					try {
						System.out.println("Enter new email.");
						String newEmail = input.nextLine();
						selectedContact.setEmail(newEmail);
						break;
					} catch (InvalidEmailException e) {
						System.out.println(e.getMessage());
					}
				}	
			case 3:
				selectedContact.getPhoneNumber();
				while (true) {
					try {
						System.out.println("Enter new phone number.");
						String newPhoneNumber = input.nextLine();
						selectedContact.setPhoneNumber(newPhoneNumber);
						break;
					} catch (InvalidPhoneNumberException e) {
						System.out.println(e.getMessage());
					}
				}
			case 4:
				break;
		}
	
	}
	
	public static void deleteAContact(Scanner input) {
		System.out.println("Which contact would you like to delete? Enter its index.");
		int contactToDelete = input.nextInt();
		
		ContactProject9 selectedContact2 = contactsInAddressBook.get(contactToDelete);
		System.out.println("Are you sure you want to delete the contact below?\n" + selectedContact2.getStringToPrint());
		System.out.println("1) Yes");
		System.out.println("2) No");
		int deleteConfirmation = input.nextInt();
		input.nextLine();
		
		if (deleteConfirmation == 1) {
			contactsInAddressBook.remove(contactToDelete);
		}		
	}
	
	public static void displayAllContacts() {
		System.out.println("Here are your contacts: ");
		for (ContactProject9 c:contactsInAddressBook) {
			System.out.println("\n" + c.getStringToPrint() + "\n");
		}	
	}
	
}

