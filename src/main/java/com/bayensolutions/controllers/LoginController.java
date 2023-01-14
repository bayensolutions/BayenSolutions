package com.bayensolutions.controllers;

import com.bayensolutions.util.DBUtil;
import com.bayensolutions.util.JavaFXUtil;
import com.bayensolutions.util.Util;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class LoginController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button button;

    @FXML
    private TextField usernameTF;

    @FXML
    private PasswordField passwordPF;

    private static Integer userId;

    public static void showStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions LogIn");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void logIn() {
        boolean logIn;
        String username = usernameTF.getText();
        String password = passwordPF.getText();
        if (username.equals("") || password.equals("")) {
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
            return;
        }
        try {
            String result = DBUtil.logIn(username, password);
            logIn = Boolean.parseBoolean(result.split("#")[0]);
            userId = Integer.parseInt(result.split("#")[1]);
            if (logIn) {
                borderPane.getScene().getWindow().hide();
                MainWindowController mainWindowController = new MainWindowController();
                mainWindowController.showStage();
            } else {
                JavaFXUtil.showAlert(Alert.AlertType.ERROR, "Sign In", "Enter valid parameters");
                return;
            }
        } catch (Exception ex) {
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, ex.getMessage());
            ex.printStackTrace();
            return;
        }
    }
}
