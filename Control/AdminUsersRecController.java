/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.RecPatientsWindowController.patientID;
import static Control.UserLoginController.profilePicture;
import static Control.UserLoginController.staticUserName;
import Model.Appointment;
import Model.Patient;
import Model.Receptionist;
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
public class AdminUsersRecController extends DashboardUIController implements Initializable {
  
    
    public static String receptionistID;
    
    @FXML
    private TableView<Receptionist> receptionistTable;

    @FXML
    private TableColumn<Receptionist,String> staffIDCol;

    @FXML
    private TableColumn<Receptionist,String> fNameCol;

    @FXML
    private TableColumn<Receptionist,String> lNameCol;

    @FXML
    private TableColumn<Receptionist,String> genderCol;

    @FXML
    private TableColumn<Receptionist,String> dobCol;

    @FXML
    private TableColumn<Receptionist,String> addressCol;

    @FXML
    private TableColumn<Receptionist,String> phoneNoCol;
    
    @FXML
    private TableColumn<Receptionist,String> joinedDate;
    
    @FXML
    private TableColumn<Receptionist,String> emailCol;
    


    
    @FXML
    void AdminUserPatEdit(ActionEvent event) throws IOException {
    try{
        ObservableList<Receptionist> allUser,singleUser;
        allUser = receptionistTable.getItems();
        singleUser =receptionistTable.getSelectionModel().getSelectedItems();
        receptionistID = receptionistTable.getSelectionModel().getSelectedItem().getStaffID();
        // all items store in static object in recep class 
        AdminUsersRecEdit.selectUser=(Receptionist)receptionistTable.getSelectionModel().getSelectedItem();
        singleUser.forEach(allUser::remove);
        // load patient edit window   
        FXMLLoader loader =new FXMLLoader(getClass
        ().getResource("/View/Dashboards/Admin/AdminUsersRecEdit.fxml"));
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
        alert.setContentText("Selecet Receptionist and then press edit  button");
        alert.show();
       
       }
        
    }
 


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        
        try {
          ArrayList<Receptionist> receptionistArrayList = Receptionist.viewReceptionist();
          
          int receptionistCount = receptionistArrayList.size();
          
          ObservableList<Receptionist> receptionists = FXCollections.observableArrayList();
          for(int i =0;i< receptionistCount;i++){
          receptionists.add(receptionistArrayList.get(i));
      
          }
          staffIDCol.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("staffID"));
          fNameCol.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("fName"));
          lNameCol.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("lName"));
          genderCol.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("gender"));
          dobCol.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("DOB"));
          addressCol.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("address"));
          phoneNoCol.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("phoneNumber"));
          joinedDate.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("joinDate"));
          emailCol.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("staffEmail"));
          
          receptionistTable.setItems(receptionists);
           
         }catch(Exception e){}
        
        
        
        
        
    }    
    
}
