/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.MedicalOfficer;
import Model.user;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class Sign_Up_as_MOController extends DashboardUIController implements Initializable {
    
    //create new object as fileChooser           
    FileChooser fileChooser = new FileChooser();
    Stage primaryStage = new Stage();
    
    @FXML
    private JFXTextField moFirstName;
    @FXML
    private JFXTextField moLastName;
    @FXML
    private JFXTextField moAddress;
    @FXML
    private JFXTextField moPhoneNum;
    @FXML
    private JFXTextField moStaffID;
    @FXML
    private JFXTextField moStaffEmail;
    @FXML
    private JFXDatePicker moDateOfBirth;
    @FXML
    private JFXDatePicker moDateOfJoin;
    @FXML
    private JFXComboBox<String> moGender;
    @FXML
    private JFXComboBox<String> moSpecialityArea;
    @FXML
    private JFXButton btnAddFile;
    @FXML
    private File path;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnLoad;
    
    
    // Cancel Button. it's go to sign up as menu  
    @FXML
    public void cancelBtn(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Sign_Up_as.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    @FXML
    private void signupbtn(ActionEvent event) throws  IOException {
     //   String value = moDateOfJoin.getValue().toString();//get date as a String value
      //  String value1 = moDateOfBirth.getValue().toString();//get date as a String value
        
        
       if(validateFields()&&validatePhoneNum()&&validateEmail()){
        //write details in a text file
       
           MedicalOfficer moObj = new MedicalOfficer();
           
           moObj.setFName(moFirstName.getText());
           moObj.setLName(moLastName.getText());
           moObj.setAddress(moAddress.getText());
           moObj.setPhoneNumber(moPhoneNum.getText());
           moObj.setDOB(moDateOfBirth.getValue().toString());
           moObj.setStaffID(moStaffID.getText());
           moObj.setEmail(moStaffEmail.getText());
           moObj.setDateJoined(moDateOfJoin.getValue().toString());
           moObj.setGender(moGender.getValue());
           moObj.setSpecialityArea (moSpecialityArea.getValue());
          
           moObj.signup(event);
          
          
         
          //Write credentials file of MO
         try{
         
         FileWriter fw = new FileWriter("user data\\medical officer\\credentials\\medicalofficerlogin.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.write(moStaffID.getText()+","+moStaffID.getText()+"\n");
         pw.close();
         }catch(FileNotFoundException  e){}
         
         
         //setiing values for declared variables
         moFirstName.setText(null);
         moLastName.setText(null);
         moAddress.setText(null);
         moPhoneNum.setText(null);
         moDateOfBirth.setValue(null);
         moStaffID.setText(null);
         moStaffEmail.setText(null);
         moDateOfJoin.setValue(null);        
         moGender.setValue(null);
         moSpecialityArea.setValue(null);
      }}

    @FXML
    private void Select(ActionEvent event) {
        
        String value = moGender.getValue().toString();//get combo gender value as String value
        String value1 = moSpecialityArea.getValue().toString();//get combo specialityArea value as String value
        
     
                 
   }
     //to add a photograph for staff photograph
    @FXML
     private void onclickbtnAddFile(ActionEvent event)throws IOException{
         Stage stage =new Stage();
         FileChooser fileChooser =new FileChooser();
        
         File selectedFile = fileChooser.showOpenDialog(stage);
         
        
         Image moImg1= new Image(selectedFile.toURI().toString());
         saveToFile(moImg1,"Photo");
         
     }
     //saving photogrgaph
     private void saveToFile(Image image,String name)throws IOException{
         File fileoutput = new File ("user data\\medical officer\\photo\\"+moStaffID.getText()+".jpg");
         BufferedImage BI= SwingFXUtils.fromFXImage(image,null);
         ImageIO.write(BI,"jpg",fileoutput);
     
     }
     // warning message for null validation
     private boolean validateFields(){
           if(moFirstName.getText().isEmpty() | moLastName.getText().isEmpty()| moAddress.getText().isEmpty()|
              moPhoneNum.getText().isEmpty()| moDateOfBirth.getEditor().getText().isEmpty()| moStaffID.getText().isEmpty()| moStaffEmail.getText().isEmpty()| moDateOfJoin.getEditor().getText().isEmpty())
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
     //warnig message to invalide Email Address 
     private boolean validateEmail(){
         Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+");
         Matcher m = p.matcher( moStaffEmail.getText());
         if(m.find() && m.group().equals( moStaffEmail.getText())){
           return true;
         }else{
              Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Validate Email");
             alert.setHeaderText(null);
             alert.setContentText("Please Enter The Valid Email");
             alert.showAndWait();
             return false;
         }
       }
        //warnig message to invalide Phone Number 
     private boolean validatePhoneNum(){
         Pattern p=Pattern.compile("[0][0-9]{9}");
         Matcher m = p.matcher(moPhoneNum.getText());
         if(m.find() && m.group().equals(moPhoneNum.getText())){
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
                Files.copy(file.toPath(),Paths.get("user data\\medical officer\\cv\\"+moStaffID.getText()+".pdf"));
            } catch (Exception ioException) {
               ioException.printStackTrace();
            }
          
          //create new object file1
          File file1 = new File(String.valueOf(path));
       
        fileChooser.setInitialFileName(moStaffID.getText()+".pdf");  
        //getting type of files 
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pdf file","*.pdf","*.PDF"));
        
         
    }

   
 @Override
    public void initialize(URL url, ResourceBundle rb) {
       //add combo box values
       ObservableList<String>list=FXCollections.observableArrayList("Male","Female");
       moGender.setItems(list);
       ObservableList<String>list1=FXCollections.observableArrayList("A","B","C");
       moSpecialityArea.setItems(list1);
       
       //show validation status
        RequiredFieldValidator validator = new RequiredFieldValidator();
        NumberValidator numvalidator = new  NumberValidator();
        numvalidator.setMessage("Invalied Number");
         validator.setMessage("Required Field");
        
    
        moPhoneNum.getValidators().add(numvalidator);
        moPhoneNum.getValidators().add(validator);
        moFirstName.getValidators().add(validator);
        moLastName.getValidators().add(validator);
        moAddress.getValidators().add(validator);
        moDateOfBirth.getValidators().add(validator);
        moStaffID.getValidators().add(validator);
        moStaffEmail.getValidators().add(validator);
        moDateOfJoin.getValidators().add(validator);
        moGender.getValidators().add(validator);
        moSpecialityArea.getValidators().add(validator);
       
        moPhoneNum.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                moPhoneNum.validate();
                } }
        });       
        
         moFirstName.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                 moFirstName.validate();
                }}
        });
       
        moLastName.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
               moLastName.validate();
                }}
        });
       
        moAddress.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                moAddress.validate();
                }}
        }); 
      
       moDateOfBirth.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                 moDateOfBirth.validate();
                }}
        }); 
       
       moStaffID.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                moStaffID.validate();
                }}
        }); 
   
        moStaffEmail.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                moStaffEmail.validate();
                }}
        }); 
       moDateOfJoin.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                 moDateOfJoin.validate();
                }}
        });
    moGender.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
               moGender.validate();
                }}
        }); 
        
      moSpecialityArea.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
              moSpecialityArea.validate();
                }}
        }); 


       }
    



} 