package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.PrefabricatedItemDAO;
import com.bayensolutions.model.PrefabricatedItem;
import com.bayensolutions.util.ConnectionPool;

import java.sql.*;

public class PrefabricatedItemDAOImplementation implements PrefabricatedItemDAO {
    @Override
    public boolean createPrefabricatedItem(PrefabricatedItem prefabricatedItem) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        String callStatementItem = "{call kreiranjeMontažnogArtikla(?,?,?)}";
        boolean result;

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement=connection.prepareCall(callStatementItem);
            callableStatement.setInt(1,prefabricatedItem.getId());
            callableStatement.setDouble(2,prefabricatedItem.getPoolDiameter());
            callableStatement.setDouble(3,prefabricatedItem.getPoolDepth());
            result=callableStatement.executeUpdate() == 1;
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePrefabricatedItem(PrefabricatedItem prefabricatedItem) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call izmjenaMontažnogArtikla(?,?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, prefabricatedItem.getId());
            callableStatement.setDouble(2,prefabricatedItem.getPoolDiameter());
            callableStatement.setDouble(3,prefabricatedItem.getPoolDepth());
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
