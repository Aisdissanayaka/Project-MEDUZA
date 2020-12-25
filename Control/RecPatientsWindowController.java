/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.RecAppointmentWindowController.userIDAppointment;
import static Control.UserLoginController.profilePicture;
import static Control.UserLoginController.staticUserName;
import Model.Appointment;
import Model.Patient;
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
public class RecPatientsWindowController extends DashboardUIController implements Initializable {
    public static String patientID;
    
    //Triggers the add patient window
    @FXML
    public void AddPatientBtn(ActionEvent event) throws IOException{
  
       
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecAddPatient.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);
    welcome.showProfilePicture(profilePicture);


    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
    
    }
    
     @FXML
    private TableView<Patient> patientsTable;

    @FXML
    private TableColumn<Patient, String> idCol;

    @FXML
    private TableColumn<Patient, String> fNameCol;

    @FXML
    private TableColumn<Patient, String>lNameCol;

    @FXML
    private TableColumn<Patient, String> genderCol;

    @FXML
    private TableColumn<Patient, String> dobCol;

    @FXML
    private TableColumn<Patient, String> phoneCol;

    @FXML
    private TableColumn<Patient, String> addressCol;

    @FXML
    private TableColumn<Patient, String> bloodGroupCol;

    @FXML
    private TableColumn<Patient, String> allergiesCol;

    @FXML
    private TableColumn<Patient, String> passwordCol;

    @FXML
    private TableColumn<Patient, String> optionsCol;
    
    
    @FXML
    public void viewPatients(){
         try {
          ArrayList<Patient> patientArrayList = Patient.viewPatient();
          
          int postalCount = patientArrayList.size();
          
          
             System.out.println(postalCount);
          
          ObservableList<Patient> patients = FXCollections.observableArrayList();
          for(int i =0;i< postalCount;i++){
          patients.add(patientArrayList.get(i));
      
          }
          idCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("nic"));
          fNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("fName"));
          lNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("lName"));
          genderCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("gender"));
          dobCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("DOB"));
          phoneCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
          addressCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("address"));
          bloodGroupCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("bloodGroup"));
          allergiesCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("allergies"));
          passwordCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("password"));
          optionsCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("options"));
          
       
          patientsTable.setItems(patients);
          
             
         }catch(Exception e){}
    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
          ArrayList<Patient> patientArrayList = Patient.viewPatient();
          
          int postalCount = patientArrayList.size();
          
          
             System.out.println(postalCount);
          
          ObservableList<Patient> patients = FXCollections.observableArrayList();
          for(int i =0;i< postalCount;i++){
          patients.add(patientArrayList.get(i));
      
          }
          idCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("nic"));
          fNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("fName"));
          lNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("lName"));
          genderCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("gender"));
          dobCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("DOB"));
          phoneCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
          addressCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("address"));
          bloodGroupCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("bloodGroup"));
          allergiesCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("allergies"));
          passwordCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("password"));
          optionsCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("options"));
          
       
          patientsTable.setItems(patients);
          
             
         }catch(Exception e){}
        
    }    
    
    @FXML
    void editPatientBtn(ActionEvent event) throws IOException {
    try{
        ObservableList<Patient> allUser,singleUser;
        allUser = patientsTable.getItems();
        singleUser =patientsTable.getSelectionModel().getSelectedItems();
        patientID = patientsTable.getSelectionModel().getSelectedItem().getNic();
        // all items store in static object in patient class 
        RecPatientEditWindowController.selectedUser=(Patient)patientsTable.getSelectionModel().getSelectedItem();
        singleUser.forEach(allUser::remove);
        // load patient edit window   
        FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecPatientEditWindow.fxml"));
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
        alert.setContentText("Selecet Patient and then press edit  button");
        alert.show();
        System.out.println(e);
        }
        
    }
    
    
    
    
}
