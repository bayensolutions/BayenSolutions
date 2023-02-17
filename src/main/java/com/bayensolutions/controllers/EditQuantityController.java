package com.bayensolutions.controllers;

import com.bayensolutions.model.Item;
import com.bayensolutions.model.OrderItem;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EditQuantityController implements Initializable {
    private static Item item;

    public static Item getItem() {
        return item;
    }

    public static void setItem(Item item) {
        EditQuantityController.item = item;
    }

    public static boolean addItemToSelectedItems(Item item){
        for(Item selectedItem:selectedItems){
            if(selectedItem.getId()==item.getId()){
                JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.ITEM_ALREADY_ADDED);
                return false;
            }
        }
        selectedItems.add(item);
        return true;
    }

    public static void removeItemFromSelectedItems(Item item){
        for(int i=selectedItems.size()-1;i>=0;--i){
            if(selectedItems.get(i).getId()==item.getId()){
                selectedItems.remove(i);
            }
        }
    }

    private static List<Item> selectedItems=new ArrayList<>();

    private AddItemController addItemController;

    private Integer oldQuantity;

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
    private Button changeItemQuantityButton;

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

    public void showStage(AddItemController addItemController, OrderItem orderItem) throws IOException {
        FXMLLoader loader = new FXMLLoader(EditQuantityController.class.getResource("/fxml/EditQuantity.fxml"));
        Scene scene = new Scene(loader.load(), 440, 300, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - izmjena količine");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((EditQuantityController) loader.getController()).setAddItemController(addItemController,orderItem);
    }

    public void setAddItemController(AddItemController addItemController, OrderItem orderItem){
        label.setText(orderItem.getQuantity().toString());
        slider.setValue(orderItem.getQuantity());
        oldQuantity=orderItem.getQuantity();
        this.addItemController=addItemController;
    }

    @FXML
    public void changeItemQuantity(){
        String quantityString=label.getText();
        if(quantityString.equals("")){
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
            return;
        }
        addItemController.changeItemQuantity(item,Integer.parseInt(quantityString),oldQuantity);
        borderPane.getScene().getWindow().hide();
    }

    public void resetValues(){
        selectedItems.clear();
        item=null;
    }
}