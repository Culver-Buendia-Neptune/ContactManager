import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class Main extends Input {
//Scanner scanner = new Scanner(System.in);
//    public String getString() {
//        return this.scanner.nextLine();
//    }

    public static void addContact(HashMap<String, ArrayList<ContactsManager>> list, Input in) {
        String name = in.getString("Please enter the name of the Person:");
        int phoneNumber = in.getInt("Please enter Phone Number:");
    }


    public static void runApp(HashMap<String, ArrayList<ContactsManager>> list, Input in){
        System.out.println("Main Menu");
        boolean run = true;
        while (run) {
            System.out.println("Please make your selection:");
            System.out.println("1. Add Contact");
            System.out.println("2. View List");
            System.out.println("3. Quit");
            int userResp = in.getInt("Please enter either 1, 2, or 3 into your terminal.", 1, 3);
            in.getString();
            switch (userResp) {
                case 1:
                    addContact(list, in);
                    System.out.println("Returning to menu...\n");
                    break;
//                case 2:
//                    printList(list);
//                    System.out.println("Returning to menu...\n");
//                    break;
                default:
                    System.out.println("Are you sure you want to quit?");
                    if (in.yesNo()) {
                        System.out.println("Thank you for choosing Happy Market.\nWe'll see you soon!");
                        run = false;
                    } else {
                        System.out.println("Returning to menu...\n");
                    }
            }
        }

    }

    public static void main(String[] args) {
        // Building the grocery list and menu of categories
        HashMap<String, ArrayList<ContactsManager>> list = new HashMap<>();
        runApp(list, new Input());

        List<String> romanEmpresses = Arrays.asList("Livia", "Agrippina", "Messaline", "Julia Domna");
        Path toOurDataPlace = Paths.get("src/contacts.txt");

        try {
            Files.write(toOurDataPlace, romanEmpresses);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}


//Files.write(
//        Paths.get("src", "contacts.txt"),
//        Arrays.asList("eggs"), // list with one item
//        StandardOpenOption.APPEND
//        );