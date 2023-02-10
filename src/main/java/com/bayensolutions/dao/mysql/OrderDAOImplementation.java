package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.OrderDAO;
import com.bayensolutions.model.*;
import com.bayensolutions.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImplementation implements OrderDAO {

    @Override
    public int createOrder(Order order) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        String callStatementItem = "{call kreiranjeNarudžbe(?,?,?,?)}";
        int result;

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement=connection.prepareCall(callStatementItem);
            callableStatement.setDouble(2,order.getTotalPrice());
            callableStatement.setString(3,order.getPoolMountingAddress());
            callableStatement.setInt(4,order.getPerson().getId());
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.executeUpdate();
            result = callableStatement.getInt(1);
            System.out.println("Rezultat: " + result);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean changeOrderStatus(Order order, int status) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call promjenaStatusaNarudžbe(?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, order.getId());
            callableStatement.setInt(2, status);
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
    public boolean addOrderItemToOrder(Item item, Order order, int quantity) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call dodavanjeArtiklaUNarudžbu(?,?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1,order.getId());
            callableStatement.setInt(2, item.getId());
            callableStatement.setInt(3,quantity);
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
    public List<OrderItem> getOrderItems(Order order){
        List<OrderItem> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeArtikalaUNarudžbi(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, order.getId());
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new OrderItem(new Order(rs.getInt(1),new Person(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),new Place(rs.getString(6),rs.getString(7))),rs.getTimestamp(8).toLocalDateTime(),rs.getInt(16),rs.getDouble(9),rs.getString(10)),new Item(rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14)),rs.getInt(15)));
            System.out.println("---");
            System.out.println(list.toString());
            System.out.println("---");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return list;
    }

    @Override
    public double calculateTotalPrice(Order order){
        double sum=0;
        List<Integer> quantities=new ArrayList<Integer>();
        List<Double> prices=new ArrayList<Double>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeKoličineICijeneArtikala(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, order.getId());
            rs = callableStatement.executeQuery();
            while (rs.next()) {
                quantities.add(rs.getInt(2));
                prices.add(rs.getDouble(1));
            }
            for(int i=0;i<quantities.size();i++){
                sum+=quantities.get(i)*prices.get(i);
            }
            System.out.println("UKUPNA SUMA: "+sum);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return sum;
    }

    @Override
    public boolean changeTotalPrice(Order order, double price){
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;
        boolean result=false;
        String callStatement = "{call izračunavanjeUkupneCijene(?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, order.getId());
            callableStatement.setDouble(2,price);
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
    public List<Order> getOrders() {
        List<Order> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeSvihNarudžbi()}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new Order(rs.getInt(1),new Person(rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),new Place(rs.getString(10),rs.getString(11))),rs.getTimestamp(2).toLocalDateTime(),rs.getInt(3),rs.getDouble(4),rs.getString(5)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return list;
    }

    @Override
    public boolean deleteOrder(Order order) {
        boolean result = false;
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        String callStatementItem = "{call BrisanjeNarudžbe(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatementItem);
            callableStatement.setInt(1, order.getId());
            result = callableStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return result;
    }
}
