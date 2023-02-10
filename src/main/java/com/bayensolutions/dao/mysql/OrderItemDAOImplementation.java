package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.OrderItemDAO;
import com.bayensolutions.model.Item;
import com.bayensolutions.model.Order;
import com.bayensolutions.model.OrderItem;
import com.bayensolutions.model.Pool;
import com.bayensolutions.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAOImplementation implements OrderItemDAO {

    @Override
    public List<OrderItem> getOrderItems(Order order) {
        List<OrderItem> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeSvihStavkiNarudžbe(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1,order.getId());
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new OrderItem(order,new ItemDAOImplementation().getItemById(rs.getInt(1)),rs.getInt(2)));
            //System.out.println(list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return list;
    }

    @Override
    public boolean addOrderItem(Order order, Item item, Integer quantity) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        String callStatementItem = "{call dodavanjeArtiklaUNarudžbu(?,?,?)}";
        boolean result=false;

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement=connection.prepareCall(callStatementItem);
            callableStatement.setInt(1,order.getId());
            callableStatement.setInt(2,item.getId());
            callableStatement.setInt(3,quantity);

            result=callableStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
