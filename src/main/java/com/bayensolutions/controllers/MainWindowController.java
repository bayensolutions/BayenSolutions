package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.OrderDAOImplementation;
import com.bayensolutions.dao.mysql.PersonDAOImplementation;
import com.bayensolutions.model.Employee;
import com.bayensolutions.model.Order;
import com.bayensolutions.model.Person;
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

    PersonDAOImplementation personDAOImplementation=new PersonDAOImplementation();
    OrderDAOImplementation orderDAOImplementation=new OrderDAOImplementation();
    ObservableList<Employee> employeeList = FXCollections.observableArrayList(personDAOImplementation.getEmployees());
    ObservableList<Person> clientList = FXCollections.observableArrayList(personDAOImplementation.getClients());



    public static void showStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainWindowController.class.getResource("/fxml/MainWindow.fxml"));
        Scene scene = new Scene(loader.load(), 600, 600, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen Solutions glavni prozor");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeEmployees();
        initializeClients();
        initializeCreatedOrders();
        initializeOrdersInMade();
        initializeClosedOrders();
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
    private void deleteCreatedOrder(){
        deleteOrder(createdOrdersTableView);
    }

    @FXML
    private void deleteOrderInMade(){
        deleteOrder(ordersInMadeTableView);
    }

    @FXML
    private void deleteClosedOrder(){
        deleteOrder(closedOrdersTableView);
    }

    public void deleteOrder(TableView<Order> tableView){
        ObservableList<Order> selectedOrders,allOrders;
        selectedOrders=tableView.getSelectionModel().getSelectedItems();
        allOrders=tableView.getItems();
        for(Order order:selectedOrders){
            allOrders.remove(order);
            orderDAOImplementation.deleteOrder(order);
        }
    }

    @FXML
    private void changeCreatedOrderStatus(){
        changeOrderStatus(createdOrdersTableView);
    }

    @FXML
    private void changeOrderInMadeStatus(){
        changeOrderStatus(ordersInMadeTableView);
    }

    public void changeOrderStatus(TableView<Order> tableView){
        ObservableList<Order> selectedOrders;
        selectedOrders=tableView.getSelectionModel().getSelectedItems();
        orderDAOImplementation.changeOrderStatus(selectedOrders.get(0),selectedOrders.get(0).getStatus()+1);
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
        selectedOrders=tableView.getSelectionModel().getSelectedItems();
        EditOrderController editOrderController = new EditOrderController();
        editOrderController.showStage(selectedOrders.get(0),this);
    }
}