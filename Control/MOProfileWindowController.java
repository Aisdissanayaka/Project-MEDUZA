/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
public class MOProfileWindowController extends DashboardUIController implements Initializable {
    
    
     //declare variables
     @FXML
    private JFXTextField firstNameTxt;

    @FXML
    private JFXTextField lastNameTxt;
    
    @FXML
    private ComboBox genderBox;

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
    public JFXTextField MOStaffIDTxt;
    
      @FXML
    private ComboBox specialityAreaBox;
    
    @FXML
    public Circle profilePhoto;
    
    @FXML
    public Label nameLbl;
    
    
    
 

    
  // update button. It's update receptionist data
    @FXML
    private void updateBtn(){
        try{
        File file = new File("user data\\receptionist\\data\\"+ MOStaffIDTxt.getText()+".txt");  
        file.delete();
        PrintWriter printer = new PrintWriter(new FileOutputStream(file,true)); 
        
        printer.append(firstNameTxt.getText()+"\n"+lastNameTxt.getText()+"\n"+addressTxt.getText()+"\n"+phoneNumTxt.getText()+"\n"
                +dateOfBirthTxt.getText()+"\n"+ MOStaffIDTxt.getText()+"\n"+ staffEmailTxt.getText()+"\n"+ joinedDateTxt.getText()+"\n"+
                genderBox.getValue()+"\n"+ specialityAreaBox.getValue()+"\n");
           
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
         File fileoutput = new File ("user data\\medical officer\\photo\\" +MOStaffIDTxt.getText()+".jpg");
         BufferedImage BI= SwingFXUtils.fromFXImage(image,null);
         ImageIO.write(BI,"jpg",fileoutput);
         
       
     }
 
      
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       ObservableList<String>list1=FXCollections.observableArrayList("Male","Female");
       genderBox.setItems(list1);
        ObservableList<String>list2=FXCollections.observableArrayList("A","B","C");
       specialityAreaBox.setItems(list2);
    }    


    
    
}
