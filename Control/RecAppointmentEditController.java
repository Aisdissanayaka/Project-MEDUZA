/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Model.Appointment;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.awt.Desktop;
import java.awt.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Ashan Isuru
 */
public class RecAppointmentEditController extends DashboardUIController implements Initializable {
    //create static  object in appointment class
    static Appointment selectedFeield; 
    
    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField appDate;

    @FXML
    private JFXTextField appTime;

    @FXML
    private ComboBox<String> specAreaCombo;

    @FXML
    private JFXTextArea Symptoms;

    @FXML
    private JFXTextField userID;
   
   

    //appointment update button action event
    @FXML
    public void updateBtn(javafx.event.ActionEvent event) {
        if(validateFields()){
    //create object in appointment class    
    Appointment obj = new Appointment();
    try{
    //called edit appointment metode  
    obj.setUserID(userID.getText());
    obj.editAppointment("user data//database//pendingappointment.txt", "user data//database//temp.txt", name.getText(), appDate.getText(), appTime.getText(),Symptoms.getText(), specAreaCombo.getValue());
    Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
    alert.setContentText("Updated appointment.!");
    alert.show();
    }catch(Exception e){
      Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
    alert.setContentText("Please update date and time..!");
    alert.show();
    }
    }}
    
      private boolean validateFields(){
         
   if(name.getText().isEmpty() | appDate.getText().isEmpty()| appTime.getText().isEmpty()|Symptoms.getText().isEmpty())
         {
              Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Validate Fields");
             alert.setHeaderText(null);
             alert.setContentText("Please Enter Into The Fields");
             alert.showAndWait();
             return false;
            }
        return true;
         }

  

    

  
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //get value and set each text feild
       name.setText(selectedFeield.getName());
       Symptoms.setText(selectedFeield.getSymptoms());
       userID.setText(selectedFeield.getUserID());
       specAreaCombo.setValue(selectedFeield.getSpecArea());
       appTime.setText(selectedFeield.getAppTime());
       appDate.setText(selectedFeield.getAppDate());
     
      ObservableList<String>list1=FXCollections.observableArrayList("A","B","C","D");
        specAreaCombo.setItems(list1);
        
         RequiredFieldValidator validator = new RequiredFieldValidator();
        NumberValidator numvalidator = new  NumberValidator();
       
        numvalidator.setMessage("Invalied Number");
        validator.setMessage("Required Field");
        
         name.getValidators().add(validator);
         appDate.getValidators().add(validator);
        appTime.getValidators().add(validator);
        //specAreaCombo.getValidators().add(validator);
         Symptoms.getValidators().add(validator);
        
        name.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                name.validate();
                }}
        });
  
        appDate.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                appDate.validate();
                }}
        });
       
        appTime.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                appTime.validate();
                }}
        }); 
       
        Symptoms.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                Symptoms.validate();
                }}
        }); 
       
    }    
    
}
