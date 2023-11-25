package com.example.ced1integradora2.control;

import com.example.ced1integradora2.Implementation;
import com.example.ced1integradora2.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView {

    @FXML
    private ComboBox<String> graphComboBox;
    @FXML
    private Button playButton;

    @FXML
    protected void onStartButtonClick() {
        String implementation = graphComboBox.getValue();
        if (implementation == null || implementation.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error por implementacion");
            alert.setHeaderText(null);
            alert.setContentText("Debes escoger una implementacion para el grafo!");
            alert.showAndWait();
            return;
        }

        Implementation implementationEnum = implementation.equals("Matriz de Adyacencia")?  Implementation.ADJACENCY_MATRIX :  Implementation.ADJACENCY_LIST;
        GameController gameController = obtainControllerWindow("game-view.fxml", "RUTA AMERICANA").getController();
        gameController.setImplementation(implementationEnum);
        Stage stage = (Stage) playButton.getScene().getWindow();
        stage.close();

    }

    public FXMLLoader obtainControllerWindow(String fxmlName, String stageTitle) {
        Parent rootNode;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlName));

        Stage newStage = new Stage();
        try {
            newStage.setTitle(stageTitle);
            rootNode = fxmlLoader.load();
            newStage.setScene(new Scene(rootNode));
            newStage.show();
            return fxmlLoader;
        } catch (IOException e) {
            return e.getMessage().equals("Location is not set.") ? null : fxmlLoader;
        }
    }
}