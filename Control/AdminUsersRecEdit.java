/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.AdminUsersPatEdit.selectUser;
import Model.Patient;
import Model.Receptionist;
import Model.user;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminUsersRecEdit extends DashboardUIController implements Initializable {
    @FXML
    private JFXTextArea address;

    @FXML
    private JFXTextField lastName;

    @FXML
    private JFXComboBox<String> gender;

    @FXML
    private JFXTextField phoneNumber;

    @FXML
    private JFXTextField firstName;

    @FXML
    private JFXTextField moStaffID;

    @FXML
    private JFXTextField moStaffEmail;

    @FXML
    private JFXTextField dateOfBirth;

    @FXML
    private JFXTextField dateOfJoined;

    public static Receptionist selectUser;
    
    @FXML
    private Circle recProfilePhoto;
  
    @FXML
    void updateBtn(ActionEvent event){
        
  try {
            
    Receptionist recObj = new Receptionist();
    recObj.editPatient("user data//database//receptionists.txt", "user data//database//temp.txt", moStaffID.getText(), firstName.getText(), lastName.getText(), gender.getValue(), dateOfBirth.getText(), phoneNumber.getText(), address.getText(), dateOfJoined.getText(), moStaffEmail.getText()); 
    
    
    Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
    alert.setContentText("Updated receptionist's profile.!");
    alert.show();
            
        } catch (Exception e) {
        }
    
    
}
    
    
    @FXML //Password reset button
    void passwordResetBtn(ActionEvent event) {
         try {
             Receptionist obj = new Receptionist(); // create object in user class and call password reset method
             obj.passwordReset("user data\\receptionist\\credentials\\receptionistlogin.txt", "user data\\patient\\credentials\\temp.txt", selectUser.getStaffID());
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
      moStaffEmail.setText(selectUser.getStaffEmail());
      dateOfBirth.setText(selectUser.getDOB());
      dateOfJoined.setText(selectUser.getJoinDate());
      moStaffID.setText(selectUser.getStaffID());
        
      ObservableList<String>list1=FXCollections.observableArrayList("Male","Female");
       gender.setItems(list1);
       
       
      
              try{
        FileInputStream input = new FileInputStream("user data\\receptionist\\photo\\"+selectUser.getStaffID()+".jpg");
 
        Image img1 = new Image(input);
     
       recProfilePhoto.setFill(new ImagePattern(img1));
        }catch(Exception e){
            
        }
       
       
    }   


}
