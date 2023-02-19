package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.EquipmentProducerDAO;
import com.bayensolutions.model.EquipmentProducer;
import com.bayensolutions.model.EquipmentType;
import com.bayensolutions.util.ConnectionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentProducerDAOImplementation implements EquipmentProducerDAO {
    @Override
    public List<EquipmentProducer> getEquipmentProducers() {
        List<EquipmentProducer> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeSvihProizvođačaOpreme()}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new EquipmentProducer(rs.getInt(1),rs.getString(2)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return list;
    }
}
