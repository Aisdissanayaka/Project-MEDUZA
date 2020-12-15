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
    public void openFile(ActionEvent event2) throws IOException {
        
        Visitor visitorObjF = new Visitor();
        
        visitorObjF.setNic(visID.getText());
        visitorObjF.setName(visName.getText());
        visitorObjF.setNote(visNote.getText());
        visitorObjF.setInTime(inTime.getValue().toString());
        visitorObjF.setOutTime(outTime.getValue().toString());
        visitorObjF.setDate(visDate.getValue().toString());
        visitorObjF.addFile(event2);
    }
    
    @FXML
    public void submitBtn(ActionEvent event) throws FileNotFoundException {
        try{
        Visitor visitorObj = new Visitor();
        
        visitorObj.setNic(visID.getText());
        visitorObj.setName(visName.getText());
        visitorObj.setNote(visNote.getText());
        visitorObj.setInTime(inTime.getValue().toString());
        visitorObj.setOutTime(outTime.getValue().toString());
        visitorObj.setDate(visDate.getValue().toString());
        
        visitorObj.addVisitor(event);}
        catch(Exception e){
            System.out.println("Error");}
    } 
       
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
