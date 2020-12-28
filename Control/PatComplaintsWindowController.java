/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.UserLoginController.primaryKey;
import static Control.UserLoginController.profilePicture;
import static Control.UserLoginController.staticUserName;
import Model.Complaint;
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
public class PatComplaintsWindowController extends DashboardUIController implements Initializable {
    
   
    //Triggers the add complain button in the complains window
     @FXML
    public void AddComplaintBtn(ActionEvent event) throws IOException{
        FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Patient/PatAddComplaintWindow.fxml"));
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
    private TableView<Complaint> complaintsTable;

    @FXML
    private TableColumn<Complaint, String> idCol;

    @FXML
    private TableColumn<Complaint, String> comTypeCol;

    @FXML
    private TableColumn<Complaint, String>  comByCol;

    @FXML
    private TableColumn<Complaint, String>  phoneNoCol;

    @FXML
    private TableColumn<Complaint, String>  dateCol;

    @FXML
    private TableColumn<Complaint, String> desCol;

    @FXML
    private TableColumn<Complaint, String>  actionCol;

    @FXML
    private TableColumn<Complaint, String> noteCol;
    
    
    
    
    
    String filepath = "user data\\complaint\\data\\"+primaryKey+".txt";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
          ArrayList<Complaint> complaintArrayList = Complaint.viewComplaint(filepath);
          
          int complaintCount = complaintArrayList.size();
          
          
             System.out.println(complaintCount);
          
          ObservableList<Complaint> complaints = FXCollections.observableArrayList();
          for(int i =0;i< complaintCount;i++){
          complaints.add(complaintArrayList.get(i));
      
          }
          idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
          comTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
          comByCol.setCellValueFactory(new PropertyValueFactory<>("name"));
          phoneNoCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
          dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
          desCol.setCellValueFactory(new PropertyValueFactory<>("description"));
          actionCol.setCellValueFactory(new PropertyValueFactory<>("actionTaken"));
          noteCol.setCellValueFactory(new PropertyValueFactory<>("note"));
         // docCol.setCellValueFactory(new PropertyValueFactory<>("document"));
          //optionsCol.setCellValueFactory(new PropertyValueFactory<>("options"));
       
       
          complaintsTable.setItems(complaints);
          
             
         }catch(Exception e){}
    }    
    
}
