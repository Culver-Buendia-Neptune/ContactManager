import java.util.ArrayList;
import java.util.List;

public class ContactsManager {
    private String name;
    private int phoneNumber;


    public ContactsManager(){}


    public ContactsManager(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int num) {
        this.phoneNumber = num;
    }

}