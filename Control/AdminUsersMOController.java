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
public class AdminUsersMOController extends DashboardUIController implements Initializable {

    
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
    private TableColumn<MedicalOfficer, String> optionsCol;
    
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
          pwCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("email"));
          optionsCol.setCellValueFactory(new PropertyValueFactory<MedicalOfficer,String>("options"));
          
       
          moTable.setItems(mos);
          
             
         }catch(Exception e){}
        
    }  
    
}
