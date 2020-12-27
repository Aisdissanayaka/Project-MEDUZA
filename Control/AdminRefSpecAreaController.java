/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


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
    void add(ActionEvent event) throws FileNotFoundException, IOException {
         
        File file1 = new File("user data\\reference\\category.txt");
           PrintWriter print1 = new PrintWriter(new FileOutputStream(file1,true));
           print1.append(addNewTxt.getText()+"\n");
          
           print1.close();
      
        loadData();
        addNewTxt.setText(null);
        
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
     

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      try {
          loadData();
      } catch (IOException ex) {
          Logger.getLogger(AdminRefSpecAreaController.class.getName()).log(Level.SEVERE, null, ex);
      }

    }

}  
    

