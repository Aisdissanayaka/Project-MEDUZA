/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
//update
 */
package Control;

import static Control.UserLoginController.primaryKey;
import static Control.UserLoginController.staticLName;
import static Control.UserLoginController.staticUserName;
import Model.Appointment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;



public class PatDashboardWelcome extends DashboardUIController implements Initializable {
   
    @FXML
    private Label pendingAppointmentCount,pendingCountlbl,completedCountlbl,approvedCountLbl; 
    
    private static int pendingCount,completedCount,approvedCount = 0;
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {

            File pendingAppointments = new File("user data//appointment//"+primaryKey+".txt");
                 try {
            FileReader pendingReader = new FileReader(pendingAppointments);
            LineNumberReader lineRpApp = new LineNumberReader(pendingReader);
            int lineCountpApp = 0;
            
                 try{
                  
                while(lineRpApp.readLine()!=null){
                    lineCountpApp++;
                }
             pendingAppointmentCount.setText(Integer.toString(lineCountpApp));
            
                     }catch(Exception e){}
                    }catch(FileNotFoundException e){}  
                 
                 
                 try{
                   
          ArrayList<Appointment> appointmentArrayList = Appointment.viewAppointment("user data//appointment//"+primaryKey+".txt"); //grt data and set arraylist
         int appointmentCount = appointmentArrayList.size();
         for(int i =0;i< appointmentCount;i++){
            if(appointmentArrayList.get(i).getStatus().equals("pending")){
              
              pendingCount+=1;
              
              }
            if(appointmentArrayList.get(i).getStatus().equals("approved")){
              
              approvedCount+=1;
              
              }
            if(appointmentArrayList.get(i).getStatus().equals("completed")){
              
              completedCount+=1;
              
              }
            }
          
          pendingCountlbl.setText(Integer.toString(pendingCount));
          completedCountlbl.setText(Integer.toString(completedCount));
          approvedCountLbl.setText(Integer.toString(approvedCount));
          pendingCount =0;
          completedCount = 0;
          approvedCount = 0;
                 }catch(Exception e){}
    
    }}
