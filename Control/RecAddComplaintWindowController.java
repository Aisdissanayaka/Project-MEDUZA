/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Complaint;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RecAddComplaintWindowController extends DashboardUIController implements Initializable {
    
    //create new object as fileChooser           
    FileChooser fileChooser = new FileChooser();
    Stage primaryStage = new Stage();
    
    // declare variables
    @FXML
    private JFXTextField nameTxt;

    @FXML
    private JFXTextArea actionTakenTxt;

     @FXML
    private JFXComboBox<String> comTypeBox;

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
    
     @FXML
    private JFXDatePicker complaintDate;
    
    //submit button. It's writes complaints data to file
    @FXML
    public void submitBtn(ActionEvent event)throws  IOException{
        if(validateFields()&& validatePhoneNum()){
        
        Complaint recCom=new Complaint();
        recCom.setDate(date.now().toString());
        recCom.setType(comTypeBox.getValue().toString());
        recCom.setName(nameTxt.getText());
        recCom.setPhoneNo(phoneNumTxt.getText());
        recCom.setDescription(descriptionTxt.getText());
        recCom.setDate(complaintDate.getValue().toString());
        recCom.setNote(noteTxt.getText());
        
        recCom.addComplaint();
        
        comTypeBox.setValue(null);
        nameTxt.setText(null);
        phoneNumTxt.setText(null);
        descriptionTxt.setText(null);
        noteTxt.setText(null);
        complaintDate.setValue(null);
        
        
    }}
    
     // warning message for null validation
     private boolean validateFields(){
         
          if(nameTxt.getText().isEmpty() | descriptionTxt.getText().isEmpty()|
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
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pdf file",".pdf",".PDF"));

        File file = fileChooser.showOpenDialog(primaryStage);
       // File desination = fileChooser.showSaveDialog(primaryStage);
        path=file.getAbsoluteFile();
        
        
         //saving file given path
          try {
                Files.copy(file.toPath(),Paths.get("user data\\complaint\\cv\\"+LocalDate.now()+" " +nameTxt.getText() +".pdf"));
            } catch (Exception ioException) {
               ioException.printStackTrace();
            }
          
          //create new object file1
          File file1 = new File(String.valueOf(path));
       
        fileChooser.setInitialFileName(LocalDate.now()+" " +nameTxt.getText() +".pdf");  
        //getting type of files 
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pdf file",".pdf",".PDF"));
        
         
    }

     ObservableList list1=FXCollections.observableArrayList();
    
     //Complaint type drop down list
     private void loadData() throws FileNotFoundException, IOException{
        list1.removeAll(list1);
        
        File myfile = new File("user data\\reference\\complaint.txt"); 
    BufferedReader abc = new BufferedReader(new FileReader(myfile));
     String s;
        while((s=abc.readLine())!=null) {
            list1.add(s);
      
     }
        comTypeBox.getItems().addAll(list1);
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //add compalint type combo box values
        try {
            loadData();
        } catch (IOException ex) {
            Logger.getLogger(RecAddComplaintWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
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
      complaintDate.getValidators().add(validator);
        comTypeBox.getValidators().add(validator);
        
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
       
       complaintDate.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
               complaintDate.validate();
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
       
        comTypeBox.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                comTypeBox.validate();
                }}
        }); 
        
       
    }    
    
}