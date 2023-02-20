package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.PoolDAO;
import com.bayensolutions.model.*;
import com.bayensolutions.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PoolDAOImplementation implements PoolDAO {
    @Override
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

    @Override
    public boolean createPool(Pool pool) {
        ItemDAOImplementation itemDAOImplementation=new ItemDAOImplementation();
        int index=itemDAOImplementation.createItem(new Item(pool.getId(), pool.getName(), pool.getPrice(), pool.getDescription()));
        PrefabricatedItemDAOImplementation prefabricatedItemDAOImplementation=new PrefabricatedItemDAOImplementation();
        prefabricatedItemDAOImplementation.createPrefabricatedItem(new PrefabricatedItem(index, pool.getName(), pool.getPrice(), pool.getDescription(), pool.getPoolDiameter(), pool.getPoolDepth()));

        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        String callStatementItem = "{call kreiranjeBazena(?)}";
        boolean result;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement=connection.prepareCall(callStatementItem);
            callableStatement.setInt(1,index);
            result=callableStatement.executeUpdate() == 1;
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePool(Pool pool) {
        ItemDAOImplementation itemDAOImplementation=new ItemDAOImplementation();
        PrefabricatedItemDAOImplementation prefabricatedItemDAOImplementation=new PrefabricatedItemDAOImplementation();
        return (itemDAOImplementation.updateItem(new Item(pool.getId(), pool.getName(), pool.getPrice(), pool.getDescription())) && prefabricatedItemDAOImplementation.updatePrefabricatedItem(new PrefabricatedItem(pool.getId(), pool.getName(), pool.getPrice(), pool.getDescription(), pool.getPoolDiameter(), pool.getPoolDepth())));
    }


}
