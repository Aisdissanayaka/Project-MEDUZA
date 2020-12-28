/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.RecAppointmentWindowController.appointmentNo;
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

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminAppointmentsApprovedController extends DashboardUIController implements Initializable {
    @FXML
    private TableView<Appointment> appointmentTableAdmin;

    @FXML
    private TableColumn<Appointment, String> idCol;

    @FXML
    private TableColumn<Appointment, String> patientCol;

    @FXML
    private TableColumn<Appointment, String> dateCol;

    @FXML
    private TableColumn<Appointment, String> timeCol;

    @FXML
    private TableColumn<Appointment, String> symptomsCol;

    @FXML
    private TableColumn<Appointment, String>moCol;

    @FXML
    private TableColumn<Appointment, String> statusCol;

    @FXML
    private TableColumn<Appointment, String>optionsCol;
    
    
    @FXML
    void deleteAppointment(ActionEvent event) {  // deleteaction event
            try{
        String name; 
        ObservableList<Appointment> allAppointment,singleAppointment;
        allAppointment = appointmentTableAdmin.getItems();
        singleAppointment =appointmentTableAdmin.getSelectionModel().getSelectedItems();
        userIDAppointment = appointmentTableAdmin.getSelectionModel().getSelectedItem().getUserID(); // get user id in select row and set it static variable
        name=appointmentTableAdmin.getSelectionModel().getSelectedItem().getName(); //get name in table set it name
        appointmentNo =appointmentTableAdmin.getSelectionModel().getSelectedItem().getOptions();//get user id in selected row
        singleAppointment.forEach(allAppointment::remove); //delete select row
        Appointment appObj = new Appointment();            //create object in appointmen class
        appObj.deleteAppointment("user data//database//approveappointment.txt", "user data//database//temp.txt"); //call appointment delete methode
        appObj.deleteAppointment("user data\\appointment\\"+userIDAppointment+".txt", "user data\\appointment\\temp.txt");
        Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("You deleted "+name.toUpperCase()+"'s appointment..!");
        alert.show();
           }
        catch(Exception e){
         Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("Selecet Appointment and press delete button");
        alert.show();  
        }
        
        
    }
    
    String filepathpending ="user data//database//approveappointment.txt";
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
       
          appointmentTableAdmin.setItems(appointments);
           
         }catch(Exception e){}
        
    }  
        
    
}
