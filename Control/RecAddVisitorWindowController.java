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
import com.jfoenix.controls.JFXTimePicker;
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
    public void submitBtn(ActionEvent event) {
         try {
            File file = new File ("user data\\visitors\\data\\"+visName.getText()+".txt");
                PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
                print.append(visName.getText()+"\n"+visID.getText()+"\n"+visDate.getValue()+"\n"+inTime.getValue()+"\n"+outTime.getValue()+"\n"+visNote.getText()+"\n");
                print.close();
        } catch (FileNotFoundException e) {
        }

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
                Files.copy(file.toPath(),Paths.get("user data\\visitors\\cv\\"+visName.getText()+".doc"));
            } catch (Exception ioException) {
               ioException.printStackTrace();
            }
          
          //create new object file1
          File file1 = new File(String.valueOf(path));
       
        fileChooser.setInitialFileName(visName.getText()+".doc");  
        //getting type of files 
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("doc file","*.doc","*.docx"));
        
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
