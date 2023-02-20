package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.PrefabricatedItemDAO;
import com.bayensolutions.model.Item;
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

    @Override
    public boolean deletePrefabricatedItem(PrefabricatedItem prefabricatedItem) {
        boolean result = false;
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        String callStatementItem = "{call brisanjeMontažnogArtikla(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatementItem);
            callableStatement.setInt(1, prefabricatedItem.getId());
            result = callableStatement.executeUpdate() == 1;
            if(result==true) {
                ItemDAOImplementation itemDAOImplementation=new ItemDAOImplementation();
                result=itemDAOImplementation.deleteItem(new Item(prefabricatedItem.getId(),prefabricatedItem.getName(),prefabricatedItem.getPrice(),prefabricatedItem.getDescription()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return result;
    }
}
