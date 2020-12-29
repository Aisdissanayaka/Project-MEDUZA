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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
//import Control.user;

/**
 * FXML Controller class
 *
 * @author Ashan Isuru
 */
public class UserLoginController implements Initializable {
    
    
    
    // Declare Variable each button
     @FXML 
     private AnchorPane rootpane;
    
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
               staticAddress,staticEmail,staticJoinDate,staticStaffID,staticUserID,staticBloodGroup,staticAllergies,
               staticSpecilatyArea;
               
       public static String staticUserName =" ";
       public static String profilePicture =" ";
    //Login button Action Method in receptionist Window(user data\receptionist\credentials\receptionistlogin.txt)

    public UserLoginController() {
    }
    
  

     @FXML
    private void loginAsRec(ActionEvent event) throws IOException {
      user obj = new user();
      obj.setUserName(userName.getText());
      primaryKey = userName.getText();
      primaryKey1 = password.getText();
     try {
      profilePicture = "user data\\receptionist\\photo\\"+primaryKey+".jpg";
      File file = new File("user data\\receptionist\\data\\"+primaryKey+".txt");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      staticUserName = br.readLine();
      staticLName = br.readLine();
      staticGender = br.readLine();
      staticDOB = br.readLine();
      staticPhoneNo = br.readLine();
      staticAddress = br.readLine();
      staticEmail = br.readLine();  
      staticStaffID= br.readLine();
      staticJoinDate = br.readLine();
      
        fr.close();
      br.close();      
      } catch (Exception e) {
         
      } 
      obj.setPassword(password.getText());
      obj.login(event, lable, "user data\\receptionist\\credentials\\receptionistlogin.txt", "/View/Dashboards/RecDashboardWelcome.fxml");
      
     
        
     
     
      
    }
   
    
    //Login button Action Method in Patient Window(user data\patient\credentials\patientlogin.txt)

    @FXML
    private void loginAsPatient(ActionEvent event) throws IOException ,FileNotFoundException {
      user obj = new user();
      obj.setUserName(userName.getText());
      obj.setPassword(password.getText());
      primaryKey = userName.getText();
      primaryKey1 = password.getText();
       
      
      try {
      profilePicture = "user data\\patient\\photo\\"+primaryKey+".jpg";
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
      
      obj.login(event, lable, "user data\\patient\\credentials\\patientlogin.txt" , "/View/Dashboards/PatientDashboardWelcome.fxml");
      
      
      
      
      
      
    }
    
    
    //Login button Action Method in Medical Officer Window(user data\medical officer\credentials\medicalofficerlogin.txt)


    @FXML
    private void loginAsMO(ActionEvent event) throws IOException {
      user obj = new user();
      obj.setUserName(userName.getText());
      obj.setPassword(password.getText());
      primaryKey = userName.getText();
      primaryKey1 = password.getText();
      
        try{
        profilePicture = "user data\\receptionist\\photo\\"+primaryKey+".jpg";
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
       obj.login(event, lable, "user data\\medical officer\\credentials\\medicalofficerlogin.txt", "/View/Dashboards/MODashboardWelcome.fxml");
      
     
    }
    

    //Methode of Create Account HyperLink
  
     //switching and transition sign up as window to user login medical offficer window
        @FXML   
        public void createAccountMedicalOfficer(ActionEvent event) {
              makeFadeOut();
        }
        public void makeFadeOut() {
        FadeTransition fadetransition = new FadeTransition();
        fadetransition.setDuration(Duration.millis(250));
        fadetransition.setNode(rootpane);
        fadetransition.setFromValue(1);
        fadetransition.setToValue(0);
        fadetransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadNextScene();
            }
        });
        fadetransition.play();
       
    }
    
    private void loadNextScene() {
       
        try {
            Parent secondview;
            secondview = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/Sign_Up_as_MO.fxml"));
            Scene newscene= new Scene(secondview);
            Stage curstage =(Stage)rootpane.getScene().getWindow();
            curstage.setScene(newscene);
            
        } catch (IOException ex) {
            Logger.getLogger(Sign_Up_asController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void loginAsAdmin(ActionEvent event) throws IOException ,FileNotFoundException {
      user obj = new user();
      obj.setUserName(userName.getText());
      obj.setPassword(password.getText());
      primaryKey = userName.getText();
      primaryKey1 = password.getText();
    
      obj.login(event, lable, "user data\\admin\\credentials\\adminlogin.txt" , "/View/Dashboards/AdminDashboardWelcome.fxml");
      
      profilePicture = "user data\\admin\\photo\\"+primaryKey+".jpg";
    
      try {
      File file = new File("user data\\admin\\data\\"+primaryKey+".txt");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      staticUserName = br.readLine();
      staticLName = br.readLine();
      staticAddress = br.readLine();
      staticUserID =br.readLine();
      staticDOB = br.readLine();     
      staticGender = br.readLine();
      staticPhoneNo = br.readLine();
      fr.close();
      br.close();      
      } catch (Exception e) {
         
      }
    }
      
    
    //Methode of Create Account HyperLink
   
     //switching and transition sign up as window to user login patient window
        @FXML   
        public void createAccountPATIENT(ActionEvent event) {
              makeFadeOut1();
        }
        public void makeFadeOut1() {
        FadeTransition fadetransition = new FadeTransition();
        fadetransition.setDuration(Duration.millis(250));
        fadetransition.setNode(rootpane);
        fadetransition.setFromValue(1);
        fadetransition.setToValue(0);
        fadetransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadNextScene1();
            }
        });
        fadetransition.play();
       
    }
    
    private void loadNextScene1() {
       
        try {
            Parent secondview;
            secondview = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/Sign_Up_as_PATIENT.fxml"));
            Scene newscene= new Scene(secondview);
            Stage curstage =(Stage)rootpane.getScene().getWindow();
            curstage.setScene(newscene);
            
        } catch (IOException ex) {
            Logger.getLogger(Sign_Up_asController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Methode of Create Account HyperLink
   
      //switching and transition sign up as window to user login Receptionist window
        @FXML   
        public void createAccountReceptionist(ActionEvent event) {
              makeFadeOut2();
        }
        public void makeFadeOut2() {
        FadeTransition fadetransition = new FadeTransition();
        fadetransition.setDuration(Duration.millis(250));
        fadetransition.setNode(rootpane);
        fadetransition.setFromValue(1);
        fadetransition.setToValue(0);
        fadetransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadNextScene2();
            }
        });
        fadetransition.play();
       
    }
    
    private void loadNextScene2() {
       
        try {
            Parent secondview;
            secondview = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/Sign_Up_as_RECEPTIONIST.fxml"));
            Scene newscene= new Scene(secondview);
            Stage curstage =(Stage)rootpane.getScene().getWindow();
            curstage.setScene(newscene);
            
        } catch (IOException ex) {
            Logger.getLogger(Sign_Up_asController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
         //switching and transition sign up as window to user login medical offficer window
        @FXML   
        public void forgotpw(ActionEvent event) {
              makeFadeOut4();
        }
        public void makeFadeOut4() {
        FadeTransition fadetransition = new FadeTransition();
        fadetransition.setDuration(Duration.millis(250));
        fadetransition.setNode(rootpane);
        fadetransition.setFromValue(1);
        fadetransition.setToValue(0);
        fadetransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadNextScene4();
            }
        });
        fadetransition.play();
       
    }
    
    private void loadNextScene4() {
       
        try {
            Parent secondview;
            secondview = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/Dashboards/MODashboardWelcome.fxml"));
            Scene newscene= new Scene(secondview);
            Stage curstage =(Stage)rootpane.getScene().getWindow();
            curstage.setScene(newscene);
            
        } catch (IOException ex) {
            Logger.getLogger(Sign_Up_asController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  

   //switching and transition sign up as window to user login patient window
        @FXML   
        public void forgotpw1(ActionEvent event) {
              makeFadeOut5();
        }
        public void makeFadeOut5() {
        FadeTransition fadetransition = new FadeTransition();
        fadetransition.setDuration(Duration.millis(250));
        fadetransition.setNode(rootpane);
        fadetransition.setFromValue(1);
        fadetransition.setToValue(0);
        fadetransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadNextScene5();
            }
        });
        fadetransition.play();
       
    }
    
    private void loadNextScene5() {
       
        try {
            Parent secondview;
            secondview = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/Dashboards/PatientDashboardWelcome.fxml"));
            Scene newscene= new Scene(secondview);
            Stage curstage =(Stage)rootpane.getScene().getWindow();
            curstage.setScene(newscene);
            
        } catch (IOException ex) {
            Logger.getLogger(Sign_Up_asController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
 
    
   //switching and transition sign up as window to user login Receptionist window
        @FXML   
        public void forgotpw2(ActionEvent event) {
              makeFadeOut6();
        }
        public void makeFadeOut6() {
        FadeTransition fadetransition = new FadeTransition();
        fadetransition.setDuration(Duration.millis(250));
        fadetransition.setNode(rootpane);
        fadetransition.setFromValue(1);
        fadetransition.setToValue(0);
        fadetransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadNextScene6();
            }
        });
        fadetransition.play();
       
    }
    
    private void loadNextScene6() {
       
        try {
            Parent secondview;
            secondview = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/Dashboards/RecDashboardWelcome.fxml"));
            Scene newscene= new Scene(secondview);
            Stage curstage =(Stage)rootpane.getScene().getWindow();
            curstage.setScene(newscene);
            
        } catch (IOException ex) {
            Logger.getLogger(Sign_Up_asController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
