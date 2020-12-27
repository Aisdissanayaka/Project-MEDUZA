/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Visitor;
import static Control.UserLoginController.profilePicture;
import static Control.UserLoginController.staticUserName;
import Model.Patient;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RecVisitorsWindowController extends DashboardUIController implements Initializable {
    
      @FXML
    private TableView<Visitor> visitorTable;

    @FXML
    private TableColumn<Visitor,String> idCol;

    @FXML
    private TableColumn<Visitor,String>  nameCol;

    @FXML
    private TableColumn<Visitor,String>  intimeCol;

    @FXML
    private TableColumn<Visitor,String>  outTimeCol;

    @FXML
    private TableColumn<Visitor,String>  docCol;

    @FXML
    private TableColumn<Visitor,String>  noteCol;

    @FXML
    private TableColumn<Visitor,String>  optionsCol;
    
    public static String visitorID;
    
    @FXML
    public void viewVisitors(){
         try {
          ArrayList<Visitor> visitorArrayList = Visitor.viewVisitor();
          
          int postalCount = visitorArrayList.size();
          
          
             System.out.println(postalCount);
          
          ObservableList<Visitor> Visitors = FXCollections.observableArrayList();
          for(int i =0;i< postalCount;i++){
          Visitors.add(visitorArrayList.get(i));
      
          }
          idCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("nic"));
          nameCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
          intimeCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("inTime"));
          outTimeCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("outTime"));
          docCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("document"));
          noteCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("note"));
          optionsCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("options"));
          
       
          visitorTable.setItems(Visitors);
          
             
         }catch(Exception e){}
    
    }

   
 
    
    //Trigers the add new Visitor Window
    @FXML
    public void addNewVisitorBtn(ActionEvent event) throws IOException{

      
    FXMLLoader loader =new FXMLLoader(getClass().getResource("/View/Dashboards/Receptionist/RecAddVisitorWindow.fxml"));
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
       try {
          ArrayList<Visitor> visitorArrayList = Visitor.viewVisitor();
          
          int postalCount = visitorArrayList.size();
          
          
             System.out.println(postalCount);
          
          ObservableList<Visitor> Visitors = FXCollections.observableArrayList();
          for(int i =0;i< postalCount;i++){
          Visitors.add(visitorArrayList.get(i));
      
          }
          idCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("nic"));
          nameCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
          intimeCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("inTime"));
          outTimeCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("outTime"));
          docCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("date"));
          noteCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("note"));
         // optionsCol.setCellValueFactory(new PropertyValueFactory<Visitor,String>("options"));
          
       
          visitorTable.setItems(Visitors);
          
             
         }catch(Exception e){}
       
    }    
    
        public void deleteVisitor(ActionEvent event){
             try{
        String name; 
        ObservableList<Visitor> allVisitors,singleVisitor;
        allVisitors = visitorTable.getItems();
        singleVisitor =visitorTable.getSelectionModel().getSelectedItems();
        visitorID = visitorTable.getSelectionModel().getSelectedItem().getNic(); // get user id in select row and set it static variable
        name=visitorTable.getSelectionModel().getSelectedItem().getName(); //get name in table set it name
        singleVisitor.forEach(allVisitors::remove); //delete select row
        Visitor appObj = new Visitor();            //create object in appointmen class
        appObj.deleteVisitor("user data\\database\\visitors.txt","user data\\database\\temp.txt" );
        Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("You deleted "+name.toUpperCase()+"'s visitor record..!");
        alert.show();
        }catch(Exception e){
        Alert alert = new Alert(Alert.AlertType.WARNING); //display Warning message
        alert.setContentText("Selecet Visitor and press delete button");
        alert.show();   
        }
        
        }
    
}
