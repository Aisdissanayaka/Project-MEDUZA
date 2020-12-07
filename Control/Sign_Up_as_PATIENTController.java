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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ashan Isuru
 */
public class Sign_Up_as_PATIENTController implements Initializable {

    
    
    
    
     // Cancel Button. it's go to sign up as menu  
    public void cancelBtn(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Sign_Up_as.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
