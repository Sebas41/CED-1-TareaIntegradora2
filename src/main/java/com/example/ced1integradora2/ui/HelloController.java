package com.example.ced1integradora2.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea textArea;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(textArea.getText());
    }
}