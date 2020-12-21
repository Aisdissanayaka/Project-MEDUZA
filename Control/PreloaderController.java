/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.jfoenix.controls.JFXProgressBar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 * FXML Controller class
 *
 * @author Ashan Isuru
 */
public class PreloaderController implements Initializable {
@FXML
    private Label progress;
    
    public static Label label;
    
    
    @FXML
    private JFXProgressBar progressBar;
    
    public static ProgressBar statProgressBar;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       label = progress ;
      // progressBar.setStyle("-fx-accent: yellow;");
       statProgressBar = progressBar;
       
    }    
    
}
