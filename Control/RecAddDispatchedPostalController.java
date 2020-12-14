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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
                Files.copy(file.toPath(),Paths.get("user data\\receptionist\\postal\\dispatched post\\cv\\"+disReff.getText()+".doc"));
            } catch (Exception ioException) {
               ioException.printStackTrace();
            }
          
          //create new object file1
          File file1 = new File(String.valueOf(path));
       
        fileChooser.setInitialFileName(disReff.getText()+".doc");  
        //getting type of files 
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("doc file","*.doc","*.docx"));
        
         
    }
      
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
