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

/**
 *
 * @author ASUS
 */
public class Postal {
     private String From,To,Address,RefferenceNum,Note,Date,Document,Options;
    
    
//Getters
    
    public String getFrom() {
        return From;
    }
    public String getTo() {
        return To;
    }
    public String getAddress() {
        return Address;
    }
     public String getRefferenceNum() {
        return RefferenceNum;
    }
     public String getDate() {
        return Date;
    }
    public String getNote() {
        return Note;
    }
      public String getDocument() {
        return Document;
    }
        public String getOptions() {
        return Options;
    }

  //setters
    public void setFrom(String From) {
        this.From = From;
    }

    public void setTo(String To) {
        this.To = To;
    }
     public void setAddress(String Address) {
        this.Address = Address;
    }
    public void setRefferenceNum(String RefferenceNum) {
        this.RefferenceNum = RefferenceNum;
    }
    public void setDate(String Date) {
        this.Date = Date;
    }
     public void setNote(String Note) {
        this.Note = Note;
    }
      public void setDocument(String document) {
        this.Document = document;
    }
       public void setOptions(String options) {
        this.Options = options;
    }
    

//Receptionist Add Received Post  Submit button  Action Method Call
    public void AddReceivedPost(ActionEvent event)throws FileNotFoundException{
                File file = new File ("user data\\receptionist\\postal\\recieved\\"+getRefferenceNum()+".txt");
                PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
                print.append(getFrom()+"\n"+getRefferenceNum()+"\n"+getAddress()+"\n"+getNote()+"\n"+getDate()+"\n"+getTo()+"\n");
                print.close();
        
        
     }
    //Receptionist Add Dispatched Post  Submit button Action Method Call
     public void AddDispatchedPost(ActionEvent event)throws FileNotFoundException{
                File file = new File ("user data\\receptionist\\postal\\dispatched post\\"+getRefferenceNum()+".txt");
                PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
                print.append(getTo()+"\n"+getRefferenceNum()+"\n"+getAddress()+"\n"+getNote()+"\n"+getDate()+"\n"+getFrom()+"\n");
                print.close();
     }
    @FXML
      public static ArrayList<Postal> viewReceivedPostal() throws IOException{
        
        ArrayList<Postal> receivedPostalArrayList = new ArrayList<>();
        
        
        File appFile = new File("user data//database//recievedPostals.txt");
        FileReader fr = new FileReader(appFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
      
        
        while ((currentLine = br.readLine())!=null){
            String[] postalData = currentLine.split(",");
            //System.out.println(Arrays.toString(appData));
            Postal receivedPostalLine = new Postal();
            
           
            receivedPostalLine.setRefferenceNum(postalData[0]);
            receivedPostalLine.setFrom(postalData[1]);
            receivedPostalLine.setAddress(postalData[2]);
            receivedPostalLine.setNote(postalData[3]);
            receivedPostalLine.setDate(postalData[4]);
            receivedPostalLine.setTo(postalData[5]);
            receivedPostalLine.setDocument(postalData[6]);
            receivedPostalLine.setOptions(postalData[7]);
           
        receivedPostalArrayList.add(receivedPostalLine);
     
        }
        
        fr.close();
        br.close();
        return receivedPostalArrayList;
        
    }
      
      @FXML
      public static ArrayList<Postal> viewDispatchedPostal() throws IOException{
        
        ArrayList<Postal> dispatchedPostalArrayList = new ArrayList<>();
        
        
        File appFile = new File("user data//database//dispatchedPostals.txt");
        FileReader fr = new FileReader(appFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
      
        
        while ((currentLine = br.readLine())!=null){
            String[] postalData = currentLine.split(",");
            //System.out.println(Arrays.toString(appData));
            Postal dispatchedPostalLine = new Postal();
            
           
            dispatchedPostalLine.setRefferenceNum(postalData[0]);
            dispatchedPostalLine.setFrom(postalData[1]);
            dispatchedPostalLine.setAddress(postalData[2]);
            dispatchedPostalLine.setNote(postalData[3]);
            dispatchedPostalLine.setDate(postalData[4]);
            dispatchedPostalLine.setTo(postalData[5]);
            dispatchedPostalLine.setDocument(postalData[6]);
            dispatchedPostalLine.setOptions(postalData[7]);
           
        dispatchedPostalArrayList.add(dispatchedPostalLine);
     
        }
        
        fr.close();
        br.close();
        return dispatchedPostalArrayList;
        
    }



}

    

