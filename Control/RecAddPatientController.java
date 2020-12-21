/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
    private ComboBox gender;
    
    @FXML
    private JFXDatePicker dateOfBirth;
    
    @FXML
    private JFXTextField phoneNumber;
    
    @FXML
    private JFXTextArea address;
    
    @FXML
    private ComboBox bloodGroup;
    
    @FXML
    private JFXTextArea allergies;
   
    
     @FXML
    public void submitBtn(ActionEvent event)throws  IOException{
        
        if(validateFields()){
    
        try
        {
          File file = new File("user data\\patient\\data\\"+ nic.getText()+".txt"); 
        PrintWriter printer = new PrintWriter(new FileOutputStream(file,true));  
        printer.append(firstName.getText()+" "  + lastName.getText()+"\n"  +address.getText() + "\n"+ nic.getText()+"\n"+bloodGroup.getValue()+"\n"+dateOfBirth.getValue()+"\n"+gender.getValue()+  
                "\n"+ phoneNumber.getText()+"\n"+ allergies.getText());
             printer.close();
           }
        catch (Exception ioException) {}
        
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
    
    
    
     // Cancel Button. it's go to sign up as menu  
    public void cancelBtn(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Sign_Up_as.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
     // warning message for null validation
     private boolean validateFields(){
         
   if(firstName.getText().isEmpty() | lastName.getText().isEmpty()|  address.getText().isEmpty()|
       nic.getText().isEmpty()|allergies.getText().isEmpty()|phoneNumber.getText().isEmpty())
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
