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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;



public class PatAddAppointmentWindowController extends DashboardUIController implements Initializable {
    
//Declaring the components in the window    
    @FXML
    private JFXTextField name;

    @FXML
    private JFXDatePicker appDate;

    @FXML
    private JFXTimePicker appTime;

    @FXML
    private ComboBox<String> specAreaCombo;

    @FXML
    private JFXTextArea Symptoms;

    @FXML
    private JFXTextField userID;
    
    
      
      //Adding new appointment - Submit Button Action Methode    
      @FXML  
      public void submitBtn(ActionEvent event) {
//          //write values in another text file
//         try {
//            File file = new File ("user data\\appointment\\"+userID.getText()+".txt");
//                PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
//                print.append(userID.getText()+"\n"+name.getText()+"\n"+appDate.getValue()+"\n"+appTime.getValue()+"\n"+specAreaCombo.getValue()+"\n"+Symptoms.getText()+"\n");
//                print.close();
//        } catch (FileNotFoundException e) {
//        }

     }
    
    
    
    @Override
       public void initialize(URL url, ResourceBundle rb) {
           
      //Combo-box data foe the Medical officer speciality     
       ObservableList<String>list1=FXCollections.observableArrayList("A","B","C","D");
        specAreaCombo.setItems(list1);
        
        
    }    
    
}
