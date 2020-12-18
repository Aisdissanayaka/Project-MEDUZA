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
public class RecAddReceivedPostController extends DashboardUIController implements Initializable {
    
    //create new object as fileChooser           
    FileChooser fileChooser = new FileChooser();
    Stage primaryStage = new Stage();
    
    
    //Declaring Variable
    @FXML
    private JFXTextField postName;

    @FXML
    private JFXTextArea postNote;

    @FXML
    private JFXTextField postReff;

    @FXML
    private JFXTextArea postFrom;

    @FXML
    private JFXTextField postTo;
    
    @FXML
    private JFXDatePicker postDate;
    
    @FXML
    private File path;
    
    @FXML
    private JFXButton btnSave;
    
    @FXML
    private JFXButton btnLoad;
    
    
    //Submit Button Action Methode    
    @FXML  
      public void submitBtn(ActionEvent event) {
          if(validateFields()){
          //write values in another text file
         try {
            File file = new File ("user data\\receptionist\\postal\\received postal\\data\\"+postReff.getText()+".txt");
                PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
                print.append(postName.getText()+"\n"+postReff.getText()+"\n"+postFrom.getText()+"\n"+postNote.getText()+"\n"+postTo.getText()+"\n"+postDate.getValue().toString()+"\n");
                print.close();
        } catch (FileNotFoundException e) {
        }
         
         //setting values to declared variables
        postName.setText(null);
        postNote.setText(null);
        postReff.setText(null);
        postFrom.setText(null);
        postTo.setText(null);
        postDate.setValue(null);
     }}
     // warning message for null validation
     private boolean validateFields(){
        if(   postName.getText().isEmpty() | postNote.getText().isEmpty()|
                postReff.getText().isEmpty()|postFrom.getText().isEmpty()|  postDate.getEditor().getText().isEmpty()|postTo.getText().isEmpty())
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
                Files.copy(file.toPath(),Paths.get("user data\\receptionist\\postal\\received postal\\cv\\"+postReff.getText()+".pdf"));
            } catch (Exception ioException) {
               ioException.printStackTrace();
            }
          
          //create new object file1
          File file1 = new File(String.valueOf(path));
       
        fileChooser.setInitialFileName(postReff.getText()+".pdf");  
        //getting type of files 
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pdf file","*.pdf","*.PDF"));
        
         
    }
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //show validation status
        RequiredFieldValidator validator = new RequiredFieldValidator();
        NumberValidator numvalidator = new  NumberValidator();
        
        
       
        //validation for Address
       postName.getValidators().add(validator);
        validator.setMessage("Required Field");
        
       postName.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                postName.validate();
                } 
            }
        });
        //validation field for Reffereence Number
        postNote.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        postNote.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                postNote.validate();
                } 
            }
        });
        //validation Field for To
       postReff.getValidators().add(validator);
        validator.setMessage("Required Field");
        
       postReff.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                postReff.validate();
                } 
            }
        }); 
        //validation field for Note
       postFrom.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        postFrom.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                postFrom.validate();
                } 
            }
        }); 
        //validation field for Date
       postTo.getValidators().add(validator);
        validator.setMessage("Required Field");
        
       postTo.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
               postTo.validate();
                } 
            }
        }); 
        //validation field for From
        postDate.getValidators().add(validator);
        validator.setMessage("Required Field");
        
         postDate.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                 postDate.validate();
                } 
            }
        }); 
    }    
    
}
