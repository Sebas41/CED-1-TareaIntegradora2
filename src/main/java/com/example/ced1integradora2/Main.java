package com.example.ced1integradora2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage){
        openWindow("main-view.fxml", 600, 402);
    }

    @FXML
    public void openWindow(String fxml, double v, double v1) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), v, v1);
            Stage stage = new Stage();
            stage.setTitle("¡La Odisea de Tom!");
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}