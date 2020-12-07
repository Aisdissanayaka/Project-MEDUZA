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
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RecAddAppointmentWindowController implements Initializable {
    
    
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

    @FXML
    public void Signoutbtn(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/UserLogin.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
      @FXML
    public void Profilebtn(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/ReceptionistProfileWindow.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    @FXML
    public void homeBtn(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Dashboards/RecDashboardWelcome.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    
    @FXML
    public void AppointmentBtn(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/RecAppointmentWindow.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
      @FXML  
      public void submitBtn(ActionEvent event) {
         try {
            File file = new File ("user data\\Appointment\\"+userID.getText()+".txt");
                PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
                print.append(userID.getText()+"\n"+name.getText()+"\n"+appDate.getValue()+"\n"+appTime.getValue()+"\n"+specAreaCombo.getValue()+"\n"+Symptoms.getText()+"\n");
                print.close();
        } catch (FileNotFoundException e) {
        }

     }
    
    
    
    @Override
       public void initialize(URL url, ResourceBundle rb) {
           
           
       ObservableList<String>list1=FXCollections.observableArrayList("A","B","C","D");
        specAreaCombo.setItems(list1);
        
        
    }    
    
}
