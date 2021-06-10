
import java.util.*;

public class Main{

    private static Object ContactsManager;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ContactsManager Contact1 = new ContactsManager ("Irvin Buendia");
        ContactsManager Contact2 = new ContactsManager ("David Culver");
        ContactsManager Contact3 = new ContactsManager ("David Stephens");


        Contact1.addPhoneNumber(2101231234);
        Contact2.addPhoneNumber(2103214321);
        Contact3.addPhoneNumber(2102462468);


        System.out.println(Contact1.getName());
        System.out.println(Contact1.getNumber());


        System.out.println("Enter a name");
        String userName = sc.nextLine();
        System.out.println("Enter Phone Number");
        long userNumber = sc.nextLong();
        ContactsManager userName = new ContactsManager(userName);

        System.out.println(ContactsManager);
        


    }

}