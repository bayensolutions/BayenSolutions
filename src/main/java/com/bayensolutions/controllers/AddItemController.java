package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.*;
import com.bayensolutions.model.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private MainWindowController mainWindowController;
    private static Order order;

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
        System.out.println(order.toString());
    }

    @FXML
    private BorderPane borderPane;

    @FXML
    private TableView<OrderItem> orderItemTableView;

    @FXML
    private TableColumn<OrderItem,String> itemName;

    @FXML
    private TableColumn<OrderItem,Double> itemPrice;

    @FXML
    private TableColumn<OrderItem, Integer> itemQuantity;

    @FXML
    private Button addPoolButton;

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

    PoolDAOImplementation poolDAOImplementation=new PoolDAOImplementation();
    DeckDAOImplementation deckDAOImplementation=new DeckDAOImplementation();
    RevetmentDAOImplementation revetmentDAOImplementation=new RevetmentDAOImplementation();
    EquipmentDAOImplementation equipmentDAOImplementation=new EquipmentDAOImplementation();
    OrderItemDAOImplementation orderItemDAOImplementation=new OrderItemDAOImplementation();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializePools();
        initializeDecks();
        initializeRevetments();
        initializeEquipment();
        initializeItems();
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
        //itemName.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getItem().getName()));
        //itemPrice.setCellValueFactory(cellData->new SimpleDoubleProperty(cellData.getValue().getItem().getPrice()).doubleValue());
        itemQuantity.setCellValueFactory(new PropertyValueFactory<OrderItem,Integer>("quantity"));
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
        Scene scene = new Scene(loader.load(), 800, 600, Color.TRANSPARENT);
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
        System.out.println("DODAJ BAZEN");
        ObservableList<Pool> selectedPool;
        selectedPool= poolTableView.getSelectionModel().getSelectedItems();
        InsertQuantityController insertQuantityController=new InsertQuantityController();
        insertQuantityController.initializeItemNameAndPrice(new Item(selectedPool.get(0).getId(),selectedPool.get(0).getName(),selectedPool.get(0).getPrice(),selectedPool.get(0).getDescription()));
        insertQuantityController.showStage(mainWindowController);
        //EditEmployeeController editEmployeeController=new EditEmployeeController();
        //editEmployeeController.showStage(selectedEmployee.get(0),this);
    }

    @FXML
    private void addDeck(){
        System.out.println("DODAJ PLATFORMU");
    }

    @FXML
    private void addRevetment(){
        System.out.println("DODAJ OBLOGU");
    }

    @FXML
    private void addEquipment(){
        System.out.println("DODAJ OPREMU");
    }

    public void registerItem(Item item, Integer quantity){
        System.out.println("Naziv artikla: "+item.getName());
        System.out.println("Cijena artikla: "+item.getPrice());
        System.out.println("Kolicina: "+quantity);
        orderItemDAOImplementation.addOrderItem(order,item,quantity);
        initializeItems();
        searchItems();
    }
}
