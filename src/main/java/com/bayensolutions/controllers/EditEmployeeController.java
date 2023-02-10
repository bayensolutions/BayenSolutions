package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.EmployeeRoleDAOImplementation;
import com.bayensolutions.dao.mysql.PersonDAOImplementation;
import com.bayensolutions.dao.mysql.PlaceDAOImplementation;
import com.bayensolutions.model.Employee;
import com.bayensolutions.model.EmployeeRole;
import com.bayensolutions.model.Person;
import com.bayensolutions.model.Place;
import com.bayensolutions.util.JavaFXUtil;
import com.bayensolutions.util.Util;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EditEmployeeController {

    private int id;
    MainWindowController mainWindowController;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button addEmployeeButton;

    @FXML
    private TextField nameTF;

    @FXML
    private TextField passwordTF;

    @FXML
    private ChoiceBox<Place> placeCB;

    @FXML
    private ChoiceBox<EmployeeRole> roleCB;

    @FXML
    private TextField salaryTF;

    @FXML
    private TextField surnameTF;

    @FXML
    private TextField telephoneTF;

    @FXML
    private TextField uniqueIdentifierTF;

    @FXML
    private TextField usernameTF;

    private List<String> getCityName(List<Place> list){
        List<String> names=new LinkedList<>();

        for(Place place:list){
            names.add(place.getName());
        }
        return names;
    }

    ObservableList<Place> placeList= FXCollections.observableArrayList(new PlaceDAOImplementation().getPlaces());
    ObservableList<EmployeeRole> roleList=FXCollections.observableArrayList(new EmployeeRoleDAOImplementation().getEmloyeeRoles());

    @FXML
    private void initialize(){
        placeCB.setItems(placeList);
        roleCB.setItems(roleList);
    }

    @FXML
    void registerEmployee(ActionEvent event) {
        String name=nameTF.getText();
        String surname=surnameTF.getText();
        String telephone=telephoneTF.getText();
        Place place=placeCB.getValue();
        String username=usernameTF.getText();
        String password=passwordTF.getText();
        Double salary=Double.parseDouble(salaryTF.getText());
        String uniqueIdentifier=uniqueIdentifierTF.getText();
        EmployeeRole role=roleCB.getValue();

        if(name.equals("") || surname.equals("") || telephone.equals("") || place.equals("") || username.equals("") || password.equals("") || salary.equals("") || uniqueIdentifier.equals("") || role.equals("")){
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
            return;
        }

        boolean success=new PersonDAOImplementation().updateEmployee(new Employee(id,name,surname,telephone,new Place(place.getZipCode(),place.getName()),username,password,salary,new EmployeeRole(role.getId(),role.getRole()),uniqueIdentifier));
        JavaFXUtil.showInfoAlert(success,Util.INFO,Util.ADD_SUCCESS,Util.ADD_FAILURE);

        success=new PersonDAOImplementation().updatePerson(new Person(id,name,surname,telephone,new Place(place.getZipCode(),place.getName())));
        //JavaFXUtil.showInfoAlert(success,Util.INFO,Util.ADD_SUCCESS,Util.ADD_FAILURE);
        mainWindowController.searchEmployees();
        borderPane.getScene().getWindow().hide();
    }

    public void showStage(Employee employee, MainWindowController mainWindowController) throws IOException {

        FXMLLoader loader = new FXMLLoader(AddEmployeeController.class.getResource("/fxml/EditEmployee.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - izmjena zaposlenog");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((EditEmployeeController) loader.getController()).addParameters(employee,mainWindowController);
    }

    public void addParameters(Employee employee, MainWindowController mainWindowController){
        id=employee.getId();
        nameTF.setText(employee.getName());
        surnameTF.setText(employee.getSurname());
        telephoneTF.setText(employee.getTelephone());
        placeCB.setValue(employee.getPlace());
        usernameTF.setText(employee.getNickname());
        passwordTF.setText(employee.getPasswordHash());
        salaryTF.setText(employee.getSalary().toString());
        uniqueIdentifierTF.setText(employee.getUniqueIdentificationNumber());
        roleCB.setValue(employee.getEmployeeRole());
        this.mainWindowController=mainWindowController;
    }
}