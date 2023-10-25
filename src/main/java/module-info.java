module com.example.ced1integradora2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ced1integradora2 to javafx.fxml;
    exports com.example.ced1integradora2;
    exports com.example.ced1integradora2.ui;
    opens com.example.ced1integradora2.ui to javafx.fxml;
}