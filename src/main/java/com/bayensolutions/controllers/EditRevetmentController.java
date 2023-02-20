package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.RevetmentDAOImplementation;
import com.bayensolutions.model.Item;
import com.bayensolutions.model.Revetment;
import com.bayensolutions.util.JavaFXUtil;
import com.bayensolutions.util.Util;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class EditRevetmentController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button editRevetmentButton;

    @FXML
    private TextField revetmentName;

    @FXML
    private TextField revetmentMaterial;

    @FXML
    private TextField revetmentPrice;

    @FXML
    private TextField revetmentDescription;

    @FXML
    private TextField revetmentDiameter;

    @FXML
    private TextField revetmentDepth;

    MainWindowController mainWindowController;
    private int id;

    @FXML
    public void initialize(){}

    public void showStage(Revetment revetment, MainWindowController mainWindowController) throws IOException {
        FXMLLoader loader = new FXMLLoader(EditRevetmentController.class.getResource("/fxml/EditRevetment.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - izmjena artikla - obloga");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((EditRevetmentController) loader.getController()).addParameters(revetment, mainWindowController);
    }

    public void addParameters(Revetment revetment, MainWindowController mainWindowController){
        this.mainWindowController=mainWindowController;
        id=revetment.getId();
        revetmentName.setText(revetment.getName());
        revetmentPrice.setText(Double.toString(revetment.getPrice()));
        revetmentDescription.setText(revetment.getDescription());
        revetmentDiameter.setText(Double.toString(revetment.getPoolDiameter()));
        revetmentDepth.setText(Double.toString(revetment.getPoolDepth()));
        revetmentMaterial.setText(revetment.getTypeOfMaterial());
    }

    @FXML
    public void editRevetment(){
        String name=revetmentName.getText();
        Double price=Double.parseDouble(revetmentPrice.getText());
        Double diameter=Double.parseDouble(revetmentDiameter.getText());
        Double depth=Double.parseDouble(revetmentDepth.getText());
        String material=revetmentMaterial.getText();
        String description=revetmentDescription.getText();

        if(name.equals("") || price.equals("") || diameter.equals("") || depth.equals("") || description.equals("") || material.equals("")){
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
            return;
        }
        RevetmentDAOImplementation revetmentDAOImplementation=new RevetmentDAOImplementation();
        Revetment revetment=new Revetment(id,name,price,description,diameter,depth,material);
        JavaFXUtil.showInfoAlert(revetmentDAOImplementation.updateRevetment(revetment),Util.INFO,Util.ADD_SUCCESS,Util.ADD_FAILURE);
        mainWindowController.searchRevetments();
        borderPane.getScene().getWindow().hide();
    }
}
