/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.RecAddAppointmentWindowController;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;


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
    
    
    public void addAppointmentRec(ActionEvent event) throws FileNotFoundException, IOException{
        File file = new File ("user data\\appointment\\"+getUserID()+".txt");
        PrintWriter print = new PrintWriter(new FileOutputStream(file,true));
        print.append(getUserID()+"\n"+getName()+"\n"+getAppDate()+"\n"+
                getAppTime()+"\n"+getSpecArea()+"\n"+getSymptoms()+"\n");
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
         
         }catch(FileNotFoundException  e){}
        
    }
    
    
   @FXML
      public ArrayList<RecAddAppointmentWindowController> viewAppointment(ActionEvent event) throws FileNotFoundException, IOException{
        
        ArrayList<RecAddAppointmentWindowController> appointmentArrayList = new ArrayList<>();
        
        
        File appFile = new File("user data//appointment//007.txt");
        FileReader fr = new FileReader(appFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
        while ((currentLine = br.readLine())!=null){
            RecAddAppointmentWindowController appoinmentLine = new RecAddAppointmentWindowController();
            
            String[] appData = currentLine.split(",");
            appoinmentLine.setName(appData[0]);
            appoinmentLine.setName(appData[1]);
            appoinmentLine.setName(appData[2]);
            appoinmentLine.setName(appData[3]);
            appoinmentLine.setName(appData[4]);
            appoinmentLine.setName(appData[5]);
            
        
           
        appointmentArrayList.add(appoinmentLine);
        
        System.out.println(appointmentArrayList.toString());

        }
        
        fr.close();
        br.close();
        return appointmentArrayList;
        
    }
    
   
    
}
