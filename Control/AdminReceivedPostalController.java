/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
          docCol.setCellValueFactory(new PropertyValueFactory<Postal,String>("Document"));
          optionsCol.setCellValueFactory(new PropertyValueFactory<Postal,String>("Options"));
       
          receivedPostTableAdmin.setItems(recievedPostal);
          
             
         }catch(Exception e){}
        
    }    
    
}
