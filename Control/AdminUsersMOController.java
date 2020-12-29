/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.UserLoginController.profilePicture;
import static Control.UserLoginController.staticUserName;
import Model.MedicalOfficer;
import Model.Patient;
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
public class AdminUsersMOController extends DashboardUIController implements Initializable {

    public static String moID;
    @FXML
    private TableView<MedicalOfficer> moTable;

    @FXML
    private TableColumn<MedicalOfficer, String> idCol;

    @FXML
    private TableColumn<MedicalOfficer, String>specCol;

    @FXML
    private TableColumn<MedicalOfficer, String> fNameCol;

    @FXML
    private TableColumn<MedicalOfficer, String> lNameCol;

    @FXML
    private TableColumn<MedicalOfficer, String> genderCol;

    @FXML
    private TableColumn<MedicalOfficer, String> dobCol;

    @FXML
    private TableColumn<MedicalOfficer, String> addressCol;

    @FXML
    private TableColumn<MedicalOfficer, String> phoneCol;

    @FXML
    private TableColumn<MedicalOfficer, String> emailCol;

    @FXML
    private TableColumn<MedicalOfficer, String> pwCol;

    @FXML
    void AdminUserMOEdit(ActionEvent event) throws IOException {
    try{
        ObservableList<MedicalOfficer> allUser,singleUser;
        allUser = moTable.getItems();
        singleUser = moTable.getSelectionModel().getSelectedItems();
        moID = moTable.getSelectionModel().getSelectedItem().getStaffID();
        // all items store in static object in patient class 
        AdminUsersMOEdit.selectUser=(MedicalOfficer)moTable.getSelectionModel().getSelectedItem();
        singleUser.forEach(allUser::remove);
        // load patient edit window   
        FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminUsersMOEdit.fxml"));
        Parent root = loader.load();
        DashboardUIController welcome =loader.getController();
        welcome.showInformation(staticUserName);
        welcome.showProfilePicture(profilePicture);
         
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
        window.centerOnScreen();
        }catch(Exception e){
        
        Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("Selecet Medical Officer and then press edit  button");
        alert.show();
       
       }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
          ArrayList<MedicalOfficer> moArrayList = MedicalOfficer.viewMO();
          
          int postalCount = moArrayList.size();
          
          
             System.out.println(postalCount);
          
          ObservableList<MedicalOfficer> mos = FXCollections.observableArrayList();
          for(int i =0;i< postalCount;i++){
          mos.add(moArrayList.get(i));
      
          }
          idCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("staffID"));
          specCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("specialityArea"));
          fNameCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("fName"));
          lNameCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("lName"));
          genderCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("gender"));
          dobCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("DOB"));
          addressCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("address"));
          phoneCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("phoneNumber"));
          emailCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("email"));
          pwCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("dateJoined"));
         // optionsCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("options"));
          
       
          moTable.setItems(mos);
          
             
         }catch(Exception e){}
        
    }  
    
}
