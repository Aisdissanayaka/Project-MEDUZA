/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Control.RecAppointmentWindowController.userIDAppointment;
import static Control.RecPostalDispatchedWindowController.datePostal;
import static Control.RecPostalWindowController.refNumber;
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
import java.util.Scanner;
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
     try{           
    File file = new File ("user data\\receptionist\\postal\\received postal\\"+getRefferenceNum()+".txt");
    PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
    print.append(getRefferenceNum()+","+getFrom()+","+getAddress()+","+getNote()+","+getDate()+","+getTo()+"\n");
    print.close();
    
    //write database file
    FileWriter fw = new FileWriter("user data\\database\\recievedPostals.txt",true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);
    pw.print(getRefferenceNum()+","+getFrom()+","+getAddress()+","+getNote()+","+getDate()+","+getTo()+"\n");
    pw.close();
     }catch(Exception e){
         
     }         
        
     }
    //Receptionist Add Dispatched Post  Submit button Action Method Call
     public void AddDispatchedPost(ActionEvent event)throws FileNotFoundException{
     try{    
     File file = new File ("user data\\receptionist\\postal\\dispatched post\\"+getRefferenceNum()+".txt");
     PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
     print.append(getRefferenceNum()+","+getTo()+","+getAddress()+","+getNote()+","+getDate()+","+getFrom()+"\n");
     print.close();
     
     //write database file
     FileWriter fw = new FileWriter("user data\\database\\dispatchedPostals.txt",true);
     BufferedWriter bw = new BufferedWriter(fw);
     PrintWriter pw = new PrintWriter(bw);
     pw.print(getRefferenceNum()+","+getTo()+","+getAddress()+","+getNote()+","+getDate()+","+getFrom()+"\n");
     pw.close();
     
     }catch(Exception e){
         
     }
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
            //receivedPostalLine.setDocument(postalData[6]);
           // receivedPostalLine.setOptions(postalData[7]);
           
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
            //dispatchedPostalLine.setDocument(postalData[6]);
           // dispatchedPostalLine.setOptions(postalData[7]);
           
        dispatchedPostalArrayList.add(dispatchedPostalLine);
     
        }
        
        fr.close();
        br.close();
        return dispatchedPostalArrayList;
        
    }
      private Scanner x;
      public void deletePostal(String filepath,String tempFile){
        File oldFile = new File(filepath);//create object in oldfile
        File newFile = new File (tempFile);//create object in newfile
        //idintyfiy each component
        String ref = "" ; String from = ""; String fromadd =""; String note =""; String date =""; String to="";  
        try {
            FileWriter fw = new FileWriter(tempFile,true); 
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner (new File (filepath));  // scan file
            x.useDelimiter("[,\n]"); // set delimiter
            
            while(x.hasNext()){
                //assign value in variable in tempary
                ref=x.next();
                from=x.next();
                fromadd=x.next();
                note=x.next();
                date=x.next();
                to=x.next();
                
                if(ref.equals(refNumber) && date.equals(datePostal)){  //compare idnumber
                    System.out.println("You deleted "+ref+"postal"); // is it true display message
                    
                }else{
                    pw.print(ref+","+from+","+fromadd+","+note+","+date+","+to+"\n"); //else write other data in new file
                    
                
                }
                
            }
            
            x.close();   //scanner close
            pw.flush();  //print writer flush
            pw.close();   //print writer close
            if(oldFile.delete()); 
            File dump = new File (filepath); 
            if(newFile.renameTo(dump));  // new file rename old file name
            
            
            
       } catch (Exception e) {
       }
         
          
      }



}

    

