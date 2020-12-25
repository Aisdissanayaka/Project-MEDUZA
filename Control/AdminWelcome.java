/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
//update
 */
package Control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;



public class AdminWelcome extends DashboardUIController implements Initializable {
   
    @FXML
    Label nameLbl;
    @FXML 
    Circle profilePhoto;
    
    
    @FXML
    private Label pendingAppointmentCount;

    @FXML
    private Label approvedAppointmentCount;

    @FXML
    private Label completedAppointmentsCount;

    @FXML
    private Label visitorRecordsCount;

    @FXML
    private Label complaintsCount;

    @FXML
    private Label receivedPostalCount;

    @FXML
    private Label dispatchedPostalCount;

    @FXML
    private Label patientsCount;

    @FXML
    private Label receptionistCount;

    @FXML
    private Label moCount;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        File pendingAppointments = new File("user data//database//pendingappointment.txt");
        File approvedAppointments = new File("user data//database//approveappointment.txt");
        File completedAppointments = new File("user data//database//completedappointment.txt");
        File visitors  = new File("user data//database//visitors.txt");
        File complaints = new File("user data//database//complaints.txt");
        File rPostal = new File("user data//database//recievedPostals.txt");
        File dPostal = new File("user data//database//dispatchedPostals.txt");
        File patient = new File("user data//database//patients.txt");
        File receptionist = new File("user data//database//receptionists.txt");
        File mo = new File("user data//database//medicalOfficers.txt");
        
        try {
            FileReader pAppR = new FileReader(pendingAppointments);
            FileReader aAppR = new FileReader(approvedAppointments);
            FileReader cAppR = new FileReader(completedAppointments);
            FileReader visitorR = new FileReader(visitors);
            FileReader complR = new FileReader(complaints);
            FileReader rPostalR = new FileReader(rPostal);
            FileReader dPostalR = new FileReader(dPostal);
            FileReader patR = new FileReader(patient);
            FileReader recR = new FileReader(receptionist);
            FileReader moR = new FileReader(mo);
            
            LineNumberReader lineRpApp = new LineNumberReader(pAppR);
            LineNumberReader lineRaApp = new LineNumberReader(aAppR);
            LineNumberReader lineRcApp = new LineNumberReader(cAppR);
            LineNumberReader lineRvis = new LineNumberReader(visitorR);
            LineNumberReader lineRcompl = new LineNumberReader(complR);
            LineNumberReader lineRrPostal = new LineNumberReader(rPostalR);
            LineNumberReader lineRdPostal = new LineNumberReader(dPostalR);
            LineNumberReader lineRpatient = new LineNumberReader(patR);
            LineNumberReader lineRrec = new LineNumberReader(recR);
            LineNumberReader lineRmo = new LineNumberReader(moR);
            
            
            int lineCountpApp = 0;
            int lineCountaApp = 0;
            int lineCountcApp = 0;
            int lineCountvis = 0;
            int lineCountcompl = 0;
            int lineCountrPostal = 0;
            int lineCountdPostal = 0;
            int lineCountpatient = 0;
            int lineCountrec = 0;
            int lineCountmo = 0;
            
            try{
                while(lineRpApp.readLine()!=null){
                    lineCountpApp++;
                }
                 while(lineRaApp.readLine()!=null){
                    lineCountaApp++;
                }
                 while(lineRcApp.readLine()!=null){
                    lineCountcApp++;
                }
                 while(lineRvis.readLine()!=null){
                    lineCountvis++;
                }
                 while(lineRcompl.readLine()!=null){
                    lineCountcompl++;
                }
                 while(lineRrPostal.readLine()!=null){
                    lineCountrPostal++;
                }
                 while(lineRdPostal.readLine()!=null){
                    lineCountdPostal++;
                }
                   while(lineRpatient.readLine()!=null){
                    lineCountpatient++;
                }
                 while(lineRrec.readLine()!=null){
                    lineCountrec++;
                }
                 while(lineRmo.readLine()!=null){
                    lineCountmo++;
                }
               
                pendingAppointmentCount.setText(Integer.toString(lineCountpApp));
                approvedAppointmentCount.setText(Integer.toString(lineCountaApp));
                completedAppointmentsCount.setText(Integer.toString(lineCountcApp));
                visitorRecordsCount.setText(Integer.toString(lineCountvis));
                complaintsCount.setText(Integer.toString(lineCountcompl));
                receivedPostalCount.setText(Integer.toString(lineCountrPostal));
                dispatchedPostalCount.setText(Integer.toString(lineCountdPostal));
                patientsCount.setText(Integer.toString(lineCountpatient));
                receptionistCount.setText(Integer.toString(lineCountrec));
                moCount.setText(Integer.toString(lineCountmo));
                
            }catch(Exception e){}
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminWelcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
