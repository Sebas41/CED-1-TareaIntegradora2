package com.example.ced1integradora2.control;

import com.example.ced1integradora2.Implementation;
import com.example.ced1integradora2.model.Position;
import com.example.ced1integradora2.model.State;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import com.example.ced1integradora2.model.GameMap;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class GameController implements Initializable {

    private ToggleGroup toggleButtonGroup;
    private Map<String, State> states;
    private Implementation implementation;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label msg;
    private GameMap gameMap;
    private Map<String, RadioButton> radioButtons;
    @FXML
    private Button goButton;
    @FXML
    private ImageView carImage;

    public GameController(){
        this.toggleButtonGroup = new ToggleGroup();
        radioButtons = new HashMap<>();
    }


    @FXML
    private void onGoButtonClicked() {
        for (RadioButton radioButton : radioButtons.values()) {
            if (radioButton.isSelected()) {
                State state = states.get(radioButton.getText());
                Position position = state.getPosition();
                carImage.setLayoutX(position.getX());
                carImage.setLayoutY(position.getY());
                msg.setText("Buen viaje a " + state.getName() + "!");
                return;
            }
        }
    }

    public void setImplementation(Implementation implementationEnum) {
        this.implementation = implementationEnum;
        gameMap = new GameMap(implementation);
        states = gameMap.getStates();
        carImage.setLayoutX(states.get("California").getPosition().getX());
        carImage.setLayoutY(states.get("California").getPosition().getY());
        anchorPane.getChildren().addAll(gameMap.getRadioButtons().values());
        radioButtons = gameMap.getRadioButtons();

        for (RadioButton radioButton : radioButtons.values()) {
            radioButton.setToggleGroup(toggleButtonGroup);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        msg.setText("Selecciona un estado");
    }
}
