/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PatPatientsWindowController extends DashboardUIController implements Initializable {
 
    
    //Triggers the add patient window
    @FXML
    public void AddPatientBtn(ActionEvent event) throws IOException{
        Parent addPatientWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/RecAddPatient.fxml"));
        Scene addPatientWindowViewScene = new Scene(addPatientWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addPatientWindowViewScene);
        window.show();
        window.centerOnScreen();
        
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
