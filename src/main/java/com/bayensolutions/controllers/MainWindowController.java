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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class MainWindowController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private TabPane main;

    @FXML
    private TableView<Employee> employeeTableView;

    @FXML
    private TableView<Person> clientTableView;

    @FXML
    private TableView<Order> createdOrdersTableView;

    @FXML
    private TableView<Order> ordersInMadeTableView;

    @FXML
    private TableView<Order> closedOrdersTableView;

    @FXML
    private TableView<Pool> poolTableView;

    @FXML
    private TableView<Deck> deckTableView;

    @FXML
    private TableView<Revetment> revetmentTableView;

    @FXML
    private TableView<Equipment> equipmentTableView;

    @FXML
    private TableColumn<Employee, Integer> employeeId;

    @FXML
    private TableColumn<Employee, String> employeeName;

    @FXML
    private TableColumn<Employee, String> employeeUniqueIdentifier;

    @FXML
    private TableColumn<Employee, String> employeePlace;

    @FXML
    private TableColumn<Employee, Double> employeeSalary;

    @FXML
    private TableColumn<Employee, String> employeeSurname;

    @FXML
    private TableColumn<Employee, String> employeeTelephone;

    @FXML
    private TableColumn<Employee, String> employeeRole;

    @FXML
    private TableColumn<Person, Integer> clientId;

    @FXML
    private TableColumn<Person, String> clientName;

    @FXML
    private TableColumn<Person, String> clientSurname;

    @FXML
    private TableColumn<Person, String> clientTelephone;

    @FXML
    private TableColumn<Person, String> clientPlace;

    @FXML
    private TableColumn<Order, Integer> createdOrderId;

    @FXML
    private TableColumn<Order, Integer> orderInMadeId;

    @FXML
    private TableColumn<Order, Integer> closedOrderId;

    @FXML
    private TableColumn<Order, LocalDateTime> createdOrderDate;

    @FXML
    private TableColumn<Order, LocalDateTime> orderInMadeDate;

    @FXML
    private TableColumn<Order, LocalDateTime> closedOrderDate;

    @FXML
    private TableColumn<Order, String> createdOrderClient;

    @FXML
    private TableColumn<Order, String> orderInMadeClient;

    @FXML
    private TableColumn<Order, String> closedOrderClient;

    @FXML
    private TableColumn<Order, String> createdOrderAddress;

    @FXML
    private TableColumn<Order, String> orderInMadeAddress;

    @FXML
    private TableColumn<Order, String> closedOrderAddress;

    @FXML
    private TableColumn<Order, String> createdOrderPlace;

    @FXML
    private TableColumn<Order, String> orderInMadePlace;

    @FXML
    private TableColumn<Order, String> closedOrderPlace;

    @FXML
    private TableColumn<Order, Double> createdOrderTotalPrice;

    @FXML
    private TableColumn<Order, Double> orderInMadeTotalPrice;

    @FXML
    private TableColumn<Order, Double> closedOrderTotalPrice;

    @FXML
    private TableColumn<Pool, Integer> poolId;

    @FXML
    private TableColumn<Pool, String> poolName;

    @FXML
    private TableColumn<Pool, Double> poolDiameter;

    @FXML
    private TableColumn<Pool, Double> poolDepth;

    @FXML
    private TableColumn<Pool, Double> poolPrice;

    @FXML
    private TableColumn<Pool, String> poolDescription;

    @FXML
    private TableColumn<Deck, Integer> deckId;

    @FXML
    private TableColumn<Deck, String> deckName;

    @FXML
    private TableColumn<Deck, Double> deckDiameter;

    @FXML
    private TableColumn<Deck, Double> deckDepth;

    @FXML
    private TableColumn<Deck, Double> deckPrice;

    @FXML
    private TableColumn<Deck, String> deckMaterial;

    @FXML
    private TableColumn<Deck, Double> deckScope;

    @FXML
    private TableColumn<Deck, String> deckDescription;

    @FXML
    private TableColumn<Revetment, Integer> revetmentId;

    @FXML
    private TableColumn<Revetment, String> revetmentName;

    @FXML
    private TableColumn<Revetment, Double> revetmentDiameter;

    @FXML
    private TableColumn<Revetment, Double> revetmentDepth;

    @FXML
    private TableColumn<Revetment, Double> revetmentPrice;

    @FXML
    private TableColumn<Revetment, String> revetmentMaterial;

    @FXML
    private TableColumn<Revetment, String> revetmentDescription;

    @FXML
    private TableColumn<Equipment, Integer> equipmentId;

    @FXML
    private TableColumn<Equipment, String> equipmentName;

    @FXML
    private TableColumn<Equipment, Integer> equipmentWarranty;

    @FXML
    private TableColumn<Equipment, String> equipmentType;

    @FXML
    private TableColumn<Equipment, String> equipmentProducer;

    @FXML
    private TableColumn<Equipment, Double> equipmentPrice;

    @FXML
    private TableColumn<Equipment, String> equipmentDescription;

    PersonDAOImplementation personDAOImplementation = new PersonDAOImplementation();
    OrderDAOImplementation orderDAOImplementation = new OrderDAOImplementation();
    PoolDAOImplementation poolDAOImplementation;
    DeckDAOImplementation deckDAOImplementation;
    RevetmentDAOImplementation revetmentDAOImplementation;
    EquipmentDAOImplementation equipmentDAOImplementation;

    ObservableList<Employee> employeeList = FXCollections.observableArrayList(personDAOImplementation.getEmployees());
    ObservableList<Person> clientList = FXCollections.observableArrayList(personDAOImplementation.getClients());


    public static void showStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainWindowController.class.getResource("/fxml/MainWindow.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen Solutions glavni prozor");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeEmployees();
        initializeClients();
        initializeCreatedOrders();
        initializeOrdersInMade();
        initializeClosedOrders();
        initializePools();
        initializeDecks();
        initializeRevetments();
        initializeEquipment();
    }

    public void initializeEmployees() {
        personDAOImplementation = new PersonDAOImplementation();
        employeeId.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        employeeName.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        employeeSurname.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
        employeeTelephone.setCellValueFactory(new PropertyValueFactory<Employee, String>("telephone"));
        employeePlace.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlace().getName()));
        employeeSalary.setCellValueFactory(new PropertyValueFactory<Employee, Double>("salary"));
        employeeUniqueIdentifier.setCellValueFactory(new PropertyValueFactory<Employee, String>("uniqueIdentificationNumber"));
        employeeRole.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployeeRole().getRole()));
        //tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        searchEmployees();
    }

    public void initializeClients() {
        personDAOImplementation = new PersonDAOImplementation();
        clientId.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        clientName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        clientSurname.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
        clientTelephone.setCellValueFactory(new PropertyValueFactory<Person, String>("telephone"));
        clientPlace.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlace().getName()));
        searchClients();
    }

    public void initializeCreatedOrders() {
        orderDAOImplementation = new OrderDAOImplementation();
        createdOrderId.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
        createdOrderDate.setCellValueFactory(new PropertyValueFactory<Order, LocalDateTime>("dateTime"));
        createdOrderClient.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPerson().getName() + " " + cellData.getValue().getPerson().getSurname()));
        createdOrderAddress.setCellValueFactory(new PropertyValueFactory<Order, String>("poolMountingAddress"));
        createdOrderPlace.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPerson().getPlace().getName()));
        createdOrderTotalPrice.setCellValueFactory(new PropertyValueFactory<Order, Double>("totalPrice"));
        searchCreatedOrders();
    }

    public void initializeOrdersInMade() {
        orderDAOImplementation = new OrderDAOImplementation();
        orderInMadeId.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
        orderInMadeDate.setCellValueFactory(new PropertyValueFactory<Order, LocalDateTime>("dateTime"));
        orderInMadeClient.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPerson().getName() + " " + cellData.getValue().getPerson().getSurname()));
        orderInMadeAddress.setCellValueFactory(new PropertyValueFactory<Order, String>("poolMountingAddress"));
        orderInMadePlace.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPerson().getPlace().getName()));
        orderInMadeTotalPrice.setCellValueFactory(new PropertyValueFactory<Order, Double>("totalPrice"));
        searchOrdersInMade();
    }

    public void initializeClosedOrders() {
        orderDAOImplementation = new OrderDAOImplementation();
        closedOrderId.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
        closedOrderDate.setCellValueFactory(new PropertyValueFactory<Order, LocalDateTime>("dateTime"));
        closedOrderClient.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPerson().getName() + " " + cellData.getValue().getPerson().getSurname()));
        closedOrderAddress.setCellValueFactory(new PropertyValueFactory<Order, String>("poolMountingAddress"));
        closedOrderPlace.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPerson().getPlace().getName()));
        closedOrderTotalPrice.setCellValueFactory(new PropertyValueFactory<Order, Double>("totalPrice"));
        searchClosedOrders();
    }

    public void initializePools() {
        poolDAOImplementation = new PoolDAOImplementation();
        poolId.setCellValueFactory(new PropertyValueFactory<Pool, Integer>("id"));
        poolName.setCellValueFactory(new PropertyValueFactory<Pool, String>("name"));
        poolDiameter.setCellValueFactory(new PropertyValueFactory<Pool, Double>("poolDiameter"));
        poolDepth.setCellValueFactory(new PropertyValueFactory<Pool, Double>("poolDepth"));
        poolPrice.setCellValueFactory(new PropertyValueFactory<Pool, Double>("price"));
        poolDescription.setCellValueFactory(new PropertyValueFactory<Pool, String>("description"));
        searchPools();
    }

    public void initializeDecks() {
        deckDAOImplementation = new DeckDAOImplementation();
        deckId.setCellValueFactory(new PropertyValueFactory<Deck, Integer>("id"));
        deckName.setCellValueFactory(new PropertyValueFactory<Deck, String>("name"));
        deckDepth.setCellValueFactory(new PropertyValueFactory<Deck, Double>("poolDepth"));
        deckDiameter.setCellValueFactory(new PropertyValueFactory<Deck, Double>("poolDiameter"));
        deckPrice.setCellValueFactory(new PropertyValueFactory<Deck, Double>("price"));
        deckScope.setCellValueFactory(new PropertyValueFactory<Deck, Double>("scope"));
        deckMaterial.setCellValueFactory(new PropertyValueFactory<Deck, String>("typeOfMaterial"));
        deckDescription.setCellValueFactory(new PropertyValueFactory<Deck, String>("description"));
        searchDecks();
    }

    public void initializeRevetments() {
        revetmentDAOImplementation = new RevetmentDAOImplementation();
        revetmentId.setCellValueFactory(new PropertyValueFactory<Revetment, Integer>("id"));
        revetmentName.setCellValueFactory(new PropertyValueFactory<Revetment, String>("name"));
        revetmentDepth.setCellValueFactory(new PropertyValueFactory<Revetment, Double>("poolDepth"));
        revetmentDiameter.setCellValueFactory(new PropertyValueFactory<Revetment, Double>("poolDiameter"));
        revetmentPrice.setCellValueFactory(new PropertyValueFactory<Revetment, Double>("price"));
        revetmentMaterial.setCellValueFactory(new PropertyValueFactory<Revetment, String>("typeOfMaterial"));
        revetmentDescription.setCellValueFactory(new PropertyValueFactory<Revetment, String>("description"));
        searchRevetments();
    }

    public void initializeEquipment() {
        equipmentDAOImplementation = new EquipmentDAOImplementation();
        equipmentId.setCellValueFactory(new PropertyValueFactory<Equipment, Integer>("id"));
        equipmentName.setCellValueFactory(new PropertyValueFactory<Equipment, String>("name"));
        equipmentPrice.setCellValueFactory(new PropertyValueFactory<Equipment, Double>("price"));
        equipmentWarranty.setCellValueFactory(new PropertyValueFactory<Equipment, Integer>("warrantyDuration"));
        equipmentProducer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEquipmentProducer().getName()));
        equipmentType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEquipmentType().getName()));
        equipmentDescription.setCellValueFactory(new PropertyValueFactory<Equipment, String>("description"));
        searchEquipment();
    }

    public void searchEmployees() {
        employeeTableView.getItems().clear();
        List<Employee> list = personDAOImplementation.getEmployees();
        try {
            employeeTableView.getItems().clear();
            employeeTableView.setItems(FXCollections.observableArrayList(list));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void searchClients() {
        clientTableView.getItems().clear();
        List<Person> list = personDAOImplementation.getClients();
        try {
            clientTableView.getItems().clear();
            clientTableView.setItems(FXCollections.observableArrayList(list));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void searchCreatedOrders() {
        List<Order> list = orderDAOImplementation.getOrders();
        List<Order> createdOrdersList = list.stream().filter(c -> c.getStatus() == 0).collect(Collectors.toList());
        createdOrdersTableView.getItems().clear();
        createdOrdersTableView.setItems(FXCollections.observableArrayList(createdOrdersList));
    }

    public void searchOrdersInMade() {
        List<Order> list = orderDAOImplementation.getOrders();
        List<Order> ordersInMadeList = list.stream().filter(c -> c.getStatus() == 1).collect(Collectors.toList());
        ordersInMadeTableView.getItems().clear();
        ordersInMadeTableView.setItems(FXCollections.observableArrayList(ordersInMadeList));
    }

    public void searchClosedOrders() {
        List<Order> list = orderDAOImplementation.getOrders();
        List<Order> closedOrdersList = list.stream().filter(c -> c.getStatus() == 2).collect(Collectors.toList());
        closedOrdersTableView.getItems().clear();
        closedOrdersTableView.setItems(FXCollections.observableArrayList(closedOrdersList));
    }

    public void searchPools() {
        List<Pool> list = poolDAOImplementation.getPools();
        poolTableView.getItems().clear();
        poolTableView.setItems(FXCollections.observableArrayList(list));
    }

    public void searchDecks() {
        List<Deck> list = deckDAOImplementation.getDecks();
        deckTableView.getItems().clear();
        deckTableView.setItems(FXCollections.observableArrayList(list));
    }

    public void searchRevetments() {
        List<Revetment> list = revetmentDAOImplementation.getRevetments();
        revetmentTableView.getItems().clear();
        revetmentTableView.setItems(FXCollections.observableArrayList(list));
    }

    public void searchEquipment() {
        List<Equipment> list = equipmentDAOImplementation.getEquipment();
        equipmentTableView.getItems().clear();
        equipmentTableView.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    private void addEmployee() throws IOException {
        AddEmployeeController addEmployeeController = new AddEmployeeController();
        addEmployeeController.showStage(this);
    }

    @FXML
    private void deleteEmployee() {
        ObservableList<Employee> allEmployees, selectedEmployees;
        allEmployees = employeeTableView.getItems();
        selectedEmployees = employeeTableView.getSelectionModel().getSelectedItems();
        PersonDAOImplementation personDAOImplementation = new PersonDAOImplementation();
        for (Employee employee : selectedEmployees) {
            allEmployees.remove(employee);
            personDAOImplementation.deleteEmployee(employee);
        }
    }

    @FXML
    private void editEmployee() throws IOException {
        ObservableList<Employee> selectedEmployee;
        selectedEmployee = employeeTableView.getSelectionModel().getSelectedItems();
        EditEmployeeController editEmployeeController = new EditEmployeeController();
        editEmployeeController.showStage(selectedEmployee.get(0), this);
    }

    @FXML
    private void addClient() throws IOException {
        AddClientController addClientController = new AddClientController();
        addClientController.showStage(this);
    }

    @FXML
    private void deleteClient() {
        ObservableList<Person> selectedClient, allClients;
        selectedClient = clientTableView.getSelectionModel().getSelectedItems();
        allClients = clientTableView.getItems();
        personDAOImplementation = new PersonDAOImplementation();
        for (Person person : selectedClient) {
            allClients.remove(person);
            personDAOImplementation.deletePerson(person);
        }
    }

    @FXML
    private void editClient() throws IOException {
        ObservableList<Person> selectedClient;
        selectedClient = clientTableView.getSelectionModel().getSelectedItems();
        EditClientController editClientController = new EditClientController();
        editClientController.showStage(selectedClient.get(0), this);
    }


    @FXML
    private void createOrder() throws IOException {
        CreateOrderController createOrderController = new CreateOrderController();
        createOrderController.showStage(this);
    }

    @FXML
    private void deleteCreatedOrder() {
        deleteOrder(createdOrdersTableView);
    }

    @FXML
    private void deleteOrderInMade() {
        deleteOrder(ordersInMadeTableView);
    }

    @FXML
    private void deleteClosedOrder() {
        deleteOrder(closedOrdersTableView);
    }

    public void deleteOrder(TableView<Order> tableView) {
        ObservableList<Order> selectedOrders, allOrders;
        selectedOrders = tableView.getSelectionModel().getSelectedItems();
        allOrders = tableView.getItems();
        for (Order order : selectedOrders) {
            allOrders.remove(order);
            orderDAOImplementation.deleteOrder(order);
        }
    }

    @FXML
    private void changeCreatedOrderStatus() {
        changeOrderStatus(createdOrdersTableView);
    }

    @FXML
    private void changeOrderInMadeStatus() {
        changeOrderStatus(ordersInMadeTableView);
    }

    public void changeOrderStatus(TableView<Order> tableView) {
        ObservableList<Order> selectedOrders;
        selectedOrders = tableView.getSelectionModel().getSelectedItems();
        orderDAOImplementation.changeOrderStatus(selectedOrders.get(0), selectedOrders.get(0).getStatus() + 1);
        searchCreatedOrders();
        searchOrdersInMade();
        searchClosedOrders();
    }

    @FXML
    private void editCreatedOrder() throws IOException {
        editOrder(createdOrdersTableView);
    }

    @FXML
    private void editOrderInMade() throws IOException {
        editOrder(ordersInMadeTableView);
    }

    public void editOrder(TableView<Order> tableView) throws IOException {
        ObservableList<Order> selectedOrders;
        selectedOrders = tableView.getSelectionModel().getSelectedItems();
        EditOrderController editOrderController = new EditOrderController();
        editOrderController.showStage(selectedOrders.get(0), this);
    }

    @FXML
    private void addPool() throws IOException {
        AddPoolController addPoolController = new AddPoolController();
        addPoolController.showStage(this);
    }

    @FXML
    private void editPool() throws IOException {
        ObservableList<Pool> selectedPools;
        selectedPools = poolTableView.getSelectionModel().getSelectedItems();
        EditPoolController editPoolController=new EditPoolController();
        editPoolController.showStage(selectedPools.get(0),this);
    }

    @FXML
    private void deletePool() {
        // TODO:
    }

    @FXML
    private void addDeck() throws IOException {
        AddDeckController addDeckController = new AddDeckController();
        addDeckController.showStage(this);
    }

    @FXML
    private void editDeck() throws IOException {
        ObservableList<Deck> selectedDecks;
        selectedDecks = deckTableView.getSelectionModel().getSelectedItems();
        EditDeckController editDeckController=new EditDeckController();
        editDeckController.showStage(selectedDecks.get(0),this);
    }

    @FXML
    private void deleteDeck() throws IOException {
        // TODO
    }

    @FXML
    private void addRevetment() throws IOException {
        AddRevetmentController addRevetmentController = new AddRevetmentController();
        addRevetmentController.showStage(this);
    }

    @FXML
    private void editRevetment() throws IOException {
        ObservableList<Revetment> selectedRevetments;
        selectedRevetments = revetmentTableView.getSelectionModel().getSelectedItems();
        EditRevetmentController editRevetmentController=new EditRevetmentController();
        editRevetmentController.showStage(selectedRevetments.get(0),this);
    }

    @FXML
    private void deleteRevetment() throws IOException {
        // TODO
    }

    @FXML
    private void addEquipment() throws IOException {
        AddEquipmentController addEquipmentController = new AddEquipmentController();
        addEquipmentController.showStage(this);
    }

    @FXML
    private void editEquipment() throws IOException {
        ObservableList<Equipment> selectedEquipment;
        selectedEquipment = equipmentTableView.getSelectionModel().getSelectedItems();
        EditEquipmentController editEquipmentController=new EditEquipmentController();
        editEquipmentController.showStage(selectedEquipment.get(0),this);
    }

    @FXML
    private void deleteEquipment() throws IOException {
        // TODO
    }
}