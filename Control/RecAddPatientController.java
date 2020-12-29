/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Patient;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RecAddPatientController extends DashboardUIController implements Initializable {
    
     
    @FXML
    private JFXTextField nic;
    
    @FXML
    private JFXTextField firstName;
    
    @FXML
    private JFXTextField lastName;
    
    @FXML
    private JFXComboBox<String> gender;
    
    @FXML
    private JFXDatePicker dateOfBirth;
    
    @FXML
    private JFXTextField phoneNumber;
    
    @FXML
    private JFXTextArea address;
    
    @FXML
    private JFXComboBox<String> bloodGroup;
    
    @FXML
    private JFXTextArea allergies;
   
    
     @FXML
    public void submitBtn(ActionEvent event)throws  IOException{
        
        if(validateFields()&& validatePhoneNum()){
    try{ //set value in setters
        Patient obj = new Patient();
        obj.setNic(nic.getText());
        obj.setFName(firstName.getText());
        obj.setLName(lastName.getText());
        obj.setPhoneNumber(phoneNumber.getText());
        obj.setBloodGroup(bloodGroup.getValue());
        obj.setAllergies(allergies.getText());
        obj.setGender(gender.getValue().toString());
        obj.setAddress(address.getText());
        obj.setDOB(dateOfBirth.getValue().toString());
        obj.signup(event);// call patient add methode
    }catch(Exception e){
        
    }
        
        
         //setiing values for declared variables
         firstName.setText(null);
         lastName.setText(null);
         address.setText(null);
         nic.setText(null);
         dateOfBirth.setValue(null);
         allergies.setText(null);
         phoneNumber.setText(null);        
         gender.setValue(null);
         bloodGroup.setValue(null);
    
    } }
    
       // warning message for null validation
     private boolean validateFields(){
         
   if(firstName.getText().isEmpty() | lastName.getText().isEmpty()| nic.getText().isEmpty()| dateOfBirth.getEditor().getText().isEmpty()|phoneNumber.getText().isEmpty()|address.getText().isEmpty()|
allergies.getText().isEmpty())
         {
              Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Validate Fields");
             alert.setHeaderText(null);
             alert.setContentText("Please fill all the fields");
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
        // TODO
         ObservableList<String>list1=FXCollections.observableArrayList("Male","Female");
       gender.setItems(list1);
       
       ObservableList<String>list2=FXCollections.observableArrayList("A+","O+","B+","AB+","A-","O-","B-","AB-");
       bloodGroup.setItems(list2);
       
           //show validation status
        RequiredFieldValidator validator = new RequiredFieldValidator();
        NumberValidator numvalidator = new  NumberValidator();
        numvalidator.setMessage("Invalied Number");
        validator.setMessage("Required Field");
        
        
        phoneNumber.getValidators().add(numvalidator);
         firstName.getValidators().add(validator);
        lastName.getValidators().add(validator);
        address.getValidators().add(validator);
        nic.getValidators().add(validator);
        dateOfBirth.getValidators().add(validator);
        allergies.getValidators().add(validator);
        phoneNumber.getValidators().add(validator);
        gender.getValidators().add(validator);
        bloodGroup.getValidators().add(validator);
       
        
       gender.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
               gender.validate();
                }}
        }); 
        bloodGroup.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                bloodGroup.validate();
                }}
        }); 
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
       
        nic.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                nic.validate();
                }}
        }); 
       
        dateOfBirth.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                dateOfBirth.validate();
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
