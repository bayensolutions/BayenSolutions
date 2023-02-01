package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.PersonDAOImplementation;
import com.bayensolutions.model.Employee;
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
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable{

    @FXML
    private BorderPane borderPane;

    @FXML
    private TabPane main;

    @FXML
    private TableView<Employee> tableView;

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

    PersonDAOImplementation personDAO=new PersonDAOImplementation();

    ObservableList<Employee> list = FXCollections.observableArrayList(personDAO.getEmployees());

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
        personDAO = new PersonDAOImplementation();
        employeeId.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        employeeName.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        employeeSurname.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
        employeeTelephone.setCellValueFactory(new PropertyValueFactory<Employee, String>("telephone"));
        employeePlace.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlace().getName()));
        employeeSalary.setCellValueFactory(new PropertyValueFactory<Employee, Double>("salary"));
        employeeUniqueIdentifier.setCellValueFactory(new PropertyValueFactory<Employee, String>("uniqueIdentificationNumber"));
        employeeRole.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployeeRole().getRole()));
        //tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        search();
    }

    private void search() {
        List<Employee> list=personDAO.getEmployees();
        try {
            tableView.getItems().clear();
            tableView.setItems(FXCollections.observableArrayList(list));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void addEmployee() throws IOException {
        AddEmployeeController addEmployeeController =new AddEmployeeController();
        addEmployeeController.showStage();
    }

    @FXML
    private void deleteEmployee(){
        ObservableList<Employee> allEmployees,selectedEmployees;
        allEmployees=tableView.getItems();
        selectedEmployees=tableView.getSelectionModel().getSelectedItems();

        PersonDAOImplementation personDAOImplementation=new PersonDAOImplementation();

        for(Employee employee:selectedEmployees){
            allEmployees.remove(employee);
            personDAOImplementation.deleteEmployee(employee);
        }
    }

    @FXML
    private void editEmployee(){
        System.out.println("EDIT EMPLOYEE");
        ObservableList<Employee> selectedEmployee;
        selectedEmployee=tableView.getSelectionModel().getSelectedItems();

    }

}
