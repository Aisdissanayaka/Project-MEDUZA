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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import Control.UserLoginController;
import static Control.UserLoginController.primaryKey;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;




public class RecAddAppointmentWindowController extends DashboardUIController implements Initializable {
    
//Declaring the components in the window    
    @FXML
    private JFXTextField name;

    @FXML
    private JFXDatePicker appDate;

    @FXML
    private JFXTimePicker appTime;

    @FXML
    private ComboBox<String> specAreaCombo;

    @FXML
    private JFXTextArea Symptoms;

    @FXML
    private JFXTextField userID;
    
    
      
      //Adding new appointment - Submit Button Action Methode    
      @FXML  
      public void submitBtn(ActionEvent event) throws FileNotFoundException {
          if(validateFields()){
        //write values in another text file
        Appointment appObj = new Appointment();
        appObj.setName(name.getText());
        appObj.setAppDate(appDate.getValue().toString());
        appObj.setAppTime(appTime.getValue().toString());
        appObj.setSymptoms(Symptoms.getText());
        appObj.setUserID(userID.getText());
        appObj.addAppointmentRec(event);
        
        
          System.out.println(primaryKey);
        
     }}
      
      @FXML  
      public void abracadabra(ActionEvent event) throws FileNotFoundException, IOException {
          Appointment obj = new Appointment();
          obj.viewAppointment(event);
          
          
          
      }
      
      
       // warning message for null validation
     private boolean validateFields(){
         
          if(userID.getText().isEmpty() | name.getText().isEmpty()|appDate.getEditor().getText().isEmpty()|appTime.getEditor().getText().isEmpty()| Symptoms.getText().isEmpty())
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
    

   //Create an arrayList to store the appointment reco
    
    
    
    @Override
       public void initialize(URL url, ResourceBundle rb) {
           
      //Combo-box data foe the Medical officer speciality     
       ObservableList<String>list1=FXCollections.observableArrayList("A","B","C","D");
        specAreaCombo.setItems(list1);
        
         //show validation status
        RequiredFieldValidator validator = new RequiredFieldValidator();
        NumberValidator numvalidator = new  NumberValidator();
        
       
        //validation for user ID
        userID.getValidators().add(validator);
        validator.setMessage("Required Field");
        
       userID.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                userID.validate();
                } 
            }
        });
        //validation field for name
        name.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        name.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                name.validate();
                } 
            }
        });
        //validation Field for appointment date
        appDate.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        appDate.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                appDate.validate();
                } 
            }
        }); 
        //validation field for appointment time
        appTime.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        appTime.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                appTime.validate();
                } 
            }
        }); 
        //validation Field for symptoms
        Symptoms.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        Symptoms.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                Symptoms.validate();
                } 
            }
        }); 
        
        
        
        
    }    
    
}
