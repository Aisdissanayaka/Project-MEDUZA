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

public class Receptionist extends user {
    
    private String series,staffID,staffEmail,joinDate;
    
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
    
    
    public void signup(ActionEvent event) throws FileNotFoundException{
        
        File file = new File("user data\\receptionist\\data\\"+getStaffID()+".txt");
           PrintWriter printer = new PrintWriter(new FileOutputStream(file,true));
          
           printer.append(getFName()+" "+getLName()
                   +"\n"+""+getAddress()+"\n"+""+getPhoneNumber()+"\n"+""+getDOB().toString()+"\n"+""+getSeries()+"\n"+""+getStaffID()
                   +"\n"+""+getStaffEmail()+"\n"+""+getJoinDate().toString()+"\n");
           printer.close();
          
        
    }
    
}
