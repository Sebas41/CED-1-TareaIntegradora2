package com.example.ced1integradora2.control;

import com.example.ced1integradora2.Implementation;
import com.example.ced1integradora2.model.Position;
import com.example.ced1integradora2.model.State;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.example.ced1integradora2.model.Map;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    private ToggleGroup toggleButtonGroup;
    private java.util.Map<State, Position> states;
    private Implementation implementation;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label msg;
    private com.example.ced1integradora2.model.Map map;

    public GameController(){
        this.toggleButtonGroup = new ToggleGroup();
        this.states = new HashMap<>();


    }



    private void onGoButtonClicked(){

    }

    public void setImplementation(Implementation implementationEnum) {
        this.implementation = implementationEnum;
        map = new Map(implementation);
        anchorPane.getChildren().addAll(map.getRadioButtons().values());
        radioButtons = map.getRadioButtons();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        msg.setText("Selecciona un estado");
    }
}
