/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Visitor {
    
    private String name;
    private String nic;
    private String date;
    private String inTime;
    private String outTime;
    private String note;
    
    
    
//Getters
    public String getName(){
        return this.name;
    }

    public String getNic(){
        return this.nic;
    }
    public String getDate(){
        return this.date;
    }
    public String getInTime(){
        return this.inTime;
    }
    public String getOutTime(){
        return this.outTime;
    }
    public String getNote(){
        return this.note;
    }
    
    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setNic(String nic){
        this.nic = nic;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setInTime(String inTime){
        this.inTime = inTime;
    }
    public void setOutTime(String outTime){
        this.outTime = outTime;
    }
    public void setNote(String note){
        this.note = note;
    }
    
    
    
    
    
    public void addVisitor(ActionEvent event) throws FileNotFoundException{ 
        
        
        File file = new File ("user data\\visitors\\data\\"+getName()+".txt");
                PrintWriter print = new PrintWriter(new FileOutputStream(file,true)); 
                print.append(getName()+"\n"+getNic()+"\n"+getDate()+"\n"+getInTime()+"\n"+getOutTime()+"\n"+getNote()+"\n");
                print.close();
    }
    
    
    
    public void addFile(ActionEvent event) throws FileNotFoundException{
         FileChooser fileChooser = new FileChooser();
         Stage primaryStage = new Stage();
         
         
        fileChooser.setInitialDirectory(new File("C:\\Users\\"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("doc file","*.doc","*.docx"));
        
        
        File file = fileChooser.showOpenDialog(primaryStage);
       // File desination = fileChooser.showSaveDialog(primaryStage);
       File path=file.getAbsoluteFile();
        
        
         //saving file given path
          try {
                Files.copy(file.toPath(),Paths.get("user data\\visitors\\cv\\"+getName()+".doc"));
            } catch (Exception ioException) {
               ioException.printStackTrace();
            }
          
          //create new object file1
          File file1 = new File(String.valueOf(path));
       
        fileChooser.setInitialFileName(getName()+".doc");  
        //getting type of files 
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("doc file","*.doc","*.docx"));
        
         
    }
    
    
          
    
}
