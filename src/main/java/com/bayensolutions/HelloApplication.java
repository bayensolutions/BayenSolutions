package com.bayensolutions;

import com.bayensolutions.controllers.LoginController;
import com.bayensolutions.dao.mysql.ItemDAOImplementation;
import com.bayensolutions.dao.mysql.OrderItemDAOImplementation;
import com.bayensolutions.model.Order;
import javafx.application.Application;
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