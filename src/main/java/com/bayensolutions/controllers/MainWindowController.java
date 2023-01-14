package com.bayensolutions.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;

public class MainWindowController {

    public static void showStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainWindowController.class.getResource("/fxml/MainWindow.fxml"));
        Scene scene = new Scene(loader.load(), 600, 600, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen Solutions glavni prozor");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}
