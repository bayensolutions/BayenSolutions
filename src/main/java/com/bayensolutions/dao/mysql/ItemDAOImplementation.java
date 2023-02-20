package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.ItemDAO;
import com.bayensolutions.model.Item;
import com.bayensolutions.util.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
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

    @Override
    public Item getItemById(Integer id){
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        ResultSet rs;
        List<Item> items=new ArrayList<>();
        String callStatement = "{call dohvatanjeArtikla(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, id);
            rs=callableStatement.executeQuery();
            while (rs.next())
                items.add(new Item(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
            return items.get(0);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return null;
    }

    @Override
    public boolean updateItem(Item item) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call izmjenaArtikla(?,?,?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, item.getId());
            callableStatement.setString(2,item.getName());
            callableStatement.setDouble(3,item.getPrice());
            callableStatement.setString(4, item.getDescription());
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


}
