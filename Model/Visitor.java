/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Control.RecVisitorsWindowController.visitorID;
import Model.Patient;
import java.awt.Desktop.Action;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Visitor {
    
    private String name;
    private String nic;
    private String date;
    private String inTime;
    private String outTime;
    private String document;
    private String note;
    private String options;
    
    
    
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
    
    public String getDocument(){
        return this.document;
    
    }
    public String getNote(){
        return this.note;
    }
     public String getOptions(){
        return this.options;
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
     public void setDocument(String document){
        this.document = document;
    }
     
    public void setNote(String note){
        this.note = note;
    }
     public void setOptions(String options){
        this.options = options;
    }
    
 public void addVisitor(ActionEvent event) throws  IOException{ 
        
        try{ 
       // File file = new File ("user data\\visitors\\data\\"+getNic()+".txt");
        FileWriter fw1 = new FileWriter("user data\\visitors\\data\\"+getNic()+".txt");
        BufferedWriter bw1 = new BufferedWriter(fw1);
        PrintWriter pw1 = new PrintWriter(bw1);
        pw1.print(getNic()+","+getName()+","+getInTime()+","+getOutTime()+","+getDate()+","+getNote()+"\n");
        pw1.close();
            System.out.println("error 0");       
                
         //database\visitors.txt  file write in all of data
         FileWriter fw = new FileWriter("user data\\database\\visitors.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.print(getNic()+","+getName()+","+getInTime()+","+getOutTime()+","+getDate()+","+getNote()+"\n");
         pw.close();
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setContentText("Visitor  was added..!");  //display data saved message
         alert.show();
         
         }catch(Exception e){
            System.out.println("Error");
         }
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
                Files.copy(file.toPath(),Paths.get("user data\\visitors\\cv\\"+getNic()+".doc"));
            } catch (Exception ioException) {
               ioException.printStackTrace();
            }
          
          //create new object file1
          File file1 = new File(String.valueOf(path));
       
        fileChooser.setInitialFileName(getNic()+".doc");  
        //getting type of files 
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("doc file","*.doc","*.docx"));
        
         
    }
    
    
    @FXML
     public static ArrayList<Visitor> viewVisitor() throws IOException{
        
        ArrayList<Visitor> visitorArrayList = new ArrayList<>();
        
        
        File visFile = new File("user data//database//visitors.txt");
        FileReader fr = new FileReader(visFile);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
      
        
        while ((currentLine = br.readLine())!=null){
            String[] visData = currentLine.split(",");
            Visitor visitorLine = new Visitor();
            
            visitorLine.setNic(visData[0]);
            visitorLine.setName(visData[1]);
            visitorLine.setInTime(visData[2]);
            visitorLine.setOutTime(visData[3]);
            visitorLine.setDate(visData[4]);
            visitorLine.setNote(visData[5]);
            //visitorLine.setOptions(visData[6]);
            
            visitorArrayList.add(visitorLine);
     
        }
        
        fr.close();
        br.close();
        return visitorArrayList;
        
    }
    
     // delete visitor method
     private Scanner x;
     public void deleteVisitor(String filepath,String tempFile){
        File oldFile = new File(filepath);//create object in oldfile
        File newFile = new File (tempFile);//create object in newfile
        //idintyfiy each component
        String id = "" ; String name = ""; String inTime =""; String outTime =""; String date =""; String note=""; 
        try {
            FileWriter fw = new FileWriter(tempFile,true); 
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner (new File (filepath));  // scan file
            x.useDelimiter("[,\n]"); // set delimiter
            
            while(x.hasNext()){
                //assign value in variable in tempary
                id=x.next();
                name=x.next();
                inTime=x.next();
                outTime=x.next();
                date=x.next();
                note=x.next();
                
                if(id.equals(visitorID)){  //compare idnumber
                    System.out.println("delete"+name+"'s visitor"); // is it true display message
                    
                }else{
                    pw.print(id+","+name+","+inTime+","+outTime+","+date+","+note+"\n"); //else write other data in new file
                }
                
            }
            x.close();   //scanner close
            pw.flush();  //print writer flush
            pw.close();   //print writer close
            oldFile.delete();   // file deleted
            File dump = new File (filepath); 
            newFile.renameTo(dump);  // new file rename old file name
             File file = new File("user data\\visitors\\data\\"+ visitorID+".txt");  
             file.delete();
            
       } catch (Exception e) {
       }
          
    
}
}