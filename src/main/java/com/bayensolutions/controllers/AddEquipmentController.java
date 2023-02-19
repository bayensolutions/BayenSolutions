package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.*;
import com.bayensolutions.model.*;
import com.bayensolutions.util.JavaFXUtil;
import com.bayensolutions.util.Util;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AddEquipmentController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button addEquipmentButton;

    @FXML
    private TextField equipmentName;

    @FXML
    private TextField equipmentPrice;

    @FXML
    private TextField equipmentDescription;

    @FXML
    private TextField equipmentWarrantyDuration;

    @FXML
    private ComboBox<EquipmentType> equipmentType;

    @FXML
    private ComboBox<EquipmentProducer> equipmentProducer;

    MainWindowController mainWindowController;

    ObservableList<EquipmentType> equipmentTypes= FXCollections.observableArrayList(new EquipmentTypeDAOImplementation().getEquipmentTypes());
    ObservableList<EquipmentProducer> equipmentProducers=FXCollections.observableArrayList(new EquipmentProducerDAOImplementation().getEquipmentProducers());

    @FXML
    private void initialize(){
        equipmentType.setItems(equipmentTypes);
        equipmentProducer.setItems(equipmentProducers);
    }

    public void showStage(MainWindowController mainWindowController) throws IOException {
        FXMLLoader loader = new FXMLLoader(AddEquipmentController.class.getResource("/fxml/AddEquipment.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - dodavanje artikla - oprema");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((AddEquipmentController) loader.getController()).addParameters(mainWindowController);
    }

    public void addParameters(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    @FXML
    public void addEquipment() {
        String name = equipmentName.getText();
        Double price = Double.parseDouble(equipmentPrice.getText());
        String description = equipmentDescription.getText();
        EquipmentType type=equipmentType.getValue();
        EquipmentProducer producer=equipmentProducer.getValue();
        Integer warranty=Integer.parseInt(equipmentWarrantyDuration.getText());

        if (name.equals("") || price.equals("") || description.equals("") || type.equals("") || producer.equals("") || warranty.equals("")) {
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
        }
        Item item = new Item(999, name, price, description);
        EquipmentDAOImplementation equipmentDAOImplementation=new EquipmentDAOImplementation();
        Equipment equipment=new Equipment(999,name,price,description,warranty,producer,type);
        JavaFXUtil.showInfoAlert(equipmentDAOImplementation.createEquipment(equipment), Util.INFO, Util.ADD_SUCCESS, Util.ADD_FAILURE);
        mainWindowController.searchEquipment();
        borderPane.getScene().getWindow().hide();
    }
}
