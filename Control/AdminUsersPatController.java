/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.MedicalOfficer;
import Model.Patient;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminUsersPatController extends DashboardUIController implements Initializable {

  
    @FXML
    private TableView<Patient> patientTable;

    @FXML
    private TableColumn<Patient, String> nicCol;

    @FXML
    private TableColumn<Patient, String> fNameCol;

    @FXML
    private TableColumn<Patient, String> lNameCol;

    @FXML
    private TableColumn<Patient, String> genderCol;

    @FXML
    private TableColumn<Patient, String> dobCol;

    @FXML
    private TableColumn<Patient, String> addressCol;

    @FXML
    private TableColumn<Patient, String>phoneCol;

    @FXML
    private TableColumn<Patient, String> bloodCol;

    @FXML
    private TableColumn<Patient, String> allergiesCol;

    @FXML
    private TableColumn<Patient, String> pwCol;

    @FXML
    private TableColumn<Patient, String> optionsCol;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        try {
          ArrayList<Patient> patientArrayList = Patient.viewPatient();
          
          int patientCount = patientArrayList.size();
          
          
             System.out.println(patientCount);
          
          ObservableList<Patient> patients = FXCollections.observableArrayList();
          for(int i =0;i< patientCount;i++){
          patients.add(patientArrayList.get(i));
      
          }
          nicCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("nic"));
          fNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("fName"));
          lNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("lName"));
          genderCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("gender"));
          dobCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("DOB"));
          phoneCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
          addressCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("address"));
          bloodCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("bloodGroup"));
          allergiesCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("allergies"));
          pwCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("password"));
          optionsCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("options"));
          
       
          patientTable.setItems(patients);
          
             
         }catch(Exception e){}
    }    
    
}
