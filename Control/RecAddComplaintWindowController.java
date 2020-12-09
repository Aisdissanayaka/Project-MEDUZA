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
import java.time.LocalDate;
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
    private ComboBox comTypeBox;

    @FXML
    private JFXTextField phoneNumTxt;

    @FXML
    private JFXTextArea descriptionTxt;

    @FXML
    private JFXTextArea noteTxt;
    
    private LocalDate date;
    
    
    //submit button. It's writes complaints data to file
     @FXML
    public void submitBtn(ActionEvent event){
        try{
         File file = new File("user data\\complaint\\"+ LocalDate.now()+" " +nameTxt.getText() +".txt"); 
        PrintWriter printer = new PrintWriter(new FileOutputStream(file,true));  
        printer.append(date.now()+"\n"  + comTypeBox.getValue()+"\n"  + nameTxt.getText()+ "\n" +  phoneNumTxt.getText()+"\n"+ descriptionTxt.getText()+"\n"+ actionTakenTxt.getText() + "\n"+
                         noteTxt.getText()+ "\n");
             printer.close();
        }catch(FileNotFoundException e){}
        
        comTypeBox.setValue(null);
        nameTxt.setText(null);
        descriptionTxt.setText(null);
        noteTxt.setText(null);
        phoneNumTxt.setText(null);
        actionTakenTxt.setText(null);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         ObservableList<String>list=FXCollections.observableArrayList("Type 1","Type 2", "Type 3");
       comTypeBox.setItems(list);
    }    
    
}
