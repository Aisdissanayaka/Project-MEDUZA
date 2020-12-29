/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
import javafx.scene.control.Alert;

public class Receptionist extends user {
    
    private String series,staffID,staffEmail,joinDate;
    
    //getters

    public String getSeries() {
        return series;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public String getJoinDate() {
        return joinDate;
    }
   
    
    //setters

    public void setSeries(String series) {
        this.series = series;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
     
    
   
    
      public void signup() throws FileNotFoundException, IOException{
        try{
        File file = new File("user data\\receptionist\\data\\"+getStaffID()+".txt");    
        PrintWriter printer = new PrintWriter(new FileOutputStream(file));  
        printer.append(getFName()+"\n"  + getLName()+ "\n" +  getAddress()+"\n"+ getPhoneNumber()+"\n"+ getDOB() + "\n"+
              getGender()+ "\n"+ getStaffID() +"\n" +getStaffEmail() +"\n"+ getJoinDate());
             printer.close();}
        catch(Exception e){
            
        }
            //Write credentials file of patients
        try{
         
         FileWriter fw = new FileWriter("user data\\receptionist\\credentials\\receptionistlogin.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.write(getStaffID()+","+getStaffID()+"\n");
         pw.close();
         }catch(FileNotFoundException  e){} 
        
        try{
         //write a database file in data
         FileWriter fw = new FileWriter("user data//database//receptionists.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.print(getStaffID()+","  + getFName()+ "," +  getLName()+","+ getGender()+","+ getDOB() + ","+
              getAddress()+ ","+ getPhoneNumber() +","+ getJoinDate() +"," +getStaffEmail()+"\n");
         pw.close();
         }catch(FileNotFoundException  e){} 
             
    }
    
    @FXML
      public static ArrayList<Receptionist> viewReceptionist() throws IOException{
        
        ArrayList<Receptionist> receptionistArrayList = new ArrayList<>();
        
        
        File recFile = new File("user data//database//receptionists.txt");
        FileReader fr = new FileReader(recFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
      
        
        while ((currentLine = br.readLine())!=null){
            String[] recData = currentLine.split(",");
            Receptionist receptionistLine = new Receptionist();
            receptionistLine.setStaffID(recData[0]);
            receptionistLine.setFName(recData[1]);
            receptionistLine.setLName(recData[2]);
            receptionistLine.setGender(recData[3]);
            receptionistLine.setDOB(recData[4]);
            receptionistLine.setAddress(recData[5]);
            receptionistLine.setPhoneNumber(recData[6]);
            receptionistLine.setJoinDate(recData[7]);
            receptionistLine.setStaffEmail(recData[8]);
        
            receptionistArrayList.add(receptionistLine);
        }
      
          fr.close();
          br.close();
      
          
          return receptionistArrayList;
      }

        
        
        // patient edit methode
     private Scanner x;
     public void editPatient(String filepath,String tempFile,String staffid,String fname,String lname,String gender,String dob,String phone,String address,String joinedDate,String Email){
       File oldFile = new File(filepath);//create object in oldfile
       File newFile = new File (tempFile);//create object in newfile
        //idintyfiy each component
        String idno;String fullname;String lastname;String usergender;String birthday;String phoneNo;String Address;String dateJoined;String staffEmail;
        try {
            FileWriter fw = new FileWriter(tempFile,true); 
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner (new File (filepath));  // scan file
            x.useDelimiter("[,\n]"); // set delimiter
            while(x.hasNext()){
              //assign value in variable in tempary  
                idno=x.next();
                fullname=x.next();
                lastname=x.next();
                usergender=x.next();
                birthday=x.next();
                phoneNo=x.next();
                Address=x.next();
                dateJoined=x.next();
                staffEmail=x.next();
               
                
                if(idno.equals(staffid)){  //compare idnumber
                    pw.print(staffid+","+fname+","+lname+","+gender+","+dob+","+address+","+phone+","+joinedDate+","+Email+"\n"); //is it true update new component
                    
                }else{
                    pw.print(idno+","+fullname+","+lastname+","+usergender+","+birthday+","+phoneNo+","+Address+","+dateJoined+","+staffEmail+"\n"); //else write other data in new file
                }
                    
            } 
            x.close();   //scanner close
            pw.flush();  //print writer flush
            pw.close();   //print writer close
            oldFile.delete();   // file deleted
            File dump = new File (filepath); 
            newFile.renameTo(dump);  // new file rename old file name
            
            
            
       try{ //edit patient detail in data file
        File file = new File("user data\\receptionist\\data\\"+staffid+".txt");  
        file.delete();
        PrintWriter printer = new PrintWriter(new FileOutputStream(file)); 
        
         printer.append(fname+"\n"  + lname+ "\n" +  address+"\n"+ phone+"\n"+dob  + "\n"+
             "\n"+ gender +"\n" +staffid+"\n"+ Email+"\n"+ joinedDate);
         
        
         
      printer.close();
        }catch(FileNotFoundException e){
                 System.out.println("error");
        }
            
        }catch(Exception e){
         Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("Go back and try agin..!");
        alert.show();
        System.out.println(e);    
        }
        
       
        
     }
    
}