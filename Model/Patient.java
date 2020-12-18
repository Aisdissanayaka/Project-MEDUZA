/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javafx.event.ActionEvent;

/**
 *
 * @author ASUS
 */
public class Patient extends user {
    
    private String allergies,bloodGroup,nic;

    //getters
    public String getAllergies() {
        return allergies;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getNic() {
        return nic;
    }
    
    //setters

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
    
    public void signup(ActionEvent event) throws FileNotFoundException{
        
        File file = new File("user data\\patient\\data\\"+getNic()+".txt");    
        PrintWriter printer = new PrintWriter(new FileOutputStream(file,true));  
        printer.append(getFName()+" "  + getLName()+ "\n" +  getAddress()+"\n"+ getNic()+"\n"+ getBloodGroup() + "\n"+
                 getDOB()+ "\n"+ getGender() +"\n" +getPhoneNumber() +"\n"+ getAllergies());
             printer.close();
    }
    
    
    
}
