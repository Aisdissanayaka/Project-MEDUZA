/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.RecAppointmentWindowController.userIDAppointment;
import Model.Appointment;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RecAppointmentCompletedController extends DashboardUIController implements Initializable {

   
    @FXML
    private TableView<Appointment> appointmentTable;

    @FXML
    private TableColumn<Appointment,String> idCol;

    @FXML
    private TableColumn<Appointment,String>patientCol;

    @FXML
    private TableColumn<Appointment,String> dateCol;

    @FXML
    private TableColumn<Appointment,String> timeCol;

    @FXML
    private TableColumn<Appointment,String> symptomsCol;

    @FXML
    private TableColumn<Appointment,String> moCol;

    @FXML
    private TableColumn<Appointment,String> statusCol;

    @FXML
    private TableColumn<Appointment,String>optionsCol;
    
    //assign the file path in string variable because we can't pass the parameter into initialize methode
    String filepathpending ="user data//database//completedappointment.txt";

    public void initialize(){
         try {
          ArrayList<Appointment> appointmentArrayList = Appointment.viewAppointment(filepathpending);
          
          int appointmentCount = appointmentArrayList.size();
          
          ObservableList<Appointment> appointments = FXCollections.observableArrayList();
          for(int i =0;i< appointmentCount;i++){
          appointments.add(appointmentArrayList.get(i));
      
          }
          idCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("userID"));
          patientCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("name"));
          dateCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appDate"));
          timeCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appTime"));
          symptomsCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("symptoms"));
          moCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("specArea"));
          statusCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("status"));
          optionsCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("options"));
           //set data in each colloms and row
          appointmentTable.setItems(appointments);
           
         }catch(Exception e){}
             
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
          ArrayList<Appointment> appointmentArrayList = Appointment.viewAppointment(filepathpending);
          
          int appointmentCount = appointmentArrayList.size();
          
          ObservableList<Appointment> appointments = FXCollections.observableArrayList();
          for(int i =0;i< appointmentCount;i++){
          appointments.add(appointmentArrayList.get(i));
      
          }
          idCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("userID"));
          patientCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("name"));
          dateCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appDate"));
          timeCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appTime"));
          symptomsCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("symptoms"));
          moCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("specArea"));
          statusCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("status"));
          optionsCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("options"));
           //set data in each colloms and row
          appointmentTable.setItems(appointments);
           
         }catch(Exception e){}
    }    
   
    @FXML
    void deleteAppointment(ActionEvent event) {  // deleteaction event
        String name; 
        ObservableList<Appointment> allAppointment,singleAppointment;
        allAppointment = appointmentTable.getItems();
        singleAppointment =appointmentTable.getSelectionModel().getSelectedItems();
        userIDAppointment = appointmentTable.getSelectionModel().getSelectedItem().getUserID(); // get user id in select row and set it static variable
        name=appointmentTable.getSelectionModel().getSelectedItem().getName(); //get name in table set it name
        singleAppointment.forEach(allAppointment::remove); //delete select row
        Appointment appObj = new Appointment();            //create object in appointmen class
        appObj.deleteAppointment("user data//database//approveappointment.txt", "user data//database//temp.txt"); //call appointment delete methode
        Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("You deleted "+name.toUpperCase()+"'s appointment..!");
        alert.show();
    }
    
}
