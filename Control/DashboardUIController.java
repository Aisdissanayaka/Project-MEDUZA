/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
//update
 */
package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * Parent class of the Dashboard action events. 
 */
public class DashboardUIController implements Initializable {
    
    
    //Close button
    @FXML
    public void closeBtn(ActionEvent event) {
     System.exit(0);
    }
    
    //Signout button - (Side Vbox)
    @FXML
    public void Signoutbtn(ActionEvent event) throws IOException{
        Parent loginWindow = FXMLLoader.load(getClass().getResource("/View/Sign_Up_as.fxml"));
        Scene loginViewScene = new Scene(loginWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    //Profile button - (Side Vbox)
    @FXML
    public void Profilebtn(ActionEvent event) throws IOException{
        Parent profileWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/ReceptionistProfileWindow.fxml"));
        Scene profileViewScene = new Scene(profileWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(profileViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    //Home button - (Side Vbox)
    @FXML
    public void homeBtn(ActionEvent event) throws IOException{
        Parent welcomeWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/RecDashboardWelcome.fxml"));
        Scene welcomeWindowViewScene = new Scene(welcomeWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeWindowViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    //Appointment button - (Side Vbox)
    @FXML
    public void AppointmentBtn(ActionEvent event) throws IOException{
        Parent appointmentWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/RecAppointmentWindow.fxml"));
        Scene appointmentWindowViewScene = new Scene(appointmentWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(appointmentWindowViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    //Visitors button - (Side Vbox)
    @FXML
    public void VisitorsBtn(ActionEvent event) throws IOException{
        Parent VisitorsWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/RecVisitorsWindow.fxml"));
        Scene VisitorsWindowViewScene = new Scene(VisitorsWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(VisitorsWindowViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    //Complaints button - (Side Vbox)
    @FXML
    public void ComplaintsBtn(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/RecComplaintsWindow.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
    //Postal Button - (Side Vbox)
     @FXML
    public void PostalBtn(ActionEvent event) throws IOException{
        Parent postalWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/RecPostalWindow.fxml"));
        Scene postalWindowViewScene = new Scene(postalWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(postalWindowViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    //Patient Button - (Side Vbox)
    @FXML
    public void PatientBtn(ActionEvent event) throws IOException{
        Parent patientWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/RecPatientsWindow.fxml"));
        Scene patientWindowViewScene = new Scene(patientWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(patientWindowViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
     //Following lines are related to Patient's Dashboard
    
    //Patient's Home button - (Side Vbox) patHomeBtn
    @FXML
    public void patHomeBtn(ActionEvent event) throws IOException{
        Parent profileWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/PatientDashboardWelcome.fxml"));
        Scene profileViewScene = new Scene(profileWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(profileViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    
    @FXML
    public void patientProfilebtn(ActionEvent event) throws IOException{
        Parent profileWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/Patient/PatientProfileWindow.fxml"));
        Scene profileViewScene = new Scene(profileWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(profileViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    

    
     //Patient's Appointment button - (Side Vbox)
    @FXML
    public void patientAppointmentBtn(ActionEvent event) throws IOException{
        Parent appointmentWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/Patient/PatAppointmentWindow.fxml"));
        Scene appointmentWindowViewScene = new Scene(appointmentWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(appointmentWindowViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    //Patient's Complaints button - (Side Vbox)
    @FXML
    public void patientComplaintsBtn(ActionEvent event) throws IOException{
        Parent signUpAsParent = FXMLLoader.load(getClass().getResource("/View/Dashboards/Patient/PatComplaintsWindow.fxml"));
        Scene signUpAsviewScene = new Scene(signUpAsParent);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signUpAsviewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    
    //Following lines are related to MO's Dashboard
    
    
    //Profile button - (Side Vbox)
    @FXML
    public void MOProfilebtn(ActionEvent event) throws IOException{
        Parent profileWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/MO/MOProfileWindow.fxml"));
        Scene profileViewScene = new Scene(profileWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(profileViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    //Home button - (Side Vbox)
    @FXML
    public void MOhomeBtn(ActionEvent event) throws IOException{
        Parent welcomeWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/MODashboardWelcome.fxml"));
        Scene welcomeWindowViewScene = new Scene(welcomeWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeWindowViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    //Appointment button - (Side Vbox)
    @FXML
    public void MOPendingAppointmentBtn(ActionEvent event) throws IOException{
        Parent appointmentWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/MO/MOPendingAppointmentWindow.fxml"));
        Scene appointmentWindowViewScene = new Scene(appointmentWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(appointmentWindowViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    //Appointment button - (Side Vbox)
    @FXML
    public void MOCompletedAppointmentBtn(ActionEvent event) throws IOException{
        Parent appointmentWindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/MO/MOCompletedAppointmentWindow.fxml"));
        Scene appointmentWindowViewScene = new Scene(appointmentWindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(appointmentWindowViewScene);
        window.show();
        window.centerOnScreen();
        
       }
    
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
