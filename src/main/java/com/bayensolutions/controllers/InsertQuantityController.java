package com.bayensolutions.controllers;

import com.bayensolutions.model.Item;
import com.bayensolutions.util.JavaFXUtil;
import com.bayensolutions.util.Util;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InsertQuantityController implements Initializable {

    private static Item item;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Slider slider;

    @FXML
    private Label itemName;

    @FXML
    private Label itemPrice;

    @FXML
    private Label label;

    @FXML
    private Button addItemButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemName.setText(item.getName());
        itemPrice.setText(item.getPrice().toString()+" KM");
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                label.setText(Integer.toString((int)slider.getValue()));
            }
        });
    }

    public void initializeItemNameAndPrice(Item item){
        this.item=item;
    }

    public void showStage(MainWindowController mainWindowController) throws IOException {
        FXMLLoader loader = new FXMLLoader(InsertQuantityController.class.getResource("/fxml/InsertQuantity.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - dodavanje količine");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        //((AddItemController) loader.getController()).addParameters(mainWindowController);
    }
    @FXML
    public void addItem(){
        String quantityString=label.getText();
        if(quantityString.equals("")){
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
            return;
        }
        borderPane.getScene().getWindow().hide();
        AddItemController addItemController=new AddItemController();
        addItemController.registerItem(item,Integer.parseInt(quantityString));
    }
}
