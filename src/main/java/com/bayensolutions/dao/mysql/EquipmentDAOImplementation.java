package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.EquipmentDAO;
import com.bayensolutions.model.*;
import com.bayensolutions.util.ConnectionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAOImplementation implements EquipmentDAO {
    @Override
    public List<Equipment> getEquipment() {
        List<Equipment> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeSveOpreme()}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new Equipment(rs.getInt(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getInt(1),new EquipmentProducer(rs.getInt(11),rs.getString(12)),new EquipmentType(rs.getInt(9),rs.getString(10))));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
        }
        return list;
    }

    @Override
    public boolean createEquipment(Equipment equipment) {
        ItemDAOImplementation itemDAOImplementation=new ItemDAOImplementation();
        int index=itemDAOImplementation.createItem(new Item(equipment.getId(), equipment.getName(), equipment.getPrice(), equipment.getDescription()));

        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        String callStatementItem = "{call kreiranjeOpreme(?,?,?,?)}";
        boolean result;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement=connection.prepareCall(callStatementItem);
            callableStatement.setInt(1,index);
            callableStatement.setInt(2,equipment.getEquipmentType().getId());
            callableStatement.setInt(3,equipment.getEquipmentProducer().getId());
            callableStatement.setInt(4,equipment.getWarrantyDuration());
            result=callableStatement.executeUpdate() == 1;
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEquipment(Equipment equipment) {
        ItemDAOImplementation itemDAOImplementation = new ItemDAOImplementation();
        boolean itemSuccess = itemDAOImplementation.updateItem(new Item(equipment.getId(), equipment.getName(), equipment.getPrice(), equipment.getDescription()));

        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call izmjenaOpreme(?,?,?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1,equipment.getId());
            callableStatement.setInt(2,equipment.getWarrantyDuration());
            callableStatement.setInt(3,equipment.getEquipmentType().getId());
            callableStatement.setInt(4,equipment.getEquipmentProducer().getId());

            result = callableStatement.executeUpdate() == 1;
            return (result && itemSuccess);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return false;
    }
}
