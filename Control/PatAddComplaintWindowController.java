/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Complaint;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PatAddComplaintWindowController extends DashboardUIController implements Initializable {
    
    //create new object as fileChooser           
    FileChooser fileChooser = new FileChooser();
    Stage primaryStage = new Stage();
    
    // declare variables
     @FXML
    private JFXTextField nameTxt;

    @FXML
    private JFXTextArea actionTakenTxt;

    @FXML
    private ComboBox comTypeBox;

    @FXML
    private JFXTextField phoneNumTxt;

    @FXML
    private JFXTextArea descriptionTxt;

    @FXML
    private JFXTextArea noteTxt;
      
    @FXML
    private LocalDate date;
    
    @FXML
    private File path;
    
    @FXML
    private JFXButton btnSave;
    
    @FXML
    private JFXButton btnLoad;
    
    
    //submit button. It's writes complaints data to file
     @FXML
    public void submitBtn(ActionEvent event)throws  IOException {
        if(validateFields()&&validatePhoneNum()){
        
        Complaint patCom=new Complaint();
        patCom.setDate(date.now().toString());
        patCom.setType(comTypeBox.getValue().toString());
        patCom.setName(nameTxt.getText());
        patCom.setPhoneNo(phoneNumTxt.getText());
        patCom.setDescription(descriptionTxt.getText());
        patCom.setActionTaken(actionTakenTxt.getText());
        patCom.setNote(noteTxt.getText());
        
        patCom.addComplaint();
        
        comTypeBox.setValue(null);
        nameTxt.setText(null);
        descriptionTxt.setText(null);
        noteTxt.setText(null);
        phoneNumTxt.setText(null);
        actionTakenTxt.setText(null);
        

    }}
    
       // warning message for null validation
     private boolean validateFields(){
         
          if(nameTxt.getText().isEmpty() | descriptionTxt.getText().isEmpty()| actionTakenTxt.getText().isEmpty()|
             noteTxt.getText().isEmpty()|phoneNumTxt.getText().isEmpty())
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
         Matcher m = p.matcher( phoneNumTxt.getText());
         if(m.find() && m.group().equals( phoneNumTxt.getText())){
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
    
     //opening and saving document file    
    @FXML
    public void openFile(ActionEvent actionEvent) throws IOException {
       
       
        fileChooser.setInitialDirectory(new File("C:\\Users\\"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pdf file","*.pdf","*.PDF"));

        File file = fileChooser.showOpenDialog(primaryStage);
       // File desination = fileChooser.showSaveDialog(primaryStage);
        path=file.getAbsoluteFile();
        
        
         //saving file given path
          try {
                Files.copy(file.toPath(),Paths.get("user data\\complaint\\cv\\"+LocalDate.now()+" " +nameTxt.getText()+".pdf"));
            } catch (Exception ioException) {
               ioException.printStackTrace();
            }
          
          //create new object file1
          File file1 = new File(String.valueOf(path));
       
        fileChooser.setInitialFileName(LocalDate.now()+" " +nameTxt.getText()+".pdf");  
        //getting type of files 
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pdf file","*.pdf","*.PDF"));
        
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         ObservableList<String>list=FXCollections.observableArrayList("Type 1","Type 2", "Type 3");
       comTypeBox.setItems(list);
       
         //show validation status
        RequiredFieldValidator validator = new RequiredFieldValidator();
        NumberValidator numvalidator = new  NumberValidator();
        validator.setMessage("Required Field");
         numvalidator.setMessage("Invalied Number");
     
       nameTxt.getValidators().add(validator);
       descriptionTxt.getValidators().add(validator);
       noteTxt.getValidators().add(validator);
       phoneNumTxt.getValidators().add(validator);
       phoneNumTxt.getValidators().add(numvalidator);
       actionTakenTxt.getValidators().add(validator);
        
        
       nameTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                nameTxt.validate();
                }}
        });
       
       descriptionTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
               descriptionTxt.validate();
                }}
        });
        
        noteTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
               noteTxt.validate();
                }}
        }); 
       
       phoneNumTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                phoneNumTxt.validate();
                }}
        }); 
       
        actionTakenTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                actionTakenTxt.validate();
                }}
        }); 
    }    
    
}
