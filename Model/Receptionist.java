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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Receptionist extends user {
    
    private String series,staffID,staffEmail,joinDate,options;
    
    //getters

    public String getSeries() {
        return series;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public String getJoinDate() {
        return joinDate;
    }
    public String getOptions() {
        return options;
    }
    
    //setters

    public void setSeries(String series) {
        this.series = series;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
      public void setOptions(String options) {
        this.options = options;
    }
    
    
    public void signup(ActionEvent event) throws FileNotFoundException{
        
        File file = new File("user data\\receptionist\\data\\"+getStaffID()+".txt");
           PrintWriter printer = new PrintWriter(new FileOutputStream(file,true));
          
           printer.append(getFName()+" "+getLName()
                   +"\n"+""+getAddress()+"\n"+""+getPhoneNumber()+"\n"+""+getDOB().toString()+"\n"+""+getSeries()+"\n"+""+getStaffID()
                   +"\n"+""+getStaffEmail()+"\n"+""+getJoinDate().toString()+"\n");
           printer.close();
          
        
    }
    
    @FXML
      public static ArrayList<Receptionist> viewReceptionist() throws IOException{
        
        ArrayList<Receptionist> receptionistArrayList = new ArrayList<>();
        
        
        File recFile = new File("user data//database//receptionists.txt");
        FileReader fr = new FileReader(recFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
      
        
        while ((currentLine = br.readLine())!=null){
            String[] recData = currentLine.split(",");
            Receptionist receptionistLine = new Receptionist();
            receptionistLine.setStaffID(recData[0]);
            receptionistLine.setFName(recData[1]);
            receptionistLine.setLName(recData[2]);
            receptionistLine.setGender(recData[3]);
            receptionistLine.setDOB(recData[4]);
            receptionistLine.setAddress(recData[5]);
            receptionistLine.setPhoneNumber(recData[6]);
            receptionistLine.setStaffEmail(recData[7]);
            receptionistLine.setPassword(recData[8]);
            receptionistLine.setOptions(recData[9]);
           
        receptionistArrayList.add(receptionistLine);
     
        }
        
        fr.close();
        br.close();
        return receptionistArrayList;
        
    }
    
}