/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Ashan Isuru
 */


      


public class Sign_Up_asController implements Initializable {
    @FXML
    private  AnchorPane rootpane;
    
     // Exit Button
    @FXML
    public void closeBtn(ActionEvent event) {
    System.exit(0);
    }

   
        //medical officer button
     //switching and transition sign up as window to user login medical offficer window
        @FXML   
        public void medicalOfficerBtn(ActionEvent event) {
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
            secondview = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/UserLoginMedicalOfficer.fxml"));
            Scene newscene= new Scene(secondview);
            Stage curstage =(Stage)rootpane.getScene().getWindow();
            curstage.setScene(newscene);
            
        } catch (IOException ex) {
            Logger.getLogger(Sign_Up_asController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
       //switching and transition sign up as window to user login patient window
        @FXML   
        public void patientBtn(ActionEvent event) {
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
            secondview = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/UserLoginPatient.fxml"));
            Scene newscene= new Scene(secondview);
            Stage curstage =(Stage)rootpane.getScene().getWindow();
            curstage.setScene(newscene);
            
        } catch (IOException ex) {
            Logger.getLogger(Sign_Up_asController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
     //switching and transition sign up as window to user login Receptionist window
        @FXML   
        public void receptionisBtn(ActionEvent event) {
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
            secondview = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/UserLoginReceptionist.fxml"));
            Scene newscene= new Scene(secondview);
            Stage curstage =(Stage)rootpane.getScene().getWindow();
            curstage.setScene(newscene);
            
        } catch (IOException ex) {
            Logger.getLogger(Sign_Up_asController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
         //switching and transition sign up as window to user login Admin window
        @FXML   
        public void adminBtn(ActionEvent event) {
              makeFadeOut3();
        }
        public void makeFadeOut3() {
        FadeTransition fadetransition = new FadeTransition();
        fadetransition.setDuration(Duration.millis(250));
        fadetransition.setNode(rootpane);
        fadetransition.setFromValue(1);
        fadetransition.setToValue(0);
        fadetransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadNextScene3();
            }
        });
        fadetransition.play();
       
    }
    
    private void loadNextScene3() {
       
        try {
            Parent secondview;
            secondview = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/UserLoginAdmin.fxml"));
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
