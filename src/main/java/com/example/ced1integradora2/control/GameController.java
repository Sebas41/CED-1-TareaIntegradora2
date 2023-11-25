package com.example.ced1integradora2.control;

import com.example.ced1integradora2.Implementation;
import com.example.ced1integradora2.model.Position;
import com.example.ced1integradora2.model.State;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import com.example.ced1integradora2.model.GameMap;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class GameController implements Initializable {

    private ToggleGroup toggleButtonGroup;
    private Map<State, Position> states;
    private Implementation implementation;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label msg;
    private GameMap gameMap;
    private Map<String, RadioButton> radioButtons;

    public GameController(){
        this.toggleButtonGroup = new ToggleGroup();
        this.states = new HashMap<>();
        radioButtons = new HashMap<>();
    }



    private void onGoButtonClicked(){

    }

    public void setImplementation(Implementation implementationEnum) {
        this.implementation = implementationEnum;
        gameMap = new GameMap(implementation);
        anchorPane.getChildren().addAll(gameMap.getRadioButtons().values());
        radioButtons = gameMap.getRadioButtons();

        for (RadioButton radioButton : radioButtons.values()) {
            radioButton.setToggleGroup(toggleButtonGroup);
        }

        toggleButtonGroup.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            if(toggleButtonGroup.getSelectedToggle() != null){
                msg.setText("Seleccionaste: " + toggleButtonGroup.getSelectedToggle().getUserData().toString());
            }
        });
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        msg.setText("Selecciona un estado");
    }
}
