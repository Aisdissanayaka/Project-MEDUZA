/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
//update
 */
package Control;

import static Control.UserLoginController.primaryKey;
import static Control.UserLoginController.staticUserName;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * 
 * Parent class of the Dashboard action events. 
 */
public class DashboardUIController implements Initializable {
    
    @FXML
    public Label nameLbl;
    
    public void showInformation(String username){
        nameLbl.setText(username);
        
        
    }
    
    public void setName(String name){
      System.out.println(name);
  }   
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
     
        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/ReceptionistProfileWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        
       }
    
    //Home button - (Side Vbox)
    @FXML
    public void homeBtn(ActionEvent event) throws IOException{
       
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/RecDashboardWelcome.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        
       }
    
    //Appointment button - (Side Vbox)
    @FXML
    public void AppointmentBtn(ActionEvent event) throws IOException{
      
    
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecAppointmentWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
       
    }
    
    //Visitors button - (Side Vbox)
    @FXML
    public void VisitorsBtn(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecVisitorsWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        
       }
    
    //Complaints button - (Side Vbox)
    @FXML
    public void ComplaintsBtn(ActionEvent event) throws IOException{
  
        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecComplaintsWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();       
        
       }
    //Postal Button - (Side Vbox)
     @FXML
    public void PostalBtn(ActionEvent event) throws IOException{
       
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecPostalWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();   
        
       }
    
    //Patient Button - (Side Vbox)
    @FXML
    public void PatientBtn(ActionEvent event) throws IOException{
               
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecPatientsWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();   
        
       }
    
     //Following lines are related to Patient's Dashboard
    
    //Patient's Home button - (Side Vbox) patHomeBtn
    @FXML
    public void patHomeBtn(ActionEvent event) throws IOException{
     
        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/PatientDashboardWelcome.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();  
        
       }
    
    
    @FXML
    public void patientProfilebtn(ActionEvent event) throws IOException{
  
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Patient/PatientProfileWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();  
    
    
    }

    
     //Patient's Appointment button - (Side Vbox)
    @FXML
    public void patientAppointmentBtn(ActionEvent event) throws IOException{
        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Patient/PatAppointmentWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();  
    
        
       }
    
    //Patient's Complaints button - (Side Vbox)
    @FXML
    public void patientComplaintsBtn(ActionEvent event) throws IOException{
 
        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Patient/PatComplaintsWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
       }
    
    
    //Following lines are related to MO's Dashboard
    
    
    //Profile button - (Side Vbox)
    @FXML
    public void MOProfilebtn(ActionEvent event) throws IOException{
   
             
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/MO/MOProfileWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        
       }
    
    //Home button - (Side Vbox)
    @FXML
    public void MOhomeBtn(ActionEvent event) throws IOException{
   
        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/MODashboardWelcome.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        
       }
    
    //Appointment button - (Side Vbox)
    @FXML
    public void MOPendingAppointmentBtn(ActionEvent event) throws IOException{
  
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/MO/MOPendingAppointmentWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        
       }
    
    //Appointment button - (Side Vbox)
    @FXML
    public void MOCompletedAppointmentBtn(ActionEvent event) throws IOException{
    
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/MO/MOCompletedAppointmentWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        
       }
    
    
    
    // Receptionist Change Password Button
    @FXML
    public void recChangePasswordBtn(ActionEvent event) throws IOException {
  

    Parent changePWwindow = FXMLLoader.load(getClass().getResource("/View/Dashboards/Receptionist/RecChangePassword.fxml"));
        Scene changePWwindowScene = new Scene(changePWwindow);
        
        //This Line gets the Stage Information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(changePWwindowScene);
        window.show();
        window.centerOnScreen();
        }
    
    
    
    @FXML
    public void patChangePasswordBtn(ActionEvent event) throws IOException {
 
        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Patient/PatChangePassword.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        }
    
    
    @FXML
    public void MOChangePasswordBtn(ActionEvent event) throws IOException {
     
        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Patient/PatChangePassword.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        }
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
