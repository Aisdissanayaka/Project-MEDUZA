/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class Sign_Up_as_RECEPTIONISTController extends DashboardUIController implements Initializable {
    
     //create new object as fileChooser           
    FileChooser fileChooser = new FileChooser();
    Stage primaryStage = new Stage();
    
    ObservableList list1 =FXCollections.observableArrayList();

    @FXML
    private JFXTextField recFirstNametxt;
    @FXML
    private JFXTextField recLastNametxt;
    @FXML
    private JFXTextField recAddresstxt;
    @FXML
    private JFXTextField recPhoneNumtxt;
    @FXML
    private JFXTextField recNICtxt;
    @FXML
    private JFXTextField recStaffIDtxt;
    @FXML
    private JFXTextField recStaffEmailtxt;
    @FXML
    private JFXDatePicker recDateOfBirth;
    @FXML
    private JFXDatePicker recDateOfJoin;
    @FXML
    private JFXComboBox<String> series;
    @FXML
    private Button recbtnSave;
    @FXML
    private ImageView img;
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
    //write details in the text file
    @FXML
    private void signupbtn(ActionEvent event) {
        String value = recDateOfJoin.getValue().toString();
        String value1 = recDateOfBirth.getValue().toString();
       
        if(validateFields()){
        
         try
       {
           File file = new File("user data\\receptionist\\data\\"+recStaffIDtxt.getText()+".txt");
           PrintWriter printer = new PrintWriter(new FileOutputStream(file,true));
          
           printer.append(recFirstNametxt.getText()+"\n"+""+recLastNametxt.getText()
                   +"\n"+""+recAddresstxt.getText()+"\n"+""+recPhoneNumtxt.getText()+"\n"+""+recDateOfBirth.getValue().toString()+"\n"+""+series.getValue()+"\n"+""+recStaffIDtxt.getText()
                   +"\n"+""+recStaffEmailtxt.getText()+"\n"+""+recDateOfJoin.getValue().toString()+"\n");
           printer.close();
          
            
        //Write credentials file of receptionist
        try{
         
         FileWriter fw = new FileWriter("user data\\receptionist\\credentials\\receptionistlogin.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.write(recStaffIDtxt.getText()+","+recStaffIDtxt.getText()+"\n");
         pw.close();
         }catch(FileNotFoundException  e){}
       }
         
        catch(Exception e){}
         
         recFirstNametxt.setText(null);
         recLastNametxt.setText(null);
         recAddresstxt.setText(null);
         recPhoneNumtxt.setText(null);
         recDateOfBirth.setValue(null);
         series.setValue(null);
         recStaffIDtxt.setText(null);
         recStaffEmailtxt.setText(null);
         recDateOfJoin.setValue(null);        
         
                 
      }}
    //Gender drop down list
     private void loadData(){
        list1.removeAll(list1);
        String a="Male";
        String b="Female";
        String c="Other";
        list1.addAll(a,b,c);
        series.getItems().addAll(list1);
        
     }
     // warning message for null validation
     private boolean validateFields(){
         
         
         
          
         if(recFirstNametxt.getText().isEmpty() | recLastNametxt.getText().isEmpty()|
                 recAddresstxt.getText().isEmpty()|recPhoneNumtxt.getText().isEmpty()| recStaffIDtxt.getText().isEmpty()|recStaffEmailtxt.getText().isEmpty())
         {
              Alert alert = new Alert(AlertType.WARNING);
             alert.setTitle("Validate Fields");
             alert.setHeaderText(null);
             alert.setContentText("Please Enter Into The Fields");
             alert.showAndWait();
             
            
             
             return false;
            
         }
         
         return true;
         
          }
     
     //upload to photograph
     @FXML
     private void onclickbtnsave(ActionEvent event)throws IOException{
         Stage stage =new Stage();
         FileChooser fileChooser =new FileChooser();
         fileChooser.setTitle("Choose an Image");
         
         fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("jpg","*.jpg","*.png"));
         
         File selectedFile = fileChooser.showOpenDialog(stage);
         
         Image OriginalPhoto = new Image(selectedFile.toURI().toString());
      
         Image img1= new Image(selectedFile.toURI().toString(),100,100,false,false);
         saveToFile(img1,"photo");
         
     }
     //save photogrgaph
     private void saveToFile(Image image,String name)throws IOException{
         File fileoutput = new File ("user data\\Receptionist\\photo\\"+recStaffIDtxt.getText()+".jpg");
         BufferedImage BI= SwingFXUtils.fromFXImage(image,null);
         ImageIO.write(BI,"jpg",fileoutput);
         
    }
     
     
      //opening and saving document file    
    @FXML
    public void openFile(ActionEvent actionEvent) throws IOException {
       
       
        fileChooser.setInitialDirectory(new File("C:\\Users\\"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("doc file","*.doc","*.docx"));

        File file = fileChooser.showOpenDialog(primaryStage);
       // File desination = fileChooser.showSaveDialog(primaryStage);
        path=file.getAbsoluteFile();
        
        
         //saving file given path
          try {
                Files.copy(file.toPath(),Paths.get("user data\\receptionist\\cv\\"+recStaffIDtxt.getText()+".doc"));
            } catch (Exception ioException) {
               ioException.printStackTrace();
            }
          
          //create new object file1
          File file1 = new File(String.valueOf(path));
       
        fileChooser.setInitialFileName(recStaffIDtxt.getText()+".doc");  
        //getting type of files 
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("doc file","*.doc","*.docx"));
        
         
    }
     
  @Override
    public void initialize(URL url, ResourceBundle rb) {
         loadData();
         
         //show validation status
        RequiredFieldValidator validator = new RequiredFieldValidator();
        NumberValidator numvalidator = new  NumberValidator();
        
        //validation for phone number
        recPhoneNumtxt.getValidators().add(numvalidator);
        numvalidator.setMessage("Invalied Number");
        
        recPhoneNumtxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                recPhoneNumtxt.validate();
                } 
            }
        });       
        //validation for First name
        recFirstNametxt.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        recFirstNametxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                recFirstNametxt.validate();
                } 
            }
        });
        //validation field for Last name
        recLastNametxt.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        recLastNametxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                recLastNametxt.validate();
                } 
            }
        });
        //validation Field for Address
        recAddresstxt.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        recAddresstxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                recAddresstxt.validate();
                } 
            }
        }); 
        //validation field for staffID
        recStaffIDtxt.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        recStaffIDtxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                recStaffIDtxt.validate();
                } 
            }
        }); 
        //validation Field for Staff Email Address
        recStaffEmailtxt.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        recStaffEmailtxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                recStaffEmailtxt.validate();
                } 
            }
        }); 
        
        //validation field for phone Number
        recPhoneNumtxt.getValidators().add(validator);
        validator.setMessage("Required Field");
        
        recPhoneNumtxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                recPhoneNumtxt.validate();
                } 
            }
        }); 
        //validation of date of Join
        recDateOfJoin.getValidators().add(validator);
        validator.setMessage("Required Field");
        
       recDateOfJoin.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                recDateOfJoin.validate();
                } 
            }
        }); 
      //validation of date of birth
       recDateOfBirth.getValidators().add(validator);
        validator.setMessage("Required Field");
        
       recDateOfBirth.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                recDateOfBirth.validate();
                } 
            }
        });
       //validation of gender
       series.getValidators().add(validator);
        validator.setMessage("Required Field");
        
       series.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                series.validate();
                } 
            }
        }); 
       }

   
} 

    