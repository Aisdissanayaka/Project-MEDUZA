/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminRefSpecAreaController extends DashboardUIController implements Initializable {

        //declare variables
  @FXML
    private JFXTextField addNewTxt;

    @FXML
    private JFXTextArea listTxt;

    
    //add new speciality area to list
    @FXML
    private     void add(ActionEvent event) throws FileNotFoundException, IOException {
         
        
      if(  validateFields()){
        File file1 = new File("user data\\reference\\category.txt");
           PrintWriter print1 = new PrintWriter(new FileOutputStream(file1,true));
           print1.append(addNewTxt.getText()+"\n");
          
           print1.close();
      
        loadData();
        addNewTxt.clear();
    }
    }
    
    
    // view speciality area list
     private void loadData() throws FileNotFoundException, IOException{
         
        Scanner inputFile = new Scanner(new File("user data\\reference\\category.txt"));
        String list = "";
        String c;
        while(inputFile.hasNextLine()){
            c =(inputFile.nextLine()+ "\n");
            list += c ; 
        }
     listTxt.setText(list);
     }
     
      // warning message for null validation
     private boolean validateFields(){
         
   if(addNewTxt.getText().isEmpty())
         {
              Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Validate Fields");
             alert.setHeaderText(null);
             alert.setContentText("Please Enter Into The Field");
             alert.showAndWait();
             return false;
            }
        return true;
         }
     

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      try {
          loadData();
      } catch (IOException ex) {
          Logger.getLogger(AdminRefSpecAreaController.class.getName()).log(Level.SEVERE, null, ex);
      }

       //show validation status
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Required Field");
      
         addNewTxt.getValidators().add(validator);

          addNewTxt.focusedProperty().addListener(new ChangeListener <Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                addNewTxt.validate();
                }}
        });

        
    }

}  
    

