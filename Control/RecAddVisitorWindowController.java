/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Visitor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
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
public class RecAddVisitorWindowController extends DashboardUIController implements Initializable {
    
    //create new object as fileChooser           
    FileChooser fileChooser = new FileChooser();
    Stage primaryStage = new Stage();
    
    
   // Declaring Varible 
    
    @FXML
    private JFXTextField visID;

    @FXML
    private JFXDatePicker visDate;

    @FXML
    private JFXTimePicker inTime;

    @FXML
    private JFXTextArea visNote;

    @FXML
    private JFXTextField visName;

    @FXML
    private JFXTimePicker outTime;
    
    @FXML
    private File path;
    
    @FXML
    private JFXButton btnSave;
    
    @FXML
    private JFXButton btnLoad;
    
  
    //Submit Button Action Methode
    
    @FXML
    public void openFile(ActionEvent event2) throws IOException {
        
        Visitor visitorObjF = new Visitor();
        
        
        visitorObjF.addFile(event2);
        
        
    }
    
    @FXML
    public void submitBtn(ActionEvent event) throws IOException {
        if(validateFields()){
        try{
        Visitor visitorObj = new Visitor();
        
        visitorObj.setNic(visID.getText());
        visitorObj.setName(visName.getText());
        visitorObj.setNote(visNote.getText());
        visitorObj.setInTime(inTime.getValue().toString());
        visitorObj.setOutTime(outTime.getValue().toString());
        visitorObj.setDate(visDate.getValue().toString());
        
        visitorObj.addVisitor(event);
        
        visID.setText(null);
        visName.setText(null);
        visNote.setText(null);
        visDate.setValue(null);
        inTime.setValue(null);
        outTime.setValue(null);
        
        }
        catch(Exception e){
            System.out.println("Error");}
    } }
    
    
    //opening and saving document file    
    @FXML
    public void openedFile(ActionEvent actionEvent) throws IOException {
       
       
        fileChooser.setInitialDirectory(new File("C:\\Users\\"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pdf file","*.pdf","*.PDF"));

        File file = fileChooser.showOpenDialog(primaryStage);
       // File desination = fileChooser.showSaveDialog(primaryStage);
        path=file.getAbsoluteFile();
        
        
         //saving file given path
          try {
                Files.copy(file.toPath(),Paths.get("user data\\receptionist\\postal\\received postal\\cv\\"+visID.getText()+".pdf"));
            } catch (Exception ioException) {
               ioException.printStackTrace();
            }
          
          //create new object file1
          File file1 = new File(String.valueOf(path));
       
        fileChooser.setInitialFileName(visID.getText()+".pdf");  
        //getting type of files 
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pdf file","*.pdf","*.PDF"));
        
         
    }
        // warning message for null validation
     private boolean validateFields(){
         
   if(visName.getText().isEmpty() |  visID.getText().isEmpty()| visDate.getEditor().getText().isEmpty()|
          inTime.getEditor().getText().isEmpty()| outTime.getEditor().getText().isEmpty() |visNote.getText().isEmpty())
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
        
             //show validation status
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Required Field");
        
        
       
         visID.getValidators().add(validator);
        visName.getValidators().add(validator);
        visNote.getValidators().add(validator);
        inTime.getValidators().add(validator);
       outTime.getValidators().add(validator);
        visDate.getValidators().add(validator);
        
       
        
         visID.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                 visID.validate();
                }}
        });       
       
        visName.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                visName.validate();
                }}
        });
  
        visNote.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
               visNote.validate();
                }}
        });
       
        inTime.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                inTime.validate();
                }}
        }); 
       
        outTime.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
               outTime.validate();
                }}
        }); 
       
        visDate.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                visDate.validate();
                }}
        }); 
      
    }    
    
}
