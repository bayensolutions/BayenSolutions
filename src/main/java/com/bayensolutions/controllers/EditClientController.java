package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.PersonDAOImplementation;
import com.bayensolutions.dao.mysql.PlaceDAOImplementation;
import com.bayensolutions.model.Person;
import com.bayensolutions.model.Place;
import com.bayensolutions.util.JavaFXUtil;
import com.bayensolutions.util.Util;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EditClientController {

    private int id;
    MainWindowController mainWindowController;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button addClientButton;

    @FXML
    private TextField nameTF;

    @FXML
    private ChoiceBox<Place> placeCB;

    @FXML
    private TextField surnameTF;

    @FXML
    private TextField telephoneTF;

    private List<String> getCityName(List<Place> list){
        List<String> names=new LinkedList<>();

        for(Place place:list){
            names.add(place.getName());
        }
        return names;
    }

    ObservableList<Place> placeList= FXCollections.observableArrayList(new PlaceDAOImplementation().getPlaces());

    @FXML
    private void initialize(){
        placeCB.setItems(placeList);
    }

    @FXML
    void registerClient(ActionEvent event) {
        String name=nameTF.getText();
        String surname=surnameTF.getText();
        String telephone=telephoneTF.getText();
        Place place=placeCB.getValue();

        if(name.equals("") || surname.equals("") || telephone.equals("") || place.equals("")){
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
            return;
        }

        boolean success=new PersonDAOImplementation().updatePerson(new Person(id,name,surname,telephone,new Place(place.getZipCode(),place.getName())));
        JavaFXUtil.showInfoAlert(success,Util.INFO,Util.ADD_SUCCESS,Util.ADD_FAILURE);

        success=new PersonDAOImplementation().updatePerson(new Person(id,name,surname,telephone,new Place(place.getZipCode(),place.getName())));
        //JavaFXUtil.showInfoAlert(success,Util.INFO,Util.ADD_SUCCESS,Util.ADD_FAILURE);
        mainWindowController.searchClients();
        borderPane.getScene().getWindow().hide();
    }

    public void showStage(Person client, MainWindowController mainWindowController) throws IOException {

        FXMLLoader loader = new FXMLLoader(AddClientController.class.getResource("/fxml/EditClient.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - izmjena klijenta");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((EditClientController) loader.getController()).addParameters(client,mainWindowController);
    }

    public void addParameters(Person client, MainWindowController mainWindowController){
        id=client.getId();
        nameTF.setText(client.getName());
        surnameTF.setText(client.getSurname());
        telephoneTF.setText(client.getTelephone());
        placeCB.setValue(client.getPlace());
        this.mainWindowController=mainWindowController;
    }
}