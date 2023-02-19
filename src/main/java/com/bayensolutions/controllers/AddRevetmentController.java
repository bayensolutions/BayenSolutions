package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.DeckDAOImplementation;
import com.bayensolutions.dao.mysql.RevetmentDAOImplementation;
import com.bayensolutions.model.Deck;
import com.bayensolutions.model.Item;
import com.bayensolutions.model.Revetment;
import com.bayensolutions.util.JavaFXUtil;
import com.bayensolutions.util.Util;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AddRevetmentController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button addRevetmentButton;

    @FXML
    private TextField revetmentName;

    @FXML
    private TextField revetmentMaterial;

    @FXML
    private TextField revetmentPrice;

    @FXML
    private TextField revetmentDescription;

    @FXML
    private TextField revetmentDiameter;

    @FXML
    private TextField revetmentDepth;

    MainWindowController mainWindowController;

    @FXML
    public void initialize(){}

    public void showStage(MainWindowController mainWindowController) throws IOException {
        FXMLLoader loader = new FXMLLoader(AddRevetmentController.class.getResource("/fxml/AddRevetment.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - dodavanje artikla - obloga");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((AddRevetmentController) loader.getController()).addParameters(mainWindowController);
    }

    public void addParameters(MainWindowController mainWindowController){
        this.mainWindowController=mainWindowController;
    }

    @FXML
    public void addRevetment(){
        String name=revetmentName.getText();
        Double price=Double.parseDouble(revetmentPrice.getText());
        Double diameter=Double.parseDouble(revetmentDiameter.getText());
        Double depth=Double.parseDouble(revetmentDepth.getText());
        String material=revetmentMaterial.getText();
        String description=revetmentDescription.getText();

        if(name.equals("") || price.equals("") || diameter.equals("") || depth.equals("") || description.equals("") || material.equals("")){
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
        }
        Item item=new Item(999,name,price,description);
        RevetmentDAOImplementation revetmentDAOImplementation=new RevetmentDAOImplementation();
        Revetment revetment=new Revetment(999,name,price,description,diameter,depth,material);
        JavaFXUtil.showInfoAlert(revetmentDAOImplementation.createRevetment(revetment),Util.INFO,Util.ADD_SUCCESS,Util.ADD_FAILURE);
        mainWindowController.searchRevetments();
        borderPane.getScene().getWindow().hide();
    }
}