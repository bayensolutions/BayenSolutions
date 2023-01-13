package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.ItemDAO;
import com.bayensolutions.model.Item;
import com.bayensolutions.model.Order;
import com.bayensolutions.model.OrderItem;
import com.bayensolutions.util.ConnectionPool;

import java.sql.*;
import java.util.List;

public class ItemDAOImplementation implements ItemDAO {

    @Override
    public int createItem(Item item) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        String callStatementItem = "{call kreiranjeArtikla(?,?,?,?)}";
        int result;

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement=connection.prepareCall(callStatementItem);
            callableStatement.setString(2,item.getName());
            callableStatement.setDouble(3,item.getPrice());
            callableStatement.setString(4,item.getDescription());
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.executeUpdate();
            result = callableStatement.getInt(1);
            System.out.println("Id: " + result);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean changeItemInformation(Item oldItem, Item newItem) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call promjenaArtikla(?,?,?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, oldItem.getId());
            callableStatement.setString(2,newItem.getName());
            callableStatement.setDouble(3,newItem.getPrice());
            callableStatement.setString(4, newItem.getDescription());
            result=callableStatement.executeUpdate() == 1;
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return false;
    }

    /*
    * Naredne dvije metode nisam implementirao jer sam skontao da imam problematičan atribut u modelu
    * */
    @Override
    public List<Item> getItems() {
        return null;
    }

    @Override
    public boolean deleteItem(Item item) {
        return false;
    }
}
