/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.user;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
//import Control.user;

/**
 * FXML Controller class
 *
 * @author Ashan Isuru
 */
public class UserLoginController implements Initializable {
    
    
    
    // Declare Variable each button
    
     @FXML
    private Hyperlink createAccountLink;

    @FXML
    private Button cancelBtn;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXPasswordField password;

    @FXML
    private Button login;
    
    @FXML
    private Label lable;
    
    
    //This will exit the system.
    @FXML
    public void closeBtn(ActionEvent event) {
     System.exit(0);
    }
    
 
       public static String primaryKey,primaryKey1,
               staticFName,staticLName,staticGender,staticDOB,staticPhoneNo,
               staticAddress,staticEmail,staticJoinDate,staticStaffID,staticUserID,staticBloodGroup,staticAllergies,staticSpecilatyArea;
       public static String staticUserName =" ";
       public static String profilePicture =" ";
    //Login button Action Method in receptionist Window(user data\receptionist\credentials\receptionistlogin.txt)

    public UserLoginController() {
    }
    
  

     @FXML
    private void loginAsRec(ActionEvent event) throws IOException ,FileNotFoundException{
      user obj = new user();
      obj.setUserName(userName.getText());
      obj.setPassword(password.getText());
      primaryKey = userName.getText();
      primaryKey1 = password.getText();
      
      obj.login(event, lable, "user data\\receptionist\\credentials\\receptionistlogin.txt", "/View/Dashboards/RecDashboardWelcome.fxml");
      
      
      profilePicture = "user data\\receptionist\\photo\\"+primaryKey+".jpg";
      try{
      File file = new File("user data\\receptionist\\data\\"+primaryKey+".txt");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      staticUserName = br.readLine();
      staticLName = br.readLine();
      staticAddress = br.readLine();
      staticPhoneNo = br.readLine();
      staticDOB = br.readLine();     
      staticGender = br.readLine();
      staticStaffID = br.readLine();  
      staticEmail = br.readLine();
      staticJoinDate = br.readLine();
      
      
      fr.close();
      br.close();
     
      }catch(Exception e){
          
      }
              
      
    }
   
    
    //Login button Action Method in Patient Window(user data\patient\credentials\patientlogin.txt)

     @FXML
    private void loginAsPatient(ActionEvent event) throws IOException ,FileNotFoundException {
      user obj = new user();
      obj.setUserName(userName.getText());
      obj.setPassword(password.getText());
      primaryKey = userName.getText();
      primaryKey1 = password.getText();
    
      obj.login(event, lable, "user data\\patient\\credentials\\patientlogin.txt" , "/View/Dashboards/PatientDashboardWelcome.fxml");
      
      profilePicture = "user data\\patient\\photo\\"+primaryKey+".jpg";
      
      try {
      File file = new File("user data\\patient\\data\\"+primaryKey+".txt");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      staticUserName = br.readLine();
      staticLName = br.readLine();
      staticAddress = br.readLine();
      staticUserID =br.readLine();
      staticBloodGroup=br.readLine();
      staticDOB = br.readLine();     
      staticGender = br.readLine();
      staticPhoneNo = br.readLine();
      staticAllergies =br.readLine();
          

      fr.close();
      br.close();      
      } catch (Exception e) {
         
      }
      
      
      
    }
    
    
    //Login button Action Method in Medical Officer Window(user data\medical officer\credentials\medicalofficerlogin.txt)


     @FXML
    private void loginAsMO(ActionEvent event) throws IOException {
      user obj = new user();
      obj.setUserName(userName.getText());
      obj.setPassword(password.getText());
      primaryKey = userName.getText();
      primaryKey1 = password.getText();
      obj.login(event, lable, "user data\\medical officer\\credentials\\medicalofficerlogin.txt", "/View/Dashboards/MODashboardWelcome.fxml");
       
      profilePicture = "user data\\receptionist\\photo\\"+primaryKey+".jpg";
      try{
      File file = new File("user data\\medical officer\\data\\"+primaryKey+".txt");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      staticUserName = br.readLine();
      staticLName = br.readLine();
      staticAddress = br.readLine();
      staticPhoneNo= br.readLine();
      staticDOB = br.readLine();
      staticStaffID = br.readLine();
      staticEmail = br.readLine();
      staticJoinDate = br.readLine();
      staticGender = br.readLine();
      staticSpecilatyArea = br.readLine();
      fr.close();
      br.close();      
      } catch (Exception e) {
         
      }
      
      
      
    }
    

    //Methode of Create Account HyperLink
    @FXML   
    public void createAccountMedicalOfficer(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Sign_Up_as_MO.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    //Methode of Create Account HyperLink
    @FXML   
    public void createAccountPATIENT(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Sign_Up_as_PATIENT.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
    //Methode of Create Account HyperLink
    @FXML   
    public void createAccountReceptionist(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Sign_Up_as_RECEPTIONIST.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    @FXML 
    public void forgotpw(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Dashboards/MODashboardWelcome.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        window.getFullScreenExitKeyCombination();
        
       }

     @FXML 
    public void forgotpw1(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Dashboards/PatientDashboardWelcome.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        window.getFullScreenExitKeyCombination();
        
       }
    
 
     @FXML 
    public void forgotpw2(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Dashboards/RecDashboardWelcome.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        window.getFullScreenExitKeyCombination();
        
       }
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
