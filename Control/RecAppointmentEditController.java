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
import java.awt.Desktop;
import java.awt.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;
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
    private JFXDatePicker appDate;

    @FXML
    private JFXTimePicker appTime;

    @FXML
    private ComboBox<String> specAreaCombo;

    @FXML
    private JFXTextArea Symptoms;

    @FXML
    private JFXTextField userID;
   
   

    //appointment update button action event
    @FXML
    public void updateBtn(javafx.event.ActionEvent event) {
    //create object in appointment class    
    Appointment obj = new Appointment();
    try{
    //called edit appointment metode    
    obj.editAppointment("user data//database//pendingappointment.txt", "user data//database//temp.txt", name.getText(), appDate.getValue().toString(), appTime.getValue().toString(),Symptoms.getText(), specAreaCombo.getValue());
    Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
    alert.setContentText("Updated appointment.!");
    alert.show();
    }catch(Exception e){
      
    }
    }

  

    

  
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //get value and set each text feild
       name.setText(selectedFeield.getName());
       Symptoms.setText(selectedFeield.getSymptoms());
       userID.setText(selectedFeield.getUserID());
       specAreaCombo.setValue(selectedFeield.getSpecArea());
       appTime.setPromptText(selectedFeield.getAppTime());
       appDate.setPromptText(selectedFeield.getAppDate());
     
      ObservableList<String>list1=FXCollections.observableArrayList("A","B","C","D");
        specAreaCombo.setItems(list1);
    }    
    
}
