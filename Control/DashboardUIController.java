/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
//update
 */
package Control;

import static Control.UserLoginController.primaryKey;
import static Control.UserLoginController.profilePicture;
import static Control.UserLoginController.staticAddress;
import static Control.UserLoginController.staticAllergies;
import static Control.UserLoginController.staticBloodGroup;
import static Control.UserLoginController.staticDOB;
import static Control.UserLoginController.staticEmail;
import static Control.UserLoginController.staticGender;
import static Control.UserLoginController.staticJoinDate;
import static Control.UserLoginController.staticLName;
import static Control.UserLoginController.staticPhoneNo;
import static Control.UserLoginController.staticSpecilatyArea;
import static Control.UserLoginController.staticStaffID;
import static Control.UserLoginController.staticUserID;
import static Control.UserLoginController.staticUserName;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * Parent class of the Dashboard action events. 
 */
public class DashboardUIController implements Initializable {
    
    
    
     @FXML
    private JFXTextField firstNameTxt;

    @FXML
    private JFXTextField lastNameTxt;
    
    @FXML
    private ComboBox genderBox;

    @FXML
    private JFXTextField dateOfBirthTxt;

    @FXML
    private JFXTextField phoneNumTxt;

    @FXML
    private JFXTextField addressTxt;
    
    @FXML
    private JFXTextField staffEmailTxt;

    @FXML
    private JFXTextField joinedDateTxt;
    
    @FXML
    public JFXTextField staffIDTxt;
    
    @FXML
    private JFXTextField NICTxt;
    
    @FXML
    private ComboBox bloodGroupBox;
    
    @FXML
    private JFXTextArea allergiesTxt;
 
    
    @FXML
    public Label nameLbl,nameLbl2;
    @FXML
    public Circle profilePhoto;

 @FXML
    private AnchorPane ap;
    @FXML
    private JFXTextField nameTxt;
    

    @FXML
    private JFXTextField specialityAreamo;

    
    public void showInformation(String username){
        nameLbl.setText(username);
       
  
    }
    
    public void showWelcome(String username){
    nameLbl2.setText(username);
  
    }
    
  
    
    public void showProfilePicture(String picturePath) {
        try{
        FileInputStream input = new FileInputStream(picturePath);
 
        Image img1 = new Image(input);
     
        profilePhoto.setFill(new ImagePattern(img1));
        }catch(Exception e){
            
        }
    }
    public void showInformation(String username,String lastName, String gender, String dob, String phone, String address,String staffID, String email, String joinedDate ){
        nameLbl.setText(username);
        firstNameTxt.setText(username);
        lastNameTxt.setText(lastName);
        genderBox.setValue(gender);
        dateOfBirthTxt.setText(dob);
        phoneNumTxt.setText(phone);
        addressTxt.setText(address);
        staffEmailTxt.setText(email);
        staffIDTxt.setText(staffID);
        joinedDateTxt.setText(joinedDate);

    }
    public void showInformatienPatient(String username,String lastName,String address,String IDNumber,String bloodGroup,String dob,String gender,String phoneNumber,String allergies){
        firstNameTxt.setText(username);
        lastNameTxt.setText(lastName);
        phoneNumTxt.setText(phoneNumber);
        addressTxt.setText(address);
        dateOfBirthTxt.setText(dob);
        NICTxt.setText(IDNumber);
        genderBox.setValue(gender);
        bloodGroupBox.setValue(bloodGroup);
        allergiesTxt.setText(allergies);
    }
    
    // create a methode for medical officer set value in profile update window
    public void showInformation(String username,String lastName, String address, String phone, String DOB, String staffID ,String email, String joinedDate, String gender,String specialityArea ){
        nameLbl.setText(username);
        firstNameTxt.setText(username);
        lastNameTxt.setText(lastName);
        genderBox.setValue(gender);
        dateOfBirthTxt.setText(DOB);
        phoneNumTxt.setText(phone);
        addressTxt.setText(address);
        staffEmailTxt.setText(email);
        staffIDTxt.setText(staffID);
        joinedDateTxt.setText(joinedDate);
        specialityAreamo.setText(specialityArea);
    }
    
    public void showInformation(String username,String userid){
        nameTxt.setText(username);
        NICTxt.setText(userid);
        
    }
     
    
      
    //Close button
    @FXML
    public void closeBtn(ActionEvent event) {
     System.exit(0);
    }

    
    //Signout button - (Side Vbox)
   
     //switching and transition sign up as window to user login medical offficer window
        @FXML   
        public void Signoutbtn(ActionEvent event) {
              makeFadeOut();
        }
        public void makeFadeOut() {
        FadeTransition fadetransition = new FadeTransition();
        fadetransition.setDuration(Duration.millis(250));
        fadetransition.setNode(ap);
        fadetransition.setFromValue(1);
        fadetransition.setToValue(0);
        fadetransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadNextScene();
            }
        });
        fadetransition.play();
       
    }
    
    private void loadNextScene() {
       
        try {
            Parent secondview;
            secondview = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/Sign_Up_as.fxml"));
            Scene newscene= new Scene(secondview);
            Stage curstage =(Stage)ap.getScene().getWindow();
            curstage.setScene(newscene);
            curstage.centerOnScreen();
            
        } catch (IOException ex) {
            Logger.getLogger(Sign_Up_asController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 //minimize button
     @FXML
    private void minimizeButtonAction(ActionEvent event) {
        Stage stage =(Stage)ap.getScene().getWindow();
        stage.setIconified(true);
    }
    
    //Profile button - (Side Vbox)
    @FXML
    public void Profilebtn(ActionEvent event) throws IOException{
     
        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/ReceptionistProfileWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName,staticLName, staticGender, 
    staticDOB, staticPhoneNo, staticAddress,staticEmail, staticStaffID,staticJoinDate);
    welcome.showProfilePicture(profilePicture);
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
    welcome.showWelcome(staticUserName+"!");
    welcome.showProfilePicture(profilePicture);
    
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
    welcome.showProfilePicture(profilePicture);
        
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
       
    }
    @FXML
    public void AppointmentApprovedBtn(ActionEvent event) throws IOException{
      
    
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecAppointmentApproved.fxml"));
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
    public void AppointmentCompletedBtn(ActionEvent event) throws IOException{
      
    
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecAppointmentCompleted.fxml"));
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
    public void addNewAppointment(ActionEvent event) throws IOException{
       
            
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecAddAppointmentWindow.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);
    welcome.showProfilePicture(profilePicture);


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
    welcome.showProfilePicture(profilePicture);
         

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
    welcome.showProfilePicture(profilePicture);

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
    welcome.showProfilePicture(profilePicture);
    
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
    welcome.showProfilePicture(profilePicture);
    
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
    welcome.showWelcome(staticUserName+"!");
    welcome.showProfilePicture(profilePicture);
    
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
    welcome.showInformatienPatient(staticUserName, staticLName, staticAddress, staticUserID, 
            staticBloodGroup, staticDOB, staticGender, staticPhoneNo,staticAllergies);
    welcome.showInformation(staticUserName);
    welcome.showProfilePicture(profilePicture);
    
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
    welcome.showProfilePicture(profilePicture);
    
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
    welcome.showProfilePicture(profilePicture);
    
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
    welcome.showInformation(staticUserName, staticLName, staticAddress, staticPhoneNo, 
            staticDOB, staticStaffID, staticEmail, staticJoinDate, staticGender, staticSpecilatyArea);
    welcome.showInformation(staticUserName);
    welcome.showProfilePicture(profilePicture);
    
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
     welcome.showWelcome(staticUserName+"!");
    welcome.showProfilePicture(profilePicture);
    
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
    welcome.showProfilePicture(profilePicture);
    
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
    welcome.showProfilePicture(profilePicture);
    
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
    
    
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        }
    
    
    @FXML
    public void MOChangePasswordBtn(ActionEvent event) throws IOException {
     
        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/MO/MoChangePassword.fxml"));
    Parent root = loader.load();
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        }
    
    @FXML
    public void adminHome(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/AdminDashboardWelcome.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);
    welcome.showWelcome(staticUserName+"!");
    welcome.showProfilePicture(profilePicture);
         

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(new Scene(root));
    window.show();
    window.centerOnScreen();
        
       }
    
    @FXML
    public void AdminProfileBtn(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminProfileWindow.fxml"));
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
    public void AdminAppointmentBtn(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminAppointments.fxml"));
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
    public void AdminAppointmentApprovedBtn(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminAppointmentsApproved.fxml"));
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
    public void AdminAppointmentCompletedBtn(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminAppointmentsCompleted.fxml"));
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
    public void AdminVisitorstBtn(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminVisitors.fxml"));
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
    public void AdminComplaintBtn(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminComplaints.fxml"));
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
    public void AdminPostalReceivedBtn(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminPostalReceived.fxml"));
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
    public void AdminUsersRecBtn(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminUsersRec.fxml"));
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
    public void AdminAddNewRec(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminAddRec.fxml"));
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
    public void AdminAddNewMO(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminAddMO.fxml"));
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
    public void AdminAddNewPat(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminAddPat.fxml"));
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
    public void AdminUserMO(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminUsersMO.fxml"));
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
    public void AdminUserPat(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminUsersPat.fxml"));
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
    public void AdminUserRec(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminUsersRec.fxml"));
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
    public void AdminUserRecEdit(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminUsersRecEdit.fxml"));
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
    public void refSpecArea(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminRefSpecType.fxml"));
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
    public void refComType(ActionEvent event) throws IOException{

        
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Admin/AdminRefComType.fxml"));
    Parent root = loader.load();
    DashboardUIController welcome =loader.getController();
    welcome.showInformation(staticUserName);
    welcome.showProfilePicture(profilePicture);
         

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
