module com.example.bazeni {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.bayensolutions to javafx.fxml;
    exports com.bayensolutions;
    opens com.bayensolutions.controllers to javafx.fxml;
    exports com.bayensolutions.controllers;
}