/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.UserLoginController.primaryKey1;
import static Control.UserLoginController.profilePicture;
import static Control.UserLoginController.staticAddress;
import static Control.UserLoginController.staticDOB;
import static Control.UserLoginController.staticEmail;
import static Control.UserLoginController.staticGender;
import static Control.UserLoginController.staticJoinDate;
import static Control.UserLoginController.staticLName;
import static Control.UserLoginController.staticPhoneNo;
import static Control.UserLoginController.staticSpecilatyArea;
import static Control.UserLoginController.staticStaffID;
import static Control.UserLoginController.staticUserName;
import Model.user;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ashan Isuru
 */
public class MoChangePasswordController implements Initializable {
    @FXML
    private JFXPasswordField currentPassword;

    @FXML
    private JFXPasswordField newPassword1;

    @FXML
    private JFXPasswordField newPassword2;

    @FXML
    private Label warningMsg;
    
    private final  String  filepath = "user data\\medical officer\\credentials\\medicalofficerlogin.txt";
    private final  String tempFile =  "user data\\medical officer\\credentials\\temp.txt";

    @FXML
    public void cancelBtn(ActionEvent event) throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/MO/MOProfileWindow.fxml"));
        //Scene profileViewScene = new Scene(profileWindow);
        Parent root = loader.load();
        DashboardUIController welcome =loader.getController();
        welcome.showInformation(staticUserName, staticLName, staticAddress, staticPhoneNo, 
            staticDOB, staticStaffID, staticEmail, staticJoinDate, staticGender, staticSpecilatyArea);
        welcome.showInformation(staticUserName);
        welcome.showProfilePicture(profilePicture);
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
        window.centerOnScreen();


    }

    @FXML
   public void submitBtn(ActionEvent event) throws IOException {
       if(primaryKey1.equals(currentPassword.getText())){
            warningMsg.setText(null);
            if(newPassword1.getText().equals(newPassword2.getText())){
                
               user o =new user();
               o.changePassword(filepath, currentPassword.getText(),newPassword1.getText(), newPassword2.getText(), tempFile, warningMsg);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setContentText("Password change successfully..!");
               alert.show();
               FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/UserLoginMedicalOfficer.fxml"));
               //Scene profileViewScene = new Scene(profileWindow);
               Parent root = loader.load();
               
               //This Line gets the Stage Information
               Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
               window.setScene(new Scene(root));
               window.show();
               window.centerOnScreen();
               
            }else{
                warningMsg.setText("You must enter the same password twice in oder to confirm it.");
            }
        }else{
            warningMsg.setText("Your current password was incorrect.");
        }
   
    }
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
