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
public class Postal {
     private String From,To,Address,RefferenceNum,Note,Date;
    
    
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
                
    
}}

    

