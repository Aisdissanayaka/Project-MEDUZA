/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.RecAppointmentWindowController.userIDAppointment;
import Model.Appointment;
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
public class MOAppointmentPendingWindowController extends DashboardUIController implements Initializable {
    
     @FXML
    private TableView<Appointment> appointmentPendingMO;

    @FXML
    private TableColumn<Appointment, String> idCol;

    @FXML
    private TableColumn<Appointment, String> patCol;

    @FXML
    private TableColumn<Appointment, String>dateCol;

    @FXML
    private TableColumn<Appointment, String> timeCol;

    @FXML
    private TableColumn<Appointment, String> symptomsCol;
    
    
    @FXML
    public void completedBtn(ActionEvent event) {
     
      try{
        ObservableList<Appointment> allAppointment,singleAppointment;
        allAppointment = appointmentPendingMO.getItems();
        singleAppointment =appointmentPendingMO.getSelectionModel().getSelectedItems();
        userIDAppointment = appointmentPendingMO.getSelectionModel().getSelectedItem().getUserID(); // get user id in select row and set it static variable
        
         
        //get status in table and asign the value in static variable
             
        Appointment appObj = new Appointment();       //create object in appointment class
        appObj.completedAppointment(filepathpending, "user data//database//completedappointment.txt");  //call approved appointment methode
        appObj.deleteAppointment(filepathpending, "user data//database//temp.txt");  //call delete appointment methode
        singleAppointment.forEach(allAppointment::remove);   // delete selected row in table

        
        
        }
        catch(Exception e){
         Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("Selecet Appointment and press completed button");
        alert.show();  
        }
    }
    
    
    //assign the file path in string variable because we can't pass the parameter into initialize methode
    String filepathpending ="user data//database//approveappointment.txt";

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try {
          ArrayList<Appointment> appointmentArrayList = Appointment.viewAppointment(filepathpending); //grt data and set arraylist
          
          int appointmentCount = appointmentArrayList.size();
          
          ObservableList<Appointment> appointments = FXCollections.observableArrayList();   
          for(int i =0;i< appointmentCount;i++){
          appointments.add(appointmentArrayList.get(i));
      
          }
          idCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("userID"));
          patCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("name"));
          dateCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appDate"));
          timeCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appTime"));
          symptomsCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("symptoms"));
         
            //set data in each colloms and row
          appointmentPendingMO.setItems(appointments);
           
         }catch(Exception e){}
        
    }    
    
}
