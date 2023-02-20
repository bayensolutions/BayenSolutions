package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.EquipmentDAOImplementation;
import com.bayensolutions.dao.mysql.EquipmentProducerDAOImplementation;
import com.bayensolutions.dao.mysql.EquipmentTypeDAOImplementation;
import com.bayensolutions.model.Equipment;
import com.bayensolutions.model.EquipmentProducer;
import com.bayensolutions.model.EquipmentType;
import com.bayensolutions.model.Item;
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

public class EditEquipmentController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button editEquipmentButton;

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
    private int id;

    ObservableList<EquipmentType> equipmentTypes = FXCollections.observableArrayList(new EquipmentTypeDAOImplementation().getEquipmentTypes());
    ObservableList<EquipmentProducer> equipmentProducers = FXCollections.observableArrayList(new EquipmentProducerDAOImplementation().getEquipmentProducers());

    @FXML
    private void initialize() {
        equipmentType.setItems(equipmentTypes);
        equipmentProducer.setItems(equipmentProducers);
    }

    public void showStage(Equipment equipment, MainWindowController mainWindowController) throws IOException {
        FXMLLoader loader = new FXMLLoader(EditEquipmentController.class.getResource("/fxml/EditEquipment.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - izmjena artikla - oprema");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((EditEquipmentController) loader.getController()).addParameters(equipment,mainWindowController);
    }

    public void addParameters(Equipment equipment, MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
        id=equipment.getId();
        equipmentName.setText(equipment.getName());
        equipmentPrice.setText(Double.toString(equipment.getPrice()));
        equipmentDescription.setText(equipment.getDescription());
        equipmentWarrantyDuration.setText(Integer.toString(equipment.getWarrantyDuration()));
        equipmentType.setValue(equipment.getEquipmentType());
        equipmentProducer.setValue(equipment.getEquipmentProducer());
    }

    @FXML
    public void editEquipment() {
        String name = equipmentName.getText();
        Double price = Double.parseDouble(equipmentPrice.getText());
        String description = equipmentDescription.getText();
        EquipmentType type = equipmentType.getValue();
        EquipmentProducer producer = equipmentProducer.getValue();
        Integer warranty = Integer.parseInt(equipmentWarrantyDuration.getText());

        if (name.equals("") || price.equals("") || description.equals("") || type.equals("") || producer.equals("") || warranty.equals("")) {
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
            return;
        }
        EquipmentDAOImplementation equipmentDAOImplementation = new EquipmentDAOImplementation();
        Equipment equipment = new Equipment(id, name, price, description, warranty, producer, type);
        JavaFXUtil.showInfoAlert(equipmentDAOImplementation.updateEquipment(equipment), Util.INFO, Util.ADD_SUCCESS, Util.ADD_FAILURE);
        mainWindowController.searchEquipment();
        borderPane.getScene().getWindow().hide();
    }
}
