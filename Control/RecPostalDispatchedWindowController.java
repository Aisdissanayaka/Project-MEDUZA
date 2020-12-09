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
public class RecPostalDispatchedWindowController extends DashboardUIController implements Initializable {
    
    
    //Trigers the Dispatched postal side window in the postal window
    @FXML
    public void DispatchedpostalBtn(ActionEvent event) throws IOException{
        Parent dispatchedPostalWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/RecPostalDispatchedWindow.fxml"));
        Scene dispatchedPostalWindowViewScene = new Scene(dispatchedPostalWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(dispatchedPostalWindowViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    //Trigers the add new received post window
    @FXML
    public void addReceivedPostBtn(ActionEvent event) throws IOException{
        Parent signUpAsParent =  FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/RecAddReceivedPost.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
     //Trigers the add new dispatched post window
    @FXML
    public void addDispatchedPostBtn(ActionEvent event) throws IOException{
        Parent addDispatchedPostWindow =  FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/RecAddDispatchedPostal.fxml"));
        Scene addDispatchedPostWindowViewScene = new Scene(addDispatchedPostWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addDispatchedPostWindowViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
