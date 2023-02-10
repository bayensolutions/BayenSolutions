package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.RevetmentDAO;
import com.bayensolutions.model.Deck;
import com.bayensolutions.model.Revetment;
import com.bayensolutions.util.ConnectionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RevetmentDAOImplementation implements RevetmentDAO {

    @Override
    public List<Revetment> getRevetments() {
        List<Revetment> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeSvihObloga()}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new Revetment(rs.getInt(1),rs.getString(2),rs.getDouble(5),rs.getString(6),rs.getDouble(3),rs.getDouble(4),rs.getString(7)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
        }
        return list;
    }
}
