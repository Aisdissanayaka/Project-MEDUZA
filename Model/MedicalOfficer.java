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
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MedicalOfficer extends user{
    
    private String staffID,email,dateJoined,specialityArea,options;

    

       //Getters
    public String getStaffID() {
        return staffID;
    }
    public String getEmail() {
        return email;
    }
    public String getDateJoined() {
        return dateJoined;
    }

    public String getSpecialityArea() {
        return specialityArea;
    }
     public String getOptions() {
        return options;
    }
    
    //Setters
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public void setSpecialityArea(String specialityArea) {
        this.specialityArea = specialityArea;
    }
       public void setOptions(String options) {
        this.options = options;
    }
    
    
    
    
    public void signup(ActionEvent event) throws FileNotFoundException{
     
        File file = new File("user data\\medical officer\\data\\"+getStaffID()+".txt");
           PrintWriter print = new PrintWriter(new FileOutputStream(file,true));
           print.append(getFName()+"\n"+getLName()
                   +"\n"+getAddress()+"\n"+getPhoneNumber()+"\n"+getDOB()+"\n"+getStaffID()
                   +"\n"+getEmail()+"\n"+getDateJoined()+"\n" +getGender()+"\n"+getSpecialityArea()+"\n");
          
           print.close();
    
    }
    
     @FXML
      public static ArrayList<MedicalOfficer> viewMO() throws IOException{
        
        ArrayList<MedicalOfficer> moArrayList = new ArrayList<>();
        
        
        File moFile = new File("user data//database//medicalOfficers.txt");
        FileReader fr = new FileReader(moFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
      
        
        while ((currentLine = br.readLine())!=null){
            String[] moData = currentLine.split(",");
            MedicalOfficer moLine = new MedicalOfficer();
            moLine.setStaffID(moData[0]);
            moLine.setFName(moData[1]);
            moLine.setLName(moData[2]);
            moLine.setGender(moData[3]);
            moLine.setDOB(moData[4]);
            moLine.setAddress(moData[5]);
            moLine.setPhoneNumber(moData[6]);
            moLine.setSpecialityArea(moData[7]);
            moLine.setEmail(moData[8]);
            moLine.setPassword(moData[9]);
            moLine.setOptions(moData[10]);
           
        moArrayList.add(moLine);
     
        }
        
        fr.close();
        br.close();
        return moArrayList;
        
    }
      
}
