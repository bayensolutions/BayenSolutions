package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.EmployeeRoleDAO;
import com.bayensolutions.model.EmployeeRole;
import com.bayensolutions.model.Place;
import com.bayensolutions.util.ConnectionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRoleDAOImplementation implements EmployeeRoleDAO {

    @Override
    public List<EmployeeRole> getEmloyeeRoles() {
        List<EmployeeRole> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call dohvatanjeSvihUlogaZaposlenih()}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new EmployeeRole(rs.getInt(1),rs.getString(2)));
            System.out.println(list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return list;
    }
}
