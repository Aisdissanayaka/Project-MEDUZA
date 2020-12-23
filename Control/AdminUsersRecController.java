/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Appointment;
import Model.Receptionist;
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
public class AdminUsersRecController extends DashboardUIController implements Initializable {

    
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
    private TableColumn<Receptionist,String> emailCol;

    @FXML
    private TableColumn<Receptionist,String> passwordCol;

    @FXML
    private TableColumn<Receptionist,String> optionsCol;
    
    
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
          emailCol.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("staffEmail"));
          passwordCol.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("password"));
          optionsCol.setCellValueFactory(new PropertyValueFactory<Receptionist,String>("options"));
       
          receptionistTable.setItems(receptionists);
           
         }catch(Exception e){}
        
        
        
        
        
    }    
    
}
