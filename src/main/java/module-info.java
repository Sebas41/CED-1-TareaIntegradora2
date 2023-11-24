module com.example.ced1integradora2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.ced1integradora2 to javafx.fxml;
    exports com.example.ced1integradora2;
    exports com.example.ced1integradora2.tests;
    exports com.example.ced1integradora2.ui;
    opens com.example.ced1integradora2.ui to javafx.fxml;
}