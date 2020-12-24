/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Appointment;
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
