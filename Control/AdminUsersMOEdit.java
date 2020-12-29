/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Model.MedicalOfficer;
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
public class AdminUsersMOEdit extends DashboardUIController implements Initializable {

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
    private JFXTextField moSpecialityArea;

    @FXML
    private JFXTextField moStaffEmail;

    @FXML
    private JFXTextField dateOfBirth;

    @FXML
    private JFXTextField moDateOfJoin;
    
    @FXML
    private Circle moProfilePhoto;
    
    public static MedicalOfficer selectUser;
    
     @FXML//ubdate butoon action event
    void updateBtn(ActionEvent event) {
        try{
    MedicalOfficer moObj = new MedicalOfficer(); //create object in medical officer class
    //assign the value in setters
    moObj.setFName(firstName.getText());
    moObj.setLName(lastName.getText());
    moObj.setAddress(address.getText());
    moObj.setPhoneNumber(phoneNumber.getText());
    moObj.setDOB(dateOfBirth.getText());
    moObj.setStaffID(moStaffID.getText());
    moObj.setEmail(moStaffEmail.getText());
    moObj.setDateJoined(moDateOfJoin.getText());
    moObj.setGender(gender.getValue());
    moObj.setSpecialityArea (moSpecialityArea.getText());
    moObj.editMO("user data//database//medicalOfficers.txt", "user data//database//temp.txt"); // call medical officer edit method
    Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
    alert.setContentText("Updated medical officer profile.!");
    alert.show();
        }catch(Exception e){}
    }
       
    
   
    
     @FXML //Password reset button
    void passwordResetBtn(ActionEvent event) {
         try {
             user obj = new user(); // create object in user class and call password reset method
             obj.passwordReset("user data\\medical officer\\credentials\\medicalofficerlogin.txt", "user data\\medical officer\\credentials\\temp.txt", selectUser.getStaffID());
             Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
             alert.setContentText("You reset"+selectUser.getFName().toUpperCase()+"'s Password..!");
             alert.show();
         } catch (Exception e) {
         }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       firstName.setText(selectUser.getFName());
       lastName .setText(selectUser.getLName());
       address.setText(selectUser.getAddress());
       gender.setValue(selectUser.getGender());
       phoneNumber.setText(selectUser.getPhoneNumber());
       moStaffID.setText(selectUser.getStaffID());
       moSpecialityArea.setText(selectUser.getSpecialityArea());
       moStaffEmail.setText(selectUser.getEmail());
       dateOfBirth.setText(selectUser.getDOB());
       moDateOfJoin.setText(selectUser.getDateJoined());
        
       ObservableList<String>list1=FXCollections.observableArrayList("Male","Female");
       gender.setItems(list1);

                     try{
        FileInputStream input = new FileInputStream("user data\\medical officer\\photo\\"+selectUser.getStaffID()+".jpg");
 
        Image img1 = new Image(input);
     
        moProfilePhoto.setFill(new ImagePattern(img1));
        }catch(Exception e){
            
        }
       
    }
}
