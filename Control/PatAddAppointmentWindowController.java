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
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;



public class PatAddAppointmentWindowController extends DashboardUIController implements Initializable {
    
//Declaring the components in the window    
    @FXML
    private JFXTextField nameTxt;

    @FXML
    private JFXDatePicker appDate;

    @FXML
    private JFXTimePicker appTime;

    @FXML
    private ComboBox<String> specAreaCombo;

    @FXML
    private JFXTextArea SymptomsTxt;

    @FXML
    private JFXTextField NICTxt;
    
    
      
      //Adding new appointment - Submit Button Action Methode    
      @FXML  
      public void submitBtn(ActionEvent event) throws FileNotFoundException, IOException {
          if(validateFields()){
        Appointment appObj = new Appointment();
        appObj.setName(nameTxt.getText());
        appObj.setAppDate(appDate.getValue().toString());
        appObj.setAppTime(appTime.getValue().toString());
        appObj.setSymptoms(SymptomsTxt.getText());
        appObj.setUserID(NICTxt.getText());
        appObj.setSpecArea(specAreaCombo.getValue());
        appObj.addAppointmentRec(event);
        
        appDate.setValue(null);
        appTime.setValue(null);
        specAreaCombo.setValue(null);
        SymptomsTxt.setText(null);
        
        
        
     }}
       // warning message for null validation
     private boolean validateFields(){
         
          if(nameTxt.getText().isEmpty() |SymptomsTxt.getText().isEmpty()| NICTxt.getText().isEmpty())
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
           
      //Combo-box data foe the Medical officer speciality     
       ObservableList<String>list1=FXCollections.observableArrayList("A","B","C","D");
        specAreaCombo.setItems(list1);
        
          //show validation status
        RequiredFieldValidator validator = new RequiredFieldValidator();
         validator.setMessage("Required Field");
        
        
       
        //validation for user ID
        nameTxt.getValidators().add(validator);
        SymptomsTxt.getValidators().add(validator);
        appDate.getValidators().add(validator);
        appTime.getValidators().add(validator);
        NICTxt.getValidators().add(validator);
       
        
      nameTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                nameTxt.validate();
                }}
        });
          
      SymptomsTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
               SymptomsTxt.validate();
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
      
        NICTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                 NICTxt.validate();
                }}
        }); 
        
        
        
    }    
    
}
