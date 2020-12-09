/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
public class RecAddDispatchedPostalController extends DashboardUIController implements Initializable {
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
    
    //Add Dispatched Postal Contoller - Submit Button Action Method    
    @FXML  
      public void submitBtn(ActionEvent event) {
         try {
            File file = new File ("user data\\receptionist\\postal\\dispatched post\\"+disReff.getText()+".txt");
                PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
                print.append(disName.getText()+"\n"+disReff.getText()+"\n"+disTo.getText()+"\n"+disNote.getText()+"\n"+disFrom.getText()+"\n");
                print.close();
        } catch (FileNotFoundException e) {
        }

     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
