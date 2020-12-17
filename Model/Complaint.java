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
import java.nio.file.Path;
import java.time.LocalDate;
import javafx.event.ActionEvent;

/**
 *
 * @author ASUS
 */
public class Complaint {
    
    private String name;
    private String actionTaken;
    private String type;
    private String phoneNo;
    private String description;
    private String note;
    private String date;
    private Path document;
    
    //Getters
    public String getName() {
        return name;
    }
    public String getActionTaken() {
        return actionTaken;
    }
    
    public String getType() {
        return type;
    }
    
    public String getPhoneNo() {
        return phoneNo;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getNote() {
        return note;
    }
    
    public String getDate() {
        return date;
    }
   
    
    
    //Setters
    
    public void setName(String name) {
        this.name = name;
    }
    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public void setNote(String note) {
        this.note = note;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
   
    
    
    public void addComplaint(ActionEvent event) throws FileNotFoundException{
        
       
         File file = new File("user data\\complaint\\data\\"+ LocalDate.now()+" " +getName()+".txt"); 
        PrintWriter printer = new PrintWriter(new FileOutputStream(file,true));  
        printer.append(getDate()+"\n"  + getType()+"\n"  + getName()+ "\n" +  
                getPhoneNo()+"\n"+ getDescription()+"\n"+ getActionTaken() + "\n"+
                         getNote()+ "\n");
             printer.close();
           
        }

    
      
        
    }
    
    
//