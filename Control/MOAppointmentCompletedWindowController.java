/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MOAppointmentCompletedWindowController extends DashboardUIController implements Initializable {
    
    @FXML
    private TableView<Appointment> completedAppTable;

    @FXML
    private TableColumn<Appointment, String> idCol;

    @FXML
    private TableColumn<Appointment, String> patCol;

    @FXML
    private TableColumn<Appointment, String>dateTable;

    @FXML
    private TableColumn<Appointment, String> timeTable;

    @FXML
    private TableColumn<Appointment, String> symptomsCol;

   
  //assign the file path in string variable because we can't pass the parameter into initialize methode
    String filepathpending ="user data//database//completedappointment.txt";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
     try {
          ArrayList<Appointment> appointmentArrayList = Appointment.viewAppointment(filepathpending);
          
          int appointmentCount = appointmentArrayList.size();
          System.out.println(appointmentCount);
          
          ObservableList<Appointment> appointments = FXCollections.observableArrayList();
          for(int i =0;i< appointmentCount;i++){
          appointments.add(appointmentArrayList.get(i));
      
          }
          idCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("userID"));
          patCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("name"));
          dateTable.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appDate"));
          timeTable.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appTime"));
          symptomsCol.setCellValueFactory(new PropertyValueFactory<Appointment,String>("symptoms"));
         
          completedAppTable.setItems(appointments);
           
         }catch(Exception e){}
    
    
    }    
    
}
