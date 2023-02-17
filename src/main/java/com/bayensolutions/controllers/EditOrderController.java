package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.OrderDAOImplementation;
import com.bayensolutions.dao.mysql.OrderItemDAOImplementation;
import com.bayensolutions.dao.mysql.PersonDAOImplementation;
import com.bayensolutions.model.Order;
import com.bayensolutions.model.OrderItem;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EditOrderController {

    private int orderId;
    private int orderStatus;
    private Double orderTotalPrice;
    MainWindowController mainWindowController = new MainWindowController();

    @FXML
    private BorderPane borderPane;

    @FXML
    private TextField addressTF;

    @FXML
    private ComboBox<Person> clientCB;

    @FXML
    private Button editItemsButton;

    @FXML
    private Button finishButton;

    ObservableList<Person> clients = FXCollections.observableArrayList(new PersonDAOImplementation().getClients());
    OrderDAOImplementation orderDAOImplementation;
    OrderItemDAOImplementation orderItemDAOImplementation;

    @FXML
    private void initialize() {
        orderDAOImplementation=new OrderDAOImplementation();
        orderItemDAOImplementation=new OrderItemDAOImplementation();
        clientCB.setItems(clients);
    }

    public void showStage(Order order, MainWindowController mainWindowController) throws IOException {
        FXMLLoader loader = new FXMLLoader(EditOrderController.class.getResource("/fxml/EditOrder.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - izmjena narudžbe");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((EditOrderController) loader.getController()).addParameters(order,mainWindowController);
    }

    public void addParameters(Order order,MainWindowController mainWindowController) {
        orderId=order.getId();
        orderStatus=order.getStatus();
        orderTotalPrice=order.getTotalPrice();
        clientCB.setValue(order.getPerson());
        addressTF.setText(order.getPoolMountingAddress());
        this.mainWindowController = mainWindowController;
    }

    @FXML
    public void finish(){
        Order newOrder= getOrder();
        boolean success=orderDAOImplementation.editOrderInfo(newOrder);
        JavaFXUtil.showInfoAlert(success, Util.INFO, Util.EDIT_SUCCESS, Util.EDIT_FAILURE);
        mainWindowController.searchCreatedOrders();
        mainWindowController.searchOrdersInMade();
        mainWindowController.searchClosedOrders();
        borderPane.getScene().getWindow().hide();
    }

    public Order getOrder(){
        String address = addressTF.getText();
        Person client = clientCB.getValue();
        LocalDateTime currentDateTime = LocalDateTime.now();
        if (client.equals("")) {
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
            return null;
        }
        return new Order(orderId,client,currentDateTime,orderStatus,orderTotalPrice,address);
    }

    @FXML
    public void editItems() throws IOException {
        finish();
        mainWindowController.searchCreatedOrders();
        mainWindowController.searchOrdersInMade();
        mainWindowController.searchClosedOrders();
        borderPane.getScene().getWindow().hide();
        AddItemController addItemController = new AddItemController();
        addItemController.setOrder(getOrder());
        addItemController.setTotalPrice(getOrder().getTotalPrice());
        List<OrderItem> orderItems=new ArrayList<>();
        for(OrderItem orderItem:orderItemDAOImplementation.getOrderItems(getOrder())){
            InsertQuantityController.addItemToSelectedItems(orderItem.getItem());
        }
        System.out.println(getOrder().toString());
        addItemController.showStage(mainWindowController);
    }
}
