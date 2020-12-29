/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.UserLoginController.primaryKey;
import Model.MedicalOfficer;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class MOProfileWindowController extends DashboardUIController implements Initializable {
    
    
     //declare variables
     @FXML
    private JFXTextField firstNameTxt;

    @FXML
    private JFXTextField lastNameTxt;
    
    @FXML
    private ComboBox<String> genderBox;

    @FXML
    private JFXTextField dateOfBirthTxt;

    @FXML
    private JFXTextField phoneNumTxt;

    @FXML
    private JFXTextField addressTxt;
    
    @FXML
    private JFXTextField staffEmailTxt;

    @FXML
    private JFXTextField joinedDateTxt;
    
    @FXML
    public JFXTextField staffIDTxt;
    
    @FXML
    private JFXTextField specialityAreamo;
    
    @FXML
    public Circle profilePhoto;
    
    @FXML
    public Label nameLbl;
    
     @FXML
    private Button view; 
   
    // view button. It's open MO's CV
    @FXML
    private void view(ActionEvent event) {
 
        File file=new File("user data\\medical officer\\cv\\"+primaryKey+".pdf");

        Desktop desktop = Desktop.getDesktop();

        view.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override 
        public void handle(ActionEvent event) { 

        try { 
            desktop.open(file); 
        } catch (IOException ex) { 
            
        }
    }
});}
    
    
  @FXML//ubdate butoon action event
    void updateBtn(ActionEvent event) {
     if(validateFields()&&validatePhoneNum()&&validateEmail()){    
        try{
            
    MedicalOfficer moObj = new MedicalOfficer(); //create object in medical officer class
    
    //assign the value in setters
    moObj.setFName(firstNameTxt.getText());
    
    moObj.setLName(lastNameTxt.getText());
    moObj.setAddress(addressTxt.getText());
    moObj.setPhoneNumber(phoneNumTxt.getText());
    moObj.setDOB(dateOfBirthTxt.getText());
    moObj.setStaffID(staffIDTxt.getText());       
    moObj.setEmail(staffEmailTxt.getText());
    moObj.setDateJoined(joinedDateTxt.getText());
    moObj.setGender(genderBox.getValue().toString());
    moObj.setSpecialityArea (specialityAreamo.getText());
   
    moObj.editMO("user data//database//medicalOfficers.txt", "user data//database//temp.txt"); // call medical officer edit method
   
    Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
    alert.setContentText("Updated medical officer profile.!");
    alert.show();
        }catch(Exception e){
            
        }
     } 
    }
    
     //warnig message to invalide Email Address 
     private boolean validateEmail(){
         Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+");
         Matcher m = p.matcher(staffEmailTxt.getText());
         if(m.find() && m.group().equals(staffEmailTxt.getText())){
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
       phoneNumTxt.getText().isEmpty()| addressTxt.getText().isEmpty()|staffEmailTxt.getText().isEmpty())
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
         File fileoutput = new File ("user data\\medical officer\\photo\\" +primaryKey+".jpg");
         BufferedImage BI= SwingFXUtils.fromFXImage(image,null);
         ImageIO.write(BI,"jpg",fileoutput);
         
       
     }
 
      
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       ObservableList<String>list1=FXCollections.observableArrayList("Male","Female");
       genderBox.setItems(list1);
        
    }    


    
    
}
