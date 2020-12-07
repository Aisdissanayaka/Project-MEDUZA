/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
    private JFXPasswordField userPassword;

    @FXML
    private Button loginBtn;
    
    
    
     @FXML
    public void closeBtn(ActionEvent event) {
     System.exit(0);
    }

    
    
    
    //Methode of Create Account HyperLink
    @FXML   
    public void createAccount(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Sign_Up_as.fxml"));
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
