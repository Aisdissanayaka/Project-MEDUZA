/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.RecAddAppointmentWindowController;
import static Control.UserLoginController.primaryKey;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;


public class Appointment {
    
    private String userID,name,appDate,appTime,specArea,symptoms,status,options;

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
     public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
    
    
    public void addAppointmentRec(ActionEvent event) throws FileNotFoundException, IOException{
        File file = new File ("user data\\appointment\\"+getUserID()+".txt");
        PrintWriter print = new PrintWriter(new FileOutputStream(file,true));
        print.append(getUserID()+","+getName()+","+getAppDate()+","+
                getAppTime()+","+getSpecArea()+","+getSymptoms()+"\n");
        print.close();
        
        try{
         //database\appointment.txt  file write in all of data
         FileWriter fw = new FileWriter("user data\\database\\pendingappointment.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.write(getUserID()+","+getName()+","+getAppDate()+","+getAppTime()+","+getSpecArea()+","+getSymptoms()+"\n");
         pw.close();
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setContentText("Appointment was saved..!");  //display data saved message
         alert.show();
         
         }catch(FileNotFoundException e){}
        
    }
    
    @FXML
      public static ArrayList<Appointment> viewAppointment() throws IOException{
        
        ArrayList<Appointment> appointmentArrayList = new ArrayList<>();
        
        
        File appFile = new File("user data//appointment//"+primaryKey+".txt");
        FileReader fr = new FileReader(appFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
      
        
        while ((currentLine = br.readLine())!=null){
            String[] appData = currentLine.split(",");
            //System.out.println(Arrays.toString(appData));
            Appointment appoinmentLine = new Appointment();
            
           
            appoinmentLine.setUserID(appData[0]);
            appoinmentLine.setName(appData[1]);
            appoinmentLine.setAppDate(appData[2]);
            appoinmentLine.setAppTime(appData[3]);
            appoinmentLine.setSymptoms(appData[4]);
            appoinmentLine.setSpecArea(appData[5]);
            appoinmentLine.setStatus(appData[6]);
            appoinmentLine.setOptions(appData[7]);
           
        appointmentArrayList.add(appoinmentLine);
     
        }
        
        fr.close();
        br.close();
        return appointmentArrayList;
        
    }
       
    
   
    
}
