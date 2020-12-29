/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.UserLoginController.profilePicture;
import static Control.UserLoginController.staticUserName;
import Model.Patient;
import Model.user;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
 * @author Ashan Isuru
 */
public class RecPatientEditWindowController extends DashboardUIController implements Initializable {
    @FXML
    private JFXTextField firstName;

    @FXML
    private JFXTextArea address;

    @FXML
    private JFXTextField lastName;

    @FXML
    private JFXComboBox<String> gender;

    @FXML
    private JFXTextField dateOfBirth;

    @FXML
    private JFXTextField phoneNumber;

    @FXML
    private JFXComboBox<String> bloodGroup;

    @FXML
    private JFXTextArea allergies;

    @FXML
    private JFXTextField nic;
    
     @FXML
    private Circle patientProfilePhoto;

    public static Patient selectedUser;
    
     @FXML
    void cancelBtn(ActionEvent event) throws IOException {
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecPatientsWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);
    welcome.showProfilePicture(profilePicture);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen(); 
    }
    
    
    
    @FXML
    void updateBtn(ActionEvent event){
        if(validateFields()&& validatePhoneNum()){
  try {
            
    Patient obj = new Patient();
    obj.editPatient("user data//database//patients.txt", "user data//database//temp.txt", nic.getText(), firstName.getText(), lastName.getText(), gender.getValue(), dateOfBirth.getText(),
                    phoneNumber.getText(),address.getText(),bloodGroup.getValue(), allergies.getText());
    Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
    alert.setContentText("Updated patient profile.!");
    alert.show();
            
        } catch (Exception e) {
        }
        
        }
    }
    
     @FXML //Password reset button
    void passwordResetBtn(ActionEvent event) {
         try {
             user obj = new user(); // create object in user class and call password reset method
             obj.passwordReset("user data\\patient\\credentials\\patientlogin.txt", "user data\\patient\\credentials\\temp.txt", selectedUser.getNic());
             Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
             alert.setContentText("You reset"+selectedUser.getFName().toUpperCase()+"'s Password..!");
             alert.show();
         } catch (Exception e) {
         }

    }
    
     // warning message for null validation
     private boolean validateFields(){
         
   if(firstName.getText().isEmpty() | lastName.getText().isEmpty()|phoneNumber.getText().isEmpty()|address.getText().isEmpty()|
allergies.getText().isEmpty())
         {
              Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Validate Fields");
             alert.setHeaderText(null);
             alert.setContentText("Please Fill all the Fields");
             alert.showAndWait();
             return false;
            }
        return true;
         }
    
       //warnig message to invalide Phone Number 
     private boolean validatePhoneNum(){
         Pattern p=Pattern.compile("[0][0-9]{9}");
         Matcher m = p.matcher(phoneNumber.getText());
         if(m.find() && m.group().equals(phoneNumber.getText())){
           return true;
         }else{
              Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Validate Phone Number");
             alert.setHeaderText(null);
             alert.setContentText("Please Enter The Valid Phone Number");
             alert.showAndWait();
             return false;
         }
       }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      firstName.setText(selectedUser.getFName());
      address.setText(selectedUser.getAddress());
      lastName.setText(selectedUser.getLName());
      gender.setValue(selectedUser.getGender());
      dateOfBirth.setText(selectedUser.getDOB());
      phoneNumber.setText(selectedUser.getPhoneNumber());
      bloodGroup.setValue(selectedUser.getBloodGroup());
      allergies.setText(selectedUser.getAllergies());
      nic.setText(selectedUser.getNic());
      
      
      ObservableList<String>list1=FXCollections.observableArrayList("Male","Female");
       gender.setItems(list1);
       
       ObservableList<String>list2=FXCollections.observableArrayList("A+","O+","B+","AB+","A-","O-","B-","AB-");
       bloodGroup.setItems(list2);
       
       //set patient profile photo
          
       try{
        FileInputStream input = new FileInputStream("user data\\patient\\photo\\"+selectedUser.getNic()+".jpg");
 
        Image img1 = new Image(input);
     
        patientProfilePhoto.setFill(new ImagePattern(img1));
        }catch(Exception e){
            
        }
       
            //show validation status
        RequiredFieldValidator validator = new RequiredFieldValidator();
        NumberValidator numvalidator = new  NumberValidator();
        numvalidator.setMessage("Invalied Number");
        validator.setMessage("Required Field");
        
        
        phoneNumber.getValidators().add(numvalidator);
         firstName.getValidators().add(validator);
        lastName.getValidators().add(validator);
        address.getValidators().add(validator);
        allergies.getValidators().add(validator);
        phoneNumber.getValidators().add(validator);
       
        
        phoneNumber.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                phoneNumber.validate();
                }}
        });       
       
        firstName.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                firstName.validate();
                }}
        });
  
        lastName.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                lastName.validate();
                }}
        });
         address.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                address.validate();
                }}
        }); 
         
           allergies.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                 allergies.validate();
                }}
        }); 
       
       
       
      
    }    
    
}
