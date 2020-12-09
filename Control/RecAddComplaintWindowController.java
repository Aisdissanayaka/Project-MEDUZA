/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RecAddComplaintWindowController extends DashboardUIController implements Initializable {
    
    // declare variables
     @FXML
    private JFXTextField nameTxt;

    @FXML
    private JFXTextArea actionTakenTxt;

    @FXML
    private ComboBox comTypeCombo;

    @FXML
    private JFXTextField phoneNumTxt;

    @FXML
    private JFXTextArea descriptionTxt;

    @FXML
    private JFXTextArea noteTxt;
    
    @FXML
    private JFXButton submitBtn;
    
    private int n=1;
    
    
    //submit button. It writes complaints data to file
     @FXML
    public void submitBtn(ActionEvent event){
        try{
        File file = new File("user data\\complaint\\"+ n++ +".txt");    
        PrintWriter printer = new PrintWriter(new FileOutputStream(file,true));  
        printer.append( comTypeCombo.getValue()+"\n"  + nameTxt.getText()+ "\n" +  phoneNumTxt.getText()+"\n"+ descriptionTxt.getText()+"\n"+ actionTakenTxt.getText() + "\n"+
                         noteTxt.getText()+ "\n");
             printer.close();
        }catch(FileNotFoundException e){}
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ObservableList<String>list=FXCollections.observableArrayList("Type 1","Type 2", "Type 3");
       comTypeCombo.setItems(list);
    }    
    
}
