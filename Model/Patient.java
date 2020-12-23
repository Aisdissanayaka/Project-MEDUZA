/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author ASUS
 */
public class Patient extends user {
    
    private String allergies,bloodGroup,nic,options;

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
    public String getOptions() {
        return options;
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
    public void setOptions(String options) {
        this.options = options;
    }
    
    public void signup(ActionEvent event) throws FileNotFoundException{
        
        File file = new File("user data\\patient\\data\\"+getNic()+".txt");    
        PrintWriter printer = new PrintWriter(new FileOutputStream(file,true));  
        printer.append(getFName()+" "  + getLName()+ "\n" +  getAddress()+"\n"+ getNic()+"\n"+ getBloodGroup() + "\n"+
                 getDOB()+ "\n"+ getGender() +"\n" +getPhoneNumber() +"\n"+ getAllergies());
             printer.close();
    }
   @FXML
     public static ArrayList<Patient> viewPatient() throws IOException{
        
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        
        
        File patFile = new File("user data//database//patients.txt");
        FileReader fr = new FileReader(patFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
      
        
        while ((currentLine = br.readLine())!=null){
            String[] patData = currentLine.split(",");
            Patient patientLine = new Patient();
            
         
           
            patientLine.setNic(patData[0]);
            patientLine.setFName(patData[1]);
            patientLine.setLName(patData[2]);
            patientLine.setGender(patData[3]);
            patientLine.setDOB(patData[4]);
            patientLine.setPhoneNumber(patData[5]);
            patientLine.setAddress(patData[6]);
            patientLine.setBloodGroup(patData[7]);
            patientLine.setAllergies(patData[8]);
            patientLine.setPassword(patData[9]);
            patientLine.setOptions(patData[10]);
            
            patientArrayList.add(patientLine);
     
        }
        
        fr.close();
        br.close();
        return patientArrayList;
        
    }
    
    
}
