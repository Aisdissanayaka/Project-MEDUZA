/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
   
    
    
    
          @FXML
  public void readFiles(ActionEvent event) {
        try  { 
//the file to be opened for reading  
FileInputStream fis=new FileInputStream("user data\\patient\\data\\123.txt");       
Scanner sc=new Scanner(fis);    //file to be scanned  
//returns true if there is another line to read  
while(sc.hasNextLine())  
{     
            //returns the line that was skipped 
firstNameTxt.setText(sc.nextLine()); 
lastNameTxt.setText(sc.nextLine());
addressTxt.setText(sc.nextLine());
NICTxt.setText(sc.nextLine());
bloodGroupBox.setValue(sc.nextLine());
dateOfBirthTxt.setText(sc.nextLine());
genderBox.setValue(sc.nextLine());
phoneNumTxt.setText(sc.nextLine());
allergiesTxt.setText(sc.nextLine());

}  
sc.close();     //closes the scanner  
}  
catch(IOException e)  {} 
} 

    
  // update button. It's update receptionist data
    @FXML
    private void updateBtn(){
        try{
        File file = new File("user data\\patient\\data\\"+ NICTxt.getText()+".txt");  
        file.delete();
        PrintWriter printer = new PrintWriter(new FileOutputStream(file,true)); 
        
         printer.append(firstNameTxt.getText()+"\n"  + lastNameTxt.getText()+ "\n" +  addressTxt.getText()+"\n"+ NICTxt.getText()+"\n"+ bloodGroupBox.getValue() + "\n"+
                 dateOfBirthTxt.getText()+ "\n"+ genderBox.getValue() +"\n" +phoneNumTxt.getText() +"\n"+ allergiesTxt.getText());
             printer.close();
        }catch(FileNotFoundException e){}
        
        
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
         File fileoutput = new File ("user data\\Receptionist\\photo\\" +NICTxt.getText()+".jpg");
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
