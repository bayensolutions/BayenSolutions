package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.PersonDAOImplementation;
import com.bayensolutions.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    @FXML
    private TabPane main;

    @FXML
    private TableView<Employee> tableView;

    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private TableColumn<Employee, String> name;

    @FXML
    private TableColumn<Employee, String> uniqueIdentifier;

    @FXML
    private TableColumn<Employee, String> place;

    @FXML
    private TableColumn<Employee, Double> salary;

    @FXML
    private TableColumn<Employee, String> surname;

    @FXML
    private TableColumn<Employee, String> telephone;

    @FXML
    private TableColumn<Employee, String> role;

    ObservableList<Employee> list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ID"));
        name.setCellValueFactory(new PropertyValueFactory<Employee, String>("Ime"));
        surname.setCellValueFactory(new PropertyValueFactory<Employee, String>("Prezime"));
        telephone.setCellValueFactory(new PropertyValueFactory<Employee, String>("Telefon"));
        place.setCellValueFactory(new PropertyValueFactory<Employee, String>("Mjesto"));
        salary.setCellValueFactory(new PropertyValueFactory<Employee, Double>("Plata"));
        uniqueIdentifier.setCellValueFactory(new PropertyValueFactory<Employee, String>("JMBG"));
        role.setCellValueFactory(new PropertyValueFactory<Employee, String>("Uloga"));

        tableView.setItems(list);
    }
}
