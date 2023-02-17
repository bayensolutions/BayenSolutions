package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.*;
import com.bayensolutions.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddItemController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private TableView<OrderItem> orderItemTableView;

    @FXML
    private TableColumn<OrderItem,String> itemName;

    @FXML
    private TableColumn<OrderItem,String> itemPrice;

    @FXML
    private TableColumn<OrderItem,Integer> itemQuantity;

    @FXML
    private Label totalPriceLabel=new Label();

    @FXML
    private Button addPoolButton;

    @FXML
    private Button finishButton;

    @FXML
    private TableView<Pool> poolTableView;

    @FXML
    private TableColumn<Pool,Integer> poolId;

    @FXML
    private TableColumn<Pool,String> poolName;

    @FXML
    private TableColumn<Pool,Double> poolDiameter;

    @FXML
    private TableColumn<Pool,Double> poolDepth;

    @FXML
    private TableColumn<Pool,Double> poolPrice;

    @FXML
    private Button addDeckButton;

    @FXML
    private TableView<Deck> deckTableView;

    @FXML
    private TableColumn<Deck,Integer> deckId;

    @FXML
    private TableColumn<Deck,String> deckName;

    @FXML
    private TableColumn<Deck,Double> deckDiameter;

    @FXML
    private TableColumn<Deck,Double> deckDepth;

    @FXML
    private TableColumn<Deck,Double> deckPrice;

    @FXML
    private TableColumn<Deck,String> deckMaterial;

    @FXML
    private TableColumn<Deck,Double> deckScope;

    @FXML
    private Button addRevetmentButton;

    @FXML
    private TableView<Revetment> revetmentTableView;

    @FXML
    private TableColumn<Revetment,Integer> revetmentId;

    @FXML
    private TableColumn<Revetment,String> revetmentName;

    @FXML
    private TableColumn<Revetment,Double> revetmentDiameter;

    @FXML
    private TableColumn<Revetment,Double> revetmentDepth;

    @FXML
    private TableColumn<Revetment,Double> revetmentPrice;

    @FXML
    private TableColumn<Revetment,String> revetmentMaterial;

    @FXML
    private Button addEquipmentButton;

    @FXML
    private TableView<Equipment> equipmentTableView;

    @FXML
    private TableColumn<Equipment,Integer> equipmentId;

    @FXML
    private TableColumn<Equipment,String> equipmentName;

    @FXML
    private TableColumn<Equipment,Integer> equipmentWarranty;

    @FXML
    private TableColumn<Equipment,String> equipmentType;

    @FXML
    private TableColumn<Equipment,String> equipmentProducer;

    @FXML
    private TableColumn<Equipment,Double> equipmentPrice;

    PoolDAOImplementation poolDAOImplementation;
    DeckDAOImplementation deckDAOImplementation;
    RevetmentDAOImplementation revetmentDAOImplementation;
    EquipmentDAOImplementation equipmentDAOImplementation;
    OrderItemDAOImplementation orderItemDAOImplementation;
    InsertQuantityController insertQuantityController;
    MainWindowController mainWindowController;

    static Order order;
    static Double totalPrice=0.0;

    public MainWindowController getMainWindowController() {
        return mainWindowController;
    }

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setTotalPrice(Double price){totalPrice=price;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainWindowController=new MainWindowController();
        insertQuantityController=new InsertQuantityController();
        orderItemDAOImplementation=new OrderItemDAOImplementation();
        equipmentDAOImplementation=new EquipmentDAOImplementation();
        revetmentDAOImplementation=new RevetmentDAOImplementation();
        deckDAOImplementation=new DeckDAOImplementation();
        poolDAOImplementation=new PoolDAOImplementation();

        initializePools();
        initializeDecks();
        initializeRevetments();
        initializeEquipment();
        initializeItems();
        initializeTotalPrice();
    }

    public void initializePools(){
        poolDAOImplementation=new PoolDAOImplementation();
        poolId.setCellValueFactory(new PropertyValueFactory<Pool,Integer>("id"));
        poolName.setCellValueFactory(new PropertyValueFactory<Pool,String>("name"));
        poolDiameter.setCellValueFactory(new PropertyValueFactory<Pool,Double>("diameter"));
        poolDepth.setCellValueFactory(new PropertyValueFactory<Pool,Double>("depth"));
        poolPrice.setCellValueFactory(new PropertyValueFactory<Pool,Double>("price"));
        searchPools();
    }

    public void initializeDecks(){
        deckDAOImplementation=new DeckDAOImplementation();
        deckId.setCellValueFactory(new PropertyValueFactory<Deck,Integer>("id"));
        deckName.setCellValueFactory(new PropertyValueFactory<Deck,String>("name"));
        deckDepth.setCellValueFactory(new PropertyValueFactory<Deck,Double>("poolDepth"));
        deckDiameter.setCellValueFactory(new PropertyValueFactory<Deck,Double>("poolDiameter"));
        deckPrice.setCellValueFactory(new PropertyValueFactory<Deck,Double>("price"));
        deckScope.setCellValueFactory(new PropertyValueFactory<Deck,Double>("scope"));
        deckMaterial.setCellValueFactory(new PropertyValueFactory<Deck,String>("typeOfMaterial"));
        searchDecks();
    }

    public void initializeRevetments(){
        revetmentDAOImplementation=new RevetmentDAOImplementation();
        revetmentId.setCellValueFactory(new PropertyValueFactory<Revetment,Integer>("id"));
        revetmentName.setCellValueFactory(new PropertyValueFactory<Revetment,String>("name"));
        revetmentDepth.setCellValueFactory(new PropertyValueFactory<Revetment,Double>("poolDepth"));
        revetmentDiameter.setCellValueFactory(new PropertyValueFactory<Revetment,Double>("poolDiameter"));
        revetmentPrice.setCellValueFactory(new PropertyValueFactory<Revetment,Double>("price"));
        revetmentMaterial.setCellValueFactory(new PropertyValueFactory<Revetment,String>("typeOfMaterial"));
        searchRevetments();
    }

    public void initializeEquipment(){
        equipmentDAOImplementation=new EquipmentDAOImplementation();
        equipmentId.setCellValueFactory(new PropertyValueFactory<Equipment,Integer>("id"));
        equipmentName.setCellValueFactory(new PropertyValueFactory<Equipment,String>("name"));
        equipmentPrice.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("price"));
        equipmentWarranty.setCellValueFactory(new PropertyValueFactory<Equipment,Integer>("warrantyDuration"));
        equipmentProducer.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getEquipmentProducer().getName()));
        equipmentType.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getEquipmentType().getName()));
        searchEquipment();
    }

    public void initializeItems(){
        orderItemDAOImplementation=new OrderItemDAOImplementation();
        itemName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getItem().getName()));
        itemPrice.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getItem().getPrice().toString()));
        itemQuantity.setCellValueFactory(new PropertyValueFactory<OrderItem,Integer>("quantity"));
        searchItems();
    }

    public void initializeTotalPrice(){
        totalPriceLabel.setText(totalPrice.toString());
    }

    public void searchPools(){
        List<Pool> list=poolDAOImplementation.getPools();
        poolTableView.getItems().clear();
        poolTableView.setItems(FXCollections.observableArrayList(list));
    }

    public void searchDecks(){
        List<Deck> list=deckDAOImplementation.getDecks();
        deckTableView.getItems().clear();
        deckTableView.setItems(FXCollections.observableArrayList(list));
    }

    public void searchRevetments(){
        List<Revetment> list=revetmentDAOImplementation.getRevetments();
        revetmentTableView.getItems().clear();
        revetmentTableView.setItems(FXCollections.observableArrayList(list));
    }

    public void searchEquipment(){
        List<Equipment> list=equipmentDAOImplementation.getEquipment();
        equipmentTableView.getItems().clear();
        equipmentTableView.setItems(FXCollections.observableArrayList(list));
    }

    public void searchItems(){
        List<OrderItem> list=orderItemDAOImplementation.getOrderItems(order);
        orderItemTableView.getItems().clear();
        orderItemTableView.setItems(FXCollections.observableArrayList(list));
    }

    public void showStage(MainWindowController mainWindowController) throws IOException {
        FXMLLoader loader = new FXMLLoader(AddItemController.class.getResource("/fxml/AddItems.fxml"));
        Scene scene = new Scene(loader.load(), 800, 700, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - dodavanje artikala");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((AddItemController) loader.getController()).addParameters(mainWindowController);
    }

    public void addParameters(MainWindowController mainWindowController){
        this.mainWindowController=mainWindowController;
    }

    @FXML
    private void addPool() throws IOException {
        ObservableList<Pool> selectedPool;
        selectedPool= poolTableView.getSelectionModel().getSelectedItems();
        Item item=new Item(selectedPool.get(0).getId(),selectedPool.get(0).getName(),selectedPool.get(0).getPrice(),selectedPool.get(0).getDescription());
        InsertQuantityController.setItem(item);
        if(InsertQuantityController.addItemToSelectedItems(item))
            insertQuantityController.showStage(this);
    }

    @FXML
    private void addDeck() throws IOException {
        ObservableList<Deck> selectedDeck;
        selectedDeck=deckTableView.getSelectionModel().getSelectedItems();
        Item item=new Item(selectedDeck.get(0).getId(),selectedDeck.get(0).getName(),selectedDeck.get(0).getPrice(),selectedDeck.get(0).getDescription());
        InsertQuantityController.setItem(item);
        if(InsertQuantityController.addItemToSelectedItems(item))
            insertQuantityController.showStage(this);
    }

    @FXML
    private void addRevetment() throws IOException {
        ObservableList<Revetment> selectedRevetment;
        selectedRevetment=revetmentTableView.getSelectionModel().getSelectedItems();
        Item item=new Item(selectedRevetment.get(0).getId(),selectedRevetment.get(0).getName(),selectedRevetment.get(0).getPrice(),selectedRevetment.get(0).getDescription());
        InsertQuantityController.setItem(item);
        if(InsertQuantityController.addItemToSelectedItems(item))
            insertQuantityController.showStage(this);
    }

    @FXML
    private void addEquipment() throws IOException {
        ObservableList<Equipment> selectedEquipment;
        selectedEquipment=equipmentTableView.getSelectionModel().getSelectedItems();
        Item item=new Item(selectedEquipment.get(0).getId(),selectedEquipment.get(0).getName(),selectedEquipment.get(0).getPrice(),selectedEquipment.get(0).getDescription());
        InsertQuantityController.setItem(item);
        if(InsertQuantityController.addItemToSelectedItems(item))
            insertQuantityController.showStage(this);
    }

    @FXML
    private void editSelectedItem() throws IOException {
        ObservableList<OrderItem> selectedItems;
        selectedItems=orderItemTableView.getSelectionModel().getSelectedItems();
        OrderItem selectedOrderItem=selectedItems.get(0);
        EditQuantityController editQuantityController=new EditQuantityController();
        editQuantityController.setItem(selectedOrderItem.getItem());
        editQuantityController.showStage(this,selectedOrderItem);
    }

    @FXML
    private void deleteSelectedItem(){
        ObservableList<OrderItem> selectedItems, allItems;
        selectedItems=orderItemTableView.getSelectionModel().getSelectedItems();
        allItems=orderItemTableView.getItems();

        if(orderItemDAOImplementation.deleteOrderItem(selectedItems.get(0).getOrder(),selectedItems.get(0).getItem())){
            totalPrice-=selectedItems.get(0).getQuantity()*selectedItems.get(0).getItem().getPrice();
            initializeTotalPrice();
            InsertQuantityController.removeItemFromSelectedItems(selectedItems.get(0).getItem());
            allItems.remove(selectedItems.get(0));
            searchItems();
        }
    }

    public void registerItem(Item item, Integer quantity){
        orderItemDAOImplementation.addOrderItem(order,item,quantity);
        searchItems();
        totalPrice+=quantity*item.getPrice();
        initializeTotalPrice();
    }

    public void changeItemQuantity(Item item, Integer newQuantity, Integer oldQuantity){
        orderItemDAOImplementation.changeOrderItemQuantity(order,item,newQuantity);
        searchItems();
        totalPrice+=(newQuantity-oldQuantity)*item.getPrice();
        initializeTotalPrice();
    }

    public void finish(){
        changeTotalPrice(order,totalPrice);
        InsertQuantityController insertQuantityController=new InsertQuantityController();
        insertQuantityController.resetValues();
        totalPrice=0.0;
        order=null;
        mainWindowController.searchCreatedOrders();
        borderPane.getScene().getWindow().hide();
    }

    public void changeTotalPrice(Order order, Double totalPrice){
        OrderDAOImplementation orderDAOImplementation=new OrderDAOImplementation();
        orderDAOImplementation.changeTotalPrice(order,totalPrice);
    }
}