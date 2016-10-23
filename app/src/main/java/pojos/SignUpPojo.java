package pojos;

import java.io.Serializable;

/**
 * Created by Ben on 10/22/16.
 */

public class SignUpPojo implements Serializable{
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phoneNumber;

    private int confirmation;

    public SignUpPojo(String firstName,String lastName,String username,String password, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setUserName(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setConfirmation(int confirmation){
        this.confirmation = confirmation;
    }
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getPhoneNumber(String phoneNumber){
        return phoneNumber;
    }
    public int getConfirmation(int confirmation){
        return confirmation;
    }



}

