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

public class EditDeckController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button editDeckButton;

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
    private int id;

    @FXML
    public void initialize(){}

    public void showStage(Deck deck, MainWindowController mainWindowController) throws IOException {
        FXMLLoader loader = new FXMLLoader(EditDeckController.class.getResource("/fxml/EditDeck.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - izmjena artikla - platforma");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((EditDeckController) loader.getController()).addParameters(deck,mainWindowController);
    }

    public void addParameters(Deck deck, MainWindowController mainWindowController){
        this.mainWindowController=mainWindowController;
        id=deck.getId();
        deckName.setText(deck.getName());
        deckPrice.setText(Double.toString(deck.getPrice()));
        deckDescription.setText(deck.getDescription());
        deckDiameter.setText(Double.toString(deck.getPoolDiameter()));
        deckDepth.setText(Double.toString(deck.getPoolDepth()));
        deckMaterial.setText(deck.getTypeOfMaterial());
        deckScope.setText(Double.toString(deck.getScope()));
    }

    @FXML
    public void editDeck(){
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
        DeckDAOImplementation deckDAOImplementation=new DeckDAOImplementation();
        Deck deck=new Deck(id,name,price,description,diameter,depth,scope,material);
        JavaFXUtil.showInfoAlert(deckDAOImplementation.updateDeck(deck),Util.INFO,Util.ADD_SUCCESS,Util.ADD_FAILURE);
        mainWindowController.searchDecks();
        borderPane.getScene().getWindow().hide();
    }
}
