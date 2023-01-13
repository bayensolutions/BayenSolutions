package com.bayensolutions.dao.mysql;

import com.bayensolutions.dao.MaterialDAO;
import com.bayensolutions.model.Material;
import com.bayensolutions.util.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAOImplementation implements MaterialDAO {

    @Override
    public double checkMaterialQuantity(int materialId, double requiredQuantity) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        String callStatementItem = "{call provjeraStanjaMaterijala(?,?,?)}";
        double result;

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatementItem);
            callableStatement.setInt(1, materialId);
            callableStatement.setDouble(2, requiredQuantity);
            callableStatement.registerOutParameter(3, Types.DECIMAL);

            callableStatement.executeUpdate();
            result = callableStatement.getDouble(3);
            System.out.println("Rezultat: " + result);
            return result;
            /*
            *Promjenljiva RESULT cuva razliku u kolicini materijala na stanju i potrebnoj kolicini za prodaju/izgradnju
            *npr. ako imamo 20.5 mreza na stanju, a potrebne su 4, ova metoda vraca 16.5
            */

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
        }
        return 0;
    }

    @Override
    public boolean createMaterial(String name, double materialQuantity, int measurementUnitId, int materialTypeId) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        String callStatementItem = "{call dodavanjeMaterijala(?,?,?,?,?)}";
        boolean result=false;

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement=connection.prepareCall(callStatementItem);
            callableStatement.setString(1,name);
            callableStatement.setDouble(2,materialQuantity);
            callableStatement.setInt(3,measurementUnitId);
            callableStatement.setInt(4,materialTypeId);
            callableStatement.executeUpdate();
            result=callableStatement.executeUpdate() == 1;
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMaterial(int materialId){
        boolean result = false;
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        String callStatementItem = "{call BrisanjeMaterijala(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatementItem);
            callableStatement.setInt(1, materialId);
            result = callableStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(connection);
            //DBUtil.close(callableStatement);
        }
        return result;
    }

    @Override
    public List<Material> getMaterialItems(String name) {
        List<Material> list = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;

        String callStatement = "{call pretragaMaterijala(?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setString(1, name);
            rs = callableStatement.executeQuery();

            while (rs.next())
                list.add(new Material(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),rs.getInt(5)));
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
    public boolean updateMaterial(Material material) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs;
        boolean result = false;
        String callStatement = "{call izmjenaMaterijala(?,?,?,?,?)}";

        try {
            connection = ConnectionPool.getInstance().checkOut();
            callableStatement = connection.prepareCall(callStatement);
            callableStatement.setInt(1, material.getId());
            callableStatement.setString(2,material.getName());
            callableStatement.setDouble(3,material.getQuantity());
            callableStatement.setInt(4,material.getIdMeasurementUnit());
            callableStatement.setInt(5,material.getIdMaterialType());
            rs = callableStatement.executeQuery();
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
