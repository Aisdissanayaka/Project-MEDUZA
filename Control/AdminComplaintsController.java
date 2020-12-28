/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.RecComplaintsWindowController.complaintID;
import static Control.UserLoginController.primaryKey;
import Model.Complaint;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    private JFXTextField actTakenTxt;
    
    public static String complaintDate,complaintTime;
    
    int index = -1;

   //delete Complaint Action event
     public void deleteComplaintBtnAct(ActionEvent event){
             try{
        String name; 
        ObservableList<Complaint> allComplaints,singleComplaint;
        allComplaints = complaintsAdminTable.getItems();
        singleComplaint =complaintsAdminTable.getSelectionModel().getSelectedItems();
        complaintID = complaintsAdminTable.getSelectionModel().getSelectedItem().getId(); // get id in select row and set it static variable
        name=complaintsAdminTable.getSelectionModel().getSelectedItem().getName(); //get name in table set it name
        singleComplaint.forEach(allComplaints::remove); //delete select row
        Complaint appObj = new Complaint();            //create object in Complaint class
        appObj.deleteComplaint("user data\\database\\complaints.txt", "user data\\database\\temp.txt"); //delete coplaint in database file
        appObj.deleteComplaint("user data\\complaint\\"+ complaintID+".txt", "user data\\complaint\\temp.txt");//delete coplaint in complaint file
        Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("You deleted "+name.toUpperCase()+"'s  complaint..!");
        alert.show();
        
        }catch(Exception e){
        Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("Selecet Complaint and press delete button..!");
        alert.show();   
        }
        
        }
     
    
   public void getSelected(MouseEvent event){
       index = complaintsAdminTable.getSelectionModel().getSelectedIndex();
       if(index <=  -1){
         
           return;
       }
       actTakenTxt.setText(actionCol.getCellData(index).toString());
       
     }
     
     
    @FXML
    void actBtn(ActionEvent event) {
        if(validateFields()){
        try{
        ObservableList<Complaint> allComplaints,singleComplaint;
        complaintID = complaintsAdminTable.getSelectionModel().getSelectedItem().getId(); // get id in select row and set it static variable
        complaintDate = complaintsAdminTable.getSelectionModel().getSelectedItem().getDate(); // get date in select row and set it static variable
       
        Complaint appObj = new Complaint();            //create object in Complaint class
        appObj.editActionTaken("user data\\database\\complaints.txt", "user data\\database\\temp.txt", actTakenTxt.getText().toString()); // edit database file
        appObj.editActionTaken("user data\\complaint\\data\\"+complaintID+".txt", "user data\\database\\temp.txt", actTakenTxt.getText().toString()); //edit complaint file
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //display Warning message
        alert.setContentText("Update Complaint..!");
        alert.show();
       
        }catch(Exception e){
         Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("Update Complaint and press submit button..!");
        alert.show();     
        }
        }
     }
    
    
    
         private boolean validateFields(){
           
         
         if(actTakenTxt.getText().isEmpty() )
         {
            Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Validate Fields");
             alert.setHeaderText(null);
             alert.setContentText("Please Enter Into The Fields");
             alert.showAndWait();
             
             return false;
            
         }
         return true;
          }
    
    String filepath ="user data\\database\\complaints.txt";
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
          comByType.setCellValueFactory(new PropertyValueFactory<>("name"));
          phoneNoCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
          dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
          desCol.setCellValueFactory(new PropertyValueFactory<>("description"));
          actionCol.setCellValueFactory(new PropertyValueFactory<>("actionTaken"));
          noteCol.setCellValueFactory(new PropertyValueFactory<>("note"));
        
       
       
          complaintsAdminTable.setItems(complaints);
          
             
         }catch(Exception e){}
         
        
         
         
       
        
      }    
    
}
