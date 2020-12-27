/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import static Control.RecComplaintsWindowController.complaintID;
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
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

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
    
   // delete Complain method
     private Scanner x;
     public void deleteComplaint(String filepath,String tempFile){
        File oldFile = new File(filepath);//create object in oldfile
        File newFile = new File (tempFile);//create object in newfile
        //idintyfiy each component
        String id = "" ; String type = ""; String name =""; String phoneno =""; String date =""; String description=""; String act ="";String note;
        try {
            FileWriter fw = new FileWriter(tempFile,true); 
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner (new File (filepath));  // scan file
            x.useDelimiter("[,\n]"); // set delimiter
            
            while(x.hasNext()){
                //assign value in variable in tempary
                id=x.next();
                type=x.next();
                name=x.next();
                phoneno=x.next();
                date=x.next();
                description=x.next();
                act=x.next();
                note=x.next();
                
                if(id.equals(complaintID)){  //compare idnumber
                    System.out.println("delete"+name+"'s visitor"); // is it true display message
                    
                }else{
                    pw.print(id+","+type+","+name+","+phoneno+","+date+","+description+","+act+","+note+"\n"); //else write other data in new file
                }
                
            }
            x.close();   //scanner close
            pw.flush();  //print writer flush
            pw.close();   //print writer close
            oldFile.delete();   // file deleted
            File dump = new File (filepath); 
            newFile.renameTo(dump);  // new file rename old file name
             File file = new File("user data\\complaint\\"+ complaintID+".txt");  
             file.delete();
            
       } catch (Exception e) {
       }
          
    
}
            
    
    public void addComplaint() throws FileNotFoundException, IOException{
        try{
       Random randomObj = new Random();
        String  randomNumber = Integer.toString( randomObj.nextInt(1000000)+100000);
         FileWriter fw1 = new FileWriter("user data\\complaint\\data\\"+ primaryKey+".txt",true);
         BufferedWriter bw1 = new BufferedWriter(fw1);
         PrintWriter pw1 = new PrintWriter(bw1);
         pw1.append(randomNumber+","  + getType()+","  + getName()+ "," +  
                getPhoneNo()+","+getDate()+","+getDescription()+","+"pending" + ","+
                    getNote()+ "\n");
         pw1.close();
        
         //database\Complaint.txt  file write in all of data
         FileWriter fw = new FileWriter("user data\\database\\complaints.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.print(randomNumber+","+getType()+","+getName()+","+getPhoneNo()+","+getDate()+","+getDescription()+","+"pending"+","+getNote()+"\n");
         pw.close();
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setContentText("Complaint  was added..!");  //display data saved message
         alert.show();
         
         }catch(FileNotFoundException e){}
           
        }
    
    
      @FXML
     public static ArrayList<Complaint> viewComplaint(String filePath) throws IOException{
        
        ArrayList<Complaint> complaintArrayList = new ArrayList<>();
        
        
        File appFile = new File(filePath);
        FileReader fr = new FileReader(appFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
      
        
        while ((currentLine = br.readLine())!=null){
            String[] comData = currentLine.split(",");
             //System.out.println(Arrays.toString(comData));
            Complaint complaintLine = new Complaint();
            
           
           
            complaintLine.setId(comData[0]);
            complaintLine.setType(comData[1]);
            complaintLine.setName(comData[2]);
            complaintLine.setPhoneNo(comData[3]);
            complaintLine.setDate(comData[4]);
            complaintLine.setDescription(comData[5]);
            complaintLine.setActionTaken(comData[6]);
            complaintLine.setNote(comData[7]);
            //complaintLine.setDocument(comData[8]);
            //complaintLine.setOptions(comData[9]);
            
            complaintArrayList.add(complaintLine);
     
        }
        
        fr.close();
        br.close();
        return complaintArrayList;
        
    }

    
      
        
    }
    