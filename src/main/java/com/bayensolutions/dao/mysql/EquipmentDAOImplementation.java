package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.EquipmentDAO;
import com.bayensolutions.model.Deck;
import com.bayensolutions.model.Equipment;
import com.bayensolutions.model.EquipmentProducer;
import com.bayensolutions.model.EquipmentType;
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
}
