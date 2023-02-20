package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.RevetmentDAO;
import com.bayensolutions.model.Deck;
import com.bayensolutions.model.Item;
import com.bayensolutions.model.PrefabricatedItem;
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

    @Override
    public boolean createRevetment(Revetment revetment) {
        ItemDAOImplementation itemDAOImplementation=new ItemDAOImplementation();
        int index=itemDAOImplementation.createItem(new Item(revetment.getId(), revetment.getName(), revetment.getPrice(), revetment.getDescription()));
        PrefabricatedItemDAOImplementation prefabricatedItemDAOImplementation=new PrefabricatedItemDAOImplementation();
        prefabricatedItemDAOImplementation.createPrefabricatedItem(new PrefabricatedItem(index, revetment.getName(), revetment.getPrice(), revetment.getDescription(), revetment.getPoolDiameter(), revetment.getPoolDepth()));


        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        String callStatementItem = "{call kreiranjeObloge(?,?)}";
        boolean result;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement=connection.prepareCall(callStatementItem);
            callableStatement.setInt(1,index);
            callableStatement.setString(2,revetment.getTypeOfMaterial());
            result=callableStatement.executeUpdate() == 1;
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRevetment(Revetment revetment) {
        ItemDAOImplementation itemDAOImplementation = new ItemDAOImplementation();
        PrefabricatedItemDAOImplementation prefabricatedItemDAOImplementation = new PrefabricatedItemDAOImplementation();
        boolean itemSuccess = itemDAOImplementation.updateItem(new Item(revetment.getId(), revetment.getName(), revetment.getPrice(), revetment.getDescription()));
        boolean prefabricatedItemSuccess = prefabricatedItemDAOImplementation.updatePrefabricatedItem(new PrefabricatedItem(revetment.getId(), revetment.getName(), revetment.getPrice(), revetment.getDescription(), revetment.getPoolDiameter(), revetment.getPoolDepth()));

        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = false;
        String callStatement = "{call izmjenaObloge(?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, revetment.getId());
            callableStatement.setString(2, revetment.getTypeOfMaterial());
            result = callableStatement.executeUpdate() == 1;
            return (result && itemSuccess && prefabricatedItemSuccess);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return false;
    }

    @Override
    public boolean deleteRevetment(Revetment revetment) {
        boolean result = false;
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        String callStatementItem = "{call brisanjeObloge(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatementItem);
            callableStatement.setInt(1, revetment.getId());
            result = callableStatement.executeUpdate() == 1;
            if(result==true) {
                PrefabricatedItemDAOImplementation prefabricatedItemDAOImplementation=new PrefabricatedItemDAOImplementation();
                result=prefabricatedItemDAOImplementation.deletePrefabricatedItem(new PrefabricatedItem(revetment.getId(), revetment.getName(), revetment.getPrice(), revetment.getDescription(), revetment.getPoolDiameter(), revetment.getPoolDepth()));
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