/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
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
    
    @FXML
    public void closeBtn(ActionEvent event) {
     System.exit(0);
    }
    



    //Login button Action Method in receptionist Window(user data\receptionist\credentials\receptionistlogin.txt)


     @FXML
    private void loginAsRec(ActionEvent event) throws IOException {
      boolean x = true;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("user data\\receptionist\\credentials\\receptionistlogin.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (br != null) {
            String st;
            while ((st = br.readLine()) != null) {
                String[] splitted = st.split(",");
                if (userName.getText().equals(splitted[0]) && password.getText().equals(splitted[1])) {
                    x = false;
                    Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Dashboards/RecDashboardWelcome.fxml"));
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
        userName.setText(null);
        password.setText(null);
    }



    
    
    
    
    
    
    
    
    
    
    //Login button Action Method in Patient Window(user data\patient\credentials\patientlogin.txt)


     @FXML
    private void loginAsPatient(ActionEvent event) throws IOException {
      boolean x = true;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("user data\\patient\\credentials\\patientlogin.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (br != null) {
            String st;
            while ((st = br.readLine()) != null) {
                String[] splitted = st.split(",");
                if (userName.getText().equals(splitted[0]) && password.getText().equals(splitted[1])) {
                    x = false;
                    Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Dashboards/PatientDashboardWelcome.fxml"));
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
        userName.setText(null);
        password.setText(null);
    }
    
    //Login button Action Method in Medical Officer Window(user data\medical officer\credentials\medicalofficerlogin.txt)


     @FXML
    private void loginAsMO(ActionEvent event) throws IOException {
      boolean x = true;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("user data\\medical officer\\credentials\\medicalofficerlogin.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (br != null) {
            String st;
            while ((st = br.readLine()) != null) {
                String[] splitted = st.split(",");
                if (userName.getText().equals(splitted[0]) && password.getText().equals(splitted[1])) {
                    x = false;
                    Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Dashboards/MODashboardWelcome.fxml"));
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
        userName.setText(null);
        password.setText(null);
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
