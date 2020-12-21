/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyPreloader extends Preloader {

    private Stage preloaderStage;
    private Scene scene;
    
    public MyPreloader() {
        
    }

    @Override
    public void init() throws Exception {               
                                         
    Parent root1 = FXMLLoader.load(getClass().getResource("/View/preloader.fxml"));               
    scene = new Scene(root1);                       
                
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
       this.preloaderStage = primaryStage;

        // Set preloader scene and show stage.
        preloaderStage.setScene(scene);  
        preloaderStage.initStyle(StageStyle.UNDECORATED);
        preloaderStage.show();
        
        
      
    }

    @Override
    public void handleApplicationNotification(Preloader.PreloaderNotification info) {
      
          if (info instanceof ProgressNotification) {
            PreloaderController.label.setText(((ProgressNotification) info).getProgress()*100 +"\n  "+ "%");
            
            PreloaderController.statProgressBar.setProgress(((ProgressNotification) info).getProgress());
        }

               
        
    }

    @Override
    public void handleStateChangeNotification(Preloader.StateChangeNotification info) {
      
        StateChangeNotification.Type type = info.getType();
        switch (type) {
            
            case BEFORE_START:
                
                
                preloaderStage.hide();
                break;
        }
        
        
    }
}

