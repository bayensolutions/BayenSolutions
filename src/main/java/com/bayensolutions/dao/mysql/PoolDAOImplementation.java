package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.PoolDAO;
import com.bayensolutions.model.Person;
import com.bayensolutions.model.Place;
import com.bayensolutions.model.Pool;
import com.bayensolutions.util.ConnectionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoolDAOImplementation implements PoolDAO {
    public List<Pool> getPools(){
        List<Pool> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeSvihBazena()}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new Pool(rs.getInt(1),rs.getString(2),rs.getDouble(5),rs.getString(6),rs.getDouble(3),rs.getDouble(4)));
            //System.out.println(list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return list;
    }
}
