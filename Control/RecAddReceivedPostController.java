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
public class RecAddReceivedPostController extends DashboardUIController implements Initializable {
    
    //Declaring Variable
    @FXML
    private JFXTextField postName;

    @FXML
    private JFXTextArea postNote;

    @FXML
    private JFXTextField postReff;

    @FXML
    private JFXTextArea postFrom;

    @FXML
    private JFXTextField postTo;
    
    //Submit Button Action Methode    
    @FXML  
      public void submitBtn(ActionEvent event) {
         try {
            File file = new File ("user data\\receptionist\\postal\\received postal\\"+postReff.getText()+".txt");
                PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
                print.append(postName.getText()+"\n"+postReff.getText()+"\n"+postFrom.getText()+"\n"+postNote.getText()+"\n"+postTo.getText()+"\n");
                print.close();
        } catch (FileNotFoundException e) {
        }

     }
    
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
