package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.EquipmentTypeDAO;
import com.bayensolutions.model.EquipmentType;
import com.bayensolutions.model.Place;
import com.bayensolutions.util.ConnectionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentTypeDAOImplementation implements EquipmentTypeDAO {
    @Override
    public List<EquipmentType> getEquipmentTypes() {
        List<EquipmentType> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeSvihTipovaOpreme()}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new EquipmentType(rs.getInt(1),rs.getString(2)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return list;
    }
}
