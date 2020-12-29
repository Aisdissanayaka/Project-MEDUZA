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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class MedicalOfficer extends user{
    
    private String staffID,email,dateJoined,specialityArea,options;

    

       //Getters
    public String getStaffID() {
        return staffID;
    }
    public String getEmail() {
        return email;
    }
    public String getDateJoined() {
        return dateJoined;
    }

    public String getSpecialityArea() {
        return specialityArea;
    }
     public String getOptions() {
        return options;
    }
    
    //Setters
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public void setSpecialityArea(String specialityArea) {
        this.specialityArea = specialityArea;
    }
       public void setOptions(String options) {
        this.options = options;
    }
    
    
    
    
    public void signup(ActionEvent event) throws FileNotFoundException, IOException{
     try{
        File file = new File("user data\\medical officer\\data\\"+getStaffID()+".txt");
           PrintWriter print = new PrintWriter(new FileOutputStream(file,true));
           print.append(getFName()+"\n"+getLName()
                   +"\n"+getAddress()+"\n"+getPhoneNumber()+"\n"+getDOB()+"\n"+getStaffID()
                   +"\n"+getEmail()+"\n"+getDateJoined()+"\n" +getGender()+"\n"+getSpecialityArea()+"\n");
          
           print.close();
           
        File file2 = new File("user data\\reference\\Speciality Area\\"+getSpecialityArea()+".txt");
           PrintWriter print2 = new PrintWriter(new FileOutputStream(file2,true));
           print2.append("Dr. "+getFName()+" "+getLName()+"\n");
          
           print2.close();
     }catch(Exception e){
         
     }
     try{
         //write a database file in data
         FileWriter fw = new FileWriter("user data//database//medicalOfficers.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.print(getStaffID()+","  + getSpecialityArea()+ "," +  getFName()+","+ getLName()+","+ getGender() + ","+
              getDOB()+ ","+ getAddress() +"," +getPhoneNumber() +","+getEmail()+","+getDateJoined() +"\n");
         pw.close();
         }catch(FileNotFoundException  e){}
     
     //Write credentials file of patients
        try{
         
         FileWriter fw = new FileWriter("user data\\medical officer\\credentials\\medicalofficerlogin.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.write(getStaffID()+","+getStaffID()+"\n");
         pw.close();
         }catch(FileNotFoundException  e){} 
    }
    
     @FXML
      public static ArrayList<MedicalOfficer> viewMO() throws IOException{
        
        ArrayList<MedicalOfficer> moArrayList = new ArrayList<>();
        
        
        File moFile = new File("user data//database//medicalOfficers.txt");
        FileReader fr = new FileReader(moFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
      
        
        while ((currentLine = br.readLine())!=null){
            String[] moData = currentLine.split(",");
            MedicalOfficer moLine = new MedicalOfficer();
            moLine.setStaffID(moData[0]);
            moLine.setSpecialityArea(moData[1]);
            moLine.setFName(moData[2]);
            moLine.setLName(moData[3]);
            moLine.setGender(moData[4]);
            moLine.setDOB(moData[5]);
            moLine.setAddress(moData[6]);
            moLine.setPhoneNumber(moData[7]);
            moLine.setEmail(moData[8]);
            moLine.setDateJoined(moData[9]);
           // moLine.setOptions(moData[10]);
           
        moArrayList.add(moLine);
     
        }
        
        fr.close();
        br.close();
        return moArrayList;
        
    }
      
      
      
     // medical offier edit methode
     private Scanner x;
     public void editMO(String filepath,String tempFile){
       File oldFile = new File(filepath);//create object in oldfile
       File newFile = new File (tempFile);//create object in newfile
        //idintyfiy each component
        String stid;String specarea;String fnam;String lnam;String usergender;String DOB;String Address;String phoneNO;String emailadd;String dateofjoi;
        try {
            FileWriter fw = new FileWriter(tempFile,true); 
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner (new File (filepath));  // scan file
            x.useDelimiter("[,\n]"); // set delimiter
            while(x.hasNext()){
              //assign value in variable in tempary  
                stid=x.next();
                specarea=x.next();
                fnam=x.next();
                lnam=x.next();
                usergender=x.next();
                DOB=x.next();
                Address=x.next();
                phoneNO=x.next();
                emailadd=x.next();
                dateofjoi=x.next();
                
                if(stid.equals(getStaffID())){  //compare idnumber
                    pw.print(getStaffID()+","  + getSpecialityArea()+ "," +  getFName()+","+ getLName()+","+ getGender() + ","+getDOB()+ ","+ getAddress() +"," +getPhoneNumber() +","+getEmail()+","+getDateJoined() +"\n"); //is it true update new component
                    
                }else{
                    pw.print(stid+","+specarea+","+fnam+","+lnam+","+usergender+","+DOB+","+Address+","+phoneNO+","+emailadd+","+dateofjoi+"\n"); //else write other data in new file
                }
                    
            } 
            x.close();   //scanner close
            pw.flush();  //print writer flush
            pw.close();   //print writer close
            oldFile.delete();   // file deleted
            File dump = new File (filepath); 
            newFile.renameTo(dump);  // new file rename old file name
            
            
            
       try{ //edit patient detail in data file
        File file = new File("user data\\medical officer\\data\\"+getStaffID()+".txt");  
        file.delete();
        PrintWriter printer = new PrintWriter(new FileOutputStream(file)); 
        
         printer.append(getFName()+"\n"+getLName()
                   +"\n"+getAddress()+"\n"+getPhoneNumber()+"\n"+getDOB()+"\n"+getStaffID()
                   +"\n"+getEmail()+"\n"+getDateJoined()+"\n" +getGender()+"\n"+getSpecialityArea()+"\n");
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
