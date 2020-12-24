/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.RecAddAppointmentWindowController;
import static Control.RecAppointmentWindowController.userIDAppointment;
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
import java.util.Scanner;
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
    
    // add oppointment method
    public void addAppointmentRec(ActionEvent event) throws FileNotFoundException, IOException{
        File file = new File ("user data\\appointment\\"+getUserID()+".txt");
        PrintWriter print = new PrintWriter(new FileOutputStream(file,true));
        print.print(getUserID()+","+getName()+","+getAppDate()+","+
                getAppTime()+","+getSymptoms()+","+getSpecArea()+","+"pending"+"option"+"\n");
        print.close();
        try{
         //database\appointment.txt  file write in all of data
         FileWriter fw = new FileWriter("user data\\database\\pendingappointment.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.print(getUserID()+","+getName()+","+getAppDate()+","+getAppTime()+","+getSymptoms()+","+getSpecArea()+","+"pending"+","+"option"+"\n");
         pw.close();
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setContentText("Appointment was saved..!");  //display data saved message
         alert.show();
         
         }catch(FileNotFoundException e){}
        
    }
    
      @FXML
      public static ArrayList<Appointment> viewAppointment(String filepath) throws IOException{
        
        ArrayList<Appointment> appointmentArrayList = new ArrayList<>();
        
        
        File appFile = new File(filepath);
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
    //import Scanner
    private Scanner x;
    // delete appointment method
   public void deleteAppointment(String filepath,String tempFile){
        File oldFile = new File(filepath);//create object in oldfile
        File newFile = new File (tempFile);//create object in newfile
        //idintyfiy each component
        String id = "" ; String name = ""; String appdate =""; String apptime =""; String syp =""; String mo=""; String status ="";String op="";   
        try {
            FileWriter fw = new FileWriter(tempFile,true); 
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner (new File (filepath));  // scan file
            x.useDelimiter("[,\n]"); // set delimiter
            
            while(x.hasNext()){
                //assign value in variable in tempary
                id=x.next();
                name=x.next();
                appdate=x.next();
                apptime=x.next();
                syp=x.next();
                mo=x.next();
                status=x.next();
                op=x.next();
                if(id.equals(userIDAppointment)){  //compare idnumber
                    System.out.println("delete"+name+"'s appointment"); // is it true display message
                    
                }else{
                    pw.print(id+","+name+","+appdate+","+apptime+","+syp+","+mo+","+status+","+op+"\n"); //else write other data in new file
                }
                
            }
            x.close();   //scanner close
            pw.flush();  //print writer flush
            pw.close();   //print writer close
            oldFile.delete();   // file deleted
            File dump = new File (filepath); 
            newFile.renameTo(dump);  // new file rename old file name
            
            
       } catch (Exception e) {
       }
        
        
        
   }
   // Appointment approved method
   public void approveAppointment(String filepath,String approvefilepath){
        File pendingFile = new File(filepath);
        File approveFile = new File (approvefilepath);
        //idintyfiy each component
        String id = "" ; String name = ""; String appdate =""; String apptime =""; String syp =""; String mo=""; String status ="";String op="";   
        try {
            FileWriter fw = new FileWriter(approvefilepath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner (new File (filepath)); // scan file 
            x.useDelimiter("[,\n]"); // set delimiter
            
            while(x.hasNext()){
                //assign value in variable in tempary
                id=x.next();
                name=x.next();
                appdate=x.next();
                apptime=x.next();
                syp=x.next();
                mo=x.next();
                status=x.next();
                op=x.next();
                if(id.equals(userIDAppointment)){
                    // userid are equal display message
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("You approved "+name.toUpperCase()+"'s appointment..!");
                    alert.show();
                    //write new file approved appointment in approvedappointment file
                    pw.print(id+","+name+","+appdate+","+apptime+","+syp+","+mo+","+"approved"+","+op+"\n");
                }
                
            }
            x.close();  //scanner close
            pw.flush(); //print writer fush
            pw.close();  //print writer close
             
            
            
       } catch (Exception e) {
       }
       
   }
 
   // Appointment completed method
   public void completedAppointment(String filepath,String completefilepath){
        File approvedFile = new File(filepath);
        File completeFile = new File (completefilepath);
        //idintyfiy each component
        String id = "" ; String name = ""; String appdate =""; String apptime =""; String syp =""; String mo=""; String status ="";String op="";   
        try {
            FileWriter fw = new FileWriter(completefilepath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner (new File (filepath)); // scan file 
            x.useDelimiter("[,\n]"); // set delimiter
            
            while(x.hasNext()){
                //assign value in variable in tempary
                id=x.next();
                name=x.next();
                appdate=x.next();
                apptime=x.next();
                syp=x.next();
                mo=x.next();
                status=x.next();
                op=x.next();
                if(id.equals(userIDAppointment)){
                    // userid are equal display message
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("You completed "+name.toUpperCase()+"'s appointment..!");
                    alert.show();
                    //write new file completed appointment in completed appointment file
                    pw.print(id+","+name+","+appdate+","+apptime+","+syp+","+mo+","+"completed"+","+op+"\n");
                }
                
            }
            x.close();  //scanner close
            pw.flush(); //print writer fush
            pw.close();  //print writer close
             
            
            
       } catch (Exception e) {
       }
       
   }
   
   // edit appointment method
   public void editAppointment(String filepath,String tempFile,String editname,String appDate,String appTime,String sypt,String mOfficer){
        File oldFile = new File(filepath);//create object in oldfile
        File newFile = new File (tempFile);//create object in newfile
        //idintyfiy each component
        String id = "" ; String name = ""; String appdate =""; String apptime =""; String syp =""; String mo=""; String status ="";String op="";   
        try {
            FileWriter fw = new FileWriter(tempFile,true); 
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner (new File (filepath));  // scan file
            x.useDelimiter("[,\n]"); // set delimiter
            
            while(x.hasNext()){
                //assign value in variable in tempary
                id=x.next();
                name=x.next();
                appdate=x.next();
                apptime=x.next();
                syp=x.next();
                mo=x.next();
                status=x.next();
                op=x.next();
                if(id.equals(userIDAppointment)){  //compare idnumber
                    pw.print(id+","+editname+","+appDate+","+appTime+","+sypt+","+mOfficer+","+status+","+op+"\n"); //is it true update new component
                    
                }else{
                    pw.print(id+","+name+","+appdate+","+apptime+","+syp+","+mo+","+status+","+op+"\n"); //else write other data in new file
                }
                
            }
            x.close();   //scanner close
            pw.flush();  //print writer flush
            pw.close();   //print writer close
            oldFile.delete();   // file deleted
            File dump = new File (filepath); 
            newFile.renameTo(dump);  // new file rename old file name
            
            
       } catch (Exception e) {
        Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("Go back and try agin..!");
        alert.show();
        System.out.println(e);  
       }
        
        
        
   }
   
   
   
   
    
}


