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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @FXML
    private ComboBox<String> category;
    
    
      
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
    
     
      ObservableList list1=FXCollections.observableArrayList();
 ObservableList list2=FXCollections.observableArrayList();
    
     //spec area drop down list
     private void loadData() throws FileNotFoundException, IOException{
      
        File myfile = new File("user data\\reference\\category.txt"); 
    BufferedReader abc = new BufferedReader(new FileReader(myfile));
     String s;
        while((s=abc.readLine())!=null) {
            list1.add(s);
      
     }
        category.getItems().addAll(list1);
     }
    
    //set medical officer's name
    @FXML
    void getMO() throws IOException {
        specAreaCombo.getItems().removeAll(list2);
        list2.removeAll(list2);
        
        File myfile2 = new File("user data\\reference\\Speciality Area\\"+category.getValue()+".txt"); 
    BufferedReader abc = new BufferedReader(new FileReader(myfile2));
     String s;
        while((s=abc.readLine())!=null) {
            list2.add(s);
      
     }
        specAreaCombo.getItems().addAll(list2);
        
    }
    
    
    @Override
       public void initialize(URL url, ResourceBundle rb) {
         
        //Combo-box data foe the Medical officer speciality
        try {
     
            loadData();
        } catch (IOException ex) {
            Logger.getLogger(PatAddAppointmentWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
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
