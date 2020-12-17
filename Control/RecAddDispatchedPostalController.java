/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RecAddDispatchedPostalController extends DashboardUIController implements Initializable {
    
    //create new object as fileChooser           
    FileChooser fileChooser = new FileChooser();
    Stage primaryStage = new Stage();
    
    
    //Declaring Variables
    @FXML
    private JFXTextField disName;

    @FXML
    private JFXTextArea disNote;

    @FXML
    private JFXTextField disReff;

    @FXML
    private JFXTextArea disTo;

    @FXML
    private JFXTextField disFrom;
    
    @FXML
    private JFXDatePicker disDate;
    
    @FXML
    private File path;
    
    @FXML
    private JFXButton btnSave;
    
    @FXML
    private JFXButton btnLoad;
    
    
    //Add Dispatched Postal Contoller - Submit Button Action Method    
    @FXML  
      public void submitBtn(ActionEvent event) {
            String value = disDate.getValue().toString();
            
            if(validateFields()){
         try {
            File file = new File ("user data\\receptionist\\postal\\dispatched post\\data\\"+disReff.getText()+".txt");
                PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
                print.append(disName.getText()+"\n"+disReff.getText()+"\n"+disTo.getText()+"\n"+disNote.getText()+"\n"+disDate.getValue().toString()+"\n"+disFrom.getText()+"\n");
                print.close();
        } catch (FileNotFoundException e) {}
         disName.setText(null);
         disReff.setText(null);
         disTo.setText(null);
        disNote.setText(null);
         disDate.setValue(null);
         disFrom.setText(null);
         

     }}
      // warning message for null validation
     private boolean validateFields(){
        if( disName.getText().isEmpty() | disReff.getText().isEmpty()|
                 disTo.getText().isEmpty()|disNote.getText().isEmpty()|  disDate.getEditor().getText().isEmpty()|disFrom.getText().isEmpty())
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
                Files.copy(file.toPath(),Paths.get("user data\\receptionist\\postal\\dispatched post\\cv\\"+disReff.getText()+".pdf"));
            } catch (Exception ioException) {
               ioException.printStackTrace();
            }
          
          //create new object file1
          File file1 = new File(String.valueOf(path));
       
        fileChooser.setInitialFileName(disReff.getText()+".pdf");  
        //getting type of files 
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pdf file","*.pdf","*.PDF"));
        
         
    }
      
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //show validation status
        RequiredFieldValidator validator = new RequiredFieldValidator();
        NumberValidator numvalidator = new  NumberValidator();
        
        
       
        //validation for Address
        disTo.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        disTo.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                disTo.validate();
                } 
            }
        });
        //validation field for Reffereence Number
        disReff.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        disReff.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                disReff.validate();
                } 
            }
        });
        //validation Field for To
        disName.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        disName.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                disName.validate();
                } 
            }
        }); 
        //validation field for Note
        disNote.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        disNote.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                disNote.validate();
                } 
            }
        }); 
        //validation field for Date
        disDate.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        disDate.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                disDate.validate();
                } 
            }
        }); 
        //validation field for From
        disFrom.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        disFrom.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                disFrom.validate();
                } 
            }
        }); 
    }    
    
}
