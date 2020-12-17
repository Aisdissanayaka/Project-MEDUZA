/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.UserLoginController.staticUserName;
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
public class RecAppointmentWindowController extends DashboardUIController implements Initializable {
    
    //Triggers the Add new appointmend button in the appointment window
    @FXML
    public void addNewAppointment(ActionEvent event) throws IOException{
       
            
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecAddAppointmentWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
