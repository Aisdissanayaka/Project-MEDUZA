/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Control.RecPatientsWindowController.patientID;
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

/**
 *
 * @author ASUS
 */
public class Patient extends user {
    
    private String allergies,bloodGroup,nic,options;

    //getters
    public String getAllergies() {
        return allergies;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getNic() {
        return nic;
    }
    public String getOptions() {
        return options;
    }
    
    //setters

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
    public void setOptions(String options) {
        this.options = options;
    }
    
    
    
    
    //patient add methode
    
    public void signup(ActionEvent event) throws FileNotFoundException, IOException{
        try{
        File file = new File("user data\\patient\\data\\"+getNic()+".txt");    
        PrintWriter printer = new PrintWriter(new FileOutputStream(file));  
        printer.append(getFName()+"\n"  + getLName()+ "\n" +  getAddress()+"\n"+ getNic()+"\n"+ getBloodGroup() + "\n"+
              getDOB()+ "\n"+ getGender() +"\n" +getPhoneNumber() +"\n"+ getAllergies());
             printer.close();}
        catch(Exception e){
            
        }
            //Write credentials file of patients
        try{
         
         FileWriter fw = new FileWriter("user data\\patient\\credentials\\patientlogin.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.write(getNic()+","+getNic()+"\n");
         pw.close();
         }catch(FileNotFoundException  e){} 
        
        try{
         //write a database file in data
         FileWriter fw = new FileWriter("user data//database//patients.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.print(getNic()+","  + getFName()+ "," +  getLName()+","+ getGender()+","+ getDOB() + ","+
              getPhoneNumber()+ ","+ getAddress() +"," +getBloodGroup() +","+getAllergies() +","+"password"+","+"op"+"\n");
         pw.close();
         }catch(FileNotFoundException  e){} 
             
    }
   @FXML
     public static ArrayList<Patient> viewPatient() throws IOException{
        
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        
        
        File patFile = new File("user data//database//patients.txt");
        FileReader fr = new FileReader(patFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
      
        
        while ((currentLine = br.readLine())!=null){
            String[] patData = currentLine.split(",");
            Patient patientLine = new Patient();
            
         
           
            patientLine.setNic(patData[0]);
            patientLine.setFName(patData[1]);
            patientLine.setLName(patData[2]);
            patientLine.setGender(patData[3]);
            patientLine.setDOB(patData[4]);
            patientLine.setPhoneNumber(patData[5]);
            patientLine.setAddress(patData[6]);
            patientLine.setBloodGroup(patData[7]);
            patientLine.setAllergies(patData[8]);
            patientLine.setPassword(patData[9]);
            patientLine.setOptions(patData[10]);
            
            patientArrayList.add(patientLine);
     
        }
        
        fr.close();
        br.close();
        return patientArrayList;
        
    }
     // patient edit methode
     private Scanner x;
     public void editPatient(String filepath,String tempFile,String id,String fname,String lname,String gender,String dob,String phone,String address,String blood,String allergies){
       File oldFile = new File(filepath);//create object in oldfile
       File newFile = new File (tempFile);//create object in newfile
        //idintyfiy each component
        String idno;String fullname;String lastname;String usergender;String birthday;String phoneNo;String Address;String bloodGroup;String patienallergies;String password;String op;
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
                bloodGroup=x.next();
                patienallergies=x.next();
                password=x.next();
                op=x.next();
                if(idno.equals(id)){  //compare idnumber
                    pw.print(id+","+fname+","+lname+","+gender+","+dob+","+phone+","+address+","+blood+","+allergies+","+password+","+op+"\n"); //is it true update new component
                    
                }else{
                    pw.print(idno+","+fullname+","+lastname+","+usergender+","+birthday+","+phoneNo+","+Address+","+bloodGroup+","+patienallergies+","+password+","+op+"\n"); //else write other data in new file
                }
                    
            } 
            x.close();   //scanner close
            pw.flush();  //print writer flush
            pw.close();   //print writer close
            oldFile.delete();   // file deleted
            File dump = new File (filepath); 
            newFile.renameTo(dump);  // new file rename old file name
            
            
            
       try{ //edit patient detail in data file
        File file = new File("user data\\patient\\data\\"+id+".txt");  
        file.delete();
        PrintWriter printer = new PrintWriter(new FileOutputStream(file)); 
        
         printer.append(fname+"\n"  + lname+ "\n" +  address+"\n"+ id+"\n"+ blood + "\n"+
             dob+ "\n"+ gender +"\n" +phone+"\n"+ allergies);
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
