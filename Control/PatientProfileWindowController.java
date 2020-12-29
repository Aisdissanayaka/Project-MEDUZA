/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Patient;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PatientProfileWindowController extends DashboardUIController implements Initializable {
    
    
     //declare variables
 
    @FXML
    private JFXTextField firstNameTxt;

    @FXML
    private JFXTextField lastNameTxt;

    @FXML
    private JFXTextField phoneNumTxt;

    @FXML
    private JFXTextField addressTxt;

    @FXML
    private JFXTextField dateOfBirthTxt;

    @FXML
    private JFXTextField NICTxt;

    @FXML
    private ComboBox genderBox;

    @FXML
    private ComboBox bloodGroupBox;
    
    @FXML
    private JFXTextArea allergiesTxt;
    
    @FXML
    public Circle profilePhoto;
    
   
    
    


    
  // update button. It's update receptionist data
    @FXML
    private void updateBtn()throws IOException{
        
        if(validateFields()&&validatePhoneNum()){
        
    try {
            
    Patient obj = new Patient(); //create object in patient class and call edit patient methode
    obj.editPatient("user data//database//patients.txt", "user data//database//temp.txt", NICTxt.getText(), firstNameTxt.getText(), lastNameTxt.getText(), genderBox.getValue().toString(), dateOfBirthTxt.getText(),
            phoneNumTxt.getText(),addressTxt.getText(),bloodGroupBox.getValue().toString(),allergiesTxt.getText());
    Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
    alert.setContentText("Updated Profile..!");
    alert.show();
            
        } catch (Exception e) {
        }
         

        
        
    }
    }
    //warnig message to invalide Phone Number 
     private boolean validatePhoneNum(){
         Pattern p=Pattern.compile("[0][0-9]{9}");
         Matcher m = p.matcher(phoneNumTxt.getText());
         if(m.find() && m.group().equals(phoneNumTxt.getText())){
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
     // warning message for null validation
     private boolean validateFields(){
         
   if(firstNameTxt.getText().isEmpty() |lastNameTxt.getText().isEmpty()| 
       phoneNumTxt.getText().isEmpty()| addressTxt.getText().isEmpty())
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
     //upload to photograph
     @FXML
     private void addPhoto(ActionEvent event)throws IOException{
         Stage stage =new Stage();
         FileChooser fileChooser =new FileChooser();
         fileChooser.setTitle("Choose an Image");
         
         fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("jpg","*.jpg","*.png"));
         
         File selectedFile = fileChooser.showOpenDialog(stage);
         
         Image OriginalPhoto = new Image(selectedFile.toURI().toString());
      
         Image img1= new Image(selectedFile.toURI().toString());
         saveToFile(img1,"photo");
         
         
         // set new profile picture
          profilePhoto.setFill(new ImagePattern(img1));
          
         
     }
     //save photogrgaph
     private void saveToFile(Image image,String name)throws IOException{
         File fileoutput = new File ("user data\\patient\\photo\\" +NICTxt.getText()+".jpg");
         BufferedImage BI= SwingFXUtils.fromFXImage(image,null);
         ImageIO.write(BI,"jpg",fileoutput);
         
       
     }
 
      
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       ObservableList<String>list1=FXCollections.observableArrayList("Male","Female","Other");
       genderBox.setItems(list1);
       
       ObservableList<String>list2=FXCollections.observableArrayList("A+","O+","B+","AB+","A-","O-","B-","AB-");
       bloodGroupBox.setItems(list2);
    }    


    
    
}
