/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RecAddVisitorWindowController extends DashboardUIController implements Initializable {
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
    
    
    //Submit Button Action Methode
    
    @FXML
    public void submitBtn(ActionEvent event) {
         try {
            File file = new File ("user data\\visitors\\"+visName.getText()+".txt");
                PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
                print.append(visName.getText()+"\n"+visID.getText()+"\n"+visDate.getValue()+"\n"+inTime.getValue()+"\n"+outTime.getValue()+"\n"+visNote.getText()+"\n");
                print.close();
        } catch (FileNotFoundException e) {
        }

     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
