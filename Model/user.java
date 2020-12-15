/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.jfoenix.controls.JFXPasswordField;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Ashan Isuru
 */
public class user {
   private String username;
   private String password;
   private String fName;
   private String lName;
   private String phoneNumber;
   private String DOB;
   private String gender;
   private String maritalStatus;
   private String address;
   
   
   
  //Getters
    public String getPassword() {
        return password;
    }
    public String getUserName() {
        return username;
    }
    public String getFName() {
        return fName;
    }
    public String getLName() {
        return lName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getDOB() {
        return DOB;
    }
    
     public String getGender() {
        return gender;
    }
     public String getMaritalStatus() {
        return maritalStatus;
    }
     public String getAddress() {
        return address;
    }
    
    
    //Setters
  
   public void setUserName(String username) {
        this.username = username;
    }
   public void setPassword(String password) {
        this.password = password;
    }
    public void setFName(String fName) {
        this.fName = fName;
    }
    public void setLName(String lName) {
        this.lName = lName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
     public void setGender(String gender) {
        this.gender = gender;
    }
     public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
     public void setAddress(String address) {
        this.address = address;
    }
    
   
   
   
   public void login(ActionEvent event ,Label lable ,String txtpath,String fxmlpath) throws IOException{
      boolean x = true;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(txtpath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (br != null) {
            String st;
            while ((st = br.readLine()) != null) {
                String[] splitted = st.split(",");
                if (username.equals(splitted[0]) && password.equals(splitted[1])) {
                    x = false;
                    Parent signUpAsParent = FXMLLoader.load(getClass().getResource(fxmlpath));
                    Scene signUpAsviewScene = new Scene(signUpAsParent);
        
                     //This Line gets the Stage Information
                     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                     window.setScene(signUpAsviewScene);
                     window.show();
                     window.centerOnScreen();
                     
                }
                    
                
            }if (x == true){
            /*Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Invalid Username or Password\n please try again!");
            alert.show();*/
            lable.setText("Invalid Username or Password");
            
            }
        }
        username=(null);
        password=(null);
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    
    private  Scanner x;
    public void changePassword(String filepath,String currentPassword,String newPassword1,String newPassword2,String tempFile,Label warningMsg,String userName) throws IOException{
        File oldFile = new File(filepath);
        File newFile = new File (tempFile);
        String username = "" ; String password = "";
        
       
            
            
           try{ 
            FileWriter fw = new FileWriter(tempFile,true); 
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x =new Scanner(new File (filepath));
            x.useDelimiter("[,\n]");
            
            while (x.hasNext()){
                
            
            username = x.next();
            password = x.next();
            if (username.equals(userName)&& password.equals(currentPassword)){
            
             pw.print(username+ "," + newPassword1+"\n");
               
            }else{
                warningMsg.setText("hello");
                pw.print(username + "," + password+"\n");
            }
            
        }
           x.close();
           pw.flush();
           pw.close();
           //fw.close();
           oldFile.delete();
           File dump = new File(filepath);
           newFile.renameTo(dump);
            
            
        }
           
           catch (Exception e) {
               System.out.println("Error");
        }
    }


    
    
    
    
}