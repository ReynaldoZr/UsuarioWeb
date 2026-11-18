module com.example.servicioswebs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;


    opens com.example.servicioswebs to javafx.fxml;
    opens com.example.servicioswebs.controller to javafx.fxml;
    opens com.example.servicioswebs.model to javafx.base, com.fasterxml.jackson.databind;
    exports com.example.servicioswebs;
    exports com.example.servicioswebs.model;
    exports com.example.servicioswebs.service;
}
