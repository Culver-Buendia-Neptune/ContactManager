import java.util.ArrayList;
import java.util.List;

public class ContactsManager {
    private String name;
    private List<Integer> phoneNumber = new ArrayList<>();

//constructor
    public ContactsManager(){};

    //method
    public ContactsManager(String name){
        this.name = name;
    }

    //setters
    public String getName(){
        return this.name;
    }

    public List<Integer> getNumber() {
        return phoneNumber;
    }

    //add the phone number to the phone property
    public void addPhoneNumber(int num){
        this.phoneNumber.add(num);
    }




}