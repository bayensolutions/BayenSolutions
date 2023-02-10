package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.OrderDAOImplementation;
import com.bayensolutions.dao.mysql.PersonDAOImplementation;
import com.bayensolutions.model.Order;
import com.bayensolutions.model.Person;
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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class CreateOrderController {
    MainWindowController mainWindowController;

    @FXML
    private BorderPane borderPane;

    @FXML
    private TextField addressTF;

    @FXML
    private ComboBox<Person> clientCB;

    @FXML
    private Button addItemsButton;

    ObservableList<Person> clients= FXCollections.observableArrayList(new PersonDAOImplementation().getClients());

    @FXML
    private void initialize(){
        clientCB.setItems(clients);
    }

    public void showStage(MainWindowController mainWindowController) throws IOException {
        FXMLLoader loader = new FXMLLoader(CreateOrderController.class.getResource("/fxml/CreateOrder.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - kreiranje narudžbe");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((CreateOrderController) loader.getController()).addParameters(mainWindowController);
    }

    public void addParameters(MainWindowController mainWindowController){
        this.mainWindowController=mainWindowController;
    }

    public void addItems() throws IOException {
        String address=addressTF.getText();
        Person client=clientCB.getValue();
        LocalDateTime currentDateTime=LocalDateTime.now();
        if(client.equals("")){
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
            return;
        }
        OrderDAOImplementation orderDAOImplementation=new OrderDAOImplementation();
        int index=orderDAOImplementation.createOrder(new Order(999,client, currentDateTime,0,0.00,address));
        boolean success=false;
        if(index>0) success=true;
        JavaFXUtil.showInfoAlert(success,Util.INFO,Util.ADD_SUCCESS,Util.ADD_FAILURE);
        mainWindowController.searchCreatedOrders();
        //borderPane.getScene().getWindow().hide();
        AddItemController addItemController=new AddItemController();
        addItemController.setOrder(new Order(index,client,currentDateTime,0,0.00,address));
        addItemController.showStage(mainWindowController);
    }
}
