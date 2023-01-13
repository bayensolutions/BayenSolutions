package com.bayensolutions;

import com.bayensolutions.dao.mysql.ItemDAOImplementation;
import com.bayensolutions.dao.mysql.OrderDAOImplementation;
import com.bayensolutions.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("BAYEN SOLUTIONS!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //MaterialDAOImplementation m=new MaterialDAOImplementation();
        //PurchaseOrderDAOImplementation po=new PurchaseOrderDAOImplementation();
        //PersonDAOImplementation p=new PersonDAOImplementation();
        OrderDAOImplementation o=new OrderDAOImplementation();
        ItemDAOImplementation i=new ItemDAOImplementation();

        //m.checkMaterialQuantity(1,7);
        //po.changeMaterialQuantity(6);
        //po.getPurchaseOrderItems(1);
        //p.getPersons();
        //Person person1=new Person(14,"Muamererere","Kavazović","061 213-016",new Place("71240","Hadžići"));
        //p.addPerson(person1);
        //p.deletePerson(person1);
        //p.updatePerson(person1);
        //Employee employee=new Employee(22,"Ilija","Grahovac","065 000-000",new Place("78000","Banja Luka"),"zmaj","zmaj",1000.00,new EmployeeRole(2,"Skladišni radnik"),"0000000000000");
        //p.addEmployee(employee);
        //p.deleteEmployee(employee);
        //p.getEmployees();
        //p.updateEmployee(employee);
        //Material material1=new Material(8,"Žabica 40x40",200.00,5,1);
        //m.createMaterial(material1.getId(),material1.getName(),material1.getQuantity(),material1.getIdMeasurementUnit(),material1.getIdMaterialType());
        //m.updateMaterial(material1);
        //m.getMaterialItems("1,25");

        Order order=new Order(1,2,null,100,0.00,"Turbe b.b.");
        Order anando=new Order(2,3,null,1000,0.00,null);
        Order brisanje=new Order(200,200,null,null,0.00,null);
        Item item =new Item(16,"BILO STA",696969.0,"APSOLUTNO NEBITNO");
        Item item1=new Item (69,"Set za čišćenje - osnovni paket", 50.00,"Uključuje teleskopski štap sa nastavkom za dvorišno crijevo i mrežicu za sakupljanje insekata.");
        //o.createOrder(order);
        //o.changeOrderStatus(order,2);
        //o.addOrderItemToOrder(item,order,2);
        //o.getOrderItems(order);
        //o.changeTotalPrice(order,o.calculateTotalPrice(order));
        //o.changeTotalPrice(anando, o.calculateTotalPrice(anando));
        //o.getOrders();
        //o.deleteOrder(brisanje);
        //i.createItem(item1);
        //i.changeItemInformation(item,new Item(16,"Hlor BelChlor Tabs 200",22.00,"Tablete hlora za doziranje bazena zapremine preko 25 m^3."));
        /*
        *
        *
        *
        *
        *
        * */

        //launch();
        System.out.println("GOTOVO");
    }
}