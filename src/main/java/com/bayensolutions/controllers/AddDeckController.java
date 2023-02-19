package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.DeckDAOImplementation;
import com.bayensolutions.model.Deck;
import com.bayensolutions.model.Item;
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

public class AddDeckController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button addDeckButton;

    @FXML
    private TextField deckName;

    @FXML
    private TextField deckScope;

    @FXML
    private TextField deckMaterial;

    @FXML
    private TextField deckPrice;

    @FXML
    private TextField deckDescription;

    @FXML
    private TextField deckDiameter;

    @FXML
    private TextField deckDepth;

    MainWindowController mainWindowController;

    @FXML
    public void initialize(){}

    public void showStage(MainWindowController mainWindowController) throws IOException {
        FXMLLoader loader = new FXMLLoader(AddDeckController.class.getResource("/fxml/AddDeck.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - dodavanje artikla - platforma");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((AddDeckController) loader.getController()).addParameters(mainWindowController);
    }

    public void addParameters(MainWindowController mainWindowController){
        this.mainWindowController=mainWindowController;
    }

    @FXML
    public void addDeck(){
        String name=deckName.getText();
        Double price=Double.parseDouble(deckPrice.getText());
        Double diameter=Double.parseDouble(deckDiameter.getText());
        Double depth=Double.parseDouble(deckDepth.getText());
        Double scope=Double.parseDouble(deckScope.getText());
        String material=deckMaterial.getText();
        String description=deckDescription.getText();

        if(name.equals("") || price.equals("") || diameter.equals("") || depth.equals("") || description.equals("") || scope.equals("") || material.equals("")){
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
        }
        Item item=new Item(999,name,price,description);
        DeckDAOImplementation deckDAOImplementation=new DeckDAOImplementation();
        Deck deck=new Deck(999,name,price,description,diameter,depth,scope,material);
        JavaFXUtil.showInfoAlert(deckDAOImplementation.createDeck(deck),Util.INFO,Util.ADD_SUCCESS,Util.ADD_FAILURE);
        mainWindowController.searchDecks();
        borderPane.getScene().getWindow().hide();
    }
}
