/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 * FXML Controller class
 *
 * @author ASUS
 */

public class MODashboardWelcome extends DashboardUIController implements Initializable {
    
     @FXML
    private Label pendingMOcountLbl; 
    
    private static int pendingMOcount = 0;

    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
   ArrayList<Appointment> appointmentArrayList = Appointment.viewAppointment("user data//database//approveappointment.txt"); //grt data and set arraylist
         int appointmentCount = appointmentArrayList.size();
         for(int i =0;i< appointmentCount;i++){
              if(appointmentArrayList.get(i).getSpecArea().equals("Dr. "+staticUserName+" "+staticLName)){
              
              pendingMOcount+=1;
              
              }
            
         }
         pendingMOcountLbl.setText(Integer.toString(pendingMOcount));
         pendingMOcount = 0;
         
         
        }catch(Exception e){}
    }    


    
    
}
