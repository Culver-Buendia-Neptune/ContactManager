public class Main {
    public static void main(String[] args) {
        // Create the ContactsManager object
        ContactsManager myContactsManager = new ContactsManager();

        // Create a new Contact object for Olivia
        Contact contact1 = new Contact();
        contact1.name = "Olivia";
        contact1.phoneNumber = "888-878-9790";
        myContactsManager.addContact(contact1);

        // Create a new Contact object for Omid
        Contact contact2 = new Contact();
        contact2.name = "Omid";
        contact2.phoneNumber = "888-777-5589";
        myContactsManager.addContact(contact2);

        // Create a new Contact object for Beth
        Contact contact3 = new Contact();
        contact3.name = "Beth";
        contact3.phoneNumber = "444-777-1323";
        myContactsManager.addContact(contact3);

        // Create a new Contact object for Daniel
        Contact contact4 = new Contact();
        contact4.name = "Daniel";
        contact4.phoneNumber = "818-266-5523";
        myContactsManager.addContact(contact4);

        // Search for Omid and print his phone number to screen
        Contact result = myContactsManager.searchContact("Beth");
        System.out.println(result.name + ": " + result.phoneNumber);


        System.out.println(myContactsManager);

    }
}
