/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.RecPostalDispatchedWindowController.datePostal;
import static Control.RecPostalWindowController.refNumber;
import static Control.UserLoginController.profilePicture;
import static Control.UserLoginController.staticUserName;
import Model.Postal;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminReceivedPostalController extends DashboardUIController implements Initializable {
    
    @FXML
    private TableView<Postal> receivedPostTableAdmin;

    @FXML
    private TableColumn<Postal, String> refCol;

    @FXML
    private TableColumn<Postal, String>fromCol;

    @FXML
    private TableColumn<Postal, String>fromAddressCol;

    @FXML
    private TableColumn<Postal, String> noteCol;

    @FXML
    private TableColumn<Postal, String> dateCol;

    @FXML
    private TableColumn<Postal, String> toCol;

    @FXML
    private TableColumn<Postal, String> docCol;

    @FXML
    private TableColumn<Postal, String> optionsCol;
    
    @FXML
    public void AdminDispatchedpostalBtn(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminPostalDispatched.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);
    welcome.showProfilePicture(profilePicture);
         

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        
    }
    
     @FXML // received postal delete button
    void deletePostal(ActionEvent event) {

        try{
        
        ObservableList<Postal> allReceived,singleReceived;
        allReceived = receivedPostTableAdmin.getItems();
        singleReceived =receivedPostTableAdmin.getSelectionModel().getSelectedItems();
        refNumber = receivedPostTableAdmin.getSelectionModel().getSelectedItem().getRefferenceNum(); // get refnumber in select row and set it static variable
        datePostal = receivedPostTableAdmin.getSelectionModel().getSelectedItem().getDate();
        Postal appObj = new Postal();            //create object in postal class
        appObj.deletePostal("user data//database//recievedPostals.txt", "user data//database//temp.txt"); //call postal delete methode
        singleReceived.forEach(allReceived::remove); //delete select row
        Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("You deleted "+refNumber.toUpperCase()+"'s Received Posatal..!");
        alert.show();
        }catch(Exception e){
        Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("Selecet Postal and press delete button");
        alert.show();   
        }
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
          ArrayList<Postal> postalArrayList = Postal.viewReceivedPostal();
          
          int postalCount = postalArrayList.size();
          ObservableList<Postal> recievedPostal = FXCollections.observableArrayList();
          for(int i =0;i< postalCount;i++){
          recievedPostal.add(postalArrayList.get(i));
      
          }
          refCol.setCellValueFactory(new PropertyValueFactory<Postal,String>("RefferenceNum"));
          fromCol.setCellValueFactory(new PropertyValueFactory<Postal,String>("From"));
          fromAddressCol.setCellValueFactory(new PropertyValueFactory<Postal,String>("Address"));
          noteCol.setCellValueFactory(new PropertyValueFactory<Postal,String>("Note"));
          dateCol.setCellValueFactory(new PropertyValueFactory<Postal,String>("Date"));
          toCol.setCellValueFactory(new PropertyValueFactory<Postal,String>("To"));
         // docCol.setCellValueFactory(new PropertyValueFactory<Postal,String>("Document"));
          //optionsCol.setCellValueFactory(new PropertyValueFactory<Postal,String>("Options"));
       
          receivedPostTableAdmin.setItems(recievedPostal);
          
             
         }catch(Exception e){}
        
    }    
    
}
