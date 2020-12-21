/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



/**
 *
 * @author Ashan Isuru
 */
public class main extends Application {
    
    
    
     private static final int COUNT_LIMIT = 10;
        @Override
       public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Sign_Up_as.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    
      @Override
        public void init() throws Exception {       
        
        
        for (int i = 1; i <= COUNT_LIMIT; i++) {
            double progress =(double) i/10;
                       
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
            Thread.sleep(1000);
        }
        
    }
    
    
    
    
    
  
       
        
    
    
    public static void main(String[] args) {
       LauncherImpl.launchApplication(main.class, MyPreloader.class, args);
    }
    
}
