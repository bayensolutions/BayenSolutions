package com.bayensolutions;

import com.bayensolutions.controllers.LoginController;
import com.bayensolutions.dao.mysql.ItemDAOImplementation;
import com.bayensolutions.dao.mysql.OrderDAOImplementation;
import com.bayensolutions.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        LoginController.showStage();
    }

    public static void main(String[] args) {
        launch();
    }
}