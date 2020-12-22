/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Complaint;
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
public class AdminComplaintsController extends DashboardUIController implements Initializable {

    @FXML
    private TableView<Complaint> complaintsAdminTable;

    @FXML
    private TableColumn<Complaint, String> idCol;

    @FXML
    private TableColumn<Complaint, String> comByType;

    @FXML
    private TableColumn<Complaint, String> comTypeCol;

    @FXML
    private TableColumn<Complaint, String> phoneNoCol;

    @FXML
    private TableColumn<Complaint, String> dateCol;

    @FXML
    private TableColumn<Complaint, String> desCol;

    @FXML
    private TableColumn<Complaint, String> actionCol;

    @FXML
    private TableColumn<Complaint, String> noteCol;

    @FXML
    private TableColumn<Complaint, String> docCol;

    @FXML
    private TableColumn<Complaint, String> optionsCol;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         try {
          ArrayList<Complaint> complaintArrayList = Complaint.viewComplaint();
          
          int complaintCount = complaintArrayList.size();
          
          
             System.out.println(complaintCount);
          
          ObservableList<Complaint> complaints = FXCollections.observableArrayList();
          for(int i =0;i< complaintCount;i++){
          complaints.add(complaintArrayList.get(i));
      
          }
          idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
          comTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
          comByType.setCellValueFactory(new PropertyValueFactory<>("name"));
          phoneNoCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
          dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
          desCol.setCellValueFactory(new PropertyValueFactory<>("description"));
          actionCol.setCellValueFactory(new PropertyValueFactory<>("actionTaken"));
          noteCol.setCellValueFactory(new PropertyValueFactory<>("note"));
          docCol.setCellValueFactory(new PropertyValueFactory<>("document"));
          optionsCol.setCellValueFactory(new PropertyValueFactory<>("options"));
       
       
          complaintsAdminTable.setItems(complaints);
          
             
         }catch(Exception e){}
    }    
    
}
