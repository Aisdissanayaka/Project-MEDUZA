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


public class Appointment {
    
    private String userID,name,appDate,appTime,specArea,symptoms;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getAppTime() {
        return appTime;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }

    public String getSpecArea() {
        return specArea;
    }

    public void setSpecArea(String specArea) {
        this.specArea = specArea;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
    
    
    public void addAppointmentRec(ActionEvent event) throws FileNotFoundException{
        File file = new File ("user data\\appointment\\"+getUserID()+".txt");
        PrintWriter print = new PrintWriter(new FileOutputStream(file,true));
        print.append(getUserID()+"\n"+getName()+"\n"+getAppDate()+"\n"+
                getAppTime()+"\n"+getSpecArea()+"\n"+getSymptoms()+"\n");
        print.close();
        
    }
    
   
    
}
