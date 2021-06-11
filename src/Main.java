import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class Main extends Input {

    public static void viewContacts(){
        Path toOurDataPlace = Paths.get("src/data");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(toOurDataFile);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        for (String line : currentList){
            System.out.println(line);
        }
    }

    public static void addContact(HashMap<String, ArrayList<ContactsManager>> list, Input in) {
        Path toOurDataPlace = Paths.get("src/data");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");

        List<String> Contacts = new ArrayList<>();
        String name = in.getString("Please enter the name of the Person:");
//        Contacts.add(name);
        long phoneNumber = in.getInt("Please enter Phone Number:");
        long i = phoneNumber;
        String s=Long.toString(i).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");

        String newContact = name + " | " + s;
        Contacts.add(newContact);
        try {
            Files.write(toOurDataFile, Contacts, StandardOpenOption.APPEND);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void deleteContact(HashMap<String, ArrayList<ContactsManager>> list, Input in) {

        Path toOurDataPlace = Paths.get("src/data");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");

        String name = in.getString("What Contact would you like to delete? (Enter First and Last name)");

        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(toOurDataFile);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        Iterator<String> listIterator = currentList.iterator();
        while(listIterator.hasNext()){
            String contact = listIterator.next();
            if (contact.contains(name)){
                listIterator.remove();
            }
        }
        try {
            Files.write(toOurDataFile, currentList);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void searchByName(HashMap<String, ArrayList<ContactsManager>> list, Input in) {

        Path toOurDataPlace = Paths.get("src/data");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");

        String name = in.getString("What Contact would you like view?");

        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(toOurDataFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Iterator<String> listIterator = currentList.iterator();
        while (listIterator.hasNext()) {
            String empress = listIterator.next();
            if (empress.contains(name)) {
                System.out.println(empress);
            }
        }
    }


    public static void runApp(HashMap<String, ArrayList<ContactsManager>> list, Input in){
        System.out.println("Main Menu");
        boolean run = true;
        while (run) {
            System.out.println("Please make your selection:");
            System.out.println("1. View Contacts");
            System.out.println("2. Add a new contact");
            System.out.println("3. Search by contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Quit");
            int userResp = in.getInt("Please enter either 1, 2, or 3 into your terminal.", 1, 5);
            in.getString();
            switch (userResp) {
                case 1:
                    viewContacts();
                    System.out.println("Returning to menu...\n");
                    break;
                case 2:
                    addContact(list, in);
                    System.out.println("Returning to menu...\n");
                    break;
                case 3:
                    searchByName(list, in);
                    System.out.println("Returning to menu...\n");
                    break;
                case 4:
                    deleteContact(list, in);
                    System.out.println("Returning to menu...\n");
                    break;
                default:
                    System.out.println("Are you sure you want to quit?");
                    if (in.yesNo()) {
                        System.out.println("Goodbye");
                        run = false;
                    } else {
                        System.out.println("Returning to menu...\n");
                    }
            }
        }

    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<ContactsManager>> list = new HashMap<>();
        runApp(list, new Input());
    }
}
