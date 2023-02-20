package com.bayensolutions.controllers;

import com.bayensolutions.dao.mysql.PoolDAOImplementation;
import com.bayensolutions.model.Item;
import com.bayensolutions.model.Pool;
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

public class EditPoolController {
    MainWindowController mainWindowController;
    private int id;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button editPoolButton;

    @FXML
    private TextField poolName;

    @FXML
    private TextField poolPrice;

    @FXML
    private TextField poolDepth;

    @FXML
    private TextField poolDiameter;

    @FXML
    private TextField poolDescription;

    @FXML
    private void initialize(){}

    public void showStage(Pool pool, MainWindowController mainWindowController) throws IOException {
        FXMLLoader loader = new FXMLLoader(EditPoolController.class.getResource("/fxml/EditPool.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400, Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setTitle("Bayen solutions - izmjena artikla - bazen");
        String path = "resources/photos/icon.png";
        Image applicationIcon = new Image(new File(path).toURI().toString());
        stage.getIcons().add(applicationIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((EditPoolController) loader.getController()).addParameters(pool, mainWindowController);
    }

    public void addParameters(Pool pool, MainWindowController mainWindowController){
        this.mainWindowController=mainWindowController;
        id=pool.getId();
        poolName.setText(pool.getName());
        poolPrice.setText(pool.getPrice().toString());
        poolDescription.setText(pool.getDescription());
        poolDiameter.setText(Double.toString(pool.getPoolDiameter()));
        poolDepth.setText(Double.toString(pool.getPoolDepth()));
    }

    @FXML
    public void editPool(){
        String name=poolName.getText();
        Double price=Double.parseDouble(poolPrice.getText());
        Double diameter=Double.parseDouble(poolDiameter.getText());
        Double depth=Double.parseDouble(poolDepth.getText());
        String description=poolDescription.getText();
        if(name.equals("") || price.equals("") || diameter.equals("") || depth.equals("") || description.equals("")){
            JavaFXUtil.showAlert(Alert.AlertType.ERROR, Util.ERROR, Util.NO_PARAMS);
            return;
        }
        PoolDAOImplementation poolDAOImplementation=new PoolDAOImplementation();
        JavaFXUtil.showInfoAlert(poolDAOImplementation.updatePool(new Pool(id,name,price,description,diameter,depth)),Util.INFO,Util.ADD_SUCCESS,Util.ADD_FAILURE);
        mainWindowController.searchPools();
        borderPane.getScene().getWindow().hide();
    }
}
