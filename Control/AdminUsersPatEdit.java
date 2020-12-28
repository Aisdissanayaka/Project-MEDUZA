/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.RecPatientEditWindowController.selectedUser;
import static Control.UserLoginController.profilePicture;
import static Control.UserLoginController.staticUserName;
import Model.Patient;
import Model.user;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminUsersPatEdit extends DashboardUIController implements Initializable {
  @FXML
    private JFXTextArea address;

    @FXML
    private JFXTextField lastName;

    @FXML
    private JFXComboBox<String> gender;

    @FXML
    private JFXTextField phoneNumber;

    @FXML
    private JFXComboBox<String> bloodGroup;

    @FXML
    private JFXTextArea allergies;

    @FXML
    private JFXTextField nic;
  
    @FXML
    private JFXTextField firstName;

    @FXML
    private JFXTextField dob;  
    
    
   public static Patient selectUser;
   
   @FXML
    private Circle patientProfilePhoto;

    
      
   @FXML
    void updateBtn(ActionEvent event){
        
  try {
            
    Patient obj = new Patient();
    obj.editPatient("user data//database//patients.txt", "user data//database//temp.txt", nic.getText(), firstName.getText(), lastName.getText(), gender.getValue(), dob.getText(),
                    phoneNumber.getText(),address.getText(),bloodGroup.getValue(), allergies.getText());
    Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
    alert.setContentText("Updated patient profile.!");
    alert.show();
            
        } catch (Exception e) {
        }
        
        
    }
   
    
   
    @FXML //Password reset button
    void passwordResetBtn(ActionEvent event) {
         try {
             user obj = new user(); // create object in user class and call password reset method
             obj.passwordReset("user data\\patient\\credentials\\patientlogin.txt", "user data\\patient\\credentials\\temp.txt", selectUser.getNic());
             Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
             alert.setContentText("You reset"+selectUser.getFName().toUpperCase()+"'s Password..!");
             alert.show();
         } catch (Exception e) {
         }

    }
   
   
   
   
   
   
   
   
   
   
   
  @Override
    public void initialize(URL url, ResourceBundle rb) { 
    
      firstName.setText(selectUser.getFName());
      lastName.setText(selectUser.getLName());
      gender.setValue(selectUser.getGender());
      address.setText(selectUser.getAddress());
      phoneNumber.setText(selectUser.getPhoneNumber());
      bloodGroup.setValue(selectUser.getBloodGroup());
      allergies.setText(selectUser.getAllergies());
      nic.setText(selectUser.getNic());
      dob.setText(selectUser.getDOB());
        
      ObservableList<String>list1=FXCollections.observableArrayList("Male","Female");
       gender.setItems(list1);
       
       ObservableList<String>list2=FXCollections.observableArrayList("A+","O+","B+","AB+","A-","O-","B-","AB-");
       bloodGroup.setItems(list2);

      
              try{
        FileInputStream input = new FileInputStream("user data\\patient\\photo\\"+selectUser.getNic()+".jpg");
 
        Image img1 = new Image(input);
     
        patientProfilePhoto.setFill(new ImagePattern(img1));
        }catch(Exception e){
            
        }
       
       
    }    
    
}
