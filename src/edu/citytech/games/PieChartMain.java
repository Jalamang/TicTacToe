package edu.citytech.games;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PieChartMain extends Application {

    public static void main(String[] args) {
Application.launch(PieChartMain.class, args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("XCgames.fxml"));
        stage.setTitle("Tic Tac Toe");
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        URL url = this.getClass().getResource("games.css");
        if(url == null) {
        	System.out.println("Resource not found. Absording.");
        	System.exit(-1);
        }
        
        String css =url.toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.show();
    
        
    }

}