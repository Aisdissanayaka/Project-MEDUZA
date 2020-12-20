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
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author ASUS
 */
public class Complaint {
    
    private String id,name,actionTaken,type,phoneNo,description,note,date,
            options,document;
  
    
    
    
    //Getters
     public String getId() {
        return id;
    }
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
    
     public String getDocument() {
        return document;
    }
      public String getStatus() {
        return options;
    }
       public String getOptions() {
        return options;
    }
    
   
    
    
    //Setters
    
    public void setId(String colid) {
        this.id = colid;
    }
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
    public void setDocument(String document) {
        this.document = document;
    }
    public void setOptions(String options) {
        this.options = options;
    }
    
   
            
    
    public void addComplaint(ActionEvent event) throws FileNotFoundException{
        
       
         File file = new File("user data\\complaint\\data\\"+ LocalDate.now()+" " +getName()+".txt"); 
        PrintWriter printer = new PrintWriter(new FileOutputStream(file,true));  
        printer.append(getDate()+"\n"  + getType()+"\n"  + getName()+ "\n" +  
                getPhoneNo()+"\n"+ getDescription()+"\n"+ getActionTaken() + "\n"+
                         getNote()+ "\n");
             printer.close();
           
        }
    
    
      @FXML
     public static ArrayList<Complaint> viewComplaint() throws IOException{
        
        ArrayList<Complaint> complaintArrayList = new ArrayList<>();
        
        
        File appFile = new File("user data//database//complaints.txt");
        FileReader fr = new FileReader(appFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
      
        
        while ((currentLine = br.readLine())!=null){
            String[] comData = currentLine.split(",");
             System.out.println(Arrays.toString(comData));
            Complaint complaintLine = new Complaint();
            
           
           
            complaintLine.setId(comData[0]);
            complaintLine.setType(comData[1]);
            complaintLine.setName(comData[2]);
            complaintLine.setPhoneNo(comData[3]);
            complaintLine.setDate(comData[4]);
            complaintLine.setDescription(comData[5]);
            complaintLine.setActionTaken(comData[6]);
            complaintLine.setNote(comData[7]);
            complaintLine.setDocument(comData[8]);
            complaintLine.setOptions(comData[9]);
            
            complaintArrayList.add(complaintLine);
     
        }
        
        fr.close();
        br.close();
        return complaintArrayList;
        
    }

    
      
        
    }
    