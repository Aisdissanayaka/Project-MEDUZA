/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminAddPatController extends DashboardUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    

    @FXML
    private JFXTextField firstNameTxt;

    @FXML
    private JFXTextField lastNameTxt;

    @FXML
    private JFXTextField nicTxt;

     @FXML
    private JFXComboBox<String> genderTxt;

    @FXML
    private JFXDatePicker dateOfBirthDate;

    @FXML
    private JFXTextField phoneNumberTxt;

    @FXML
    private JFXTextArea address;

    @FXML
    private JFXComboBox<String> bloodGroupTxt;

    @FXML
    private JFXTextArea allergies;
    
    Stage primaryStage = new Stage();
    
       @FXML
    public void submit(ActionEvent event) throws IOException{
        
        if(validateFields()&& validatePhoneNum()){
        try{
        
            Patient patObj=new Patient();
            
           patObj.setFName(firstNameTxt.getText());
           patObj.setLName(lastNameTxt.getText());
           patObj.setAddress(address.getText());
           patObj.setPhoneNumber(phoneNumberTxt.getText());
           patObj.setDOB(dateOfBirthDate.getValue().toString());
           patObj.setNic(nicTxt.getText());
           patObj.setGender(genderTxt.getValue());
           patObj.setAllergies(allergies.getText());
           patObj.setBloodGroup(bloodGroupTxt.getValue());
         
          
           patObj.signup(event);
          

        
        }
        catch(Exception e){}
          firstNameTxt.setText(null);
          lastNameTxt.setText(null);
         address.setText(null);
         nicTxt.setText(null);
         bloodGroupTxt.setValue(null);
         dateOfBirthDate.setValue(null);
         phoneNumberTxt.setText(null);
         allergies.setText(null);
         genderTxt.setValue(null);    
        
        }
        
    }
    
    
    //upload a photograph
     @FXML
     private void addPhoto(ActionEvent event)throws IOException{
         Stage stage =new Stage();
         FileChooser fileChooser =new FileChooser();
         fileChooser.setTitle("Choose an Image");
         
         fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("jpg","*.jpg"));
         
         File selectedFile = fileChooser.showOpenDialog(stage);
         
         Image OriginalPhoto = new Image(selectedFile.toURI().toString());
      
         Image img1= new Image(selectedFile.toURI().toString());
         saveToFile(img1,"photo");
         
     }
     //save photogrgaph
     private void saveToFile(Image image,String name)throws IOException{
         File fileoutput = new File ("user data\\patient\\photo\\"+nicTxt.getText()+".jpg");
         BufferedImage BI= SwingFXUtils.fromFXImage(image,null);
         ImageIO.write(BI,"jpg",fileoutput);
         
    }
    
 // warning message for null validation
     private boolean validateFields(){
           
         
         if(firstNameTxt.getText().isEmpty() | lastNameTxt.getText().isEmpty()| address.getText().isEmpty()|
                 phoneNumberTxt.getText().isEmpty()| nicTxt.getText().isEmpty()| allergies.getText().isEmpty())
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
       //warnig message to invalide Phone Number 
     private boolean validatePhoneNum(){
         Pattern p=Pattern.compile("[0][0-9]{9}");
         Matcher m = p.matcher(phoneNumberTxt.getText());
         if(m.find() && m.group().equals(phoneNumberTxt.getText())){
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
        
        ObservableList<String>list1=FXCollections.observableArrayList("Male","Female","Other");
       genderTxt.setItems(list1);
       
       ObservableList<String>list2=FXCollections.observableArrayList("A+","O+","B+","AB+","A-","O-","B-","AB-");
       bloodGroupTxt.setItems(list2);
       
        //show validation status
        RequiredFieldValidator validator = new RequiredFieldValidator();
        NumberValidator numvalidator = new  NumberValidator();
        numvalidator.setMessage("Invalied Number");
        validator.setMessage("Required Field");
    
      
        
        //validation for phone number
        phoneNumberTxt.getValidators().add(numvalidator);
        firstNameTxt.getValidators().add(validator);
        lastNameTxt.getValidators().add(validator);
        address.getValidators().add(validator);
        phoneNumberTxt.getValidators().add(validator);
        dateOfBirthDate.getValidators().add(validator);
        allergies.getValidators().add(validator);
        nicTxt.getValidators().add(validator);
        genderTxt.getValidators().add(validator);
        bloodGroupTxt.getValidators().add(validator);
        
       phoneNumberTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                phoneNumberTxt.validate();
                }}
        });       
        
        firstNameTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                firstNameTxt.validate();
                }}
        });
        
        lastNameTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                lastNameTxt.validate();
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
       
        phoneNumberTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                phoneNumberTxt.validate();
                }}
        }); 
    
        dateOfBirthDate.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
               dateOfBirthDate.validate();
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
        
       nicTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
               nicTxt.validate();
                }}
        }); 
       
       genderTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                genderTxt.validate();
                }}
         }); 
       
        bloodGroupTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                bloodGroupTxt.validate();
                }}
         }); 
    }    
    
}
